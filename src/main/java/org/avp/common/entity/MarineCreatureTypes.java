package org.avp.common.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.util.EnumHelper;
import org.avp.common.config.ModelConfig;
import org.avp.common.entity.living.EntityMarine;

/**
 * @author Boston Vanseghi
 */
public class MarineCreatureTypes {

    private MarineCreatureTypes() {}

    private static EnumCreatureType MARINE;

    public static void init() {
        MARINE = createMarineCreatureType();
    }

    private static EnumCreatureType createMarineCreatureType() {
        boolean customCreatureTypesEnabled = ModelConfig.getInstance().getSpawning().customCreatureTypesEnabled;
        EnumCreatureType creatureType = EnumCreatureType.CREATURE; // Default fallback for marine creatures.

        if (customCreatureTypesEnabled) {
            creatureType = EnumHelper.addCreatureType("marine", EntityMarine.class, 20, Material.AIR, false, false);
        }

        return creatureType;
    }

    public static EnumCreatureType getMarineCreatureType() {
        if (MARINE == null) {
            MARINE = createMarineCreatureType();
        }
        return MARINE;
    }
}
