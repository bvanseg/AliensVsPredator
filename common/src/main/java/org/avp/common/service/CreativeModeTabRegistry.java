package org.avp.common.service;

import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public interface CreativeModeTabRegistry {

    GameObject<CreativeModeTab> register(String registryName, Supplier<CreativeModeTab> supplier);
}
