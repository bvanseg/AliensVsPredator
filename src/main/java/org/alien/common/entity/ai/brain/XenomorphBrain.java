package org.alien.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import org.alien.common.entity.ai.brain.task.xenomorph.FindJellyBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.ShareJellyBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestBlockPositionsOfInterestSensor;
import org.lib.brain.impl.task.*;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class XenomorphBrain extends AbstractEntityBrain<SpeciesXenomorph> {
	public XenomorphBrain(SpeciesXenomorph entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.initSenses();

		// Brain Tasks
		this.addTask(new SwimBrainTask(this.getEntity()));
		this.addTask(new LeapAtTargetBrainTask(0.6F));
		this.addTask(new WanderBrainTask(0.8D));
		this.addTask(new FindJellyBrainTask());
		this.addTask(new ShareJellyBrainTask());
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16F));
		this.addTask(new AttackOnCollideBrainTask(1.0D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());
		// TODO: Add predicate and generify to "AvoidBlockBrainTask"
		this.addTask(new AvoidFireBrainTask(3F, 1.0F, 1.0F));
	}

	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));
		// TODO: Use a hash set instead of a long condition chain.
		this.addSense(new NearestBlockPositionsOfInterestSensor(1, 8, block ->
				// Dangers
				block == Blocks.FIRE ||
				// Light sources
				block == Blocks.TORCH || block == Blocks.REDSTONE_TORCH || block == Blocks.LIT_REDSTONE_LAMP ||
				block == Blocks.SEA_LANTERN || block == Blocks.GLOWSTONE
				// TODO: Power carriers
		));
	}
}
