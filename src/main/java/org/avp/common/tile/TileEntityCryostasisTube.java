package org.avp.common.tile;

import com.asx.mdx.common.minecraft.tile.IRotatableYAxis;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import org.avp.common.AVPNetworking;
import org.avp.common.api.power.VoltageReceiver;
import org.avp.common.item.ItemEntitySummoner;
import org.avp.common.network.packet.server.PacketCryostasisStateUpdate;


public class TileEntityCryostasisTube extends TileEntityElectrical implements VoltageReceiver, IRotatableYAxis, ITickable
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
        
        // If the machine is shattered, it can no longer support an entity. Nothing more to update.
        if (this.isShattered()) {
            if (!this.world.isRemote && stasisEntity != null)
            {
            	stasisEntity.setLocationAndAngles(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), 0F, 0F);
                this.world.spawnEntity(stasisEntity);
            }

            // Set these to null, as the stasis tube can no longer support a specimen, anyways.
            this.stasisItemstack = null;
            this.stasisEntity = null;
        	return;
        }

        // There is nothing more this machine can do if the stasis itemstack is null.
        if (this.stasisItemstack == null) {
        	return;
        }

        // If no stasis entity is present, try setting one.
        if (this.stasisEntity == null)
        {
            this.stasisEntity = ((ItemEntitySummoner) this.stasisItemstack.getItem()).createNewEntity(this.world);
        }


        if (this.stasisEntity != null) {
            if (world.isRemote)
            {
                stasisEntity.onUpdate();
            }

            if (!this.world.isRemote && !this.isOperational())
            {
            	if (this.world.getTotalWorldTime() % 100 == 0)
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
        }
    }

    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
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

        if (nbtStack != null && !nbtStack.isEmpty() && nbtStack.hasKey("StasisItemstack")) {
            this.stasisItemstack = new ItemStack(nbtStack);
        }

        if (this.stasisEntity == null &&
            stasisItemstack != null &&
            this.stasisItemstack != ItemStack.EMPTY &&
            this.stasisItemstack.getItem() != Items.AIR
        )
        {
            Item summoner = this.stasisItemstack.getItem();
            
            if (summoner != null && summoner instanceof ItemEntitySummoner)
            {
                this.stasisEntity = ((ItemEntitySummoner)summoner).createNewEntity(this.world);
            }
        }
    }

    public void setCracked(boolean cracked)
    {
        this.cracked = cracked;

        if (!this.world.isRemote) {
            AVPNetworking.instance.sendToAll(new PacketCryostasisStateUpdate(this));
        }
    }

    public void setShattered(boolean shattered)
    {
        this.shattered = shattered;

        if (!this.world.isRemote) {
            AVPNetworking.instance.sendToAll(new PacketCryostasisStateUpdate(this));
        }
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
