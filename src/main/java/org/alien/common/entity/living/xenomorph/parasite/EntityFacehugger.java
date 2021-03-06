package org.alien.common.entity.living.xenomorph.parasite;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.ai.brain.parasitoid.FacehuggerBrain;
import org.alien.common.entity.living.EntityParasitoid;

public class EntityFacehugger extends EntityParasitoid implements Parasitoid {

    public EntityFacehugger(World world) {
        super(world);
        this.setSize(0.8F, 0.3F);
        this.experienceValue = 10;
        this.jumpMovementFactor = 0.3F;
    }

    @Override
    public FacehuggerBrain getBrain() {
        return (FacehuggerBrain) super.getBrain();
    }

    @Override
    public FacehuggerBrain createNewBrain() {
        return new FacehuggerBrain(this);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    public boolean isOnLadder() {
        return this.motionY > 1.0099999997764826D;
    }

    @Override
    protected boolean canTriggerWalking() {
        return true;
    }

    @Override
    protected void despawnEntity() { /* Do Nothing */ }

    @Override
    public void implantEmbryo(EntityLivingBase living) {
        // Give players a 2 second window to remove the facehugger off of their face.
        if (this.ticksOnHost < 20 * 2) return;
        super.implantEmbryo(living);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.isFertile() ? AlienSounds.FACEHUGGER_DEATH.event() : super.getDeathSound();
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AlienItems.SUMMONER_FACEHUGGER);
    }

    @Override
    public SoundEvent getImplantSound() {
        return AlienSounds.FACEHUGGER_IMPLANT.event();
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.0575F, 3.0F);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        if (this.isFertile()) {
            super.knockBack(entityIn, strength, xRatio, zRatio);
        }
    }
}
