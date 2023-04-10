package org.alien.common.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.util.EnumHelper;
import org.alien.common.entity.living.SpeciesAlien;

/**
 * @author Boston Vanseghi
 */
public class AlienCreatureTypes {

    private AlienCreatureTypes() {}

    private static EnumCreatureType ALIEN;

    public static void init() {
        ALIEN = createAlienCreatureType();
    }

    private static EnumCreatureType createAlienCreatureType() {
        return EnumHelper.addCreatureType("alien", SpeciesAlien.class, 70, Material.AIR, false, false);
    }

    public static EnumCreatureType getAlienCreatureType() {
        if (ALIEN == null) {
            ALIEN = createAlienCreatureType();
        }
        return ALIEN;
    }
}
