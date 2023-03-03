package org.avp.tile;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.api.machines.IDataDevice;
import org.avp.api.power.IVoltageReceiver;
import org.avp.client.Sounds;
import org.avp.inventory.ContainerTurret;
import org.avp.packets.client.PacketTurretSync;
import org.avp.packets.server.PacketTurretTargetUpdate;
import org.avp.tile.helpers.TileEntityTurretAmmoHelper;
import org.avp.tile.helpers.TileEntityTurretLookHelper;
import org.avp.tile.helpers.TileEntityTurretTargetHelper;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.storage.NBTStorage;

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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityTurret extends TileEntityElectrical implements IDataDevice, IVoltageReceiver
{
    private boolean                            isFiring;
    private int                                fireRate;
    private int                                timeout;
    private int                                timeoutMax;
    public InventoryBasic                      inventoryExpansion;
    public InventoryBasic                      inventoryDrive;
    private ContainerTurret                    container;
    private Pos                                pos;
    public int                                 beamColor;
    
    private TileEntityTurretAmmoHelper         ammoHelper;
    private TileEntityTurretLookHelper         lookHelper;
    private TileEntityTurretTargetHelper       targetHelper;

    public TileEntityTurret()
    {
        super(false);
        this.inventoryExpansion = new InventoryBasic("TurretExpansionBay", true, 3);
        this.inventoryDrive = new InventoryBasic("TurretDriveBay", true, 1);
        this.fireRate = 2;
        this.timeoutMax = 60;
        this.beamColor = 0xFFFF0000;
        
        this.ammoHelper = new TileEntityTurretAmmoHelper(world, pos);
        this.lookHelper = new TileEntityTurretLookHelper(pos);
        this.targetHelper = new TileEntityTurretTargetHelper(world, pos);
    }

    @Override
    public void update()
    {
        super.update();
        super.updateEnergyAsReceiver();

        if (this.pos == null)
        {
            this.pos = new Pos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
        }
        else
        {
            this.pos.x = this.getPos().getX();
            this.pos.y = this.getPos().getY();
            this.pos.z = this.getPos().getZ();
        }

        this.isFiring = false;

        if (this.getVoltage() > 0)
        {
            this.timeout = this.timeout > 0 ? this.timeout - 1 : this.timeout;
            this.ammoHelper.update();
            this.targetHelper.update();
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

        this.lookHelper.getFocusRotation().setYaw(nbt.getFloat("FocusYaw")).setPitch(nbt.getFloat("FocusPitch"));
        this.readTargetListFromCompoundTag(nbt);
        this.readInventoryFromNBT(nbt, this.ammoHelper.inventoryAmmo);
        this.readInventoryFromNBT(nbt, this.inventoryExpansion);
        this.readInventoryFromNBT(nbt, this.inventoryDrive);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        nbt.setFloat("FocusYaw", this.lookHelper.getFocusRotation().yaw);
        nbt.setFloat("FocusPitch", this.lookHelper.getFocusRotation().pitch);
        nbt.setTag("Targets", this.getTargetListTag());
        this.saveInventoryToNBT(nbt, this.ammoHelper.inventoryAmmo);
        this.saveInventoryToNBT(nbt, this.inventoryExpansion);
        this.saveInventoryToNBT(nbt, this.inventoryDrive);

        return nbt;
    }

    private void sendSyncPacket()
    {
        AliensVsPredator.network().sendToAll(new PacketTurretSync(this));
    }

    public void onReceiveInitPacket(PacketTurretSync packet, MessageContext ctx)
    {
        this.applyUpgrades();
        this.readTargetList(packet.targets);
        this.lookHelper.getRotation().yaw = packet.rotation.yaw;
        this.lookHelper.getRotation().pitch = packet.rotation.pitch;
    }

    @SideOnly(Side.CLIENT)
    public void onReceiveTargetUpdatePacket(PacketTurretTargetUpdate packet, MessageContext ctx)
    {
        Entity entity = Game.minecraft().world.getEntityByID(packet.id);
        this.targetHelper.setTargetEntity(entity);
        this.lookHelper.setFocusPosition(packet.foc);
        this.lookHelper.setFocusRotation(packet.focrot);
    }

    public void fire() {
        this.isFiring = true;
        this.timeout = this.timeoutMax;
        this.targetHelper.getTargetEntity().attackEntityFrom(DamageSources.bullet, 1F);
        this.targetHelper.getTargetEntity().hurtResistantTime = 0;
        // this.world.spawnParticle(EnumParticleTypes.CLOUD, this.pos.x, this.pos.y,
        // this.pos.z, 0, 10, 0);
        Sounds.WEAPON_M56SG.playSound(this.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), 1F, 1F);
    }

    public void applyUpgrades()
    {
        int cycles = this.lookHelper.getBaseCycleCount();
        this.ammoHelper.setAmmoDisplayEnabled(false);

        for (int i = 0; i < 3; i++)
        {
            ItemStack pciSlot = this.inventoryExpansion.getStackInSlot(i);

            if (pciSlot.getItem() == AliensVsPredator.items().itemProcessor)
            {
                cycles += pciSlot.getCount();
            }

            if (pciSlot.getItem() == AliensVsPredator.items().itemLedDisplay)
            {
                this.ammoHelper.setAmmoDisplayEnabled(true);
            }
        }

        this.lookHelper.setCycleCount(cycles);
    }

    public NBTTagList getTargetListTag()
    {
        ArrayList<String> entityIDs = new ArrayList<String>();

        for (Class<? extends Entity> c : this.targetHelper.getDangerousTargets())
        {
            entityIDs.add(Entities.getEntityRegistrationId(c));
        }

        return NBTStorage.newStringNBTList(entityIDs);
    }

    public void readTargetListFromCompoundTag(NBTTagCompound nbt)
    {
        NBTTagList list = nbt.getTagList("Targets", NBT.TAG_STRING);
        this.readTargetList(list);
    }

    public void readTargetList(NBTTagList list)
    {
        for (int i = 0; i < list.tagCount(); i++)
        {
            String id = list.getStringTagAt(i);

            ResourceLocation identifier = new ResourceLocation(id);
            EntityEntry entityEntry = ForgeRegistries.ENTITIES.getValue(identifier);
            Class<? extends Entity> entityClass = (Class<? extends Entity>) entityEntry.getEntityClass();
            this.targetHelper.addTargetType(entityClass);
        }
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

    public long getFireRate()
    {
        return fireRate;
    }

    public void setFireRate(int fireRate)
    {
        this.fireRate = fireRate;
    }

    public boolean isFiring()
    {
        return isFiring;
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
                        this.targetHelper.addTargetType(c);
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

            for (Class<? extends Entity> c : this.targetHelper.getDangerousTargets())
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

	public TileEntityTurretAmmoHelper getAmmoHelper() {
		return this.ammoHelper;
	}

	public TileEntityTurretLookHelper getLookHelper() {
		return this.lookHelper;
	}

	public TileEntityTurretTargetHelper getTargetHelper() {
		return this.targetHelper;
	}
}
