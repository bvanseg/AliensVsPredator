package org.avp.common;

import org.avp.common.block.*;
import org.avp.common.creative_tab.AVPCreativeModeTabs;
import org.avp.common.entity.*;
import org.avp.common.item.*;

/**
 * @author Boston Vanseghi
 */
public class AVPCommon {

    public static void init() {
        AVPArmorItems.getInstance().register();
        AVPElectronicItems.getInstance().register();
        AVPFoodItems.getInstance().register();
        AVPItems.getInstance().register();
        AVPWeaponItems.getInstance().register();

        AVPEngineerBlocks.getInstance().register();
        AVPIndustrialBlocks.getInstance().register();
        AVPOreBlocks.getInstance().register();
        AVPPaddingBlocks.getInstance().register();
        AVPTempleBlocks.getInstance().register();
        AVPYautjaShipBlocks.getInstance().register();

        AVPBaseAlienEntityTypes.getInstance().register();
        AVPEngineerEntityTypes.getInstance().register();
        AVPEntityTypes.getInstance().register();
        AVPExoticAlienEntityTypes.getInstance().register();
        AVPPrometheusAlienEntityTypes.getInstance().register();

        // It's important to register creative mode tabs last, as entities generate spawn eggs automatically.
        AVPCreativeModeTabs.getInstance().register();
    }
}
