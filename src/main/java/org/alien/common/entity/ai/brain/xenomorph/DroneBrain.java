package org.alien.common.entity.ai.brain.xenomorph;

import net.minecraft.entity.EntityLiving;
import org.alien.common.entity.ai.brain.task.xenomorph.*;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.world.hive.HiveMember;
import org.lib.brain.impl.profile.BrainProfiles;
import org.lib.brain.profile.BrainProfile;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class DroneBrain extends XenomorphBrain {
	public DroneBrain(SpeciesXenomorph entity) {
		super(entity);
	}

	private static final BrainProfile HIVE_WORKER = new BrainProfile("hive");

	@Override
	public void initTasks() {
		super.initTasks();
		this.addTask(new RecycleAlienBrainTask<>(EntityOvamorph.class, ovamorph -> !ovamorph.containsFacehugger()));
		this.addTask(new RecycleAlienBrainTask<>(EntityFacehugger.class, facehugger -> !facehugger.isFertile() && !facehugger.isAttachedToHost()));

		this.addTask(new BuildHiveBrainTask(), BrainProfiles.STANDARD, HIVE_WORKER);
		this.addTask(new MoveToHiveCoreBrainTask(), BrainProfiles.STANDARD, HIVE_WORKER);

		this.addTask(new PickUpNearestEggBrainTask(), BrainProfiles.STANDARD, HIVE_WORKER);
		this.addTask(new MoveEggBrainTask(), BrainProfiles.STANDARD, HIVE_WORKER);
	}

	@Override
	public void update() {
		super.update();

		EntityLiving entity = this.getEntity();
		if (entity instanceof HiveMember && ((HiveMember) entity).getAlienHive() != null) {
			this.enableProfiles(HIVE_WORKER);
		} else {
			this.disableProfiles(HIVE_WORKER);
		}
	}
}
