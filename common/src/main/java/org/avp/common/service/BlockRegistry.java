package org.avp.common.service;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public interface BlockRegistry {

    GameObject<Block> register(String registryName, Supplier<Block> supplier);
}
