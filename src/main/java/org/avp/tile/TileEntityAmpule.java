package org.avp.tile;

import com.arisux.mdx.lib.world.tile.IRotatableYAxis;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityAmpule extends TileEntity implements IRotatableYAxis
{
    private EnumFacing direction;

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

        if (EnumFacing.getFront(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.getFront(nbt.getInteger("Direction"));
        }
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
