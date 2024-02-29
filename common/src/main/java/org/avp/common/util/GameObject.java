package org.avp.common.util;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class GameObject<T> {

    private T object;
    private final Supplier<T> supplier;

    public GameObject(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if (object == null) {
            object = supplier.get();
        }
        return object;
    }
}
