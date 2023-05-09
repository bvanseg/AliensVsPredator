package org.alien.common.entity.living.xenomorph.exotic;

import com.asx.mdx.common.math.MDXMath;
import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.block.Blocks;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.selector.EntitySelectorNauticomorph;
import org.alien.common.entity.living.SpeciesXenomorph;

import java.util.ArrayList;

public class EntityNauticomorph extends SpeciesXenomorph
{
    private static final DataParameter<Float> PHOSPHORESCENCE_LEVEL = EntityDataManager.createKey(EntityNauticomorph.class, DataSerializers.FLOAT);

    private long                              lastAttackedTime;

    public EntityNauticomorph(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.2F;
        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(PHOSPHORESCENCE_LEVEL, 0F);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.lurkInWater();
        this.updatePhosphorescenceLevel();

        if (this.getAttackTarget() == null && this.ticksExisted % 60 == 0 && this.rand.nextInt(3) == 0)
        {
            ArrayList<EntityLivingBase> entities = (ArrayList<EntityLivingBase>) Entities.getEntitiesInCoordsRange(world, EntityLivingBase.class, new Pos(this), (int) this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue() / 2);

            for (EntityLivingBase entity : entities)
            {
                if (EntitySelectorNauticomorph.instance.test(entity) && Entities.canEntityBeSeenBy(entity, this) && (!EntitySelectorNauticomorph.instance.test(entity.getLastAttackedEntity()) && (entity.ticksExisted - entity.getLastAttackedEntityTime() > 150)))
                {
                    if (entity instanceof EntityPlayer && !((EntityPlayer) entity).capabilities.isCreativeMode)
                    {
                        this.setAttackTarget(entity);
                    }
                }
            }
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        this.lastAttackedTime = this.ticksExisted;
        return super.attackEntityFrom(source, amount);
    }

    public void updatePhosphorescenceLevel()
    {
        if (!this.world.isRemote)
        {
            float mult = 0.02F;
            float downMult = mult;
            float targetLevel = 1F - (float) MDXMath.map(this.world.getLightBrightness(this.getPosition()), 0.08, 0.5, 0.08F, 1F);

            if (this.getAttackTarget() != null)
            {
                mult = 0.08F;
                downMult = mult;
                float time = 20;

                if (this.ticksExisted % time <= time / 2)
                {
                    targetLevel = 0.1F;
                }
            }

            long resultingTime = Math.abs(this.ticksExisted - this.lastAttackedTime);
            
            if (this.lastAttackedTime > 0  && resultingTime > 0 && resultingTime <= 20)
            {
                mult = 1F;
                downMult = 1F;
                
                if (this.ticksExisted % 3 <= 1)
                {
                    targetLevel = 0F;
                }
                else
                {
                    targetLevel = 1F;
                }
            }

            float currentLevel = this.getPhosphorescenceLevel();
            float newLevel = currentLevel;

            if (currentLevel < targetLevel)
            {
                newLevel += mult;
            }
            else if (currentLevel > targetLevel)
            {
                newLevel -= downMult;
            }

            newLevel = MathHelper.clamp(newLevel, 0.1F, 1F);

            this.setPhosphorescenceLevel(newLevel);
        }
    }

    public void lurkInWater()
    {
        if (this.getAttackTarget() == null)
        {
            if (this.ticksExisted % 40 == 0 && this.rand.nextInt(4) == 0)
            {
                if (this.world.getBlockState(this.getPosition()).getBlock() != net.minecraft.init.Blocks.WATER)
                {
                    double range = this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue() / 2;
                    ArrayList<Pos> coordData = Blocks.getCoordDataInRangeIncluding((int) this.posX, (int) this.posY, (int) this.posZ, (int) range, this.world, net.minecraft.init.Blocks.WATER);

                    if (!coordData.isEmpty())
                    {
                        Pos selectedCoord = coordData.get(this.rand.nextInt(coordData.size()));
                        this.getNavigator().tryMoveToXYZ(selectedCoord.x, selectedCoord.y, selectedCoord.z, this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
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
        return AlienSounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return AlienSounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.ALIEN_DEATH.event();
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    public float getPhosphorescenceLevel()
    {
        return this.getDataManager().get(PHOSPHORESCENCE_LEVEL);
    }

    public void setPhosphorescenceLevel(float level)
    {
        this.getDataManager().set(PHOSPHORESCENCE_LEVEL, level);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_AQUA);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.98F;
    }
}
