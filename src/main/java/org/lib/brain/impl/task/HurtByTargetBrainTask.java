package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLiving;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class HurtByTargetBrainTask extends AbstractBrainTask<EntityBrainContext> {

    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();

    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
		return new HashMap<>();
    }

    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();
		return entity.getRevengeTarget() != null;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		ctx.getBrain().remember(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET, ctx.getEntity().getRevengeTarget());
	}
}
