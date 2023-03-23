package org.avp.common.entity.living;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.client.AVPSounds;
import org.avp.common.AVPItemDrops;
import org.avp.common.AVPItems;
import org.avp.common.entity.EntityBullet;
import org.avp.common.entity.ai.brain.MarineBrain;
import org.avp.common.world.MarineTypes;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

public class EntityMarine extends EntityCreature implements IMob, IRangedAttackMob, Brainiac<MarineBrain>
{
    protected static final int[] SKIN_TONES = new int[] { 0xF1C381FF, 0xC58C85FF, 0xECBCB4FF, 0xD1A3A4FF, 0xA1665EFF, 0x503335FF, 0x592F2AFF };
    protected static final int[] EYE_COLORS = new int[] {
            0x4D1500FF, // Classic brownish-black
            0x8BB5DBFF, // Light Blue
            0x4079C0FF, // Blue
            0xB3B9B9FF, // Light Gray
            0x8E9796FF, // Gray
            0x748B9DFF, // Blue-Gray
            0x6E9D4CFF, // Green
            0xAA6925FF, // Amber
            0x863603FF, // Light Brown
            0x3f0c08FF  // Dark Brown
    };

    private static final DataParameter<Boolean> AIMING = EntityDataManager.createKey(EntityMarine.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TYPE   = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> SKIN_TONE   = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> EYE_COLOR   = EntityDataManager.createKey(EntityMarine.class, DataSerializers.VARINT);

    protected MarineBrain brain;

    public EntityMarine(World world)
    {
        super(world);
        this.experienceValue = 5;
    }

    @Override
    public MarineBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new MarineBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(AIMING, false);
        this.getDataManager().register(TYPE, this.world.rand.nextInt(MarineTypes.values().length));
        this.getDataManager().register(SKIN_TONE, SKIN_TONES[this.world.rand.nextInt(SKIN_TONES.length)]);
        this.getDataManager().register(EYE_COLOR, EYE_COLORS[this.world.rand.nextInt(EYE_COLORS.length)]);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6499999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
    }

    @Override
    public float getBlockPathWeight(BlockPos pos)
    {
        return 0.5F - this.world.getLightBrightness(pos);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return AVPSounds.MARINE_HURT.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AVPSounds.MARINE_DEATH.event();
    }

    @Override
    public ItemStack getHeldItemMainhand()
    {
        return new ItemStack(getMarineType().getFirearmItem());
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote)
        {
            this.brain.update();
            this.getDataManager().set(AIMING, this.getAttackTarget() != null || this.getBrain().hasMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET));
        }
    }

    @Override
    public void onDeath(DamageSource damageSource)
    {
        super.onDeath(damageSource);
        AVPItemDrops.AMMUNITION.tryDrop(this);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null)
        {
            EntityBullet entityBullet = new EntityBullet(this.world, this, targetEntity, 10F, 0.0000001F);
            this.world.spawnEntity(entityBullet);
            this.playSound(getMarineType().getGunfireSound(), 0.7F, 1F);
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + this.getEyeHeight(), this.posZ, 1, 1, 1);
        }
    }

    public MarineTypes getMarineType()
    {
        Integer marineTypeInteger = this.getDataManager().get(TYPE);
        MarineTypes marineType = MarineTypes.getTypeForId(marineTypeInteger);
        return marineType != null ? marineType : MarineTypes.M41A;
    }

    public boolean isAiming()
    {
        return this.getDataManager().get(AIMING);
    }

    public int getSkinTone()
    {
        return this.dataManager.get(SKIN_TONE);
    }

    public int getEyeColor()
    {
        return this.dataManager.get(EYE_COLOR);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) { /* Do Nothing */ }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AVPItems.SUMMONER_MARINE);
    }

    private static final String WEAPON_TYPE_NBT_KEY = "WeaponType";
    private static final String SKIN_TONE_NBT_KEY = "SkinTone";
    private static final String EYE_COLOR_NBT_KEY = "EyeColor";

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger(WEAPON_TYPE_NBT_KEY, this.dataManager.get(TYPE));
        nbt.setInteger(SKIN_TONE_NBT_KEY, this.getSkinTone());
        nbt.setInteger(EYE_COLOR_NBT_KEY, this.getEyeColor());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.dataManager.set(TYPE, nbt.getInteger(WEAPON_TYPE_NBT_KEY));
        this.dataManager.set(SKIN_TONE, nbt.getInteger(SKIN_TONE_NBT_KEY));
        this.dataManager.set(EYE_COLOR, nbt.getInteger(EYE_COLOR_NBT_KEY));
    }
}
