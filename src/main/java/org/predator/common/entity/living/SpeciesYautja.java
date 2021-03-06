package org.predator.common.entity.living;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.alien.common.api.parasitoidic.Host;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPItemDropTables;
import org.avp.common.AVPItemDrops;
import org.avp.common.network.AvpDataSerializers;
import org.lib.brain.Brainiac;
import org.lib.common.entity.BooleanDataHandle;
import org.lib.common.entity.EnumDataHandle;
import org.lib.common.inventory.ItemDropContext;
import org.predator.client.PredatorSounds;
import org.predator.common.entity.PredatorCreatureTypes;
import org.predator.common.entity.ai.brain.YautjaBrain;
import org.predator.common.entity.living.helper.YautjaCloakHelper;
import org.predator.common.entity.state.CloakState;

public abstract class SpeciesYautja extends EntityMob implements Host, Brainiac<YautjaBrain>
{
    private static final DataParameter<Boolean> WEARING_MASK = EntityDataManager.createKey(SpeciesYautja.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> DUCKING = EntityDataManager.createKey(SpeciesYautja.class, DataSerializers.BOOLEAN);

    public static final DataParameter<CloakState> CLOAK_STATE = EntityDataManager.createKey(SpeciesYautja.class, AvpDataSerializers.CLOAK_STATE);

    public final BooleanDataHandle isWearingMask = new BooleanDataHandle(this, WEARING_MASK);
    public final BooleanDataHandle isDucking = new BooleanDataHandle(this, DUCKING);
    public final EnumDataHandle<CloakState> cloakState = new EnumDataHandle<>(this, CLOAK_STATE);

    public int cloakRenderProgress;

    private YautjaBrain brain;

    protected SpeciesYautja(World world)
    {
        super(world);
        this.experienceValue = 250;
        this.cloakRenderProgress = YautjaCloakHelper.MIN_CLOAK;
        this.setSize(0.75F, 2.5F);
        this.jumpMovementFactor = 0.1F;
    }

    @Override
    public boolean getCanSpawnHere() {
        boolean isAboveSeaLevel = this.posY >= this.world.getSeaLevel();
        return super.getCanSpawnHere() && isAboveSeaLevel;
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean isCreatureType(EnumCreatureType type, boolean forSpawnCount) {
        // If not using custom creature type, fall back on default super behavior.
        if (PredatorCreatureTypes.getPredatorCreatureType() == EnumCreatureType.MONSTER)
            return super.isCreatureType(type, forSpawnCount);

        if (type == EnumCreatureType.MONSTER)
            return false;

        if (forSpawnCount && this.isNoDespawnRequired())
            return false;

        // Otherwise, override for the predator creature type. If we do not do this, the superclass will check against assignable
        // classes on the creature
        return type.getCreatureClass().isAssignableFrom(this.getClass());
    }

    public float getBlockPathWeight(BlockPos pos) {
        return 0.0F;
    }

    @Override
    public YautjaBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new YautjaBrain(this);
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(WEARING_MASK, this.rand.nextBoolean());
        this.getDataManager().register(DUCKING, false);
        YautjaCloakHelper.entityInit(this);
    }
    
    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update();
        }
        
        if (this.world.getTotalWorldTime() % 10 == 0)
        {
            BlockPos aboveHead = this.getPosition().add(0, 3, 0);

            if (!this.world.isRemote) {
                this.isDucking.set(this.world.getBlockState(aboveHead).getBlock() != Blocks.AIR);
            }
            
            if (this.isDucking.get())
            {
                this.setSize(1.0F,  1.75F);
            }
            else
            {
                this.setSize(1.0F,  2.5F);
            }
        }

