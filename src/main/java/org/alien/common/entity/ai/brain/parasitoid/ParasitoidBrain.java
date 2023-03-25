package org.alien.common.entity.ai.brain.parasitoid;

import org.alien.common.entity.ai.brain.task.parasitoid.AttachedToHostBrainTask;
import org.alien.common.entity.ai.brain.task.parasitoid.UpdateInfertileStateBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.EntityParasitoid;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.profile.BrainProfiles;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class ParasitoidBrain extends AbstractEntityBrain<EntityParasitoid> {
	public ParasitoidBrain(EntityParasitoid entity) {
		super(entity);
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorParasitoid.instance));
	}

	@Override
	public void initTasks() {
		this.addTask(new SwimBrainTask(this.getEntity()));
		this.addTask(new AttackOnCollideBrainTask(0.55D));
		this.addTask(new WanderBrainTask(0.55D));
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new AttachedToHostBrainTask(), BrainProfiles.PARASITOID_ATTACHED);
		this.addTask(new UpdateInfertileStateBrainTask(), BrainProfiles.PARASITOID_INFERTILE);

		this.initParasiteTasks();
	}

	public void initParasiteTasks() {
		this.addTask(new LeapAtTargetBrainTask(0.8F));
	}

	@Override
	public void update() {
		super.update();

		EntityParasitoid entity = this.getEntity();

		if (entity.isAttachedToHost()) {
			this.disableAllProfilesExcept(BrainProfiles.PARASITOID_ATTACHED);
		} else if (!entity.isFertile()) {
			this.disableAllProfilesExcept(BrainProfiles.PARASITOID_INFERTILE);
		}
	}
}
