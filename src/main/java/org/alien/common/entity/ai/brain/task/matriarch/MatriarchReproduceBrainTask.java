package org.alien.common.entity.ai.brain.task.matriarch;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.Vec3d;
import org.alien.JellyConstants;
import org.alien.common.entity.ai.brain.task.util.OvipositorHelper;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class MatriarchReproduceBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
	}
	
	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityMatriarch)) return false;

		EntityMatriarch matriarchEntity = (EntityMatriarch) entity;

		if (!matriarchEntity.isReproducing()) return false;
		if (matriarchEntity.world.getTotalWorldTime() % (20 * 120) != 0) return false;

		// Checks egglaying position and line-of-sight to egglaying position.
		if (!OvipositorHelper.canGrowOvipositor(matriarchEntity)) return false;

		return true;
	}
	
    @Override
	protected void startExecuting() {
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		Vec3d ovamorphPosition = OvipositorHelper.getEggLayingPosition(matriarchEntity);

		EntityOvamorph ovamorph = new EntityOvamorph(matriarchEntity.world);
		ovamorph.setLocationAndAngles(ovamorphPosition.x, ovamorphPosition.y, ovamorphPosition.z, 0F, 0F);
		matriarchEntity.world.spawnEntity(ovamorph);
		matriarchEntity.jellyLevel.add(-JellyConstants.EGG_LAY_COST);
	}
}