        YautjaCloakHelper.tickCloakingLogic(this);
    }

    // This method allows us to cancel the hurt animation, but it looks as if it may be responsible for other things.
    @Override
    public void handleStatusUpdate(byte id) {
        if (this.cloakState.get() == CloakState.CLOAKED) return;
        super.handleStatusUpdate(id);
    }

    @Override
    public int getMaxFallHeight()
    {
        return 20;
    }
    
    @Override
    public void fall(float distance, float damageMultiplier)
    {
        int intensity = MathHelper.ceil((distance - 3.0F) * damageMultiplier);

        if (intensity > 0)
        {
            this.playSound(this.getFallSound(intensity), 1.0F, 1.0F);
            
            if (this.world.getTotalWorldTime() % 4 == 0)
                this.playSound(this.getDeathSound(), 1.0F, 1.0F);
            
            int x = MathHelper.floor(this.posX);
            int y = MathHelper.floor(this.posY - 0.20000000298023224D);
            int z = MathHelper.floor(this.posZ);
            IBlockState state = this.world.getBlockState(new BlockPos(x, y, z));

            if (state.getMaterial() != Material.AIR)
            {
                SoundType soundtype = state.getBlock().getSoundType(state, world, new BlockPos(x, y, z), this);
                this.playSound(soundtype.getFallSound(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        int damage = 6;

        if (this.isPotionActive(MobEffects.INSTANT_DAMAGE))
        {
            damage += 3 << this.getActivePotionEffect(MobEffects.INSTANT_DAMAGE).getAmplifier();
        }

        if (this.isPotionActive(MobEffects.WEAKNESS))
        {
            damage -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }

        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
    }

    @Override
    public int getTotalArmorValue()
    {
        return 7;
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        if (entity instanceof IMob && this.rand.nextInt(20) == 0 && !(entity instanceof SpeciesYautja))
        {
            this.setAttackTarget((EntityLivingBase) entity);
            this.setRevengeTarget((EntityLivingBase) entity);
        }

        super.collideWithEntity(entity);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return PredatorSounds.YAUTJA_LIVING.event();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return PredatorSounds.YAUTJA_HURT.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return PredatorSounds.YAUTJA_DEATH.event();
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        ItemDropContext itemDropContext = new ItemDropContext(this);
        itemDropContext.drop(AVPItemDropTables.PREDATOR_DROP_TABLE);
        itemDropContext.drop(AVPItemDropTables.PREDATOR_DROP_TABLE);
        dropBiomaskAndSkull(itemDropContext, damagesource);
    }
    
    protected void dropBiomaskAndSkull(ItemDropContext itemDropContext, DamageSource damagesource)
    {
        if (damagesource.getDamageType().equalsIgnoreCase(AVPDamageSources.WRISTBRACER)) {
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.SKULL_PREDATOR, 25);
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.BIOMASK, 25);
        }
        else
        {
            itemDropContext.drop(AVPItemDrops.SKULL_PREDATOR);
            itemDropContext.drop(AVPItemDrops.BIOMASK);
        }
    }

    private static final String WEARING_MASK_NBT_KEY = "WearingMask";
    private static final String CLOAK_STATE_NBT_KEY = "CloakState";
    private static final String CLOAK_PROGRESS_NBT_KEY = "CloakProgress";

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        this.isWearingMask.set(tag.getBoolean(WEARING_MASK_NBT_KEY));
        this.cloakState.set(CloakState.getValuesByIdMap().get((int)tag.getByte(CLOAK_STATE_NBT_KEY)));
        this.cloakRenderProgress = tag.getInteger(CLOAK_PROGRESS_NBT_KEY);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setBoolean(WEARING_MASK_NBT_KEY, this.isWearingMask.get());
        tag.setByte(CLOAK_STATE_NBT_KEY, (byte)this.cloakState.get().id);
        tag.setInteger(CLOAK_PROGRESS_NBT_KEY, this.cloakRenderProgress);
    }

    @Override
    public boolean canParasiteAttach()
    {
        return !this.isWearingMask.get();
    }
    
    @Override
    public boolean canHostParasite()
    {
        return true;
    }

    @Override
    protected float getSoundVolume() {
        return 1.1F - (this.cloakRenderProgress / (float)YautjaCloakHelper.MAX_CLOAK);
    }
}
