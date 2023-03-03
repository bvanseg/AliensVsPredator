package org.avp.block;

import org.avp.AliensVsPredator;
import org.avp.packets.server.PacketAddTurretTarget;
import org.avp.tile.TileEntityTurret;

import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
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
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockTurret extends Block
{
    public BlockTurret(Material material)
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
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityTurret();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityTurret tile = (TileEntityTurret) world.getTileEntity(pos);

        if (tile != null)
        {
            tile.setDirection(MathHelper.floor(((placer.rotationYaw * 4F) / 360F) + 0.5D) & 3);
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntityTurret tile = (TileEntityTurret) world.getTileEntity(pos);

        if (tile != null)
        {
            if (!world.isRemote)
            {
                for (Class<? extends Entity> dangerousTarget: tile.getTargetHelper().getDangerousTargets())
                {
                    if (dangerousTarget != null)
                    {
                        AliensVsPredator.network().sendToAll(new PacketAddTurretTarget(pos.getX(), pos.getY(), pos.getZ(), Entities.getEntityRegistrationId(dangerousTarget)));
                    }
                }
            }
        }

        FMLNetworkHandler.openGui(player, AliensVsPredator.instance(), AliensVsPredator.interfaces().GUI_TURRET, world, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }
    
    @Override
    public void onPlayerDestroy(World world, BlockPos pos, IBlockState state)
    {
        super.onPlayerDestroy(world, pos, state);

        TileEntityTurret tile = (TileEntityTurret) world.getTileEntity(pos);

        if (tile != null)
        {
            if (!world.isRemote)
            {
                for (int i = 0; i < tile.inventoryAmmo.getSizeInventory(); i++)
                {
                    ItemStack stack = tile.inventoryAmmo.getStackInSlot(i);

                    if (stack != null)
                    {
                        EntityItem entityitem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                        entityitem.setPickupDelay(10);
                        world.spawnEntity(entityitem);
                    }
                }

                for (int i = 0; i < tile.inventoryExpansion.getSizeInventory(); i++)
                {
                    ItemStack stack = tile.inventoryExpansion.getStackInSlot(i);

                    if (stack != null)
                    {
                        EntityItem entityitem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                        entityitem.setPickupDelay(10);
                        world.spawnEntity(entityitem);
                    }
                }
            }

            // if (tile.getEntity() != null)
            // {
            // tile.getEntity().setDead();
            // }
        }
    }
    
    @Override
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn)
    {
        super.onExplosionDestroy(worldIn, pos, explosionIn);
        this.onPlayerDestroy(worldIn, pos, worldIn.getBlockState(pos));
    }
}
