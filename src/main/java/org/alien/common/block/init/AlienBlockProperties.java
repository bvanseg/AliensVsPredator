package org.alien.common.block.init;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import org.alien.common.block.AlienSoundTypes;
import org.lib.common.block.BlockProperties;

/**
 * @author Boston Vanseghi
 */
public class AlienBlockProperties {

    public static final BlockProperties RESIN_PROPS = new BlockProperties(Material.CLAY)
            .setHardness(5.0F).setResistance(10.0F).setSoundType(AlienSoundTypes.RESIN).setFireInfo(5, 20);

    // Woods
    public static final BlockProperties WOOD_PLANK_PROPS = new BlockProperties(Material.WOOD)
            .setHardness(2.0F).setResistance(5.0F).setSoundType(SoundType.WOOD).setFireInfo(5, 20);
    public static final BlockProperties ENGINEER_PROPS = new BlockProperties(Material.IRON).setHardness(10F).setResistance(15.0F);
    static final BlockProperties RELIC_PROPS =  new BlockProperties(Material.ROCK).setHardness(5F).setResistance(15F);

    private AlienBlockProperties() {}
}
