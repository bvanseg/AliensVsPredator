package org.avp.common.tile;

import com.asx.mdx.common.minecraft.block.IMultiBlock;
import com.asx.mdx.common.minecraft.tile.IRotatableYAxis;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.avp.client.AVPSounds;
import org.avp.common.AVPItems;
import org.avp.common.AVPNetworking;
import org.avp.common.api.machines.Openable;
import org.avp.common.api.power.VoltageReceiver;
import org.avp.common.block.init.AVPTileEntityBlocks;
import org.avp.common.network.packet.client.PacketOpenBlastdoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TileEntityBlastdoor extends TileEntityElectrical implements VoltageReceiver, IRotatableYAxis, Openable, IMultiBlock
{
    private boolean               isParent;
    private boolean               placedByPlayer;
    private TileEntity            parent;
    private final ArrayList<TileEntity> children;
    private int                   ticksExisted;
    private EnumFacing            direction;
    private float                 doorProgress;
    private float                 doorProgressPrev;
    private boolean               doorOpen;
    protected String              identifier;
    protected String              password;
    protected String              bindKey;
    protected boolean             locked;
    protected boolean             autolockEnabled;
    protected int                 lockTimer;
    private long                  timeOfLastPry;

    public TileEntityBlastdoor()
    {
        super(false);
        this.children = new ArrayList<>();
        this.identifier = "BD" + (1000 + new Random().nextInt(8999));
        this.password = "";
        this.bindKey = "";
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

        nbt.setFloat("DoorProgress", this.doorProgress);
        nbt.setBoolean("DoorOpen", this.isOpen());
        nbt.setLong("TimeOfLastPry", this.getTimeOfLastPry());
        nbt.setBoolean("Parent", this.isParent);
        nbt.setBoolean("Locked", this.locked);
        nbt.setBoolean("AutoLock", this.autolockEnabled);

        if (!identifier.isEmpty())
            nbt.setString("Identifier", this.identifier);

        if (!password.isEmpty())
            nbt.setString("Password", this.password);

        if (!bindKey.isEmpty())
            nbt.setString("BindKey", this.bindKey);

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }

        this.doorProgress = nbt.getFloat("DoorProgress");
        this.isParent = nbt.getBoolean("Parent");
        this.locked = nbt.getBoolean("Locked");
        this.autolockEnabled = nbt.getBoolean("AutoLock");
        this.setOpen(nbt.getBoolean("DoorOpen"));
        this.timeOfLastPry = nbt.getLong("TimeOfLastPry");
        this.identifier = nbt.getString("Identifier");
        this.password = nbt.getString("Password");
        this.bindKey = nbt.getString("BindKey");
    }

    @Override
    public void update()
    {
        super.update();
        this.updateMultiblock(this.world);
        this.updateMultiblockPower();

        this.doorProgressPrev = this.doorProgress;

        if (this.isParent())
        {
            if (this.isLocked() && !this.isOpen() && this.getWorld().getTotalWorldTime() % 10 == 0)
            {
                int scanRange = 1;
                List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1).grow(scanRange * 2, 5, scanRange * 2));

                for (EntityPlayer player : players)
                {
                    if (this.playerHoldingRequiredSecurityTuner(player))
                    {
                        this.unlock();
                        this.setOpen(true, true);
                        break;
                    }
                }
            }

            if (this.isOperational())
            {
                if (!this.isLocked() && this.isAutolockEnabled())
                {
                    if (this.lockTimer > 0)
                    {
                        this.lockTimer--;
                    }

                    if (this.lockTimer <= 0)
                    {
                        this.lock();
                    }
                }
                else if (this.isLocked() && this.isOpen())
                {
                    this.lock();
                }
            }

            if (this.isOpen() && this.isOperational())
            {
                this.doorProgress = this.doorProgress < getMaxDoorProgress() ? this.doorProgress + getDoorSpeed() : this.doorProgress;
            }

            if (!this.isOpen() && !isBeingPryedOpen())
            {
                this.doorProgress = this.doorProgress > 0.0F ? this.doorProgress - getDoorSpeed() : this.doorProgress;
            }

            long timeSinceLastPry = (System.currentTimeMillis() - this.getTimeOfLastPry());

            if (this.timeOfLastPry != 0 && timeSinceLastPry > getDoorResealTime())
            {
                this.timeOfLastPry = 0;
            }

            if (isBeingPryedOpen() && this.doorProgress >= getMaxDoorPryProgress())
            {
                this.timeOfLastPry = 0;
                this.setOpen(true);
            }
        }
    }
    
    private void updateMultiblockPower()
    {
        if (!this.isParent())
        {
            this.updateEnergyAsReceiver();
        }

        if (this.isChild())
        {
            if (this.getParent() != null && this.getVoltage() > this.getParent().getVoltage())
            {
                this.getParent().setVoltage(this.getVoltage());
            }
        }

        if (this.isParent)
        {
            double childrenVoltage = 0.0D;

            for (TileEntity c : this.getChildren())
            {
                if (c instanceof TileEntityElectrical)
                {
                    TileEntityElectrical child = (TileEntityElectrical) c;
                    
                    if (child.getVoltage() > 0.0D && child.getVoltage() > childrenVoltage)
                    {
                        childrenVoltage = child.getVoltage();
                    }
                }
            }

            if (childrenVoltage <= 0)
            {
                this.updateEnergyAsReceiver();
            }
        }
    }

    @Override
    public BlockPos[] defaultSet()
    {
        List<BlockPos> set = new ArrayList<>();
        BlockPos pos = new BlockPos(0, 0, 0);

        set.add(pos.add(1, 0, 0));
        set.add(pos.add(2, 0, 0));
        set.add(pos.add(3, 0, 0));
        set.add(pos.add(0, 1, 0));
        set.add(pos.add(0, 2, 0));
        set.add(pos.add(1, 2, 0));
        set.add(pos.add(1, 1, 0));
        set.add(pos.add(2, 2, 0));
        set.add(pos.add(2, 1, 0));
        set.add(pos.add(3, 2, 0));
        set.add(pos.add(3, 1, 0));

        return set.toArray(new BlockPos[set.size()]);
    }

    @Override
    public ArrayList<TileEntity> getChildren()
    {
        return this.children;
    }

    @Override
    public boolean isChild()
    {
        return !this.isParent();
    }

    @Override
    public boolean isParent()
    {
        return this.isParent;
    }

    @Override
    public TileEntityBlastdoor getParent()
    {
        return (TileEntityBlastdoor) parent;
    }

    @Override
    public void setParent(TileEntity parent)
    {
        this.parent = parent;
    }

    @Override
    public void setPlacedByPlayer()
    {
        this.placedByPlayer = true;
    }

    @Override
    public boolean isPlacedByPlayer()
    {
        return this.placedByPlayer;
    }

    @Override
    public void setTileParent()
    {
        this.isParent = true;
    }

    @Override
    public void setTileChild()
    {
        this.isParent = false;
    }

    @Override
    public String getMultiblockName()
    {
        return "Blast Door";
    }

    @Override
    public Block getMultiBlockType()
    {
        return AVPTileEntityBlocks.BLAST_DOOR;
    }
    
    @Override
    public void tick()
    {
        this.ticksExisted++;
    }
    
    @Override
    public int getTicksExisted()
    {
        return this.ticksExisted;
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

    public void unlock()
    {
        this.locked = false;
        this.lockTimer = this.getDoorAutolockTime();
        this.playUnlockSound();
    }

    public void lock()
    {
        this.locked = true;
        this.setOpen(false);
        this.playLockSound();
        IBlockState state = world.getBlockState(this.getPos());
        world.notifyBlockUpdate(this.getPos(), state, state, 3);
    }

    public boolean isLocked()
    {
        return locked;
    }

    public boolean isBeingPryedOpen()
    {
        return this.timeOfLastPry != 0;
    }

    public void setBeingPryedOpen(boolean beingPryedOpen)
    {
        if (beingPryedOpen)
        {
            this.timeOfLastPry = System.currentTimeMillis();
        }
    }

    public long getTimeOfLastPry()
    {
        return timeOfLastPry;
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
        return 220;
    }

    @Override
    public boolean isOpen()
    {
        return this.isChild() ? (this.getParent() != null && this.getParent().isOpen()) : doorOpen;
    }

    @Override
    public void setOpen(boolean doorOpen)
    {
        this.setOpen(doorOpen, true);
    }

    public void setOpen(boolean doorOpen, boolean sendPacket)
    {
        if (this.isChild())
        {
            if (this.getParent() != null)
            {
                this.getParent().setOpen(doorOpen);
            }
        }
        else if (this.isParent())
        {
            if (this.doorOpen != doorOpen)
            {
                if (doorOpen)
                {
                    this.playOpenSound();
                }
                else
                {
                    this.playCloseSound();
                }
            }
            this.doorOpen = doorOpen;

            if (this.world != null && !this.world.isRemote && sendPacket)
            {
                AVPNetworking.instance.sendToAll(new PacketOpenBlastdoor(doorOpen, this.getPos()));
            }
        }
    }

    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
    }

    public float getDoorProgress()
    {
        return this.doorProgress;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }

    public boolean hasPassword()
    {
        return !this.getPassword().isEmpty();
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;

        if (this.password.isEmpty() && this.isLocked())
        {
            this.unlock();
            this.setAutolock(false);
        }
    }

    public void setDoorProgress(float doorProgress)
    {
        this.doorProgress = doorProgress;
    }

    public float getMaxDoorPryProgress()
    {
        return 0.4F;
    }

    public float getMaxDoorProgress()
    {
        return 1.0F;
    }

    public int getDoorResealTime()
    {
        return 600;
    }

    public float getDoorSpeed()
    {
        return 0.03F;
    }

    public int getDoorAutolockTime()
    {
        return 20 * 10;
    }

    public boolean isAutolockEnabled()
    {
        return autolockEnabled;
    }

    public void setAutolock(boolean autolockEnabled)
    {
        this.autolockEnabled = autolockEnabled;
    }

    public float getDoorProgressPrev()
    {
        return this.doorProgressPrev;
    }

    public void playOpenSound()
    {
        AVPSounds.BLASTDOOR_OPEN.playSound(world, pos, 1F, 1F);
    }

    public void playCloseSound()
    {
        AVPSounds.BLASTDOOR_CLOSE.playSound(world, pos, 1F, 1F);
    }

    public void playUnlockSound()
    {
        AVPSounds.BLASTDOOR_UNLOCK.playSound(world, pos.getX(), pos.getY(), pos.getZ(), 1F, 1F, false);
    }

    public void playLockSound()
    {
        AVPSounds.BLASTDOOR_LOCK.playSound(world, pos.getX(), pos.getY(), pos.getZ(), 1F, 1F, false);
    }

    public void playIncorrectPasswordSound()
    {
        AVPSounds.BLASTDOOR_PASSWORD_DENIED.playSound(world, pos.getX(), pos.getY(), pos.getZ(), 1F, 1F, false);
    }

    public boolean authenticate(String key)
    {
        if (key.equals(this.password))
        {
            this.unlock();
            this.setOpen(true);
            return true;
        }
        else
        {
            this.playIncorrectPasswordSound();
        }

        return false;
    }

    public void bindToSecurityTuner(ItemStack itemstack)
    {
        if (itemstack.getItem() == AVPItems.SECURITY_TUNER)
        {
            NBTTagCompound tag = itemstack.getTagCompound() != null ? itemstack.getTagCompound() : new NBTTagCompound();
            String tunerBindKey = tag.getString("BindKey");

            if (!this.world.isRemote)
            {
                if (tunerBindKey.isEmpty())
                {
                    tunerBindKey = UUID.randomUUID().toString();
                    tag.setString("BindKey", tunerBindKey);
                    itemstack.setTagCompound(tag);
                    itemstack.setStackDisplayName(tunerBindKey);
                }
            }

            this.bindKey = tunerBindKey;
        }
    }

    public boolean playerHoldingRequiredSecurityTuner(EntityPlayer player)
    {
        ItemStack itemstack = player.getHeldItemMainhand();

        if (itemstack != null && itemstack.getItem() == AVPItems.SECURITY_TUNER)
        {
            NBTTagCompound tag = itemstack.getTagCompound() != null ? itemstack.getTagCompound() : new NBTTagCompound();
            return tag.getString("BindKey").equals(this.bindKey) || this.bindKey.isEmpty();
        }

        return false;
    }

    public String getBindKey()
    {
        return this.bindKey;
    }
}
