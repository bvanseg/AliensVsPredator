package org.avp.common.tile;

import com.asx.mdx.lib.world.block.IMultiBlock;
import com.asx.mdx.lib.world.tile.IRotatableYAxis;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;
import org.avp.common.AVPBlocks;
import org.avp.common.api.power.IVoltageReceiver;
import org.avp.common.inventory.ContainerNetworkRack;

import java.util.ArrayList;
import java.util.List;

public class TileEntityNetworkRack extends TileEntityElectrical implements IRotatableYAxis, IVoltageReceiver, IMultiBlock
{
    private boolean               isParent;
    private boolean               placedByPlayer;
    private TileEntity            parent;
    private ArrayList<TileEntity> children;
    private int                   ticksExisted;
    private EnumFacing            direction;
    public InventoryBasic         inventory;
    public Container              container;

    public TileEntityNetworkRack()
    {
        super(false);
        this.children = new ArrayList<TileEntity>();
        this.inventory = new InventoryBasic("container.networkrack.slots", true, 4);
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
        return (container = new ContainerNetworkRack(player, this));
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
        
        nbt.setBoolean("Parent", this.isParent);

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
    public void update()
    {
        super.update();
        this.updateMultiblock(this.world);
        this.updateMultiblockPower();
    }

    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 220;
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
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }

        this.readInventoryFromNBT(nbt, this.inventory);
        
        this.isParent = nbt.getBoolean("Parent");
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
    public EnumFacing getRotationYAxis()
    {
        return this.direction;
    }

    @Override
    public void setRotationYAxis(EnumFacing facing)
    {
        this.direction = facing;
    }
    
    private void updateMultiblockPower()
    {
        if (!this.isParent())
        {
            this.updateEnergyAsReceiver();
        }

        if (this.isChild())
        {
            if (this.getParent() != null && this.getVoltage() > this.getParent().getVoltage())
            {
                this.getParent().setVoltage(this.getVoltage());
            }
        }

        if (this.isParent)
        {
            double childrenVoltage = 0.0D;

            for (TileEntity c : this.getChildren())
            {
                if (c instanceof TileEntityElectrical)
                {
                    TileEntityElectrical child = (TileEntityElectrical) c;
                    
                    if (child.getVoltage() > 0.0D && child.getVoltage() > childrenVoltage)
                    {
                        childrenVoltage = child.getVoltage();
                    }
                }
            }

            if (childrenVoltage <= 0)
            {
                this.updateEnergyAsReceiver();
            }
        }
    }

    @Override
    public BlockPos[] defaultSet()
    {
        List<BlockPos> set = new ArrayList<BlockPos>();
        BlockPos pos = new BlockPos(0, 0, 0);

        set.add(pos.add(0, 0, 0));
        set.add(pos.add(-1, 0, 0));
        set.add(pos.add(0, 1, 0));
        set.add(pos.add(-1, 1, 0));
        set.add(pos.add(0, 2, 0));
        set.add(pos.add(-1, 2, 0));

        return set.toArray(new BlockPos[set.size()]);
    }

    @Override
    public ArrayList<TileEntity> getChildren()
    {
        return this.children;
    }

    @Override
    public boolean isChild()
    {
        return !this.isParent();
    }

    @Override
    public boolean isParent()
    {
        return this.isParent;
    }

    @Override
    public TileEntityNetworkRack getParent()
    {
        return (TileEntityNetworkRack) parent;
    }

    @Override
    public void setParent(TileEntity parent)
    {
        this.parent = parent;
    }

    @Override
    public void setPlacedByPlayer()
    {
        this.placedByPlayer = true;
    }

    @Override
    public boolean isPlacedByPlayer()
    {
        return this.placedByPlayer;
    }

    @Override
    public void setTileParent()
    {
        this.isParent = true;
    }

    @Override
    public void setTileChild()
    {
        this.isParent = false;
    }

    @Override
    public String getMultiblockName()
    {
        return "Blast Door";
    }

    @Override
    public Block getMultiBlockType()
    {
        return AVPBlocks.NETWORK_RACK;
    }
    
    @Override
    public void tick()
    {
        this.ticksExisted++;
    }
    
    @Override
    public int getTicksExisted()
    {
        return this.ticksExisted;
    }
}
