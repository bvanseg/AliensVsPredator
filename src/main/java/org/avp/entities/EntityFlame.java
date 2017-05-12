package org.avp.entities;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.item.ItemFlamethrower;
import org.avp.item.ItemM240IncineratorUnit;
import org.avp.item.ItemNostromoFlamethrower;
import org.avp.tile.TileEntityCryostasisTube;

import com.arisux.mdxlib.lib.game.Game;
import com.arisux.mdxlib.lib.world.Pos;
import com.arisux.mdxlib.lib.world.block.Blocks;
import com.arisux.mdxlib.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFlame extends EntityThrowable
{
    protected int flameLife;
    protected int flameIntensity;
    protected int flameSpread;
    protected double flameTailWidth;

    public EntityFlame(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
        this.flameLife = 25;
        this.flameSpread = 1;
        this.flameIntensity = 60;
        this.flameTailWidth = 0.02;
    }

    public EntityFlame(World world)
    {
        super(world);
        this.flameLife = 25;
        this.flameSpread = 1;
        this.flameIntensity = 60;
        this.flameTailWidth = 0.02;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();

        if (this.getThrower() != null && this.getThrower().getHeldItemMainhand() != null)
        {
            if (this.getThrower().getHeldItemMainhand().getItem() == AliensVsPredator.items().itemM240ICU || this.getThrower().getHeldItemMainhand().getItem() == AliensVsPredator.items().itemNostromoFlamethrower)
            {
                ItemFlamethrower flamethrower = (ItemFlamethrower) this.getThrower().getHeldItemMainhand().getItem();

                if (flamethrower instanceof ItemM240IncineratorUnit)
                {
                    this.flameLife = 30;
                    this.flameSpread = 1;
                }

                if (flamethrower instanceof ItemNostromoFlamethrower)
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
        this.move(this.motionX, this.motionY, this.motionZ);
        RayTraceResult result = this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY, this.posZ), new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ));

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
        int posX = (int)result.hitVec.xCoord;
        int posY = (int)result.hitVec.yCoord;
        int posZ = (int)result.hitVec.zCoord;

        if (!this.world.isRemote)
        {
            switch (result.sideHit.ordinal())
            {
                case 0:
                    --posY;
                    break;

                case 1:
                    ++posY;
                    break;

                case 2:
                    --posZ;
                    break;

                case 3:
                    ++posZ;
                    break;

                case 4:
                    --posX;
                    break;

                case 5:
                    ++posX;
            }
        }

        if (rand.nextInt(10) == 0)
        {
            ArrayList<Pos> list = Blocks.getCoordDataInRangeIncluding((int)result.hitVec.xCoord, (int)result.hitVec.yCoord, (int)result.hitVec.zCoord, 1, this.world, AliensVsPredator.blocks().blockCryostasisTube);

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
            if (this.getThrower().getHeldItemMainhand().getItem() == AliensVsPredator.items().itemM240ICU || this.getThrower().getHeldItemMainhand().getItem() == AliensVsPredator.items().itemNostromoFlamethrower)
            {
                ItemFlamethrower flamethrower = (ItemFlamethrower) this.getThrower().getHeldItemMainhand().getItem();

                if (flamethrower instanceof ItemM240IncineratorUnit)
                {
                    this.setFire(posX, posY, posZ);
                }

                if (flamethrower instanceof ItemNostromoFlamethrower)
                {
                    this.setFire(posX, posY, posZ);
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
