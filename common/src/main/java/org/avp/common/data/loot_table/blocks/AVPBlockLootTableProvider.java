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
    protected void generate() {
        this.dropSelf(AVPBlocks.ALUMINUM_BLOCK.get());

        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK_1.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK_2.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_BRICK_3.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_COLUMN_1.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_COLUMN_2.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_FLOOR.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_GRAVEL.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_MATERIAL_0.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_MATERIAL_1.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_MATERIAL_2.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK_1.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK_2.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_ROCK_3.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_1.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_2.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_3.get());
        this.dropSelf(AVPEngineerBlocks.ENGINEER_SHIP_WALL_4.get());

        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_BRICK.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_FLOOR_GRILL.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_GLASS.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_LAMP.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_VENT.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_WALL.get());
        this.dropSelf(AVPIndustrialBlocks.INDUSTRIAL_WALL_HAZARD.get());

        this.dropOther(AVPOreBlocks.ORE_BAUXITE.get(), AVPItems.RAW_BAUXITE.get());
        this.dropOther(AVPOreBlocks.ORE_COBALT.get(), AVPItems.COBALT.get());
        this.dropSelf(AVPOreBlocks.ORE_LITHIUM.get()); // TODO:
        this.dropOther(AVPOreBlocks.ORE_MONAZITE.get(), AVPItems.NEODYMIUM.get());
        this.dropOther(AVPOreBlocks.ORE_SILICA.get(), AVPItems.SILICA.get());
        this.dropSelf(AVPOreBlocks.RAW_BAUXITE_BLOCK.get());

        this.dropSelf(AVPPaddingBlocks.PADDING_ORANGE_PANEL.get());
        this.dropSelf(AVPPaddingBlocks.PADDING_ORANGE_PIPES.get());
        this.dropSelf(AVPPaddingBlocks.PADDING_ORANGE_SQUARE.get());
        this.dropSelf(AVPPaddingBlocks.PADDING_ORANGE_TILES.get());
        this.dropSelf(AVPPaddingBlocks.PADDING_WHITE_PANEL.get());
        this.dropSelf(AVPPaddingBlocks.PADDING_WHITE_PIPES.get());
        this.dropSelf(AVPPaddingBlocks.PADDING_WHITE_SQUARE.get());
        this.dropSelf(AVPPaddingBlocks.PADDING_WHITE_TILES.get());

        this.dropSelf(AVPParadiseBlocks.PARADISE_DIRT.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_DIRT_MOSSY.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_DIRT_PODZOL.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_GRASS.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_LEAVES_LARGE.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_LEAVES_MEDIUM.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_LEAVES_SMALL.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_LOG_LARGE.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_LOG_MEDIUM.get());
        this.dropSelf(AVPParadiseBlocks.PARADISE_LOG_SMALL.get());

        this.dropSelf(AVPTempleBlocks.TEMPLE_BRICK.get());
        this.dropSelf(AVPTempleBlocks.TEMPLE_BRICK_CHESTBURSTER.get());
        this.dropSelf(AVPTempleBlocks.TEMPLE_BRICK_FACEHUGGER.get());
        this.dropSelf(AVPTempleBlocks.TEMPLE_BRICK_SINGLE.get());
        this.dropSelf(AVPTempleBlocks.TEMPLE_FLOOR.get());
        this.dropSelf(AVPTempleBlocks.TEMPLE_SKULLS.get());
        this.dropSelf(AVPTempleBlocks.TEMPLE_TEMPLE_TILE.get());
        this.dropSelf(AVPTempleBlocks.TEMPLE_WALL_BASE.get());

        this.dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_BRICK.get());
        this.dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_DECOR_1.get());
        this.dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_DECOR_2.get());
        this.dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_DECOR_3.get());
        this.dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_PANEL.get());
        this.dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_SUPPORT_PILLAR.get());
        this.dropSelf(AVPYautjaShipBlocks.YAUTJA_SHIP_WALL_BASE.get());
    }
}
