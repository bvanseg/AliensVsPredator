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
import org.lib.brain.impl.EntityBrainContext;

public class EntityOvamorph extends SpeciesAlien implements IMob, HiveMember, Brainiac<OvamorphBrain>
{
    private static final DataParameter<Integer> TIME_LEFT_UNTIL_OPEN = EntityDataManager.createKey(EntityOvamorph.class, DataSerializers.VARINT);
    private static final DataParameter<Byte>    OPEN_PROGRESS    = EntityDataManager.createKey(EntityOvamorph.class, DataSerializers.BYTE);

    public static final int MAX_OPEN_PROGRESS = 21;

    public boolean                           acceleratedHatching;
    public int                               hatchWaitTimer;
    private boolean                              containsFacehugger;
    protected boolean                           sendUpdates;
    private int                                 timeSinceHatched = 0;

    private OvamorphBrain brain;

    public EntityOvamorph(World par1World)
    {
        super(par1World);
        this.setSize(1F, 1F);
        this.experienceValue = 10;
        this.hatchWaitTimer = 20 * 3 + (20 * rand.nextInt(5));
        this.containsFacehugger = true;
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
        this.getDataManager().register(OPEN_PROGRESS, (byte) -MAX_OPEN_PROGRESS);
        this.getDataManager().register(TIME_LEFT_UNTIL_OPEN, 20 * 30 + (10 * rand.nextInt(24)));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);

        this.containsFacehugger = nbt.getBoolean("containsFacehugger");
        this.timeSinceHatched = nbt.getInteger("timeHatched");
        this.setOpenProgress(nbt.getInteger("openProgress"));
        this.sendUpdates = true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);

        nbt.setBoolean("containsFacehugger", this.containsFacehugger);
        nbt.setInteger("openProgress", this.getOpenProgress());
        nbt.setInteger("timeHatched", this.timeSinceHatched);
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        AVPItemDrops.ROYAL_JELLY_GENERIC.tryDrop(this);
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
    protected void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);
        if (entity instanceof EntityLivingBase && EntitySelectorParasitoid.instance.test((EntityLivingBase) entity))
            this.setTimeLeftUntilOpen(0);
    }

    @Override
    protected void damageEntity(DamageSource source, float amount)
    {
        super.damageEntity(source, amount);
        AVPItemDrops.ROYAL_JELLY_SINGLE.tryDrop(this);
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
