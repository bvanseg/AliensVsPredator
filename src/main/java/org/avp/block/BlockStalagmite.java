package org.avp.block;

import java.util.Random;

import org.avp.AliensVsPredator;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockStalagmite extends Block
{
    public BlockStalagmite(Material material)
    {
        super(material);
        this.setTickRandomly(true);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[0])
        {
            @Override
            protected StateImplementation createState(Block block, ImmutableMap<IProperty<?>, Comparable<?>> properties, ImmutableMap<IUnlistedProperty<?>, Optional<?>> unlistedProperties)
            {
                return new StateImplementation(block, properties)
                {
                    @Override
                    public EnumBlockRenderType getRenderType()
                    {
                        return EnumBlockRenderType.INVISIBLE;
                    }

                    @Override
                    public boolean isOpaqueCube()
                    {
                        return false;
                    }
                    
                    @Override
                    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos)
                    {
                        return null;
                    }
                };
            }
        };
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && this.canThisPlantGrowOn(worldIn.getBlockState(pos.add(0, -1, 0)));
    }

    protected boolean canThisPlantGrowOn(IBlockState state)
    {
        return state.getBlock() == AliensVsPredator.blocks().unidirt || state.getBlock() == AliensVsPredator.blocks().unistone || state.getMaterial() == Material.GROUND || state.getMaterial() == Material.ROCK;
    }

    @Override
    public void onNeighborChange(IBlockAccess access, BlockPos pos, BlockPos neighbor)
    {
        super.onNeighborChange(access, pos, neighbor);
        this.checkFlowerChange(access, access.getBlockState(pos), pos);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(world, pos, state, rand);
        this.checkFlowerChange(world, state, pos);
    }

    protected final void checkFlowerChange(IBlockAccess access, IBlockState state, BlockPos pos)
    {
        if (!this.canBlockStay(access, pos))
        {
            if (access instanceof World)
            {
                World world = (World) access;
                this.dropBlockAsItem(world, pos, state, 0);
                world.setBlockToAir(pos);
            }
        }
    }

    public boolean canBlockStay(IBlockAccess world, BlockPos pos)
    {
        return this.canThisPlantGrowOn(world.getBlockState(pos.add(0, -1, 0)));
    }
}
