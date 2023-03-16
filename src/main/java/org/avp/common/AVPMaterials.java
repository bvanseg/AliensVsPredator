package org.avp.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.avp.common.block.material.MaterialBlackGoo;
import org.avp.common.block.material.MaterialMist;

public class AVPMaterials implements IInitEvent
{
    public static final AVPMaterials instance = new AVPMaterials();

    public static final Material MIST = new MaterialMist();
    public static final Material BLACK_GOO = new MaterialBlackGoo();

    private AVPMaterials() {}

    //TODO: Armor enum textures, sounds, and toughness
    public static class Armors
    {
        private Armors() {}

        public static final ArmorMaterial CELTIC = EnumHelper.addArmorMaterial("celtic", "items.celtic", 34, new int[] { 4, 7, 5, 3 }, 20, null, 5);
        public static final ArmorMaterial CHITIN = EnumHelper.addArmorMaterial("chitin", "items.chitin", 30, new int[] { 2, 7, 5, 3 }, 7, null, 1);
        public static final ArmorMaterial KEVLAR = EnumHelper.addArmorMaterial("kevlar", "items.kevlar", 26, new int[] { 2, 6, 3, 2 }, 5, null, 2);
        public static final ArmorMaterial PRESSURE_SUIT = EnumHelper.addArmorMaterial("pressuresuit", "items.pressuresuit", 22, new int[] { 2, 4, 3, 2 }, 6, null, 1);
        public static final ArmorMaterial MK50 = EnumHelper.addArmorMaterial("mk50", "items.mk50", 24, new int[] { 2, 4, 3, 2 }, 6, null, 1);
    }

    public static class Tools
    {
        private Tools() {}

        public static final ToolMaterial CELTIC = EnumHelper.addToolMaterial("celtic", 12, 1430, 9.0F, 8.0F, 9);
        public static final ToolMaterial CHITIN = EnumHelper.addToolMaterial("chitin", 7, 730, 10.0F, 7.0F, 14);
    }

    @Override
    public void init(FMLInitializationEvent event) { /* Do Nothing */ }
}
