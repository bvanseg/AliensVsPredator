package org.avp.neoforge.common.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.avp.common.data.loot_table.AVPLootTableProvider;
import org.avp.common.data.recipes.AVPRecipeProvider;
import org.avp.common.data.recipes.AVPElectronicRecipes;

/**
 * @author Boston Vanseghi
 */
public final class AVPNeoForgeData {

    public static void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        var generator = gatherDataEvent.getGenerator();
        var output = generator.getPackOutput();
        generator.addProvider(true, new AVPLootTableProvider(output));
        generator.addProvider(true, new AVPRecipeProvider(output));
    }

    private AVPNeoForgeData() {
        throw new UnsupportedOperationException();
    }
}
