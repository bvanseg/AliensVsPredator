package org.avp.tile;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.api.machines.IDataDevice;
import org.avp.api.power.IVoltageReceiver;
import org.avp.client.Sounds;
import org.avp.entities.living.EntityAethon;
import org.avp.entities.living.EntityAqua;
import org.avp.entities.living.EntityBelugaburster;
import org.avp.entities.living.EntityBelugamorph;
import org.avp.entities.living.EntityChestburster;
import org.avp.entities.living.EntityCrusher;
import org.avp.entities.living.EntityDeacon;
import org.avp.entities.living.EntityDeaconShark;
import org.avp.entities.living.EntityDrone;
import org.avp.entities.living.EntityEngineer;
import org.avp.entities.living.EntityFacehugger;
import org.avp.entities.living.EntityGooMutant;
import org.avp.entities.living.EntityHammerpede;
import org.avp.entities.living.EntityMatriarch;
import org.avp.entities.living.EntityOctohugger;
import org.avp.entities.living.EntityOvamorph;
import org.avp.entities.living.EntityPraetorian;
import org.avp.entities.living.EntityPredalien;
import org.avp.entities.living.EntityPredalienChestburster;
import org.avp.entities.living.EntityQueenChestburster;
import org.avp.entities.living.EntityRoyalFacehugger;
import org.avp.entities.living.EntityRunnerChestburster;
import org.avp.entities.living.EntityRunnerDrone;
import org.avp.entities.living.EntityRunnerWarrior;
import org.avp.entities.living.EntitySpaceJockey;
import org.avp.entities.living.EntitySpitter;
import org.avp.entities.living.EntityTrilobite;
import org.avp.entities.living.EntityUltramorph;
import org.avp.entities.living.EntityWarrior;
import org.avp.inventory.ContainerTurret;
import org.avp.packets.client.PacketTurretSync;
import org.avp.packets.server.PacketTurretTargetUpdate;

