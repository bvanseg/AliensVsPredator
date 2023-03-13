package org.alien.common.entity.ai.brain;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.ai.selector.EntitySelectorYautjaMutant;
import org.alien.common.entity.living.EntityYautjaMutant;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class YautjaMutantBrain extends AbstractEntityBrain<EntityYautjaMutant> {
	public YautjaMutantBrain(EntityYautjaMutant entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorYautjaMutant.instance));

		// Brain Tasks
		EntityYautjaMutant entity = this.getEntity();
		this.addTask(new BrainTaskAdapter(new EntityAISwimming(entity)));
		this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, EntityCreature.class, 1.0D, false)));
		this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, EntityPlayer.class, 1.0D, false)));
		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 1.0D)));
		this.addTask(new BrainTaskAdapter(new EntityAIMoveThroughVillage(entity, 1.0D, false)));
		this.addTask(new BrainTaskAdapter(new PatchedEntityAIWander(entity, 1.0D)));
		this.addTask(new BrainTaskAdapter(new EntityAIWatchClosest(entity, EntityPlayer.class, 8.0F)));
		this.addTask(new BrainTaskAdapter(new EntityAILookIdle(entity)));
		this.addTask(new BrainTaskAdapter(new EntityAIHurtByTarget(entity, true)));
		this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityCreature.class, 0, true, false, EntitySelectorYautjaMutant.instance)));
		this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityPlayer.class, 0, true, false, EntitySelectorYautjaMutant.instance)));
	}
}
