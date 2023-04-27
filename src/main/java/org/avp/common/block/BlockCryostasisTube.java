package org.avp.common.block;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.avp.common.item.ItemEntitySummoner;
import org.avp.common.tile.TileEntityCryostasisTube;

public class BlockCryostasisTube extends Block
{

    private static final AxisAlignedBB BOUNDING_BOX_INTACT = new AxisAlignedBB(0.1D, 0D, 0.1D, 0.9D, 2.0D, 0.9D);
    private static final AxisAlignedBB BOUNDING_BOX_SHATTERED = new AxisAlignedBB(0.1D, 0D, 0.1D, 0.9D, 0.7D, 0.9D);
    
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
                    if (!EntityLivingBase.class.isAssignableFrom(item.getEntityClass())) return true;

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
            tile.setRotationYAxis(Entities.getEntityFacingRotY(placer).getOpposite());
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
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
        TileEntityCryostasisTube tile = (TileEntityCryostasisTube) worldIn.getTileEntity(pos);
        AxisAlignedBB box = tile != null ? tile.isShattered() ? BOUNDING_BOX_SHATTERED : BOUNDING_BOX_INTACT : BOUNDING_BOX_INTACT;
    	return box.offset(pos);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        TileEntityCryostasisTube tile = (TileEntityCryostasisTube) worldIn.getTileEntity(pos);
        AxisAlignedBB box = tile != null ? tile.isShattered() ? BOUNDING_BOX_SHATTERED : BOUNDING_BOX_INTACT : BOUNDING_BOX_INTACT;
    	return box.offset(pos);
    }
}
