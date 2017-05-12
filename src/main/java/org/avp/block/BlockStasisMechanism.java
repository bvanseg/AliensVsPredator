package org.avp.block;

import org.avp.item.ItemEntitySummoner;
import org.avp.tile.TileEntityStasisMechanism;

import com.arisux.mdxlib.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockStasisMechanism extends Block
{
    public BlockStasisMechanism(Material material)
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
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityStasisMechanism();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntityStasisMechanism tile = (TileEntityStasisMechanism) world.getTileEntity(pos);

        if (tile != null)
        {
            if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof ItemEntitySummoner)
            {
                ItemEntitySummoner item = (ItemEntitySummoner) player.getHeldItemMainhand().getItem();
                tile.itemstack = new ItemStack(item, 1);
                Inventories.consumeItem(player, item);
            }
            else if (player.getHeldItemMainhand() == null)
            {
                player.inventory.addItemStackToInventory(tile.itemstack);
                tile.itemstack = null;
            }
        }

        return true;
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(world, pos, playerIn);

        TileEntityStasisMechanism tile = (TileEntityStasisMechanism) world.getTileEntity(pos);

        if (tile != null)
        {
            if (tile.dummyEntity != null)
            {
                world.removeEntity(tile.dummyEntity);
            }

            if (tile.itemstack != null)
            {
                EntityItem entityitem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), tile.itemstack);
                entityitem.setPickupDelay(10);
                world.spawnEntity(entityitem);
            }
        }
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityStasisMechanism tile = (TileEntityStasisMechanism) world.getTileEntity(pos);

        if (tile != null)
        {
            tile.setDirection((byte) (MathHelper.floor(((placer.rotationYaw * 4F) / 360F) + 0.5D) & 3));
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }
}
