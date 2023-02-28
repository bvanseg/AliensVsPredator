package org.avp.entities.living;

import org.avp.AliensVsPredator;
import org.avp.EntityItemDrops;
import org.avp.ItemHandler;
import org.avp.api.parasitoidic.IHost;
import org.avp.client.Sounds;
import org.avp.entities.EntityBullet;
import org.avp.entities.EntityLiquidLatexPool;
import org.avp.entities.ai.EntitySelectorCombatSynthetic;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
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
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCombatSynthetic extends EntityCreature implements IMob, IRangedAttackMob, IHost
{
    private static final DataParameter<Boolean> FIRING = EntityDataManager.createKey(EntityMarine.class, DataSerializers.BOOLEAN);
    
    private EntityAIBase                        aiRangedAttack;
    private long                                lastShotFired;

    public EntityCombatSynthetic(World word)
    {
        super(word);
        this.setSize(1, 2);
        this.experienceValue = 40;
        this.aiRangedAttack = new EntityAIAttackRanged(this, 0.4D, 20, 24);
        this.tasks.addTask(1, this.aiRangedAttack);
        this.tasks.addTask(2, new EntityAIWander(this, this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
        this.tasks.addTask(3, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityLivingBase.class, 0, true, false, EntitySelectorCombatSynthetic.instance));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5499999761581421D);
    }
    
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(FIRING, false);
    }
    
    @Override
    protected void despawnEntity()
    {
        ;
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
        return new ItemStack(AliensVsPredator.items().itemM41A);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    public int getTotalArmorValue()
    {
        return 5;
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

    public boolean isFiring()
    {
        return this.getDataManager().get(FIRING);
    }
    
    @Override
    public float getBlockPathWeight(BlockPos pos)
    {
        return 0.5F - this.world.getLightBrightness(pos);
    }
    
    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null)
        {
            this.lastShotFired = System.currentTimeMillis();
            Sounds.WEAPON_PULSERIFLE.playSound(this);
            EntityBullet entityBullet = new EntityBullet(this.world, this, targetEntity, 10F, 0.5F);
            entityBullet.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.world.spawnEntity(entityBullet);
            this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + this.getEyeHeight(), this.posZ, 1, 1, 1);
        }
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);
        
        EntityItemDrops.AMMUNITION.tryDrop(this);

        if (!this.world.isRemote)
        {
            EntityLiquidLatexPool pool = new EntityLiquidLatexPool(this.world);
            pool.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.world.spawnEntity(pool);
        }
    }

    @Override
    public boolean canParasiteAttach()
    {
        return false;
    }

    @Override
    public boolean canHostParasite()
    {
        return false;
    }

    @Override
    public void setSwingingArms(boolean swingingArms)
    {
        ;
    }

    public long getLastShotFired()
    {
        return this.lastShotFired;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerCombatSynthetic);
    }
}
