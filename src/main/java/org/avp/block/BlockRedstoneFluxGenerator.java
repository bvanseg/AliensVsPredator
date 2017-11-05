package org.avp.block;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.packets.client.PacketRotateRotatable;
import org.avp.tile.TileEntityRedstoneFluxGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockRedstoneFluxGenerator extends Block
{
    public BlockRedstoneFluxGenerator(Material material)
    {
        super(material);
        this.setTickRandomly(true);
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity te = world.getTileEntity(pos);

        if (te != null && te instanceof TileEntityRedstoneFluxGenerator)
        {
            TileEntityRedstoneFluxGenerator generator = (TileEntityRedstoneFluxGenerator) te;

            ArrayList<EnumFacing> EnumFacings = new ArrayList<EnumFacing>();

            for (EnumFacing dir : EnumFacing.VALUES)
            {
                if (dir != EnumFacing.UP && dir != EnumFacing.DOWN)
                {
                    EnumFacings.add(dir);
                }
            }

            if (generator.getRotationYAxis() != null)
            {
                int index = EnumFacings.indexOf(generator.getRotationYAxis());

                if (index + 1 >= EnumFacings.size())
                {
                    index = -1;
                }

                if (EnumFacings.get(index + 1) != null)
                {
                    generator.setRotationYAxis(EnumFacings.get(index + 1));
                }

                if (!world.isRemote)
                {
                    AliensVsPredator.network().sendToAll(new PacketRotateRotatable(generator.getRotationYAxis().ordinal(), generator.getPos().getX(), generator.getPos().getY(), generator.getPos().getZ()));
                }
            }

            generator.getUpdatePacket();
        }
        return super.onBlockActivated(world, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityRedstoneFluxGenerator();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
