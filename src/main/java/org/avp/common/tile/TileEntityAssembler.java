package org.avp.common.tile;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import org.avp.AVP;
import org.avp.common.inventory.ContainerAssembler;
import org.avp.common.item.crafting.AssemblyManager;

public class TileEntityAssembler extends TileEntity implements IInventory, ITickable
{
    private Item               randomItem  = AVP.items().biomaskCeltic;
    private ItemStack[]        items       = new ItemStack[28];
    private ItemStack          previousTickStack;
    public int                 clickAmount = 0;
    private ContainerAssembler container;
	
	public float rotateProgress;

    public TileEntityAssembler()
    {
        ;
    }

    @Override
    public int getSizeInventory()
    {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return items[i];
    }

    @Override
    public void update()
    {
        if (this.getWorld().getTotalWorldTime() % 20 == 0)
        {
            if (this.getWorld().rand.nextInt(3) == 0)
            {
                this.randomItem = AssemblyManager.instance.schematics().get(this.getWorld().rand.nextInt(AssemblyManager.instance.schematics().size())).getItemStackAssembled().getItem();
            }
        }

        if (previousTickStack != getStackInSlot(27) && getStackInSlot(27) != null)
        {
            setInventorySlotContents(26, null);
        }

        if (clickAmount >= 10)
        {
            this.shiftCraftResult();
            clickAmount = 0;
        }

        previousTickStack = getStackInSlot(27);
    }

    private void shiftCraftResult()
    {
        if (getStackInSlot(26) == null && getStackInSlot(27) != null)
        {
            this.setInventorySlotContents(26, this.getStackInSlot(27));
            this.setInventorySlotContents(27, (ItemStack) null);
        }
    }

    @Override
    public ItemStack decrStackSize(int i, int count)
    {
        ItemStack stack = this.getStackInSlot(i);

        if (stack != null)
        {
            if (stack.getCount() <= count)
            {
                setInventorySlotContents(i, null);
            }
            else
            {
                stack = stack.splitStack(count);
                markDirty();
            }
        }

        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int i)
    {
        ItemStack stack = getStackInSlot(i);
        setInventorySlotContents(i, null);

        return stack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack)
    {
        items[i] = stack;

        if (stack != null && stack.getCount() > getInventoryStackLimit())
        {
            stack.setCount(getInventoryStackLimit());
        }

        super.markDirty();
    }

    @Override
    public String getName()
    {
        return "ElectricalWorkbench";
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return player.getDistanceSq(this.getPos().getX() + 0.5D, this.getPos().getY(), this.getPos().getZ() + 0.5D) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
        ;
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
        ;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if (slot == 25)
        {
            return TileEntityFurnace.getItemBurnTime(stack) > 313;

        }
        else if (slot == 26 || slot == 27)
        {

            return false;

        }
        else
        {

            return true;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        NBTTagList items = new NBTTagList();

        for (byte x = 0; x < this.getSizeInventory(); x++)
        {

            ItemStack stack = this.getStackInSlot(x);

            if (stack != null)
            {

                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", x);
                stack.writeToNBT(item);
                items.appendTag(item);
            }
        }

        nbt.setTag("Items", items);

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);

        for (byte x = 0; x < items.tagCount(); x++)
        {
            NBTTagCompound item = items.getCompoundTagAt(x);

            byte slot = item.getByte("Slot");

            if (slot >= 0 && slot <= this.getSizeInventory())
            {
                setInventorySlotContents(slot, new ItemStack(item));
            }
        }
    }

    public ContainerAssembler getNewContainer(EntityPlayer player)
    {
        return (container = new ContainerAssembler(player.inventory, this, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
    }

    public ContainerAssembler getCurrentContainer()
    {
        return container;
    }

    public void openGui(EntityPlayer player)
    {
        if (!player.world.isRemote)
        {
            FMLNetworkHandler.openGui(player, AVP.instance(), AVP.interfaces().GUI_ASSEMBLER, player.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
        }
    }

    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
    }

    public Item getRandomItem()
    {
        return this.randomItem;
    }

    
    //TODO: Implement New Functions
    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value)
    {
        
    }

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {
        ;
    }

    @Override
    public boolean isEmpty()
    {
        return this.items.length <= 0;
    }
}
