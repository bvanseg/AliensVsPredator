package org.avp.entities.living;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.api.parasitoidic.IHost;
import org.avp.api.parasitoidic.IParasitoid;
import org.avp.client.Sounds;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.alien.EntitySelectorTrilobite;
import org.avp.packets.server.PacketAttachParasiteToEntity;
import org.avp.world.Embryo;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.entity.animations.Animation;
import com.asx.mdx.lib.world.entity.animations.AnimationHandler;
import com.asx.mdx.lib.world.entity.animations.IAnimated;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityTrilobite extends EntitySpecies223ODe implements IParasitoid, IAnimated
{
    public static final Animation               IMPREGNATION_ANIMATION = Animation.create(0);
    public static final Animation               ANIMATION_HUG_WALL     = Animation.create(20 * 5);

    private static final DataParameter<Boolean> FERTILE                = EntityDataManager.createKey(EntityParasitoid.class, DataSerializers.BOOLEAN);
    private int                                 ticksOnHost            = 0;

    public static Predicate<EntityLivingBase>   impregnationSelector   = new Predicate<EntityLivingBase>() {
                                                                           @Override
                                                                           public boolean apply(EntityLivingBase potentialTarget)
                                                                           {
                                                                               ArrayList<Class<?>> blacklist = IParasitoid.getDefaultEntityBlacklist();

                                                                               for (Class<?> c : blacklist)
                                                                               {
                                                                                   if (c.isInstance(potentialTarget))
                                                                                   {
                                                                                       return false;
                                                                                   }
                                                                               }

                                                                               Organism organism = (Organism) potentialTarget.getCapability(Provider.CAPABILITY, null);

                                                                               if (potentialTarget instanceof IHost)
                                                                               {
                                                                                   IHost host = (IHost) potentialTarget;

                                                                                   if (!host.canHostParasite() || !host.canParasiteAttach())
                                                                                   {
                                                                                       return false;
                                                                                   }
                                                                               }

                                                                               if (organism != null && organism.hasEmbryo())
                                                                               {
                                                                                   return false;
                                                                               }

                                                                               if (potentialTarget instanceof EntityPlayer)
                                                                               {
                                                                                   EntityPlayer player = (EntityPlayer) potentialTarget;
                                                                                   ItemStack headwear = Inventories.getHelmSlotItemStack(player);

                                                                                   if (headwear != null && headwear.getItem() != Items.AIR || ((EntityPlayer) potentialTarget).capabilities.isCreativeMode)
                                                                                   {
                                                                                       return false;
                                                                                   }
                                                                               }

                                                                               if (!(potentialTarget instanceof EntityLivingBase))
                                                                               {
                                                                                   return false;
                                                                               }

                                                                               if (potentialTarget instanceof EntityLiving)
                                                                               {
                                                                                   EntityLiving living = (EntityLiving) potentialTarget;

                                                                                   if (living.isChild())
                                                                                   {
                                                                                       return false;
                                                                                   }
                                                                               }

                                                                               return true;
                                                                           }
                                                                       };

    public EntityTrilobite(World world)
    {
        super(world);
        this.setSize(3F, 1.98F);
        this.experienceValue = 32;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAICustomAttackOnCollide(this, 0.800000011920929D, true));
        this.tasks.addTask(8, new EntityAIWander(this, 0.800000011920929D));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAILeapAtTarget(this, 0.85F));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, false, false, EntitySelectorTrilobite.instance));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(44.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6999999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1F);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(FERTILE, true);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    protected void updateAITasks()
    {
        super.updateAITasks();
    }

    @Override
    public void onEntityUpdate()
    {
        super.onEntityUpdate();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        if (!this.isFertile())
        {
            this.setNoAI(true);

            this.motionY -= 0.25F;

            this.motionX *= 0.98F;
            this.motionY *= 0.98F;
            this.motionZ *= 0.98F;
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        }

        if (this.collidedHorizontally)
        {
             this.motionY += 0.25F;
        }

        this.jumpMovementFactor = 1.0F;
        if (this.world.getWorldTime() % 20 == 0)
        {
            if (isFertile())
            {
                ArrayList<EntityLivingBase> targetHosts = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(1.0D, 16.0D, 1.0D), this.getImpregnationEntitiySelector());

                if (targetHosts != null && targetHosts.size() > 0)
                {
                    Collections.sort(targetHosts, new EntityAINearestAttackableTarget.Sorter(this));

                    EntityLivingBase targetHost = targetHosts.get(0);
                    this.setAttackTarget(targetHost);

                    if (!targetHosts.contains(this.getAttackTarget()))
                    {
                        this.setAttackTarget(null);
                    }
                }
            }
        }

        this.negateFallDamage();

        if (this.isAttachedToHost())
        {
            this.ticksOnHost++;

            if (this.getRidingEntity() instanceof EntityLiving)
            {
                EntityLiving living = (EntityLiving) this.getRidingEntity();

                living.rotationYawHead = 0;
                living.rotationYaw = 0;
                living.prevRotationYawHead = 0;
                living.prevRotationYaw = 0;

                this.rotationYawHead = 0;
                this.rotationYaw = 0;
                this.prevRotationYawHead = 0;
                this.prevRotationYaw = 0;

                EntityMoveHelper newMoveHelper = new EntityMoveHelper(living) {
                    public void onUpdateMoveHelper()
                    {
                        ;
                    }
                };
                MDX.access().setMoveHelper(living, newMoveHelper);
                MDX.access().setMoveHelper(this, newMoveHelper);

                EntityLookHelper newLookHelper = new EntityLookHelper(living) {
                    public void setLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch)
                    {
                        ;
                    }
                    public void setLookPositionWithEntity(Entity entityIn, float deltaYaw, float deltaPitch)
                    {
                        ;
                    }
                    public float updateRotation(float x, float y, float z)
                    {
                        return 0F;
                    }
                };
                MDX.access().setLookHelper(living, newLookHelper);
                MDX.access().setLookHelper(this, newLookHelper);
            }
        }

        if (this.getTicksOnHost() > this.getDetachTime())
        {
            if (this.getRidingEntity() != null)
            {
                if (this.getRidingEntity() instanceof EntityLiving)
                {
                    EntityLiving living = (EntityLiving) this.getRidingEntity();

                    EntityMoveHelper newMoveHelper = new EntityMoveHelper(living);
                    MDX.access().setMoveHelper(living, newMoveHelper);

                    EntityLookHelper newLookHelper = new EntityLookHelper(living);
                    MDX.access().setLookHelper(living, newLookHelper);
                }
                this.detachFromHost();
            }
        }
        
        if (this.getAttackTarget() != null)
        {
            if (this.getActiveAnimation() == ANIMATION_HUG_WALL)
            {
                Entity entityIn = this.getAttackTarget();
                float angle = (float) (MathHelper.atan2(entityIn.posZ - this.posZ, entityIn.posX - this.posX) * (180D / Math.PI)) - 90.0F;
                angle = MathHelper.floor((angle / 90) + 0.5) * 90F;
                this.rotationYaw = angle;
            }
            
            double distanceX = this.prevPosX - this.posX;
            double distanceZ = this.prevPosZ - this.posZ;
            
            double motion = distanceX * distanceZ;
            
            if ((this.collidedHorizontally) && this.getActiveAnimation() == NO_ANIMATION && Math.abs(motion) < 0.3D && Math.abs(motion) > 0.0D)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, ANIMATION_HUG_WALL);
            }
        }
        
        if (this.getRidingEntity() == null && this.getActiveAnimation() == IMPREGNATION_ANIMATION)
        {
            this.setActiveAnimation(NO_ANIMATION);
        }
    }

    @Override
    protected boolean pushOutOfBlocks(double x, double y, double z)
    {
        return super.pushOutOfBlocks(x, y, z);
    }

    @Override
    protected void onInsideBlock(IBlockState state)
    {
        super.onInsideBlock(state);
    }

    @Override
    protected void onAnimationFinish(Animation animation)
    {
        super.onAnimationFinish(animation);
    }

    @Override
    public double getYOffset()
    {
        if (this.getRidingEntity() != null)
        {
            return -this.getRidingEntity().height;
        }
        return super.getYOffset();
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox()
    {
        return super.getCollisionBoundingBox();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.FACEHUGGER_HURT.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.CHESTBURSTER_BURST.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.FACEHUGGER_LIVING.event();
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return true;
    }

    @Override
    public boolean isOnLadder()
    {
        return this.motionY > 1.0099999997764826D;
    }

    public boolean isClimbing()
    {
        return false;
    }

    @Override
    public boolean isPotionApplicable(PotionEffect potionEffect)
    {
        return potionEffect.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potionEffect);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected void collideWithNearbyEntities()
    {
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());

        if (list != null && !list.isEmpty())
        {
            for (int i = 0; i < list.size(); ++i)
            {
                Entity entity = (Entity) list.get(i);

                this.collideWithEntity(entity);
            }
        }
    }

    @Override
    public void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);

        if (!this.world.isRemote && this.isFertile() && this.canAttach(entity))
        {
            AliensVsPredator.network().sendToAll(new PacketAttachParasiteToEntity(this.getEntityId(), entity.getEntityId()));
            this.attachToEntity(entity);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        IParasitoid.readFromNBT(this, nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        IParasitoid.writeToNBT(this, nbt);
        return super.writeToNBT(nbt);
    }

    /** Parasitoid implementation **/

    @Override
    public void attachToEntity(Entity target)
    {
        if (Entities.getEntityRiddenBy(target) == null && target instanceof EntityLivingBase)
        {
            EntityLivingBase living = (EntityLivingBase) target;

            AnimationHandler.INSTANCE.sendAnimationMessage(this, IMPREGNATION_ANIMATION);
            this.startRiding(living);
            this.implantEmbryo(living);
        }
    }

    @Override
    public void implantEmbryo(EntityLivingBase target)
    {
        Organism organism = (Organism) target.getCapability(Provider.CAPABILITY, null);
        organism.impregnate(Embryo.DEACON);
        organism.syncWithClients(target);
        this.setFertility(false);
    }

    @Override
    public void detachFromHost()
    {
        this.dismountRidingEntity();
        this.setNoAI(true);
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        if (this.getRidingEntity() != null && this.getRidingEntity() instanceof EntityLiving)
        {
            EntityLiving living = (EntityLiving) this.getRidingEntity();
            living.setNoAI(false);
        }

        super.onDeath(damagesource);
    }

    @Override
    public void setFertility(boolean fertility)
    {
        this.getDataManager().set(FERTILE, fertility);
    }

    @Override
    public boolean isFertile()
    {
        return this.getDataManager().get(FERTILE);
    }

    @Override
    public boolean isAttachedToHost()
    {
        return this.isRiding();
    }

    @Override
    public boolean canAttach(Entity entity)
    {
        if (entity instanceof EntityLivingBase)
        {
            return getImpregnationEntitiySelector().apply((EntityLivingBase) entity);
        }

        return false;
    }

    @Override
    public int getTicksOnHost()
    {
        return this.ticksOnHost;
    }

    @Override
    public int getDetachTime()
    {
        return (2 * 60) * 20;
    }

    @Override
    public Predicate<EntityLivingBase> getImpregnationEntitiySelector()
    {
        return EntityTrilobite.impregnationSelector;
    }

    @Override
    public Animation[] getAnimations()
    {
        return new Animation[] { IMPREGNATION_ANIMATION, ANIMATION_HUG_WALL };
    }
}
