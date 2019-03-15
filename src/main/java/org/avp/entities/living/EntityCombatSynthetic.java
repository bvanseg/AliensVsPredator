package org.avp.entities.living;

import org.avp.AliensVsPredator;
import org.avp.EntityItemDrops;
import org.avp.api.parasitoidic.IHost;
import org.avp.client.Sounds;
import org.avp.entities.EntityBullet;
import org.avp.entities.EntityLiquidLatexPool;
import org.avp.entities.EntityLiquidPool;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.entities.living.species.SpeciesYautja;

import com.google.common.base.Predicate;

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
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityCombatSynthetic extends EntityCreature implements IMob, IRangedAttackMob, IHost, Predicate<EntityLivingBase>
{
    private EntityAIBase aiRangedAttack;
    
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
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityLivingBase.class, /** targetChance **/ 0, /** shouldCheckSight **/ true, /** nearbyOnly **/ false, this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5499999761581421D);
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

        if (this.getAttackTarget() != null && this.world.getWorldTime() % 20 == 0 && this.aiRangedAttack.shouldExecute() && this.canEntityBeSeen(this.getAttackTarget()))
        {
        }
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
    public boolean apply(EntityLivingBase entity)
    {
        if (entity instanceof SpeciesAlien)
            return true;

        if (entity instanceof EntityMob)
            return true;

        if (entity instanceof SpeciesYautja)
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
}
