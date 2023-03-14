package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.xenomorph.EntityDrone;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
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
public class RecycleSpentOvamorphBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}

	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityDrone)) return false;

		EntityDrone droneEntity = (EntityDrone) entity;

		if (droneEntity.getAlienHive() == null) return false;
		if (droneEntity.world.getTotalWorldTime() % 20 != 0) return false;
		if (droneEntity.getRNG().nextInt(3) != 0) return false;

		return true;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityDrone entityDrone = (EntityDrone) ctx.getEntity();

		if (entityDrone.targetOvamorph == null) {
			findOvamorphTarget(entityDrone, ctx);
			return;
		}

		entityDrone.getNavigator().tryMoveToEntityLiving(entityDrone.targetOvamorph, entityDrone.getMoveHelper().getSpeed());
		double distance = entityDrone.getDistanceSq(entityDrone.targetOvamorph);

		if (distance <= 2)
		{
			entityDrone.setJellyLevel(entityDrone.getJellyLevel() + entityDrone.targetOvamorph.getJellyLevel());
			entityDrone.targetOvamorph.setDead();
			entityDrone.targetOvamorph = null;
		}
	}

	private static void findOvamorphTarget(EntityDrone entityDrone, EntityBrainContext ctx) {
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);
		if (!livingEntitiesOptional.isPresent()) return;

		List<EntityLivingBase> livingEntities = livingEntitiesOptional.get();

		List<EntityOvamorph> ovamorphs = livingEntities.stream()
				.filter(EntityOvamorph.class::isInstance)
				.map(e -> (EntityOvamorph) e)
				.collect(Collectors.toList());

		for (EntityOvamorph ovamorph: ovamorphs) {
			if (!ovamorph.containsFacehugger)
			{
				entityDrone.targetOvamorph = ovamorph;
				break;
			}
		}
	}
}
