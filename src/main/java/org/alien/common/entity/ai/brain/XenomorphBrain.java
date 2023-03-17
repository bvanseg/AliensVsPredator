package org.alien.common.entity.ai.brain;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import org.alien.common.entity.ai.brain.task.xenomorph.FindJellyBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.ShareJellyBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.common.AVPBlocks;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestBlockPositionsOfInterestSensor;
import org.lib.brain.impl.task.*;

import java.util.HashSet;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class XenomorphBrain extends AbstractEntityBrain<SpeciesXenomorph> {
	public XenomorphBrain(SpeciesXenomorph entity) {
		super(entity);
	}

	private static final HashSet<Block> BLOCKS_OF_INTEREST = new HashSet<>();

	static  {
		BLOCKS_OF_INTEREST.add(Blocks.FIRE);

		BLOCKS_OF_INTEREST.add(Blocks.TORCH);
		BLOCKS_OF_INTEREST.add(Blocks.REDSTONE_TORCH);
		BLOCKS_OF_INTEREST.add(Blocks.LIT_REDSTONE_LAMP);
		BLOCKS_OF_INTEREST.add(Blocks.SEA_LANTERN);
		BLOCKS_OF_INTEREST.add(Blocks.GLOWSTONE);

		BLOCKS_OF_INTEREST.add(AVPBlocks.POWERLINE);
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
		this.addTask(new AvoidBlockBrainTask(3F, 1.0F, 1.0F, block -> block == Blocks.FIRE));
	}

	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));
		this.addSense(new NearestBlockPositionsOfInterestSensor(1, 8, BLOCKS_OF_INTEREST::contains));
	}
}
