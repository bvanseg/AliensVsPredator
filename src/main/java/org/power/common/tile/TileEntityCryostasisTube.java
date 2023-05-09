package org.power.common.tile;

import com.asx.mdx.common.minecraft.tile.IRotatableYAxis;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import org.avp.common.AVPNetworking;
import org.avp.common.api.power.VoltageReceiver;
import org.avp.common.item.ItemEntitySummoner;
import org.power.common.network.packet.server.PacketCryostasisStateUpdate;


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
                            this.world.playSound(null, this.pos, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 2.0F, 1.0F);
                        }

                        this.setCracked(true);
                        this.world.playSound(null, this.pos, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 0.5F, 0.5F);
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

    private static final String CRACKED_NBT_KEY = "Cracked";
    private static final String SHATTERED_NBT_KEY = "Shattered";
    private static final String DIRECTION_NBT_KEY = "Direction";
    private static final String STASIS_ITEMSTACK_NBT_KEY = "StasisItemstack";

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setBoolean(CRACKED_NBT_KEY, this.cracked);
        nbt.setBoolean(SHATTERED_NBT_KEY, this.shattered);

        if (this.direction != null)
        {
            nbt.setInteger(DIRECTION_NBT_KEY, this.direction.ordinal());
        }

        if (this.stasisItemstack != null)
        {
            NBTTagCompound nbtStack = new NBTTagCompound();
            this.stasisItemstack.writeToNBT(nbtStack);
            nbt.setTag(STASIS_ITEMSTACK_NBT_KEY, nbtStack);
        }
        
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.cracked = nbt.getBoolean(CRACKED_NBT_KEY);
        this.shattered = nbt.getBoolean(SHATTERED_NBT_KEY);

        if (EnumFacing.byIndex(nbt.getInteger(DIRECTION_NBT_KEY)) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger(DIRECTION_NBT_KEY));
        }

        NBTTagCompound nbtStack = nbt.getCompoundTag(STASIS_ITEMSTACK_NBT_KEY);

        if (nbtStack != null && !nbtStack.isEmpty()) {
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
