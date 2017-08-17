package org.avp.block;

import org.avp.api.machines.IOpenable;
import org.avp.tile.TileEntityMedpod;

import com.arisux.mdx.lib.world.entity.Entities;
import com.arisux.mdx.lib.world.tile.IRotatable;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;


public class BlockMedpod extends Block
{
    public BlockMedpod(Material material)
    {
        super(material);
        setTickRandomly(true);
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity != null && tileEntity instanceof IOpenable)
        {
            IOpenable openable = (IOpenable) tileEntity;
            openable.setOpen(!openable.isOpen());
        }

        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof IRotatable && placer != null)
        {
            IRotatable rotatable = (IRotatable) tile;
            rotatable.setDirection(Entities.getDirectionFacing(placer));
        }
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityMedpod();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(world, pos, playerIn);

        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityMedpod)
        {
            TileEntityMedpod medpod = (TileEntityMedpod) tile;

            if (medpod != null && medpod.getEntity() != null)
            {
                medpod.getEntity().setDead();
            }
        }
    }
}
