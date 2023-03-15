package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
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
public class GrowOvipositorBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityMatriarch)) return false;

		EntityMatriarch matriarchEntity = (EntityMatriarch) entity;

		if (matriarchEntity.getJellyLevel() < EntityMatriarch.OVIPOSITOR_UNHEALTHY_THRESHOLD) return false;
		if (matriarchEntity.world.canSeeSky(matriarchEntity.getPosition())) return false;

		return true;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {

		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		// TODO: Gotta do something better than this. Perhaps task profiles/groups are justified now?
		matriarchEntity.getBrain().getTasks()
				.forEach(task -> task.setDisabled(!(task instanceof GrowOvipositorBrainTask) && !(task instanceof MatriarchEnthrallAlienBrainTask)));

		// If the queen does not have a hive, create one.
		if (matriarchEntity.getAlienHive() == null) {
			matriarchEntity.alienHive = matriarchEntity.createNewAlienHive();
		}

		// Grow ovipositor if it is not fully grown.
		if (matriarchEntity.getOvipositorSize() < EntityMatriarch.OVIPOSITOR_THRESHOLD_SIZE)
		{
			matriarchEntity.setOvipositorSize(matriarchEntity.getOvipositorSize() + EntityMatriarch.OVIPOSITOR_PROGRESSIVE_GROWTH_SIZE);
			matriarchEntity.setJellyLevel(matriarchEntity.getJellyLevel() - EntityMatriarch.OVIPOSITOR_JELLYLEVEL_GROWTH_USE);
		}
	}

	@Override
	public void finish(EntityBrainContext ctx) {
		super.finish(ctx);
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();
		matriarchEntity.getBrain().getTasks().forEach(task -> task.setDisabled(false));
	}
}
