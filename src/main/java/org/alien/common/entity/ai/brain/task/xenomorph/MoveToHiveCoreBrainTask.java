package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.Path;
import org.alien.common.world.hive.HiveMember;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class MoveToHiveCoreBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if (!(entity instanceof HiveMember)) return false;

		HiveMember hiveMember = (HiveMember) entity;

		if (hiveMember.getAlienHive() == null) return false;
		if (hiveMember.getAlienHive().isEntityWithinRange(entity)) return false;

		return true;
	}

	@Override
	protected boolean shouldContinueExecuting() {
		return !ctx.getEntity().getNavigator().noPath();
	}

	@Override
	protected void startExecuting() {
		EntityLiving entity = ctx.getEntity();
		HiveMember hiveMember = (HiveMember) entity;

		Path path = entity.getNavigator().getPathToPos(hiveMember.getAlienHive().getCoreBlockPos());

		if (path == null) return;

		entity.getNavigator().setPath(path, 0.8D);
	}
}
