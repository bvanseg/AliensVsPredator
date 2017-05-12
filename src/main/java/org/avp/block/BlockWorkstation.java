package org.avp.block;

import org.avp.tile.TileEntityWorkstation;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockWorkstation extends Block
{
    public BlockWorkstation(Material material)
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
                    public boolean isOpaqueCube()
                    {
                        return false;
                    }
                    
                    @Override
                    public EnumBlockRenderType getRenderType()
                    {
                        return EnumBlockRenderType.INVISIBLE;
                    }
                };
            }
        };
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityWorkstation();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityWorkstation tile = (TileEntityWorkstation) world.getTileEntity(pos);

        if (tile != null)
        {
            tile.setDirection((byte) (MathHelper.floor(((placer.rotationYaw * 4F) / 360F) + 0.5D) & 3));
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }
}
