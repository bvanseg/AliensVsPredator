package org.avp.common.item.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPArmorMaterials;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.item.ItemArmorMK50;
import org.avp.common.item.ItemArmorMarine;
import org.avp.common.item.ItemArmorPressureSuit;
import org.lib.common.registry.ItemRegistryUtil;

public class AVPArmorItems implements IPreInitEvent {
    public static final AVPArmorItems instance = new AVPArmorItems();

    private AVPArmorItems() {}

    public static final Item PRESSURE_MASK = new ItemArmorPressureSuit(0, EntityEquipmentSlot.HEAD).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("helm.pressure");
    public static final Item PRESSURE_CHEST = new ItemArmorPressureSuit(0, EntityEquipmentSlot.CHEST).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("body.pressure");
    public static final Item PRESSURE_PANTS = new ItemArmorPressureSuit(0, EntityEquipmentSlot.LEGS).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("legwear.pressure");
    public static final Item PRESSURE_BOOTS = new ItemArmorPressureSuit(0, EntityEquipmentSlot.FEET).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("boots.pressure");

    public static final Item MK_50_HELMET = new ItemArmorMK50(0, EntityEquipmentSlot.HEAD).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("helm.mk50");
    public static final Item MK_50_BODY = new ItemArmorMK50(0, EntityEquipmentSlot.CHEST).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("body.mk50");
    public static final Item MK_50_PANTS = new ItemArmorMK50(0, EntityEquipmentSlot.LEGS).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("legwear.mk50");
    public static final Item MK_50_BOOTS = new ItemArmorMK50(0, EntityEquipmentSlot.FEET).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("boots.mk50");

    public static final Item HELM_MARINE = new ItemArmorMarine(0, EntityEquipmentSlot.HEAD).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("helm.tactical");
    public static final Item PLATE_MARINE = new ItemArmorMarine(0, EntityEquipmentSlot.CHEST).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("body.tactical");
    public static final Item LEGS_MARINE = new ItemArmorMarine(0, EntityEquipmentSlot.LEGS).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("legwear.tactical");
    public static final Item BOOTS_MARINE = new ItemArmorMarine(0, EntityEquipmentSlot.FEET).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("boots.tactical");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerItems();
    }

    private void registerItems() {
        ItemRegistryUtil.registerItemWithModel(PRESSURE_MASK);
        ItemRegistryUtil.registerItemWithModel(PRESSURE_CHEST);
        ItemRegistryUtil.registerItemWithModel(PRESSURE_PANTS);
        ItemRegistryUtil.registerItemWithModel(PRESSURE_BOOTS);

        ItemRegistryUtil.registerItemWithModel(MK_50_HELMET);
        ItemRegistryUtil.registerItemWithModel(MK_50_BODY);
        ItemRegistryUtil.registerItemWithModel(MK_50_PANTS);
        ItemRegistryUtil.registerItemWithModel(MK_50_BOOTS);

        ItemRegistryUtil.registerItemWithModel(HELM_MARINE);
        ItemRegistryUtil.registerItemWithModel(PLATE_MARINE);
        ItemRegistryUtil.registerItemWithModel(LEGS_MARINE);
        ItemRegistryUtil.registerItemWithModel(BOOTS_MARINE);

        AVPArmorMaterials.ALUMINUM.setRepairItem(new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM));
        AVPArmorMaterials.COPPER.setRepairItem(new ItemStack(AVPItems.ITEM_INGOT_COPPER));

        AVPArmorMaterials.KEVLAR.setRepairItem(new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM));
        AVPArmorMaterials.PRESSURE_SUIT.setRepairItem(new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM));
        AVPArmorMaterials.MK50.setRepairItem(new ItemStack(AVPItems.ITEM_INGOT_COPPER));
    }
}
