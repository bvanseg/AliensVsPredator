package org.avp.common.block;

import org.avp.AliensVsPredator;
import org.avp.common.tile.TileEntityRepulsionGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockGenerator extends Block
{
    public BlockGenerator(Material material)
    {
        super(material);
        this.setTickRandomly(true);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityRepulsionGenerator();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tile = world.getTileEntity(pos);
        
        if (tile instanceof TileEntityRepulsionGenerator)
        {
            TileEntityRepulsionGenerator generator = (TileEntityRepulsionGenerator) tile;
            showGeneratorGUI(playerIn, generator);
            return true;
        }

        return super.onBlockActivated(world, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
    }

    public static void showGeneratorGUI(EntityPlayer player, TileEntityRepulsionGenerator generator)
    {
        if (!player.world.isRemote)
        {
            FMLNetworkHandler.openGui(player, AliensVsPredator.instance(), AliensVsPredator.interfaces().GUI_REPULSION_GENERATOR, player.world, generator.getPos().getX(), generator.getPos().getY(), generator.getPos().getZ());
        }
    }
}
