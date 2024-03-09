package org.avp.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.avp.common.AVPResources;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPBlockTags implements AVPRegistry {

    private static final AVPBlockTags INSTANCE = new AVPBlockTags();

    public static AVPBlockTags getInstance() {
        return INSTANCE;
    }

    private static TagKey<Block> create(String registryName) {
        return TagKey.create(Registries.BLOCK, AVPResources.location(registryName));
    }

    public TagKey<Block> ACID_RESISTANT;

    @Override
    public void register() {
        ACID_RESISTANT = create("acid_resistant");
    }
}
