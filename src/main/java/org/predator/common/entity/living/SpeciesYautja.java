package org.predator.common.entity.living;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import org.avp.common.AVPItemDrops;
import org.avp.common.network.AvpDataSerializers;
import org.lib.brain.Brainiac;
import org.lib.common.inventory.ItemDropContext;
import org.predator.client.PredatorSounds;
import org.predator.common.entity.ai.brain.YautjaBrain;
import org.predator.common.entity.state.CloakState;

public abstract class SpeciesYautja extends EntityMob implements Host, Brainiac<YautjaBrain>
{
    private static final DataParameter<Boolean> WEARING_MASK = EntityDataManager.createKey(SpeciesYautja.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> DUCKING = EntityDataManager.createKey(SpeciesYautja.class, DataSerializers.BOOLEAN);

    private static final DataParameter<CloakState> CLOAK_STATE = EntityDataManager.createKey(SpeciesYautja.class, AvpDataSerializers.CLOAK_STATE);
    private static final DataParameter<Integer> CLOAK_PROGRESS = EntityDataManager.createKey(SpeciesYautja.class, DataSerializers.VARINT);

    public static int MAX_CLOAK = 20 * 2;
    private static final int MIN_CLOAK = 0;
    private static final int CLOAK_PROGRESS_SPEED = 1;

    public int cloakProgress;

    private YautjaBrain brain;

    public SpeciesYautja(World world)
    {
        super(world);
        this.experienceValue = 250;
        this.cloakProgress = MIN_CLOAK;
        this.setSize(0.75F, 2.5F);
        this.jumpMovementFactor = 0.1F;
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
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(WEARING_MASK, this.rand.nextBoolean());
        this.getDataManager().register(DUCKING, false);
        this.getDataManager().register(CLOAK_STATE, CloakState.DECLOAKED);
        this.getDataManager().register(CLOAK_PROGRESS, MIN_CLOAK);
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
            this.setDucking(this.world.getBlockState(aboveHead).getBlock() != Blocks.AIR);
            
            if (this.isDucking())
            {
                this.setSize(1.0F,  1.75F);
            }
            else
            {
                this.setSize(1.0F,  2.5F);
            }
        }

        this.tickCloakingLogic();
    }
    
    private void tickCloakingLogic() {
		if (!this.world.isRemote) {
            // Yautja should only force de-cloak in water, snow doesn't count.
            boolean isInRain = this.world.isRainingAt(this.getPosition()) && !this.world.getBiome(this.getPosition()).getEnableSnow();
        	if (this.isInWater() || isInRain || this.getAttackTarget() != null) {
                handleDecloak();
            } else {
                handleCloak();
            }
        }

        updateCloakingProgress();
    }

    private void updateCloakingProgress() {
        switch (this.getCloakState()) {
            case CLOAKED:
                this.cloakProgress = MAX_CLOAK;
                break;
            case CLOAKING:
                this.cloakProgress += CLOAK_PROGRESS_SPEED;
                break;
            case DECLOAKING_FORCED:
                this.cloakProgress -= CLOAK_PROGRESS_SPEED;
                break;
            case DECLOAKING_MANUAL:
                this.cloakProgress -= CLOAK_PROGRESS_SPEED * 3;
                break;
            default:
                this.cloakProgress = MIN_CLOAK;
                break;
        }

        this.cloakProgress = MathHelper.clamp(cloakProgress, MIN_CLOAK, MAX_CLOAK);
    }

    private void handleCloak() {
        if (this.cloakProgress < MAX_CLOAK) {
            if (this.getCloakState() != CloakState.CLOAKING) {
                PredatorSounds.YAUTJA_CLOAK.playSound(this, 0.6F, 1.0F);
            }

            this.setCloakState(CloakState.CLOAKING);
        } else if (this.cloakProgress == MAX_CLOAK) {
            this.setCloakState(CloakState.CLOAKED);
        }
    }

    private void handleDecloak() {
        CloakState decloakType = this.getAttackTarget() != null ? CloakState.DECLOAKING_MANUAL : CloakState.DECLOAKING_FORCED;
        if (this.cloakProgress > MIN_CLOAK) {
            if (this.getCloakState() != CloakState.DECLOAKING_FORCED && this.getCloakState() != CloakState.DECLOAKING_MANUAL) {
                PredatorSounds.YAUTJA_DECLOAK.playSound(this, 0.6F, 1.0F);
            }

            this.setCloakState(decloakType);
        } else if (this.cloakProgress == MIN_CLOAK) {
            this.setCloakState(CloakState.DECLOAKED);
        }
    }

    // This method allows us to cancel the hurt animation, but it looks as if it may be responsible for other things.
    @Override
    public void handleStatusUpdate(byte id) {
        if (this.getCloakState() == CloakState.CLOAKED) return;
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
    public boolean isInWater()
    {
        return super.isInWater();
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
        itemDropContext.drop(AVPItemDrops.PREDATOR_ARTIFACT);
        itemDropContext.drop(AVPItemDrops.PLASMACANNON);
        itemDropContext.drop(AVPItemDrops.WRISTBRACER);
        itemDropContext.drop(AVPItemDrops.SHURIKEN);
        itemDropContext.drop(AVPItemDrops.SILICON);
        itemDropContext.drop(AVPItemDrops.WRISTBRACER_BLADES);
        
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
    
    @Override
    protected void despawnEntity() { /* Do Nothing */ }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        this.setWearingMask(tag.getBoolean("WearingMask"));
        this.setCloakState(CloakState.getValuesByIdMap().get((int)tag.getByte("CloakState")));
        this.cloakProgress = tag.getInteger("CloakProgress");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setBoolean("WearingMask", this.isWearingMask());
        tag.setByte("CloakState", (byte)this.getCloakState().id);
        tag.setInteger("CloakProgress", this.cloakProgress);
    }

    public boolean isWearingMask()
    {
        return this.getDataManager().get(WEARING_MASK);
    }

    public boolean isDucking()
    {
        return this.getDataManager().get(DUCKING);
    }

    public void setCloakState(CloakState cloakState) {
    	if (!this.world.isRemote) {
    		this.getDataManager().set(CLOAK_STATE, cloakState);
    	}
    }

    public CloakState getCloakState() {
    	return this.getDataManager().get(CLOAK_STATE);
    }

    public void setWearingMask(boolean wearingMask)
    {
        if (!this.world.isRemote)
        {
            this.getDataManager().set(WEARING_MASK, wearingMask);
        }
    }

    public void setDucking(boolean ducking)
    {
        if (!this.world.isRemote)
        {
            this.getDataManager().set(DUCKING, ducking);
        }
    }

    @Override
    public boolean canParasiteAttach()
    {
        return !this.isWearingMask();
    }
    
    @Override
    public boolean canHostParasite()
    {
        return true;
    }

    @Override
    protected float getSoundVolume() {
        return 1.1F - (this.cloakProgress / (float)MAX_CLOAK);
    }
}
