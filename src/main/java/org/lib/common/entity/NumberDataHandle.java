package org.lib.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.network.datasync.DataParameter;

/**
 * @author Boston Vanseghi
 */
public abstract class NumberDataHandle<T extends Number> extends DataHandle<T> {

    protected NumberDataHandle(Entity entity, DataParameter<T> dataParameter) {
        super(entity, dataParameter);
    }

    public abstract void add(T value);
    public abstract void increment();
}
