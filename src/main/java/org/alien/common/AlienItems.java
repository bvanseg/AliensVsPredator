package org.alien.common;

import com.asx.mdx.common.minecraft.item.HookedItem;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.burster.*;
import org.alien.common.entity.living.xenomorph.exotic.*;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityDracoEgg;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorphGiger;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.alien.common.item.ItemArmorXeno;
import org.avp.common.AVPArmorMaterials;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.AVPToolMaterials;
import org.avp.common.item.ItemEntitySummoner;
import org.lib.common.registry.ItemRegistryUtil;

public class AlienItems implements IPreInitEvent {
    public static final AlienItems instance = new AlienItems();

    private AlienItems() {}

    public static final Item HELM_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.HEAD).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("helm.xeno");
    public static final Item PLATE_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.CHEST).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("body.xeno");
    public static final Item LEGS_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.LEGS).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("legwear.xeno");
    public static final Item BOOTS_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.FEET).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("boots.xeno");
    public static final Item ITEM_ROYAL_JELLY = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("royaljelly");
    public static final Item SUMMONER_DRONE = new ItemEntitySummoner<>(EntityDrone.class, EntityDrone::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.drone");
    public static final Item SUMMONER_AQUA = new ItemEntitySummoner<>(EntityNauticomorph.class, EntityNauticomorph::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.aqua");
    public static final Item SUMMONER_WARRIOR = new ItemEntitySummoner<>(EntityWarrior.class, EntityWarrior::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.warrior");
    public static final Item SUMMONER_CRUSHER = new ItemEntitySummoner<>(EntityCrusher.class, EntityCrusher::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.crusher");
    public static final Item SUMMONER_SPITTER = new ItemEntitySummoner<>(EntitySpitter.class, EntitySpitter::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.spitter");
    public static final Item SUMMONER_PRAETORIAN = new ItemEntitySummoner<>(EntityPraetorian.class, EntityPraetorian::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.praetorian");
    public static final Item SUMMONER_QUEEN = new ItemEntitySummoner<>(EntityMatriarch.class, EntityMatriarch::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.queen");
    public static final Item SUMMONER_CHESTBURSTER = new ItemEntitySummoner<>(EntityChestburster.class, EntityChestburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster");
    public static final Item SUMMONER_FACEHUGGER = new ItemEntitySummoner<>(EntityFacehugger.class, EntityFacehugger::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.facehugger");
    public static final Item SUMMONER_OVAMORPH = new ItemEntitySummoner<>(EntityOvamorph.class, EntityOvamorph::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.ovamorph");
    public static final Item SUMMONER_OVAMORPH_GIGER = new ItemEntitySummoner<>(EntityOvamorphGiger.class, EntityOvamorphGiger::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.ovamorph.giger");
    public static final Item SUMMONER_ROYAL_FACEHUGGER = new ItemEntitySummoner<>(EntityRoyalFacehugger.class, EntityRoyalFacehugger::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.royalfacehugger");
    public static final Item SUMMONER_PREDALIEN = new ItemEntitySummoner<>(EntityPredalien.class, EntityPredalien::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.predalien");
    public static final Item SUMMONER_RUNNER_DRONE = new ItemEntitySummoner<>(EntityRunnerDrone.class, EntityRunnerDrone::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.runner.drone");
    public static final Item SUMMONER_RUNNER_WARRIOR = new ItemEntitySummoner<>(EntityRunnerWarrior.class, EntityRunnerWarrior::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.runner.warrior");
    public static final Item SUMMONER_AETHON = new ItemEntitySummoner<>(EntityAethon.class, EntityAethon::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.aethon");
    public static final Item SUMMONER_PREDALIEN_BURSTER = new ItemEntitySummoner<>(EntityPredalienChestburster.class, EntityPredalienChestburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.predalien");
    public static final Item SUMMONER_QUEEN_BURSTER = new ItemEntitySummoner<>(EntityQueenChestburster.class, EntityQueenChestburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.queen");
    public static final Item SUMMONER_RUNNER_BURSTER = new ItemEntitySummoner<>(EntityRunnerChestburster.class, EntityRunnerChestburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.runner");

    /* Experimental */
    public static final Item SUMMONER_BAT_XENO = new ItemEntitySummoner<>(EntityBatXeno.class, EntityBatXeno::new).setRegistryName("summon.batxeno");
    public static final Item SUMMONER_BOILER = new ItemEntitySummoner<>(EntityBoiler.class, EntityBoiler::new).setRegistryName("summon.boiler");
    public static final Item SUMMONER_DRACOBURSTER = new ItemEntitySummoner<>(EntityDracoburster.class, EntityDracoburster::new).setRegistryName("summon.dracoburster");
    public static final Item SUMMONER_DRACO_EGG = new ItemEntitySummoner<>(EntityDracoEgg.class, EntityDracoEgg::new).setRegistryName("summon.dracoegg");
    public static final Item SUMMONER_DRACOMORPH = new ItemEntitySummoner<>(EntityDracomorph.class, EntityDracomorph::new).setRegistryName("summon.dracomorph");
    public static final Item SUMMONER_MYCELIOMORPH = new ItemEntitySummoner<>(EntityMyceliomorph.class, EntityMyceliomorph::new).setRegistryName("summon.myceliomorph");
    public static final Item SUMMONER_PANTHERAMORPH = new ItemEntitySummoner<>(EntityPantheramorph.class, EntityPantheramorph::new).setRegistryName("summon.pantheramorph");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItemWithModel(HELM_XENO);
        ItemRegistryUtil.registerItemWithModel(PLATE_XENO);
        ItemRegistryUtil.registerItemWithModel(LEGS_XENO);
        ItemRegistryUtil.registerItemWithModel(BOOTS_XENO);

        ItemRegistryUtil.registerItemWithModel(ITEM_ROYAL_JELLY);

        ItemRegistryUtil.registerItem(SUMMONER_DRONE);
        ItemRegistryUtil.registerItem(SUMMONER_AQUA);
        ItemRegistryUtil.registerItem(SUMMONER_WARRIOR);
        ItemRegistryUtil.registerItem(SUMMONER_CRUSHER);
        ItemRegistryUtil.registerItem(SUMMONER_SPITTER);
        ItemRegistryUtil.registerItem(SUMMONER_PRAETORIAN);
        ItemRegistryUtil.registerItem(SUMMONER_QUEEN);
        ItemRegistryUtil.registerItem(SUMMONER_CHESTBURSTER);
        ItemRegistryUtil.registerItem(SUMMONER_FACEHUGGER);
        ItemRegistryUtil.registerItem(SUMMONER_OVAMORPH);
        ItemRegistryUtil.registerItem(SUMMONER_OVAMORPH_GIGER);
        ItemRegistryUtil.registerItem(SUMMONER_ROYAL_FACEHUGGER);
        ItemRegistryUtil.registerItem(SUMMONER_PREDALIEN);
        ItemRegistryUtil.registerItem(SUMMONER_RUNNER_DRONE);
        ItemRegistryUtil.registerItem(SUMMONER_RUNNER_WARRIOR);
        ItemRegistryUtil.registerItem(SUMMONER_AETHON);
        ItemRegistryUtil.registerItem(SUMMONER_PREDALIEN_BURSTER);
        ItemRegistryUtil.registerItem(SUMMONER_QUEEN_BURSTER);
        ItemRegistryUtil.registerItem(SUMMONER_RUNNER_BURSTER);

        /* Experimental */
        ItemRegistryUtil.registerItem(SUMMONER_BAT_XENO, true);
        ItemRegistryUtil.registerItem(SUMMONER_BOILER, true);
        ItemRegistryUtil.registerItem(SUMMONER_DRACOBURSTER, true);
        ItemRegistryUtil.registerItem(SUMMONER_DRACO_EGG, true);
        ItemRegistryUtil.registerItem(SUMMONER_DRACOMORPH, true);
        ItemRegistryUtil.registerItem(SUMMONER_MYCELIOMORPH, true);
        ItemRegistryUtil.registerItem(SUMMONER_PANTHERAMORPH, true);

        /* Repairs */
        AVPArmorMaterials.CHITIN.setRepairItem(new ItemStack(AlienItems.ITEM_ROYAL_JELLY));

        AVPToolMaterials.CHITIN.setRepairItem(new ItemStack(AlienItems.ITEM_ROYAL_JELLY));
    }
}
