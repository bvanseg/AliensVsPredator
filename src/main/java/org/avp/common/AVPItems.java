package org.avp.common;

import com.asx.mdx.core.mods.IPreInitEvent;
import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.item.*;
import org.avp.common.item.expansion.ItemLedDisplay;
import org.avp.common.item.expansion.ItemProcessor;
import org.avp.common.item.expansion.ItemSMGAmmo;
import org.avp.common.item.firearm.*;
import org.avp.common.item.rackmodule.*;
import org.avp.common.item.supply.chute.ItemSupplyChute;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.lib.registry.ItemRegistryUtil;

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
    public static final Item ITEM_GRENADE = new ItemGrenade(false).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("grenade.m40");
    public static final Item ITEM_INCENDIARY_GRENADE = new ItemGrenade(true).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("grenade.incindiary");
    public static final Item ITEM_AMMO_PISTOL = new ItemAmmunition(Classification.PISTOL).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.pistol");
    public static final Item ITEM_AMMO_AR = new ItemAmmunition(Classification.ASSAULT_RIFLE).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.ar");
    public static final Item ITEM_AMMO_SMG = new ItemSMGAmmo().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.smg");
    public static final Item ITEM_AMMO_SNIPER = new ItemAmmunition(Classification.RIFLE).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.sniper");
    public static final Item ITEM_PROPANE_TANK = new HookedItem().setMaxStackSize(1).setMaxDamage(64).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.flamethrower");
    public static final Item ITEM_M_240_ICU = new ItemM240IncineratorUnit(ITEM_PROPANE_TANK).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m240icu");
    public static final Item ITEM_SEVASTOPOL_FLAMETHROWER = new ItemSevastopolFlamethrower(ITEM_PROPANE_TANK).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.flamethrower.nostromo");
    public static final Item ITEM_PISTOL = new ItemFirearm(FirearmProfiles.PISTOL).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.pistol");
    public static final Item ITEM_M4 = new ItemFirearm(FirearmProfiles.M4).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m4");
    public static final Item ITEM_SNIPER = new ItemFirearm(FirearmProfiles.SNIPER).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.sniper");
    public static final Item ITEM_M41A = new ItemFirearm(FirearmProfiles.M41A).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m41a");
    public static final Item ITEM_M56SG = new ItemFirearm(FirearmProfiles.M56SG).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m56sg");
    public static final Item ITEM_AK47 = new ItemFirearm(FirearmProfiles.AK47).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.ak47");
    public static final Item ITEM_PISTOL_STOCK = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.pistol.stock");
    public static final Item ITEM_PISTOL_BARREL = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.pistol.barrel");
    public static final Item ITEM_PISTOL_ACTION = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.pistol.action");
    public static final Item ITEM_M4_STOCK = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m4.stock");
    public static final Item ITEM_M4_BARREL = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m4.barrel");
    public static final Item ITEM_M4_ACTION = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m4.action");
    public static final Item ITEM_SNIPER_STOCK = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.sniper.stock");
    public static final Item ITEM_SNIPER_BARREL = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.sniper.barrel");
    public static final Item ITEM_SNIPER_ACTION = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.sniper.action");
    public static final Item ITEM_SNIPER_SCOPE = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.sniper.scope");
    public static final Item ITEM_SNIPER_PERIPHERALS = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.sniper.peripherals");
    public static final Item ITEM_M41A_STOCK = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m41a.stock");
    public static final Item ITEM_M41A_BARREL = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m41a.barrel");
    public static final Item ITEM_M41A_ACTION = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m41a.action");
    public static final Item ITEM_M41A_PERIPHERALS = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m41a.peripherals");
    public static final Item ITEM_M56SG_STOCK = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m56sg.stock");
    public static final Item ITEM_M56SG_BARREL = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m56sg.barrel");
    public static final Item ITEM_M56SG_ACTION = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m56sg.action");
    public static final Item ITEM_M56SG_SUPPORT_FRAME = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m56sg.supportframe");
    public static final Item ITEM_M56SG_AIMING_MODULE = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.m56sg.aimingmodule");
    public static final Item ITEM_AK47_STOCK = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.ak47.stock");
    public static final Item ITEM_AK47_BARREL = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.ak47.barrel");
    public static final Item ITEM_AK47_ACTION = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.GUN_PARTS).setRegistryName("part.ak47.action");
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
    public static final Item RACK_MODULE_1 = new ItemNetworkRackModule1().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule1");
    public static final Item RACK_MODULE_2 = new ItemNetworkRackModule2().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule2");
    public static final Item RACK_MODULE_3 = new ItemNetworkRackModule3().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule3");
    public static final Item RACK_MODULE_4 = new ItemNetworkRackModule4().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule4");
    public static final Item RACK_MODULE_5 = new ItemNetworkRackModule5().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule5");
    public static final Item RACK_MODULE_6 = new ItemNetworkRackModule6().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule6");
    public static final Item RACK_MODULE_7 = new ItemNetworkRackModule7().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule7");
    public static final Item RACK_MODULE_8 = new ItemNetworkRackModule8().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("rackmodule8");
    public static final Item SUMMONER_MARINE = new ItemEntitySummoner(EntityMarine.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.marine");
    public static final Item SUMMONER_COMBAT_SYNTHETIC = new ItemEntitySummoner(EntityCombatSynthetic.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.synthetic.combat");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItem(PRESSURE_MASK);
        ItemRegistryUtil.registerItem(PRESSURE_CHEST);
        ItemRegistryUtil.registerItem(PRESSURE_PANTS);
        ItemRegistryUtil.registerItem(PRESSURE_BOOTS);

        ItemRegistryUtil.registerItem(MK_50_HELMET);
        ItemRegistryUtil.registerItem(MK_50_BODY);
        ItemRegistryUtil.registerItem(MK_50_PANTS);
        ItemRegistryUtil.registerItem(MK_50_BOOTS);

        ItemRegistryUtil.registerItem(HELM_MARINE);
        ItemRegistryUtil.registerItem(PLATE_MARINE);
        ItemRegistryUtil.registerItem(LEGS_MARINE);
        ItemRegistryUtil.registerItem(BOOTS_MARINE);

        ItemRegistryUtil.registerItem(ITEM_STUN_BATON);
        ItemRegistryUtil.registerItem(ITEM_GRENADE);
        ItemRegistryUtil.registerItem(ITEM_INCENDIARY_GRENADE);
        ItemRegistryUtil.registerItem(ITEM_AMMO_PISTOL);
        ItemRegistryUtil.registerItem(ITEM_AMMO_AR);
        ItemRegistryUtil.registerItem(ITEM_AMMO_SMG);
        ItemRegistryUtil.registerItem(ITEM_AMMO_SNIPER);
        ItemRegistryUtil.registerItem(ITEM_PROPANE_TANK);
        ItemRegistryUtil.registerItem(ITEM_M_240_ICU);
        ItemRegistryUtil.registerItem(ITEM_SEVASTOPOL_FLAMETHROWER);
        ItemRegistryUtil.registerItem(ITEM_PISTOL);
        ItemRegistryUtil.registerItem(ITEM_M4);
        ItemRegistryUtil.registerItem(ITEM_SNIPER);
        ItemRegistryUtil.registerItem(ITEM_M41A);
        ItemRegistryUtil.registerItem(ITEM_M56SG);
        ItemRegistryUtil.registerItem(ITEM_AK47);

        ItemRegistryUtil.registerItem(ITEM_PISTOL_STOCK);
        ItemRegistryUtil.registerItem(ITEM_PISTOL_BARREL);
        ItemRegistryUtil.registerItem(ITEM_PISTOL_ACTION);

        ItemRegistryUtil.registerItem(ITEM_M4_STOCK);
        ItemRegistryUtil.registerItem(ITEM_M4_BARREL);
        ItemRegistryUtil.registerItem(ITEM_M4_ACTION);

        ItemRegistryUtil.registerItem(ITEM_SNIPER_STOCK);
        ItemRegistryUtil.registerItem(ITEM_SNIPER_BARREL);
        ItemRegistryUtil.registerItem(ITEM_SNIPER_ACTION);
        ItemRegistryUtil.registerItem(ITEM_SNIPER_SCOPE);
        ItemRegistryUtil.registerItem(ITEM_SNIPER_PERIPHERALS);

        ItemRegistryUtil.registerItem(ITEM_M41A_STOCK);
        ItemRegistryUtil.registerItem(ITEM_M41A_BARREL);
        ItemRegistryUtil.registerItem(ITEM_M41A_ACTION);
        ItemRegistryUtil.registerItem(ITEM_M41A_PERIPHERALS);

        ItemRegistryUtil.registerItem(ITEM_M56SG_STOCK);
        ItemRegistryUtil.registerItem(ITEM_M56SG_BARREL);
        ItemRegistryUtil.registerItem(ITEM_M56SG_ACTION);
        ItemRegistryUtil.registerItem(ITEM_M56SG_SUPPORT_FRAME);
        ItemRegistryUtil.registerItem(ITEM_M56SG_AIMING_MODULE);

        ItemRegistryUtil.registerItem(ITEM_AK47_STOCK);
        ItemRegistryUtil.registerItem(ITEM_AK47_BARREL);
        ItemRegistryUtil.registerItem(ITEM_AK47_ACTION);

        ItemRegistryUtil.registerItem(ITEM_DORITOS);
        ItemRegistryUtil.registerItem(ITEM_DORITOS_COOL_RANCH);

        ItemRegistryUtil.registerItem(ITEM_FLASH_DRIVE);
        ItemRegistryUtil.registerItem(ITEM_CAPACITOR);
        ItemRegistryUtil.registerItem(ITEM_TRANSISTOR);
        ItemRegistryUtil.registerItem(ITEM_RAM);
        ItemRegistryUtil.registerItem(ITEM_RESISTOR);
        ItemRegistryUtil.registerItem(ITEM_PROCESSOR);
        ItemRegistryUtil.registerItem(ITEM_SOLID_STATE_DRIVE);
        ItemRegistryUtil.registerItem(ITEM_DIODE);
        ItemRegistryUtil.registerItem(ITEM_MOTHERBOARD);
        ItemRegistryUtil.registerItem(ITEM_POWER_SUPPLY);
        ItemRegistryUtil.registerItem(ITEM_LED_DISPLAY);
        ItemRegistryUtil.registerItem(ITEM_VOLTAGE_REGULATOR);
        ItemRegistryUtil.registerItem(ITEM_LED);
        ItemRegistryUtil.registerItem(ITEM_INTEGRATED_CIRCUIT);

        ItemRegistryUtil.registerItem(ITEM_SUPPLY_CHUTE);
        ItemRegistryUtil.registerItem(ITEM_SUPPLY_CHUTE_MARINES);
        ItemRegistryUtil.registerItem(ITEM_SUPPLY_CHUTE_SEEGSON);

        ItemRegistryUtil.registerItem(ITEM_APC);

        ItemRegistryUtil.registerItem(ITEM_CARBON);
        ItemRegistryUtil.registerItem(ITEM_COBALT);
        ItemRegistryUtil.registerItem(ITEM_NEODYMIUM);
        ItemRegistryUtil.registerItem(ITEM_NEODYMIUM_MAGNET);
        ItemRegistryUtil.registerItem(ITEM_SILICON);
        ItemRegistryUtil.registerItem(ITEM_INGOT_ALUMINUM);
        ItemRegistryUtil.registerItem(ITEM_INGOT_COPPER);
        ItemRegistryUtil.registerItem(ITEM_POLYCARBONATE);
        ItemRegistryUtil.registerItem(ITEM_INGOT_LITHIUM);

        ItemRegistryUtil.registerItem(ITEM_MOTION_TRACKER);
        ItemRegistryUtil.registerItem(ITEM_CHARGE_PACK);
        ItemRegistryUtil.registerItem(ITEM_MAINTENANCE_JACK);
        ItemRegistryUtil.registerItem(SECURITY_TUNER);

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
}