import com.arisux.mdx.lib.client.util.Rotation;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.util.MDXMath;
import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.entity.Entities;
import com.arisux.mdx.lib.world.storage.NBTStorage;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityTurret extends TileEntityElectrical implements IDataDevice, IVoltageReceiver
{
    private boolean                            ammoDisplayEnabled;
    private boolean                            isFiring;
    private int                                fireRate;
    private int                                range;
    private int                                cycleCount;
    private int                                curAmmo;
    private int                                rounds;
    private int                                roundsMax;
    private int                                direction;
    private int                                timeout;
    private int                                timeoutMax;
    private ArrayList<Class<? extends Entity>> targetTypes;
    public InventoryBasic                      inventoryAmmo;
    public InventoryBasic                      inventoryExpansion;
    public InventoryBasic                      inventoryDrive;
    private Entity                             targetEntity;
    private ContainerTurret                    container;
    private Pos                                pos;
    private Rotation                           rot;
    private Pos                                foc;
    private Rotation                           focrot;
    private Item                               itemAmmo;
    public int                                 beamColor;

    public TileEntityTurret()
    {
        super(false);
        this.targetTypes = new ArrayList<Class<? extends Entity>>();
        this.inventoryAmmo = new InventoryBasic("TurretAmmoBay", true, 9);
        this.inventoryExpansion = new InventoryBasic("TurretExpansionBay", true, 3);
        this.inventoryDrive = new InventoryBasic("TurretDriveBay", true, 1);
        this.fireRate = 2;
        this.range = 24;
        this.cycleCount = getBaseCycleCount();
        this.curAmmo = 0;
        this.rot = new Rotation(0F, 0F);
        this.focrot = new Rotation(0F, 0F);
        this.ammoDisplayEnabled = false;
        this.timeoutMax = 60;
        this.itemAmmo = AliensVsPredator.items().itemAmmoSMG;
        this.beamColor = 0xFFFF0000;
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
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        this.direction = nbt.getInteger("Direction");
        this.focrot.setYaw(nbt.getFloat("FocusYaw")).setPitch(nbt.getFloat("FocusPitch"));
        this.readTargetListFromCompoundTag(nbt);
        this.readInventoryFromNBT(nbt, this.inventoryAmmo);
        this.readInventoryFromNBT(nbt, this.inventoryExpansion);
        this.readInventoryFromNBT(nbt, this.inventoryDrive);
        this.sendSyncPacket();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        nbt.setInteger("Direction", this.direction);
        nbt.setFloat("FocusYaw", this.focrot.yaw);
        nbt.setFloat("FocusPitch", this.focrot.pitch);
        nbt.setTag("Targets", this.getTargetListTag());
        this.saveInventoryToNBT(nbt, this.inventoryAmmo);
        this.saveInventoryToNBT(nbt, this.inventoryExpansion);
        this.saveInventoryToNBT(nbt, this.inventoryDrive);
        
        return nbt;
    }

    private void sendSyncPacket()
    {
        AliensVsPredator.network().sendToAll(new PacketTurretSync(this));
    }

    public void onReceiveInitPacket(PacketTurretSync packet, MessageContext ctx)
    {
        this.applyUpgrades();
        this.readTargetList(packet.targets);
        this.rot.yaw = packet.rotation.yaw;
        this.rot.pitch = packet.rotation.pitch;
    }

    @SideOnly(Side.CLIENT)
    public void onReceiveTargetUpdatePacket(PacketTurretTargetUpdate packet, MessageContext ctx)
    {
        Entity entity = Game.minecraft().world.getEntityByID(packet.id);
        this.setTargetEntity(entity);
        this.foc = packet.foc;
        this.focrot = packet.focrot;
    }

    @Override
    public void update()
    {
        super.update();
        super.updateEnergyAsReceiver();

        // System.out.println(this.getRotation().yaw);

        if (this.pos == null)
        {
            this.pos = new Pos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
        }
        else
        {
            this.pos.x = this.getPos().getX();
            this.pos.y = this.getPos().getY();
            this.pos.z = this.getPos().getZ();
        }

        this.isFiring = false;

        if (this.getVoltage() > 0)
        {
            this.timeout = this.timeout > 0 ? this.timeout - 1 : this.timeout;
            this.pickUpAmmunition();
            this.updateAmmunitionCount();
            this.reloadIfNecessary();
            this.targetAndAttack();
        }
    }

    // public Entity findTarget()
    // {
    // Entity newTarget = Entities.getRandomEntityInCoordsRange(this.world, EntityLiving.class, this.pos, range, range);
    //
    // if (this.canTarget(newTarget) && canSee(newTarget))
    // {
    // System.out.println(newTarget);
    // this.targetEntity = newTarget;
    //
    // if (this.world.isRemote)
    // {
    // AliensVsPredator.network().sendToAll(new PacketTurretTargetUpdate(this));
    // }
    //
    // return newTarget;
    // }
    //
    // return null;
    // }

    public boolean canTarget(Entity e)
    {
        if (e != null)
        {
            double distance = Pos.distance(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), e.posX, e.posY, e.posZ);
            return !e.isDead && this.canTargetType(e.getClass()) && distance <= this.range;
        }

        return false;
    }

    private boolean canSee(Entity e)
    {
        double height = e.getEntityBoundingBox().maxY - e.getEntityBoundingBox().minY;
        double halfHeight = height / 2;

        Pos middlePos = new Pos(e.posX, e.getEntityBoundingBox().maxY - (halfHeight), e.posZ);
        Pos topPos = new Pos(e.posX, e.getEntityBoundingBox().maxY - (halfHeight + halfHeight), e.posZ);
        Pos botPos = new Pos(e.posX, e.getEntityBoundingBox().maxY - (halfHeight - halfHeight), e.posZ);
        Pos newPos = this.pos.add(0.5, 1, 0.5);
        RayTraceResult middle = Entities.rayTraceBlocks(this.world, middlePos, newPos, false, true, false);
        RayTraceResult top = Entities.rayTraceBlocks(this.world, topPos, newPos, false, true, false);
        RayTraceResult bot = Entities.rayTraceBlocks(this.world, botPos, newPos, false, true, false);

        if (middle == null || top == null || bot == null)
        {
            return true;
        }

        return false;
    }

    private void updatePosition(double x, double y, double z)
    {
        if (this.foc == null)
        {
            this.foc = new Pos(x, y, z);
        }
        else
        {
            this.foc.x = x;
            this.foc.y = y;
            this.foc.z = z;
        }
    }

    public void targetAndAttack()
    {
        if (this.targetEntity != null)
        {
            if (this.targetEntity.isDead)
            {
                this.targetEntity = null;
            }
        }

        if (!this.world.isRemote && this.world.getWorldTime() % 10 == 0)
        {
            if (this.getTargetEntity() == null || this.getTargetEntity() != null && !this.canTarget(targetEntity))
            {
                for (Class<? extends Entity> type : this.targetTypes)
                {
                    Entity newTarget = Entities.getRandomEntityInCoordsRange(this.world, type, this.pos, range, range);

                    if (this.canTarget(newTarget) && canSee(newTarget))
                    {
                        this.targetEntity = newTarget;
                        break;
                    }
                }
            }
        }

        this.lookAtFocusPoint();

        if (targetEntity != null)
        {
            this.updatePosition(targetEntity.posX, targetEntity.posY, targetEntity.posZ);
            this.focrot = turnTurretToPoint(this.foc, this.focrot, 360F, 90F);

            if (!this.world.isRemote)
            {
                AliensVsPredator.network().sendToAll(new PacketTurretTargetUpdate(this));

                if (world.getWorldInfo().getWorldTime() % fireRate == 0L && this.rot.yaw == this.focrot.yaw)
                {
                    if (curAmmo-- > 0)
                    {
                        this.fire();
                    }
                    else
                    {
                        this.reload();
                    }
                }
            }
        }
    }

    public void lookAtFocusPoint()
    {
        if (this.foc != null)
        {
            for (int runCycles = this.cycleCount; runCycles > 0; runCycles--)
            {
                if (Math.ceil(this.getRotationYaw()) < Math.ceil(this.focrot.yaw))
                {
                    this.rot.yaw += 1;
                }
                else if (Math.ceil(this.getRotationYaw()) > Math.ceil(this.focrot.yaw))
                {
                    this.rot.yaw -= 1;
                }

                if (Math.ceil(this.getRotationPitch()) < Math.ceil(this.focrot.pitch))
                {
                    this.rot.pitch += 1;
                }
                else if (Math.ceil(this.getRotationPitch()) > Math.ceil(this.focrot.pitch))
                {
                    this.rot.pitch -= 1;
                }

                double focus = 1;

                if (Math.ceil(this.getRotationPitch()) >= Math.ceil(this.focrot.pitch - focus) && Math.ceil(this.getRotationPitch()) <= Math.ceil(this.focrot.pitch + focus) && Math.ceil(this.getRotationYaw()) >= Math.ceil(this.focrot.yaw - focus) && Math.ceil(this.getRotationYaw()) <= Math.ceil(this.focrot.yaw + focus))
                {
                    this.rot.pitch = this.focrot.pitch;
                    this.rot.yaw = this.focrot.yaw;
                }
            }
        }
    }

    public void reloadIfNecessary()
    {
        if (this.curAmmo < this.getMaxAmmo() && this.curAmmo <= 0)
        {
            this.reload();
        }
    }

    public void updateAmmunitionCount()
    {
        if (world.getWorldInfo().getWorldTime() % 8L == 0L)
        {
            this.roundsMax = (9 * 64);
            this.rounds = 0;

            for (int i = 0; i < 9; i++)
            {
                ItemStack stack = this.inventoryAmmo.getStackInSlot(i);

                if (stack != null)
                {
                    if (stack.getItem() == this.itemAmmo)
                    {
                        this.rounds = this.rounds + (stack.getCount());
                    }
                }
            }
        }
    }

    public void pickUpAmmunition()
    {
        if (this.world != null && this.inventoryAmmo != null)
        {
            ArrayList<EntityItem> entityItemList = (ArrayList<EntityItem>) Entities.getEntitiesInCoordsRange(world, EntityItem.class, new Pos(this), 1);

            for (EntityItem entityItem : entityItemList)
            {
                if (!entityItem.cannotPickup())
                {
                    ItemStack stack = entityItem.getItem();

                    if (stack.getItem() == this.itemAmmo)
                    {
                        for (int x = 0; x < 9; x++)
                        {
                            ItemStack invStack = this.inventoryAmmo.getStackInSlot(x);

                            if (invStack == null || invStack != null && invStack.getCount() < 64)
                            {
                                this.inventoryAmmo.setInventorySlotContents(x, stack);
                                entityItem.setDead();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void reload()
    {
        if (this.rounds >= 1)
        {
            this.curAmmo = this.getMaxAmmo();

            for (int x = 0; x < 9; x++)
            {
                ItemStack stack = this.inventoryAmmo.getStackInSlot(x);

                if (stack != null && stack.getItem() == this.getItemAmmo())
                {
                    stack.shrink(1);
                    
                    if (stack.getCount() <= 0)
                    {
                        this.inventoryAmmo.setInventorySlotContents(x, ItemStack.EMPTY);
                    }

                    break;
                }
            }
        }
    }

    public void fire()
    {
        this.isFiring = true;
        this.timeout = this.timeoutMax;
        this.targetEntity.attackEntityFrom(DamageSources.bullet, 1F);
        this.targetEntity.hurtResistantTime = 0;
        // this.world.spawnParticle("largesmoke", xCoord, yCoord, zCoord, 1, 1, 1);
        Sounds.WEAPON_M56SG.playSound(this.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), 1F, 1F);
    }

    public Rotation turnTurretToPoint(Pos pos, Rotation rotation, float deltaYaw, float deltaPitch)
    {
        double x = pos.x - this.pos.x;
        double y = pos.y - this.pos.y;
        double z = pos.z - this.pos.z;
        double sq = MathHelper.sqrt(x * x + z * z);

        float newYaw = (float) (Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
        float f1 = (float) (-(Math.atan2(y, sq) * 180.0D / Math.PI));

        return rotation.setYaw(MDXMath.wrapAngle(this.rot.yaw, newYaw, deltaYaw)).setPitch(MDXMath.wrapAngle(this.rot.pitch, f1, deltaPitch));
    }

    public void removeTargetType(Class<? extends Entity> entityClass)
    {
        this.setTargetEntity(null);

        if (this.targetTypes.contains(entityClass))
        {
            this.targetTypes.remove(entityClass);
        }
    }

    public void addTargetType(Class<? extends Entity> entityClass)
    {
        this.setTargetEntity(null);

        if (!this.targetTypes.contains(entityClass))
        {
            this.targetTypes.add(entityClass);
        }
    }

    public boolean canTargetType(Class<? extends Entity> entityClass)
    {
        if (this.targetTypes.contains(entityClass))
        {
            return true;
        }

        return false;
    }

    public void setPredefinedTargets()
    {
        this.addTargetType(EntityOvamorph.class);
        this.addTargetType(EntityFacehugger.class);
        this.addTargetType(EntityChestburster.class);
        this.addTargetType(EntityDrone.class);
        this.addTargetType(EntityWarrior.class);
        this.addTargetType(EntityPraetorian.class);
        this.addTargetType(EntityMatriarch.class);
        this.addTargetType(EntityCrusher.class);
        this.addTargetType(EntitySpitter.class);
        this.addTargetType(EntityAqua.class);
        this.addTargetType(EntityPredalien.class);
        this.addTargetType(EntitySlime.class);
        this.addTargetType(EntityAqua.class);
        this.addTargetType(EntityRunnerWarrior.class);
        this.addTargetType(EntityRunnerDrone.class);
        this.addTargetType(EntityDeacon.class);
        this.addTargetType(EntityUltramorph.class);
        this.addTargetType(EntityRunnerChestburster.class);
        this.addTargetType(EntityPredalienChestburster.class);
        this.addTargetType(EntityQueenChestburster.class);
        this.addTargetType(EntityBelugaburster.class);
        this.addTargetType(EntityHammerpede.class);
        this.addTargetType(EntityOvamorph.class);
        this.addTargetType(EntityDeaconShark.class);
        this.addTargetType(EntityOctohugger.class);
        this.addTargetType(EntityRoyalFacehugger.class);
        this.addTargetType(EntityTrilobite.class);
        this.addTargetType(EntityPredalien.class);
        this.addTargetType(EntitySpaceJockey.class);
        this.addTargetType(EntityEngineer.class);
        this.addTargetType(EntityBelugamorph.class);
        this.addTargetType(EntityGooMutant.class);
        this.addTargetType(EntityAethon.class);
    }

    public void applyUpgrades()
    {
        int cycles = this.getBaseCycleCount();
        this.setAmmoDisplayEnabled(false);

        for (int i = 0; i < 3; i++)
        {
            ItemStack pciSlot = this.inventoryExpansion.getStackInSlot(i);

            if (pciSlot != null && pciSlot.getItem() == AliensVsPredator.items().itemProcessor)
            {
                cycles += 1 * pciSlot.getCount();
            }

            if (pciSlot != null && pciSlot.getItem() == AliensVsPredator.items().itemLedDisplay)
            {
                this.setAmmoDisplayEnabled(true);
            }
        }

        this.setCycleCount(cycles);
    }

    public NBTTagList getTargetListTag()
    {
        ArrayList<String> entityIDs = new ArrayList<String>();

        for (Class<? extends Entity> c : this.getDangerousTargets())
        {
            entityIDs.add(Entities.getEntityRegistrationId(c));
        }

        return NBTStorage.newStringNBTList(entityIDs);
    }

    public void readTargetListFromCompoundTag(NBTTagCompound nbt)
    {
        NBTTagList list = nbt.getTagList("Targets", NBT.TAG_STRING);

        if (list instanceof NBTTagList)
        {
            this.readTargetList(list);
        }
    }

    public void readTargetList(NBTTagList list)
    {
        for (int i = 0; i < list.tagCount(); i++)
        {
            String id = list.getStringTagAt(i);
            
            Class<? extends Entity> c = (Class<? extends Entity>) ForgeRegistries.ENTITIES.getValue(new ResourceLocation(AliensVsPredator.Properties.ID, id)).getEntityClass();
            this.addTargetType(c);
        }
    }

    private void saveInventoryToNBT(NBTTagCompound nbt, IInventory inventory)
    {
        NBTTagList items = new NBTTagList();

        for (byte x = 0; x < inventory.getSizeInventory(); x++)
        {
            ItemStack stack = inventory.getStackInSlot(x);

            if (stack != null)
            {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", x);
                stack.writeToNBT(item);
                items.appendTag(item);
            }
        }

        nbt.setTag(inventory.getName(), items);
    }

    private void readInventoryFromNBT(NBTTagCompound nbt, IInventory inventory)
    {
        NBTTagList items = nbt.getTagList(inventory.getName(), Constants.NBT.TAG_COMPOUND);

        for (byte x = 0; x < items.tagCount(); x++)
        {
            NBTTagCompound item = items.getCompoundTagAt(x);

            byte slot = item.getByte("Slot");

            if (slot >= 0 && slot <= inventory.getSizeInventory())
            {
                inventory.setInventorySlotContents(slot, new ItemStack(item));
            }
        }
    }

    public ContainerTurret getNewContainer(EntityPlayer player)
    {
        return (container = new ContainerTurret(player, this, world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
    }

    public ContainerTurret getContainer(EntityPlayer player)
    {
        return container == null && player != null ? container = getNewContainer(player) : container;
    }

    public long getFireRate()
    {
        return fireRate;
    }

    public void setFireRate(int fireRate)
    {
        this.fireRate = fireRate;
    }

    public int getRange()
    {
        return range;
    }

    public void setRange(int range)
    {
        this.range = range;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public void setCycleCount(int count)
    {
        this.cycleCount = count;
    }

    public int getCycleCount()
    {
        return cycleCount;
    }

    public int getBaseCycleCount()
    {
        return 4;
    }

    public void setAmmoDisplayEnabled(boolean ammoDisplayEnabled)
    {
        this.ammoDisplayEnabled = ammoDisplayEnabled;
    }

    public boolean isAmmoDisplayEnabled()
    {
        return ammoDisplayEnabled;
    }

    public Entity getTargetEntity()
    {
        return targetEntity;
    }

    public void setTargetEntity(Entity targetEntity)
    {
        this.targetEntity = targetEntity;
    }

    public ArrayList<Class<? extends Entity>> getDangerousTargets()
    {
        return targetTypes;
    }

    public int getCurAmmo()
    {
        return curAmmo;
    }

    public int getMaxAmmo()
    {
        return 128;
    }

    public void setCurAmmo(int curAmmo)
    {
        this.curAmmo = curAmmo;
    }

    public Item getItemAmmo()
    {
        return itemAmmo;
    }

    public void setItemAmmo(Item itemAmmo)
    {
        this.itemAmmo = itemAmmo;
    }

    public int getCurRounds()
    {
        return rounds;
    }

    public int getMaxRounds()
    {
        return roundsMax;
    }

    public void setCurRounds(int curRounds)
    {
        this.rounds = curRounds;
    }

    public void setMaxRounds(int maxRounds)
    {
        this.roundsMax = maxRounds;
    }

    public float getRotationYaw()
    {
        // this.getDirection() * 90F +
        return this.rot.yaw;
    }

    public float getRotationPitch()
    {
        return this.rot.pitch;
    }

    public boolean isFiring()
    {
        return isFiring;
    }

    @Override
    public void readFromOtherDevice(int ID)
    {
        StringBuilder builder = new StringBuilder();
        ItemStack devicePort = this.inventoryDrive.getStackInSlot(0);

        if (devicePort != null)
        {
            NBTTagCompound nbt = devicePort.getTagCompound();

            if (nbt != null)
            {
                NBTTagList list = nbt.getTagList("Targets", NBT.TAG_STRING);

                if (list != null)
                {
                    for (int i = 0; i < list.tagCount(); i++)
                    {
                        String id = list.getStringTagAt(i);

                        Class<? extends Entity> c = (Class<? extends Entity>) ForgeRegistries.ENTITIES.getValue(new ResourceLocation(AliensVsPredator.Properties.ID, id)).getEntityClass();
                        this.addTargetType(c);
                        builder.append(id + "-");
                    }
                }
            }
        }

        this.sendSyncPacket();
    }

    @Override
    public void writeToOtherDevice(int ID)
    {
        if (container != null)
        {
            ItemStack devicePort = this.inventoryDrive.getStackInSlot(0);

            if (devicePort != null)
            {
                NBTTagCompound nbt = new NBTTagCompound();
                ArrayList<String> entityIDs = new ArrayList<String>();

                for (Class<? extends Entity> c : this.getDangerousTargets())
                {
                    if (c != null)
                    {
                        entityIDs.add(Entities.getEntityRegistrationId(c));
                    }
                }

                nbt.setTag("Targets", NBTStorage.newStringNBTList(entityIDs));

                devicePort.setTagCompound(nbt);
                devicePort.setStackDisplayName("NBT Drive - " + "TURRET." + this.pos.x + "" + this.pos.y + "" + this.pos.z);
                this.inventoryDrive.setInventorySlotContents(0, devicePort);
            }
        }
    }

    @Override
    public Block getBlockType()
    {
        return Blocks.BEACON;
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate)
    {
        return super.receiveVoltage(from, maxReceive, simulate);
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

    public Rotation getRotation()
    {
        return this.rot;
    }

    public Rotation getFocusRotation()
    {
        return this.focrot;
    }

    public Pos getFocusPosition()
    {
        return foc;
    }
}
