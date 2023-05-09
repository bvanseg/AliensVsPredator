package org.alien.common.entity.living.species223ode;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.entity.animations.Animation;
import com.asx.mdx.common.minecraft.entity.animations.AnimationHandler;
import com.asx.mdx.common.minecraft.entity.animations.IAnimated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.parasitoid.TrilobiteBrain;
import org.alien.common.entity.ai.selector.EntitySelectorTrilobite;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.entity.living.helper.TrilobiteAnimationController;
import org.alien.common.entity.living.helper.TrilobiteTentacleHelper;

import java.util.List;

/**
 * @author Ri5ux
 */
public class EntityTrilobite extends EntityParasitoid implements IAnimated
{
    public static final DataParameter<NBTTagCompound> DETACHED_TENTACLES = EntityDataManager.createKey(EntityTrilobite.class, DataSerializers.COMPOUND_TAG);

    private TrilobiteTentacleHelper tentacleHelper;
    private final TrilobiteAnimationController animationController;

    public EntityTrilobite(World world)
    {
        super(world);
        this.setSize(3F, 1.98F);
        this.experienceValue = 32;
        this.jumpMovementFactor = 1.0F;

        this.animationController = new TrilobiteAnimationController();
    }

    @Override
    public TrilobiteBrain getBrain() {
        return (TrilobiteBrain) super.getBrain();
    }

    @Override
    public TrilobiteBrain createNewBrain() {
        return new TrilobiteBrain(this);
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
        this.tentacleHelper = new TrilobiteTentacleHelper();
        NBTTagCompound tagDetachedTentacles = new NBTTagCompound();
        tagDetachedTentacles.setIntArray("Tentacles", new int[this.tentacleHelper.getAmountOfTentacles()]);
        this.getDataManager().register(DETACHED_TENTACLES, tagDetachedTentacles);
    }

    @Override
    protected void updateAnimations()
    {
        super.updateAnimations();
        animationController.update(this);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.tentacleHelper.updateHitbox(this);
        this.slideUpSurface();
    }

    private void slideUpSurface()
    {
        if (this.collidedHorizontally)
        {
            this.motionY += 0.25F;
        }
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

    @Override
    protected void collideWithNearbyEntities()
    {
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
        list.forEach(this::collideWithEntity);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.tentacleHelper.setDetachedTentacles(this, nbt.getIntArray("Tentacles"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt.setTag("Tentacles", new NBTTagIntArray(this.getDetachedTentacles()));
        return super.writeToNBT(nbt);
    }

    /* Parasitoid implementation */

    @Override
    public void attachToEntity(Entity target)
    {
        if (Entities.getEntityRiddenBy(target) == null && target instanceof EntityLivingBase)
        {
            EntityLivingBase living = (EntityLivingBase) target;

            AnimationHandler.INSTANCE.sendAnimationMessage(this, TrilobiteAnimationController.IMPREGNATION_ANIMATION);
            this.startRiding(living);
            this.implantEmbryo(living);
        }
    }

    @Override
    public boolean hitByEntity(Entity entity)
    {
        this.tentacleHelper.onHitByEntity(this, entity);
        return super.hitByEntity(entity);
    }

    public int[] getDetachedTentacles()
    {
        return this.getDataManager().get(DETACHED_TENTACLES).getIntArray("Tentacles");
    }

    @Override
    public boolean canAttach(Entity entity)
    {
        return (entity instanceof EntityLivingBase) && EntitySelectorTrilobite.instance.test(entity);
    }

    @Override
    public Animation[] getAnimations()
    {
        return this.animationController.getAnimations();
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_TRILOBITE);
    }

    public TrilobiteTentacleHelper getTentacleHelper() {
        return this.tentacleHelper;
    }

    @Override
    protected void spawnAcidPool() { /* Do nothing */ }
}
