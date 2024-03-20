package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class AVPIndustrialBlocks {

    private static final List<GameObject<Block>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties INDUSTRIAL_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    );

    public static final GameObject<Block> INDUSTRIAL_BRICK;

    public static final GameObject<Block> INDUSTRIAL_FLOOR_GRILL;

    public static final GameObject<Block> INDUSTRIAL_GLASS;

    public static final GameObject<Block> INDUSTRIAL_LAMP;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_0;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_1;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_2;

    public static final GameObject<Block> INDUSTRIAL_VENT;

    public static final GameObject<Block> INDUSTRIAL_WALL;

    public static final GameObject<Block> INDUSTRIAL_WALL_HAZARD;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    public static List<GameObject<Block>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Block> register(String registryName, Supplier<Block> blockSupplier) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockSupplier);
        ENTRIES.add(gameObject);
        return gameObject;
    }

    private AVPIndustrialBlocks() {}

    static {
        INDUSTRIAL_BRICK = register("industrial_brick", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_FLOOR_GRILL = register("industrial_floor_grill", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_GLASS = register("industrial_glass", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_LAMP = register("industrial_lamp", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_0 = register("industrial_metal_panel_0", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_1 = register("industrial_metal_panel_1", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_2 = register("industrial_metal_panel_2", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_VENT = register("industrial_vent", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL = register("industrial_wall", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL_HAZARD = register("industrial_wall_hazard", () -> new Block(INDUSTRIAL_PROPERTIES));
    }
}
