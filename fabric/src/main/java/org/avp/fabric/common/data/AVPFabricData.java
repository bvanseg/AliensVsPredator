package org.avp.fabric.common.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.avp.common.data.loot_table.AVPLootTableProvider;

/**
 * @author Boston Vanseghi
 */
public class AVPFabricData implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((fabricDataOutput, completableFuture) -> new AVPLootTableProvider(fabricDataOutput));
    }
}
