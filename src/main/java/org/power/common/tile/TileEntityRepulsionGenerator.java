package org.power.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import org.avp.common.api.power.VoltageProvider;
import org.power.common.inventory.ContainerRepulsionGenerator;
import org.power.common.tile.helper.repulsion.InventorySetType;
import org.power.common.tile.helper.repulsion.RepulsionGeneratorSet;

/**
 * @author Ri5ux
 */
public class TileEntityRepulsionGenerator extends TileEntityElectrical implements VoltageProvider {
    public static final float MAX_SPEED = 10F;
    private static final float SPEED_MULTIPLIER = 0.05F;

    private float speed;
    private final RepulsionGeneratorSet primarySet;
    private final RepulsionGeneratorSet secondarySet;

    public TileEntityRepulsionGenerator() {
        super(true);
        this.primarySet = new RepulsionGeneratorSet(InventorySetType.PRIMARY);
        this.secondarySet = new RepulsionGeneratorSet(InventorySetType.SECONDARY);
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.getPos(), 1, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setFloat("RotationSpeed", this.speed);
        primarySet.writeToNBT(nbt);
        secondarySet.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.speed = nbt.getFloat("RotationSpeed");
        this.primarySet.readFromNBT(nbt);
        this.secondarySet.readFromNBT(nbt);
    }

    @Override
    public void update() {
        primarySet.update();
        secondarySet.update();
        this.updateSpeed();
        this.updateVoltage();
    }

    private void updateVoltage() {
        if (this.world.getTotalWorldTime() % (200 / this.getUpdateFrequency()) == 0) {
            this.setVoltage(this.getRotationSpeed() * 240 / MAX_SPEED);
        }
    }

    private void updateSpeed() {
        float proposedSpeed = (primarySet.getProposedSpeed() + secondarySet.getProposedSpeed()) * (MAX_SPEED / 2);

        if (this.speed < proposedSpeed)
        {
            this.speed = Math.min(this.speed + SPEED_MULTIPLIER, proposedSpeed);
        }
        else if (this.speed > proposedSpeed)
        {
            this.speed = Math.max(this.speed - SPEED_MULTIPLIER, 0);
        }
    }

    public InventoryBasic getInventory(InventorySetType inventorySetType) {
        return inventorySetType == InventorySetType.PRIMARY ? this.primarySet.getInventory() : this.secondarySet.getInventory();
    }

    @Override
    public boolean canConnectPower(EnumFacing from) {
        return true;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from) {
        return this.voltage;
    }

    @Override
    public double getMaxVoltage(EnumFacing from) {
        return 10000;
    }

    public Container getNewContainer(EntityPlayer player) {
        return new ContainerRepulsionGenerator(player, this);
    }

    public float getRotationSpeed() {
        return speed;
    }
}
