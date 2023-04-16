package org.weapon.common.item.init;

import com.asx.mdx.common.minecraft.item.HookedItem;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.item.expansion.ItemSMGAmmo;
import org.lib.common.registry.ItemRegistryUtil;
import org.weapon.common.item.ItemGrenade;
import org.weapon.common.item.firearm.ItemFirearm;
import org.weapon.common.item.firearm.ItemM240IncineratorUnit;
import org.weapon.common.item.firearm.ItemSevastopolFlamethrower;
import org.weapon.common.item.firearm.rework.AVPFirearmProperties;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class WeaponItems implements IPreInitEvent {
    public static final WeaponItems instance = new WeaponItems();

    private WeaponItems() {}

    public static final Item ITEM_GRENADE = new ItemGrenade(false).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("grenade.m40");
    public static final Item ITEM_INCENDIARY_GRENADE = new ItemGrenade(true).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("grenade.incindiary");
    public static final Item ITEM_AMMO_PISTOL = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.pistol");
    public static final Item ITEM_AMMO_AR = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.ar");
    public static final ItemSMGAmmo ITEM_AMMO_SMG = (ItemSMGAmmo) new ItemSMGAmmo().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.smg");
    public static final Item ITEM_AMMO_SNIPER = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.sniper");
    public static final Item ITEM_PROPANE_TANK = new HookedItem().setMaxStackSize(1).setMaxDamage(64).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ammo.flamethrower");
    public static final Item ITEM_M_240_ICU = new ItemM240IncineratorUnit(ITEM_PROPANE_TANK).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m240icu");
    public static final Item ITEM_SEVASTOPOL_FLAMETHROWER = new ItemSevastopolFlamethrower(ITEM_PROPANE_TANK).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.flamethrower.nostromo");
    public static final Item ITEM_PISTOL = new ItemFirearm(AVPFirearmProperties.PISTOL_PROPERTIES).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.pistol");
    public static final Item ITEM_M4 = new ItemFirearm(AVPFirearmProperties.M4_PROPERTIES).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m4");
    public static final Item ITEM_SNIPER = new ItemFirearm(AVPFirearmProperties.SNIPER_PROPERTIES).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.sniper");
    public static final Item ITEM_M41A = new ItemFirearm(AVPFirearmProperties.M41A_PULSE_RIFLE_PROPERTIES).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m41a");
    public static final Item ITEM_M56SG = new ItemFirearm(AVPFirearmProperties.M56SG_PROPERTIES).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.m56sg");
    public static final Item ITEM_AK47 = new ItemFirearm(AVPFirearmProperties.AK47_PROPERTIES).setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gun.ak47");
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

    @Override
    public void pre(FMLPreInitializationEvent event) {
        ItemRegistryUtil.registerItem(ITEM_GRENADE);
        ItemRegistryUtil.registerItem(ITEM_INCENDIARY_GRENADE);
        ItemRegistryUtil.registerItemWithIcon(ITEM_AMMO_PISTOL);
        ItemRegistryUtil.registerItemWithIcon(ITEM_AMMO_AR);
        ItemRegistryUtil.registerItemWithIcon(ITEM_AMMO_SMG);
        ItemRegistryUtil.registerItemWithIcon(ITEM_AMMO_SNIPER);
        ItemRegistryUtil.registerItemWithIcon(ITEM_PROPANE_TANK);
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
    }
}
