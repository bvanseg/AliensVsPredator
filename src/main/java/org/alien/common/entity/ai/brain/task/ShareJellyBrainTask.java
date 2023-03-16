package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.world.hive.HiveMember;
import org.alien.common.world.hive.HiveOwner;
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
public class ShareJellyBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return FLAGS;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		if (!(entity instanceof SpeciesXenomorph) || !(entity instanceof HiveMember) || entity instanceof EntityMatriarch) {
			return false;
		}

		SpeciesXenomorph xenomorph = (SpeciesXenomorph)entity;
		HiveMember hiveMember = (HiveMember) entity;

		return xenomorph.getJellyLevel() > 0 && hiveMember.getAlienHive() != null && xenomorph.getAttackTarget() == null;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();
		SpeciesXenomorph xenomorph = (SpeciesXenomorph)entity;
		HiveMember hiveMember = (HiveMember) xenomorph;
		HiveOwner hiveOwner = hiveMember.getAlienHive().getHiveOwner();

		if (hiveOwner instanceof EntityMatriarch) {
			EntityMatriarch queen = (EntityMatriarch) hiveOwner;

			if (queen.getOvipositorSize() < EntityMatriarch.OVIPOSITOR_THRESHOLD_SIZE || queen.isReproducing())
			{
				if (queen.getJellyLevel() < EntityMatriarch.OVIPOSITOR_JELLYLEVEL_THRESHOLD * 2 && xenomorph.getJellyLevel() >= 80)
				{
					queen.setJellyLevel(queen.getJellyLevel() + xenomorph.getJellyLevel());
					xenomorph.setJellyLevel(0);
				}
			}
		}
	}
}
