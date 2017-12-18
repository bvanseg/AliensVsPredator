package org.avp.tile;

import org.avp.api.power.IVoltageProvider;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;


public abstract class TileEntityElectrical extends TileEntity implements ITickable
{
    protected double voltage;
    protected double voltagePrev;
    protected double srcVoltage;
    protected double thresholdVoltage;
    protected double resistance;
    protected double boost;
    protected int updateFrequency;
    protected boolean isSrc;

    public TileEntityElectrical(boolean isSource)
    {
        this.isSrc = isSource;
        this.thresholdVoltage = 110;
        this.srcVoltage = 120;
        this.updateFrequency = 50;
        /** 1000 / 50Hz = 20 Ticks **/
        this.resistance = 0.1;
        this.boost = 0;
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

    /**
     * Saves the amount of voltage this component contains to the world.
     */
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setDouble("voltage", this.voltage);
        
        return nbt;
    }

    /**
     * Loads the amount of voltage this component contains from the world.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.voltage = nbt.getDouble("voltage");
    }

    /**
     * @return Returns true if this component is currently operational.
     */
    public boolean isOperational()
    {
        return this.getVoltage() >= this.getThresholdVoltage();
    }

    /**
     * @return Returns the amount of resistance this component applies.
     */
    public double getResistance()
    {
        return resistance;
    }

    /**
     * @param resistance - The amount of resistance this component will apply 
     * on components extracting energy from it.
     */
    public void setResistance(double resistance)
    {
        this.resistance = resistance;
    }

    /**
     * @return The threshold voltage required for this component to operate.
     */
    public double getThresholdVoltage()
    {
        return thresholdVoltage;
    }

    /**
     * @param thresholdVoltage - The threshold voltage required for this 
     * component to operate.
     */
    public void setThresholdVoltage(double thresholdVoltage)
    {
        this.thresholdVoltage = thresholdVoltage;
    }

    /**
     * @param side - EnumFacing from the receiver. 
     * @return If this side can provide energy to the receiver.
     */
    public boolean canProvideEnergyToReceiver(EnumFacing side)
    {
        return true;
    }

    /**
     * @return The amount of voltage this component currently contains.
     */
    public double getVoltage()
    {
        return this.voltage;
    }

    /**
     * @param voltage - The amount of voltage this component should contain.
     */
    public void setVoltage(double voltage)
    {
        this.voltage = voltage;
    }

    /**
     * @return The amount of boost this component currently contains.
     */
    public double getBoost()
    {
        return this.boost;
    }

    /**
     * @param rf - The amount of boost this component should contain.
     */
    public void setBoost(double boost)
    {
        this.boost = boost;
    }

    /**
     * @return The rate at which this source component will update its voltage.
     */
    public int getUpdateFrequency()
    {
        return updateFrequency;
    }

    /**
     * @param freq - The rate at which this source component should update its voltage.
     */
    public void setUpdateFrequency(int freq)
    {
        this.updateFrequency = freq;
    }

    /**
     * @return The voltage this source component provides.
     */
    public double getSourceVoltage()
    {
        return srcVoltage;
    }

    /**
     * @return The Source Direction that a receiver can extract from
     */
    public EnumFacing getSourcePowerDirection()
    {
        return null;
    }

    /**
     * @param srcVoltage - The voltage this source component should provide.
     */
    public void setSourceVoltage(double srcVoltage)
    {
        this.srcVoltage = srcVoltage;
    }

    /**
     * @return True if this is a source component.
     */
    public boolean isSource()
    {
        return this.isSrc;
    }

    /**
     * @param isSrc - Set true if this should be a source component.
     */
    public void setIsSource(boolean isSrc)
    {
        this.isSrc = isSrc;
    }
    
    @Override
    public void update()
    {
        ;
    }

    /**
     * Updates the voltage of this component based on surrounding components.
     */
    public void updateEnergyAsReceiver()
    {
        this.voltagePrev = this.voltage;

        for (EnumFacing direction : EnumFacing.VALUES)
        {
            TileEntity tile = this.world.getTileEntity(this.getPos().offset(direction));

            if (tile != null && tile instanceof TileEntityElectrical)
            {
                TileEntityElectrical electrical = (TileEntityElectrical) tile;

                if (electrical instanceof IVoltageProvider)
                {
                    IVoltageProvider provider = (IVoltageProvider) electrical;

                    if (electrical.canProvideEnergyToReceiver(direction) && provider.canConnectPower(direction) && electrical.getVoltage() > this.getVoltage())
                    {
                        this.receiveVoltage(direction.getOpposite(), provider.extractVoltage(direction.getOpposite(), electrical.getVoltage() - this.getVoltage(), false), false);
                    }
                }
            }
        }

        TileEntity surroundingTile = null;

        for (EnumFacing direction : EnumFacing.VALUES)
        {
            TileEntity tile = this.world.getTileEntity(this.getPos().offset(direction));

            if (tile != null && tile instanceof TileEntityElectrical)
            {
                TileEntityElectrical tee = (TileEntityElectrical) tile;

                if (tee.getBoost() == 0 && tee.getVoltage() > this.getVoltage() && tile instanceof IVoltageProvider)
                {
                    surroundingTile = tile;
                }
                else if (tee.getVoltage() > 0 && tee.getBoost() != 0 && direction == tee.getSourcePowerDirection())
                {
                    surroundingTile = tile;
                }
            }
        }

        if (surroundingTile == null || this.getVoltage() < 0)
        {
            this.setVoltage(0);
        }

    }

    /**
     * Returns the amount of energy to be extracted from this component.
     * 
     * @param from - The direction this request was sent from.
     * @param maxExtract - The amount of energy we're trying to extract.
     * @param simulate - If true, this request will only be simulated.
     * @return - The amount of energy to be extracted.
     */
    public double extractVoltage(EnumFacing from, double maxExtract, boolean simulate)
    {
        TileEntity tile = this.world.getTileEntity(this.getPos().offset(from));

        if (tile != null && tile instanceof TileEntityElectrical)
        {
            return maxExtract - this.getResistance();
        }

        return 0;
    }

    /**
     * Returns the amount of energy this component will contain after adding 
     * the specified amount of energy.
     * 
     * @param from - The direction this request was sent from.
     * @param maxReceive - The amount of energy this component is receiving.
     * @param simulate - If true, this request will only be simulated.
     * @return The amount of energy this component will contain after adding 
     * the specified amount of energy.
     */
    public double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate)
    {
        if (this.canReceiveVoltageFromSide(from))
        {
            double result = this.getVoltage() + maxReceive;

            if (!simulate)
            {
                this.setVoltage(result);
            }

            return result;
        }
        return this.voltage;
    }
    
    public boolean canReceiveVoltageFromSide(EnumFacing from)
    {
        return true;
    }
}
