package org.alien.common.entity.living.xenomorph.exotic;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.xenomorph.NauticomorphBrain;
import org.alien.common.entity.ai.brain.xenomorph.XenomorphBrain;
import org.alien.common.entity.living.SpeciesXenomorph;

public class EntityNauticomorph extends SpeciesXenomorph {
    private static final DataParameter<Float> PHOSPHORESCENCE_LEVEL = EntityDataManager.createKey(EntityNauticomorph.class, DataSerializers.FLOAT);

    public EntityNauticomorph(World world) {
        super(world);
        this.jumpMovementFactor = 0.2F;
        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
    }

    @Override
    public NauticomorphBrain getBrain() {
        return (NauticomorphBrain) super.getBrain();
    }

    @Override
    public NauticomorphBrain createNewBrain() {
        return new NauticomorphBrain(this);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(PHOSPHORESCENCE_LEVEL, 0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5500000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return AlienSounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return AlienSounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AlienSounds.ALIEN_DEATH.event();
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    public float getPhosphorescenceLevel() {
        return this.getDataManager().get(PHOSPHORESCENCE_LEVEL);
    }

    public void setPhosphorescenceLevel(float level) {
        this.getDataManager().set(PHOSPHORESCENCE_LEVEL, level);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AlienItems.SUMMONER_AQUA);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.98F;
    }
}
