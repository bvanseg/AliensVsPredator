package org.predator.common;

import com.asx.mdx.common.minecraft.item.HookedItem;
import com.asx.mdx.common.minecraft.item.ItemToolMaterialAxe;
import com.asx.mdx.common.minecraft.item.ItemToolMaterialPickaxe;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPArmorMaterials;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.AVPToolMaterials;
import org.avp.common.item.ItemEntitySummoner;
import org.lib.common.registry.ItemRegistryUtil;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;
import org.predator.common.item.*;

public class PredatorItems implements IPreInitEvent {
    public static final PredatorItems instance = new PredatorItems();

    private PredatorItems() {}

    public static final Item BIOMASK_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.HEAD).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("helm.celtic");
    public static final Item CHESTPLATE_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.CHEST).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("body.celtic");
    public static final Item LEGS_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.LEGS).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("legwear.celtic");
    public static final Item BOOTS_CELTIC = new ItemArmorCeltic(0, EntityEquipmentSlot.FEET).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("boots.celtic");
    public static final Item SHOVEL_CELTIC = new ItemSpade(AVPToolMaterials.CELTIC).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.celtic.shovel");
    public static final Item PICKAXE_CELTIC = new ItemToolMaterialPickaxe(AVPToolMaterials.CELTIC).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.celtic.pick");
    public static final Item AXE_CELTIC = new ItemToolMaterialAxe(AVPToolMaterials.CELTIC).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.celtic.axe");
    public static final Item SWORD_CELTIC = new ItemSword(AVPToolMaterials.CELTIC).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.celtic.sword");
    public static final Item HOE_CELTIC = new ItemHoe(AVPToolMaterials.CELTIC).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.celtic.hoe");
    public static final Item ITEM_SPEAR = new ItemSpear(AVPToolMaterials.CELTIC).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("tool.celtic.spear");
    public static final Item ITEM_WRISTBRACER = new ItemWristbracer().setMaxStackSize(1).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("wristblade");
    public static final Item ITEM_WRISTBRACER_BLADES = new HookedItem().setMaxStackSize(1).setMaxDamage(AVPToolMaterials.CELTIC.getMaxUses()).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("wristbracer.blades");
    public static final Item ITEM_PLASMA_CANNON = new ItemPlasmaCannon().setFull3D().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("plasmacannon");
    public static final Item ITEM_PROXIMITY_MINE = new ItemLaserMine().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("mine.laser");
    public static final Item ITEM_DISC = new ItemDisc().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("smartdisc");
    public static final Item ITEM_SHURIKEN = new ItemShuriken().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("shuriken");
    public static final Item ITEM_ARTIFACT_TECH = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.CRAFTING).setRegistryName("artifact.tech");

    public static final Item SUMMONER_YAUTJA_WARRIOR = new ItemEntitySummoner<>(EntityYautjaWarrior.class, EntityYautjaWarrior::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.yautja.warrior");
    public static final Item SUMMONER_YAUTJA_BERSERKER = new ItemEntitySummoner<>(EntityYautjaBerserker.class, EntityYautjaBerserker::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.yautja.berserker");

    /* Experimental */
    public static final Item SUMMONER_PREDATOR_HOUND = new ItemEntitySummoner<>(EntityPredatorHound.class, EntityPredatorHound::new).setRegistryName("summon.predatorhound");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItemWithModel(BIOMASK_CELTIC);
        ItemRegistryUtil.registerItemWithModel(CHESTPLATE_CELTIC);
        ItemRegistryUtil.registerItemWithModel(LEGS_CELTIC);
        ItemRegistryUtil.registerItemWithModel(BOOTS_CELTIC);

        ItemRegistryUtil.registerItemWithModel(SHOVEL_CELTIC);
        ItemRegistryUtil.registerItemWithModel(PICKAXE_CELTIC);
        ItemRegistryUtil.registerItemWithModel(AXE_CELTIC);
        ItemRegistryUtil.registerItemWithModel(SWORD_CELTIC);
        ItemRegistryUtil.registerItemWithModel(HOE_CELTIC);
        ItemRegistryUtil.registerItem(ITEM_SPEAR);
        ItemRegistryUtil.registerItem(ITEM_WRISTBRACER);
        ItemRegistryUtil.registerItem(ITEM_WRISTBRACER_BLADES);

        ItemRegistryUtil.registerItem(ITEM_PLASMA_CANNON);
        ItemRegistryUtil.registerItemWithModel(ITEM_PROXIMITY_MINE);
        ItemRegistryUtil.registerItemWithModel(ITEM_DISC);
        ItemRegistryUtil.registerItemWithModel(ITEM_SHURIKEN);

        ItemRegistryUtil.registerItemWithModel(ITEM_ARTIFACT_TECH);

        ItemRegistryUtil.registerItem(SUMMONER_YAUTJA_WARRIOR);
        ItemRegistryUtil.registerItem(SUMMONER_YAUTJA_BERSERKER);

        /* Experimental */
        ItemRegistryUtil.registerItem(SUMMONER_PREDATOR_HOUND, true);

        /* Repairs */
        AVPArmorMaterials.CELTIC.setRepairItem(new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH));

        AVPToolMaterials.CELTIC.setRepairItem(new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH));
    }
}
