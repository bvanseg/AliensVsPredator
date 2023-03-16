package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.world.hive.HiveMember;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class MatriarchEnthrallAlienBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
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

		if(!(entity instanceof EntityMatriarch)) return false;

		EntityMatriarch matriarchEntity = (EntityMatriarch) entity;

		if (matriarchEntity.world.getTotalWorldTime() % 20 != 0) return false;
		if (matriarchEntity.getAlienHive() == null) return false;

		return true;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityMatriarch matriarchEntity = (EntityMatriarch) ctx.getEntity();

		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);

		if (livingEntitiesOptional.isPresent()) {
			List<HiveMember> hiveMembers = livingEntitiesOptional.get().stream()
					.filter(HiveMember.class::isInstance)
					.map(e -> (HiveMember) e)
					.collect(Collectors.toList());

			hiveMembers.forEach(hiveMember -> {
				if (hiveMember.getAlienHive() == null) {
					matriarchEntity.getAlienHive().addHiveMember(hiveMember.getHiveMemberID());
				}
			});
		}
	}
}
