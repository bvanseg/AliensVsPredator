package org.alien.common.entity.ai.brain;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.task.FindItemBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorChestbursterAvoid;
import org.alien.common.entity.living.xenomorph.EntityChestburster;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAvoidTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestBlockPositionsOfInterestSensor;
import org.lib.brain.impl.task.*;

import java.util.HashSet;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class ChestbursterBrain extends AbstractEntityBrain<EntityChestburster> {
	public ChestbursterBrain(EntityChestburster entity) {
		super(entity);
	}

	private static final HashSet<Block> AVOID_BLOCKS = new HashSet<>();
	private static final HashSet<Block> BLOCKS_OF_INTEREST = new HashSet<>();

	static  {
		BLOCKS_OF_INTEREST.add(Blocks.FIRE);
		AVOID_BLOCKS.add(Blocks.FIRE);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAvoidTargetBrainSensor(1, EntitySelectorChestbursterAvoid.instance));
		this.addSense(new NearestBlockPositionsOfInterestSensor(1, 6, BLOCKS_OF_INTEREST::contains));

		// Brain Tasks
		EntityChestburster entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AvoidNearestAvoidTargetBrainTask(8.0F, 0.4F, 0.7F));
		this.addTask(new AttackOnCollideBrainTask(0.800000011920929D));
		this.addTask(new WanderBrainTask(0.800000011920929D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new LeapAtTargetBrainTask(0.8F));
		this.addTask(new FindItemBrainTask(50, e -> e.getItem().getItem() instanceof ItemFood));
		this.addTask(new FindItemBrainTask(100, e -> e.getItem().getItem() == AlienItems.ITEM_ROYAL_JELLY));
		this.addTask(new AvoidBlockBrainTask(6F, 0.7F, 0.7F, AVOID_BLOCKS::contains));
	}
}
