package org.avp.common.data.loot_table.blocks;

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
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK_1.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK_2.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK_3.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_COLUMN_1.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_COLUMN_2.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_FLOOR.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_GRAVEL.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_MATERIAL_0.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_MATERIAL_1.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_MATERIAL_2.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK_1.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK_2.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK_3.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_1.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_2.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_3.get());
        dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_4.get());
    }

    private void createIndustrialBlockLookTables() {
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_BRICK.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_FLOOR_GRILL.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_GLASS.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_LAMP.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_VENT.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_WALL.get());
        dropSelf(AVPIndustrialBlocks.INDUSTRIAL_WALL_HAZARD.get());
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
        dropSelf(AVPPaddingBlocks.PADDING_ORANGE_PANEL.get());
        dropSelf(AVPPaddingBlocks.PADDING_ORANGE_PIPES.get());
        dropSelf(AVPPaddingBlocks.PADDING_ORANGE_SQUARE.get());
        dropSelf(AVPPaddingBlocks.PADDING_ORANGE_TILES.get());
        dropSelf(AVPPaddingBlocks.PADDING_WHITE_PANEL.get());
        dropSelf(AVPPaddingBlocks.PADDING_WHITE_PIPES.get());
        dropSelf(AVPPaddingBlocks.PADDING_WHITE_SQUARE.get());
        dropSelf(AVPPaddingBlocks.PADDING_WHITE_TILES.get());
    }

    private void createParadiseBlockLootTables() {
        dropSelf(AVPParadiseBlocks.PARADISE_DIRT.get());
        dropSelf(AVPParadiseBlocks.PARADISE_DIRT_MOSSY.get());
        dropSelf(AVPParadiseBlocks.PARADISE_DIRT_PODZOL.get());
        dropSelf(AVPParadiseBlocks.PARADISE_GRASS.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LEAVES_LARGE.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LEAVES_MEDIUM.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LEAVES_SMALL.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_LARGE.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_MEDIUM.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_SMALL.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_LARGE_PLANKS.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_MEDIUM_PLANKS.get());
        dropSelf(AVPParadiseBlocks.PARADISE_LOG_SMALL_PLANKS.get());
    }

    private void createTempleBlockLootTables() {
        dropSelf(AVPTempleBlocks.TEMPLE_BRICK.get());
        dropSelf(AVPTempleBlocks.TEMPLE_BRICK_CHESTBURSTER.get());
        dropSelf(AVPTempleBlocks.TEMPLE_BRICK_FACEHUGGER.get());
        dropSelf(AVPTempleBlocks.TEMPLE_BRICK_SINGLE.get());
        dropSelf(AVPTempleBlocks.TEMPLE_FLOOR.get());
        dropSelf(AVPTempleBlocks.TEMPLE_SKULLS.get());
        dropSelf(AVPTempleBlocks.TEMPLE_TEMPLE_TILE.get());
        dropSelf(AVPTempleBlocks.TEMPLE_WALL_BASE.get());
    }

    private void createYautjaBlockLootTables() {
        dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_BRICK.get());
        dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_DECOR_1.get());
        dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_DECOR_2.get());
        dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_DECOR_3.get());
        dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_PANEL.get());
        dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_SUPPORT_PILLAR.get());
        dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_WALL_BASE.get());
    }
}
