package org.alien.common.entity.ai.brain.xenomorph;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.util.SoundCategory;
import org.alien.JellyConstants;
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
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAvoidTargetBrainSensor(1, EntitySelectorChestbursterAvoid.instance));
		this.addSense(new NearestBlockPositionsOfInterestSensor(1, 6, BLOCKS_OF_INTEREST::contains));
	}

	@Override
	public void initTasks() {
		EntityChestburster entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AvoidNearestAvoidTargetBrainTask(8.0F, 0.4F, 0.7F));
		this.addTask(new AttackOnCollideBrainTask(0.800000011920929D));
		this.addTask(new WanderBrainTask(0.800000011920929D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new LeapAtTargetBrainTask(0.8F));

		this.addTask(new FindItemBrainTask(e -> e.getItem().getItem() instanceof ItemFood)
				.onUseItem(entityItem -> {
					ItemFood itemFood = (ItemFood) entityItem.getItem().getItem();
					int foodGain = (int) (JellyConstants.BASE_FOOD_YIELD * itemFood.getSaturationModifier(entityItem.getItem()));
					int jellyGain = (entityItem.getItem().getCount() * foodGain);
					entity.setJellyLevel(entity.getJellyLevel() + jellyGain);
					entity.world.playSound(null, entity.getPosition(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 1F, 1F);
				}));
		this.addTask(new FindItemBrainTask(e -> e.getItem().getItem() == AlienItems.ITEM_ROYAL_JELLY)
				.onUseItem(e -> entity.setJellyLevel(entity.getJellyLevel() + (e.getItem().getCount() * JellyConstants.RAW_YIELD))));

		this.addTask(new AvoidBlockBrainTask(6F, 0.7F, 0.7F, AVOID_BLOCKS::contains));
	}
}
