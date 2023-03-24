package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.xenomorph.EntityDrone;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class RecycleAlienBrainTask<T extends SpeciesAlien> extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private T recycleTarget;

	private final Class<T> targetClass;
	private final Predicate<T> recyclePredicate;

	public RecycleAlienBrainTask(Class<T> targetClass, Predicate<T> recyclePredicate) {
		this.targetClass = targetClass;
		this.recyclePredicate = recyclePredicate;
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
	protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
		return this.recycleTarget != null && !this.recycleTarget.isDead;
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		EntityDrone entityDrone = (EntityDrone) ctx.getEntity();

		if (this.recycleTarget == null) {
			findRecycleTarget(ctx);
		}

		if (this.recycleTarget != null) {
			entityDrone.getNavigator().tryMoveToEntityLiving(this.recycleTarget, entityDrone.getMoveHelper().getSpeed());
		}
	}

	@Override
	protected void continueExecuting(EntityBrainContext ctx) {
		EntityDrone entityDrone = (EntityDrone) ctx.getEntity();
		double distance = entityDrone.getDistanceSq(this.recycleTarget);

		if (distance <= 2)
		{
			entityDrone.setJellyLevel(entityDrone.getJellyLevel() + this.recycleTarget.getJellyLevel());
			this.recycleTarget.setDead();
			this.recycleTarget = null;
		}
	}

	@SuppressWarnings("unchecked")
	private void findRecycleTarget(EntityBrainContext ctx) {
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);
		if (!livingEntitiesOptional.isPresent()) return;

		List<EntityLivingBase> livingEntities = livingEntitiesOptional.get();

		List<T> targets = livingEntities.stream()
				.filter(e -> targetClass.isAssignableFrom(e.getClass()))
				.map(e -> (T) e)
				.collect(Collectors.toList());

		for (T target: targets) {
			if (this.recyclePredicate.test(target))
			{
				this.recycleTarget = target;
				break;
			}
		}
	}
}