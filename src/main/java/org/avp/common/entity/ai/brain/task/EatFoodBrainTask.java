package org.avp.common.entity.ai.brain.task;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import org.avp.common.entity.living.EntityMarine;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.common.inventory.InventorySnapshot;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Boston Vanseghi
 */
public class EatFoodBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
        map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
        map.put(BrainFlags.NEAREST_AVOID_TARGET, BrainFlagState.ABSENT);
        map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
    }

    @Override
    public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
    }

    private boolean isEating = false;
    private ItemStack foodItemStack;
    private int eatTimer;

    @Override
    protected boolean shouldExecute() {
        if (!(ctx.getEntity() instanceof EntityMarine)) return false;
        if (this.getFoodItems().isEmpty()) return false;

        return !this.isEating && ctx.getEntity().getHealth() < ctx.getEntity().getMaxHealth();
    }

    @Override
    protected boolean shouldContinueExecuting() {
        return this.isEating && this.eatTimer >= 0;
    }

    @Override
    protected void startExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        Set<ItemFood> foodItems = this.getFoodItems();

        InventorySnapshot inventorySnapshot = marine.getInventorySnapshot();
        ItemStack stack = inventorySnapshot.getFirstNonEmptyStack(foodItems.iterator().next());

        if (stack == null) return;

        if (!stack.isEmpty() && !this.isEating) {
            this.isEating = true;
            this.foodItemStack = stack;
            this.eatTimer = (int)(20 * 1.61); // Players eat for 1.61 seconds.
        }
    }

    @Override
    protected void continueExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        InventorySnapshot inventorySnapshot = marine.getInventorySnapshot();

        if (this.eatTimer-- <= 0) {
            float healAmount = ((ItemFood)foodItemStack.getItem()).getSaturationModifier(ItemStack.EMPTY) * 10;
            inventorySnapshot.consumeItem(this.foodItemStack.getItem(), 1);
            ctx.getEntity().setHealth(ctx.getEntity().getHealth() + healAmount);
            this.isEating = false;
        }
        else if (this.eatTimer % 4 == 0) {
            ctx.getEntity().playSound(SoundEvents.ENTITY_GENERIC_EAT, 1F, 1F);
        }
    }

    @Override
    public void finish() {
        super.finish();
        this.isEating = false;
        this.foodItemStack = null;
        this.eatTimer = 0;
    }

    private Set<ItemFood> getFoodItems() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        return marine.getInventorySnapshot()
                .getItemsMatchingPredicate(ItemFood.class::isInstance)
                .stream()
                .map(item -> (ItemFood)item).collect(Collectors.toSet());
    }
}
