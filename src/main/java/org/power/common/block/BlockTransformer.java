package org.power.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.PacketRotateRotatable;
import org.power.common.tile.TileEntityTransformer;

import java.util.ArrayList;

public class BlockTransformer extends Block
{
    public BlockTransformer(Material material)
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
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityTransformer();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity te = world.getTileEntity(pos);

        if (hand == EnumHand.MAIN_HAND)
        {
            if (te != null && te instanceof TileEntityTransformer)
            {
                if (playerIn.getHeldItemMainhand().getItem() == Items.AIR)
                {
                    TileEntityTransformer transformer = (TileEntityTransformer) te;

                    ArrayList<EnumFacing> facing = new ArrayList<>();

                    for (EnumFacing dir : EnumFacing.VALUES)
                    {
                        if (dir != EnumFacing.UP && dir != EnumFacing.DOWN)
                        {
                            facing.add(dir);
                        }
                    }

                    if (transformer.getRotationYAxis() != null)
                    {
                        int index = facing.indexOf(transformer.getRotationYAxis());

                        if (index + 1 >= facing.size())
                        {
                            index = -1;
                        }

                        if (facing.get(index + 1) != null)
                        {
                            transformer.setRotationYAxis(facing.get(index + 1));
                        }

                        if (!world.isRemote)
                        {
                            AVPNetworking.instance.sendToAll(new PacketRotateRotatable(transformer.getRotationYAxis().ordinal(), transformer.getPos().getX(), transformer.getPos().getY(), transformer.getPos().getZ()));
                        }
                    }

                    transformer.getUpdatePacket();
                }
            }
        }
        return super.onBlockActivated(world, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
    }
}
