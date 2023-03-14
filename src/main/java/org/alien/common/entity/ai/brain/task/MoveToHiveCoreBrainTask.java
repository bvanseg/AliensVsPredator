package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.Path;
import org.alien.common.world.hive.HiveMember;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class MoveToHiveCoreBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		if (!(entity instanceof HiveMember)) return false;

		HiveMember hiveMember = (HiveMember) entity;

		if (hiveMember.getAlienHive() == null) return false;
		if (hiveMember.getAlienHive().isEntityWithinRange(entity)) return false;

		return true;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();
		HiveMember hiveMember = (HiveMember) entity;

		Path path = entity.getNavigator().getPathToPos(hiveMember.getAlienHive().getCoreBlockPos());

		if (path == null) return;

		entity.getNavigator().setPath(path, 0.8D);
	}
}
