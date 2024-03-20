package org.avp.fabric.common.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import org.avp.common.block.AVPBlocks;
import org.avp.common.block.AVPEngineerBlocks;
import org.avp.common.block.AVPIndustrialBlocks;
import org.avp.common.block.AVPPaddingBlocks;
import org.avp.common.block.AVPParadiseBlocks;
import org.avp.common.block.AVPTempleBlocks;
import org.avp.common.block.AVPYautjaShipBlocks;
import org.avp.common.item.AVPArmorItems;
import org.avp.common.item.AVPElectronicItems;
import org.avp.common.item.AVPFoodItems;
import org.avp.common.item.AVPItems;
import org.avp.common.item.AVPToolItems;
import org.avp.common.item.AVPWeaponItems;

/**
 * @author Boston Vanseghi
 */
public class AVPFabricModelProvider extends FabricModelProvider {
    public AVPFabricModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        AVPBlocks.getInstance().ENTRIES.forEach(
            blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
        );
        AVPEngineerBlocks.getInstance().ENTRIES.forEach(
            blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
        );
        AVPIndustrialBlocks.getInstance().ENTRIES.forEach(
            blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
        );
        AVPPaddingBlocks.getInstance().ENTRIES.forEach(
            blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
        );
        AVPParadiseBlocks.getInstance().ENTRIES.forEach(
            blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
        );
        AVPTempleBlocks.getInstance().ENTRIES.forEach(
            blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
        );
        AVPYautjaShipBlocks.getInstance().ENTRIES.forEach(
            blockGameObject -> blockStateModelGenerator.createTrivialCube(blockGameObject.get())
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        AVPArmorItems.getInstance().ENTRIES.forEach(
            itemGameObject -> itemModelGenerator.generateFlatItem(itemGameObject.get(), ModelTemplates.FLAT_ITEM)
        );
        AVPElectronicItems.getInstance().ENTRIES.forEach(
            itemGameObject -> itemModelGenerator.generateFlatItem(itemGameObject.get(), ModelTemplates.FLAT_ITEM)
        );
        AVPFoodItems.getInstance().ENTRIES.forEach(
            itemGameObject -> itemModelGenerator.generateFlatItem(itemGameObject.get(), ModelTemplates.FLAT_ITEM)
        );
        AVPItems.getInstance().ENTRIES.forEach(
            itemGameObject -> itemModelGenerator.generateFlatItem(itemGameObject.get(), ModelTemplates.FLAT_ITEM)
        );
        AVPToolItems.getInstance().ENTRIES.forEach(
            itemGameObject -> itemModelGenerator.generateFlatItem(itemGameObject.get(), ModelTemplates.FLAT_HANDHELD_ITEM)
        );
        AVPWeaponItems.getInstance().ENTRIES.forEach(
            itemGameObject -> itemModelGenerator.generateFlatItem(itemGameObject.get(), ModelTemplates.FLAT_HANDHELD_ITEM)
        );
    }
}