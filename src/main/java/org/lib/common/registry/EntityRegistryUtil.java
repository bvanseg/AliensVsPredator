package org.lib.common.registry;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Boston Vanseghi
 */
public class EntityRegistryUtil {

    private EntityRegistryUtil() {}

    private static final AtomicInteger LATEST_ENTITY_ID = new AtomicInteger(0);

    public static int getNextEntityID() {
        return LATEST_ENTITY_ID.getAndIncrement();
    }
}
