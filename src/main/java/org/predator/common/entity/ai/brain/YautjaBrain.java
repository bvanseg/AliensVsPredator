package org.predator.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import org.alien.common.entity.EntityAcidPool;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestAvoidTargetBrainSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;
import org.predator.common.entity.ai.EntityAISuperjump;
import org.predator.common.entity.ai.selector.EntitySelectorYautja;
import org.predator.common.entity.living.SpeciesYautja;
import org.weapon.common.entity.EntityGrenade;

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
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorYautja.instance));
		this.addSense(new NearestAvoidTargetBrainSensor(1, e -> e instanceof EntityAcidPool || e instanceof EntityGrenade || e instanceof EntityTNTPrimed));
	}

	@Override
	public void initTasks() {
		SpeciesYautja entity = this.getEntity();
//      this.tasks.addTask(0, new EntityAISwimming(this));
		this.addTask(new AttackOnCollideBrainTask(0.9D));
		this.addTask(new WanderBrainTask(0.6D));
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16F));
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAISuperjump(entity, 1.0F)));

//		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsTarget(entity, 0.9D, 48)));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new AvoidNearestAvoidTargetBrainTask(0.6F, 0.6F, e -> {
			if (e instanceof EntityAcidPool)
				return 3.0F;
			if (e instanceof EntityTNTPrimed)
				return 8.0F;

			return 5.0F;
		}));
	}
}
