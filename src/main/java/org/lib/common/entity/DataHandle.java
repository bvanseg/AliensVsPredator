package org.lib.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.network.datasync.DataParameter;

/**
 * A slightly cleaner way of handling data parameters by automatically providing getters and setters.
 *
 * @param <T> The type of the data parameter.
 *
 * @author Boston Vanseghi
 */
public class DataHandle<T> {

    private final Entity entity;
    private final DataParameter<T> dataParameter;

    public DataHandle(Entity entity, DataParameter<T> dataParameter) {
        this.entity = entity;
        this.dataParameter = dataParameter;
    }

    public T get() {
        return this.entity.getDataManager().get(this.dataParameter);
    }

    public void set(T value) {
        this.entity.getDataManager().set(this.dataParameter, value);
    }
}
