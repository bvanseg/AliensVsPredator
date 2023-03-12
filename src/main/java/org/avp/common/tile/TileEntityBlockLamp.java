package org.avp.common.tile;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockLamp extends TileEntity
{
    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
    }
}
