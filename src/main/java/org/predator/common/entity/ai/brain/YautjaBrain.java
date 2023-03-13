package org.predator.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.task.BrainTaskAdapter;
import org.predator.common.entity.ai.EntityAISuperjump;
import org.predator.common.entity.ai.selector.EntitySelectorYautja;
import org.predator.common.entity.living.SpeciesYautja;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class YautjaBrain extends AbstractEntityBrain<SpeciesYautja> {
	public YautjaBrain(SpeciesYautja entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorYautja.instance));

		// Brain Tasks
		SpeciesYautja entity = this.getEntity();
//      this.tasks.addTask(0, new EntityAISwimming(this));
		this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, EntityLivingBase.class, 0.9D, true)));
		this.addTask(new BrainTaskAdapter(new PatchedEntityAIWander(entity, 0.6D)));
		this.addTask(new BrainTaskAdapter(new EntityAIWatchClosest(entity, EntityLivingBase.class, 16F)));
		this.addTask(new BrainTaskAdapter(new EntityAISuperjump(entity, 1.0F)));
		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsTarget(entity, 0.9D, 48)));
		this.addTask(new BrainTaskAdapter(new EntityAIHurtByTarget(entity, true)));
		this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityLivingBase.class, 0, false, false, EntitySelectorYautja.instance)));
	}
}
