package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.xenomorph.OvamorphBrain;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.hive.HiveMember;
import org.avp.common.AVPItemDrops;
import org.lib.brain.Brainiac;
import org.lib.common.inventory.ItemDropContext;

public class EntityOvamorph extends SpeciesAlien implements IMob, HiveMember, Brainiac<OvamorphBrain>
{
    private static final DataParameter<Integer> TIME_LEFT_UNTIL_OPEN = EntityDataManager.createKey(EntityOvamorph.class, DataSerializers.VARINT);
    private static final DataParameter<Byte> OPEN_PROGRESS = EntityDataManager.createKey(EntityOvamorph.class, DataSerializers.BYTE);

    public static final int MAX_OPEN_PROGRESS = 42;

    public boolean acceleratedHatching;
    public int hatchWaitTimer;
    private boolean containsFacehugger;
    protected boolean sendUpdates;
    private int timeSinceHatched = 0;

    public boolean wantsToBeMoved;
    public boolean hasBeenMoved;

    public float renderOpenProgress;

    private OvamorphBrain brain;

    public EntityOvamorph(World par1World)
    {
        super(par1World);
        this.setSize(0.85F, 1F);
        this.experienceValue = 10;
        this.hatchWaitTimer = 20 * 3 + (20 * rand.nextInt(5));
        this.containsFacehugger = true;
        this.wantsToBeMoved = false;
        this.hasBeenMoved = false;
        this.renderOpenProgress = -1;
    }

    @Override
    public OvamorphBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new OvamorphBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(OPEN_PROGRESS, (byte) 0);
        this.getDataManager().register(TIME_LEFT_UNTIL_OPEN, 20 * 30 + (10 * rand.nextInt(24)));
    }

    private static final String CONTAINS_FACEHUGGER_NBT_KEY = "containsFacehugger";
    private static final String TIME_HATCHED_NBT_KEY = "timeHatched";
    private static final String OPEN_PROGRESS_NBT_KEY = "openProgress";
    private static final String HAS_BEEN_MOVED_NBT_KEY = "hasBeenMoved";

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);

        this.containsFacehugger = nbt.getBoolean(CONTAINS_FACEHUGGER_NBT_KEY);
        this.timeSinceHatched = nbt.getInteger(TIME_HATCHED_NBT_KEY);
        this.setOpenProgress(nbt.getInteger(OPEN_PROGRESS_NBT_KEY));
        this.hasBeenMoved = nbt.getBoolean(HAS_BEEN_MOVED_NBT_KEY);
        this.sendUpdates = true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);

        nbt.setBoolean(CONTAINS_FACEHUGGER_NBT_KEY, this.containsFacehugger);
        nbt.setInteger(OPEN_PROGRESS_NBT_KEY, this.getOpenProgress());
        nbt.setInteger(TIME_HATCHED_NBT_KEY, this.timeSinceHatched);
        nbt.setBoolean(HAS_BEEN_MOVED_NBT_KEY, this.hasBeenMoved);
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        ItemDropContext itemDropContext = new ItemDropContext(this);
        itemDropContext.drop(AVPItemDrops.ROYAL_JELLY);
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update();
        }

        if (this.getHealth() < this.getMaxHealth())
        {
            this.acceleratedHatching = true;
        }

        if (!this.containsFacehugger)
        {
            this.timeSinceHatched++;

            if (this.timeSinceHatched >= 20 * 60 * 5)
                this.setDead();
        }
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        super.notifyDataManagerChange(key);

        if (key == OPEN_PROGRESS && this.renderOpenProgress == -1) {
            this.renderOpenProgress = this.getOpenProgress();
        }
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);
        if (entity instanceof EntityLivingBase && EntitySelectorParasitoid.instance.test(entity))
            this.setTimeLeftUntilOpen(0);
    }

    @Override
    protected void damageEntity(DamageSource source, float amount)
    {
        super.damageEntity(source, amount);
        ItemDropContext itemDropContext = new ItemDropContext(this);
        itemDropContext.dropWithAmount(AVPItemDrops.ROYAL_JELLY, 1);
    }

    public int getOpenProgress()
    {
        return this.getDataManager().get(OPEN_PROGRESS);
    }

    public void setOpenProgress(int progress)
    {
        this.getDataManager().set(OPEN_PROGRESS, (byte) progress);
    }

    public int getTimeLeftUntilOpen()
    {
        return this.getDataManager().get(TIME_LEFT_UNTIL_OPEN);
    }

    public void setTimeLeftUntilOpen(int hatchingTime)
    {
        this.getDataManager().set(TIME_LEFT_UNTIL_OPEN, hatchingTime);
    }

    public boolean containsFacehugger() {
        return containsFacehugger;
    }

    public void setContainsFacehugger(boolean containsFacehugger)
    {
        this.containsFacehugger = containsFacehugger;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_OVAMORPH);
    }
}
