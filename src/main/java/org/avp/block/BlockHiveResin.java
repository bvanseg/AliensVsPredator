package org.avp.block;

import org.avp.tile.TileEntityHiveResin;
import org.avp.world.hives.HiveHandler;

import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.Pos.BlockDataStore;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockHiveResin extends Block
{
    public BlockHiveResin(Material material)
    {
        super(material);
        this.setLightLevel(0.1F);
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
                        // AliensVsPredator.renderTypes().RENDER_TYPE_RESIN
                        return EnumBlockRenderType.MODEL;
                    }
                };
            }
        };
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

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityHiveResin();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer playerIn)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityHiveResin)
        {
            Pos coord = new Pos(pos);
            TileEntityHiveResin resin = (TileEntityHiveResin) tile;

            if (resin != null)
            {
                if (coord.isAnySurfaceNextTo(world, Blocks.FIRE))
                {
                    if (resin != null && resin.getBlockCovering() != null)
                    {
                        HiveHandler.instance.burntResin.add(new Pos(pos).store(new BlockDataStore(resin.getBlockCovering().getBlock(), (byte) 0)));
                    }
                }

                if (resin.getHive() != null)
                {
                    resin.getHive().getResinInHive().remove(resin);
                }
            }
        }

        super.onBlockClicked(world, pos, playerIn);
    }
}
