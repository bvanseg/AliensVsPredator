package org.avp.common.tile;

import com.asx.mdx.lib.world.tile.IRotatableXAxis;
import com.asx.mdx.lib.world.tile.IRotatableYAxis;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import org.avp.common.api.power.IVoltageProvider;

public class TileEntityCCFLTube extends TileEntityLightPanel implements IVoltageProvider, IRotatableYAxis, IRotatableXAxis
{
    private EnumFacing rotationX;
    private EnumFacing rotationY;
    
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.byIndex(nbt.getInteger("RotationX")) != null)
            this.rotationX = EnumFacing.byIndex(nbt.getInteger("RotationX"));

        if (EnumFacing.byIndex(nbt.getInteger("RotationY")) != null)
            this.rotationY = EnumFacing.byIndex(nbt.getInteger("RotationY"));
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        if (this.rotationX != null)
            nbt.setInteger("RotationX", this.rotationX.ordinal());
        
        if (this.rotationY != null)
            nbt.setInteger("RotationY", this.rotationY.ordinal());
        
        return super.writeToNBT(nbt);
    }
    
    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return canProvideEnergyToReceiver(from);
    }
    
    @Override
    public boolean canProvideEnergyToReceiver(EnumFacing side)
    {
        if (side == EnumFacing.UP || side == EnumFacing.DOWN)
        {
            return false;
        }
        
        if (side == this.getRotationYAxis() || this.getRotationYAxis() != null && side == this.getRotationYAxis().getOpposite())
        {
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean canReceiveVoltageFromSide(EnumFacing from)
    {
        return canProvideEnergyToReceiver(from);
    }
    
    @Override
    public void update()
    {
        super.update();
    }

    @Override
    public EnumFacing getRotationYAxis()
    {
        return this.rotationX;
    }

    @Override
    public void setRotationYAxis(EnumFacing facing)
    {
        this.rotationX = facing;
    }

    @Override
    public EnumFacing getRotationXAxis()
    {
        return this.rotationY;
    }

    @Override
    public void setRotationXAxis(EnumFacing facing)
    {
        this.rotationY = facing;
    }
}
