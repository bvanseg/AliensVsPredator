package org.predator.common.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.util.EnumHelper;
import org.avp.common.config.ModelConfig;
import org.predator.common.entity.living.SpeciesYautja;

/**
 * @author Boston Vanseghi
 */
public class PredatorCreatureTypes {

    private PredatorCreatureTypes() {}

    private static EnumCreatureType PREDATOR;

    public static void init() {
        PREDATOR = createPredatorCreatureType();
    }

    private static EnumCreatureType createPredatorCreatureType() {
        boolean customCreatureTypesEnabled = ModelConfig.getInstance().getSpawning().customCreatureTypesEnabled;
        EnumCreatureType creatureType = EnumCreatureType.MONSTER; // Default fallback for predator creatures.

        if (customCreatureTypesEnabled) {
            creatureType = EnumHelper.addCreatureType("predator", SpeciesYautja.class, 12, Material.AIR, false, false);
        }

        return creatureType;
    }

    public static EnumCreatureType getPredatorCreatureType() {
        if (PREDATOR == null) {
            PREDATOR = createPredatorCreatureType();
        }
        return PREDATOR;
    }
}
