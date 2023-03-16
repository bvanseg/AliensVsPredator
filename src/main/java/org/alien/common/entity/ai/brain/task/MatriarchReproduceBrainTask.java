package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
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
public class MatriarchReproduceBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return FLAGS;
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
