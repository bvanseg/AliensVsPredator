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

    public static final EnumCreatureType ALIEN = EnumHelper.addCreatureType("alien", SpeciesAlien.class, 70, Material.AIR, false, false);
}
