package org.avp.common;

import org.avp.common.item.AVPArmorItems;
import org.avp.common.item.AVPElectronicItems;
import org.avp.common.item.AVPFoodItems;
import org.avp.common.item.AVPItems;

/**
 * @author Boston Vanseghi
 */
public class AVPCommon {

    public static void init() {
        AVPArmorItems.getInstance().register();
        AVPElectronicItems.getInstance().register();
        AVPFoodItems.getInstance().register();
        AVPItems.getInstance().register();
    }
}