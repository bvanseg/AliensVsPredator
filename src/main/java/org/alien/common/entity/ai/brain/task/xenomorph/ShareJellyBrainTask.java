package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.entity.EntityLiving;
import org.alien.JellyConstants;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.world.hive.HiveMember;
import org.alien.common.world.hive.HiveOwner;
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
public class ShareJellyBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
	}
	
	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if (!(entity instanceof SpeciesXenomorph) || entity instanceof EntityMatriarch) {
			return false;
		}

		SpeciesXenomorph xenomorph = (SpeciesXenomorph)entity;
		HiveMember hiveMember = (HiveMember) entity;

		return xenomorph.getJellyLevel() > 0 && hiveMember.getAlienHive() != null && xenomorph.getAttackTarget() == null;
	}
	
    @Override
	protected void startExecuting() {
		EntityLiving entity = ctx.getEntity();
		SpeciesXenomorph xenomorph = (SpeciesXenomorph)entity;
		HiveOwner hiveOwner = xenomorph.getAlienHive().getHiveOwner();

		if (hiveOwner instanceof EntityMatriarch) {
			EntityMatriarch queen = (EntityMatriarch) hiveOwner;

			if (queen.getOvipositorSize() < EntityMatriarch.OVIPOSITOR_THRESHOLD_SIZE || queen.isReproducing())
			{
				if (queen.getJellyLevel() < JellyConstants.OVIPOSITOR_THRESHOLD * 2 && xenomorph.getJellyLevel() >= JellyConstants.DRONE_SHARE_THRESHOLD)
				{
					queen.setJellyLevel(queen.getJellyLevel() + xenomorph.getJellyLevel());
					xenomorph.setJellyLevel(0);
				}
			}
		}
	}
}
