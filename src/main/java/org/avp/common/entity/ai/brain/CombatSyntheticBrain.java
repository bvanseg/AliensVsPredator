package org.avp.common.entity.ai.brain;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.EntityAcidPool;
import org.avp.common.entity.ai.selector.EntitySelectorCombatSynthetic;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestAvoidTargetBrainSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;
import org.weapon.common.entity.EntityGrenade;

/**
 * @author Boston Vanseghi
 */
public class CombatSyntheticBrain extends AbstractEntityBrain<EntityCombatSynthetic> {

    public CombatSyntheticBrain(EntityCombatSynthetic entity) {
        super(entity);
    }

    @Override
    public void initSenses() {
        this.addSense(new EntityBrainSensor(1));
        this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorCombatSynthetic.instance));
        this.addSense(new NearestAvoidTargetBrainSensor(1, e -> e instanceof EntityAcidPool || e instanceof EntityGrenade || e instanceof EntityTNTPrimed));
    }

    @Override
    public void initTasks() {
        EntityCombatSynthetic entity = this.getEntity();
        this.addTask(new NearestAttackableTargetBrainTask());
        this.addTask(new SwimBrainTask(entity));
        // TODO:
        this.addTask(new BrainTaskAdapter(new EntityAIAttackRanged(entity, 0.4D, 20, 24)));
        this.addTask(new BrainTaskAdapter(new EntityAIAvoidEntity<>(entity, EntityZombie.class, 8.0F, 0.6D, 0.6D)));
        this.addTask(new BrainTaskAdapter(new EntityAIMoveIndoors(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIRestrictOpenDoor(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIOpenDoor(entity, true)));
        this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 0.6D)));

        this.addTask(new WanderBrainTask( 0.6D));
        this.addTask(new WatchClosestBrainTask(EntityPlayer.class, 3.0F));
        this.addTask(new WatchClosestBrainTask(EntityLiving.class, 8.0F));
        // TODO:
        this.addTask(new BrainTaskAdapter(new EntityAIMoveIndoors(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIOpenDoor(entity, true)));

        this.addTask(new HurtByTargetBrainTask());
        this.addTask(new NearestAttackableTargetBrainTask());
        this.addTask(new AvoidNearestAvoidTargetBrainTask(0.6F, 0.6F, e -> {
            if (e instanceof EntityAcidPool)
                return 3.0F;
            if (e instanceof EntityTNTPrimed)
                return 8.0F;

            return 5.0F;
        }));
    }
}
