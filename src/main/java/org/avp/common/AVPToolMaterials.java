package org.avp.common;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPToolMaterials {

    private AVPToolMaterials() {}

    public static final Item.ToolMaterial CELTIC = EnumHelper.addToolMaterial("celtic", 12, 1430, 9.0F, 8.0F, 9);
    public static final Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("copper", 2, 200, 5.0F, 1.5F, 13);
    public static final Item.ToolMaterial CHITIN = EnumHelper.addToolMaterial("chitin", 7, 730, 10.0F, 7.0F, 14);
}
