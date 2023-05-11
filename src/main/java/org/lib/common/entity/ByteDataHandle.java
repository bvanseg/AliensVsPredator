package org.lib.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.network.datasync.DataParameter;

/**
 * @author Boston Vanseghi
 */
public class ByteDataHandle extends NumberDataHandle<Byte> {

    public ByteDataHandle(Entity entity, DataParameter<Byte> dataParameter) {
        super(entity, dataParameter);
    }

    @Override
    public void add(Byte value) {
        this.set((byte) (this.get() + value));
    }

    @Override
    public void increment() {
        this.add((byte) 1);
    }
}
