package org.avp.common.block;

import org.avp.common.AVPBlocks;
import org.avp.common.ItemHandler;
import org.avp.client.gui.GuiBlastdoor;
import org.avp.common.item.ItemMaintenanceJack;
import org.avp.common.tile.TileEntityBlastdoor;

import com.asx.mdx.lib.client.gui.notifications.Notification;
import com.asx.mdx.lib.client.gui.notifications.Notification.DynamicNotification;
import com.asx.mdx.lib.client.gui.notifications.Notifications;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBlastdoor extends Block
{
    private DynamicNotification notification = new DynamicNotification();

    public BlockBlastdoor(Material material)
    {
        super(material);
        setTickRandomly(true);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityBlastdoor)
        {
            TileEntityBlastdoor doorSubBlock = (TileEntityBlastdoor) tile;
            TileEntityBlastdoor blastdoor = null;

            if (doorSubBlock.isChild() && doorSubBlock.getParent() != null)
            {
                blastdoor = doorSubBlock.getParent();
            }
            else if (doorSubBlock.isParent())
            {
                blastdoor = doorSubBlock;
            }

            if (blastdoor != null)
            {
                if (blastdoor.isOperational() && player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() == ItemHandler.securityTuner)
                {
                    if (blastdoor.playerHoldingRequiredSecurityTuner(player))
                    {
                        if (FMLCommonHandler.instance().getSide() == Side.CLIENT && player.getName().equalsIgnoreCase(Game.minecraft().player.getName()))
                            showAdministrationGUI(blastdoor);
                    }
                }
                else if (canOpen(blastdoor, player))
                {
                    this.onOpen(blastdoor, world, player);
                }
                else if (blastdoor.isLocked() && blastdoor.isOperational())
                {
                    if (FMLCommonHandler.instance().getSide() == Side.CLIENT && player.getName().equalsIgnoreCase(Game.minecraft().player.getName()))
                        showUnlockGUI(blastdoor);
                }
            }
        }

        return true;
    }

    @SideOnly(Side.CLIENT)
    public static void showUnlockGUI(TileEntityBlastdoor blastdoor)
    {
        FMLCommonHandler.instance().showGuiScreen(new GuiBlastdoor(blastdoor));
    }

    @SideOnly(Side.CLIENT)
    public static void showAdministrationGUI(TileEntityBlastdoor blastdoor)
    {
        FMLCommonHandler.instance().showGuiScreen(new GuiBlastdoor(blastdoor, false));
    }

    private void onOpen(TileEntityBlastdoor blastdoor, World world, EntityPlayer player)
    {
        if (isOpenedByJack(blastdoor, player))
        {
            blastdoor.setBeingPryedOpen(true);
            blastdoor.setDoorProgress(blastdoor.getDoorProgress() + 0.05F);
            int percentOpen = (int) (((blastdoor.getDoorProgress() >= blastdoor.getMaxDoorPryProgress() ? blastdoor.getMaxDoorPryProgress() : blastdoor.getDoorProgress()) * 100) / blastdoor.getMaxDoorPryProgress());

            ItemMaintenanceJack jack = (ItemMaintenanceJack) player.getHeldItemMainhand().getItem();
            jack.onPryBlastDoor(player, player.getHeldItemMainhand());

            if (percentOpen >= 100)
            {
                jack.onOpenBlastDoor(player, player.getHeldItemMainhand());
            }

            if (world.isRemote)
            {
                this.notification.setDisplayTimeout(3);
                this.notification.setMessage("\u00A77 The blast door is \u00A7a" + percentOpen + "% open.");
                Notifications.sendNotification(this.notification);
            }
        }
        else
        {
            if (blastdoor != null)
            {
                blastdoor.setOpen(!blastdoor.isOpen());

                if (world.isRemote)
                {
                    final String value = (blastdoor.isOpen() ? "opened" : "closed");
                    Notifications.sendNotification(new Notification() {
                        @Override
                        public String getMessage()
                        {
                            return "\u00A77 Blast door \u00A7a" + value + ".";
                        }

                        @Override
                        public int displayTimeout()
                        {
                            return 20;
                        }
                    });
                }
            }
        }
    }

    private boolean isOpenedByJack(TileEntityBlastdoor blastdoor, EntityPlayer player)
    {
        return player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof ItemMaintenanceJack && !blastdoor.isOperational() && !blastdoor.isOpen();
    }

    private boolean canOpen(TileEntityBlastdoor blastdoor, EntityPlayer player)
    {
        return blastdoor.isOperational() && !blastdoor.isLocked() || isOpenedByJack(blastdoor, player);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityBlastdoor && placer != null)
        {
            TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) tile;

            blastdoor.setRotationYAxis(Entities.getEntityFacingRotY(placer));

            if (!blastdoor.setup(world, true))
            {
                world.setBlockToAir(pos);
            }
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityBlastdoor)
        {
            TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) tile;

            if (blastdoor.isChild())
            {
                if (blastdoor.getParent() != null)
                {
                    world.setBlockToAir(blastdoor.getParent().getPos());
                    blastdoor.getParent().breakChildren(world);
                }
            }
            else
            {
                blastdoor.breakChildren(world);
            }
        }

        world.removeTileEntity(pos);

        super.breakBlock(world, pos, state);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityBlastdoor();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        TileEntity tileEntity = worldIn.getTileEntity(pos);

        if (tileEntity != null && tileEntity instanceof TileEntityBlastdoor)
        {
            TileEntityBlastdoor tile = (TileEntityBlastdoor) tileEntity;

            if (tile.isOpen())
            {
                return null;
            }
            else
            {
                return blockState.getBoundingBox(worldIn, pos);
            }
        }

        return blockState.getBoundingBox(worldIn, pos);
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
    public boolean isFullBlock(IBlockState state)
    {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        TileEntity tile = world.getTileEntity(target.getBlockPos());

        if (tile instanceof TileEntityBlastdoor)
        {
            TileEntityBlastdoor door = (TileEntityBlastdoor) tile;

            if (door.isChild())
            {
                BlockPos parentPos = door.getParent().getPos();
                IBlockState parentState = world.getBlockState(parentPos);

                if (parentState != null)
                {
                    Block parentBlock = parentState.getBlock();

                    if (parentBlock != null)
                    {
                        Item itemblock = AVPBlocks.getItemFromBlock(parentBlock);

                        if (itemblock != null)
                        {
                            return new ItemStack(itemblock);
                        }
                    }
                }
            }
            else
            {
                BlockPos parentPos = door.getPos();
                IBlockState parentState = world.getBlockState(parentPos);
                return new ItemStack(AVPBlocks.getItemFromBlock(parentState.getBlock()));
            }
        }
        
        return null; // Null here means something went seriously wrong.
    }
}
