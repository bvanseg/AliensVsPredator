package org.avp.block;

import org.avp.item.ItemEntitySummoner;
import org.avp.tile.TileEntityCryostasisTube;

import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockCryostasisTube extends Block
{
    public BlockCryostasisTube(Material material)
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
        return new TileEntityCryostasisTube();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
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
            tile.setDirection(getFacing(placer));
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }

    public static EnumFacing getFacing(Entity entity)
    {
        int dir = MathHelper.floor((entity.rotationYaw / 90) + 0.5) & 3;
        return EnumFacing.getFront(dir);
    }
}
