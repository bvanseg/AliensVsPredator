package org.avp.common.entity.living;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import com.google.common.base.Optional;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import org.avp.client.AVPSounds;
import org.avp.common.AVPItems;
import org.avp.common.entity.ai.brain.MarineBrain;
import org.avp.common.network.AvpDataSerializers;
import org.avp.common.world.MarineTypes;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.BrainMemoryKeys;
import org.weapon.common.entity.EntityBullet;
import org.lib.common.inventory.InventorySnapshot;
import org.lib.common.inventory.ItemDropContext;

import java.util.UUID;

public class EntityMarine extends EntityCreature implements IMob, IRangedAttackMob, Brainiac<MarineBrain>
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

    private final InventoryBasic inventory;

    public EntityMarine(World world)
    {
        super(world);
        this.experienceValue = 5;
        this.inventory = new InventoryBasic("Items", false, 9 * 3);
    }

    @Override
    public MarineBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new MarineBrain(this);
        }
        return this.brain;
    }

    /**
     * Gets the marine's inventory.
     * Deprecated to discourage usage. Use getInventorySnapshot, instead.
     *
     * @return The marine's inventory.
     */
    @Deprecated
    public InventoryBasic getInventory() {
        return this.inventory;
    }

    public InventorySnapshot getInventorySnapshot() {
        InventorySnapshot snapshot = new InventorySnapshot();
        snapshot.snapshot(this.inventory);
        return snapshot;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(AIMING, false);

        this.getDataManager().register(TYPE, MarineDecorator.generateRandomWeaponType(this));
        this.getDataManager().register(SKIN_TONE, MarineDecorator.generateRandomSkinTone(this));
        this.getDataManager().register(CAMO_COLOR, -1);
        this.getDataManager().register(EYE_COLOR, MarineDecorator.generateRandomEyeColor(this));
        this.getDataManager().register(NAME, MarineDecorator.generateRandomMarineName(this));
        this.getDataManager().register(RANK, MarineDecorator.generateRandomMarineRank(this));
        this.getDataManager().register(SQUAD_LEADER_UNIQUE_ID, Optional.absent());
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
    public ItemStack getHeldItemMainhand()
    {
        return new ItemStack(getMarineType().getFirearmItem());
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote)
        {
            // We can't initialize the marine's camo color within entityInit, because while that method
            // is being invoked, the entity is positioned at 0, 0, 0, and will always get the biome
            // at that position instead of its true spawn position. So we initialize the camo color here, instead.
            if (this.getCamoColor() == -1) {
                this.getDataManager().set(CAMO_COLOR, MarineDecorator.generateCamoColorBasedOnCurrentBiome(this));
            }

            this.brain.update();
            this.getDataManager().set(AIMING, this.getAttackTarget() != null || this.getBrain().hasMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET));
        }
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        // If the marine does not have a squad leader already, the interacting player is now the squad leader.
        if (!this.getSquadLeaderID().isPresent()) {
            this.setSquadLeaderUniqueID(player.getUniqueID());
            return super.processInteract(player, hand);
        }

        if (player.getHeldItem(hand).getItem() == Items.DYE) {
            int dyeColor = EnumDyeColor.byDyeDamage(player.getHeldItem(hand).getItemDamage()).getColorValue();
            this.getDataManager().set(CAMO_COLOR, dyeColor << 8);
        }

        return super.processInteract(player, hand);
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

        EntityLivingBase squadLeader = this.world.getPlayerEntityByUUID(this.getSquadLeaderID().get());

        if (squadLeader == null) return;

        if (!this.world.isRemote && this.world.getGameRules().getBoolean("showDeathMessages") && squadLeader instanceof EntityPlayerMP)
        {
            squadLeader.sendMessage(this.getCombatTracker().getDeathMessage());
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null)
        {
            EntityBullet entityBullet = new EntityBullet(this.world, this, targetEntity, 10F, 0.0000001F);
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

    @Override
    public boolean hasCustomName() {
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

    public void setSquadLeaderUniqueID(UUID squadLeaderUniqueId) {
        this.getDataManager().set(SQUAD_LEADER_UNIQUE_ID, Optional.of(squadLeaderUniqueId));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) { /* Do Nothing */ }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AVPItems.SUMMONER_MARINE);
    }

    private static final String WEAPON_TYPE_NBT_KEY = "WeaponType";
    private static final String SKIN_TONE_NBT_KEY = "SkinTone";
    private static final String EYE_COLOR_NBT_KEY = "EyeColor";
    private static final String CAMO_COLOR_NBT_KEY = "CamoColor";
    private static final String NAME_NBT_KEY = "MarineName";
    private static final String RANK_NBT_KEY = "Rank";
    private static final String SQUAD_LEADER_NBT_KEY = "SquadLeader";
    private static final String INVENTORY_NBT_KEY = "Inventory";

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

        if (this.getSquadLeaderID().isPresent()) {
            nbt.setUniqueId(SQUAD_LEADER_NBT_KEY, this.getSquadLeaderID().get());
        }

        this.writeInventoryToNBT(nbt);
    }

    private void writeInventoryToNBT(NBTTagCompound nbt) {
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack = this.inventory.getStackInSlot(i);

            if (!itemstack.isEmpty())
            {
                nbttaglist.appendTag(itemstack.writeToNBT(new NBTTagCompound()));
            }
        }

        nbt.setTag(INVENTORY_NBT_KEY, nbttaglist);
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

        if (nbt.hasKey(SQUAD_LEADER_NBT_KEY)) {
            this.setSquadLeaderUniqueID(nbt.getUniqueId(SQUAD_LEADER_NBT_KEY));
        }

        this.readInventoryFromNBT(nbt);
    }

    private void readInventoryFromNBT(NBTTagCompound nbt) {
        NBTTagList nbttaglist = nbt.getTagList(INVENTORY_NBT_KEY, Constants.NBT.TAG_COMPOUND);

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            ItemStack itemstack = new ItemStack(nbttaglist.getCompoundTagAt(i));

            if (!itemstack.isEmpty())
            {
                this.inventory.addItem(itemstack);
            }
        }
    }
}
