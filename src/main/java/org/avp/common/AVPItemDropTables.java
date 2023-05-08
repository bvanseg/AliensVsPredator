package org.avp.common;

import org.avp.common.item.init.AVPItems;
import org.lib.common.inventory.ItemDropTable;
import org.predator.common.PredatorItems;

/**
 * @author Boston Vanseghi
 */
public class AVPItemDropTables {
    private AVPItemDropTables() {}

    public static final ItemDropTable PREDATOR_DROP_TABLE = new ItemDropTable.Builder()
        .addItemDropSet(
            new ItemDropTable.Builder()
                    .addItemDrop(PredatorItems.AXE_CELTIC, 1)
                    .addItemDrop(PredatorItems.HOE_CELTIC, 1)
                    .addItemDrop(PredatorItems.PICKAXE_CELTIC, 1)
                    .addItemDrop(PredatorItems.SHOVEL_CELTIC, 1)
                    .addItemDrop(PredatorItems.SWORD_CELTIC, 2)
                    .build(), 5
        )
        .addItemDropSet(
            new ItemDropTable.Builder()
                    .addItemDrop(PredatorItems.BIOMASK_CELTIC, 1)
                    .addItemDrop(PredatorItems.CHESTPLATE_CELTIC, 3)
                    .addItemDrop(PredatorItems.LEGS_CELTIC, 3)
                    .addItemDrop(PredatorItems.BOOTS_CELTIC, 3)
                    .build(), 3
        )
        .addItemDropSet(
            new ItemDropTable.Builder()
                    .addItemDrop(PredatorItems.ITEM_PROXIMITY_MINE, 4)
                    .addItemDrop(PredatorItems.ITEM_SHURIKEN, 4)
                    .addItemDrop(PredatorItems.ITEM_DISC, 1)
                    .addItemDrop(PredatorItems.ITEM_SPEAR, 1)
                    .build(), 7
        )
        .addItemDropSet(
            new ItemDropTable.Builder()
                    .addItemDrop(PredatorItems.ITEM_WRISTBRACER, 1)
                    .addItemDrop(PredatorItems.ITEM_WRISTBRACER_BLADES, 1)
                    .addItemDrop(PredatorItems.ITEM_PLASMA_CANNON, 1)
                    .build(), 1
        )
        .addItemDropSet(
            new ItemDropTable.Builder()
                    .addItemDrop(PredatorItems.ITEM_ARTIFACT_TECH, 1)
                    .addItemDrop(AVPItems.ITEM_SILICON, 1)
                    .build(), 7
        )
        .build();
}
