package org.alien.common.potion;

import net.minecraft.potion.Potion;

/**
 * @author Boston Vanseghi
 */
public class AcidPotionEffect extends Potion {

    protected AcidPotionEffect() {
        super(true, 0xFF_AE_AB_1A);
        setPotionName("effect.disintegration");
        setRegistryName("effect.disintegration");
        setIconIndex(6, 0);
    }
}
