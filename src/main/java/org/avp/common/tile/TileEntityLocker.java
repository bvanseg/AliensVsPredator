package org.avp.common.tile;

import org.avp.AVP;
import org.avp.common.api.machines.IOpenable;
import org.avp.common.inventory.ContainerLocker;
import org.avp.common.item.firearms.ItemFirearm;
import org.avp.common.packets.client.PacketOpenable;

import com.asx.mdx.lib.world.tile.IRotatableYAxis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;


public class TileEntityLocker extends TileEntity implements IOpenable, IRotatableYAxis
{
    public IInventory inventory;
    private EnumFacing direction;
    public Container container;
    private boolean isOpen;
    public float openProgress;

    public TileEntityLocker()
    {
        super();
        this.isOpen = false;
        final TileEntityLocker locker = this;
        this.inventory = new InventoryBasic("container.locker.slots", true, 64)
        {
            @Override
            public boolean isItemValidForSlot(int slot, ItemStack stack)
            {
                return locker instanceof TileEntityGunLocker ? (stack.getItem() instanceof ItemFirearm) : (true);
            }
        };
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.getPos(), 1, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
    {
        this.readFromNBT(packet.getNbtCompound());
    }

    public Container getNewContainer(EntityPlayer player)
    {
        return (container = new ContainerLocker(player, this));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }

        if (this.inventory != null)
        {
            this.saveInventoryToNBT(nbt, inventory);
        }
        
        return nbt;
    }

    private void saveInventoryToNBT(NBTTagCompound nbt, IInventory inventory)
    {
        NBTTagList items = new NBTTagList();

        for (byte x = 0; x < inventory.getSizeInventory(); x++)
        {
            ItemStack stack = inventory.getStackInSlot(x);

            if (stack != null)
            {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", x);
                stack.writeToNBT(item);
                items.appendTag(item);
            }
        }

        nbt.setTag(inventory.getName(), items);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }

        this.readInventoryFromNBT(nbt, this.inventory);
    }

    private void readInventoryFromNBT(NBTTagCompound nbt, IInventory inventory)
    {
        NBTTagList items = nbt.getTagList(inventory.getName(), Constants.NBT.TAG_COMPOUND);

        for (byte x = 0; x < items.tagCount(); x++)
        {
            NBTTagCompound item = items.getCompoundTagAt(x);

            byte slot = item.getByte("Slot");

            if (slot >= 0 && slot <= inventory.getSizeInventory())
            {
                inventory.setInventorySlotContents(slot, new ItemStack(item));
            }
        }
    }

    public void openGui(EntityPlayer player)
    {
        if (!player.world.isRemote)
        {
            FMLNetworkHandler.openGui(player, AVP.instance(), AVP.interfaces().GUI_LOCKER, player.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
        }
    }
    
    @Override
    public EnumFacing getRotationYAxis()
    {
        return direction;
    }

    @Override
    public void setRotationYAxis(EnumFacing direction)
    {
        this.direction = direction;
    }

    @Override
    public void setOpen(boolean isOpen)
    {
        this.isOpen = isOpen;

        if (!this.world.isRemote)
        {
            AVP.network().sendToAll(new PacketOpenable(isOpen, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
        }
    }

    @Override
    public boolean isOpen()
    {
        return isOpen;
    }
}
