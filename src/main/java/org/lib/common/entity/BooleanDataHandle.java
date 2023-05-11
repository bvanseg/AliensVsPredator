package org.lib.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.network.datasync.DataParameter;

/**
 * @author Boston Vanseghi
 */
public class BooleanDataHandle extends DataHandle<Boolean> {

    public BooleanDataHandle(Entity entity, DataParameter<Boolean> dataParameter) {
        super(entity, dataParameter);
    }

    public void invert() {
        this.set(!this.get());
    }
}
