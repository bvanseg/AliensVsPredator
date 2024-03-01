package org.avp.fabric;

import net.fabricmc.api.ModInitializer;
import org.avp.common.AVPCommon;
import org.avp.common.AVPConstants;
import org.avp.fabric.service.FabricEntityAttributeRegistry;

public class AVPFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        AVPConstants.LOGGER.info("Hello Fabric world!");
        AVPCommon.init();
        FabricEntityAttributeRegistry.getInstance().register();
    }
}
