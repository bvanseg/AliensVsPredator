package org.alien.common.entity;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.common.AVPDamageSources;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class EntityAcidProjectile extends Entity implements IProjectile {
    private static final Predicate<Entity> ARROW_TARGETS;
    private static final DataParameter<Byte> CRITICAL;

    static {
        ARROW_TARGETS = Predicates.and(new Predicate[]{EntitySelectors.NOT_SPECTATING, EntitySelectors.IS_ALIVE, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity p_apply_1_) {
                return p_apply_1_.canBeCollidedWith();
            }
        }});
        CRITICAL = EntityDataManager.createKey(EntityArrow.class, DataSerializers.BYTE);
    }

    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    private int inData;
    protected boolean inGround;
    protected int timeInGround;
    public EntityArrow.PickupStatus pickupStatus;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage;
    private int knockbackStrength;

    public EntityAcidProjectile(World worldIn) {
        super(worldIn);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
        this.damage = 2.0;
        this.setSize(0.5F, 0.5F);
    }

    public EntityAcidProjectile(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    public EntityAcidProjectile(World worldIn, EntityLivingBase shooter) {
        this(worldIn, shooter.posX, shooter.posY + shooter.getEyeHeight() - 0.10000000149011612, shooter.posZ);
        this.shootingEntity = shooter;
        if (shooter instanceof EntityPlayer) {
            this.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        double d0 = this.getEntityBoundingBox().getAverageEdgeLength() * 10.0;
        if (Double.isNaN(d0)) {
            d0 = 1.0;
        }

        d0 = d0 * 64.0 * getRenderDistanceWeight();
        return distance < d0 * d0;
    }

    protected void entityInit() {
        this.dataManager.register(CRITICAL, (byte)0);
    }

    public void shoot(Entity shooter, float pitch, float yaw, float velocity, float inaccuracy) {
        float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float f1 = -MathHelper.sin(pitch * 0.017453292F);
        float f2 = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.shoot(f, f1, f2, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;
        if (!shooter.onGround) {
            this.motionY += shooter.motionY;
        }
    }

    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        float f = MathHelper.sqrt(x * x + y * y + z * z);
        x /= f;
        y /= f;
        z /= f;
        x += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        y += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        z += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        x *= velocity;
        y *= velocity;
        z *= velocity;
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        float f1 = MathHelper.sqrt(x * x + z * z);
        this.rotationYaw = (float)(MathHelper.atan2(x, z) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(y, f1) * 57.29577951308232);
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.ticksInGround = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        this.setPosition(x, y, z);
        this.setRotation(yaw, pitch);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z) {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt(x * x + z * z);
            this.rotationPitch = (float)(MathHelper.atan2(y, f) * 57.29577951308232);
            this.rotationYaw = (float)(MathHelper.atan2(x, z) * 57.29577951308232);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }

    }

    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote && this.inGround) {
            this.setDead();
        }

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
            this.rotationPitch = (float)(MathHelper.atan2(this.motionY, f) * 57.29577951308232);
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }

        BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        if (iblockstate.getMaterial() != Material.AIR) {
            AxisAlignedBB axisalignedbb = iblockstate.getCollisionBoundingBox(this.world, blockpos);
            if (axisalignedbb != Block.NULL_AABB && axisalignedbb.offset(blockpos).contains(new Vec3d(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0) {
            --this.arrowShake;
        }

        if (this.inGround) {
            int j = block.getMetaFromState(iblockstate);
            if ((block != this.inTile || j != this.inData) && !this.world.collidesWithAnyBlock(this.getEntityBoundingBox().grow(0.05))) {
                this.inGround = false;
                this.motionX *= (this.rand.nextFloat() * 0.2F);
                this.motionY *= (this.rand.nextFloat() * 0.2F);
                this.motionZ *= (this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            } else {
                ++this.ticksInGround;
                if (this.ticksInGround >= 1200) {
                    this.setDead();
                }
            }

            ++this.timeInGround;
        } else {
            this.timeInGround = 0;
            ++this.ticksInAir;
            Vec3d vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
            vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
            vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (raytraceresult != null) {
                vec3d = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
            }

            Entity entity = this.findEntityOnPath(vec3d1, vec3d);
            if (entity != null) {
                raytraceresult = new RayTraceResult(entity);
            }

            if (raytraceresult != null && raytraceresult.entityHit instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer)raytraceresult.entityHit;
                if (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)) {
                    raytraceresult = null;
                }
            }

            if (raytraceresult != null && !ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
                this.onHit(raytraceresult);
            }

            if (this.getIsCritical()) {
                for(int k = 0; k < 4; ++k) {
                    this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX + this.motionX * k / 4.0, this.posY + this.motionY * k / 4.0, this.posZ + this.motionZ * k / 4.0, -this.motionX, -this.motionY + 0.2, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f4 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);

            for(this.rotationPitch = (float)(MathHelper.atan2(this.motionY, f4) * 57.29577951308232); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
            }

            while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
                this.prevRotationPitch += 360.0F;
            }

            while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
                this.prevRotationYaw -= 360.0F;
            }

            while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f1 = 0.99F;
            if (this.isInWater()) {
                for(int i = 0; i < 4; ++i) {
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ, new int[0]);
                }

                f1 = 0.6F;
            }

            if (this.isWet()) {
                this.extinguish();
            }

            this.motionX *= f1;
            this.motionY *= f1;
            this.motionZ *= f1;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.05000000074505806;
            }

            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();
        }

    }

    protected void onHit(RayTraceResult raytraceResultIn) {
        Entity entity = raytraceResultIn.entityHit;
        if (entity != null) {
            float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            int i = MathHelper.ceil(f * this.damage);
            if (this.getIsCritical()) {
                i += this.rand.nextInt(i / 2 + 2);
            }

            DamageSource damagesource;

            if (this.shootingEntity == null)
            {
                damagesource = AVPDamageSources.ACID_PROJECTILE;
            }
            else
            {
                damagesource = AVPDamageSources.causeAcidicProjectileDamage(this, this.shootingEntity);
            }

            if (this.isBurning() && !(entity instanceof EntityEnderman)) {
                entity.setFire(5);
            }

            if (entity.attackEntityFrom(damagesource, i)) {
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)entity;
                    if (!this.world.isRemote) {
                        entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
                    }

                    if (this.knockbackStrength > 0) {
                        float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                        if (f1 > 0.0F) {
                            entitylivingbase.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579 / f1, 0.1, this.motionZ * this.knockbackStrength * 0.6000000238418579 / f1);
                        }
                    }

                    if (this.shootingEntity instanceof EntityLivingBase) {
                        EnchantmentHelper.applyThornEnchantments(entitylivingbase, this.shootingEntity);
                        EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase)this.shootingEntity, entitylivingbase);
                    }

                    this.acidHit(entitylivingbase);
                    if (this.shootingEntity != null && entitylivingbase != this.shootingEntity && entitylivingbase instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                        ((EntityPlayerMP)this.shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
                    }
                }

