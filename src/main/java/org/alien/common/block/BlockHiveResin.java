package org.alien.common.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.property.IUnlistedProperty;
import org.avp.common.block.property.UnlistedPropertyBlockstate;
import org.lib.common.block.BasicBlock;
import org.lib.common.block.BlockProperties;

public class BlockHiveResin extends BasicBlock
{
    public static final IUnlistedProperty<IBlockState> PARENT_BLOCK = new UnlistedPropertyBlockstate();
    
    public BlockHiveResin(String registryName, BlockProperties properties)
    {
        super(registryName, properties);
    }


    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 5;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 5;
    }
}
