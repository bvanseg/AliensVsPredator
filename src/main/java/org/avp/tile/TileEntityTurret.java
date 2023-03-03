package org.avp.tile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.api.machines.IDataDevice;
import org.avp.api.power.IVoltageReceiver;
import org.avp.client.Sounds;
import org.avp.entities.living.EntityAethon;
import org.avp.entities.living.species.engineer.EntityEngineer;
import org.avp.entities.living.species.engineer.EntitySpaceJockey;
import org.avp.entities.living.species.species223ode.EntityDeacon;
import org.avp.entities.living.species.species223ode.EntityTrilobite;
import org.avp.entities.living.species.xenomorphs.EntityChestburster;
import org.avp.entities.living.species.xenomorphs.EntityCrusher;
import org.avp.entities.living.species.xenomorphs.EntityDrone;
import org.avp.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.entities.living.species.xenomorphs.EntityNauticomorph;
import org.avp.entities.living.species.xenomorphs.EntityOvamorph;
import org.avp.entities.living.species.xenomorphs.EntityPraetorian;
import org.avp.entities.living.species.xenomorphs.EntityPredalien;
import org.avp.entities.living.species.xenomorphs.EntityPredalienChestburster;
import org.avp.entities.living.species.xenomorphs.EntityQueenChestburster;
import org.avp.entities.living.species.xenomorphs.EntityRunnerChestburster;
import org.avp.entities.living.species.xenomorphs.EntityRunnerDrone;
import org.avp.entities.living.species.xenomorphs.EntityRunnerWarrior;
import org.avp.entities.living.species.xenomorphs.EntitySpitter;
import org.avp.entities.living.species.xenomorphs.EntityUltramorph;
import org.avp.entities.living.species.xenomorphs.EntityWarrior;
import org.avp.entities.living.species.xenomorphs.parasites.EntityFacehugger;
import org.avp.entities.living.species.xenomorphs.parasites.EntityRoyalFacehugger;
import org.avp.entities.living.vardic.EntityBelugaburster;
import org.avp.entities.living.vardic.EntityBelugamorph;
import org.avp.entities.living.vardic.EntityDeaconShark;
import org.avp.entities.living.vardic.EntityGooMutant;
import org.avp.entities.living.vardic.EntityHammerpede;
import org.avp.entities.living.vardic.EntityOctohugger;
import org.avp.inventory.ContainerTurret;
import org.avp.packets.client.PacketTurretSync;
import org.avp.packets.server.PacketTurretTargetUpdate;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.client.util.Rotation;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.storage.NBTStorage;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.EntityEntry;
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
    private HashSet<Class<? extends Entity>>   targetTypes;
    private HashSet<String>                    targetPlayers;
    public InventoryBasic                      inventoryAmmo;
    public InventoryBasic                      inventoryExpansion;
    public InventoryBasic                      inventoryDrive;
    private Entity                             targetEntity;
    private ContainerTurret                    container;
    private Pos                                pos;
    private Rotation                           rot;
    private Rotation                           rotPrev;
    private Pos                                foc;
    private Rotation                           focrot;
    private Item                               itemAmmo;
    public int                                 beamColor;

    public TileEntityTurret()
    {
        super(false);
        this.targetTypes = new HashSet<>();
        this.targetPlayers = new HashSet<>();
        this.inventoryAmmo = new InventoryBasic("TurretAmmoBay", true, 9);
        this.inventoryExpansion = new InventoryBasic("TurretExpansionBay", true, 3);
        this.inventoryDrive = new InventoryBasic("TurretDriveBay", true, 1);
        this.fireRate = 2;
        this.range = 24;
        this.cycleCount = getBaseCycleCount();
        this.curAmmo = 0;
        this.rot = new Rotation(0F, 0F);
        this.rotPrev = new Rotation(0F, 0F);
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
            this.tryReload();
            this.findTarget();
            this.targetAndAttack();
        }
    }

    public Entity findTarget()
    {
        List<? extends Entity> entities = Entities.getEntitiesInCoordsRange(world, EntityLivingBase.class, this.pos, 32);

        Entity newTarget = null;

        if (!entities.isEmpty()) {
            entities.get(this.world.rand.nextInt(entities.size()));
        }

        for (Entity e : entities) {
            if (this.canSee(e)) {
                newTarget = e;
                break;
            }
        }

        if (this.targetEntity == null || this.targetEntity.isDead || !canSee(this.targetEntity))
        {
            if (this.canTarget(newTarget) && canSee(newTarget))
            {
                this.targetEntity = newTarget;
                return newTarget;
            }
        }

        return null;
    }

    public boolean canTarget(Entity e) {
        if (e != null && !e.isDead) {
            double distance = Pos.distance(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), e.posX, e.posY, e.posZ);
            return (e instanceof EntityPlayer && this.canTargetPlayer((EntityPlayer) e) || this.canTargetType(e.getClass())) && distance <= this.range;
        }

        return false;
    }

    public boolean canTargetPlayer(EntityPlayer player) {
    	// TODO: Store UUIDs, not names to avoid casing discrepancies.
    	return this.targetPlayers.contains(player.getCommandSenderEntity().getName());
    }

    private boolean canSee(Entity e)
    {
        double height = e.getEntityBoundingBox().maxY - e.getEntityBoundingBox().minY;
        double halfHeight = height / 2;

        Vec3d mid = new Vec3d(e.posX, e.getEntityBoundingBox().maxY - (halfHeight), e.posZ);
        Vec3d top = new Vec3d(e.posX, e.getEntityBoundingBox().maxY - (halfHeight + halfHeight), e.posZ);
        Vec3d bot = new Vec3d(e.posX, e.getEntityBoundingBox().maxY - (halfHeight - halfHeight), e.posZ);
        Vec3d offset = new Vec3d(this.pos.x, this.pos.y, this.pos.z).add(0.5, 1, 0.5);
        RayTraceResult midResult = this.world.rayTraceBlocks(mid, offset, false, true, false);
        RayTraceResult topResult = this.world.rayTraceBlocks(top, offset, false, true, false);
        RayTraceResult botResult = this.world.rayTraceBlocks(bot, offset, false, true, false);

        if (midResult == null || topResult == null || botResult == null)
        {
            return true;
        }

        return false;
    }

    private void updatePosition(double x, double y, double z) {
    	this.foc = new Pos(x, y, z);
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

        if (!this.world.isRemote) {
            if (!this.canTarget(targetEntity)) {
            	EntityLiving newTarget = (EntityLiving) Entities.getRandomEntityInCoordsRange(this.world, EntityLiving.class, this.pos, range, range);

                if (newTarget != null && this.targetTypes.contains(newTarget.getClass()) && this.canTarget(newTarget) && canSee(newTarget)) {
                    this.targetEntity = newTarget;
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
            }

            if (this.canSee(targetEntity))
            {
                if (world.getTotalWorldTime() % fireRate == 0L && this.rot.yaw == this.focrot.yaw) {
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
                    this.rotPrev.yaw = this.rot.yaw;
                    this.rot.yaw += 1;
                }
                else if (Math.ceil(this.getRotationYaw()) > Math.ceil(this.focrot.yaw))
                {
                    this.rotPrev.yaw = this.rot.yaw;
                    this.rot.yaw -= 1;
                }

                if (Math.ceil(this.getRotationPitch()) < Math.ceil(this.focrot.pitch))
                {
                    this.rotPrev.pitch = this.rot.pitch;
                    this.rot.pitch += 1;
                }
                else if (Math.ceil(this.getRotationPitch()) > Math.ceil(this.focrot.pitch))
                {
                    this.rotPrev.pitch = this.rot.pitch;
                    this.rot.pitch -= 1;
                }

                double focus = 1;

                if (Math.ceil(this.getRotationPitch()) >= Math.ceil(this.focrot.pitch - focus) && Math.ceil(this.getRotationPitch()) <= Math.ceil(this.focrot.pitch + focus) && Math.ceil(this.getRotationYaw()) >= Math.ceil(this.focrot.yaw - focus) && Math.ceil(this.getRotationYaw()) <= Math.ceil(this.focrot.yaw + focus))
                {
                    this.rotPrev.pitch = this.rot.pitch;
                    this.rotPrev.yaw = this.rot.yaw;
                    this.rot.pitch = this.focrot.pitch;
                    this.rot.yaw = this.focrot.yaw;
                }
            }
        }
    }

    public void tryReload() {
        if (this.curAmmo < this.getMaxAmmo() && this.curAmmo <= 0)
        {
            this.reload();
        }
    }

    public void updateAmmunitionCount()
    {
        if (world.getTotalWorldTime() % 8L == 0L)
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
        // this.world.spawnParticle(EnumParticleTypes.CLOUD, this.pos.x, this.pos.y,
        // this.pos.z, 0, 10, 0);
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

    public void addTargetPlayer(String name)
    {
        this.targetPlayers.add(name);
    }

    public void removeTargetPlayer(String name)
    {
        if (this.targetPlayers.contains(name))
        {
            this.targetPlayers.remove(name);

            if (this.targetEntity instanceof EntityPlayer && this.targetEntity.getName().equalsIgnoreCase(name))
            {
                this.targetEntity = null;
            }
        }
    }

    public void removeTargetType(Class<? extends Entity> entityClass)
    {
        this.setTargetEntity(null);
        this.targetTypes.remove(entityClass);
    }

    public void addTargetType(Class<? extends Entity> entityClass)
    {
        this.setTargetEntity(null);
        this.targetTypes.add(entityClass);
    }

    public boolean canTargetType(Class<? extends Entity> entityClass)
    {
        return this.targetTypes.contains(entityClass);
    }

    public void setPredefinedTargets()
    {
        this.addTargetType(EntityPlayer.class);
        this.addTargetType(EntityOvamorph.class);
        this.addTargetType(EntityFacehugger.class);
        this.addTargetType(EntityChestburster.class);
        this.addTargetType(EntityDrone.class);
        this.addTargetType(EntityWarrior.class);
        this.addTargetType(EntityPraetorian.class);
        this.addTargetType(EntityMatriarch.class);
        this.addTargetType(EntityCrusher.class);
        this.addTargetType(EntitySpitter.class);
        this.addTargetType(EntityNauticomorph.class);
        this.addTargetType(EntityPredalien.class);
        this.addTargetType(EntitySlime.class);
        this.addTargetType(EntityNauticomorph.class);
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

            if (pciSlot.getItem() == AliensVsPredator.items().itemProcessor)
            {
                cycles += pciSlot.getCount();
            }

            if (pciSlot.getItem() == AliensVsPredator.items().itemLedDisplay)
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
        this.readTargetList(list);
    }

    public void readTargetList(NBTTagList list)
    {
        for (int i = 0; i < list.tagCount(); i++)
        {
            String id = list.getStringTagAt(i);

            ResourceLocation identifier = new ResourceLocation(id);
            EntityEntry entityEntry = ForgeRegistries.ENTITIES.getValue(identifier);
            Class<? extends Entity> entityClass = (Class<? extends Entity>) entityEntry.getEntityClass();
            this.addTargetType(entityClass);
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

    public HashSet<String> getTargetPlayers()
    {
        return targetPlayers;
    }

    public Entity getTargetEntity()
    {
        return targetEntity;
    }

    public void setTargetEntity(Entity targetEntity)
    {
        this.targetEntity = targetEntity;
    }

    public HashSet<Class<? extends Entity>> getDangerousTargets()
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

    public Rotation getRotationPrev()
    {
        return rotPrev;
    }

    public boolean isFiring()
    {
        return isFiring;
    }

    @Override
    public void readFromOtherDevice(int ID)
    {
        ItemStack devicePort = this.inventoryDrive.getStackInSlot(0);

        NBTTagCompound nbt = devicePort.getTagCompound();

        if (nbt != null)
        {
            NBTTagList list = nbt.getTagList("Targets", NBT.TAG_STRING);

            if (list != null)
            {
                for (int i = 0; i < list.tagCount(); i++)
                {
                    String id = list.getStringTagAt(i);

                    EntityEntry entityEntry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(AliensVsPredator.Properties.ID, id));

                    for (EntityEntry e : ForgeRegistries.ENTITIES.getValues())
                    {
                        if (id.equalsIgnoreCase(e.getRegistryName().toString()))
                        {
                            entityEntry = e;
                        }
                    }

                    if (entityEntry != null)
                    {
                        Class<? extends Entity> c = entityEntry.getEntityClass();
                        this.addTargetType(c);
                    } else {
                        MDX.log().warn("NULL EntityEntry found in NBTDrive for id " + id);
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
