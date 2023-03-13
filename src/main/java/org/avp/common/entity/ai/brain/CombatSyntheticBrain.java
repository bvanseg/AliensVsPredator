package org.avp.common.entity.ai.brain;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import org.avp.common.entity.ai.selector.EntitySelectorCombatSynthetic;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.NearestAttackableTargetBrainTask;
import org.lib.brain.impl.task.WanderBrainTask;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * @author Boston Vanseghi
 */
public class CombatSyntheticBrain extends AbstractEntityBrain<EntityCombatSynthetic> {

    public CombatSyntheticBrain(EntityCombatSynthetic entity) {
        super(entity);
    }

    @Override
    public void init() {
        super.init();

        // Senses
        this.addSense(new EntityBrainSensor(1));
        this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorCombatSynthetic.instance));

        // Tasks
        EntityCombatSynthetic entity = this.getEntity();
        this.addTask(new NearestAttackableTargetBrainTask());
        this.addTask(new BrainTaskAdapter(new EntityAISwimming(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIAttackRanged(entity, 0.4D, 20, 24)));
        this.addTask(new BrainTaskAdapter(new EntityAIAvoidEntity<>(entity, EntityZombie.class, 8.0F, 0.6D, 0.6D)));
        this.addTask(new BrainTaskAdapter(new EntityAIMoveIndoors(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIRestrictOpenDoor(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIOpenDoor(entity, true)));
        this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 0.6D)));
        this.addTask(new BrainTaskAdapter(new EntityAIWatchClosest2(entity, EntityPlayer.class, 3.0F, 1.0F)));
        this.addTask(new WanderBrainTask( 0.6D));
        this.addTask(new BrainTaskAdapter(new EntityAIWatchClosest(entity, EntityLiving.class, 8.0F)));
        this.addTask(new BrainTaskAdapter(new EntityAIMoveIndoors(entity)));

        this.addTask(new BrainTaskAdapter(new EntityAIOpenDoor(entity, true)));
        this.addTask(new BrainTaskAdapter(new EntityAIHurtByTarget(entity, true)));
        this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityLivingBase.class, 0, true, false, EntitySelectorCombatSynthetic.instance)));
    }
}
