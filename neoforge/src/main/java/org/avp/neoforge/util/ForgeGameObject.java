package org.avp.neoforge.util;

import net.neoforged.neoforge.registries.DeferredRegister;
import org.avp.common.util.GameObject;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class ForgeGameObject<T> extends GameObject<T> {
    public ForgeGameObject(DeferredRegister<T> deferredRegister, String registryName, Supplier<T> supplier) {
        super(deferredRegister.register(registryName, supplier));
    }
}
