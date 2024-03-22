package org.avp.common.data.loot_table.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import org.avp.common.block.AVPBlocks;
import org.avp.common.block.AVPEngineerBlocks;
import org.avp.common.block.AVPIndustrialBlocks;
import org.avp.common.block.AVPOreBlocks;
import org.avp.common.block.AVPPaddingBlocks;
import org.avp.common.block.AVPParadiseBlocks;
import org.avp.common.block.AVPTempleBlocks;
import org.avp.common.block.AVPYautjaShipBlocks;
import org.avp.common.data.loot_table.AbstractAVPBlockLootTableProvider;
import org.avp.common.item.AVPItems;

public class AVPBlockLootTableProvider extends AbstractAVPBlockLootTableProvider {

    @Override
    public void generate() {
        dropSelf(AVPBlocks.ALUMINUM_BLOCK.get());

        createEngineerBlockLootTables();
        createIndustrialBlockLookTables();
        createOreBlockLootTables();
        createPaddingBlockLootTables();
        createParadiseBlockLootTables();
        createTempleBlockLootTables();
        createYautjaBlockLootTables();
    }

    private void createEngineerBlockLootTables() {
        AVPEngineerBlocks.getEntries().forEach(tuple -> dropSelf(tuple.first().get()));
    }

    private void createIndustrialBlockLookTables() {
        AVPIndustrialBlocks.getEntries().forEach(blockGameObject -> dropSelf(blockGameObject.get()));
    }

    private void createOreBlockLootTables() {
        add(AVPOreBlocks.ORE_BAUXITE.get(), block -> createOreDrop(block, AVPItems.RAW_BAUXITE.get()));
        add(AVPOreBlocks.ORE_COBALT.get(), block -> createOreDrop(block, AVPItems.COBALT.get()));
        // TODO:
        dropSelf(AVPOreBlocks.ORE_LITHIUM.get());
        add(AVPOreBlocks.ORE_MONAZITE.get(), block -> createOreDrop(block, AVPItems.NEODYMIUM.get()));
        add(AVPOreBlocks.ORE_SILICA.get(), block -> createOreDrop(block, AVPItems.SILICA.get()));
        dropSelf(AVPOreBlocks.RAW_BAUXITE_BLOCK.get());
    }

    private void createPaddingBlockLootTables() {
        AVPPaddingBlocks.getEntries().forEach(blockGameObject -> dropSelf(blockGameObject.get()));
    }

    private void createParadiseBlockLootTables() {
        dropSelf(AVPParadiseBlocks.PARADISE_DIRT.get());
        dropSelf(AVPParadiseBlocks.PARADISE_DIRT_MOSSY.get());
        dropSelf(AVPParadiseBlocks.PARADISE_DIRT_PODZOL.get());
        add(
            AVPParadiseBlocks.PARADISE_GRASS.get(),
            (Block block) -> this.createSingleItemTableWithSilkTouch(block, AVPParadiseBlocks.PARADISE_DIRT.get())
        );

        // TODO: Fix sapling drops for these.
        add(
            AVPParadiseBlocks.PARADISE_LEAVES_LARGE.get(),
            (Block block) -> this.createLeavesDrops(block, Blocks.SPRUCE_SAPLING)
        );
        add(
            AVPParadiseBlocks.PARADISE_LEAVES_MEDIUM.get(),
            (Block block) -> this.createLeavesDrops(block, Blocks.SPRUCE_SAPLING)
        );
        add(
            AVPParadiseBlocks.PARADISE_LEAVES_SMALL.get(),
            (Block block) -> this.createLeavesDrops(block, Blocks.SPRUCE_SAPLING)
        );

        dropSelf(AVPParadiseBlocks.PARADISE_LOG_LARGE.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_MEDIUM.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_SMALL.get());

        dropSelf(AVPParadiseBlocks.PARADISE_LOG_LARGE_PLANKS.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_MEDIUM_PLANKS.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_SMALL_PLANKS.get());
    }

    private void createTempleBlockLootTables() {
        AVPTempleBlocks.getEntries().forEach(tuple -> dropSelf(tuple.first().get()));
    }

    private void createYautjaBlockLootTables() {
        AVPYautjaShipBlocks.getEntries().forEach(blockGameObject -> dropSelf(blockGameObject.get()));
    }
}
