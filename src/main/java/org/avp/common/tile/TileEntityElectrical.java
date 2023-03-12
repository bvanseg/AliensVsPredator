package org.avp.common.tile;

import java.util.Random;

import org.avp.common.DamageSources;
import org.avp.common.api.power.IPowerConnection;
import org.avp.common.api.power.IVoltageProvider;
import org.avp.common.api.power.IVoltageReceiver;

import com.asx.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class TileEntityElectrical extends TileEntity implements ITickable, IPowerConnection
{
    protected double  voltage;
    protected double  voltagePrev;
    protected double  srcVoltage;
    protected double  thresholdVoltage;
    protected double  resistance;
    protected double  boost;
    protected int     updateFrequency;
    protected boolean isSrc;

    public TileEntityElectrical(boolean isSource)
    {
        this.isSrc = isSource;
        this.thresholdVoltage = 110;
        this.srcVoltage = 120;
        this.updateFrequency = 50;/** 1000 / 50Hz = 20 Ticks **/
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
     * @param resistance
     *            - The amount of resistance this component will apply on components extracting energy
     *            from it.
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
     * @param thresholdVoltage
     *            - The threshold voltage required for this component to operate.
     */
    public void setThresholdVoltage(double thresholdVoltage)
    {
        this.thresholdVoltage = thresholdVoltage;
    }

    /**
     * @param side
     *            - EnumFacing from the receiver.
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
     * @param voltage
     *            - The amount of voltage this component should contain.
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
     * @param rf
     *            - The amount of boost this component should contain.
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
     * @param freq
     *            - The rate at which this source component should update its voltage.
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
     * @param srcVoltage
     *            - The voltage this source component should provide.
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
     * @param isSrc
     *            - Set true if this should be a source component.
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

        TileEntity surroundingTile = null;

        for (EnumFacing direction : EnumFacing.VALUES)
        {
            TileEntity t = this.world.getTileEntity(this.getPos().offset(direction));

            if (t != null && t instanceof TileEntityElectrical)
            {
                TileEntityElectrical e = (TileEntityElectrical) t;

                if (e instanceof IVoltageProvider)
                {
                    IVoltageProvider provider = (IVoltageProvider) e;

                    /** Check if we can pull power from surrounding providers **/
                    if (e.canProvideEnergyToReceiver(direction) && provider.canConnectPower(direction))
                    {
                        /** Make sure this receiver can accept power on the side we're pulling power from **/
                        if (this.canReceiveVoltageFromSide(direction))
                        {
                            /** Make sure the provider has a higher voltage than this receiver does **/
                            if (e.getVoltage() > this.getVoltage())
                            {
                                double newVoltage = provider.extractVoltage(direction.getOpposite(), e.getVoltage() - this.getVoltage(), false);
                                this.receiveVoltage(direction.getOpposite(), newVoltage, false);
                            }
                        }
                    }
                }

                if (e.getBoost() == 0 && e.getVoltage() > this.getVoltage() && t instanceof IVoltageProvider)
                {
                    surroundingTile = t;
                }
                else if (e.getVoltage() > 0 && e.getBoost() != 0 && direction == e.getSourcePowerDirection())
                {
                    surroundingTile = t;
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
     * @param from
     *            - The direction this request was sent from.
     * @param maxExtract
     *            - The amount of energy we're trying to extract.
     * @param simulate
     *            - If true, this request will only be simulated.
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
     * Returns the amount of energy this component will contain after adding the specified amount of
     * energy.
     * 
     * @param from
     *            - The direction this request was sent from.
     * @param maxReceive
     *            - The amount of energy this component is receiving.
     * @param simulate
     *            - If true, this request will only be simulated.
     * @return The amount of energy this component will contain after adding the specified amount of
     *         energy.
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
    
    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    public boolean canReceiveVoltageFromSide(EnumFacing from)
    {
        return this.canConnectPower(from);
    }

    public int getNearbyConnectionCount()
    {
        int connections = 0;

        for (EnumFacing direction : EnumFacing.VALUES)
        {
            TileEntity tile = this.world.getTileEntity(this.getPos().offset(direction));

            if (tile != null && tile instanceof TileEntityElectrical)
            {
                TileEntityElectrical electrical = (TileEntityElectrical) tile;

                if (electrical instanceof IVoltageProvider)
                {
                    IVoltageProvider provider = (IVoltageProvider) electrical;

                    if (electrical.canProvideEnergyToReceiver(direction) && provider.canConnectPower(direction))
                    {
                        connections++;
                    }
                }

                if (electrical instanceof IVoltageReceiver)
                {
                    if (electrical.getVoltage() < this.getVoltage())
                    {
                        connections++;
                    }
                }
            }
        }

        return connections;
    }

    public boolean canArc()
    {
        if (this.voltage > 600 && this.world.getTotalWorldTime() % 8 == 0)
        {
            return getNearbyConnectionCount() <= 1;
        }

        return false;
    }

    public Pos getArcOrigin()
    {
        Pos pos = new Pos(this.pos);
        return pos.add(0.5D, 0.5D, 0.5D);
    }

    public void tryElectricArc()
    {
        if (canArc())
        {
            Random rand = new Random();
            double maxArcDist = (this.getVoltage() / 600);
            float m = 1.75F;
            Pos origin = this.getArcOrigin();
            Pos t = getNextGroundingPoint(this, origin.add(0, 1, 0), this.world);
            Entity target = Entities.getRandomEntityInCoordsRange(world, EntityLivingBase.class, new Pos(this), (int) Math.floor(maxArcDist));
            double distG = origin.y - t.y;
            double distE = 1000;
            double dist = distG;
            double arcWidth = MDXMath.map((double) this.voltage, 600D, 10000D, 0.05D, 0.5D);
            float damageMult = (float) (arcWidth * 100F);

            if (target != null)
            {
                Pos p = new Pos(target.getPosition()).add(target.width / 2, 0, target.width / 2);
                distE = target.getDistance(origin.x, origin.y, origin.z);

                if (distE <= distG && distE <= maxArcDist)
                {
                    t = p;
                    m = 8F;
                    dist = distE;
                    target.attackEntityFrom(DamageSources.electricity, damageMult);
                    target.setFire(3);
                }
            }

            if (dist <= maxArcDist)
            {
                if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
                {
                    this.spawnArc(t, m, rand, dist, origin, arcWidth);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void spawnArc(Pos t, float m, Random rand, double dist, Pos origin, double arcWidth)
    {
        float targetX = (float) (t.x + (rand.nextFloat() / m) - (rand.nextFloat() / m));
        float targetY = (float) (t.y + 1);
        float targetZ = (float) (t.z + (rand.nextFloat() / m) - (rand.nextFloat() / m));
        int age = 4;
        int color = 0xFF8866CC;
        EntityFXElectricArc arc = new EntityFXElectricArc(world, origin.x, origin.y, origin.z, targetX, targetY, targetZ, age, 0.24F * dist, 0.1F, (float) arcWidth, color);
        Game.minecraft().effectRenderer.addEffect(arc);
    }

    public static Pos getNextGroundingPoint(TileEntityElectrical electrical, Pos pos, World world)
    {
        for (int y = (int) pos.y - 1; y > 0; y--)
        {
            Pos position = new Pos(pos.x, y - 1, pos.z);
            Block b = position.getBlock(world);

            if (b != net.minecraft.init.Blocks.AIR)
            {
                return position;
            }
        }

        return pos;
    }
}
