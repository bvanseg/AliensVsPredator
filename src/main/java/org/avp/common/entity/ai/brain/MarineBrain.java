package org.avp.common.entity.ai.brain;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.avp.common.entity.ai.selector.EntitySelectorMarine;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.item.firearm.FirearmProfile;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.NearestAttackableTargetBrainTask;
import org.lib.brain.impl.task.WanderBrainTask;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * @author Boston Vanseghi
 */
public class MarineBrain extends AbstractEntityBrain<EntityMarine> {

    public MarineBrain(EntityMarine entity) {
        super(entity);
    }

    @Override
    public void init() {
        super.init();

        // Senses
        this.addSense(new EntityBrainSensor(1));
        this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorMarine.instance));

        // Tasks
        EntityMarine entity = this.getEntity();
        this.addTask(new NearestAttackableTargetBrainTask());
        this.addTask(new BrainTaskAdapter(new EntityAISwimming(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIAttackRanged(entity, 0.4D, getAttackDelayBasedOnFirearm(), 24)));
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
        this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityLivingBase.class, 0, true, false, EntitySelectorMarine.instance)));
    }

    private int getAttackDelayBasedOnFirearm() {
        FirearmProfile firearmProfile = this.getEntity().getMarineType().getFirearmItem().getProfile();
        double rpm = firearmProfile.getRoundsPerMinute();
        double rps = rpm / 60; // Rounds per second
        double rpt = rps / 20; // Rounds per tick
        return (int) (1 / rpt); // How many ticks (x) must the entity wait until they can fire once (1 = rpt * x)
    }
}
