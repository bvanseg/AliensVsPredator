package org.avp.common.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import org.avp.common.item.armor.material.AVPArmorMaterials;
import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPArmorItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPArmorItems INSTANCE = new AVPArmorItems();

    public static AVPArmorItems getInstance() {
        return INSTANCE;
    }

    public static GameObject<Item> ALUMINUM_BODY;

    public static GameObject<Item> ALUMINUM_BOOTS;

    public static GameObject<Item> ALUMINUM_HELMET;

    public static GameObject<Item> ALUMINUM_LEGGINGS;

    public static GameObject<Item> CELTIC_BODY;

    public static GameObject<Item> CELTIC_BOOTS;

    public static GameObject<Item> CELTIC_HELMET;

    public static GameObject<Item> CELTIC_LEGGINGS;

    public static GameObject<Item> MK50_BODY;

    public static GameObject<Item> MK50_BOOTS;

    public static GameObject<Item> MK50_HELMET;

    public static GameObject<Item> MK50_LEGGINGS;

    public static GameObject<Item> PRESSURE_BODY;

    public static GameObject<Item> PRESSURE_BOOTS;

    public static GameObject<Item> PRESSURE_HELMET;

    public static GameObject<Item> PRESSURE_LEGGINGS;

    public static GameObject<Item> TACTICAL_BODY;

    public static GameObject<Item> TACTICAL_BOOTS;

    public static GameObject<Item> TACTICAL_HELMET;

    public static GameObject<Item> TACTICAL_LEGGINGS;

    private AVPArmorItems() {}

    @Override
    public void register() {
        var aluminumMaterial = AVPArmorMaterials.getInstance().ALUMINUM;
        ALUMINUM_BODY = registerEntry(
            "armor_aluminum_body",
            () -> new ArmorItem(aluminumMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties())
        );
        ALUMINUM_BOOTS = registerEntry(
            "armor_aluminum_boots",
            () -> new ArmorItem(aluminumMaterial, ArmorItem.Type.BOOTS, new Item.Properties())
        );
        ALUMINUM_HELMET = registerEntry(
            "armor_aluminum_helmet",
            () -> new ArmorItem(aluminumMaterial, ArmorItem.Type.HELMET, new Item.Properties())
        );
        ALUMINUM_LEGGINGS = registerEntry(
            "armor_aluminum_leggings",
            () -> new ArmorItem(aluminumMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties())
        );

        var celticMaterial = AVPArmorMaterials.getInstance().CELTIC;
        CELTIC_BODY = registerEntry(
            "armor_celtic_body",
            () -> new ArmorItem(celticMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties())
        );
        CELTIC_BOOTS = registerEntry(
            "armor_celtic_boots",
            () -> new ArmorItem(celticMaterial, ArmorItem.Type.BOOTS, new Item.Properties())
        );
        CELTIC_HELMET = registerEntry(
            "armor_celtic_helmet",
            () -> new ArmorItem(celticMaterial, ArmorItem.Type.HELMET, new Item.Properties())
        );
        CELTIC_LEGGINGS = registerEntry(
            "armor_celtic_leggings",
            () -> new ArmorItem(celticMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties())
        );

        var mk50Material = AVPArmorMaterials.getInstance().MK50;
        MK50_BODY = registerEntry(
            "armor_mk50_body",
            () -> new ArmorItem(mk50Material, ArmorItem.Type.CHESTPLATE, new Item.Properties())
        );
        MK50_BOOTS = registerEntry(
            "armor_mk50_boots",
            () -> new ArmorItem(mk50Material, ArmorItem.Type.BOOTS, new Item.Properties())
        );
        MK50_HELMET = registerEntry(
            "armor_mk50_helmet",
            () -> new ArmorItem(mk50Material, ArmorItem.Type.HELMET, new Item.Properties())
        );
        MK50_LEGGINGS = registerEntry(
            "armor_mk50_leggings",
            () -> new ArmorItem(mk50Material, ArmorItem.Type.LEGGINGS, new Item.Properties())
        );

        var pressureMaterial = AVPArmorMaterials.getInstance().PRESSURE;
        PRESSURE_BODY = registerEntry(
            "armor_pressure_body",
            () -> new ArmorItem(pressureMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties())
        );
        PRESSURE_BOOTS = registerEntry(
            "armor_pressure_boots",
            () -> new ArmorItem(pressureMaterial, ArmorItem.Type.BOOTS, new Item.Properties())
        );
        PRESSURE_HELMET = registerEntry(
            "armor_pressure_helmet",
            () -> new ArmorItem(pressureMaterial, ArmorItem.Type.HELMET, new Item.Properties())
        );
        PRESSURE_LEGGINGS = registerEntry(
            "armor_pressure_leggings",
            () -> new ArmorItem(pressureMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties())
        );

        var tacticalMaterial = AVPArmorMaterials.getInstance().TACTICAL;
        TACTICAL_BODY = registerEntry(
            "armor_tactical_body",
            () -> new ArmorItem(tacticalMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties())
        );
        TACTICAL_BOOTS = registerEntry(
            "armor_tactical_boots",
            () -> new ArmorItem(tacticalMaterial, ArmorItem.Type.BOOTS, new Item.Properties())
        );
        TACTICAL_HELMET = registerEntry(
            "armor_tactical_helmet",
            () -> new ArmorItem(tacticalMaterial, ArmorItem.Type.HELMET, new Item.Properties())
        );
        TACTICAL_LEGGINGS = registerEntry(
            "armor_tactical_leggings",
            () -> new ArmorItem(tacticalMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties())
        );

        var xenomorphChitinMaterial = AVPArmorMaterials.getInstance().XENOMORPH_CHITIN;
        registerEntry(
            "armor_xenomorph_chitin_body",
            () -> new ArmorItem(xenomorphChitinMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties())
        );
        registerEntry(
            "armor_xenomorph_chitin_boots",
            () -> new ArmorItem(xenomorphChitinMaterial, ArmorItem.Type.BOOTS, new Item.Properties())
        );
        registerEntry(
            "armor_xenomorph_chitin_helmet",
            () -> new ArmorItem(xenomorphChitinMaterial, ArmorItem.Type.HELMET, new Item.Properties())
        );
        registerEntry(
            "armor_xenomorph_chitin_leggings",
            () -> new ArmorItem(xenomorphChitinMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties())
        );
    }
}
