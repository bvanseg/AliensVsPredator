package org.avp.common.tile;

import com.asx.mdx.lib.world.tile.IRotatableYAxis;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import org.avp.common.block.BlockSkull;

public class TileEntitySkull extends TileEntity implements IRotatableYAxis
{
    private EnumFacing direction;
    private EnumOrientation orientation;
    
    public enum EnumOrientation
    {
        FLAT(), SIDE(), WALL();
        
        public static EnumOrientation byIndex(int id)
        {
            for (EnumOrientation o : EnumOrientation.values())
            {
                if (o.ordinal() == id)
                {
                    return o;
                }
            }
            
            return FLAT;
        }
    }

    public BlockSkull getSkullBlock()
    {
        Block block = this.world.getBlockState(this.getPos()).getBlock();

        if (block instanceof BlockSkull)
        {
            return (BlockSkull) block;
        }
        
        return null;
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

        if (this.orientation != null)
        {
            nbt.setInteger("Orientation", this.orientation.ordinal());
        }

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }

        if (EnumOrientation.byIndex(nbt.getInteger("Orientation")) != null)
        {
            this.orientation = EnumOrientation.byIndex(nbt.getInteger("Orientation"));
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
    
    public void setOrientation(EnumOrientation orientation)
    {
        this.orientation = orientation;
    }
    
    public EnumOrientation getOrientation()
    {
        return orientation;
    }
}
