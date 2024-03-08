package org.avp.common.item.armor.material;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import org.avp.common.item.AVPItems;

/**
 * @author Boston Vanseghi
 */
public class AVPArmorMaterials {

    private static final AVPArmorMaterials INSTANCE = new AVPArmorMaterials();

    public final ArmorMaterial ALUMINUM = new AVPArmorMaterial.Builder("aluminum", SoundEvents.ARMOR_EQUIP_IRON, () -> AVPItems.getInstance().INGOT_ALUMINUM.get())
        .setProtectionValues(new int[] {2, 5, 5, 2})
        .setDurabilityMultiplier(14)
        .setEnchantmentValue(10)
        .build();

    public static AVPArmorMaterials getInstance() {
        return INSTANCE;
    }
}
