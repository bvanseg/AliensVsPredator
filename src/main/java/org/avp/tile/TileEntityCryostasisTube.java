package org.avp.tile;

import org.avp.api.power.IVoltageReceiver;
import org.avp.item.ItemEntitySummoner;

import com.arisux.mdx.lib.world.tile.IRotatableYAxis;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;


public class TileEntityCryostasisTube extends TileEntityElectrical implements IVoltageReceiver, IRotatableYAxis, ITickable
{
    private EnumFacing direction;
    public Entity stasisEntity;
    public ItemStack stasisItemstack;
    private boolean cracked;
    private boolean shattered;
    private int ticksExisted;

    public TileEntityCryostasisTube()
    {
        super(false);
        this.setThresholdVoltage(90);
    }

    @Override
    public void update()
    {
        this.ticksExisted++;
        super.update();
        this.updateEnergyAsReceiver();
        
        if (this.stasisEntity != null && !this.isOperational())
        {
            if (this.world.getWorldTime() % 100 == 0)
            {
                if (this.world.rand.nextInt(8) == 0)
                {
                    if (this.isCracked())
                    {
                        this.setShattered(true);
                    }

                    this.setCracked(true);
                }
            }
        }

        if (this.stasisItemstack != null && this.stasisItemstack.getItem() instanceof ItemEntitySummoner)
        {
            ItemEntitySummoner item = (ItemEntitySummoner) this.stasisItemstack.getItem();
            Entity entity = item.createNewEntity(world);

            if (entity != null)
            {
                if (this.isShattered())
                {
                    if (!this.world.isRemote)
                    {
                        entity.setLocationAndAngles(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), 0F, 0F);
                        this.world.spawnEntity(entity);
                    }

                    this.stasisItemstack = null;
                    this.stasisEntity = null;
                }
            }
            else
            {
                this.stasisEntity = ((ItemEntitySummoner) this.stasisItemstack.getItem()).createNewEntity(this.world);
            }
        }

        if (stasisEntity != null && world.isRemote)
        {
            stasisEntity.onUpdate();
        }
    }

    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
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
        nbt.setBoolean("Cracked", this.cracked);
        nbt.setBoolean("Shattered", this.shattered);

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }

        if (this.stasisItemstack != null)
        {
            NBTTagCompound nbtStack = new NBTTagCompound();
            this.stasisItemstack.writeToNBT(nbtStack);
            nbt.setTag("StasisItemstack", nbtStack);
        }
        
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.cracked = nbt.getBoolean("Cracked");
        this.shattered = nbt.getBoolean("Shattered");

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }

        NBTTagCompound nbtStack = nbt.getCompoundTag("StasisItemstack");
        this.stasisItemstack = new ItemStack(nbtStack);

        if (this.stasisEntity == null && this.stasisItemstack != ItemStack.EMPTY)
        {
            this.stasisEntity = ((ItemEntitySummoner) this.stasisItemstack.getItem()).createNewEntity(this.world);
        }
    }

    public void setCracked(boolean cracked)
    {
        this.cracked = cracked;
    }

    public void setShattered(boolean shattered)
    {
        this.shattered = shattered;
    }

    public boolean isCracked()
    {
        return this.cracked;
    }

    public boolean isShattered()
    {
        return this.shattered;
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.getVoltage();
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 120;
    }

    public int getTicksExisted()
    {
        return ticksExisted;
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
}
