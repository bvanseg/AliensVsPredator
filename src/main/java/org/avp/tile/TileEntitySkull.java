package org.avp.tile;

import org.avp.block.BlockSkull;

import com.arisux.mdxlib.lib.world.tile.IRotatable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;


public class TileEntitySkull extends TileEntity implements IRotatable
{
    private EnumFacing direction;
    
    public BlockSkull getSkullBlock()
    {
        return (BlockSkull) this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
    }

    @Override
    public void updateEntity()
    {
        ;
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.getNbtCompound());
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.getOrientation(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.getOrientation(nbt.getInteger("Direction"));
        }
    }

    @Override
    public EnumFacing getDirection()
    {
        return direction;
    }

    @Override
    public void setDirection(EnumFacing direction)
    {
        this.direction = direction;
    }
}
