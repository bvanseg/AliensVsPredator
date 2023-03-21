package org.alien.common.entity.ai.brain;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.vardic.EntityDeaconShark;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;
import org.lib.common.predicate.EntitySelectorBase;

import java.util.function.Predicate;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class DeaconSharkBrain extends AbstractEntityBrain<EntityDeaconShark> {
	public DeaconSharkBrain(EntityDeaconShark entity) {
		super(entity);
	}

	private final Predicate<Entity> entitySelector = target -> {
		if (!EntitySelectorBase.instance.test(target)) return false;
		return !(target instanceof EntityDeaconShark) && DeaconSharkBrain.this.getEntity().canEntityBeSeen(target);
	};

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, entitySelector));
	}

	@Override
	public void initTasks() {
		EntityDeaconShark entity = this.getEntity();
		this.addTask(new AttackOnCollideBrainTask(0.8D));
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 1.0D)));

		this.addTask(new WanderBrainTask(1.0D));
		this.addTask(new WatchClosestBrainTask(EntityPlayer.class, 8.0F));
		this.addTask(new WatchClosestBrainTask(EntityDeaconShark.class, 12.0F, 0.01F));
		this.addTask(new LookIdleBrainTask());
//        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, Entity.class, 10, true, false, entitySelector));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new LeapAtTargetBrainTask(0.4F));
	}
}
