package org.avp.entities.living;

import java.util.ArrayList;

import org.avp.client.Sounds;
import org.avp.entities.EntityAcidPool;

import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.block.Blocks;
import com.arisux.mdx.lib.world.entity.Entities;
import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

@SuppressWarnings("all")
public class EntityAqua extends EntityXenomorph
{
    public EntityAqua(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.2F;
        
        
        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
        
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        
        this.addStandardXenomorphAISet();
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    public static Predicate<EntityLivingBase> entitySelector = new Predicate<EntityLivingBase>()
    {
        @Override
        public boolean apply(EntityLivingBase entity)
        {
            return !(entity instanceof EntitySpeciesAlien) && !(entity instanceof EntityAqua) && !(entity instanceof EntityAcidPool);
        }
    };

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.lurkInWater();

        if (this.getAttackTarget() == null && this.world.getWorldTime() % 60 == 0 && this.rand.nextInt(3) == 0)
        {
            ArrayList<EntityLivingBase> entities = (ArrayList<EntityLivingBase>) Entities.getEntitiesInCoordsRange(world, EntityLivingBase.class, new Pos(this), (int) this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue() / 2);

            for (EntityLivingBase entity : entities)
            {
                if (entitySelector.apply(entity) && Entities.canEntityBeSeenBy(entity, this) && (!entitySelector.apply(entity.getLastAttackedEntity()) && (entity.ticksExisted - entity.getLastAttackedEntityTime() > 150)))
                {
                    if (entity instanceof EntityPlayer && !((EntityPlayer) entity).capabilities.isCreativeMode)
                    {
                        this.setAttackTarget(entity);
                    }
                }
            }
        }
    }

    public void lurkInWater()
    {
        if (this.getAttackTarget() == null)
        {
            if (this.world.getWorldTime() % 40 == 0 && this.rand.nextInt(4) == 0)
            {
                if (this.world.getBlockState(this.getPosition()).getBlock() != net.minecraft.init.Blocks.WATER)
                {
                    double range = this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue() / 2;
                    ArrayList<Pos> coordData = Blocks.getCoordDataInRangeIncluding((int) this.posX, (int) this.posY, (int) this.posZ, (int) range, this.world, net.minecraft.init.Blocks.WATER);

                    if (coordData.size() > 0)
                    {
                        Pos selectedCoord = coordData.get(this.rand.nextInt(coordData.size()));
                        this.getNavigator().tryMoveToXYZ((double) selectedCoord.x, (double) selectedCoord.y, (double) selectedCoord.z, this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                    }
                }
            }
        }
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5500000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.ALIEN_DEATH.event();
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }
}
