package org.lib.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.network.datasync.DataParameter;

/**
 * @author Boston Vanseghi
 */
public class EnumDataHandle<T extends Enum<T>> extends DataHandle<T> {

    public EnumDataHandle(Entity entity, DataParameter<T> dataParameter) {
        super(entity, dataParameter);
    }
}
