package org.avp.fabric.common.data;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
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

    public static void addBlockModels(BlockModelGenerators blockStateModelGenerator) {
        AVPBlocks.getEntries()
            .forEach(
                blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
            );
        AVPEngineerBlocks.getEntries()
            .forEach(
                blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
            );

        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_BRICK.get());
        createStairBlockModel(
            blockStateModelGenerator, AVPIndustrialBlocks.INDUSTRIAL_BRICK.get(),  AVPIndustrialBlocks.INDUSTRIAL_BRICK_STAIRS.get()
        );
        createSlabBlockModel(
            blockStateModelGenerator, AVPIndustrialBlocks.INDUSTRIAL_BRICK.get(),  AVPIndustrialBlocks.INDUSTRIAL_BRICK_SLAB.get()
        );
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_FLOOR_GRILL.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_GLASS.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_LAMP.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_0.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_1.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_METAL_PANEL_2.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_VENT.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_WALL.get());
        blockStateModelGenerator.createTrivialCube(AVPIndustrialBlocks.INDUSTRIAL_WALL_HAZARD.get());

        AVPOreBlocks.getEntries()
            .forEach(
                blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
            );
        AVPPaddingBlocks.getEntries()
            .forEach(
                blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
            );
        AVPParadiseBlocks.getEntries()
            .forEach(
                blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
            );
        AVPTempleBlocks.getEntries()
            .forEach(
                blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
            );
        AVPYautjaShipBlocks.getEntries()
            .forEach(
                blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
            );
    }

    private static void createSlabBlockModel(
        BlockModelGenerators blockStateModelGenerator,
        Block baseBlock,
        Block slabBlock
    ) {
        var textureMapping = TexturedModel.CUBE.get(baseBlock).getMapping();
        var bottomResourceLocation =
            ModelTemplates.SLAB_BOTTOM.create(slabBlock, textureMapping, blockStateModelGenerator.modelOutput);
        var topResourceLocation =
            ModelTemplates.SLAB_TOP.create(slabBlock, textureMapping, blockStateModelGenerator.modelOutput);
        var doubleResourceLocation =
            ModelTemplates.CUBE.getDefaultModelLocation(baseBlock);

        blockStateModelGenerator.blockStateOutput.accept(
            BlockModelGenerators.createSlab(slabBlock, bottomResourceLocation, topResourceLocation, doubleResourceLocation)
        );
    }

    private static void createStairBlockModel(
        BlockModelGenerators blockStateModelGenerator,
        Block baseBlock,
        Block stairBlock
    ) {
        var textureMapping = TexturedModel.CUBE.get(baseBlock).getMapping();
        var straightResourceLocation =
            ModelTemplates.STAIRS_STRAIGHT.create(stairBlock, textureMapping, blockStateModelGenerator.modelOutput);
        var innerResourceLocation =
            ModelTemplates.STAIRS_INNER.create(stairBlock, textureMapping, blockStateModelGenerator.modelOutput);
        var outerResourceLocation =
            ModelTemplates.STAIRS_OUTER.create(stairBlock, textureMapping, blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(
            BlockModelGenerators.createStairs(stairBlock, innerResourceLocation, straightResourceLocation, outerResourceLocation)
        );
    }

    private AVPFabricBlockModelProvider() {
        throw new UnsupportedOperationException();
    }
}
