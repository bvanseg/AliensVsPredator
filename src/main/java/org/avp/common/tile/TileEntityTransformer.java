package org.avp.common.tile;

import com.asx.mdx.lib.world.tile.IRotatableYAxis;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import org.avp.common.api.power.IVoltageProvider;
import org.avp.common.api.power.IVoltageReceiver;

public class TileEntityTransformer extends TileEntityElectrical implements IVoltageProvider, IVoltageReceiver, IRotatableYAxis
{
    private EnumFacing direction;

    public TileEntityTransformer()
    {
        super(false);
        this.boost = 24;
        this.direction = EnumFacing.SOUTH;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.getPos(), 1, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
    {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }
        
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
    }

    @Override
    public void update()
    {
        super.update();
        this.updateEnergyAsReceiver();

        if (this.voltage > 0)
        {
            TileEntity tile = this.world.getTileEntity(this.getPos().offset(direction));

            if (tile != null && tile instanceof TileEntityElectrical)
            {
                TileEntityElectrical electrical = (TileEntityElectrical) tile;

                if (electrical instanceof IVoltageProvider)
                {
                    if (electrical.getVoltage() == 0)
                    {
                        this.voltage = 0;
                    }
                }
            }
            else
            {
                this.voltage = 0;
            }
        }
    }
    
    @Override
    public boolean canReceiveVoltageFromSide(EnumFacing from)
    {
        TileEntity t = this.world.getTileEntity(this.getPos().offset(direction));

        if (t != null && t instanceof TileEntityElectrical)
        {
            TileEntityElectrical e = (TileEntityElectrical) t;
            
            if (super.canReceiveVoltageFromSide(from) && e.getVoltage() > this.getVoltage() && this.getVoltage() > 0)
            {
                return false;
            }
        }
        
        return super.canReceiveVoltageFromSide(from);
    }

    @Override
    public EnumFacing getSourcePowerDirection()
    {
        return direction;
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return from == direction || from == direction.getOpposite();
    }

    @Override
    public boolean canProvideEnergyToReceiver(EnumFacing side)
    {
        return side == direction;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.voltage;
    }

    @Override
    public double extractVoltage(EnumFacing from, double maxExtract, boolean simulate)
    {
        TileEntity tile = this.world.getTileEntity(this.getPos().offset(from));

        if (tile != null && tile instanceof TileEntityElectrical)
        {
            return (maxExtract + this.getBoost()) - this.getResistance();
        }

        return 0;
    }
    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 10000;
    }

    @Override
    public EnumFacing getRotationYAxis()
    {
        return direction;
    }

    @Override
    public void setRotationYAxis(EnumFacing direction)
    {
        this.direction = direction;
    }
}
