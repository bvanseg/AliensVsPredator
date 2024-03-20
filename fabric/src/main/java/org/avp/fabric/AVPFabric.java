package org.avp.fabric;

import net.fabricmc.api.ModInitializer;

import org.avp.common.AVPCommon;
import org.avp.fabric.common.registry.AVPDeferredBlockRegistry;
import org.avp.fabric.common.registry.AVPDeferredItemRegistry;
import org.avp.fabric.common.worldgen.AVPFabricWorldGenFeatures;
import org.avp.fabric.service.FabricEntityAttributeRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        // Use Fabric to bootstrap the Common mod.
        AVPCommon.init();
        AVPDeferredItemRegistry.registerAll();
        AVPDeferredBlockRegistry.registerAll();
        AVPFabricWorldGenFeatures.getInstance().register();
        FabricEntityAttributeRegistry.getInstance().register();
    }
}
