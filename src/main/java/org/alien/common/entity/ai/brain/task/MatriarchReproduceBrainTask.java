package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
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
public class MatriarchReproduceBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityMatriarch)) return false;

		EntityMatriarch matriarchEntity = (EntityMatriarch) entity;

		if (!matriarchEntity.isReproducing()) return false;
		if (matriarchEntity.world.getTotalWorldTime() % (20 * 120) != 0) return false;
		if (matriarchEntity.getJellyLevel() < EntityMatriarch.OVIPOSITOR_UNHEALTHY_THRESHOLD) return false;

		return true;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		int ovipositorDist = 10;
		double rotationYawRadians = Math.toRadians(matriarchEntity.rotationYaw - 90);
		double ovamorphX = (matriarchEntity.posX + (ovipositorDist * (Math.cos(rotationYawRadians))));
		double ovamorphZ = (matriarchEntity.posZ + (ovipositorDist * (Math.sin(rotationYawRadians))));

		EntityOvamorph ovamorph = new EntityOvamorph(matriarchEntity.world);
		ovamorph.setLocationAndAngles(ovamorphX, matriarchEntity.posY, ovamorphZ, 0F, 0F);
		matriarchEntity.world.spawnEntity(ovamorph);
		matriarchEntity.setJellyLevel(matriarchEntity.getJellyLevel() - 100);
	}
}
