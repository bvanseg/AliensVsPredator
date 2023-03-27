package org.alien.common.entity.ai.brain.task.matriarch;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumSkyBlock;
import org.alien.common.entity.ai.brain.task.util.OvipositorHelper;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
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
public class FindEgglayingPositionBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.LOOK, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
		map.put(BrainFlags.LOOK, BrainFlagState.PRESENT);
	}

	private Float targetAngle;

	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityMatriarch)) return false;

		EntityMatriarch matriarchEntity = (EntityMatriarch) entity;

		// Do not look for an egglaying position if the matriarch already has an ovipositor.
		if (matriarchEntity.getOvipositorSize() > 0) return false;

		if (matriarchEntity.getJellyLevel() < EntityMatriarch.OVIPOSITOR_UNHEALTHY_THRESHOLD) return false;
		if (matriarchEntity.world.canSeeSky(matriarchEntity.getPosition())) return false;
		if (matriarchEntity.world.getLightFor(EnumSkyBlock.SKY, matriarchEntity.getPosition()) > 4) return false;
//		if (matriarchEntity.world.getTotalWorldTime() % 20 * 5 != 0) return false;
		if (this.targetAngle != null && this.targetAngle == entity.rotationYawHead) return false;

		return true;
	}
	
    @Override
	protected void startExecuting() {
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		int ovipositorLength = OvipositorHelper.getOvipositorLength(matriarchEntity);
		Float eggAngle = OvipositorHelper.findEggPositionAngleAround(matriarchEntity, ovipositorLength);

		if (eggAngle != null) {
			this.targetAngle = eggAngle - 180;
			Vec3d lookPosition = OvipositorHelper.getPositionAround(matriarchEntity, ovipositorLength, this.targetAngle);

			matriarchEntity.getLookHelper().setLookPosition(
					lookPosition.x, lookPosition.y, lookPosition.z,
					matriarchEntity.getHorizontalFaceSpeed(),
					matriarchEntity.getVerticalFaceSpeed()
			);
			System.out.println(matriarchEntity.rotationYawHead);
		}
	}

	@Override
	public void finish() {
		super.finish();
		this.targetAngle = null;
	}
}
