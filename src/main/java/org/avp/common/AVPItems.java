package org.avp.common;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.minecraft.item.HookedItem;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.config.ModelConfig;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.item.*;
import org.avp.common.item.expansion.ItemLedDisplay;
import org.avp.common.item.expansion.ItemProcessor;
import org.avp.common.item.supply.chute.ItemSupplyChute;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.avp.common.network.packet.server.PacketSpawnNuke;
import org.lib.common.registry.ItemRegistryUtil;
import org.predator.common.item.ItemWristbracer;
import org.weapon.common.item.init.WeaponItems;

public class AVPItems implements IPreInitEvent {
    public static final AVPItems instance = new AVPItems();

    private AVPItems() {}

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
    public static final Item ITEM_STUN_BATON = new ItemStunBaton().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("stun.baton");
    public static final Item ITEM_DORITOS = new ItemFood(8, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.doritos");
    public static final Item ITEM_DORITOS_COOL_RANCH = new ItemFood(8, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.doritos.coolranch");
    public static final Item ITEM_FLASH_DRIVE = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("device.nbtdrive");
    public static final Item ITEM_CAPACITOR = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.capacitor");
    public static final Item ITEM_TRANSISTOR = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.transistor");
    public static final Item ITEM_RAM = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.ram");
    public static final Item ITEM_RESISTOR = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.resistor");
    public static final Item ITEM_PROCESSOR = new ItemProcessor().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.processor");
    public static final Item ITEM_SOLID_STATE_DRIVE = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.solidstatedrive");
    public static final Item ITEM_DIODE = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.diode");
    public static final Item ITEM_MOTHERBOARD = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.motherboard");
    public static final Item ITEM_POWER_SUPPLY = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.powersupply");
    public static final Item ITEM_LED_DISPLAY = new ItemLedDisplay().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.led.display");
    public static final Item ITEM_VOLTAGE_REGULATOR = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.regulator");
    public static final Item ITEM_LED = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.led");
    public static final Item ITEM_INTEGRATED_CIRCUIT = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("part.ic");
    public static final Item ITEM_SUPPLY_CHUTE = new ItemSupplyChute(SupplyChuteType.UNBRANDED).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("device.supplychute");
    public static final Item ITEM_SUPPLY_CHUTE_MARINES = new ItemSupplyChute(SupplyChuteType.MARINES).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("device.supplychute.marines");
    public static final Item ITEM_SUPPLY_CHUTE_SEEGSON = new ItemSupplyChute(SupplyChuteType.SEEGSON).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("device.supplychute.seegson");
    public static final Item ITEM_APC = new ItemAPC().setCreativeTab(AVPCreativeTabs.MAIN).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("apc");
    public static final Item ITEM_CARBON = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("carbon");
    public static final Item ITEM_COBALT = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("cobalt");
    public static final Item ITEM_NEODYMIUM = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("neodymium");
    public static final Item ITEM_NEODYMIUM_MAGNET = new HookedItem().setMaxStackSize(16).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("neodymium.magnet");
    public static final Item ITEM_SILICON = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("silicon");
    public static final Item ITEM_INGOT_ALUMINUM = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("ingot.aluminum");
    public static final Item ITEM_INGOT_COPPER = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("ingot.copper");
    public static final Item ITEM_POLYCARBONATE = new HookedItem().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("polycarbonate");
    public static final Item ITEM_INGOT_LITHIUM = new ItemIngotLithium().setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("ingot.lithium");
    public static final Item ITEM_MOTION_TRACKER = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("motiontracker");
    public static final Item ITEM_CHARGE_PACK = new HookedItem().setMaxDamage(64).setMaxStackSize(1).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("chargepack");
    public static final Item ITEM_MAINTENANCE_JACK = new ItemMaintenanceJack().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.maintenancejack");
    public static final Item SECURITY_TUNER = new HookedItem().setMaxStackSize(1).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.securitytuner");
    public static final Item RACK_MODULE_1 = new ItemNetworkRackModule(0).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule1");
    public static final Item RACK_MODULE_2 = new ItemNetworkRackModule(1).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule2");
    public static final Item RACK_MODULE_3 = new ItemNetworkRackModule(2).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule3");
    public static final Item RACK_MODULE_4 = new ItemNetworkRackModule(3).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule4");
    public static final Item RACK_MODULE_5 = new ItemNetworkRackModule(4).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule5");
    public static final Item RACK_MODULE_6 = new ItemNetworkRackModule(5).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule6");
    public static final Item RACK_MODULE_7 = new ItemNetworkRackModule(6).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule7");
    public static final Item RACK_MODULE_8 = new ItemNetworkRackModule(7).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule8");
    public static final Item SUMMONER_MARINE = new ItemEntitySummoner(EntityMarine.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.marine");
    public static final Item SUMMONER_COMBAT_SYNTHETIC = new ItemEntitySummoner(EntityCombatSynthetic.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.synthetic.combat");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerItems();
        this.registerWristbracerCodes();

        // Register weapon items.
        WeaponItems.instance.pre(event);
    }

    private static void registerItems() {
        ItemRegistryUtil.registerItemWithIcon(PRESSURE_MASK);
        ItemRegistryUtil.registerItemWithIcon(PRESSURE_CHEST);
        ItemRegistryUtil.registerItemWithIcon(PRESSURE_PANTS);
        ItemRegistryUtil.registerItemWithIcon(PRESSURE_BOOTS);

        ItemRegistryUtil.registerItemWithIcon(MK_50_HELMET);
        ItemRegistryUtil.registerItemWithIcon(MK_50_BODY);
        ItemRegistryUtil.registerItemWithIcon(MK_50_PANTS);
        ItemRegistryUtil.registerItemWithIcon(MK_50_BOOTS);

        ItemRegistryUtil.registerItemWithIcon(HELM_MARINE);
        ItemRegistryUtil.registerItemWithIcon(PLATE_MARINE);
        ItemRegistryUtil.registerItemWithIcon(LEGS_MARINE);
        ItemRegistryUtil.registerItemWithIcon(BOOTS_MARINE);

        ItemRegistryUtil.registerItem(ITEM_STUN_BATON);

        ItemRegistryUtil.registerItemWithIcon(ITEM_DORITOS);
        ItemRegistryUtil.registerItemWithIcon(ITEM_DORITOS_COOL_RANCH);

        ItemRegistryUtil.registerItemWithIcon(ITEM_FLASH_DRIVE);
        ItemRegistryUtil.registerItemWithIcon(ITEM_CAPACITOR);
        ItemRegistryUtil.registerItemWithIcon(ITEM_TRANSISTOR);
        ItemRegistryUtil.registerItemWithIcon(ITEM_RAM);
        ItemRegistryUtil.registerItemWithIcon(ITEM_RESISTOR);
        ItemRegistryUtil.registerItemWithIcon(ITEM_PROCESSOR);
        ItemRegistryUtil.registerItemWithIcon(ITEM_SOLID_STATE_DRIVE);
        ItemRegistryUtil.registerItemWithIcon(ITEM_DIODE);
        ItemRegistryUtil.registerItemWithIcon(ITEM_MOTHERBOARD);
        ItemRegistryUtil.registerItemWithIcon(ITEM_POWER_SUPPLY);
        ItemRegistryUtil.registerItemWithIcon(ITEM_LED_DISPLAY);
        ItemRegistryUtil.registerItemWithIcon(ITEM_VOLTAGE_REGULATOR);
        ItemRegistryUtil.registerItemWithIcon(ITEM_LED);
        ItemRegistryUtil.registerItemWithIcon(ITEM_INTEGRATED_CIRCUIT);

        ItemRegistryUtil.registerItem(ITEM_SUPPLY_CHUTE);
        ItemRegistryUtil.registerItem(ITEM_SUPPLY_CHUTE_MARINES);
        ItemRegistryUtil.registerItem(ITEM_SUPPLY_CHUTE_SEEGSON);

        ItemRegistryUtil.registerItem(ITEM_APC);

        ItemRegistryUtil.registerItemWithIcon(ITEM_CARBON);
        ItemRegistryUtil.registerItemWithIcon(ITEM_COBALT);
        ItemRegistryUtil.registerItemWithIcon(ITEM_NEODYMIUM);
        ItemRegistryUtil.registerItemWithIcon(ITEM_NEODYMIUM_MAGNET);
        ItemRegistryUtil.registerItemWithIcon(ITEM_SILICON);
        ItemRegistryUtil.registerItemWithIcon(ITEM_INGOT_ALUMINUM);
        ItemRegistryUtil.registerItemWithIcon(ITEM_INGOT_COPPER);
        ItemRegistryUtil.registerItemWithIcon(ITEM_POLYCARBONATE);
        ItemRegistryUtil.registerItemWithIcon(ITEM_INGOT_LITHIUM);

        ItemRegistryUtil.registerItem(ITEM_MOTION_TRACKER);
        ItemRegistryUtil.registerItemWithIcon(ITEM_CHARGE_PACK);
        ItemRegistryUtil.registerItemWithIcon(ITEM_MAINTENANCE_JACK);
        ItemRegistryUtil.registerItemWithIcon(SECURITY_TUNER);

        ItemRegistryUtil.registerItem(RACK_MODULE_1);
        ItemRegistryUtil.registerItem(RACK_MODULE_2);
        ItemRegistryUtil.registerItem(RACK_MODULE_3);
        ItemRegistryUtil.registerItem(RACK_MODULE_4);
        ItemRegistryUtil.registerItem(RACK_MODULE_5);
        ItemRegistryUtil.registerItem(RACK_MODULE_6);
        ItemRegistryUtil.registerItem(RACK_MODULE_7);
        ItemRegistryUtil.registerItem(RACK_MODULE_8);

        ItemRegistryUtil.registerItem(SUMMONER_MARINE);
        ItemRegistryUtil.registerItem(SUMMONER_COMBAT_SYNTHETIC);
    }

    private void registerWristbracerCodes() {
        ItemWristbracer.addCode(ModelConfig.getInstance().getGeneral().wristbracerNukeCode, (combination, args) -> {
            AVPNetworking.instance.sendToServer(new PacketSpawnNuke());
            ClientGame.instance.minecraft().currentScreen = null;
        });
    }
}
