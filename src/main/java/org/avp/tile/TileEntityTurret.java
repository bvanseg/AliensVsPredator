package org.avp.tile;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.api.machines.IDataDevice;
import org.avp.api.power.IVoltageReceiver;
import org.avp.inventory.ContainerTurret;
import org.avp.packets.client.PacketTurretSync;
import org.avp.tile.helpers.TileEntityTurretAmmoHelper;
import org.avp.tile.helpers.TileEntityTurretAttackHelper;
import org.avp.tile.helpers.TileEntityTurretLookHelper;
import org.avp.tile.helpers.TileEntityTurretTargetHelper;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.storage.NBTStorage;
import com.asx.mdx.lib.world.tile.IRotatableYAxis;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * 
 * @author Ri5ux
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurret extends TileEntityElectrical implements IDataDevice, IVoltageReceiver, IRotatableYAxis
{
    private EnumFacing                          direction;
    public InventoryBasic                       inventoryExpansion;
    public InventoryBasic                       inventoryDrive;
    private ContainerTurret                     container;
    private Pos                                 pos;
	public int                                  beamColor;
	
    private final TileEntityTurretAmmoHelper    ammoHelper;
    private final TileEntityTurretTargetHelper  targetHelper;
    private final TileEntityTurretLookHelper    lookHelper;
    private final TileEntityTurretAttackHelper  attackHelper;

    public TileEntityTurret()
    {
        super(false);
        this.inventoryExpansion = new InventoryBasic("TurretExpansionBay", true, 3);
        this.inventoryDrive = new InventoryBasic("TurretDriveBay", true, 1);
        this.beamColor = 0xFFFF0000;
        
        this.ammoHelper = new TileEntityTurretAmmoHelper();
        this.targetHelper = new TileEntityTurretTargetHelper();
        this.lookHelper = new TileEntityTurretLookHelper(targetHelper);
        this.attackHelper = new TileEntityTurretAttackHelper(ammoHelper, lookHelper, targetHelper);
    }
    
    @Override
    public void onLoad() {
    	super.onLoad();
    	// This method is the earliest point from which we can initialize the tile entity's block position.
        this.pos = new Pos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
    }

    @Override
    public void update()
    {
        super.update();
        super.updateEnergyAsReceiver(); 
        
        // Don't do anything yet until the tile entity is aware of its world and position.
        if (this.world == null || this.pos == null) {
        	return;
        }

        if (this.getVoltage() > 0)
        {
        	this.getLookHelper().update(this.pos);
            this.getTargetHelper().update(this.world, this.pos, this.getLookHelper());
            this.getAmmoHelper().update(this.world, this.pos);
            this.getAttackHelper().update(this.world, this.pos, this.getLookHelper());
        }
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
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        
        this.getLookHelper().readFromNBT(nbt);
        this.getTargetHelper().readFromNBT(nbt);
        this.getAmmoHelper().readFromNBT(nbt);
        
        this.readInventoryFromNBT(nbt, this.getAmmoHelper().inventoryAmmo);
        this.readInventoryFromNBT(nbt, this.inventoryExpansion);
        this.readInventoryFromNBT(nbt, this.inventoryDrive);

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        
        this.getLookHelper().writeToNBT(nbt);
        this.getTargetHelper().writeToNBT(nbt);
        this.getAmmoHelper().writeToNBT(nbt);
        
        this.saveInventoryToNBT(nbt, this.getAmmoHelper().inventoryAmmo);
        this.saveInventoryToNBT(nbt, this.inventoryExpansion);
        this.saveInventoryToNBT(nbt, this.inventoryDrive);

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }

        return nbt;
    }

    private void sendSyncPacket()
    {
        AliensVsPredator.network().sendToAll(new PacketTurretSync(this));
    }

    public void onReceiveInitPacket(PacketTurretSync packet, MessageContext ctx)
    {
        this.applyUpgrades();
        this.getTargetHelper().readTargetList(packet.targets);
        this.getLookHelper().getRotation().yaw = packet.rotation.yaw;
        this.getLookHelper().getRotation().pitch = packet.rotation.pitch;
    }

    public void applyUpgrades() {
    	float turretRotateSpeed = this.getLookHelper().getTurretRotateSpeed();
        this.getAmmoHelper().setAmmoDisplayEnabled(false);

        for (int i = 0; i < 3; i++)
        {
            ItemStack pciSlot = this.inventoryExpansion.getStackInSlot(i);

            if (pciSlot.getItem() == AliensVsPredator.items().itemProcessor)
            {
                turretRotateSpeed += pciSlot.getCount() * (this.getLookHelper().getTurretRotateSpeed() / 64f);
            }

            if (pciSlot.getItem() == AliensVsPredator.items().itemLedDisplay)
            {
                this.getAmmoHelper().setAmmoDisplayEnabled(true);
            }
        }
        
        this.getLookHelper().setTurretRotateSpeed(turretRotateSpeed);
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

    public ContainerTurret getNewContainer(EntityPlayer player)
    {
        return (container = new ContainerTurret(player, this, world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
    }

    public ContainerTurret getContainer(EntityPlayer player)
    {
        return container == null && player != null ? container = getNewContainer(player) : container;
    }

    @Override
    public void readFromOtherDevice(int ID)
    {
        ItemStack devicePort = this.inventoryDrive.getStackInSlot(0);

        NBTTagCompound nbt = devicePort.getTagCompound();

        if (nbt != null)
        {
            NBTTagList list = nbt.getTagList("Targets", NBT.TAG_STRING);

            if (list != null)
            {
                for (int i = 0; i < list.tagCount(); i++)
                {
                    String id = list.getStringTagAt(i);

                    EntityEntry entityEntry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(AliensVsPredator.Properties.ID, id));

                    for (EntityEntry e : ForgeRegistries.ENTITIES.getValues())
                    {
                        if (id.equalsIgnoreCase(e.getRegistryName().toString()))
                        {
                            entityEntry = e;
                        }
                    }

                    if (entityEntry != null)
                    {
                        Class<? extends Entity> c = entityEntry.getEntityClass();
                        this.getTargetHelper().addTargetType(c);
                    } else {
                        MDX.log().warn("NULL EntityEntry found in NBTDrive for id " + id);
                    }
                }
            }
        }

        this.sendSyncPacket();
    }

    @Override
    public void writeToOtherDevice(int ID)
    {
        if (container != null)
        {
            ItemStack devicePort = this.inventoryDrive.getStackInSlot(0);

            NBTTagCompound nbt = new NBTTagCompound();
            ArrayList<String> entityIDs = new ArrayList<String>();

            for (Class<? extends Entity> c : this.getTargetHelper().getDangerousTargets())
            {
                if (c != null)
                {
                    entityIDs.add(Entities.getEntityRegistrationId(c));
                }
            }

            nbt.setTag("Targets", NBTStorage.newStringNBTList(entityIDs));

            devicePort.setTagCompound(nbt);
            devicePort.setStackDisplayName("NBT Drive - " + "TURRET." + this.pos.x + "" + this.pos.y + "" + this.pos.z);
            this.inventoryDrive.setInventorySlotContents(0, devicePort);
        }
    }

    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate)
    {
        return super.receiveVoltage(from, maxReceive, simulate);
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.getVoltage();
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 220;
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

	public TileEntityTurretAmmoHelper getAmmoHelper() {
		return this.ammoHelper;
	}

	public TileEntityTurretAttackHelper getAttackHelper() {
		return this.attackHelper;
	}

	public TileEntityTurretLookHelper getLookHelper() {
		return this.lookHelper;
	}

	public TileEntityTurretTargetHelper getTargetHelper() {
		return this.targetHelper;
	}
}
