package org.avp.util.brain.impl;

import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.alien.EntityAIFindJelly;
import org.avp.entities.ai.alien.EntityAIShareJelly;
import org.avp.entities.ai.alien.EntitySelectorXenomorph;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.util.brain.impl.sensor.EntityBrainSensor;
import org.avp.util.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.avp.util.brain.impl.task.NearestAttackableTargetBrainTask;
import org.avp.util.brain.task.BrainTaskAdapter;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class XenomorphBrain extends AbstractEntityBrain<SpeciesXenomorph> {
	public XenomorphBrain(SpeciesXenomorph entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));
		
		// Brain Tasks
//		this.addTask(new WanderBrainTask(0.8D));
//		this.addTask(new FindJellyBrainTask());
//		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16F));
		this.addTask(new NearestAttackableTargetBrainTask());
//		this.addTask(new AttackOnCollideBrainTask(1.0D));

		SpeciesXenomorph entity = this.getEntity();
		
		// NOTE: These are adapters for the older minecraft AI. The newer AI is commented out above.
        this.addTask(new BrainTaskAdapter(new EntityAISwimming(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAILeapAtTarget(entity, 0.6F)));
        this.addTask(new BrainTaskAdapter(new EntityAIWander(entity, 0.8D)));
        this.addTask(new BrainTaskAdapter(new EntityAIFindJelly(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIShareJelly(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIWatchClosest(entity, EntityLivingBase.class, 16F)));
        this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, EntityLiving.class, 1.0D, false)));
        this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, EntityPlayer.class, 1.0D, false)));
        this.addTask(new BrainTaskAdapter(new EntityAIHurtByTarget(entity, true)));
        this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<EntityLiving>(entity, EntityLiving.class, 0, false, false, EntitySelectorXenomorph.instance)));
        this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<EntityPlayer>(entity, EntityPlayer.class, 0, false, false, EntitySelectorXenomorph.instance)));
	}
}
