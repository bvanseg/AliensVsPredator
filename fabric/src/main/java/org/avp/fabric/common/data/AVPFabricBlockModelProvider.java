package org.avp.fabric.common.data;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Block;
import org.avp.common.block.AVPBlocks;
import org.avp.common.block.AVPEngineerBlocks;
import org.avp.common.block.AVPIndustrialBlocks;
import org.avp.common.block.AVPOreBlocks;
import org.avp.common.block.AVPPaddingBlocks;
import org.avp.common.block.AVPParadiseBlocks;
import org.avp.common.block.AVPTempleBlocks;
import org.avp.common.block.AVPYautjaShipBlocks;

public class AVPFabricBlockModelProvider {

    public static void addBlockModels(BlockModelGenerators generator) {
        AVPBlocks.getEntries()
            .forEach(
                blockGameObject -> generator.createTrivialCube(blockGameObject.get())
            );
        AVPEngineerBlocks.getEntries()
            .forEach(
                blockGameObject -> generator.createTrivialCube(blockGameObject.get())
            );

        addIndustrialBlockModels(generator);

        AVPOreBlocks.getEntries()
            .forEach(
                blockGameObject -> generator.createTrivialCube(blockGameObject.get())
            );
        AVPPaddingBlocks.getEntries()
            .forEach(
                blockGameObject -> generator.createTrivialCube(blockGameObject.get())
            );
        AVPParadiseBlocks.getEntries()
            .forEach(
                blockGameObject -> generator.createTrivialCube(blockGameObject.get())
            );

        addTempleBlockModels(generator);

        AVPYautjaShipBlocks.getEntries()
            .forEach(
                blockGameObject -> generator.createTrivialCube(blockGameObject.get())
            );
    }

    private static void addIndustrialBlockModels(BlockModelGenerators generator) {
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_BRICK.get());
        createSlabBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_BRICK.get(),  AVPIndustrialBlocks.INDUSTRIAL_BRICK_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_BRICK.get(),  AVPIndustrialBlocks.INDUSTRIAL_BRICK_STAIRS.get()
        );
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_FLOOR_GRILL.get());
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_GLASS.get());
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_LAMP.get());
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0.get());
        createSlabBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0.get(),  AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0.get(),  AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0_STAIRS.get()
        );
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1.get());
        createSlabBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1.get(),  AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1.get(),  AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1_STAIRS.get()
        );
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2.get());
        createSlabBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2.get(),  AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2.get(),  AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2_STAIRS.get()
        );
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_VENT.get());
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_WALL.get());
        createSlabBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_WALL.get(),  AVPIndustrialBlocks.INDUSTRIAL_WALL_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPIndustrialBlocks.INDUSTRIAL_WALL.get(),  AVPIndustrialBlocks.INDUSTRIAL_WALL_STAIRS.get()
        );
        generator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_WALL_HAZARD.get());
    }

    private static void addTempleBlockModels(BlockModelGenerators generator) {
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_BRICK.get());
        createSlabBlockModel(
            generator, AVPTempleBlocks.TEMPLE_BRICK.get(),  AVPTempleBlocks.TEMPLE_BRICK_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPTempleBlocks.TEMPLE_BRICK.get(),  AVPTempleBlocks.TEMPLE_BRICK_STAIRS.get()
        );
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_BRICK_CHESTBURSTER.get());
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_BRICK_FACEHUGGER.get());
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_BRICK_SINGLE.get());
        createSlabBlockModel(
            generator, AVPTempleBlocks.TEMPLE_BRICK_SINGLE.get(),  AVPTempleBlocks.TEMPLE_BRICK_SINGLE_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPTempleBlocks.TEMPLE_BRICK_SINGLE.get(),  AVPTempleBlocks.TEMPLE_BRICK_SINGLE_STAIRS.get()
        );
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_FLOOR.get());
        createSlabBlockModel(
            generator, AVPTempleBlocks.TEMPLE_FLOOR.get(),  AVPTempleBlocks.TEMPLE_FLOOR_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPTempleBlocks.TEMPLE_FLOOR.get(),  AVPTempleBlocks.TEMPLE_FLOOR_STAIRS.get()
        );
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_SKULLS.get());
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_TILE.get());
        createSlabBlockModel(
            generator, AVPTempleBlocks.TEMPLE_TILE.get(),  AVPTempleBlocks.TEMPLE_TILE_SLAB.get()
        );
        createStairBlockModel(
            generator, AVPTempleBlocks.TEMPLE_TILE.get(),  AVPTempleBlocks.TEMPLE_TILE_STAIRS.get()
        );
        generator.createTrivialCube(AVPTempleBlocks.TEMPLE_WALL_BASE.get());
    }

    private static void createSlabBlockModel(BlockModelGenerators generator, Block baseBlock, Block slabBlock) {
        var textureMapping = TexturedModel.CUBE.get(baseBlock).getMapping();
        var bottomResourceLocation =
            ModelTemplates.SLAB_BOTTOM.create(slabBlock, textureMapping, generator.modelOutput);
        var topResourceLocation =
            ModelTemplates.SLAB_TOP.create(slabBlock, textureMapping, generator.modelOutput);
        var doubleResourceLocation =
            ModelTemplates.CUBE.getDefaultModelLocation(baseBlock);

        generator.blockStateOutput.accept(
            BlockModelGenerators.createSlab(slabBlock, bottomResourceLocation, topResourceLocation, doubleResourceLocation)
        );
    }

    private static void createStairBlockModel(BlockModelGenerators generator, Block baseBlock, Block stairBlock) {
        var textureMapping = TexturedModel.CUBE.get(baseBlock).getMapping();
        var straightResourceLocation =
            ModelTemplates.STAIRS_STRAIGHT.create(stairBlock, textureMapping, generator.modelOutput);
        var innerResourceLocation =
            ModelTemplates.STAIRS_INNER.create(stairBlock, textureMapping, generator.modelOutput);
        var outerResourceLocation =
            ModelTemplates.STAIRS_OUTER.create(stairBlock, textureMapping, generator.modelOutput);

        generator.blockStateOutput.accept(
            BlockModelGenerators.createStairs(stairBlock, innerResourceLocation, straightResourceLocation, outerResourceLocation)
        );
    }

    private AVPFabricBlockModelProvider() {
        throw new UnsupportedOperationException();
    }
}
