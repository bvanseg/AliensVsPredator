package org.avp.common.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCustomStairs extends BlockStairs
{
    private BlockRenderLayer renderLayer;
    private boolean doesSideRendering;

    public BlockCustomStairs(IBlockState modelState)
    {
        super(modelState);
        this.renderLayer = BlockRenderLayer.SOLID;
        this.doesSideRendering = true;
    }

    public BlockCustomStairs setRenderLayer(BlockRenderLayer layer) {
        this.renderLayer = layer;
        return this;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return this.renderLayer;
    }

    public BlockCustomStairs setDoesSideRendering(boolean doesSideRendering) {
        this.doesSideRendering = doesSideRendering;
        return this;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        if (this.doesSideRendering) {
            return super.doesSideBlockRendering(state, world, pos, face);
        }

        return false;
    }
}
