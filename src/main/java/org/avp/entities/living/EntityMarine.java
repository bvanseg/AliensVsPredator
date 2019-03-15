package org.avp.entities.living;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.avp.EntityItemDrops;
import org.avp.client.Sounds;
import org.avp.entities.EntityBullet;
import org.avp.entities.EntityLiquidPool;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.world.MarineTypes;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMarine extends EntityCreature implements IMob, IRangedAttackMob, Predicate<EntityLivingBase>
{
    private static final DataParameter<Boolean> FIRING = EntityDataManager.createKey(EntityMarine.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TYPE   = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private EntityAIBase                        rangedAttackAI;
    private long                                lastShotFired;

    public EntityMarine(World world)
    {
        super(world);
        this.experienceValue = 5;
        this.rangedAttackAI = new EntityAIAttackRanged(this, 0.4D, (int) getMarineType().getFirearmItem().getProfile().getShotsPerTick() / 2, 24);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, this.rangedAttackAI);
        this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIMoveIndoors(this));
        this.targetTasks.addTask(2, new EntityAIOpenDoor(this, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, true, false, this));
        
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(FIRING, false);
        this.getDataManager().register(TYPE, new Random(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).nextInt(MarineTypes.values().length));
    }

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        if (entity instanceof SpeciesAlien)
            return true;

        if (entity instanceof EntityMob)
            return true;

        if (entity instanceof EntityYautjaWarrior)
            return true;

        if (entity instanceof EntityGolem)
            return true;

        if (entity instanceof SpeciesXenomorph)
            return true;

        if (entity instanceof EntityLiquidPool)
            return false;

        if (entity instanceof EntityPlayer)
            return false;

        if (entity instanceof EntityMarine)
            return false;

        if (entity instanceof EntityCombatSynthetic)
            return false;

        return false;
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
        return Sounds.MARINE_HURT.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.MARINE_DEATH.event();
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
            this.getDataManager().set(FIRING, !(System.currentTimeMillis() - getLastShotFired() >= 1000 * 3));
        }
    }

    @Override
    public void onDeath(DamageSource source)
    {
        super.onDeath(source);
        EntityItemDrops.AMMUNITION.tryDrop(this);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null)
        {
            this.lastShotFired = System.currentTimeMillis();
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

    public boolean isFiring()
    {
        return this.getDataManager().get(FIRING);
    }

    public long getLastShotFired()
    {
        return this.lastShotFired;
    }

    @Override
    public void setSwingingArms(boolean swingingArms)
    {
        ;
    }
}
