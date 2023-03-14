package org.avp.common.tile;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityReflective extends TileEntity
{
    private Block reflection;
    private int   reflectionMetadata;

    public TileEntityReflective()
    {
        super();
    }
    
    public Block getReflection()
    {
        return reflection;
    }
    
    public int getReflectionMetadata()
    {
        return reflectionMetadata;
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

    public void setReflection(Block reflection, int metadata)
    {
        this.reflection = reflection;
        this.reflectionMetadata = metadata;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        int id = compound.getInteger("Reflection");

        if (id != 0)
        {
            this.reflection = Block.getBlockById(id);
            this.reflectionMetadata = compound.getInteger("ReflectionMeta");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound.setInteger("Reflection", Block.getIdFromBlock(reflection));
        compound.setInteger("ReflectionMeta", reflectionMetadata);

        return super.writeToNBT(compound);
    }
}
