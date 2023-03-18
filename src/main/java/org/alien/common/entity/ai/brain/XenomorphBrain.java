package org.alien.common.entity.ai.brain;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import org.alien.common.api.parasitoidic.Maturable;
import org.alien.common.entity.ai.brain.task.xenomorph.FindJellyBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.ProduceJellyBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.ShareJellyBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.common.AVPBlocks;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestBlockPositionsOfInterestSensor;
import org.lib.brain.impl.task.*;

import java.util.Arrays;
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

	private static final HashSet<Block> AVOID_BLOCKS = new HashSet<>();
	private static final HashSet<Block> BLOCKS_OF_INTEREST = new HashSet<>();
	private static final HashSet<Block> DESTROY_BLOCKS = new HashSet<>();

	static  {
		addToSets(Blocks.FIRE, BLOCKS_OF_INTEREST, AVOID_BLOCKS);

		addToSets(Blocks.TORCH, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
		addToSets(Blocks.REDSTONE_TORCH, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
		addToSets(Blocks.LIT_REDSTONE_LAMP, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
		addToSets(Blocks.SEA_LANTERN, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
		addToSets(Blocks.GLOWSTONE, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
		addToSets(AVPBlocks.LIGHT_PANEL, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);

		addToSets(AVPBlocks.POWERLINE, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
		addToSets(Blocks.REDSTONE_WIRE, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
	}

	@SafeVarargs
	private static void addToSets(Block block, HashSet<Block>... sets) {
		Arrays.stream(sets).forEach(set -> set.add(block));
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
		this.addTask(new AvoidBlockBrainTask(3F, 1.0F, 1.0F, AVOID_BLOCKS::contains));
		this.addTask(new DestroyBlockBrainTask(1.0D, DESTROY_BLOCKS::contains));
		this.addTask(new ProduceJellyBrainTask<SpeciesXenomorph>(20, e -> {
			if (e instanceof Maturable) {
				return e.getJellyLevel() >= (((Maturable)e).getMaturityLevel() / 2);
			}
			return true;
		}));
	}

	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));
		this.addSense(new NearestBlockPositionsOfInterestSensor(1, 8, BLOCKS_OF_INTEREST::contains));
	}
}
