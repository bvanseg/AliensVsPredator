package org.avp.common;

import org.avp.common.block.*;
import org.avp.common.creative_tab.AVPCreativeModeTabs;
import org.avp.common.entity.*;
import org.avp.common.item.*;
import org.avp.common.sound.AVPSoundEvents;
import org.avp.common.tag.AVPBlockTags;
import org.avp.common.tag.AVPEntityTags;
import org.avp.common.worldgen.AVPWorldGenFeatures;

/**
 * @author Boston Vanseghi
 */
public class AVPCommon {

    public static void init() {
        // World Gen resource keys
        AVPWorldGenFeatures.getInstance().register();

        // Tags
        AVPBlockTags.getInstance().register();
        AVPEntityTags.getInstance().register();

        // Items
        AVPArmorItems.forceInitialization();
        AVPElectronicItems.forceInitialization();
        AVPFoodItems.forceInitialization();
        AVPItems.forceInitialization();
        AVPToolItems.forceInitialization();
        AVPWeaponItems.forceInitialization();

        // Blocks
        AVPBlocks.forceInitialization();
        AVPEngineerBlocks.forceInitialization();
        AVPIndustrialBlocks.forceInitialization();
        AVPOreBlocks.forceInitialization();
        AVPPaddingBlocks.forceInitialization();
        AVPParadiseBlocks.forceInitialization();
        AVPTempleBlocks.forceInitialization();
        AVPYautjaShipBlocks.forceInitialization();

        // Entities
        AVPBaseAlienEntityTypes.getInstance().register();
        AVPEngineerEntityTypes.getInstance().register();
        AVPEntityTypes.getInstance().register();
        AVPExoticAlienEntityTypes.getInstance().register();
        AVPPrometheusAlienEntityTypes.getInstance().register();
        AVPRunnerAlienEntityTypes.getInstance().register();

        // It's important to register creative mode tabs last, as entities generate spawn eggs automatically.
        AVPCreativeModeTabs.register();

        // Sounds
        AVPSoundEvents.getInstance().register();
    }

    private AVPCommon() {
        throw new UnsupportedOperationException();
    }
}
