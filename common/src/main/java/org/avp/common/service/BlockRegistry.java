package org.avp.common.service;

import net.minecraft.world.level.block.Block;
import org.avp.common.util.GameObject;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public interface BlockRegistry {
    GameObject<Block> register(String registryName, Supplier<Block> supplier);
}
