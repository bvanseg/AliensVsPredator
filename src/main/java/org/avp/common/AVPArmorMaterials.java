package org.avp.common;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPArmorMaterials {

    private AVPArmorMaterials() {}

    public static final ItemArmor.ArmorMaterial CELTIC = EnumHelper.addArmorMaterial("celtic", "items.celtic", 34, new int[] { 4, 7, 5, 3 }, 20, null, 5);
    public static final ItemArmor.ArmorMaterial CHITIN = EnumHelper.addArmorMaterial("chitin", "items.chitin", 30, new int[] { 2, 7, 5, 3 }, 7, null, 1);
    public static final ItemArmor.ArmorMaterial KEVLAR = EnumHelper.addArmorMaterial("kevlar", "items.kevlar", 26, new int[] { 2, 6, 3, 2 }, 5, null, 2);
    public static final ItemArmor.ArmorMaterial PRESSURE_SUIT = EnumHelper.addArmorMaterial("pressuresuit", "items.pressuresuit", 22, new int[] { 2, 4, 3, 2 }, 6, null, 1);
    public static final ItemArmor.ArmorMaterial MK50 = EnumHelper.addArmorMaterial("mk50", "items.mk50", 24, new int[] { 2, 4, 3, 2 }, 6, null, 1);
}
