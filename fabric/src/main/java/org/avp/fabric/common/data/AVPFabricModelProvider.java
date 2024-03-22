package org.avp.fabric.common.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;

/**
 * @author Boston Vanseghi
 */
public class AVPFabricModelProvider extends FabricModelProvider {

    public AVPFabricModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        AVPFabricBlockModelProvider.addBlockModels(blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        AVPFabricItemModelProvider.addItemModels(itemModelGenerator);
    }
}
