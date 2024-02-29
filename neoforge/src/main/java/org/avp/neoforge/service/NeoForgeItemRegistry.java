package org.avp.neoforge.service;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.avp.common.AVPConstants;
import org.avp.common.service.ItemRegistry;
import org.avp.common.util.GameObject;
import org.avp.neoforge.util.ForgeGameObject;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeItemRegistry implements ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(AVPConstants.MOD_ID);

    @Override
    public GameObject<Item> register(String registryName, Supplier<Item> supplier) {
        return new ForgeGameObject<>(ITEMS, registryName, supplier);
    }
}
