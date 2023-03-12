package org.avp.common.entity;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.block.Blocks;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.common.AVPBlocks;
import org.avp.common.DamageSources;
import org.avp.common.item.firearm.ItemFlamethrower;
import org.avp.common.item.firearm.ItemM240IncineratorUnit;
import org.avp.common.item.firearm.ItemSevastopolFlamethrower;
import org.avp.common.tile.TileEntityCryostasisTube;

import java.util.ArrayList;

public class EntityFlame extends EntityThrowable
{
    protected int    flameLife;
    protected int    flameIntensity;
    protected int    flameSpread;
    protected double flameTailWidth;

    public EntityFlame(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
        this.flameLife = 25;
        this.flameSpread = 1;
        this.flameIntensity = 60;
        this.flameTailWidth = 0.02;
        this.setAim(entityLivingBase, entityLivingBase.rotationPitch, entityLivingBase.rotationYaw, 0.0F, 3.0F, 0F);
    }

    public EntityFlame(World world)
    {
        super(world);
        this.flameLife = 25;
        this.flameSpread = 1;
        this.flameIntensity = 60;
        this.flameTailWidth = 0.02;
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
        super.entityInit();

        if (this.getThrower() != null && this.getThrower().getHeldItemMainhand() != null)
        {
            if (this.getThrower().getHeldItemMainhand().getItem() == AVP.items().itemM240ICU || this.getThrower().getHeldItemMainhand().getItem() == AVP.items().itemSevastopolFlamethrower)
            {
                ItemFlamethrower flamethrower = (ItemFlamethrower) this.getThrower().getHeldItemMainhand().getItem();

                if (flamethrower instanceof ItemM240IncineratorUnit)
                {
                    this.flameLife = 30;
                    this.flameSpread = 1;
                }

                if (flamethrower instanceof ItemSevastopolFlamethrower)
                {
                    this.flameLife = 12;
                    this.flameSpread = 2;
                    this.flameTailWidth = 0.6;
                }
            }
        }
    }

    @Override
    public void onUpdate()
    {
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        RayTraceResult result = this.world.rayTraceBlocks(new Vec3d(this.posX - 1, this.posY, this.posZ - 1), new Vec3d(this.posX - 1 + this.motionX, this.posY + this.motionY, this.posZ - 1 + this.motionZ));

        if (!this.world.isRemote)
        {
            Entity entityHit = Entities.getEntityInCoordsRange(world, EntityLiving.class, new Pos(this), flameSpread, flameSpread);

            if (entityHit != null && !entityHit.isImmuneToFire())
            {
                entityHit.setFire(10);
                entityHit.attackEntityFrom(DamageSources.causeFlamethrowerDamage(this), 4F);
            }
        }

        if (result != null)
        {
            this.onImpact(result);
        }

        if (this.ticksExisted >= flameLife)
        {
            this.setDead();
        }

        if (this.world.isRemote)
        {
            for (int x = flameIntensity; x > 0; --x)
            {
                double flameX = 0;
                double flameY = 0;
                double flameZ = 0;

                for (int r = 3; r > 0; r--)
                {
                    flameX = flameX + (this.rand.nextDouble() / (flameLife - this.ticksExisted));
                    flameY = flameY + (this.rand.nextDouble() / (flameLife - this.ticksExisted));
                    flameZ = flameZ + (this.rand.nextDouble() / (flameLife - this.ticksExisted));
                }

                this.spawnFlameParticle(flameX, flameY, flameZ, 0.04F);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void spawnFlameParticle(double flameX, double flameY, double flameZ, float flameGravity)
    {
        Game.minecraft().world.spawnParticle(EnumParticleTypes.FLAME, this.posX - (flameX / 2), this.posY - (flameY / 2), this.posZ - (flameZ / 2), this.rand.nextGaussian() * flameTailWidth, -this.motionY * (flameGravity * this.ticksExisted) - this.rand.nextGaussian() * flameTailWidth, this.rand.nextGaussian() * flameTailWidth);
    }

    @Override
    protected void onImpact(RayTraceResult result)
    {
        int posX = (int) result.hitVec.x;
        int posY = (int) result.hitVec.y;
        int posZ = (int) result.hitVec.z;

        if (!this.world.isRemote)
        {
             switch (result.sideHit)
             {
             case DOWN:
             --posY;
             break;
            
             case UP:
             break;
            
             case NORTH:
             --posZ;
             break;
            
             case SOUTH:
             ++posZ;
             break;
            
             case WEST:
             --posX;
             break;
            
             case EAST:
             ++posX;
             }
        }

        if (rand.nextInt(10) == 0)
        {
            ArrayList<Pos> list = Blocks.getCoordDataInRangeIncluding((int) result.hitVec.x, (int) result.hitVec.y, (int) result.hitVec.z, 1, this.world, AVPBlocks.CRYO_TUBE);

            for (Pos coord : list)
            {
                TileEntity tile = coord.getTileEntity(this.world);

                if (tile instanceof TileEntityCryostasisTube)
                {
                    TileEntityCryostasisTube tube = (TileEntityCryostasisTube) tile;
                    tube.setCracked(true);

                    if (tube.isCracked())
                    {
                        tube.setShattered(true);
                    }
                }
            }
        }

        if (this.getThrower() != null && this.getThrower().getHeldItemMainhand() != null)
        {
            if (this.getThrower().getHeldItemMainhand() != null && this.getThrower().getHeldItemMainhand().getItem() instanceof ItemFlamethrower)
            {
                ItemFlamethrower flamethrower = (ItemFlamethrower) this.getThrower().getHeldItemMainhand().getItem();

                this.setFire(posX, posY, posZ);

                if (flamethrower instanceof ItemSevastopolFlamethrower)
                {
                    ArrayList<Pos> coords = Blocks.getCoordDataInRange(posX, posY, posZ, 1);

                    for (Pos pos : coords)
                    {
                        this.setFire((int) pos.x, (int) pos.y, (int) pos.z);
                    }

                     this.setFire(posX + 1, posY, posZ);
                     this.setFire(posX - 1, posY, posZ);
                     this.setFire(posX, posY, posZ + 1);
                     this.setFire(posX, posY, posZ - 1);
                }
            }
        }

        this.setDead();
    }

    public void setFire(int posX, int posY, int posZ)
    {
        Block block = this.world.getBlockState(new BlockPos(posX, posY, posZ)).getBlock();

        if (block == net.minecraft.init.Blocks.AIR)
        {
            this.world.setBlockState(new BlockPos(posX, posY, posZ), net.minecraft.init.Blocks.FIRE.getDefaultState());
        }
    }
}
