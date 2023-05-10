package org.prometheus.common.entity.ai.brain.parasitoid;

import org.alien.common.entity.ai.brain.parasitoid.ParasitoidBrain;
import org.alien.common.entity.ai.brain.task.parasitoid.AttachedToHostBrainTask;
import org.alien.common.entity.ai.brain.task.parasitoid.UpdateInfertileStateBrainTask;
import org.prometheus.common.entity.ai.selector.EntitySelectorTrilobite;
import org.alien.common.entity.living.EntityParasitoid;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;
import org.lib.brain.impl.profile.BrainProfiles;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class TrilobiteBrain extends ParasitoidBrain {
	public TrilobiteBrain(EntityTrilobite entity) {
		super(entity);
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorTrilobite.instance));
	}

	@Override
	public void initTasks() {
		EntityParasitoid entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AttackOnCollideBrainTask(0.800000011920929D));
		this.addTask(new WanderBrainTask(0.800000011920929D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new LeapAtTargetBrainTask(0.85F));
		this.addTask(new NearestAttackableTargetBrainTask());

		// Trilobite/parasite-specific tasks.
		this.addTask(new AttachedToHostBrainTask(), BrainProfiles.PARASITOID_ATTACHED);
		this.addTask(new UpdateInfertileStateBrainTask(), BrainProfiles.PARASITOID_INFERTILE);
	}
}
