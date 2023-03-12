package org.alien.common.entity.living;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.avp.common.DamageSources;
import org.avp.common.EntityItemDrops;
import org.avp.common.brain.Brainiac;
import org.avp.common.brain.impl.EntityBrainContext;
import org.avp.common.brain.impl.XenomorphBrain;

public abstract class SpeciesXenomorph extends SpeciesAlien implements IMob, Brainiac<XenomorphBrain>
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

    private              XenomorphBrain         brain;

    public SpeciesXenomorph(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.045F;
        this.ableToClimb = false;
        this.isDependant = true;
    }

    @Override
    public XenomorphBrain getBrain() {
    	if (brain == null && !this.world.isRemote) {
    		brain = new XenomorphBrain(this);
    	}
    	return brain;
    }

    @Override
    protected void initEntityAI() {
    	this.getBrain().init();
    }

    @Deprecated
    protected void addStandardXenomorphAISet() {}

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

        if (!this.world.isRemote) {
            brain.update(new EntityBrainContext(this.getBrain(), this));
        }

        /** Fall Damage Negation **/
        this.fallDistance = 0F;

        this.updateInnerMouth();
        this.ocassionallyOpenMouth();
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
