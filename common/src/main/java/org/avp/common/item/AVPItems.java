package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPItems INSTANCE = new AVPItems();

    public static AVPItems getInstance() {
        return INSTANCE;
    }

    public static GameObject<Item> CARBON;

    public static GameObject<Item> COBALT;

    public static GameObject<Item> INGOT_ALUMINUM;

    public static GameObject<Item> INGOT_LITHIUM;

    public static GameObject<Item> LASER_MINE;

    public static GameObject<Item> NBT_DRIVE;

    public static GameObject<Item> NEODYMIUM;

    public static GameObject<Item> NEODYMIUM_MAGNET;

    public static GameObject<Item> POLYCARBONATE;

    public static GameObject<Item> RAW_BAUXITE;

    public static GameObject<Item> ROYAL_JELLY;

    public static GameObject<Item> SHURIKEN;

    public static GameObject<Item> SILICA;

    public static GameObject<Item> SMART_DISC;

    public static GameObject<Item> YAUTJA_ARTIFACT;

    private AVPItems() {}

    @Override
    public void register() {
        CARBON = registerEntry("carbon", () -> new Item(new Item.Properties()));
        COBALT = registerEntry("cobalt", () -> new Item(new Item.Properties()));
        INGOT_ALUMINUM = registerEntry("ingot_aluminum", () -> new Item(new Item.Properties()));
        INGOT_LITHIUM = registerEntry("ingot_lithium", () -> new Item(new Item.Properties()));
        LASER_MINE = registerEntry("laser_mine", () -> new Item(new Item.Properties()));
        NBT_DRIVE = registerEntry("nbt_drive", () -> new Item(new Item.Properties()));
        NEODYMIUM = registerEntry("neodymium", () -> new Item(new Item.Properties()));
        NEODYMIUM_MAGNET = registerEntry("neodymium_magnet", () -> new Item(new Item.Properties()));
        POLYCARBONATE = registerEntry("polycarbonate", () -> new Item(new Item.Properties()));
        RAW_BAUXITE = registerEntry("raw_bauxite", () -> new Item(new Item.Properties()));
        ROYAL_JELLY = registerEntry("royal_jelly", () -> new Item(new Item.Properties()));
        SHURIKEN = registerEntry("shuriken", () -> new Item(new Item.Properties()));
        SILICA = registerEntry("silica", () -> new Item(new Item.Properties()));
        SMART_DISC = registerEntry("smart_disc", () -> new Item(new Item.Properties()));
        YAUTJA_ARTIFACT = registerEntry("yautja_artifact", () -> new Item(new Item.Properties()));
    }
}
