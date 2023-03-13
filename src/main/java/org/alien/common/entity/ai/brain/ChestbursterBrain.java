package org.alien.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.*;
import org.alien.common.entity.ai.brain.task.FindJellyBrainTask;
import org.alien.common.entity.ai.brain.task.ShareJellyBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorAvoid;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.entity.living.xenomorph.EntityChestburster;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class ChestbursterBrain extends AbstractEntityBrain<EntityChestburster> {
	public ChestbursterBrain(EntityChestburster entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorParasitoid.instance));

		// Brain Tasks
		EntityChestburster entity = this.getEntity();
		this.addTask(new BrainTaskAdapter(new EntityAISwimming(entity)));
		this.addTask(new BrainTaskAdapter(new EntityAIAvoidEntity<>(entity, EntityLivingBase.class, EntitySelectorAvoid.instance, 8.0F, 0.4F, 0.7F)));
		this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, 0.800000011920929D, true)));
		this.addTask(new BrainTaskAdapter(new PatchedEntityAIWander(entity, 0.800000011920929D)));
		this.addTask(new BrainTaskAdapter(new EntityAIHurtByTarget(entity, true)));
		this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityLivingBase.class, 0, false, false, EntitySelectorParasitoid.instance)));
		this.addTask(new BrainTaskAdapter(new EntityAIAttackMelee(entity, 0.8F, false)));
		this.addTask(new BrainTaskAdapter(new EntityAILeapAtTarget(entity, 0.8F)));
	}
}
