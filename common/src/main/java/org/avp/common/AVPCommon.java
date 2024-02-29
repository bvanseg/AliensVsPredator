package org.avp.common;

import org.avp.common.block.AVPEngineerBlocks;
import org.avp.common.block.AVPOreBlocks;
import org.avp.common.block.AVPTempleBlocks;
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
        AVPOreBlocks.getInstance().register();
        AVPTempleBlocks.getInstance().register();
    }
}