package org.avp.entities.living.species.xenomorphs;

import org.avp.EntityItemDrops;
import org.avp.ItemHandler;
import org.avp.api.parasitoidic.IHost;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.alien.EntitySelectorDracomorph;
import org.avp.entities.ai.PatchedEntityAIWander;
import org.avp.entities.living.species.SpeciesAlien;

import com.asx.mdx.lib.world.Pos;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDracomorph extends SpeciesAlien implements IMob, IHost
{
    private static final DataParameter<Integer> FLYING = EntityDataManager.createKey(EntityDracomorph.class, DataSerializers.VARINT);
    private BlockPos flyToPosition;

    public EntityDracomorph(World world)
    {
        super(world);
        this.experienceValue = 150;
        this.setSize(4, 7);
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, EntityCreature.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new PatchedEntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityCreature.class, 0, true, false, EntitySelectorDracomorph.instance));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, 0, true, false, EntitySelectorDracomorph.instance));

        this.getDataManager().register(FLYING, 0);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45199999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32D);
    }

    @Override
    public boolean canParasiteAttach()
    {
        return this.canHostParasite();
    }
    
    @Override
    public boolean canHostParasite()
    {
        return false;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.fallDistance = 0F;

        if (!this.world.isRemote)
        {
            if (isFlying())
            {
                this.motionY *= 0.5000000238418579D;
            }

            if (this.getAttackTarget() != null && this.getDistance(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ) <= 12)
            {
                this.getDataManager().set(FLYING, 0);
            }
            else if (this.getAttackTarget() == null && this.rand.nextInt(30) == 0)
            {
                this.getDataManager().set(FLYING, 1);
            }

            if (this.flyToPosition != null && (!this.world.isAirBlock(this.flyToPosition) || this.flyToPosition.getY() < 1))
            {
                this.flyToPosition = null;
            }
            
            if (this.flyToPosition == null || this.rand.nextInt(30) == 0 || Pos.distanceSq(flyToPosition.getX(), flyToPosition.getY(), flyToPosition.getZ(), (int) this.posX, (int) this.posY, (int) this.posZ) < 4.0F)
            {
                if (this.getAttackTarget() != null)
                {
                    this.flyToPosition = new BlockPos((int) this.getAttackTarget().posX, (int) this.getAttackTarget().posY, (int) this.getAttackTarget().posZ);
                }
                else
                {
                    this.flyToPosition = new BlockPos((int) this.posX + this.rand.nextInt(16) - this.rand.nextInt(16), (int) this.posY + this.rand.nextInt(14) - this.rand.nextInt(16), (int) this.posZ + this.rand.nextInt(16) - this.rand.nextInt(16));
                }
            }

            if (this.isFlying())
            {
                double d0 = (double) this.flyToPosition.getX() + 0.5D - this.posX;
                double d1 = (double) this.flyToPosition.getY() + 0.1D - this.posY;
                double d2 = (double) this.flyToPosition.getZ() + 0.5D - this.posZ;
                this.motionX += (Math.signum(d0) * 0.65D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(d1) * 2.199999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(d2) * 0.65D - this.motionZ) * 0.10000000149011612D;
                float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += f1;
            }
        }
    }

    public boolean isFlying()
    {
        return this.getDataManager().get(FLYING) == 0 ? false : true;
    }

    @Override
    public int getTotalArmorValue()
    {
        return 6;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return null;
    }
    
    @Override
    protected void despawnEntity()
    {
        ;
    }

    @Override
    public void onDeath(DamageSource source)
    {
        super.onDeath(source);

        switch (this.rand.nextInt(4))
        {
            case 0:
                EntityItemDrops.SKULL_ENGINEER.tryDrop(this);
            case 1:
                EntityItemDrops.SKULL_SPACEJOCKEY.tryDrop(this);
            case 2:
                EntityItemDrops.SKULL_PREDATOR.tryDrop(this);
            case 3:
                EntityItemDrops.SKULL_XENO_DRONE.tryDrop(this);
            case 4:
                EntityItemDrops.SKULL_XENO_WARRIOR.tryDrop(this);
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.Experimental.summonerDracomorph);
    }
}
