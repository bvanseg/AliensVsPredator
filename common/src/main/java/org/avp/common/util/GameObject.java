package org.avp.common.util;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

import org.avp.common.AVPResources;

/**
 * @author Boston Vanseghi
 */
public class GameObject<T> {

    private T object;

    private final ResourceLocation resourceLocation;

    private final Supplier<T> supplier;

    public GameObject(String location, Supplier<T> supplier) {
        this.resourceLocation = AVPResources.location(location);
        this.supplier = supplier;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

    public T get() {
        if (object == null) {
            object = supplier.get();
        }
        return object;
    }
}
