package org.alien.common.entity.ai.brain.xenomorph;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigateGround;
import org.alien.JellyConstants;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.AlienBrain;
import org.alien.common.entity.ai.brain.task.FindItemBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.ShareJellyBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.common.block.init.AVPTileEntityBlocks;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestBlockPositionsOfInterestSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class XenomorphBrain extends AlienBrain<SpeciesXenomorph> {
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
		addToSets(AVPTileEntityBlocks.LIGHT_PANEL, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);

		addToSets(AVPTileEntityBlocks.POWERLINE, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
		addToSets(Blocks.REDSTONE_WIRE, BLOCKS_OF_INTEREST, DESTROY_BLOCKS);
	}

	@SafeVarargs
	private static void addToSets(Block block, HashSet<Block>... sets) {
		Arrays.stream(sets).forEach(set -> set.add(block));
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));
		this.addSense(new NearestBlockPositionsOfInterestSensor(1, 8, BLOCKS_OF_INTEREST::contains));
	}

	@Override
	public void initTasks() {
		// Adds jelly producing tasks and other shared alien behaviors.
		super.initTasks();

		SpeciesXenomorph entity = this.getEntity();
		this.addTask(new SwimBrainTask(this.getEntity()));
		this.addTask(new LeapAtTargetBrainTask(0.6F));
		this.addTask(new WanderBrainTask(0.8D));
		this.addTask(new FindItemBrainTask(e -> e.getItem().getItem() == AlienItems.ITEM_ROYAL_JELLY)
				.onUseItem(e -> entity.setJellyLevel(entity.getJellyLevel() + (e.getItem().getCount() * JellyConstants.RAW_YIELD))));
		this.addTask(new ShareJellyBrainTask());
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16F));

		this.initCombatTasks();

		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new AvoidBlockBrainTask(3F, 1.0F, 1.0F, AVOID_BLOCKS::contains));
		this.addTask(new DestroyBlockBrainTask(1.0D, DESTROY_BLOCKS::contains));

		if (this.getEntity().getNavigator() instanceof PathNavigateGround) {
			((PathNavigateGround)this.getEntity().getNavigator()).setBreakDoors(true);
			// TODO: Make this more flexible as a brain task.
			this.addTask(new BrainTaskAdapter(new EntityAIBreakDoor(this.getEntity())));
		}
	}

	public void initCombatTasks() {
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new AttackOnCollideBrainTask(1.0D));
	}
}
