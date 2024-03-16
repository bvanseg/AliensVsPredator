package org.avp.neoforge.service;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.avp.common.data.loot_table.AVPLootTableProvider;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeDataProviderRegistry {

    private static final NeoForgeDataProviderRegistry INSTANCE = new NeoForgeDataProviderRegistry();

    public static NeoForgeDataProviderRegistry getInstance() {
        return INSTANCE;
    }

    public void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        var generator = gatherDataEvent.getGenerator();
        var output = generator.getPackOutput();
        generator.addProvider(true, new AVPLootTableProvider(output));
    }
}
