package org.alien.common;

import com.asx.mdx.common.minecraft.item.HookedItem;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.block.init.AlienBlocks;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.EntityDracoEgg;
import org.alien.common.entity.living.EntityYautjaMutant;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.*;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.alien.common.item.ItemArmorXeno;
import org.alien.common.item.ItemSporePod;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.item.ItemEntitySummoner;
import org.lib.common.registry.ItemRegistryUtil;

public class AlienItems implements IPreInitEvent {
    public static final AlienItems instance = new AlienItems();

    private AlienItems() {}

    public static final Item HELM_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.HEAD).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("helm.xeno");
    public static final Item PLATE_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.CHEST).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("body.xeno");
    public static final Item LEGS_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.LEGS).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("legwear.xeno");
    public static final Item BOOTS_XENO = new ItemArmorXeno(0, EntityEquipmentSlot.FEET).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("boots.xeno");
    public static final Item ITEM_RAW_TENTACLE = new ItemFood(4, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.raw.tentacle");
    public static final Item ITEM_TRILO_BITE = new ItemFood(10, 1.0F, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.trilo.bite");
    public static final Item ITEM_ROYAL_JELLY = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("royaljelly");
    public static final Item ITEM_BLACK_GOO = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("blackgoo.item");
    public static final Item ITEM_PHIAL = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("phial.goo");
    public static final Item ITEM_PHIAL_EMPTY = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("phial.empty");
    public static final Item BLACK_GOO_BUCKET = new ItemBucket(AlienBlocks.BLACK_GOO).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("bucket.blackgoo");
    public static final Item MIST_BUCKET = new ItemBucket(AlienBlocks.MIST).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("bucket.mist");
    public static final Item SUMMONER_SPORE_POD = new ItemSporePod().setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.sporepod");
    public static final Item SUMMONER_DRONE = new ItemEntitySummoner(EntityDrone.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.drone");
    public static final Item SUMMONER_AQUA = new ItemEntitySummoner(EntityNauticomorph.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.aqua");
    public static final Item SUMMONER_WARRIOR = new ItemEntitySummoner(EntityWarrior.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.warrior");
    public static final Item SUMMONER_CRUSHER = new ItemEntitySummoner(EntityCrusher.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.crusher");
    public static final Item SUMMONER_SPITTER = new ItemEntitySummoner(EntitySpitter.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.spitter");
    public static final Item SUMMONER_PRAETORIAN = new ItemEntitySummoner(EntityPraetorian.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.praetorian");
    public static final Item SUMMONER_QUEEN = new ItemEntitySummoner(EntityMatriarch.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.queen");
    public static final Item SUMMONER_CHESTBURSTER = new ItemEntitySummoner(EntityChestburster.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster");
    public static final Item SUMMONER_FACEHUGGER = new ItemEntitySummoner(EntityFacehugger.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.facehugger");
    public static final Item SUMMONER_OVAMORPH = new ItemEntitySummoner(EntityOvamorph.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.ovamorph");
    public static final Item SUMMONER_OVAMORPH_GIGER = new ItemEntitySummoner(EntityOvamorphGiger.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.ovamorph.giger");
    public static final Item SUMMONER_ROYAL_FACEHUGGER = new ItemEntitySummoner(EntityRoyalFacehugger.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.royalfacehugger");
    public static final Item SUMMONER_PREDALIEN = new ItemEntitySummoner(EntityPredalien.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.predalien");
    public static final Item SUMMONER_DEACON = new ItemEntitySummoner(EntityDeacon.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deacon");
    public static final Item SUMMONER_DEACON_ADULT = new ItemEntitySummoner(EntityDeaconAdult.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deacon.adult");
    public static final Item SUMMONER_HAMMERPEDE = new ItemEntitySummoner(EntityHammerpede.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.hammerpede");
    public static final Item SUMMONER_TRILOBITE = new ItemEntitySummoner(EntityTrilobite.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.trilobite");
    public static final Item SUMMONER_SPACE_JOCKEY = new ItemEntitySummoner(EntitySpaceJockey.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.spacejockey");
    public static final Item SUMMONER_ENGINEER = new ItemEntitySummoner(EntityEngineer.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.engineer");
    public static final Item SUMMONER_DEACON_SHARK = new ItemEntitySummoner(EntityDeaconShark.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deaconshark");
    public static final Item SUMMONER_RUNNER_DRONE = new ItemEntitySummoner(EntityRunnerDrone.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.runner.drone");
    public static final Item SUMMONER_RUNNER_WARRIOR = new ItemEntitySummoner(EntityRunnerWarrior.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.runner.warrior");
    public static final Item SUMMONER_ULTRAMORPH = new ItemEntitySummoner(EntityUltramorph.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.ultramorph");
    public static final Item SUMMONER_GOO_MUTANT = new ItemEntitySummoner(EntityGooMutant.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.goomutant");
    public static final Item SUMMONER_AETHON = new ItemEntitySummoner(EntityAethon.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.aethon");
    public static final Item SUMMONER_OCTOHUGGER = new ItemEntitySummoner(EntityOctohugger.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.octohugger");
    public static final Item SUMMONER_BELUGABURSTER = new ItemEntitySummoner(EntityBelugaburster.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.belugaburster");
    public static final Item SUMMONER_BELUGAMORPH = new ItemEntitySummoner(EntityBelugamorph.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.belugamorph");
    public static final Item SUMMONER_PREDALIEN_BURSTER = new ItemEntitySummoner(EntityPredalienChestburster.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.predalien");
    public static final Item SUMMONER_QUEEN_BURSTER = new ItemEntitySummoner(EntityQueenChestburster.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.queen");
    public static final Item SUMMONER_RUNNER_BURSTER = new ItemEntitySummoner(EntityRunnerChestburster.class).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.runner");

    /* Experimental */
    public static final Item SUMMONER_BABYHEAD = new ItemEntitySummoner(EntityBabyhead.class).setRegistryName("summon.babyhead");
    public static final Item SUMMONER_BAT_XENO = new ItemEntitySummoner(EntityBatXeno.class).setRegistryName("summon.batxeno");
    public static final Item SUMMONER_BOILER = new ItemEntitySummoner(EntityBoiler.class).setRegistryName("summon.boiler");
    public static final Item SUMMONER_DRACOBURSTER = new ItemEntitySummoner(EntityDracoburster.class).setRegistryName("summon.dracoburster");
    public static final Item SUMMONER_DRACO_EGG = new ItemEntitySummoner(EntityDracoEgg.class).setRegistryName("summon.dracoegg");
    public static final Item SUMMONER_DRACOMORPH = new ItemEntitySummoner(EntityDracomorph.class).setRegistryName("summon.dracomorph");
    public static final Item SUMMONER_MYCELIOMORPH = new ItemEntitySummoner(EntityMyceliomorph.class).setRegistryName("summon.myceliomorph");
    public static final Item SUMMONER_PANTHERAMORPH = new ItemEntitySummoner(EntityPantheramorph.class).setRegistryName("summon.pantheramorph");
    public static final Item SUMMONER_URSUIDAE = new ItemEntitySummoner(EntityUrsuidae.class).setRegistryName("summon.ursuidae");
    public static final Item SUMMONER_VARDA_MONKEY = new ItemEntitySummoner(EntityScelemur.class).setRegistryName("summon.vardamonkey");
    public static final Item SUMMONER_YAUTJA_MUTANT = new ItemEntitySummoner(EntityYautjaMutant.class).setRegistryName("summon.yautjamutant");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItem(HELM_XENO);
        ItemRegistryUtil.registerItem(PLATE_XENO);
        ItemRegistryUtil.registerItem(LEGS_XENO);
        ItemRegistryUtil.registerItem(BOOTS_XENO);

        ItemRegistryUtil.registerItem(ITEM_RAW_TENTACLE);
        ItemRegistryUtil.registerItem(ITEM_TRILO_BITE);

        ItemRegistryUtil.registerItem(ITEM_ROYAL_JELLY);
        ItemRegistryUtil.registerItem(ITEM_BLACK_GOO);
        ItemRegistryUtil.registerItem(ITEM_PHIAL);
        ItemRegistryUtil.registerItem(ITEM_PHIAL_EMPTY);

        ItemRegistryUtil.registerItem(BLACK_GOO_BUCKET);
        ItemRegistryUtil.registerItem(MIST_BUCKET);

        ItemRegistryUtil.registerItem(SUMMONER_SPORE_POD);
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
        ItemRegistryUtil.registerItem(SUMMONER_DEACON);
        ItemRegistryUtil.registerItem(SUMMONER_DEACON_ADULT);
        ItemRegistryUtil.registerItem(SUMMONER_HAMMERPEDE);
        ItemRegistryUtil.registerItem(SUMMONER_TRILOBITE);
        ItemRegistryUtil.registerItem(SUMMONER_SPACE_JOCKEY);
        ItemRegistryUtil.registerItem(SUMMONER_ENGINEER);
        ItemRegistryUtil.registerItem(SUMMONER_DEACON_SHARK);
        ItemRegistryUtil.registerItem(SUMMONER_RUNNER_DRONE);
        ItemRegistryUtil.registerItem(SUMMONER_RUNNER_WARRIOR);
        ItemRegistryUtil.registerItem(SUMMONER_ULTRAMORPH);
        ItemRegistryUtil.registerItem(SUMMONER_GOO_MUTANT);
        ItemRegistryUtil.registerItem(SUMMONER_AETHON);
        ItemRegistryUtil.registerItem(SUMMONER_OCTOHUGGER);
        ItemRegistryUtil.registerItem(SUMMONER_BELUGABURSTER);
        ItemRegistryUtil.registerItem(SUMMONER_BELUGAMORPH);
        ItemRegistryUtil.registerItem(SUMMONER_PREDALIEN_BURSTER);
        ItemRegistryUtil.registerItem(SUMMONER_QUEEN_BURSTER);
        ItemRegistryUtil.registerItem(SUMMONER_RUNNER_BURSTER);

        /* Experimental */
        ItemRegistryUtil.registerItem(SUMMONER_BABYHEAD, true);
        ItemRegistryUtil.registerItem(SUMMONER_BAT_XENO, true);
        ItemRegistryUtil.registerItem(SUMMONER_BOILER, true);
        ItemRegistryUtil.registerItem(SUMMONER_DRACOBURSTER, true);
        ItemRegistryUtil.registerItem(SUMMONER_DRACO_EGG, true);
        ItemRegistryUtil.registerItem(SUMMONER_DRACOMORPH, true);
        ItemRegistryUtil.registerItem(SUMMONER_MYCELIOMORPH, true);
        ItemRegistryUtil.registerItem(SUMMONER_PANTHERAMORPH, true);
        ItemRegistryUtil.registerItem(SUMMONER_URSUIDAE, true);
        ItemRegistryUtil.registerItem(SUMMONER_VARDA_MONKEY, true);
        ItemRegistryUtil.registerItem(SUMMONER_YAUTJA_MUTANT, true);
    }
}
