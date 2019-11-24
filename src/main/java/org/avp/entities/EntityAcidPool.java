package org.avp.entities;

import javax.annotation.Nullable;

import org.avp.DamageSources;
import org.avp.entities.ai.EntityAIMeltBlock;
import org.avp.entities.living.species.SpeciesAlien;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityAcidPool extends EntityLiquidPool implements IMob
{
    public EntityAcidPool(World world)
    {
        super(world);
        this.isImmuneToFire = false;
        this.ignoreFrustumCheck = true;
        this.setSize(1.65F, 0.09F);
        this.tasks.addTask(0, new EntityAIMeltBlock(this, -1));
    }

    private static final Predicate<EntityLivingBase> SELECTOR = new Predicate<EntityLivingBase>()
    {
        @Override
        public boolean apply(@Nullable EntityLivingBase living)
        {
            if (living instanceof EntityLiquidPool)
            {
                return false;
            }

            if (living instanceof SpeciesAlien)
            {
                return false;
            }

            return true;
        }
    };

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public boolean isAIDisabled()
    {
        return false;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean isInRangeToRenderDist(double range)
    {
        return true;
    }
    
    @Override
    protected void collideWithEntity(Entity target)
    {
        if(!this.world.isRemote && target instanceof EntityLivingBase)
        {
            if (target != null && SELECTOR.apply((EntityLivingBase)target))
            {
                target.attackEntityFrom(DamageSources.acid, 4F);
            }
        }
    }

    public float getAcidIntensity()
    {
        return 1F - (1F / this.getLifetime() / (1F / this.ticksExisted));
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (world.isRemote && world.getTotalWorldTime() % 4 <= 0)
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + this.rand.nextDouble(), this.posY + this.rand.nextDouble(), this.posZ + this.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        if (!this.world.isRemote)
        {
            if (!player.capabilities.isCreativeMode)
            {
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, (14 * 20), 0));
            }
        }
    }

    public int getLifetime()
    {
        return lifetime;
    }
}
