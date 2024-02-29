package org.avp.common;

import org.avp.common.item.AVPFoodItems;
import org.avp.common.item.AVPItems;

/**
 * @author Boston Vanseghi
 */
public class AVPCommon {

    public static void init() {
        AVPItems.getInstance().register();
        AVPFoodItems.getInstance().register();
    }
}