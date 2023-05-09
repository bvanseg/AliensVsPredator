package org.power.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.power.common.tile.TileEntityElectrical;

/**
 * @author Boston Vanseghi
 */
public class ElectricalBlock extends Block {

    protected int lightEmittedWhenPowered = 0;

    public ElectricalBlock(Material materialIn) {
        super(materialIn);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityElectrical)
        {
            TileEntityElectrical e = (TileEntityElectrical) tile;

            if (e.isOperational())
            {
                return this.lightEmittedWhenPowered;
            }
        }

        return 0;
    }
}
