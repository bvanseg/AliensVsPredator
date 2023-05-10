package org.prometheus.common;

import com.asx.mdx.common.minecraft.item.HookedItem;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.item.ItemEntitySummoner;
import org.lib.common.registry.ItemRegistryUtil;
import org.prometheus.common.entity.living.EntityYautjaMutant;
import org.prometheus.common.entity.living.engineer.EntityEngineer;
import org.prometheus.common.entity.living.engineer.EntitySpaceJockey;
import org.prometheus.common.entity.living.species223ode.EntityDeacon;
import org.prometheus.common.entity.living.species223ode.EntityDeaconAdult;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;
import org.prometheus.common.entity.living.vardic.*;
import org.prometheus.common.entity.living.xenomorph.EntityUltramorph;

public class PrometheusItems implements IPreInitEvent {
    public static final PrometheusItems instance = new PrometheusItems();

    private PrometheusItems() {}

    public static final Item ITEM_RAW_TENTACLE = new ItemFood(4, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.raw.tentacle");
    public static final Item ITEM_TRILO_BITE = new ItemFood(10, 1.0F, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.trilo.bite");
    public static final Item ITEM_BLACK_GOO = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("blackgoo.item");
    public static final Item ITEM_PHIAL = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("phial.goo");
    public static final Item ITEM_PHIAL_EMPTY = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("phial.empty");
    public static final Item SUMMONER_DEACON = new ItemEntitySummoner<>(EntityDeacon.class, EntityDeacon::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deacon");
    public static final Item SUMMONER_DEACON_ADULT = new ItemEntitySummoner<>(EntityDeaconAdult.class, EntityDeaconAdult::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deacon.adult");
    public static final Item SUMMONER_HAMMERPEDE = new ItemEntitySummoner<>(EntityHammerpede.class, EntityHammerpede::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.hammerpede");
    public static final Item SUMMONER_TRILOBITE = new ItemEntitySummoner<>(EntityTrilobite.class, EntityTrilobite::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.trilobite");
    public static final Item SUMMONER_SPACE_JOCKEY = new ItemEntitySummoner<>(EntitySpaceJockey.class, EntitySpaceJockey::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.spacejockey");
    public static final Item SUMMONER_ENGINEER = new ItemEntitySummoner<>(EntityEngineer.class, EntityEngineer::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.engineer");
    public static final Item SUMMONER_DEACON_SHARK = new ItemEntitySummoner<>(EntityDeaconShark.class, EntityDeaconShark::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deaconshark");
    public static final Item SUMMONER_ULTRAMORPH = new ItemEntitySummoner<>(EntityUltramorph.class, EntityUltramorph::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.ultramorph");
    public static final Item SUMMONER_GOO_MUTANT = new ItemEntitySummoner<>(EntityGooMutant.class, EntityGooMutant::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.goomutant");
    public static final Item SUMMONER_OCTOHUGGER = new ItemEntitySummoner<>(EntityOctohugger.class, EntityOctohugger::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.octohugger");
    public static final Item SUMMONER_BELUGABURSTER = new ItemEntitySummoner<>(EntityBelugaburster.class, EntityBelugaburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.belugaburster");
    public static final Item SUMMONER_BELUGAMORPH = new ItemEntitySummoner<>(EntityBelugamorph.class, EntityBelugamorph::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.belugamorph");

    /* Experimental */
    public static final Item SUMMONER_BABYHEAD = new ItemEntitySummoner<>(EntityBabyhead.class, EntityBabyhead::new).setRegistryName("summon.babyhead");
    public static final Item SUMMONER_URSUIDAE = new ItemEntitySummoner<>(EntityUrsuidae.class, EntityUrsuidae::new).setRegistryName("summon.ursuidae");
    public static final Item SUMMONER_VARDA_MONKEY = new ItemEntitySummoner<>(EntityScelemur.class, EntityScelemur::new).setRegistryName("summon.vardamonkey");
    public static final Item SUMMONER_YAUTJA_MUTANT = new ItemEntitySummoner<>(EntityYautjaMutant.class, EntityYautjaMutant::new).setRegistryName("summon.yautjamutant");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItemWithModel(ITEM_RAW_TENTACLE);
        ItemRegistryUtil.registerItemWithModel(ITEM_TRILO_BITE);

        ItemRegistryUtil.registerItemWithModel(ITEM_BLACK_GOO);
        ItemRegistryUtil.registerItemWithModel(ITEM_PHIAL);
        ItemRegistryUtil.registerItemWithModel(ITEM_PHIAL_EMPTY);

        ItemRegistryUtil.registerItem(SUMMONER_DEACON);
        ItemRegistryUtil.registerItem(SUMMONER_DEACON_ADULT);
        ItemRegistryUtil.registerItem(SUMMONER_HAMMERPEDE);
        ItemRegistryUtil.registerItem(SUMMONER_TRILOBITE);
        ItemRegistryUtil.registerItem(SUMMONER_SPACE_JOCKEY);
        ItemRegistryUtil.registerItem(SUMMONER_ENGINEER);
        ItemRegistryUtil.registerItem(SUMMONER_DEACON_SHARK);
        ItemRegistryUtil.registerItem(SUMMONER_ULTRAMORPH);
        ItemRegistryUtil.registerItem(SUMMONER_GOO_MUTANT);
        ItemRegistryUtil.registerItem(SUMMONER_OCTOHUGGER);
        ItemRegistryUtil.registerItem(SUMMONER_BELUGABURSTER);
        ItemRegistryUtil.registerItem(SUMMONER_BELUGAMORPH);

        /* Experimental */
        ItemRegistryUtil.registerItem(SUMMONER_BABYHEAD, true);
        ItemRegistryUtil.registerItem(SUMMONER_URSUIDAE, true);
        ItemRegistryUtil.registerItem(SUMMONER_VARDA_MONKEY, true);
        ItemRegistryUtil.registerItem(SUMMONER_YAUTJA_MUTANT, true);
    }
}
