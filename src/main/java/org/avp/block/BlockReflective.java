package org.avp.block;

import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.block.properties.UnlistedPropertyBlockstate;
import org.avp.block.util.EnumAlignment;
import org.avp.client.model.loaders.ReflectiveModelLoader;
import org.avp.tile.TileEntityReflective;

import com.arisux.mdx.commands.CommandBlockUpdate;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockReflective extends Block implements ITileEntityProvider
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyEnum<EnumAlignment> ALIGNMENT = PropertyEnum.<EnumAlignment>create("alignment", EnumAlignment.class);
    public static final IUnlistedProperty<IBlockState> REFLECTION = new UnlistedPropertyBlockstate();

    public BlockReflective(Material materialIn)
    {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ALIGNMENT, EnumAlignment.BOTTOM));
    }

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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        EnumFacing facing = EnumFacing.NORTH;
        EnumAlignment alignment = EnumAlignment.BOTTOM;

        if (placer.isSneaking())
        {
            alignment = EnumAlignment.SIDE;
        }
        else
        {
            if (placer.rotationPitch < 0)
            {
                alignment = EnumAlignment.TOP;
            }
            else
            {
                alignment = EnumAlignment.BOTTOM;
            }
        }

        if (!placer.isSneaking() && placer.rotationPitch < 0)
        {
            facing = placer.getHorizontalFacing();
        }
        else
        {
            facing = placer.getHorizontalFacing().getOpposite();
        }

        worldIn.setBlockState(pos, state.withProperty(FACING, facing).withProperty(ALIGNMENT, alignment), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumAlignment alignment = EnumAlignment.BOTTOM;

        if (meta <= 3)
            alignment = EnumAlignment.BOTTOM;

        if (meta > 3 && meta <= 7)
            alignment = EnumAlignment.TOP;

        if (meta > 7 && meta <= 11)
            alignment = EnumAlignment.SIDE;

        EnumFacing facing = EnumFacing.NORTH;

        switch (meta % 4)
        {
        case 0:
            facing = EnumFacing.NORTH;
            break;
        case 1:
            facing = EnumFacing.EAST;
            break;
        case 2:
            facing = EnumFacing.SOUTH;
            break;
        case 3:
            facing = EnumFacing.WEST;
            break;
        default:
            facing = EnumFacing.NORTH;
            break;
        }

        return this.getDefaultState().withProperty(ALIGNMENT, alignment).withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;

        if (state.getValue(ALIGNMENT) == EnumAlignment.TOP)
        {
            meta = meta + 4;
        }
        else if (state.getValue(ALIGNMENT) == EnumAlignment.SIDE)
        {
            meta = meta + 8;
        }

        switch ((EnumFacing) state.getValue(FACING))
        {
        case NORTH:
            meta = meta + 0;
            break;
        case EAST:
            meta = meta + 1;
            break;
        case SOUTH:
            meta = meta + 2;
            break;
        case WEST:
            meta = meta + 3;
            break;
        default:
            meta = meta + 0;
            break;
        }

        return meta;
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer.Builder(this).add(FACING).add(ALIGNMENT).add(REFLECTION).build();
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
                IBlockState reflectionState = reflection != null ? reflection.getStateFromMeta(reflective.getReflectionMetadata()) : null;

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

    /** 1.7.10 -> 1.10.2 Shaped Block Compatability **/

    public boolean convert;

    public BlockReflective(Material materialIn, boolean convert)
    {
        this(materialIn);
        this.convert = convert;
        this.setTickRandomly(convert);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return convert ? EnumBlockRenderType.INVISIBLE : EnumBlockRenderType.MODEL;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);
        this.convert(worldIn, pos);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        this.convert(worldIn, pos);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
        this.convert(worldIn, pos);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(worldIn, pos, playerIn);
        this.convert(worldIn, pos);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        super.onEntityWalk(worldIn, pos, entityIn);
        this.convert(worldIn, pos);
    }

    private void convert(World world, BlockPos pos)
    {
        if (this.convert && !world.isRemote)
        {
            String unlocalizedName = this.getUnlocalizedName();
            IBlockState state = world.getBlockState(pos);
            Block type = null;
            String name = "";

            if (this.getUnlocalizedName().contains("slope"))
            {
                type = AliensVsPredator.blocks().slope;
                name = "slope";
            }

            if (this.getUnlocalizedName().contains("corner"))
            {
                type = AliensVsPredator.blocks().corner;
                name = "corner";
            }

            if (this.getUnlocalizedName().contains("invertedcorner"))
            {
                type = AliensVsPredator.blocks().invertedCorner;
                name = "invertedcorner";
            }

            if (this.getUnlocalizedName().contains("ridge"))
            {
                type = AliensVsPredator.blocks().ridge;
                name = "ridge";
            }

            if (this.getUnlocalizedName().contains("invertedridge"))
            {
                type = AliensVsPredator.blocks().invertedRidge;
                name = "invertedridge";
            }

            if (this.getUnlocalizedName().contains("smartridge"))
            {
                type = AliensVsPredator.blocks().pyramid;
                name = "smartridge";
            }

            if (this.getUnlocalizedName().contains("smartinvertedridge"))
            {
                type = AliensVsPredator.blocks().invertedPyramid;
                name = "smartinvertedridge";
            }

            if (type != null && world != null)
            {
                String blockName = AliensVsPredator.Properties.DOMAIN + unlocalizedName.replace("." + name, "").split(":")[1];
                Block parentBlockType = Block.getBlockFromName(blockName);

                EnumAlignment alignment = state.getValue(ALIGNMENT);
                EnumFacing facing = state.getValue(FACING);

                if (alignment == EnumAlignment.TOP)
                {
                    facing = facing.getOpposite();
                }

                IBlockState newState = type.getDefaultState().withProperty(FACING, facing).withProperty(ALIGNMENT, alignment);
                world.setBlockState(pos, newState);

                TileEntity tile = world.getTileEntity(pos);

                if (tile instanceof TileEntityReflective)
                {
                    TileEntityReflective reflective = (TileEntityReflective) tile;
                    reflective.setReflection(parentBlockType, 0);
                }

                CommandBlockUpdate.triggerBlockUpdates(world, 4, pos.getX(), pos.getY(), pos.getZ());
            }
        }
    }

    public static final String[] SHAPE_COMPAT_TYPES = new String[] { "slope", "corner", "invertedcorner", "ridge", "invertedridge", "smartinvertedridge", "smartridge" };

    public static void registerCompatBlocks(String identifier, Block block)
    {
        if (AliensVsPredator.settings().isCompatibilityModeEnabled())
        {
            for (final String type : SHAPE_COMPAT_TYPES)
            {
                String shapeId = String.format("%s.%s", identifier, type);
                registerBlockOnly(shapeId, new BlockReflective(Material.BARRIER, true));

                if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
                {
                    ReflectiveModelLoader.INSTANCE.registerDummy(shapeId);
                }
            }
        }

        block.setCreativeTab(AliensVsPredator.tabBlocks());
        AliensVsPredator.blocks().register(identifier, block);
    }

    public static Block registerBlockOnly(String identifier, Block block)
    {
        block.setUnlocalizedName(String.format("%s:%s", AliensVsPredator.Properties.ID, identifier));
        GameRegistry.register(block, new ResourceLocation(AliensVsPredator.Properties.ID, identifier));

        return block;
    }
}
