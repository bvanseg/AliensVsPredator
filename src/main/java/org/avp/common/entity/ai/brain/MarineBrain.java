package org.avp.common.entity.ai.brain;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.ai.brain.task.FindItemBrainTask;
import org.avp.common.AVPNetworking;
import org.avp.common.entity.ai.brain.task.*;
import org.avp.common.entity.ai.selector.EntitySelectorMarine;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.network.packet.client.PacketSyncEntityInventory;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestAvoidTargetBrainSensor;
import org.lib.brain.impl.sensor.NearestBlockPositionsOfInterestSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.profile.BrainProfile;
import org.lib.brain.task.BrainTaskAdapter;
import org.weapon.common.entity.EntityGrenade;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * @author Boston Vanseghi
 */
public class MarineBrain extends AbstractEntityBrain<EntityMarine> {

    // Lone wolf behavior for when the marine has no squad leader (and therefore no squad).
    private static final BrainProfile WOLF_BEHAVIOR = new BrainProfile("wolf_behavior");

    // Squad behavior for when the marine has a squad leader and a squad.
    private static final BrainProfile SQUAD_BEHAVIOR = new BrainProfile("squad_behavior");

    // Behavior for marines following squad leaders.
    private static final BrainProfile LEADER_FOLLOW_BEHAVIOR = new BrainProfile("leader_follow_behavior");

    private static final HashSet<Block> AVOID_BLOCKS = new HashSet<>();
    private static final HashSet<Block> BLOCKS_OF_INTEREST = new HashSet<>();

    static {
        addToSets(Blocks.FIRE, BLOCKS_OF_INTEREST, AVOID_BLOCKS);
    }

    @SafeVarargs
    private static void addToSets(Block block, HashSet<Block>... sets) {
        Arrays.stream(sets).forEach(set -> set.add(block));
    }

    public final Predicate<EntityItem> itemPickupPredicate = entityItem -> {
        Item item = entityItem.getItem().getItem();
        return this.itemPredicate.test(item);
    };

    public final Predicate<Item> itemPredicate = item -> {
        if (item instanceof ItemFood) return true; // Marines can pick up food.
        if (this.getEntity()
                .getMarineType().getFirearmItem()
                .getFirearmProperties().getConsumablesForReload().contains(item)) return true; // Marines can pick up ammunition.
        if (item == Item.getItemFromBlock(Blocks.TORCH)) return true; // Marines can pick up torches.

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
        this.addSense(new NearestAvoidTargetBrainSensor(1, e ->
                e instanceof EntityAcidPool ||
                e instanceof EntityGrenade ||
                e instanceof EntityTNTPrimed ||
                (!this.getEntity().hasLoadedAmmunition() && EntitySelectorMarine.instance.test(e)) || // Avoid target if no ammo.
                this.getEntity().getDistanceSq(e) < 4 && EntitySelectorMarine.instance.test(e) // Avoid target if too close
        ));
    }

    @Override
    public void initTasks() {
        EntityMarine entity = this.getEntity();

        this.addTask(new SwimBrainTask(entity));
        this.addTask(new MarineReloadTask());

        this.initNavigationTasks(entity);
        this.initIdleTasks();
        this.initCombatTasks();
        this.initInventoryTasks();
    }

    private void initInventoryTasks() {
        this.addTask(new FindItemBrainTask(this.itemPickupPredicate, 0.6D)
                .onUseItem(entityItem -> {
                    this.getEntity().getInventory().addItem(entityItem.getItem());
                    AVPNetworking.instance.sendToAll(new PacketSyncEntityInventory(this.getEntity(), this.getEntity().getInventory()));
                }), LEADER_FOLLOW_BEHAVIOR);
        this.addTask(new EatFoodBrainTask());
        this.addTask(new PlaceTorchBrainTask());
    }

    private void initNavigationTasks(EntityMarine entity) {
        this.addTask(new BrainTaskAdapter(new EntityAIMoveIndoors(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIRestrictOpenDoor(entity)));
        this.addTask(new BrainTaskAdapter(new EntityAIOpenDoor(entity, true)));
        this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 0.6D)));

        this.addTask(new AvoidBlockBrainTask(3F, 0.6F, 0.6F, AVOID_BLOCKS::contains));
        this.addTask(new FollowSquadLeaderBrainTask(0.6D, 10.0F, 2.0F), LEADER_FOLLOW_BEHAVIOR);
    }

    private void initIdleTasks() {
        this.addTask(new WanderBrainTask( 0.6D), WOLF_BEHAVIOR);
        this.addTask(new WatchClosestBrainTask(EntityPlayer.class, 3.0F));
        this.addTask(new WatchClosestBrainTask(EntityLiving.class, 8.0F));
    }

    private void initCombatTasks() {
        this.addTask(new ProtectSquadLeaderTask(), SQUAD_BEHAVIOR);
        this.addTask(new HurtByTargetBrainTask());
        this.addTask(new NearestAttackableTargetBrainTask());
        this.addTask(
                new InvalidateAttackTargetBrainTask(target ->
                        !this.getEntity().hasLoadedAmmunition() || // Out of ammo
                                this.getEntity().getDistanceSq(target) < 4 || // Target too close
                                (this.getEntity().getSquadLeader().isPresent() &&
                                target.getUniqueID().equals(this.getEntity().getSquadLeader().get().getUniqueID())) // Do not attack squad leader.
                )
        );
        this.addTask(
                new MarineRangedAttackBrainTask(
                        0.4D,
                        this.getEntity().getMarineType().getFirearmItem().getFirearmProperties().getTickDelayBetweenShots(),
                        24
                )
        );
        this.addTask(new AvoidNearestAvoidTargetBrainTask(0.6F, 0.8F, e -> {
            if (e instanceof EntityAcidPool)
                return 3.0F;
            if (e instanceof EntityCreeper && ((EntityCreeper)e).hasIgnited())
                return 8.0F;
            if (e instanceof EntityTNTPrimed)
                return 8.0F;

            return 5.0F;
        }));
    }

    @Override
    public void update() {
        super.update();

        if (this.getEntity().getSquadLeader().isPresent()) {
            this.enableProfiles(SQUAD_BEHAVIOR);
            this.disableProfiles(WOLF_BEHAVIOR);

            // If the marine is not guarding (not stationary), allow the marine to follow the squad leader.
            if (!this.getEntity().isGuarding.get()) {
                this.enableProfiles(LEADER_FOLLOW_BEHAVIOR);
            }
            // Otherwise, the marine should be stationary.
            else {
                this.disableProfiles(LEADER_FOLLOW_BEHAVIOR);
            }
        } else {
            this.getEntity().isGuarding.set(false);
            this.enableProfiles(WOLF_BEHAVIOR);
            this.disableProfiles(SQUAD_BEHAVIOR, LEADER_FOLLOW_BEHAVIOR);
        }
    }
}
