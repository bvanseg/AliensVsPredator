package org.predator.common;

import com.asx.mdx.core.mods.IPreInitEvent;
import com.asx.mdx.lib.world.item.HookedItem;
import com.asx.mdx.lib.world.item.ItemToolMaterialAxe;
import com.asx.mdx.lib.world.item.ItemToolMaterialPickaxe;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.AVP;
import org.avp.common.Tab;
import org.avp.common.item.ItemEntitySummoner;
import org.lib.ItemRegistryUtil;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;
import org.predator.common.item.*;

public class PredatorItems implements IPreInitEvent {
    public static final PredatorItems instance = new PredatorItems();

    private PredatorItems() {}

    public static final Item BIOMASK_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.HEAD).setCreativeTab(Tab.MAIN).setRegistryName("helm.celtic");
    public static final Item CHESTPLATE_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.CHEST).setCreativeTab(Tab.MAIN).setRegistryName("body.celtic");
    public static final Item LEGS_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.LEGS).setCreativeTab(Tab.MAIN).setRegistryName("legwear.celtic");
    public static final Item BOOTS_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.FEET).setCreativeTab(Tab.MAIN).setRegistryName("boots.celtic");
    public static final Item SHOVEL_CELTIC = new ItemSpade(AVP.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.shovel");
    public static final Item PICKAXE_CELTIC = new ItemToolMaterialPickaxe(AVP.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.pick");
    public static final Item AXE_CELTIC = new ItemToolMaterialAxe(AVP.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.axe");
    public static final Item SWORD_CELTIC = new ItemSword(AVP.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.sword");
    public static final Item HOE_CELTIC = new ItemHoe(AVP.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.hoe");
    public static final Item ITEM_SPEAR = new ItemSpear(AVP.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.spear");
    public static final Item ITEM_WRISTBRACER = new ItemWristbracer().setMaxStackSize(1).setCreativeTab(Tab.MAIN).setRegistryName("wristblade");
    public static final Item ITEM_WRISTBRACER_BLADES = new HookedItem().setMaxStackSize(1).setMaxDamage(AVP.materials().tools().celtic.getMaxUses()).setCreativeTab(Tab.MAIN).setRegistryName("wristbracer.blades");
    public static final Item ITEM_PLASMA_CANNON = new ItemPlasmaCannon().setFull3D().setCreativeTab(Tab.MAIN).setRegistryName("plasmacannon");
    public static final Item ITEM_PROXIMITY_MINE = new ItemLaserMine().setCreativeTab(Tab.MAIN).setRegistryName("mine.laser");
    public static final Item ITEM_DISC = new ItemDisc().setCreativeTab(Tab.MAIN).setRegistryName("smartdisc");
    public static final Item ITEM_SHURIKEN = new ItemShuriken().setCreativeTab(Tab.MAIN).setRegistryName("shuriken");
    public static final Item ITEM_ARTIFACT_TECH = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("artifact.tech");

    public static final Item SUMMONER_YAUTJA_WARRIOR = new ItemEntitySummoner(EntityYautjaWarrior.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.yautja.warrior");
    public static final Item SUMMONER_YAUTJA_BERSERKER = new ItemEntitySummoner(EntityYautjaBerserker.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.yautja.berserker");

    /* Experimental */
    public static final Item SUMMONER_PREDATOR_HOUND = new ItemEntitySummoner(EntityPredatorHound.class).setRegistryName("summon.predatorhound");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItem(BIOMASK_CELTIC);
        ItemRegistryUtil.registerItem(CHESTPLATE_CELTIC);
        ItemRegistryUtil.registerItem(LEGS_CELTIC);
        ItemRegistryUtil.registerItem(BOOTS_CELTIC);

        ItemRegistryUtil.registerItem(SHOVEL_CELTIC);
        ItemRegistryUtil.registerItem(PICKAXE_CELTIC);
        ItemRegistryUtil.registerItem(AXE_CELTIC);
        ItemRegistryUtil.registerItem(SWORD_CELTIC);
        ItemRegistryUtil.registerItem(HOE_CELTIC);
        ItemRegistryUtil.registerItem(ITEM_SPEAR);
        ItemRegistryUtil.registerItem(ITEM_WRISTBRACER);
        ItemRegistryUtil.registerItem(ITEM_WRISTBRACER_BLADES);

        ItemRegistryUtil.registerItem(ITEM_PLASMA_CANNON);
        ItemRegistryUtil.registerItem(ITEM_PROXIMITY_MINE);
        ItemRegistryUtil.registerItem(ITEM_DISC);
        ItemRegistryUtil.registerItem(ITEM_SHURIKEN);

        ItemRegistryUtil.registerItem(ITEM_ARTIFACT_TECH);

        ItemRegistryUtil.registerItem(SUMMONER_YAUTJA_WARRIOR);
        ItemRegistryUtil.registerItem(SUMMONER_YAUTJA_BERSERKER);

        /* Experimental */
        ItemRegistryUtil.registerItem(SUMMONER_PREDATOR_HOUND, true);
    }
}
