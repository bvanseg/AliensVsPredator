package org.alien.common.entity.living.species223ode;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.entity.animations.Animation;
import com.asx.mdx.common.minecraft.entity.animations.AnimationHandler;
import com.asx.mdx.common.minecraft.entity.animations.IAnimated;
import com.asx.mdx.internal.MDX;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.ai.brain.parasitoid.TrilobiteBrain;
import org.alien.common.entity.ai.selector.EntitySelectorTrilobite;
import org.alien.common.entity.living.Species223ODe;
import org.alien.common.world.Embryo;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.server.PacketAttachParasiteToEntity;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.EntityBrainContext;
import org.predator.common.item.ItemWristbracer;

import java.util.List;

public class EntityTrilobite extends Species223ODe implements Parasitoid, IAnimated, Brainiac<TrilobiteBrain>
{
    public static final Animation                      IMPREGNATION_ANIMATION = Animation.create(0);
    public static final Animation                      ANIMATION_HUG_WALL     = Animation.create(20 * 5);

    private static final DataParameter<Boolean>        FERTILE                = EntityDataManager.createKey(EntityTrilobite.class, DataSerializers.BOOLEAN);
    private static final DataParameter<NBTTagCompound> DETACHED_TENTACLES     = EntityDataManager.createKey(EntityTrilobite.class, DataSerializers.COMPOUND_TAG);
    private int                                        ticksOnHost            = 0;

    private TrilobiteBrain brain;

    public EntityTrilobite(World world)
    {
        super(world);
        this.setSize(3F, 1.98F);
        this.experienceValue = 32;
        this.jumpMovementFactor = 1.0F;
    }

    @Override
    public TrilobiteBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new TrilobiteBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
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

