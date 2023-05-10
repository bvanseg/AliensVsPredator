package org.alien.common.potion;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

import java.util.Collections;
import java.util.List;

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

    @Override
    public List<ItemStack> getCurativeItems() {
        return Collections.emptyList();
    }
}
