package org.avp.fabric.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.avp.common.util.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boston Vanseghi
 */
public final class AVPDeferredCreativeTabRegistry {

    private static final List<GameObject<CreativeModeTab>> entries = new ArrayList<>();

    public static void enqueue(GameObject<CreativeModeTab> object) {
        entries.add(object);
    }

    public static void registerAll() {
        entries.forEach(
            creativeModeTabGameObject -> Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                creativeModeTabGameObject.getResourceLocation(),
                creativeModeTabGameObject.get()
            )
        );
    }

    private AVPDeferredCreativeTabRegistry() {
        throw new UnsupportedOperationException();
    }
}
