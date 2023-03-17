package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.xenomorph.EntityDrone;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class RecycleSpentOvamorphBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private EntityOvamorph targetOvamorph;

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
	protected void startExecuting(EntityBrainContext ctx) {
		EntityDrone entityDrone = (EntityDrone) ctx.getEntity();

		if (this.targetOvamorph == null) {
			findOvamorphTarget(ctx);
			return;
		}

		entityDrone.getNavigator().tryMoveToEntityLiving(this.targetOvamorph, entityDrone.getMoveHelper().getSpeed());
	}

	@Override
	protected void continueExecuting(EntityBrainContext ctx) {
		EntityDrone entityDrone = (EntityDrone) ctx.getEntity();
		double distance = entityDrone.getDistanceSq(this.targetOvamorph);

		if (distance <= 2)
		{
			entityDrone.setJellyLevel(entityDrone.getJellyLevel() + this.targetOvamorph.getJellyLevel());
			this.targetOvamorph.setDead();
			this.targetOvamorph = null;
		}
	}

	private void findOvamorphTarget(EntityBrainContext ctx) {
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);
		if (!livingEntitiesOptional.isPresent()) return;

		List<EntityLivingBase> livingEntities = livingEntitiesOptional.get();

		List<EntityOvamorph> ovamorphs = livingEntities.stream()
				.filter(EntityOvamorph.class::isInstance)
				.map(e -> (EntityOvamorph) e)
				.collect(Collectors.toList());

		for (EntityOvamorph ovamorph: ovamorphs) {
			if (!ovamorph.containsFacehugger())
			{
				this.targetOvamorph = ovamorph;
				break;
			}
		}
	}
}
