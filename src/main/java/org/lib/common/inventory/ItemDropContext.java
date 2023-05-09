package org.lib.common.inventory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;

/**
 * @author Boston Vanseghi
 */
public class ItemDropContext {

    private final World world;
    private final Vec3d pos;
    private final Random random;

    public ItemDropContext(EntityLivingBase entity) {
        this.world = entity.world;
        this.pos = entity.getPositionVector();
        this.random = entity.getRNG();
    }

    protected int getRandomDropAmount(ItemDrop itemDrop) {
        int randomAmount = random.nextInt(itemDrop.getMaximumDropAmount()) + 1;
        return MathHelper.clamp(randomAmount, itemDrop.getMinimumDropAmount(), itemDrop.getMaximumDropAmount());
    }

    public void drop(ItemDrop itemDrop) {
        this.dropWithWeight(itemDrop, itemDrop.getDropWeight());
    }

    public void dropWithAmount(ItemDrop itemDrop, int amount) {
        this.drop(itemDrop, amount, itemDrop.getDropWeight());
    }

    public void dropWithWeight(ItemDrop itemDrop, int dropWeight) {
        int adjustedDropAmount = this.getRandomDropAmount(itemDrop);
        this.drop(itemDrop, adjustedDropAmount, dropWeight);
    }

    public void dropWithBonusDropWeight(ItemDrop itemDrop, int bonusDropWeight) {
        this.dropWithWeight(itemDrop, itemDrop.getDropWeight() + bonusDropWeight);
    }

    public void dropWithRandomBonusAmount(ItemDrop itemDrop, int bonusAmount) {
        int baseRandomAmount = this.getRandomDropAmount(itemDrop);
        int bonusRandomAmount = this.random.nextInt(MathHelper.clamp(bonusAmount, 0, Integer.MAX_VALUE));
        this.drop(itemDrop, baseRandomAmount + bonusRandomAmount, itemDrop.getDropWeight());
    }

    public void drop(ItemDrop itemDrop, int amount, int dropWeight) {
        if (world.isRemote) return;
        if ((random.nextInt(100) + 1) > dropWeight) return;

        ItemStack itemStack = new ItemStack(itemDrop.getItem(), amount);
        EntityItem entityItem = new EntityItem(world, pos.x, pos.y, pos.z, itemStack);
        entityItem.setDefaultPickupDelay();
        world.spawnEntity(entityItem);
    }

    public void drop(ItemDropTable itemDropTable) {
        int weightSum = itemDropTable.getSumOfWeights();
        int weightRoll = random.nextInt(weightSum);
        int[] summedWeights = itemDropTable.getCumulativeSummedWeights();

        int i = 0;
        for (int cumulativeWeight: summedWeights) {
            if (weightRoll < cumulativeWeight) {
                Pair<Object, Integer> droppableWithWeight = itemDropTable.getDroppablesWithWeight().get(i);
                Object droppable = droppableWithWeight.getLeft();

                if (droppable instanceof ItemDropTable) {
                    this.drop((ItemDropTable) droppable);
                }
                else {
                    ItemDrop itemDrop = (ItemDrop) droppable;
                    this.dropWithWeight(itemDrop, 100);
                }

                return;
            }
            i++;
        }
    }
}
