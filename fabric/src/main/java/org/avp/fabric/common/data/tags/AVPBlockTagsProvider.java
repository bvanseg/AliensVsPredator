package org.avp.fabric.common.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

import org.avp.api.block.factory.BlockFactories;
import org.avp.api.block.factory.FenceGateBlockFactory;
import org.avp.api.block.factory.StairBlockFactory;
import org.avp.common.block.AVPBlocks;
import org.avp.common.tag.AVPBlockTags;

public class AVPBlockTagsProvider extends FabricTagProvider.BlockTagProvider {

    public AVPBlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Acid-resistant blocks
        // TODO: For some reason, adding irreplaceable features crashes datagen. Investigate later.
        getOrCreateTagBuilder(AVPBlockTags.ACID_RESISTANT).addOptionalTag(BlockTags.FEATURES_CANNOT_REPLACE);

        // Fences, Fence Gates, Slabs, Stairs, Walls
        AVPBlocks.getEntries().forEach(tuple -> {
            var factory = tuple.second().getFactory();
            var block = tuple.first().get();

            if (factory == BlockFactories.FENCE) {
                getOrCreateTagBuilder(BlockTags.FENCES).add(block);
            }

            if (factory instanceof FenceGateBlockFactory) {
                getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(block);
            }

            if (factory == BlockFactories.SLAB) {
                getOrCreateTagBuilder(BlockTags.SLABS).add(block);
            }

            if (factory instanceof StairBlockFactory) {
                getOrCreateTagBuilder(BlockTags.STAIRS).add(block);
            }

            if (factory == BlockFactories.WALL) {
                getOrCreateTagBuilder(BlockTags.WALLS).add(block);
            }
        });
    }
}
