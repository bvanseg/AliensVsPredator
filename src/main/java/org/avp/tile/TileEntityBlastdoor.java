package org.avp.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.avp.AliensVsPredator;
import org.avp.api.machines.IOpenable;
import org.avp.api.power.IVoltageReceiver;
import org.avp.packets.client.PacketOpenBlastdoor;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.block.IMultiBlock;
import com.arisux.mdx.lib.world.tile.IRotatable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class TileEntityBlastdoor extends TileEntityElectrical implements IVoltageReceiver, IRotatable, IOpenable, IMultiBlock
{
    private EnumFacing                     direction;
    private float                          doorProgress;
    private float                          doorProgressPrev;
    private boolean                        doorOpen;
    private boolean                        isParent;
    private boolean                        placedByPlayer;
    private TileEntityBlastdoor            parent;
    private ArrayList<TileEntityBlastdoor> children;
    private int                            ticksExisted;
    protected String                       identifier;
    protected String                       password;
    protected String                       bindKey;
    protected boolean                      locked;
    protected boolean                      autolockEnabled;
    protected int                          lockTimer;
    private long                           timeOfLastPry;

    public TileEntityBlastdoor()
    {
        super(false);
        this.children = new ArrayList<TileEntityBlastdoor>();
        this.identifier = "BD" + (1000 + new Random().nextInt(8999));
        this.password = "";
        this.bindKey = "";
    }

    public void addToParent(TileEntityBlastdoor parent)
    {
        if (!parent.getChildren().contains(this))
        {
            parent.getChildren().add(this);
        }

        this.setParent(parent);
    }

    public ArrayList<TileEntityBlastdoor> getChildren()
    {
        return this.children;
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

        if (EnumFacing.getFront(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.getFront(nbt.getInteger("Direction"));
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
        this.doorProgressPrev = this.doorProgress;

        if (!this.isParent())
        {
            this.updateEnergyAsReceiver();
        }

        this.ticksExisted++;

        if (this.isParent && this.ticksExisted > 1 && !placedByPlayer)
        {
            this.setup(false);
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

            for (TileEntityBlastdoor child : this.getChildren())
            {
                if (child.getVoltage() > 0.0D && child.getVoltage() > childrenVoltage)
                {
                    childrenVoltage = child.getVoltage();
                }
            }

            if (childrenVoltage <= 0)
            {
                this.updateEnergyAsReceiver();
            }
        }

        if (this.isParent())
        {
            if (this.isLocked() && !this.isOpen() && this.getWorld().getWorldTime() % 10 == 0)
            {
                int scanRange = 1;
                List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1).expand(scanRange * 2, 5, scanRange * 2));
                
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

    public void unlock()
    {
        this.locked = false;
        this.lockTimer = this.getDoorAutolockTime();
    }

    public void lock()
    {
        this.locked = true;
        this.setOpen(false);
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
        return this.isChild() ? (this.getParent() != null ? this.getParent().isOpen() : false) : doorOpen;
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
                this.playDoorOpenSound();
            }
            this.doorOpen = doorOpen;

            if (this.world != null && !this.world.isRemote && sendPacket)
            {
                AliensVsPredator.network().sendToAll(new PacketOpenBlastdoor(doorOpen, this.getPos()));
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

    public boolean setChildTile(BlockPos position)
    {
        IBlockState blockstate = this.world.getBlockState(position);
        Block block = blockstate.getBlock();

        boolean validBlastDoor = true;

        if (block == AliensVsPredator.blocks().blastDoor)
        {
            TileEntityBlastdoor b = (TileEntityBlastdoor) this.world.getTileEntity(position);
            validBlastDoor = b.getParent() != null ? false : true;
        }

        if (blockstate.getMaterial() != Material.AIR && block != AliensVsPredator.blocks().blastDoor || !validBlastDoor)
        {
            if (this.world.isRemote)
            {
                if (validBlastDoor == false)
                {
                    Game.minecraft().player.sendMessage(new TextComponentString("Can't place a blast door inside of another blast door."));
                }
                else
                {
                    Game.minecraft().player.sendMessage(new TextComponentString("Unable to place a blast door here. Blocks are in the way."));
                }
            }

            return false;
        }

        world.setBlockState(position, AliensVsPredator.blocks().blastDoor.getDefaultState());
        TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) world.getTileEntity(position);

        if (blastdoor == null)
        {
            Game.minecraft().player.sendMessage(new TextComponentString("Internal Error: TileEntityBlastDoor.setChildTile()/blastdoor = null"));
            return false;
        }

        if (blastdoor != null)
        {
            blastdoor.addToParent(this);
            blastdoor.setParent(this);
        }

        return true;
    }

    public void breakChildren()
    {
        for (TileEntityBlastdoor child : this.getChildren())
        {
            world.setBlockToAir(child.getPos());
        }
    }

    public boolean isChild()
    {
        return !this.isParent();
    }

    public boolean isParent()
    {
        return this.isParent;
    }

    public TileEntityBlastdoor getParent()
    {
        return parent;
    }

    public void setParent(TileEntityBlastdoor parent)
    {
        this.parent = parent;
    }

    public boolean setup(boolean placedByPlayer)
    {
        this.isParent = true;
        this.placedByPlayer = true;

        if (this.direction != null)
        {
            BlockPos[] set = this.setFor(this.direction);

            for (BlockPos offset : set)
            {
                BlockPos position = this.getPos().add(offset);

                if (!this.setChildTile(position))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public EnumFacing getDirection()
    {
        return direction;
    }

    @Override
    public void setDirection(EnumFacing direction)
    {
        this.direction = direction;
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

    @Override
    public BlockPos[] defaultSet()
    {
        List<BlockPos> set = new ArrayList<BlockPos>();
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

    public void playDoorOpenSound()
    {
        AliensVsPredator.sounds().BLASTDOOR_OPEN.playSound(world, pos, 1F, 1F);
    }

    public boolean authenticate(String key)
    {
        if (key.equals(this.password))
        {
            this.unlock();
            this.setOpen(true);
            return true;
        }

        return false;
    }

    public void bindToSecurityTuner(EntityPlayer playerEntity, ItemStack itemstack)
    {
        if (itemstack.getItem() == AliensVsPredator.items().securityTuner)
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
                    System.out.println("created key: " + tunerBindKey);
                }
            }

            this.bindKey = tunerBindKey;
        }
    }

    public boolean playerHoldingRequiredSecurityTuner(EntityPlayer player)
    {
        ItemStack itemstack = player.getHeldItemMainhand();

        if (itemstack.getItem() == AliensVsPredator.items().securityTuner)
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
