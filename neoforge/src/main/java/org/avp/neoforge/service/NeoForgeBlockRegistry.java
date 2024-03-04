package org.avp.neoforge.service;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import org.avp.common.AVPConstants;
import org.avp.common.service.BlockRegistry;
import org.avp.common.util.GameObject;
import org.avp.neoforge.util.ForgeGameObject;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeBlockRegistry implements BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(AVPConstants.MOD_ID);

    @Override
    public GameObject<Block> register(String registryName, Supplier<Block> supplier) {
        return new ForgeGameObject<>(BLOCKS, registryName, supplier);
    }
}
