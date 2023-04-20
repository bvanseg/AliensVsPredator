package org.alien.common.entity.living;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.alien.common.entity.ai.brain.xenomorph.XenomorphBrain;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPItemDrops;
import org.lib.brain.Brainiac;
import org.lib.common.inventory.ItemDropContext;

public abstract class SpeciesXenomorph extends SpeciesAlien implements Brainiac<XenomorphBrain> {

    protected XenomorphBrain brain;

    protected SpeciesXenomorph(World world) {
        super(world);
        this.jumpMovementFactor = 0.045F;
    }

    @Override
    public XenomorphBrain getBrain() {
        if (this.brain == null && !this.world.isRemote) {
            this.brain = new XenomorphBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.getBrain().update();
        }

        /* Fall Damage Negation */
        this.fallDistance = 0F;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);

        ItemDropContext itemDropContext = new ItemDropContext(this);
        itemDropContext.drop(AVPItemDrops.XENO_FEET);
        itemDropContext.drop(AVPItemDrops.XENO_HELM);
        itemDropContext.drop(AVPItemDrops.XENO_LEGS);
        itemDropContext.drop(AVPItemDrops.XENO_TORSO);

        if (damageSource == AVPDamageSources.WRISTBRACER) {
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.SKULL_XENO_DRONE, 25);
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.SKULL_XENO_WARRIOR, 25);
        } else {
            itemDropContext.drop(AVPItemDrops.SKULL_XENO_DRONE);
            itemDropContext.drop(AVPItemDrops.SKULL_XENO_WARRIOR);
        }

        int adjustedLevel = this.getJellyLevel() / 4;

        if (!this.jellyLimitOverride) {
            adjustedLevel = Math.min(adjustedLevel, 64);
        }

        itemDropContext.dropWithAmount(AVPItemDrops.ROYAL_JELLY, adjustedLevel);
    }
}
