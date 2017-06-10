package org.avp.block;


import org.avp.tile.TileEntityReflective;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockReflectiveShape extends Block implements ITileEntityProvider
{
    public static final PropertyDirection              PLACEMENT  = BlockHorizontal.FACING;
    public static final IUnlistedProperty<IBlockState> REFLECTION = new IUnlistedProperty<IBlockState>()
                                                                  {
                                                                      @Override
                                                                      public String getName()
                                                                      {
                                                                          return "UnlistedProperty.Reflection";
                                                                      }

                                                                      @Override
                                                                      public boolean isValid(IBlockState value)
                                                                      {
                                                                          return true;
                                                                      }

                                                                      @Override
                                                                      public Class<IBlockState> getType()
                                                                      {
                                                                          return IBlockState.class;
                                                                      }

                                                                      @Override
                                                                      public String valueToString(IBlockState value)
                                                                      {
                                                                          return value.toString();
                                                                      }
                                                                  };

    public BlockReflectiveShape(Material materialIn)
    {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(PLACEMENT, EnumFacing.NORTH));
    }

    /**
     * Registers the existing Block model with the ItemBlock of this Block.
     */
    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState)
    {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tile = worldIn.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityReflective)
        {
            TileEntityReflective reflective = (TileEntityReflective) tile;

            if (playerIn.getHeldItemMainhand() != null)
            {
                Item itemHeld = playerIn.getHeldItemMainhand().getItem();
                Block blockHeld = Block.getBlockFromItem(itemHeld);
                int metadata = playerIn.getHeldItemMainhand().getMetadata();

                if (blockHeld != null)
                {
                    reflective.setReflection(blockHeld, metadata);
                    worldIn.notifyBlockUpdate(pos, state, state, 3);
                    return true;
                }
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState east = worldIn.getBlockState(pos.east());
            IBlockState west = worldIn.getBlockState(pos.west());
            EnumFacing facing = (EnumFacing) state.getValue(PLACEMENT);

            if (facing == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock())
            {
                facing = EnumFacing.SOUTH;
            }
            else if (facing == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock())
            {
                facing = EnumFacing.NORTH;
            }
            else if (facing == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock())
            {
                facing = EnumFacing.EAST;
            }
            else if (facing == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock())
            {
                facing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(PLACEMENT, facing), 2);
        }
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(PLACEMENT, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(PLACEMENT, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(PLACEMENT, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing) state.getValue(PLACEMENT)).getIndex();
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(PLACEMENT, rot.rotate((EnumFacing) state.getValue(PLACEMENT)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(PLACEMENT)));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer.Builder(this).add(PLACEMENT).add(REFLECTION).build();
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        if (state != null && state instanceof IExtendedBlockState)
        {
            IExtendedBlockState extendedState = ((IExtendedBlockState) state);
            TileEntity tile = world.getTileEntity(pos);

            if (tile != null && tile instanceof TileEntityReflective)
            {
                TileEntityReflective reflective = (TileEntityReflective) tile;
                Block reflection = reflective.getReflection();
                IBlockState reflectionState = reflection != null ? reflection.getDefaultState() : null;

                return extendedState.withProperty(REFLECTION, reflectionState);
            }
        }

        return state;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityReflective();
    }
}
