package org.avp.block;

import org.avp.item.ItemEntitySummoner;
import org.avp.tile.TileEntityCryostasisTube;

import com.arisux.mdx.lib.world.entity.Entities;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCryostasisTube extends Block
{
    public BlockCryostasisTube(Material material)
    {
        super(material);
        this.setTickRandomly(true);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityCryostasisTube();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemEntitySummoner)
        {
            TileEntityCryostasisTube tile = (TileEntityCryostasisTube) world.getTileEntity(pos);

            if (tile != null)
            {
                if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof ItemEntitySummoner)
                {
                    ItemEntitySummoner item = (ItemEntitySummoner) player.getHeldItemMainhand().getItem();
                    tile.stasisItemstack = new ItemStack(item, 1);
                    tile.stasisEntity = item.createNewEntity(world);
                    Inventories.consumeItem(player, item);
                }
                else if (player.getHeldItemMainhand() == null)
                {
                    player.inventory.addItemStackToInventory(tile.stasisItemstack);
                    tile.stasisEntity = null;
                    tile.stasisItemstack = null;
                }
            }

            return true;
        }

        return false;
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityCryostasisTube tile = (TileEntityCryostasisTube) world.getTileEntity(pos);

        if (tile != null)
        {
            tile.setRotationYAxis(Entities.getEntityFacingRotY(placer));
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}