        NBTTagCompound tagDetachedTentacles = new NBTTagCompound();
        tagDetachedTentacles.setIntArray("Tentacles", new int[this.getAmountOfTentacles()]);
        this.getDataManager().register(DETACHED_TENTACLES, tagDetachedTentacles);
    }
    
    @Override
    public void updatePassenger(Entity passenger)
    {
        super.updatePassenger(passenger);
    }

    private void updateHitbox()
    {
        if (this.world.getTotalWorldTime() % 20 == 0)
        {
            if (!this.isFertile() && this.getRidingEntity() == null)
            {
                this.height = 0.5F;
            }
            
            if (!this.isFertile() && this.getRidingEntity() != null)
            {
                this.height = 3F;
            }

            int[] tentacles = this.getDetachedTentacles();
            boolean hasAllTentacles = true;

            for (int i = 0; i < this.getAmountOfTentacles(); i++)
            {
                if (tentacles[i] == 1)
                {
                    hasAllTentacles = false;
                }
            }

            if (!hasAllTentacles)
            {
                this.width = 2;
            }
        }
    }
    
    @Override
    protected void updateAnimations()
    {
        super.updateAnimations();

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
        
        if(this.getActiveAnimation() == IMPREGNATION_ANIMATION && this.getAnimationTick() == 95)
        {
            AlienSounds.FACEHUGGER_IMPLANT.playSound(this, 1F, 1F);
        }

        if (this.getRidingEntity() == null && this.getActiveAnimation() == IMPREGNATION_ANIMATION)
        {
            this.setActiveAnimation(NO_ANIMATION);
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update(new EntityBrainContext(this.getBrain(), this));
        }

        this.updateHitbox();
        this.negateFallDamage();
        this.slideUpSurface();

        if (this.getAttackTarget() != null)
        {
            if (this.world.getTotalWorldTime() % 5 == 0)
            {
                if (!EntitySelectorTrilobite.instance.test(this.getAttackTarget()))
                {
                    this.setAttackTarget(null);
                }
            }
        }

        this.handleInfertileState();
    }

    private void slideUpSurface()
    {
        if (this.collidedHorizontally)
        {
            this.motionY += 0.25F;
        }
    }

    private void handleInfertileState()
    {
        if (!this.isFertile())
        {
            this.setNoAI(true);

            this.motionY -= 0.25F;

            this.motionX *= 0.98F;
            this.motionY *= 0.98F;
            this.motionZ *= 0.98F;
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        }

        if (this.isAttachedToHost())
        {
            this.ticksOnHost++;

            if (this.getRidingEntity() instanceof EntityLiving)
            {
                EntityLiving living = (EntityLiving) this.getRidingEntity();

                living.setNoAI(true);
                
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
        return AlienSounds.FACEHUGGER_HURT.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.CHESTBURSTER_BURST.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return AlienSounds.FACEHUGGER_LIVING.event();
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
        return potionEffect.getPotion() != MobEffects.POISON && super.isPotionApplicable(potionEffect);
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
        list.forEach(this::collideWithEntity);
    }

    @Override
    public void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);

        if (!this.world.isRemote && this.isFertile() && this.canAttach(entity))
        {
            AVPNetworking.instance.sendToAll(new PacketAttachParasiteToEntity(this.getEntityId(), entity.getEntityId()));
            this.attachToEntity(entity);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        Parasitoid.readFromNBT(this, nbt);

        this.setDetachedTentacles(nbt.getIntArray("Tentacles"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt.setTag("Tentacles", new NBTTagIntArray(this.getDetachedTentacles()));

        Parasitoid.writeToNBT(this, nbt);
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
        OrganismImpl organism = (OrganismImpl) target.getCapability(Provider.CAPABILITY, null);
        organism.impregnate(Embryo.DEACON);
        organism.syncWithClients(target);
        this.setFertility(false);
    }

    @Override
    public void detachFromHost()
    {
        if(!(this.getRidingEntity() instanceof EntityPlayer) && this.getRidingEntity() instanceof EntityLivingBase)
            ((EntityLiving) this.getRidingEntity()).setNoAI(false);
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
    public boolean hitByEntity(Entity entity)
    {
        if (!this.isFertile() && this.getRidingEntity() == null)
        {
            if (entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) entity;
                ItemStack held = player.getHeldItemMainhand();

                if (held != null)
                {
                    if (held.getItem() instanceof ItemSword || held.getItem() instanceof ItemAxe || ItemWristbracer.equippedHasBlades(player))
                    {
                        this.detachTentacle();
                    }
                }
            }
        }

        return super.hitByEntity(entity);
    }

    public void dropTentacle()
    {
        this.dropItem(AlienItems.ITEM_RAW_TENTACLE, 1);
    }

    public int getAmountOfTentacles()
    {
        return 7;
    }

    public void detachTentacle()
    {
        int qty = getAmountOfTentacles();
        int[] tentacles = this.getDetachedTentacles();

        if (tentacles == null || tentacles != null && tentacles.length < qty)
        {
            tentacles = new int[qty];
        }

        this.detachNextTentacleRandomly(tentacles, qty, -1);
        this.setDetachedTentacles(tentacles);
    }

    private int[] detachNextTentacleRandomly(int[] tentacles, int qty, int idx)
    {
        int randTentacle = this.rand.nextInt(qty);
        boolean canContinue = false;

        for (int t = 0; t < qty; t++)
        {
            if (tentacles[t] == 0)
            {
                canContinue = true;
                break;
            }
        }

        if (canContinue)
        {
            if (randTentacle != idx)
            {
                if (tentacles[randTentacle] == 0)
                {
                    tentacles[randTentacle] = 1;

                    if (!this.world.isRemote)
                    {
                        this.dropTentacle();
                    }

                    return tentacles;
                }
                else
                {
                    detachNextTentacleRandomly(tentacles, qty, randTentacle);
                }
            }
            else
            {
                detachNextTentacleRandomly(tentacles, qty, randTentacle);
            }
        }

        return tentacles;
    }

    public void setDetachedTentacles(int[] tentacles)
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("Tentacles", new NBTTagIntArray(tentacles));

        this.getDataManager().set(DETACHED_TENTACLES, tag);
    }

    public int[] getDetachedTentacles()
    {
        return this.getDataManager().get(DETACHED_TENTACLES).getIntArray("Tentacles");
    }

    @Override
    public void setFertility(boolean fertility)
    {
        this.getDataManager().set(FERTILE, fertility);
    }

    @Override
    public boolean isFertile()
    {
        return this.getDataManager().get(FERTILE).booleanValue();
    }

    @Override
    public boolean isAttachedToHost()
    {
        return this.isRiding();
    }

    @Override
    public boolean canAttach(Entity entity)
    {
        return (entity instanceof EntityLivingBase) && EntitySelectorTrilobite.instance.test((EntityLivingBase) entity);
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
    public Animation[] getAnimations()
    {
        return new Animation[] { IMPREGNATION_ANIMATION, ANIMATION_HUG_WALL };
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_TRILOBITE);
    }
    
    public SoundEvent getImplantSound()
    {
        return AlienSounds.FACEHUGGER_IMPLANT.event();
    }
}
