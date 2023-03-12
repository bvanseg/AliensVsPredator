package org.avp.common.entities;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Worlds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import org.avp.AVP;
import org.alien.common.entity.living.SpeciesXenomorph;

import java.util.List;

public class EntityGrenade extends EntityThrowable
{
    private static final DataParameter<Integer> FLAMING        = EntityDataManager.<Integer> createKey(EntityGrenade.class, DataSerializers.VARINT);
    public double                               velocity       = 0.9800000190734863D;
    public double                               velocityGround = 0.699999988079071D;
    public boolean                              explodeOnImpact;
    private int                                 fuse;

    public EntityGrenade(World world, EntityLivingBase shooter)
    {
        super(world, shooter);
        this.setAim(shooter, shooter.rotationPitch, shooter.rotationYaw, 0.0F, 1.2F, 0F);
    }

    public EntityGrenade(World world)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.fuse = 0;
        this.isImmuneToFire = true;
    }

    public void setAim(Entity shooter, float pitch, float yaw, float p_184547_4_, float velocity, float inaccuracy)
    {
        float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float f1 = -MathHelper.sin(pitch * 0.017453292F);
        float f2 = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.shoot((double) f, (double) f1, (double) f2, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;

        if (!shooter.onGround)
        {
            this.motionY += shooter.motionY;
        }
    }

    @Override
    protected void entityInit()
    {
        this.getDataManager().register(FLAMING, 0);
    }

    public void setFlaming(boolean flaming)
    {
        this.getDataManager().set(FLAMING, flaming ? 1 : 0);
    }

    public boolean isFlaming()
    {
        return this.getDataManager().get(FLAMING) == 1 ? true : false;
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.02999999910593033D;
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX *= velocity;
        this.motionY *= velocity;
        this.motionZ *= velocity;

        if (this.onGround)
        {
            this.motionX *= velocityGround;
            this.motionZ *= velocityGround;
            this.motionY *= -0.5D;
        }

        if (this.onGround)
        {
        	if (this.explodeOnImpact) {
        		this.explode();
        	}
        	
        	if (this.isBurning()) {
                this.fuse += 3;
        	}
        }

        if (this.fuse++ >= 50)
        {
            this.explode();
        }
        else
        {
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    @SuppressWarnings("unchecked")
    public void explode()
    {
        this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);
        this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
        
        if (!this.world.isRemote)
        {
        	Explosion explosion = Worlds.createExplosion(null, world, new Pos(this), 2F, isFlaming(), true, AVP.settings().areExplosionsEnabled());

            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(4, 4, 4));

            for (int idx = 0; idx < list.size(); ++idx)
            {
                Entity entity = list.get(idx);
                float targetDamage = entity instanceof SpeciesXenomorph ? 8F * 2 : 8F;
                entity.attackEntityFrom(DamageSource.causeExplosionDamage(explosion), targetDamage);
            }
        }

        this.setDead();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setByte("Fuse", (byte) this.fuse);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        this.fuse = tag.getByte("Fuse");
    }

    @Override
    protected void onImpact(RayTraceResult result)
    {
        ;
    }
}
