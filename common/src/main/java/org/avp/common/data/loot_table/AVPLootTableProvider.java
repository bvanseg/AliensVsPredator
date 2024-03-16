package org.avp.common.data.loot_table;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.avp.common.data.loot_table.blocks.AVPBlockLootTableProvider;

import java.util.List;
import java.util.Set;

public class AVPLootTableProvider extends LootTableProvider {
    public AVPLootTableProvider(PackOutput packOutput) {
        super(packOutput, Set.of(), List.of(
            new SubProviderEntry(AVPBlockLootTableProvider::new, LootContextParamSets.BLOCK)
        ));
    }
}
