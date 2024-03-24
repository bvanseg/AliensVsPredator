package org.avp.fabric;

import mod.azure.azurelib.common.internal.common.AzureLib;
import net.fabricmc.api.ModInitializer;

import org.avp.common.AVPCommon;
import org.avp.fabric.common.AVPFabricCommands;
import org.avp.fabric.common.registry.AVPDeferredBlockRegistry;
import org.avp.fabric.common.registry.AVPDeferredCreativeTabRegistry;
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

        // Deferred registration step.
        AVPDeferredItemRegistry.registerAll();
        AVPDeferredBlockRegistry.registerAll();
        AVPDeferredCreativeTabRegistry.registerAll();

        // Remaining steps
        AVPFabricWorldGenFeatures.getInstance().register();
        FabricEntityAttributeRegistry.getInstance().register();
        AVPFabricCommands.register();
    }
}
