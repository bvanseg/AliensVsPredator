package org.avp.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.util.Constants;
import org.avp.common.AVPItems;
import org.avp.common.api.power.VoltageProvider;
import org.avp.common.inventory.ContainerRepulsionGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class TileEntityRepulsionGenerator extends TileEntityElectrical implements VoltageProvider
{
    public Container                               container;
    public InventoryBasic                          inventory;
    public float                                   speed;
    public static final float                      MAX_SPEED        = 10F;
    private static final float                     SPEED_MULTIPLIER = 0.05F;
    private final Item                             magnet           = AVPItems.ITEM_NEODYMIUM_MAGNET;
    private final ArrayList<HashMap<Integer, ItemStack>> sets             = new ArrayList<>();
    private int                                    fullSets;
    private int                                    emptySets;
    private int                                    unstableSets;
    private float                                  speedPerSet;
    private float                                  proposedSpeed;
    private long                                   ticksExisted;

    public TileEntityRepulsionGenerator()
    {
        super(true);
        this.inventory = new InventoryBasic("container.repulsiongenerator.slots", true, 10);
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

        nbt.setLong("TicksExisted", this.ticksExisted);
        nbt.setFloat("RotationSpeed", this.speed);
        nbt.setFloat("ProposedSpeed", this.proposedSpeed);

        if (this.inventory != null)
        {
            this.saveInventoryToNBT(nbt, inventory);
        }

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        this.ticksExisted = nbt.getLong("TicksExisted");
        this.speed = nbt.getFloat("RotationSpeed");
        this.proposedSpeed = nbt.getFloat("ProposedSpeed");
        this.readInventoryFromNBT(nbt, this.inventory);
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

    @Override
    public void update()
    {
        ticksExisted++;
        sets.clear();

        for (int i = this.inventory.getSizeInventory(); i > 0; i--)
        {
            ItemStack stack = (this.inventory.getStackInSlot(i - 1));
            int slotInSet = i % 5;

            if (slotInSet == 0)
            {
                sets.add(new HashMap<>());
            }

            if (slotInSet <= 4 && slotInSet > 0)
            {
                if (sets.size() > 0)
                {
                    sets.get(sets.size() - 1).put(slotInSet - 1, stack);
                }
            }
        }

        fullSets = 0;
        emptySets = 0;
        unstableSets = 0;

        for (HashMap<Integer, ItemStack> set : sets)
        {
            if (set.get(0) != null && set.get(1) != null && set.get(2) != null && set.get(3) != null && ((ItemStack) set.get(0)).getItem() == magnet && ((ItemStack) set.get(1)).getItem() == magnet && ((ItemStack) set.get(2)).getItem() == magnet && ((ItemStack) set.get(3)).getItem() == magnet)
            {
                fullSets++;
            }
            else if (set.get(0) == null && set.get(1) == null && set.get(2) == null && set.get(3) == null)
            {
                emptySets++;
            }
            else if (set.get(0) == null || set.get(1) == null || set.get(2) == null || set.get(3) == null)
            {
                unstableSets++;
            }
        }

        speedPerSet = MAX_SPEED / sets.size();
        proposedSpeed = fullSets * speedPerSet;

        // if (this.speed < this.MAX_SPEED)
        {
            if (this.speed < proposedSpeed)
            {
                this.speed += SPEED_MULTIPLIER;
            }
            else if (this.speed > proposedSpeed)
            {
                this.speed -= SPEED_MULTIPLIER;

                if (this.speed < 0)
                {
                    this.speed = 0;
                }
            }
        }

        if (ticksExisted % (200 / this.getUpdateFrequency()) == 0)
        {
            this.setVoltage(this.getRotationSpeed() * 240 / MAX_SPEED);
        }
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.voltage;
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 10000;
    }

    public Container getNewContainer(EntityPlayer player)
    {
        return (container = new ContainerRepulsionGenerator(player, this));
    }

    public float getRotationSpeed()
    {
        return speed;
    }

    public ArrayList<HashMap<Integer, ItemStack>> getSets()
    {
        return sets;
    }

    public int getFullSets()
    {
        return fullSets;
    }

    public int getEmptySets()
    {
        return emptySets;
    }

    public int getUnstableSets()
    {
        return unstableSets;
    }

    public float getSpeedPerSet()
    {
        return speedPerSet;
    }

    public float getProposedSpeed()
    {
        return proposedSpeed;
    }
}
