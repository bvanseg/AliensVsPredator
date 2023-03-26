package org.alien.common.entity.ai.brain.task.matriarch;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.EnumSkyBlock;
import org.alien.common.entity.ai.brain.task.util.OvipositorHelper;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.profile.BrainProfiles;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class GrowOvipositorBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
	}
	
	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityMatriarch)) return false;

		EntityMatriarch matriarchEntity = (EntityMatriarch) entity;

		if (matriarchEntity.getJellyLevel() < EntityMatriarch.OVIPOSITOR_UNHEALTHY_THRESHOLD) return false;
		if (matriarchEntity.world.canSeeSky(matriarchEntity.getPosition())) return false;
		if (matriarchEntity.world.getLightFor(EnumSkyBlock.SKY, matriarchEntity.getPosition()) > 4) return false;

		// Checks egglaying position and line-of-sight to egglaying position.
		if (!OvipositorHelper.canGrowOvipositor(matriarchEntity)) return false;

		return true;
	}
	
    @Override
	protected void startExecuting() {
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		matriarchEntity.getBrain().disableAllProfilesExcept(BrainProfiles.MATRIARCH_REPRODUCING);

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
	public void finish() {
		super.finish();
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();
		matriarchEntity.setOvipositorSize(0);
		matriarchEntity.getBrain().disableAllProfilesExcept(BrainProfiles.STANDARD);
	}
}
