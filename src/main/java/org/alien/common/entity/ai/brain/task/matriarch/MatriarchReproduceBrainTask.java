package org.alien.common.entity.ai.brain.task.matriarch;

import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityMatriarch)) return false;

		EntityMatriarch matriarchEntity = (EntityMatriarch) entity;

		if (!matriarchEntity.isReproducing()) return false;
		if (matriarchEntity.world.getTotalWorldTime() % (20 * 120) != 0) return false;
		if (matriarchEntity.getJellyLevel() < EntityMatriarch.OVIPOSITOR_UNHEALTHY_THRESHOLD) return false;

		// Make sure that the position the queen is laying an egg at is not in a wall.
		Vec3d eggLayingPosition = this.getEggLayingPosition(ctx);
		BlockPos pos = new BlockPos(eggLayingPosition.x, eggLayingPosition.y, eggLayingPosition.z);
		if (ctx.getEntity().world.getBlockState(pos) != Blocks.AIR.getDefaultState()) return false;

		return true;
	}
	
    @Override
	protected void startExecuting() {
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		Vec3d ovamorphPosition = this.getEggLayingPosition(ctx);

		EntityOvamorph ovamorph = new EntityOvamorph(matriarchEntity.world);
		ovamorph.setLocationAndAngles(ovamorphPosition.x, ovamorphPosition.y, ovamorphPosition.z, 0F, 0F);
		matriarchEntity.world.spawnEntity(ovamorph);
		matriarchEntity.setJellyLevel(matriarchEntity.getJellyLevel() - 100);
	}

	private Vec3d getEggLayingPosition(EntityBrainContext ctx) {
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		int ovipositorDist = 10;
		double rotationYawRadians = Math.toRadians(matriarchEntity.rotationYaw - 90);
		double ovamorphX = (matriarchEntity.posX + (ovipositorDist * (Math.cos(rotationYawRadians))));
		double ovamorphZ = (matriarchEntity.posZ + (ovipositorDist * (Math.sin(rotationYawRadians))));

		return new Vec3d(ovamorphX, matriarchEntity.posY, ovamorphZ);
	}
}
