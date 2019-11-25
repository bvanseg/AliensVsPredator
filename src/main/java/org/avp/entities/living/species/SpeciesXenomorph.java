package org.avp.entities.living.species;

import org.avp.DamageSources;
import org.avp.EntityItemDrops;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.alien.EntityAIFindJelly;
import org.avp.entities.ai.alien.EntityAIShareJelly;
import org.avp.entities.ai.alien.EntitySelectorXenomorph;
import org.avp.entities.living.species.xenomorphs.EntityMatriarch;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class SpeciesXenomorph extends SpeciesAlien implements IMob
{
    public static final float                   JAW_PROGRESS_INCR   = 0.3F;
    public static final float                   JAW_PROGRESS_MAX    = 1.0F;

    public static final float                   MOUTH_PROGRESS_INCR = 0.175F;
    public static final float                   MOUTH_PROGRESS_MAX  = 1.0F;

    private static final DataParameter<Boolean> CRAWLING            = EntityDataManager.createKey(SpeciesXenomorph.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Float>   JAW_PROGRESS        = EntityDataManager.createKey(SpeciesXenomorph.class, DataSerializers.FLOAT);
    private static final DataParameter<Float>   MOUTH_PROGRESS      = EntityDataManager.createKey(SpeciesXenomorph.class, DataSerializers.FLOAT);

    private boolean                             startBite           = false;
    private boolean                             retractMouth        = false;
    protected boolean                           ableToClimb;

    public SpeciesXenomorph(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.045F;
        this.ableToClimb = false;
        this.isDependant = true;
        this.addStandardXenomorphAISet();
    }

    protected void addStandardXenomorphAISet()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.6F));
        this.tasks.addTask(2, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(3, new EntityAIFindJelly(this));
        this.tasks.addTask(3, new EntityAIShareJelly(this));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLivingBase.class, 16F));
        this.tasks.addTask(5, new EntityAICustomAttackOnCollide(this, EntityLiving.class, 1.0D, false));
        this.tasks.addTask(5, new EntityAICustomAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityLiving>(this, EntityLiving.class, 0, false, false, EntitySelectorXenomorph.instance));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 0, false, false, EntitySelectorXenomorph.instance));
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();

        this.getDataManager().register(CRAWLING, false);
        this.getDataManager().register(JAW_PROGRESS, 0F);
        this.getDataManager().register(MOUTH_PROGRESS, 0F);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        /** Fall Damage Negation **/
        this.fallDistance = 0F;

        this.updateInnerMouth();
        this.ocassionallyOpenMouth();
        
        if(this.getAttackTarget() != null && !EntitySelectorXenomorph.instance.apply(this.getAttackTarget()))
            this.setAttackTarget(null);
    }

    public boolean isCrawling()
    {
        return this.getDataManager().get(CRAWLING);
    }

    public boolean isStanding()
    {
        return !this.getDataManager().get(CRAWLING);
    }

    protected void setCrawling()
    {
        this.getDataManager().set(CRAWLING, true);
    }

    protected void setStanding()
    {
        this.getDataManager().set(CRAWLING, false);
    }

    public float getOuterJawProgress()
    {
        return this.getDataManager().get(JAW_PROGRESS);
    }

    public float getInnerJawProgress()
    {
        return this.getDataManager().get(MOUTH_PROGRESS);
    }

    protected void decreaseOuterJawProgress()
    {
        float p = this.getOuterJawProgress();

        if (p > 0F)
        {
            this.getDataManager().set(JAW_PROGRESS, p - JAW_PROGRESS_INCR);
        }
    }

    protected void increaseOuterJawProgress()
    {
        float p = this.getOuterJawProgress();

        if (p < JAW_PROGRESS_MAX)
        {
            this.getDataManager().set(JAW_PROGRESS, p + JAW_PROGRESS_INCR);
        }
    }

    protected void decreaseInnerJawProgress()
    {
        float p = this.getInnerJawProgress();

        if (p > 0F)
        {
            this.getDataManager().set(MOUTH_PROGRESS, p - MOUTH_PROGRESS_INCR);
        }
    }

    protected void increaseInnerJawProgress()
    {
        float p = this.getInnerJawProgress();

        if (p < MOUTH_PROGRESS_MAX)
        {
            this.getDataManager().set(MOUTH_PROGRESS, p + MOUTH_PROGRESS_INCR);
        }
    }

    public void bite()
    {
        this.startBite = true;
    }

    protected void ocassionallyOpenMouth()
    {
        if (!this.world.isRemote)
        {
            if (this.world.getTotalWorldTime() % ((20 * 4) + (20 * this.rand.nextInt(32))) == 0)
            {
                this.bite();
            }
        }
    }

    protected void updateInnerMouth()
    {
        if (!this.world.isRemote)
        {
            float outerJawProgress = this.getOuterJawProgress();
            float innerJawProgress = this.getInnerJawProgress();

            if (startBite && outerJawProgress <= JAW_PROGRESS_MAX)
            {
                this.increaseOuterJawProgress();
            }

            if (outerJawProgress >= JAW_PROGRESS_MAX || !startBite)
            {
                this.startBite = false;

                if (outerJawProgress >= JAW_PROGRESS_MAX && innerJawProgress < MOUTH_PROGRESS_MAX && !retractMouth)
                {
                    this.increaseInnerJawProgress();

                    if (innerJawProgress + MOUTH_PROGRESS_INCR >= MOUTH_PROGRESS_MAX)
                    {
                        this.retractMouth = true;
                    }
                }

                if (innerJawProgress > 0)
                {
                    if (innerJawProgress >= MOUTH_PROGRESS_MAX || retractMouth)
                    {
                        this.decreaseInnerJawProgress();

                        if (this.getInnerJawProgress() <= 0)
                        {
                            this.retractMouth = false;
                        }
                    }
                }

                if (this.getInnerJawProgress() < 0.0F)
                {
                    this.decreaseOuterJawProgress();
                }
            }
        }
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        EntityItemDrops.XENO_FEET.tryDrop(this);
        EntityItemDrops.XENO_HELM.tryDrop(this);
        EntityItemDrops.XENO_LEGS.tryDrop(this);
        EntityItemDrops.XENO_TORSO.tryDrop(this);

        if (damagesource == DamageSources.wristbracer)
        {
            EntityItemDrops.SKULLS_XENO.tryDrop(this, 25);
        }
        else
        {
            EntityItemDrops.SKULLS_XENO.tryDrop(this);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        this.bite();
        return super.attackEntityAsMob(entity);
    }

    public boolean isAbleToClimb()
    {
        return this.ableToClimb;
    }
}
