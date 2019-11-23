package org.avp.tile;

import java.util.Random;

import org.avp.DamageSources;
import org.avp.api.power.IVoltageProvider;
import org.avp.api.power.IVoltageReceiver;

import com.asx.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.tile.IRotatableXAxis;
import com.asx.mdx.lib.world.tile.IRotatableYAxis;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityTeslaCoil extends TileEntityElectrical implements IVoltageProvider, IVoltageReceiver, IRotatableYAxis, IRotatableXAxis
{
    private EnumFacing       rotationX;
    private EnumFacing       rotationY;
    private Pos              sustainArcPos;
    private long             sustainArcTimestamp;
    private static final int SUSTAIN_TIME = 20 * 2;

    public TileEntityTeslaCoil()
    {
        super(false);
        this.srcVoltage = 1000000;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.byIndex(nbt.getInteger("RotationX")) != null)
            this.rotationX = EnumFacing.byIndex(nbt.getInteger("RotationX"));

        if (EnumFacing.byIndex(nbt.getInteger("RotationY")) != null)
            this.rotationY = EnumFacing.byIndex(nbt.getInteger("RotationY"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        if (this.rotationX != null)
            nbt.setInteger("RotationX", this.rotationX.ordinal());

        if (this.rotationY != null)
            nbt.setInteger("RotationY", this.rotationY.ordinal());

        return super.writeToNBT(nbt);
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public boolean canProvideEnergyToReceiver(EnumFacing side)
    {
        return true;
    }

    @Override
    public boolean canReceiveVoltageFromSide(EnumFacing from)
    {
        return canProvideEnergyToReceiver(from);
    }

    @Override
    public EnumFacing getRotationYAxis()
    {
        return this.rotationX;
    }

    @Override
    public void setRotationYAxis(EnumFacing facing)
    {
        this.rotationX = facing;
    }

    @Override
    public EnumFacing getRotationXAxis()
    {
        return this.rotationY;
    }

    @Override
    public void setRotationXAxis(EnumFacing facing)
    {
        this.rotationY = facing;
    }

    @Override
    public void update()
    {
        super.update();
        this.updateEnergyAsReceiver();
        this.tryElectricArc();
    }

    @Override
    public boolean canArc()
    {
        if (this.world.getTotalWorldTime() % 2 == 0)
        {
            return true;
        }

        return false;
    }

    @Override
    public Pos getArcOrigin()
    {
        Pos pos = new Pos(this.pos);
        double radius = 0.75F;
        double angle = world.rand.nextFloat() * Math.PI * 2;
        double x = 0;
        double z = 0;
        double y = 0;

        if (this.rotationY == EnumFacing.DOWN)
        {
            x = 0.5D + Math.cos(angle) * radius;
            z = 0.5D + Math.sin(angle) * radius;
            pos = pos.add(0, 3, 0);
        }
        else if (this.rotationY == EnumFacing.UP)
        {
            x = 0.5D + Math.cos(angle) * radius;
            z = 0.5D + Math.sin(angle) * radius;
            pos = pos.add(0, -2, 0);
        }
        else if (this.rotationY == EnumFacing.NORTH && this.rotationX == EnumFacing.EAST)
        {
            y = 0.5D + Math.cos(angle) * radius;
            z = 0.5D + Math.sin(angle) * radius;
            pos = pos.add(-2, 0, 0);
        }
        else if (this.rotationY == EnumFacing.NORTH && this.rotationX == EnumFacing.WEST)
        {
            y = 0.5D + Math.cos(angle) * radius;
            z = 0.5D + Math.sin(angle) * radius;
            pos = pos.add(3, 0, 0);
        }
        else if (this.rotationY == EnumFacing.NORTH && this.rotationX == EnumFacing.NORTH)
        {
            y = 0.5D + Math.cos(angle) * radius;
            x = 0.5D + Math.sin(angle) * radius;
            pos = pos.add(0, 0, 3);
        }
        else if (this.rotationY == EnumFacing.NORTH && this.rotationX == EnumFacing.SOUTH)
        {
            y = 0.5D + Math.cos(angle) * radius;
            x = 0.5D + Math.sin(angle) * radius;
            pos = pos.add(0, 0, -2);
        }

        return pos.add(x, y, z);
    }

    @Override
    public void tryElectricArc()
    {
        if (this.getVoltage() > 0 && canArc() || this.getVoltage() > 0 && this.sustainArcPos != null)
        {
            Random rand = new Random();
            float m = 1.75F;
            Pos origin = this.getArcOrigin();
            int rng = 8;
            Pos t = null;

            if (this.sustainArcTimestamp > 0 && world.getTotalWorldTime() - this.sustainArcTimestamp > SUSTAIN_TIME || this.getWorld().getTotalWorldTime() - this.sustainArcTimestamp < 0)
            {
                this.sustainArcPos = null;
                this.sustainArcTimestamp = 0;
            }

            if (this.sustainArcPos != null)
            {
                t = sustainArcPos;
            }
            else
            {
                t = origin.add(world.rand.nextInt(rng) - world.rand.nextInt(rng), world.rand.nextInt(rng) - world.rand.nextInt(rng), world.rand.nextInt(rng) - world.rand.nextInt(rng));
            }

            Entity target = Entities.getRandomEntityInCoordsRange(world, EntityLivingBase.class, new Pos(this), (int) Math.floor(rng));
            double distG = origin.distanceFrom(t);
            double distE = 1000;
            double dist = distG;
            double arcWidth = MDXMath.map((double) this.voltage, 600D, 10000D, 0.05D, 0.5D);
            float damageMult = (float) (arcWidth * 100F);

            Block b = t.getBlock(this.world);

            if (b != null)
            {
                TileEntity tile = this.world.getTileEntity(t.blockPos());

                if (tile != null)
                {
                    if (tile instanceof TileEntityCCFLTube)
                    {
                        TileEntityCCFLTube tube = (TileEntityCCFLTube) tile;

                        if (this.sustainArcPos == null)
                        {
                            this.sustainArcTimestamp = world.getTotalWorldTime();
                            this.sustainArcPos = t = t.add(-0.5, -1, -0.5);
                        }

                        tube.setVoltage(this.srcVoltage);
                    }
                }
            }

            if (target != null)
            {
                boolean validTarget = true;

                if (target instanceof EntityPlayer && ((EntityPlayer) target).capabilities.isCreativeMode)
                {
                    validTarget = false;
                }

                if (validTarget)
                {
                    Pos p = new Pos(target.getPosition()).add(target.width / 2, 0, target.width / 2);
                    distE = target.getDistance(origin.x, origin.y, origin.z);
                    t = p;
                    m = 8F;
                    dist = distE;

                    target.attackEntityFrom(DamageSources.electricity, damageMult);
                    target.setFire(3);
                }
            }

            if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
            {
                this.spawnArc(t, m, rand, dist, origin, arcWidth);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void spawnArc(Pos t, float m, Random rand, double dist, Pos origin, double arcWidth)
    {
        boolean holdArc = sustainArcTimestamp > 0 && this.world.getTotalWorldTime() - sustainArcTimestamp < 1;
        float targetX = (float) (t.x + (rand.nextFloat() / m) - (rand.nextFloat() / m));
        float targetY = (float) (t.y + 1);
        float targetZ = (float) (t.z + (rand.nextFloat() / m) - (rand.nextFloat() / m));
        int age = holdArc ? SUSTAIN_TIME : 1;
        int color = 0xFF8866CC;

        if (sustainArcTimestamp == 0 && !holdArc || holdArc)
        {
            if (this.world.isRemote)
            {
                EntityFXElectricArc arc = new EntityFXElectricArc(world, origin.x, origin.y, origin.z, targetX, targetY, targetZ, age, 3F + rand.nextInt(7), 0.05F, (float) (rand.nextFloat() * 0.25F) + (float) arcWidth, color);
                Game.minecraft().effectRenderer.addEffect(arc);
            }
        }
    }

    @Override
    public double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate)
    {
        return super.receiveVoltage(from, maxReceive, simulate);
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.getVoltage();
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 240;
    }
}
