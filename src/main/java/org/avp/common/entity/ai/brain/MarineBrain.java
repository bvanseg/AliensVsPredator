package org.avp.common.entity.ai.brain;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.ai.brain.task.FindItemBrainTask;
import org.avp.common.entity.EntityGrenade;
import org.avp.common.entity.ai.brain.task.EatFoodBrainTask;
import org.avp.common.entity.ai.brain.task.FollowSquadLeaderBrainTask;
import org.avp.common.entity.ai.selector.EntitySelectorMarine;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.item.firearm.FirearmProfile;
import org.avp.common.item.firearm.ItemAmmunition;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestAvoidTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestBlockPositionsOfInterestSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * @author Boston Vanseghi
 */
public class MarineBrain extends AbstractEntityBrain<EntityMarine> {

    private static final HashSet<Block> AVOID_BLOCKS = new HashSet<>();
    private static final HashSet<Block> BLOCKS_OF_INTEREST = new HashSet<>();

    static {
        addToSets(Blocks.FIRE, BLOCKS_OF_INTEREST, AVOID_BLOCKS);
    }

    @SafeVarargs
    private static void addToSets(Block block, HashSet<Block>... sets) {
        Arrays.stream(sets).forEach(set -> set.add(block));
    }

    private static final Predicate<EntityItem> ITEM_PICKUP_PREDICATE = (entityItem) -> {
        if (entityItem.getItem().getItem() instanceof ItemFood) return true; // Marines can pick up food.
        if (entityItem.getItem().getItem() instanceof ItemAmmunition) return true; // Marines can pick up ammunition.
        if (entityItem.getItem().getItem() == Item.getItemFromBlock(Blocks.TORCH)) return true; // Marines can pick up torches.

        return false;
    };

    public MarineBrain(EntityMarine entity) {
        super(entity);
    }

    @Override
    public void initSenses() {
        this.addSense(new EntityBrainSensor(1));
        this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorMarine.instance));
        this.addSense(new NearestBlockPositionsOfInterestSensor(1, 8, BLOCKS_OF_INTEREST::contains));
        this.addSense(new NearestAvoidTargetBrainSensor(1, e -> e instanceof EntityAcidPool || e instanceof EntityGrenade || e instanceof EntityTNTPrimed));
    }

    @Override
    public void initTasks() {
        EntityMarine entity = this.getEntity();
        this.addTask(new NearestAttackableTargetBrainTask());
        this.addTask(new SwimBrainTask(entity));
        // TODO:
        this.addTask(new BrainTaskAdapter(new EntityAIAttackRanged(entity, 0.4D, getAttackDelayBasedOnFirearm(), 24)));
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

        this.addTask(new AvoidBlockBrainTask(3F, 0.6F, 0.6F, AVOID_BLOCKS::contains));

        this.addTask(new FollowSquadLeaderBrainTask(0.6D, 10.0F, 2.0F));

        this.addTask(new FindItemBrainTask(ITEM_PICKUP_PREDICATE, 0.6D)
                .onUseItem(entityItem -> this.getEntity().getInventory().addItem(entityItem.getItem())));

        this.addTask(new EatFoodBrainTask());
    }

    private int getAttackDelayBasedOnFirearm() {
        FirearmProfile firearmProfile = this.getEntity().getMarineType().getFirearmItem().getFirearmProfile();
        double rpm = firearmProfile.getRoundsPerMinute();
        double rps = rpm / 60; // Rounds per second
        double rpt = rps / 20; // Rounds per tick
        return (int) (1 / rpt); // How many ticks (x) must the entity wait until they can fire once (1 = rpt * x)
    }
}
