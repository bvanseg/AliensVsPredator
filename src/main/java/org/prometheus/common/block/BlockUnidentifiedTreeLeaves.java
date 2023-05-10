package org.prometheus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.prometheus.common.block.init.PrometheusVardaBlocks;

import java.util.List;
import java.util.Random;

public class BlockUnidentifiedTreeLeaves extends BlockLeaves
{
    public enum Type
    {
        TOP, MIDDLE, BOTTOM
    }

    protected int[]                   surroundings;
    public static final AxisAlignedBB AABB = new AxisAlignedBB(0.3D, 0.3D, 0.3D, 0.7D, 0.7D, 0.7D);
    public final Type                 type;
    
    public BlockUnidentifiedTreeLeaves(Type type)
    {
        super();
        this.type = type;
    }

    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
        switch (this.type)
        {
            case MIDDLE:
            case BOTTOM:
                IBlockState above = world.getBlockState(pos.up());
                if (this.type == Type.MIDDLE)
                {
                    return above.getBlock() == PrometheusVardaBlocks.GIGER_LEAVES || above.getBlock() == PrometheusVardaBlocks.GIGER_LEAVES_M;
                }
                else
                {
                    return above.getBlock() == PrometheusVardaBlocks.GIGER_LEAVES_M;
                }
            default:
                return true;
        }
    }

    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        return super.canPlaceBlockAt(world, pos) && this.canBlockStay(world, pos, world.getBlockState(pos));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
        this.checkAndDropBlock(worldIn, pos, state);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { DECAYABLE, CHECK_DECAY });
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(DECAYABLE) ? 2 : 1;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(DECAYABLE, meta == 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(PrometheusVardaBlocks.GIGER_SAPLING);
    }

    @Override
    public void beginLeavesDecay(IBlockState state, World world, BlockPos pos)
    {
        if (!(Boolean) state.getValue(CHECK_DECAY))
        {
            world.setBlockState(pos, state.withProperty(CHECK_DECAY, true), 4);
        }
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return null;
    }

    @Override
    public EnumType getWoodType(int meta)
    {
        return EnumType.OAK;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.type == Type.TOP)
        {
            super.updateTick(worldIn, pos, state, rand);
        }
        this.checkAndDropBlock(worldIn, pos, state);
        
        if (!worldIn.isRemote)
        {
            if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue() && ((Boolean)state.getValue(DECAYABLE)).booleanValue())
            {
                int checkDist = 8;
                int radius = 9;
                int posX = pos.getX();
                int posY = pos.getY();
                int posZ = pos.getZ();
                int j1 = 32;
                int k1 = 1024;
                int l1 = 16;

                if (this.surroundings == null)
                {
                    this.surroundings = new int[32768];
                }

                if (worldIn.isAreaLoaded(new BlockPos(posX - radius, posY - radius, posZ - radius), new BlockPos(posX + radius, posY + radius, posZ + radius)))
                {
                    BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                    for (int x = -checkDist; x <= checkDist; ++x)
                    {
                        for (int y = -checkDist; y <= checkDist; ++y)
                        {
                            for (int z = -checkDist; z <= checkDist; ++z)
                            {
                                IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos.setPos(posX + x, posY + y, posZ + z));
                                Block block = iblockstate.getBlock();

                                if (!block.canSustainLeaves(iblockstate, worldIn, blockpos$mutableblockpos.setPos(posX + x, posY + y, posZ + z)))
                                {
                                    if (block.isLeaves(iblockstate, worldIn, blockpos$mutableblockpos.setPos(posX + x, posY + y, posZ + z)))
                                    {
                                        this.surroundings[(x + l1) * k1 + (y + l1) * j1 + z + l1] = -2;
                                    }
                                    else
                                    {
                                        this.surroundings[(x + l1) * k1 + (y + l1) * j1 + z + l1] = -1;
                                    }
                                }
                                else
                                {
                                    this.surroundings[(x + l1) * k1 + (y + l1) * j1 + z + l1] = 0;
                                }
                            }
                        }
                    }

                    for (int p = 1; p <= checkDist; ++p)
                    {
                        for (int x = -checkDist; x <= checkDist; ++x)
                        {
                            for (int y = -checkDist; y <= checkDist; ++y)
                            {
                                for (int z = -checkDist; z <= checkDist; ++z)
                                {
                                    if (this.surroundings[(x + l1) * k1 + (y + l1) * j1 + z + l1] == p - 1)
                                    {
                                        if (this.surroundings[(x + l1 - 1) * k1 + (y + l1) * j1 + z + l1] == -2)
                                        {
                                            this.surroundings[(x + l1 - 1) * k1 + (y + l1) * j1 + z + l1] = p;
                                        }

                                        if (this.surroundings[(x + l1 + 1) * k1 + (y + l1) * j1 + z + l1] == -2)
                                        {
                                            this.surroundings[(x + l1 + 1) * k1 + (y + l1) * j1 + z + l1] = p;
                                        }

                                        if (this.surroundings[(x + l1) * k1 + (y + l1 - 1) * j1 + z + l1] == -2)
                                        {
                                            this.surroundings[(x + l1) * k1 + (y + l1 - 1) * j1 + z + l1] = p;
                                        }

                                        if (this.surroundings[(x + l1) * k1 + (y + l1 + 1) * j1 + z + l1] == -2)
                                        {
                                            this.surroundings[(x + l1) * k1 + (y + l1 + 1) * j1 + z + l1] = p;
                                        }

                                        if (this.surroundings[(x + l1) * k1 + (y + l1) * j1 + (z + l1 - 1)] == -2)
                                        {
                                            this.surroundings[(x + l1) * k1 + (y + l1) * j1 + (z + l1 - 1)] = p;
                                        }

                                        if (this.surroundings[(x + l1) * k1 + (y + l1) * j1 + z + l1 + 1] == -2)
                                        {
                                            this.surroundings[(x + l1) * k1 + (y + l1) * j1 + z + l1 + 1] = p;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (this.surroundings[16912] >= 0)
                {
                    worldIn.setBlockState(pos, state.withProperty(CHECK_DECAY, Boolean.valueOf(false)), 4);
                }
                else
                {
                    this.destroy(worldIn, pos);
                }
            }
        }
    }

    protected void destroy(World worldIn, BlockPos pos)
    {
        this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
        worldIn.setBlockToAir(pos);
    }
}
