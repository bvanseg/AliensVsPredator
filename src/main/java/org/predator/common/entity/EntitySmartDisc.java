package org.predator.common.entity;

import com.asx.mdx.lib.util.GameSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.AVP;
import org.avp.common.DamageSources;
import org.avp.common.ItemHandler;
import org.avp.common.entity.EntityProjectile;

public class EntitySmartDisc extends EntityProjectile
{
    public static final double RETURN_STRENGTH = 0.05D;
    public static final float MIN_FLOAT_STRENGTH = 0.7F;
    private float soundTimer;
    public float floatStrength;
    public Item thrownItem;
    public ItemStack stack;

    public EntitySmartDisc(World world)
    {
        super(world);
        this.thrownItem = AVP.items().itemDisc;
    }

    public EntitySmartDisc(World world, double posX, double posY, double posZ)
    {
        this(world);
        this.setPosition(posX, posY, posZ);
    }

    public EntitySmartDisc(World world, EntityLivingBase entityliving, ItemStack itemstack, float velocity)
    {
        this(world);
        this.shootingEntity = entityliving;
        this.setLocationAndAngles(entityliving.posX, entityliving.posY + entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.posY -= 0.1D;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionY = (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
        this.shoot(this.motionX, this.motionY, this.motionZ, velocity, 5.0F);
        this.soundTimer = 0.0F;
        this.floatStrength = Math.min(1.5F, velocity);
        System.out.println(this.floatStrength);
        itemstack = stack;
    }

    @Override
    public void entityInit()
    {
        super.entityInit();
    }

    public void setAim(Entity shooter, float pitch, float yaw, float velocity, float inaccuracy)
    {
        float motionX = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float motionY = -MathHelper.sin(pitch * 0.017453292F);
        float motionZ = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.shoot((double) motionX, (double) motionY, (double) motionZ, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;

        if (!shooter.onGround)
        {
            this.motionY += shooter.motionY;
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.inGround)
        {
            this.floatStrength *= 0.994F;

            if (this.floatStrength < 0.7F)
            {
                if (this.getIsCritical())
                {
                    this.setIsCritical(false);
                }

                this.floatStrength = 0.0F;
            }

            float limitedStrength = Math.min(1.0F, this.floatStrength);

            if (!this.beenInGround)
            {
                this.rotationYaw += 20.0F * this.floatStrength;
            }

            if (!this.beenInGround && this.shootingEntity != null && this.floatStrength > 0.0F)
            {
                double dx = this.posX - this.shootingEntity.posX;
                double dy = this.posY - this.shootingEntity.posY - this.shootingEntity.getEyeHeight();
                double dz = this.posZ - this.shootingEntity.posZ;
                double d = Math.sqrt(dx * dx + dy * dy + dz * dz);
                dx /= d;
                dy /= d;
                dz /= d;
                this.motionX -= 0.05D * dx;
                this.motionY -= 0.05D * dy;
                this.motionZ -= 0.05D * dz;
                this.soundTimer += limitedStrength;

                if (this.soundTimer > 3.0F)
                {
                    GameSounds.fxBow.playSound(this, 0.6F, 1.0F / (this.rand.nextFloat() * 0.2F + 2.2F - limitedStrength));;
                    this.soundTimer %= 3.0F;
                }
            }
        }
    }

    @Override
    public void onEntityHit(Entity entity)
    {
        if (!this.world.isRemote)
        {
            EntityPlayer player;

            if (entity != this.shootingEntity)
            {
                player = null;
                DamageSource damagesource;

                if (this.shootingEntity == null)
                {
                    damagesource = DamageSources.causeSmartDiscDamage(this);
                }
                else
                {
                    damagesource = DamageSources.causeSmartDiscDamage(this.shootingEntity);
                }

                if (entity.attackEntityFrom(damagesource, 5.0F))
                {
                    this.playHitSound();

                    if (this.thrownItem.getMaxDamage() + 1 <= this.thrownItem.getMaxDamage())
                    {
                        this.setVelocity(0.2D * this.rand.nextDouble() - 0.1D, 0.2D * this.rand.nextDouble() - 0.1D, 0.2D * this.rand.nextDouble() - 0.1D);
                    }
                }
                else
                {
                    this.bounce();
                }
            }
            else
            {
                if (entity instanceof EntityPlayer)
                {
                    player = (EntityPlayer) entity;
                    
                    GameSounds.fxPop.playSound(this, 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);;
                    this.onItemPickup(player);

                    if (!player.capabilities.isCreativeMode)
                        player.inventory.add(-1, stack == null ? new ItemStack(ItemHandler.itemDisc) : stack);
                    
                    this.setDead();
                    return;
                }
            }
        }
    }
    
    @Override
    public void onGroundHit(RayTraceResult result)
    {
        BlockPos pos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState blockstate = world.getBlockState(pos);
        this.xTile = (int) result.hitVec.x;
        this.yTile = (int) result.hitVec.y;
        this.zTile = (int) result.hitVec.z;
        this.inTile = blockstate.getBlock();
        this.motionX = ((float) (result.hitVec.x - this.posX));
        this.motionY = ((float) (result.hitVec.y - this.posY));
        this.motionZ = ((float) (result.hitVec.z - this.posZ));
        float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.posX -= this.motionX / f1 * 0.05D;
        this.posY -= this.motionY / f1 * 0.05D;
        this.posZ -= this.motionZ / f1 * 0.05D;
        this.motionX *= -this.rand.nextFloat() * 0.5F;
        this.motionZ *= -this.rand.nextFloat() * 0.5F;
        this.motionY = this.rand.nextFloat() * 0.1F;

        if (result.sideHit == EnumFacing.byIndex(1))
        {
            this.inGround = true;
        }
        else
        {
            this.inGround = false;
        }

        this.setIsCritical(false);
        this.beenInGround = true;
        this.floatStrength = 0.0F;
    }

    @Override
    public void playHitSound()
    {
        GameSounds.fxBowHit.playSound(this, 1.0F, 1.0F / (this.rand.nextFloat() * 0.4F + 0.9F));;
    }

    @Override
    public boolean aimRotation()
    {
        return this.beenInGround || this.floatStrength < 0.7F;
    }

    @Override
    public int getLifetime()
    {
        return 0;
    }

    @Override
    public boolean canBeCritical()
    {
        return true;
    }

    @Override
    public int getMaxArrowShake()
    {
        return 0;
    }

    @Override
    public float getGravity()
    {
        return !this.beenInGround && this.floatStrength >= 0.7F ? 0.0F : 0.05F;
    }

    @Override
    public float getAirResistance()
    {
        return 0.98F;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if (!this.world.isRemote)
        {
            if (this.inGround && entityplayer == this.shootingEntity && this.arrowShake <= 0)
            {
                if (entityplayer.inventory.addItemStackToInventory(new ItemStack(AVP.items().itemDisc, 1)))
                {
                    GameSounds.fxPop.playSound(this, 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);;
                    entityplayer.onItemPickup(this, 1);
                    this.setDead();
                }
            }
        }
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return null;
    }
}
