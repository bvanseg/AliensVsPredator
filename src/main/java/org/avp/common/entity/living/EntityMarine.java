package org.avp.common.entity.living;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import com.google.common.base.Optional;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import org.avp.client.AVPSounds;
import org.avp.common.item.init.AVPItems;
import org.avp.common.AVPNetworking;
import org.avp.common.entity.ai.brain.MarineBrain;
import org.avp.common.network.AvpDataSerializers;
import org.avp.common.network.packet.client.PacketSyncEntityInventory;
import org.avp.common.world.MarineTypes;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.common.FuncUtil;
import org.lib.common.InventoryHolder;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventoryNBTUtil;
import org.lib.common.inventory.InventorySnapshot;
import org.lib.common.predicate.Predicates;
import org.weapon.common.entity.EntityBullet;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityMarine extends EntityCreature implements IEntityAdditionalSpawnData, InventoryHolder, IMob, IRangedAttackMob, Brainiac<MarineBrain>
{

    private static final DataParameter<Boolean> AIMING = EntityDataManager.createKey(EntityMarine.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> SKIN_TONE = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> CAMO_COLOR = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> EYE_COLOR = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<String> NAME = EntityDataManager.createKey(EntityMarine.class, DataSerializers.STRING);
    private static final DataParameter<MarineDecorator.MarineRank> RANK = EntityDataManager.createKey(EntityMarine.class, AvpDataSerializers.MARINE_RANK);
    protected static final DataParameter<Optional<UUID>> SQUAD_LEADER_UNIQUE_ID = EntityDataManager.createKey(EntityMarine.class, DataSerializers.OPTIONAL_UNIQUE_ID);

    protected MarineBrain brain;

    protected int loadedAmmunition;

    private final InventoryBasic inventory;

    public EntityMarine(World world)
    {
        super(world);
        this.setSize(0.75F, 1.95F);
        this.experienceValue = 5;
        this.inventory = new InventoryBasic("Items", false, 9 * 3);
    }

    @Override
    public MarineBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new MarineBrain(this);
            this.brain.init();
        }
        return this.brain;
    }

    /**
     * Gets the marine's inventory.
     * Deprecated to discourage usage. Use getInventorySnapshot, instead.
     *
     * @return The marine's inventory.
     */
    @Override
    public InventoryBasic getInventory() {
        return this.inventory;
    }

    public InventorySnapshot getInventorySnapshot() {
        InventorySnapshot snapshot = new InventorySnapshot();
        snapshot.snapshot(this.inventory);
        return snapshot;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(AIMING, false);

        int weaponType = MarineDecorator.generateRandomWeaponType(this);
        this.getDataManager().register(TYPE, weaponType);

        this.getDataManager().register(SKIN_TONE, MarineDecorator.generateRandomSkinTone(this));
        this.getDataManager().register(CAMO_COLOR, -1);
        this.getDataManager().register(EYE_COLOR, MarineDecorator.generateRandomEyeColor(this));
        this.getDataManager().register(NAME, MarineDecorator.generateRandomMarineName(this));
        this.getDataManager().register(RANK, MarineDecorator.generateRandomMarineRank(this));
        this.getDataManager().register(SQUAD_LEADER_UNIQUE_ID, Optional.absent());
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        /* Initialize decorations */
        // Initialize camo color.
        this.getDataManager().set(CAMO_COLOR, MarineDecorator.generateCamoColorBasedOnCurrentBiome(this));

        /* Initialize inventory */
        // Set held weapon
        this.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(this.getMarineType().getFirearmItem()));
        // Set ammo count
        this.getMarineType()
                .getFirearmItem()
                .getFirearmProperties()
                .getConsumablesForReload()
                .forEach(consumable -> this.inventory.addItem(new ItemStack(consumable, this.getRNG().nextInt(5) + 3)));

        return super.onInitialSpawn(difficulty, livingdata);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6499999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return AVPSounds.MARINE_HURT.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AVPSounds.MARINE_DEATH.event();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote)
        {
            this.getBrain().update();

            EntityLivingBase target =
                    FuncUtil.let(
                            this.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET).orElse(this.getAttackTarget()),
                            t -> (EntityLivingBase) t
                    );
            this.getDataManager().set(AIMING, target != null && !target.isDead && target.getHealth() > 0);
        }
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            if (this.isSquadLeader(player)) {

                ItemStack heldItemStack = player.getHeldItem(hand);
                Item heldItem = heldItemStack.getItem();
                InventorySnapshot playerInventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

                // Allows the player to dye the marine's camo whatever color they'd like.
                if (heldItem == Items.DYE)
                {
                    int dyeColor = EnumDyeColor.byDyeDamage(player.getHeldItem(hand).getItemDamage()).getColorValue();
                    this.getDataManager().set(CAMO_COLOR, dyeColor << 8);

                    if (!Predicates.IS_IMMORTAL_PLAYER.test(player)) {
                        playerInventorySnapshot.consumeItem(Items.DYE);
                    }
                    return super.processInteract(player, hand);
                }
                // Allows the player to give marines food or ammo by right-clicking.
                else if (this.getBrain().itemPredicate.test(heldItem)) {
                    // Add item to marine's inventory.
                    this.inventory.addItem(new ItemStack(heldItem, 1));
                    // Remove item from player's inventory.
                    if (!Predicates.IS_IMMORTAL_PLAYER.test(player)) {
                        playerInventorySnapshot.consumeItem(heldItem);
                    }
                    // Synchronize marine's inventory.
                    AVPNetworking.instance.sendToAll(new PacketSyncEntityInventory(this, this.inventory));
                    return super.processInteract(player, hand);
                }
            }

            // If the marine does not have a squad leader already, the interacting player is now the squad leader.
            if (hand == EnumHand.MAIN_HAND) {
                this.tryChangeSquadLeader(player);
            }
        }

        return super.processInteract(player, hand);
    }

    private boolean isSquadLeader(EntityLivingBase entity) {
        return this.getSquadLeaderID().isPresent() && entity.getUniqueID().equals(this.getSquadLeaderID().get());
    }

    private void tryChangeSquadLeader(EntityPlayer player) {
        if (!this.getSquadLeaderID().isPresent()) {
            this.setSquadLeaderUniqueID(Optional.of(player.getUniqueID()));
            player.sendMessage(new TextComponentString(String.format("%s is now following you.", this.getMarineName())));
        } else {
            UUID squadLeaderID = this.getSquadLeaderID().get();
            if (player.getUniqueID().equals(squadLeaderID)) {
                this.setSquadLeaderUniqueID(Optional.absent());
                player.sendMessage(new TextComponentString(String.format("%s is no longer following you.",this.getMarineName())));
            } else {
                player.sendMessage(new TextComponentString(String.format("%s is already following another player!",this.getMarineName())));
            }
        }
    }

    @Override
    public void onDeath(DamageSource damageSource)
    {
        this.sendDeathMessageToSquadLeader();
        super.onDeath(damageSource);

        if (!this.world.isRemote) {
            Inventories.dropItemsInAt(this.inventory, this.world, this.getPosition());
        }
    }

    private void sendDeathMessageToSquadLeader() {
        if (!this.getSquadLeaderID().isPresent()) return;

        EntityPlayer squadLeader = this.world.getPlayerEntityByUUID(this.getSquadLeaderID().get());

        if (squadLeader == null) return;

        if (!this.world.isRemote && this.world.getGameRules().getBoolean("showDeathMessages") && squadLeader instanceof EntityPlayerMP)
        {
            squadLeader.sendMessage(this.getCombatTracker().getDeathMessage());
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null && !this.getAttackTarget().isDead  && this.getAttackTarget().getHealth() > 0)
        {
            EntityBullet entityBullet = new EntityBullet(this.world, this, targetEntity, 10F, this.getMarineType().getFirearmItem().getFirearmProperties().getDamageMultiplier());
            this.world.spawnEntity(entityBullet);
            SoundEvent sound = getMarineType().getGunfireSound();
            if (sound != null) {
                this.playSound(sound, 0.7F, 1F);
            }
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + this.getEyeHeight(), this.posZ, 1, 1, 1);
        }
    }

    public MarineTypes getMarineType()
    {
        Integer marineTypeInteger = this.getDataManager().get(TYPE);
        MarineTypes marineType = MarineTypes.getTypeForId(marineTypeInteger);
        return marineType != null ? marineType : MarineTypes.M41A;
    }

    @Override
    public String getName() {
        return this.getRank().getShorthandName() + " " + this.getMarineName();
    }

    // If this is set to true, the marine's death message will be once by default, and sent twice if they have a squad leader
    // (the second being sent onDeath).
    @Override
    public boolean hasCustomName() {
        return false;
    }

    // The marine should always render their name tag.
    @Override
    public boolean getAlwaysRenderNameTag() {
        return true;
    }

    public boolean isAiming()
    {
        return this.getDataManager().get(AIMING);
    }

    public int getSkinTone()
    {
        return this.dataManager.get(SKIN_TONE);
    }

    public int getEyeColor()
    {
        return this.dataManager.get(EYE_COLOR);
    }

    public int getCamoColor()
    {
        return this.dataManager.get(CAMO_COLOR);
    }

    public String getMarineName() {
        return this.dataManager.get(NAME);
    }

    public MarineDecorator.MarineRank getRank() {
        return this.dataManager.get(RANK);
    }

    public Optional<UUID> getSquadLeaderID() {
        return this.getDataManager().get(SQUAD_LEADER_UNIQUE_ID);
    }

    public int getLoadedAmmunition() {
        return this.loadedAmmunition;
    }

    public boolean hasLoadedAmmunition() {
        return this.getLoadedAmmunition() > 0;
    }

    public void setLoadedAmmunition(int loadedAmmunition) {
        this.loadedAmmunition = Math.max(0, loadedAmmunition);
    }

    public void setSquadLeaderUniqueID(Optional<UUID> squadLeaderUniqueId) {
        this.getDataManager().set(SQUAD_LEADER_UNIQUE_ID, squadLeaderUniqueId);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) { /* Do Nothing */ }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AVPItems.SUMMONER_MARINE);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    private static final String WEAPON_TYPE_NBT_KEY = "WeaponType";
    private static final String SKIN_TONE_NBT_KEY = "SkinTone";
    private static final String EYE_COLOR_NBT_KEY = "EyeColor";
    private static final String CAMO_COLOR_NBT_KEY = "CamoColor";
    private static final String NAME_NBT_KEY = "MarineName";
    private static final String RANK_NBT_KEY = "Rank";
    private static final String SQUAD_LEADER_NBT_KEY = "SquadLeader";
    private static final String INVENTORY_NBT_KEY = "Inventory";
    private static final String LOADED_AMMUNITION_NBT_KEY = "LoadedAmmo";

    @Override
    public void writeSpawnData(ByteBuf byteBuf) {
        NBTTagCompound tag = InventoryNBTUtil.writeInventoryToNBT(INVENTORY_NBT_KEY, this.getInventory());
        ByteBufUtils.writeTag(byteBuf, tag);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger(WEAPON_TYPE_NBT_KEY, this.dataManager.get(TYPE));
        nbt.setInteger(SKIN_TONE_NBT_KEY, this.getSkinTone());
        nbt.setInteger(EYE_COLOR_NBT_KEY, this.getEyeColor());
        nbt.setInteger(CAMO_COLOR_NBT_KEY, this.getCamoColor());
        nbt.setString(NAME_NBT_KEY, this.getMarineName());
        nbt.setInteger(RANK_NBT_KEY, this.getRank().ordinal());
        nbt.setInteger(LOADED_AMMUNITION_NBT_KEY, this.loadedAmmunition);

        if (this.getSquadLeaderID().isPresent()) {
            nbt.setUniqueId(SQUAD_LEADER_NBT_KEY, this.getSquadLeaderID().get());
        }

        NBTTagCompound inventoryTag = InventoryNBTUtil.writeInventoryToNBT(INVENTORY_NBT_KEY, this.inventory);
        nbt.setTag(INVENTORY_NBT_KEY, inventoryTag);
    }

    @Override
    public void readSpawnData(ByteBuf byteBuf) {
        NBTTagCompound tag = ByteBufUtils.readTag(byteBuf);
        InventoryNBTUtil.readInventoryFromNBT(INVENTORY_NBT_KEY, tag, this.inventory);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.dataManager.set(TYPE, nbt.getInteger(WEAPON_TYPE_NBT_KEY));
        this.dataManager.set(SKIN_TONE, nbt.getInteger(SKIN_TONE_NBT_KEY));
        this.dataManager.set(EYE_COLOR, nbt.getInteger(EYE_COLOR_NBT_KEY));
        this.dataManager.set(CAMO_COLOR, nbt.getInteger(CAMO_COLOR_NBT_KEY));
        this.dataManager.set(NAME, nbt.getString(NAME_NBT_KEY));
        this.dataManager.set(RANK, MarineDecorator.MarineRank.values()[nbt.getInteger(RANK_NBT_KEY)]);
        this.loadedAmmunition = nbt.getInteger(LOADED_AMMUNITION_NBT_KEY);

        UUID squadLeaderUUID = nbt.getUniqueId(SQUAD_LEADER_NBT_KEY);

        if (squadLeaderUUID.getLeastSignificantBits() != 0 && squadLeaderUUID.getMostSignificantBits() != 0) {
            this.setSquadLeaderUniqueID(Optional.of(squadLeaderUUID));
        }

        NBTTagCompound inventoryTag = nbt.getCompoundTag(INVENTORY_NBT_KEY);
        InventoryNBTUtil.readInventoryFromNBT(INVENTORY_NBT_KEY, inventoryTag, this.inventory);
    }
}
