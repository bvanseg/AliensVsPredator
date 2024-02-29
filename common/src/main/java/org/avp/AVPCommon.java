package org.avp;

import org.avp.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPCommon {

    public static void init() {
        Services.ITEM_REGISTRY.register();
    }
}