package org.lib.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.network.datasync.DataParameter;

/**
 * @author Boston Vanseghi
 */
public class IntegerDataHandle extends NumberDataHandle<Integer> {

    public IntegerDataHandle(Entity entity, DataParameter<Integer> dataParameter) {
        super(entity, dataParameter);
    }

    @Override
    public void add(Integer value) {
        this.set(this.get() + value);
    }

    @Override
    public void increment() {
        this.add(1);
    }
}
