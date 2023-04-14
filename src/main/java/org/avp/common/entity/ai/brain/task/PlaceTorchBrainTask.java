package org.avp.common.entity.ai.brain.task;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import org.avp.common.entity.living.EntityMarine;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.common.inventory.InventorySnapshot;

import java.util.Map;
import java.util.Set;

/**
 * @author Boston Vanseghi
 */
public class PlaceTorchBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
        map.put(BrainFlags.NEAREST_AVOID_TARGET, BrainFlagState.ABSENT);
        map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
    }

    @Override
    protected boolean shouldExecute() {
        if (!(ctx.getEntity() instanceof EntityMarine)) return false;
        if (!this.isValidLightLevel()) return false;

        return true;
    }

    @Override
    protected void startExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        Item torchItem = Item.getItemFromBlock(Blocks.TORCH);
        InventorySnapshot inventorySnapshot = marine.getInventorySnapshot();
        Set<Item> torchItems = inventorySnapshot.getItemsMatchingPredicate(item -> item == torchItem);

        if (torchItems.isEmpty()) return;

        ItemStack stack = inventorySnapshot.getFirstNonEmptyStack(torchItems.iterator().next());

        if (stack == null) return;

        if (!stack.isEmpty()) {
            inventorySnapshot.consumeItem(torchItem, 1);
            if (marine.world.mayPlace(Blocks.TORCH, marine.getPosition(), false, EnumFacing.DOWN, marine)) {
                marine.world.setBlockState(marine.getPosition(), Blocks.TORCH.getDefaultState());
            }
        }
    }

    protected boolean isValidLightLevel()
    {
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        int i = marine.world.getLightFromNeighbors(marine.getPosition());

        if (marine.world.isThundering())
        {
            int j = marine.world.getSkylightSubtracted();
            marine.world.setSkylightSubtracted(10);
            i = marine.world.getLightFromNeighbors(marine.getPosition());
            marine.world.setSkylightSubtracted(j);
        }

        return i <= 4;
    }
}
