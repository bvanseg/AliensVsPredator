package org.avp.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import org.avp.common.AVPCommon;
import org.avp.common.AVPConstants;
import org.avp.neoforge.service.NeoForgeBlockRegistry;
import org.avp.neoforge.service.NeoForgeEntityAttributeRegistry;
import org.avp.neoforge.service.NeoForgeEntityRegistry;
import org.avp.neoforge.service.NeoForgeItemRegistry;

/**
 * @author Boston Vanseghi
 */
@Mod(AVPConstants.MOD_ID)
public class AVPNeoForge {

    public AVPNeoForge(IEventBus eventBus) {
        AVPCommon.init();
        NeoForgeItemRegistry.ITEMS.register(eventBus);
        NeoForgeBlockRegistry.BLOCKS.register(eventBus);
        NeoForgeEntityRegistry.ENTITY_TYPES.register(eventBus);
        eventBus.addListener(NeoForgeEntityAttributeRegistry.getInstance()::createEntityAttributes);
    }
}
