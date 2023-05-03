package org.alien.common.entity.living;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.alien.common.entity.ai.brain.xenomorph.XenomorphBrain;
import org.alien.common.world.hive.HiveMember;
import org.avp.common.AVPItemDrops;
import org.lib.common.inventory.ItemDropContext;

public abstract class SpeciesXenomorph extends SpeciesAlien implements HiveMember {

    protected XenomorphBrain brain;

    protected SpeciesXenomorph(World world) {
        super(world);
        this.jumpMovementFactor = 0.045F;
    }

    @Override
    public XenomorphBrain getBrain() {
        return (XenomorphBrain) super.getBrain();
    }

    @Override
    public XenomorphBrain createNewBrain() {
        return new XenomorphBrain(this);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        /* Fall Damage Negation */
        this.fallDistance = 0F;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);

        dropLoot(damageSource);
    }

    protected void dropLoot(DamageSource damageSource) {
        ItemDropContext itemDropContext = new ItemDropContext(this);
        itemDropContext.drop(AVPItemDrops.XENO_FEET);
        itemDropContext.drop(AVPItemDrops.XENO_HELM);
        itemDropContext.drop(AVPItemDrops.XENO_LEGS);
        itemDropContext.drop(AVPItemDrops.XENO_TORSO);

        dropSkull(damageSource, itemDropContext);
        dropJelly(itemDropContext);
    }

    protected void dropJelly(ItemDropContext itemDropContext) {
        int adjustedLevel = this.getJellyLevel() / 4;

        if (!this.jellyLimitOverride) {
            adjustedLevel = Math.min(adjustedLevel, 64);
        }

        itemDropContext.dropWithAmount(AVPItemDrops.ROYAL_JELLY, adjustedLevel);
    }

    protected void dropSkull(DamageSource damageSource, ItemDropContext itemDropContext) {}

    // Speeds up xenomorphs in water.
    @Override
    protected float getWaterSlowDown() {
        return 0.9F;
    }
}
