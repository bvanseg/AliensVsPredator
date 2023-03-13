package org.avp.common.tile.plant;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.tile.IRotatableYAxis;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class TileEntityPlant extends TileEntity implements IRotatableYAxis
{
    public static final PlantColor STANDARD = new PlantColor(0.1, 0.2, 0.05);
    public static final PlantColor STANDARD_1 = new PlantColor(0.15, 0.25, 0.05);
    public static final PlantColor STANDARD_2 = new PlantColor(0.1, 0.25, 0.05);
    public static final PlantColor WHITE = new PlantColor(1, 2, 1);
    
    public static final PlantColor[] STANDARD_COLOR_GROUP = { STANDARD, STANDARD_1, STANDARD_2 };

    private static final Pos NO_OFFSET = new Pos(0F, 0F, 0F);
    
    private EnumFacing direction;
    private PlantSize size;
    private Pos offset;
    private PlantColor color;
    
    public static class PlantColor
    {
        private double r;
        private double g;
        private double b;
        
        public PlantColor(double r, double g, double b)
        {
            this.r = r;
            this.g = g;
            this.b = b;
        }
        
        public float r()
        {
            return (float) r;
        }
        
        public float g()
        {
            return (float) g;
        }
        
        public float b()
        {
            return (float) b;
        }
        
        public static PlantColor loadFromNBT(NBTTagCompound nbt)
        {
            return new PlantColor(nbt.getDouble("PlantColorR"), nbt.getDouble("PlantColorG"), nbt.getDouble("PlantColorB"));
        }
        
        public NBTTagCompound saveToNBT(NBTTagCompound nbt)
        {
            nbt.setDouble("PlantColorR", this.r);
            nbt.setDouble("PlantColorG", this.g);
            nbt.setDouble("PlantColorB", this.b);
            
            return nbt;
        }
    }
    
    public enum PlantSize
    {
        SMALL(0, 0.4F, 7), MEDIUM(1, 0.6F, 2), LARGE(3, 1.0F, 1);
        
        private int idx;
        private float scale;
        private int rarity;
        
        PlantSize(int idx, float scale, int rarity)
        {
            this.idx = idx;
            this.scale = scale;
            this.rarity = rarity;
        }
        
        public float getScale()
        {
            return scale;
        }
        
        public int getIndex()
        {
            return idx;
        }
        
        public int getRarity()
        {
            return rarity;
        }
        
        public static PlantSize getByIndex(int index)
        {
            for (PlantSize p : PlantSize.values())
            {
                if (p.getIndex() == index)
                {
                    return p;
                }
            }
            
            return PlantSize.SMALL;
        }
        
        public static PlantSize loadFromNBT(NBTTagCompound nbt)
        {
            return getByIndex(nbt.getInteger("PlantSize"));
        }
        
        public NBTTagCompound saveToNBT(NBTTagCompound nbt)
        {
            nbt.setInteger("PlantSize", this.idx);
            return nbt;
        }

        public static PlantSize random(World world)
        {
            Random rand = new Random();
            int index = rand.nextInt(PlantSize.values().length + 1);
            PlantSize size = getByIndex(index);
            
            if (rand.nextInt(size.rarity) == 0)
            {
                return size;
            }
            
            return random(world);
        }
    }
    
    public TileEntityPlant()
    {
        super();
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
        
        if (this.size != null)
        {
            this.size.saveToNBT(nbt);
        }
        
        if (this.offset != null)
        {
            nbt.setDouble("PlantOffsetX", this.offset.x);
            nbt.setDouble("PlantOffsetZ", this.offset.z);
        }
        
        if (this.color != null)
        {
            this.color.saveToNBT(nbt);
        }

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        
        this.color = PlantColor.loadFromNBT(nbt);
        this.size = PlantSize.loadFromNBT(nbt);
        this.offset = new Pos(nbt.getDouble("PlantOffsetX"), 0F, nbt.getDouble("PlantOffsetZ"));

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }
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
    
    public void applyRandomOffset(Random rand)
    {
        double maxOffset = 0.5F;
        Pos offset = new Pos((rand.nextDouble() * maxOffset) + -(rand.nextDouble() * maxOffset), 0F, (rand.nextDouble() * maxOffset) + -(rand.nextDouble() * maxOffset));
        this.setOffset(offset);
    }
    
    public PlantSize getPlantSize()
    {
        if (size == null)
        {
            return PlantSize.SMALL;
        }
        
        return size;
    }
    
    public void setPlantSize(PlantSize size)
    {
        this.size = size;
    }
    
    public Pos getOffset()
    {
        if (offset == null)
        {
            return NO_OFFSET;
        }
        
        return offset;
    }
    
    public void setOffset(Pos offset)
    {
        this.offset = offset;
    }
    
    public PlantColor getPlantColor()
    {
        if (color == null)
        {
            return STANDARD;
        }
        
        return color;
    }
    
    public void setPlantColor(PlantColor color)
    {
        this.color = color;
    }
}
