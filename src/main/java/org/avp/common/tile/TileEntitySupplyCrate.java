package org.avp.common.tile;

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
import org.avp.AVP;
import org.avp.common.AVPGui;
import org.avp.common.AVPNetworking;
import org.avp.common.api.machines.Openable;
import org.avp.common.inventory.ContainerSupplyCrate;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.avp.common.network.packet.client.PacketOpenable;


public class TileEntitySupplyCrate extends TileEntity implements Openable, IRotatableYAxis
{
	public InventoryBasic inventory;
	private EnumFacing direction;
	public Container container;
	private boolean isOpen;
	private SupplyChuteType type;

	public TileEntitySupplyCrate()
	{
		super();
		this.isOpen = false;
		this.inventory = new InventoryBasic("container.supplycrate.slots", true, 64);
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
		
		if (this.type != null)
		{
		    nbt.setInteger("Type", this.type.id());
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
		this.type = SupplyChuteType.get(nbt.getInteger("Type"));
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
			FMLNetworkHandler.openGui(player, AVP.instance, AVPGui.GUI_SUPPLYCRATE, player.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
		}
	}

	public Container getNewContainer(EntityPlayer player)
	{
		return (container = new ContainerSupplyCrate(player, this));
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
			AVPNetworking.instance.sendToAll(new PacketOpenable(isOpen, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
		}
	}

	@Override
	public boolean isOpen()
	{
		return isOpen;
	}
	
	public SupplyChuteType getType()
    {
        return type;
    }
	
	public void setType(SupplyChuteType type)
    {
        this.type = type;
    }
}
