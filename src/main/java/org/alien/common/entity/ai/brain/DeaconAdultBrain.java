package org.alien.common.entity.ai.brain;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class DeaconAdultBrain extends AbstractEntityBrain<EntityDeaconAdult> {
	public DeaconAdultBrain(EntityDeaconAdult entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));

		// Brain Tasks
		EntityDeaconAdult entity = this.getEntity();
		this.addTask(new BrainTaskAdapter(new EntityAISwimming(entity)));
		this.addTask(new BrainTaskAdapter(new PatchedEntityAIWander(entity, 0.8D)));
		this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, EntityLiving.class, 1.0D, false)));
		this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, EntityPlayer.class, 1.0D, false)));
		this.addTask(new BrainTaskAdapter(new EntityAIWatchClosest(entity, EntityLivingBase.class, 16F)));
		this.addTask(new BrainTaskAdapter(new EntityAILeapAtTarget(entity, 0.6F)));
		this.addTask(new BrainTaskAdapter(new EntityAIHurtByTarget(entity, true)));
		this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityLiving.class, 0, false, false, EntitySelectorXenomorph.instance)));
		this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityPlayer.class, 0, false, false, EntitySelectorXenomorph.instance)));
	}
}
