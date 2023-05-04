package org.alien.common;

import com.asx.mdx.common.minecraft.item.HookedItem;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.EntityYautjaMutant;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.*;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.burster.*;
import org.alien.common.entity.living.xenomorph.exotic.*;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityDracoEgg;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorphGiger;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.alien.common.item.ItemArmorXeno;
import org.alien.common.item.ItemSporePod;
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
    public static final Item ITEM_RAW_TENTACLE = new ItemFood(4, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.raw.tentacle");
    public static final Item ITEM_TRILO_BITE = new ItemFood(10, 1.0F, true).setAlwaysEdible().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("food.trilo.bite");
    public static final Item ITEM_ROYAL_JELLY = new HookedItem().setMaxStackSize(64).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("royaljelly");
    public static final Item ITEM_BLACK_GOO = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("blackgoo.item");
    public static final Item ITEM_PHIAL = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("phial.goo");
    public static final Item ITEM_PHIAL_EMPTY = new HookedItem().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("phial.empty");
    public static final Item SUMMONER_SPORE_POD = new ItemSporePod().setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.sporepod");
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
    public static final Item SUMMONER_DEACON = new ItemEntitySummoner<>(EntityDeacon.class, EntityDeacon::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deacon");
    public static final Item SUMMONER_DEACON_ADULT = new ItemEntitySummoner<>(EntityDeaconAdult.class, EntityDeaconAdult::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deacon.adult");
    public static final Item SUMMONER_HAMMERPEDE = new ItemEntitySummoner<>(EntityHammerpede.class, EntityHammerpede::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.hammerpede");
    public static final Item SUMMONER_TRILOBITE = new ItemEntitySummoner<>(EntityTrilobite.class, EntityTrilobite::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.trilobite");
    public static final Item SUMMONER_SPACE_JOCKEY = new ItemEntitySummoner<>(EntitySpaceJockey.class, EntitySpaceJockey::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.spacejockey");
    public static final Item SUMMONER_ENGINEER = new ItemEntitySummoner<>(EntityEngineer.class, EntityEngineer::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.engineer");
    public static final Item SUMMONER_DEACON_SHARK = new ItemEntitySummoner<>(EntityDeaconShark.class, EntityDeaconShark::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.deaconshark");
    public static final Item SUMMONER_RUNNER_DRONE = new ItemEntitySummoner<>(EntityRunnerDrone.class, EntityRunnerDrone::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.runner.drone");
    public static final Item SUMMONER_RUNNER_WARRIOR = new ItemEntitySummoner<>(EntityRunnerWarrior.class, EntityRunnerWarrior::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.runner.warrior");
    public static final Item SUMMONER_ULTRAMORPH = new ItemEntitySummoner<>(EntityUltramorph.class, EntityUltramorph::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.ultramorph");
    public static final Item SUMMONER_GOO_MUTANT = new ItemEntitySummoner<>(EntityGooMutant.class, EntityGooMutant::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.goomutant");
    public static final Item SUMMONER_AETHON = new ItemEntitySummoner<>(EntityAethon.class, EntityAethon::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.aethon");
    public static final Item SUMMONER_OCTOHUGGER = new ItemEntitySummoner<>(EntityOctohugger.class, EntityOctohugger::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.octohugger");
    public static final Item SUMMONER_BELUGABURSTER = new ItemEntitySummoner<>(EntityBelugaburster.class, EntityBelugaburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.belugaburster");
    public static final Item SUMMONER_BELUGAMORPH = new ItemEntitySummoner<>(EntityBelugamorph.class, EntityBelugamorph::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.belugamorph");
    public static final Item SUMMONER_PREDALIEN_BURSTER = new ItemEntitySummoner<>(EntityPredalienChestburster.class, EntityPredalienChestburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.predalien");
    public static final Item SUMMONER_QUEEN_BURSTER = new ItemEntitySummoner<>(EntityQueenChestburster.class, EntityQueenChestburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.queen");
    public static final Item SUMMONER_RUNNER_BURSTER = new ItemEntitySummoner<>(EntityRunnerChestburster.class, EntityRunnerChestburster::new).setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.chestburster.runner");

    /* Experimental */
    public static final Item SUMMONER_BABYHEAD = new ItemEntitySummoner<>(EntityBabyhead.class, EntityBabyhead::new).setRegistryName("summon.babyhead");
    public static final Item SUMMONER_BAT_XENO = new ItemEntitySummoner<>(EntityBatXeno.class, EntityBatXeno::new).setRegistryName("summon.batxeno");
    public static final Item SUMMONER_BOILER = new ItemEntitySummoner<>(EntityBoiler.class, EntityBoiler::new).setRegistryName("summon.boiler");
    public static final Item SUMMONER_DRACOBURSTER = new ItemEntitySummoner<>(EntityDracoburster.class, EntityDracoburster::new).setRegistryName("summon.dracoburster");
    public static final Item SUMMONER_DRACO_EGG = new ItemEntitySummoner<>(EntityDracoEgg.class, EntityDracoEgg::new).setRegistryName("summon.dracoegg");
    public static final Item SUMMONER_DRACOMORPH = new ItemEntitySummoner<>(EntityDracomorph.class, EntityDracomorph::new).setRegistryName("summon.dracomorph");
    public static final Item SUMMONER_MYCELIOMORPH = new ItemEntitySummoner<>(EntityMyceliomorph.class, EntityMyceliomorph::new).setRegistryName("summon.myceliomorph");
    public static final Item SUMMONER_PANTHERAMORPH = new ItemEntitySummoner<>(EntityPantheramorph.class, EntityPantheramorph::new).setRegistryName("summon.pantheramorph");
    public static final Item SUMMONER_URSUIDAE = new ItemEntitySummoner<>(EntityUrsuidae.class, EntityUrsuidae::new).setRegistryName("summon.ursuidae");
    public static final Item SUMMONER_VARDA_MONKEY = new ItemEntitySummoner<>(EntityScelemur.class, EntityScelemur::new).setRegistryName("summon.vardamonkey");
    public static final Item SUMMONER_YAUTJA_MUTANT = new ItemEntitySummoner<>(EntityYautjaMutant.class, EntityYautjaMutant::new).setRegistryName("summon.yautjamutant");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItemWithModel(HELM_XENO);
        ItemRegistryUtil.registerItemWithModel(PLATE_XENO);
        ItemRegistryUtil.registerItemWithModel(LEGS_XENO);
        ItemRegistryUtil.registerItemWithModel(BOOTS_XENO);

        ItemRegistryUtil.registerItemWithModel(ITEM_RAW_TENTACLE);
        ItemRegistryUtil.registerItemWithModel(ITEM_TRILO_BITE);

        ItemRegistryUtil.registerItemWithModel(ITEM_ROYAL_JELLY);
        ItemRegistryUtil.registerItemWithModel(ITEM_BLACK_GOO);
        ItemRegistryUtil.registerItemWithModel(ITEM_PHIAL);
        ItemRegistryUtil.registerItemWithModel(ITEM_PHIAL_EMPTY);

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

        AVPToolMaterials.CHITIN.setRepairItem(new ItemStack(AlienItems.ITEM_ROYAL_JELLY));
    }
}
