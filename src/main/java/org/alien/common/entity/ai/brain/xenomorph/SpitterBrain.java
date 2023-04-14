package org.alien.common.entity.ai.brain.xenomorph;

import org.alien.common.entity.living.xenomorph.EntitySpitter;
import org.avp.common.entity.ai.brain.task.RangedAttackBrainTask;
import org.lib.brain.impl.task.AttackOnCollideBrainTask;
import org.lib.brain.impl.task.NearestAttackableTargetBrainTask;
import org.lib.brain.profile.BrainProfile;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class SpitterBrain extends XenomorphBrain {

	private static final BrainProfile SPITTER_MELEE = new BrainProfile("spitter_melee");
	private static final BrainProfile SPITTER_RANGED = new BrainProfile("spitter_ranged");

	public SpitterBrain(EntitySpitter entity) {
		super(entity);
	}

	@Override
	public void initCombatTasks() {
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new AttackOnCollideBrainTask(1.0D), SPITTER_MELEE);
		this.addTask(new RangedAttackBrainTask(0.4D, 16, 40), SPITTER_RANGED);
	}

	@Override
	public void update() {
		super.update();

		float rangeThreshold = 64f;

		if(this.getEntity().getAttackTarget() != null)
		{
			if (this.getEntity().getDistanceSq(this.getEntity().getAttackTarget()) <= rangeThreshold) {
				this.enableProfiles(SPITTER_MELEE);
				this.disableProfiles(SPITTER_RANGED);
			} else {
				this.enableProfiles(SPITTER_RANGED);
				this.disableProfiles(SPITTER_MELEE);
			}
		}
	}
}
