package org.avp.neoforge.common.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.avp.common.data.loot_table.AVPLootTableProvider;

/**
 * @author Boston Vanseghi
 */
public class AVPNeoForgeData {

    private static final AVPNeoForgeData INSTANCE = new AVPNeoForgeData();

    public static AVPNeoForgeData getInstance() {
        return INSTANCE;
    }

    public void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        var generator = gatherDataEvent.getGenerator();
        var output = generator.getPackOutput();
        generator.addProvider(true, new AVPLootTableProvider(output));
    }
}
