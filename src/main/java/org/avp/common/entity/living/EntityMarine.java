package org.avp.common.entity.living;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.client.AVPSounds;
import org.avp.common.AVPItemDrops;
import org.avp.common.AVPItems;
import org.avp.common.entity.EntityBullet;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.avp.common.entity.ai.selector.EntitySelectorMarine;
import org.avp.common.item.firearm.FirearmProfile;
import org.avp.common.world.MarineTypes;

public class EntityMarine extends EntityCreature implements IMob, IRangedAttackMob
{
    private static final DataParameter<Boolean> AIMING = EntityDataManager.createKey(EntityMarine.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TYPE   = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private EntityAIBase                        rangedAttackAI;

    public EntityMarine(World world)
    {
        super(world);
        this.experienceValue = 5;

    }

    @Override
    protected void initEntityAI() {
        this.rangedAttackAI = new EntityAIAttackRanged(this, 0.4D, getAttackDelayBasedOnFirearm(), 24);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, this.rangedAttackAI);
        this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new PatchedEntityAIWander(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIMoveIndoors(this));

        this.targetTasks.addTask(2, new EntityAIOpenDoor(this, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, true, false, EntitySelectorMarine.instance));
    }

    private int getAttackDelayBasedOnFirearm() {
        FirearmProfile firearmProfile = getMarineType().getFirearmItem().getProfile();
        double rpm = firearmProfile.getRoundsPerMinute();
        double rps = rpm / 60; // Rounds per second
        double rpt = rps / 20; // Rounds per tick
        return (int) (1 / rpt); // How many ticks (x) must the entity wait until they can fire once (1 = rpt * x)
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(AIMING, false);
        this.getDataManager().register(TYPE, this.world.rand.nextInt(MarineTypes.values().length));
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
    public float getBlockPathWeight(BlockPos pos)
    {
        return 0.5F - this.world.getLightBrightness(pos);
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
    protected void updateAITasks()
    {
        super.updateAITasks();
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote)
        {
            this.getDataManager().set(AIMING, this.getAttackTarget() != null);
        }
    }

    @Override
    public void onDeath(DamageSource source)
    {
        super.onDeath(source);
        AVPItemDrops.AMMUNITION.tryDrop(this);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null)
        {
            EntityBullet entityBullet = new EntityBullet(this.world, this, targetEntity, 10F, 0.0000001F);
            this.world.spawnEntity(entityBullet);
            this.playSound(getMarineType().getGunfireSound(), 0.7F, 1F);
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + this.getEyeHeight(), this.posZ, 1, 1, 1);
        }
    }

    public MarineTypes getMarineType()
    {
        if (TYPE != null)
        {
            return MarineTypes.getTypeForId(this.getDataManager().get(TYPE));
        }

        return MarineTypes.M41A;
    }

    public boolean isAiming()
    {
        return this.getDataManager().get(AIMING);
    }

    @Override
    public void setSwingingArms(boolean swingingArms)
    {
        ;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AVPItems.SUMMONER_MARINE);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("WeaponType", this.dataManager.get(TYPE));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.dataManager.set(TYPE, nbt.getInteger("WeaponType"));
    }
}
