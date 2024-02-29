package org.avp.common.service;

import org.avp.common.AVPConstants;

import java.util.ServiceLoader;

public class Services {

    public static final BlockRegistry BLOCK_REGISTRY = load(BlockRegistry.class);
    public static final EntityRegistry ENTITY_REGISTRY = load(EntityRegistry.class);
    public static final ItemRegistry ITEM_REGISTRY = load(ItemRegistry.class);
    public static final Platform PLATFORM = load(Platform.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        AVPConstants.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}