//                this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                if (!(entity instanceof EntityEnderman)) {
                    this.setDead();
                }
            } else {
                this.motionX *= -0.10000000149011612;
                this.motionY *= -0.10000000149011612;
                this.motionZ *= -0.10000000149011612;
                this.rotationYaw += 180.0F;
                this.prevRotationYaw += 180.0F;
                this.ticksInAir = 0;
                if (!this.world.isRemote && this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ < 0.0010000000474974513) {
                    if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED) {
                        this.entityDropItem(this.getArrowStack(), 0.1F);
                    }

                    this.setDead();
                }
            }
        } else {
            BlockPos blockpos = raytraceResultIn.getBlockPos();
            this.xTile = blockpos.getX();
            this.yTile = blockpos.getY();
            this.zTile = blockpos.getZ();
            IBlockState iblockstate = this.world.getBlockState(blockpos);
            this.inTile = iblockstate.getBlock();
            this.inData = this.inTile.getMetaFromState(iblockstate);
            this.motionX = ((float)(raytraceResultIn.hitVec.x - this.posX));
            this.motionY = (float)(raytraceResultIn.hitVec.y - this.posY);
            this.motionZ = ((float)(raytraceResultIn.hitVec.z - this.posZ));
            float f2 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.posX -= this.motionX / f2 * 0.05000000074505806;
            this.posY -= this.motionY / f2 * 0.05000000074505806;
            this.posZ -= this.motionZ / f2 * 0.05000000074505806;
//            this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
            this.inGround = true;
            this.arrowShake = 7;
            this.setIsCritical(false);
            if (iblockstate.getMaterial() != Material.AIR) {
                this.inTile.onEntityCollision(this.world, blockpos, iblockstate, this);
            }
        }

    }

    @Override
    public void move(MoverType type, double x, double y, double z) {
        super.move(type, x, y, z);
        if (this.inGround) {
            this.xTile = MathHelper.floor(this.posX);
            this.yTile = MathHelper.floor(this.posY);
            this.zTile = MathHelper.floor(this.posZ);
        }
    }

    protected void acidHit(EntityLivingBase living) {
        living.addPotionEffect(new PotionEffect(MobEffects.POISON, (14 * 20), 0));
    }

    @Nullable
    protected Entity findEntityOnPath(Vec3d start, Vec3d end) {
        Entity entity = null;
        List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(1.0), ARROW_TARGETS);
        double d0 = 0.0;

        for (Entity value : list) {
            if (value != this.shootingEntity || this.ticksInAir >= 5) {
                AxisAlignedBB axisalignedbb = value.getEntityBoundingBox().grow(0.30000001192092896);
                RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(start, end);
                if (raytraceresult != null) {
                    double d1 = start.squareDistanceTo(raytraceresult.hitVec);
                    if (d1 < d0 || d0 == 0.0) {
                        entity = value;
                        d0 = d1;
                    }
                }
            }
        }

        return entity;
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("xTile", this.xTile);
        compound.setInteger("yTile", this.yTile);
        compound.setInteger("zTile", this.zTile);
        compound.setShort("life", (short)this.ticksInGround);
        ResourceLocation resourcelocation = (ResourceLocation)Block.REGISTRY.getNameForObject(this.inTile);
        compound.setString("inTile", resourcelocation == null ? "" : resourcelocation.toString());
        compound.setByte("inData", (byte)this.inData);
        compound.setByte("shake", (byte)this.arrowShake);
        compound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        compound.setByte("pickup", (byte)this.pickupStatus.ordinal());
        compound.setDouble("damage", this.damage);
        compound.setBoolean("crit", this.getIsCritical());
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        this.xTile = compound.getInteger("xTile");
        this.yTile = compound.getInteger("yTile");
        this.zTile = compound.getInteger("zTile");
        this.ticksInGround = compound.getShort("life");
        if (compound.hasKey("inTile", 8)) {
            this.inTile = Block.getBlockFromName(compound.getString("inTile"));
        } else {
            this.inTile = Block.getBlockById(compound.getByte("inTile") & 255);
        }

        this.inData = compound.getByte("inData") & 255;
        this.arrowShake = compound.getByte("shake") & 255;
        this.inGround = compound.getByte("inGround") == 1;
        if (compound.hasKey("damage", 99)) {
            this.damage = compound.getDouble("damage");
        }

        if (compound.hasKey("pickup", 99)) {
            this.pickupStatus = EntityArrow.PickupStatus.getByOrdinal(compound.getByte("pickup"));
        } else if (compound.hasKey("player", 99)) {
            this.pickupStatus = compound.getBoolean("player") ? EntityArrow.PickupStatus.ALLOWED : EntityArrow.PickupStatus.DISALLOWED;
        }

        this.setIsCritical(compound.getBoolean("crit"));
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {
        if (!this.world.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean flag = this.pickupStatus == EntityArrow.PickupStatus.ALLOWED || this.pickupStatus == EntityArrow.PickupStatus.CREATIVE_ONLY && entityIn.capabilities.isCreativeMode;
            if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED && !entityIn.inventory.addItemStackToInventory(this.getArrowStack())) {
                flag = false;
            }

            if (flag) {
                entityIn.onItemPickup(this, 1);
                this.setDead();
            }
        }

    }

    protected ItemStack getArrowStack() {
        return ItemStack.EMPTY;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    public void setDamage(double damageIn) {
        this.damage = damageIn;
    }

    public double getDamage() {
        return this.damage;
    }

    public void setKnockbackStrength(int knockbackStrengthIn) {
        this.knockbackStrength = knockbackStrengthIn;
    }

    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }

    @Override
    public float getEyeHeight() {
        return 0.0F;
    }

    public void setIsCritical(boolean critical) {
        byte b0 = this.dataManager.get(CRITICAL);
        if (critical) {
            this.dataManager.set(CRITICAL, (byte)(b0 | 1));
        } else {
            this.dataManager.set(CRITICAL, (byte)(b0 & -2));
        }

    }

    public boolean getIsCritical() {
        byte b0 = this.dataManager.get(CRITICAL);
        return (b0 & 1) != 0;
    }
}
