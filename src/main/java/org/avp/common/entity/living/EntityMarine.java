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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import org.avp.client.AVPSounds;
import org.avp.common.AVPNetworking;
import org.avp.common.entity.MarineCreatureTypes;
import org.avp.common.entity.ai.brain.MarineBrain;
import org.avp.common.item.init.AVPItems;
import org.avp.common.network.AvpDataSerializers;
import org.avp.common.network.packet.client.PacketSyncEntityInventory;
import org.avp.common.world.MarineTypes;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.common.EntityAccessor;
import org.lib.common.FuncUtil;
import org.lib.common.InventoryHolder;
import org.lib.common.entity.BooleanDataHandle;
import org.lib.common.entity.DataHandle;
import org.lib.common.entity.EnumDataHandle;
import org.lib.common.entity.IntegerDataHandle;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventoryNBTUtil;
import org.lib.common.inventory.InventorySnapshot;
import org.lib.common.predicate.Predicates;
import org.weapon.common.entity.EntityBullet;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityMarine extends EntityCreature implements IEntityAdditionalSpawnData, InventoryHolder, IMob, IRangedAttackMob, Brainiac<MarineBrain>
{

    private static final DataParameter<Boolean> GUARDING = EntityDataManager.createKey(EntityMarine.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> AIMING = EntityDataManager.createKey(EntityMarine.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> SKIN_TONE = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> CAMO_COLOR = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> EYE_COLOR = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<String> NAME = EntityDataManager.createKey(EntityMarine.class, DataSerializers.STRING);
    private static final DataParameter<MarineDecorator.MarineRank> RANK = EntityDataManager.createKey(EntityMarine.class, AvpDataSerializers.MARINE_RANK);
    protected static final DataParameter<Optional<UUID>> SQUAD_LEADER_UNIQUE_ID = EntityDataManager.createKey(EntityMarine.class, DataSerializers.OPTIONAL_UNIQUE_ID);

    public final BooleanDataHandle isGuarding = new BooleanDataHandle(this, GUARDING);
    public final BooleanDataHandle isAiming = new BooleanDataHandle(this, AIMING);
    public final IntegerDataHandle type = new IntegerDataHandle(this, TYPE);
    public final IntegerDataHandle skinTone = new IntegerDataHandle(this, SKIN_TONE);
    public final IntegerDataHandle camoColor = new IntegerDataHandle(this, CAMO_COLOR);
    public final IntegerDataHandle eyeColor = new IntegerDataHandle(this, EYE_COLOR);
    public final DataHandle<String> name = new DataHandle<>(this, NAME);
    public final EnumDataHandle<MarineDecorator.MarineRank> rank = new EnumDataHandle<>(this, RANK);
    public final DataHandle<Optional<UUID>> squadLeaderId = new DataHandle<>(this, SQUAD_LEADER_UNIQUE_ID);

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
        this.getDataManager().register(GUARDING, false);
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

    @Override
    public boolean isCreatureType(EnumCreatureType type, boolean forSpawnCount) {
        // If not using custom creature type, fall back on default super behavior.
        if (MarineCreatureTypes.getMarineCreatureType() == EnumCreatureType.CREATURE)
            return super.isCreatureType(type, forSpawnCount);

        if (type == EnumCreatureType.CREATURE)
            return false;

        if (forSpawnCount && this.isNoDespawnRequired())
            return false;

        // Otherwise, override for the marine creature type. If we do not do this, the superclass will check against assignable
        // classes on the creature
        return type.getCreatureClass().isAssignableFrom(this.getClass());
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
                    this.changeMarineCamoColor(player, hand, playerInventorySnapshot);
                    return super.processInteract(player, hand);
                }
                // Allows the player to give marines food or ammo by right-clicking.
                else if (this.getBrain().itemPredicate.test(heldItem))
                {
                    this.acceptItemFromPlayer(player, heldItem, playerInventorySnapshot);
                    return super.processInteract(player, hand);
                }
                else if (player.isSneaking() && hand == EnumHand.MAIN_HAND)
                {
                    this.toggleGuardMode(player);
                    return super.processInteract(player, hand);
                }
            }

            // If the marine does not have a squad leader already, the interacting player is now the squad leader.
            if (!this.isGuarding.get() && hand == EnumHand.MAIN_HAND) {
                this.tryChangeSquadLeader(player);
            }
        }

        return super.processInteract(player, hand);
    }

    private void toggleGuardMode(EntityPlayer player) {
        boolean invertedFlag = !this.isGuarding.get();

        TextComponentString textString;

        if (invertedFlag) {
            textString = new TextComponentString(String.format("%s is now standing guard.", this.name.get()));
            textString.getStyle().setColor(TextFormatting.BLUE);
        } else {
            textString = new TextComponentString(String.format("%s is now following you.", this.name.get()));
            textString.getStyle().setColor(TextFormatting.GREEN);
        }

        player.sendMessage(textString);
        this.isGuarding.set(invertedFlag);
    }

    private void acceptItemFromPlayer(EntityPlayer player, Item heldItem, InventorySnapshot playerInventorySnapshot) {
        // Add item to marine's inventory.
        this.inventory.addItem(new ItemStack(heldItem, 1));
        // Remove item from player's inventory.
        if (!Predicates.IS_IMMORTAL_PLAYER.test(player)) {
            playerInventorySnapshot.consumeItem(heldItem);
        }
        // Synchronize marine's inventory.
        AVPNetworking.instance.sendToAll(new PacketSyncEntityInventory(this, this.inventory));
    }

    private void changeMarineCamoColor(EntityPlayer player, EnumHand hand, InventorySnapshot playerInventorySnapshot) {
        float[] dyeColorValues = EnumDyeColor.byDyeDamage(player.getHeldItem(hand).getItemDamage()).getColorComponentValues();
        int r = (int) (dyeColorValues[0] * 255);
        int g = (int) (dyeColorValues[1] * 255);
        int b = (int) (dyeColorValues[2] * 255);
        this.getDataManager().set(CAMO_COLOR, (r << 24) | (g << 16) | (b << 8));

        if (!Predicates.IS_IMMORTAL_PLAYER.test(player)) {
            playerInventorySnapshot.consumeItem(Items.DYE);
        }
    }

    private boolean isSquadLeader(EntityLivingBase entity) {
        return this.squadLeaderId.get().isPresent() && entity.getUniqueID().equals(this.squadLeaderId.get().get());
    }

    private void tryChangeSquadLeader(EntityPlayer player) {
        TextComponentString textString;

        InventorySnapshot snapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

        if (!this.squadLeaderId.get().isPresent()) {
            // Having a marine follow requires 1 diamond.
            if (player.getHeldItemMainhand().getItem() == Items.DIAMOND) {
                this.squadLeaderId.set(Optional.of(player.getUniqueID()));

                if (!player.isCreative()) {
                    snapshot.consumeItem(Items.DIAMOND);
                }

                textString = new TextComponentString(String.format("%s is now following you (-1 Diamond).", this.name.get()));
                textString.getStyle().setColor(TextFormatting.GREEN);
            } else {
                textString = new TextComponentString("You can't afford this marine (1 Diamond required in hand)!");
                textString.getStyle().setColor(TextFormatting.RED);
            }
        } else {
            UUID squadLeaderID = this.squadLeaderId.get().get();
            if (player.getUniqueID().equals(squadLeaderID)) {
                // Releasing a marine requires a gold ingot.
                if (player.getHeldItemMainhand().getItem() == Items.GOLD_INGOT) {
                    this.squadLeaderId.set(Optional.absent());

                    if (!player.isCreative()) {
                        snapshot.consumeItem(Items.GOLD_INGOT);
                    }

                    textString = new TextComponentString(String.format("%s is no longer following you (-1 Gold Ingot).",this.name.get()));
                    textString.getStyle().setColor(TextFormatting.YELLOW);
                } else {
                    textString = new TextComponentString("You can't afford to release this marine (1 Gold Ingot required in hand)!");
                    textString.getStyle().setColor(TextFormatting.RED);
                }
            } else {
                textString = new TextComponentString(String.format("%s is already following another player!",this.name.get()));
                textString.getStyle().setColor(TextFormatting.RED);
            }
        }

        player.sendMessage(textString);
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
        if (!this.squadLeaderId.get().isPresent()) return;

        EntityPlayer squadLeader = this.world.getPlayerEntityByUUID(this.squadLeaderId.get().get());

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
                this.playSound(sound, 1.75F, 1F);
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
        return this.rank.get().getShorthandName() + " " + this.name.get();
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

    public Optional<EntityLivingBase> getSquadLeader() {
        if (!this.squadLeaderId.get().isPresent()) return Optional.absent();
        Optional<Entity> leader = Optional.fromJavaUtil(EntityAccessor.instance.getEntityByUUID(this.squadLeaderId.get().get()));
        if (!leader.isPresent() || !(leader.get() instanceof EntityLivingBase)) return Optional.absent();
        return Optional.fromNullable((EntityLivingBase) leader.get());
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

    @Override
    public void setSwingingArms(boolean swingingArms) { /* Do Nothing */ }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AVPItems.SUMMONER_MARINE);
    }

    @Override
    protected boolean canDespawn() {
        return !this.squadLeaderId.get().isPresent();
    }

    private static final String GUARDING_NBT_KEY = "Guarding";
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
        nbt.setBoolean(GUARDING_NBT_KEY, this.isGuarding.get());
        nbt.setInteger(WEAPON_TYPE_NBT_KEY, this.type.get());
        nbt.setInteger(SKIN_TONE_NBT_KEY, this.skinTone.get());
        nbt.setInteger(EYE_COLOR_NBT_KEY, this.eyeColor.get());
        nbt.setInteger(CAMO_COLOR_NBT_KEY, this.camoColor.get());
        nbt.setString(NAME_NBT_KEY, this.name.get());
        nbt.setInteger(RANK_NBT_KEY, this.rank.get().ordinal());
        nbt.setInteger(LOADED_AMMUNITION_NBT_KEY, this.loadedAmmunition);

        if (this.squadLeaderId.get().isPresent()) {
            nbt.setUniqueId(SQUAD_LEADER_NBT_KEY, this.squadLeaderId.get().get());
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
        this.isGuarding.set(nbt.getBoolean(GUARDING_NBT_KEY));
        this.type.set(nbt.getInteger(WEAPON_TYPE_NBT_KEY));
        this.skinTone.set(nbt.getInteger(SKIN_TONE_NBT_KEY));
        this.eyeColor.set(nbt.getInteger(EYE_COLOR_NBT_KEY));
        this.camoColor.set(nbt.getInteger(CAMO_COLOR_NBT_KEY));
        this.name.set(nbt.getString(NAME_NBT_KEY));
        this.rank.set(MarineDecorator.MarineRank.values()[nbt.getInteger(RANK_NBT_KEY)]);
        this.loadedAmmunition = nbt.getInteger(LOADED_AMMUNITION_NBT_KEY);

        UUID squadLeaderUUID = nbt.getUniqueId(SQUAD_LEADER_NBT_KEY);

        if (squadLeaderUUID.getLeastSignificantBits() != 0 && squadLeaderUUID.getMostSignificantBits() != 0) {
            this.squadLeaderId.set(Optional.of(squadLeaderUUID));
        }

        NBTTagCompound inventoryTag = nbt.getCompoundTag(INVENTORY_NBT_KEY);
        InventoryNBTUtil.readInventoryFromNBT(INVENTORY_NBT_KEY, inventoryTag, this.inventory);
    }
}
