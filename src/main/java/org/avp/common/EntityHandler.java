package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.EntityAcidProjectile;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.EntityDracoEgg;
import org.alien.common.entity.living.EntitySporePod;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.*;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.avp.AVP;
import org.avp.common.entity.*;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.tile.*;
import org.avp.common.tile.plant.TileEntityGroundFern;
import org.avp.common.tile.plant.TileEntityTreeFern;
import org.avp.common.world.dimension.varda.BiomeVarda;
import org.predator.common.entity.*;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaMutant;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class EntityHandler implements IInitEvent
{
    public static final EntityHandler     instance                  = new EntityHandler();
    private static int                    entityId                  = 0;

    private static ArrayList<EntityEntry> entities                  = new ArrayList<EntityEntry>();
    private static ArrayList<EntityEntry> livingEntities            = new ArrayList<EntityEntry>();

    public static ArrayList<Biome>        DEFAULT_ALIEN_SPAWNS      = new ArrayList<Biome>();
    public static ArrayList<Biome>        DEFAULT_AQUA_ALIEN_SPAWNS = new ArrayList<Biome>();
    public static ArrayList<Biome>        DEFAULT_PREDATOR_SPAWNS   = new ArrayList<Biome>();
    public static ArrayList<Biome>        DEFAULT_VARDA_LIFE_SPAWNS = new ArrayList<Biome>();
    public static ArrayList<Biome>        DEFAULT_MARINE_SPAWNS     = new ArrayList<Biome>();

    static
    {
        DEFAULT_ALIEN_SPAWNS.add(Biomes.BIRCH_FOREST);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.BIRCH_FOREST_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.COLD_BEACH);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.COLD_TAIGA);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.COLD_TAIGA_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.DESERT_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.EXTREME_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.EXTREME_HILLS_EDGE);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.EXTREME_HILLS_WITH_TREES);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.FOREST);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.FOREST_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.ICE_MOUNTAINS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.ICE_PLAINS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.JUNGLE);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.JUNGLE_EDGE);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.JUNGLE_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.PLAINS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.ROOFED_FOREST);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.SWAMPLAND);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.TAIGA);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.TAIGA_HILLS);

        DEFAULT_PREDATOR_SPAWNS.add(Biomes.BIRCH_FOREST);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.BIRCH_FOREST_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.DESERT);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.DESERT_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.EXTREME_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.EXTREME_HILLS_EDGE);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.EXTREME_HILLS_WITH_TREES);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FOREST);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FOREST_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FROZEN_OCEAN);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FROZEN_RIVER);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.ICE_PLAINS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.JUNGLE);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.JUNGLE_EDGE);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.JUNGLE_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.TAIGA);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.TAIGA_HILLS);

        DEFAULT_AQUA_ALIEN_SPAWNS.add(Biomes.RIVER);
        DEFAULT_AQUA_ALIEN_SPAWNS.add(Biomes.BEACH);
        DEFAULT_AQUA_ALIEN_SPAWNS.add(Biomes.STONE_BEACH);

        DEFAULT_MARINE_SPAWNS.add(Biomes.SWAMPLAND);
        DEFAULT_MARINE_SPAWNS.add(Biomes.FOREST);
        DEFAULT_MARINE_SPAWNS.add(Biomes.FOREST_HILLS);
        DEFAULT_MARINE_SPAWNS.add(Biomes.TAIGA);
        DEFAULT_MARINE_SPAWNS.add(Biomes.TAIGA_HILLS);
        DEFAULT_MARINE_SPAWNS.add(Biomes.PLAINS);

        DEFAULT_VARDA_LIFE_SPAWNS.add(BiomeVarda.vardaBadlands);
        DEFAULT_VARDA_LIFE_SPAWNS.add(BiomeVarda.vardaForest);
    }

    @Mod.EventBusSubscriber(modid = AVP.Properties.ID)
    public static class RegistrationHandler
    {
        static
        {
            entities.add(EntityEntryBuilder.create().entity(EntitySpear.class).id("Spear", entityId++).name("Spear").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityLaserMine.class).id("ProximityMine", entityId++).name("ProximityMine").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityPlasma.class).id("Plasma", entityId++).name("Plasma").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityGrenade.class).id("Grenade", entityId++).name("Grenade").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityFlame.class).id("Flamethrower", entityId++).name("Flamethrower").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityAcidPool.class).id("AcidPool", entityId++).name("AcidPool").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityLiquidLatexPool.class).id("LiquidLatexPool", entityId++).name("LiquidLatexPool").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityAcidProjectile.class).id("AcidSpit", entityId++).name("AcidSpit").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySmartDisc.class).id("EntityDisc", entityId++).name("EntityDisc").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityShuriken.class).id("EntityShuriken", entityId++).name("EntityShuriken").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityTurret.class).id("EntityTurret", entityId++).name("EntityTurret").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityWristbracer.class).id("Nuke", entityId++).name("Nuke").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityAPC.class).id("APC", entityId++).name("APC").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityMechanism.class).id("MECHANISM", entityId++).name("MECHANISM").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityMedpod.class).id("Medpod", entityId++).name("Medpod").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySupplyChute.class).id("SupplyChute", entityId++).name("SupplyChute").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySupplyChuteMarines.class).id("SupplyChuteMarines", entityId++).name("SupplyChuteMarines").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySupplyChuteSeegson.class).id("SupplyChuteSeegson", entityId++).name("SupplyChuteSeegson").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySporePod.class).id("SporePod", entityId++).name("SporePod").tracker(250, 4, true).build());

            livingEntities.add(EntityEntryBuilder.create().entity(EntityRunnerDrone.class).id("RunnerDrone", entityId++).name("RunnerDrone").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityRunnerWarrior.class).id("RunnerWarrior", entityId++).name("RunnerWarrior").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDrone.class).id("Drone", entityId++).name("Drone").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityWarrior.class).id("Warrior", entityId++).name("Warrior").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntitySpitter.class).id("Spitter", entityId++).name("Spitter").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityCrusher.class).id("Crusher", entityId++).name("Crusher").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPraetorian.class).id("Praetorian", entityId++).name("Praetorian").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityMarine.class).id("Marine", entityId++).name("Marine").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityYautjaWarrior.class).id("Yautja", entityId++).name("Yautja").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityMatriarch.class).id("Queen", entityId++).name("Queen").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityFacehugger.class).id("Facehugger", entityId++).name("Facehugger").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityChestburster.class).id("Chestbuster", entityId++).name("Chestbuster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityOvamorph.class).id("Ovamorph", entityId++).name("Ovamorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityRoyalFacehugger.class).id("RoyalFacehugger", entityId++).name("RoyalFacehugger").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityNauticomorph.class).id("AquaAlien", entityId++).name("AquaAlien").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPredalien.class).id("Predalien", entityId++).name("Predalien").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityCombatSynthetic.class).id("CombatSynthetic", entityId++).name("CombatSynthetic").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDeacon.class).id("Deacon", entityId++).name("Deacon").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityHammerpede.class).id("Hammerpede", entityId++).name("Hammerpede").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityTrilobite.class).id("Trilobite", entityId++).name("Trilobite").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntitySpaceJockey.class).id("SpaceJockey", entityId++).name("SpaceJockey").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityEngineer.class).id("Engineer", entityId++).name("Engineer").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityYautjaBerserker.class).id("YautjaBerserker", entityId++).name("YautjaBerserker").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDeaconShark.class).id("DeaconShark", entityId++).name("DeaconShark").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityUltramorph.class).id("Ultramorph", entityId++).name("Ultramorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityGooMutant.class).id("GooMutant", entityId++).name("GooMutant").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityAethon.class).id("Aethon", entityId++).name("Aethon").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityOctohugger.class).id("Octohugger", entityId++).name("Octohugger").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityBelugaburster.class).id("Belugaburster", entityId++).name("Belugaburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityBelugamorph.class).id("Belugamorph", entityId++).name("Belugamorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPredalienChestburster.class).id("PredalienChestburster", entityId++).name("PredalienChestburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityQueenChestburster.class).id("QueenChestburster", entityId++).name("QueenChestburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityRunnerChestburster.class).id("RunnerChestburster", entityId++).name("RunnerChestburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDeaconAdult.class).id("DeaconAdult", entityId++).name("DeaconAdult").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityOvamorphGiger.class).id("OvamorphGiger", entityId++).name("OvamorphGiger").tracker(250, 4, true).build());

            if (AVP.settings().areExperimentalFeaturesEnabled())
            {
                livingEntities.add(EntityEntryBuilder.create().entity(EntityBabyhead.class).id("Babyhead", entityId++).name("Babyhead").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityBatXeno.class).id("BatXeno", entityId++).name("BatXeno").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityBoiler.class).id("Boiler", entityId++).name("Boiler").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityDracoburster.class).id("Dracoburster", entityId++).name("Dracoburster").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityDracoEgg.class).id("DracoOvamorph", entityId++).name("DracoOvamorph").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityDracomorph.class).id("Dracomorph", entityId++).name("Dracomorph").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityMyceliomorph.class).id("Myceliomorph", entityId++).name("Myceliomorph").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityPantheramorph.class).id("Pantheramorph", entityId++).name("Pantheramorph").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityPredatorHound.class).id("HellHound", entityId++).name("HellHound").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityUrsuidae.class).id("Ursuidae", entityId++).name("Ursuidae").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityScelemur.class).id("VardaMonkey", entityId++).name("VardaMonkey").tracker(250, 4, true).build());
                livingEntities.add(EntityEntryBuilder.create().entity(EntityYautjaMutant.class).id("YautjaMutant", entityId++).name("YautjaMutant").tracker(250, 4, true).build());
            }

        }

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event)
        {
            for (EntityEntry ee : entities)
            {
                event.getRegistry().register(ee);
            }

            for (EntityEntry ee : livingEntities)
            {
                event.getRegistry().register(ee);
            }
        }
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerTileEntities();
        this.registerSpawns();
    }

    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityTurret.class, new ResourceLocation(AVP.Properties.ID, "tileEntityTurret"));
        GameRegistry.registerTileEntity(TileEntityWorkstation.class, new ResourceLocation(AVP.Properties.ID, "tileEntityWorkstation"));
        GameRegistry.registerTileEntity(TileEntityHiveResin.class, new ResourceLocation(AVP.Properties.ID, "tileEntityBlockHive"));
        GameRegistry.registerTileEntity(TileEntityAssembler.class, new ResourceLocation(AVP.Properties.ID, "tileEntityAssembler"));
        GameRegistry.registerTileEntity(TileEntityStasisMechanism.class, new ResourceLocation(AVP.Properties.ID, "tileStasisMechanism"));
        GameRegistry.registerTileEntity(TileEntityRepulsionGenerator.class, new ResourceLocation(AVP.Properties.ID, "tileEntityGenerator"));
        GameRegistry.registerTileEntity(TileEntityPowerline.class, new ResourceLocation(AVP.Properties.ID, "tileEntityPowerline"));
        GameRegistry.registerTileEntity(TileEntityBlastdoor.class, new ResourceLocation(AVP.Properties.ID, "tileEntityBlastdoor"));
        GameRegistry.registerTileEntity(TileEntitySevastopolBlastDoor.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySevastopolBlastdoor"));
        GameRegistry.registerTileEntity(TileEntityCryostasisTube.class, new ResourceLocation(AVP.Properties.ID, "tileEntityCryostasisTube"));
        GameRegistry.registerTileEntity(TileEntityLightPanel.class, new ResourceLocation(AVP.Properties.ID, "tileEntityLightPanel"));
        GameRegistry.registerTileEntity(TileEntityCCFLTube.class, new ResourceLocation(AVP.Properties.ID, "tileEntityCCFLTube"));
        GameRegistry.registerTileEntity(TileEntityNetworkRack.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySatelliteModem"));
        GameRegistry.registerTileEntity(TileEntitySatelliteDish.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySatelliteDish"));
        GameRegistry.registerTileEntity(TileEntityTransformer.class, new ResourceLocation(AVP.Properties.ID, "tileEntityTransformer"));
        GameRegistry.registerTileEntity(TileEntityNegativeTransformer.class, new ResourceLocation(AVP.Properties.ID, "tileEntityNegativeTransformer"));
        GameRegistry.registerTileEntity(TileEntityRedstoneSensor.class, new ResourceLocation(AVP.Properties.ID, "tileEntityR2PConverter"));
        GameRegistry.registerTileEntity(TileEntityRedstoneEmitter.class, new ResourceLocation(AVP.Properties.ID, "tileEntityP2RConverter"));
        GameRegistry.registerTileEntity(TileEntityPowercell.class, new ResourceLocation(AVP.Properties.ID, "tileEntityPowercell"));
        GameRegistry.registerTileEntity(TileEntityAmpule.class, new ResourceLocation(AVP.Properties.ID, "tileEntityAmpule"));
        GameRegistry.registerTileEntity(TileEntityLocker.class, new ResourceLocation(AVP.Properties.ID, "tileEntityLocker"));
        GameRegistry.registerTileEntity(TileEntityGunLocker.class, new ResourceLocation(AVP.Properties.ID, "tileEntityGunLocker"));
        GameRegistry.registerTileEntity(TileEntityMedpod.class, new ResourceLocation(AVP.Properties.ID, "tileEntityMedpod"));
        GameRegistry.registerTileEntity(TileEntitySupplyCrate.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySupplyCrate"));
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.solarpanel"));
        GameRegistry.registerTileEntity(TileEntitySkull.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.skull"));
        GameRegistry.registerTileEntity(TileEntityRedstoneFluxGenerator.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.redstonefluxgenerator"));
        GameRegistry.registerTileEntity(TileEntityReflective.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.reflective"));
        GameRegistry.registerTileEntity(TileEntityGroundFern.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.groundfern"));
        GameRegistry.registerTileEntity(TileEntityTreeFern.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.treefern"));
        GameRegistry.registerTileEntity(TileEntityTeslaCoil.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.tesacoil"));
    }

    private void registerSpawns()
    {
        if (AVP.settings().areAutoSpawnsEnabled())
        {
            ArrayList<Biome> alienSpawns = filterOverworldBiomes("Alien", AVP.settings().getSpawnsAlien().value());
            ArrayList<Biome> aquaAlienSpawns = filterOverworldBiomes("AlienAquatic", AVP.settings().getSpawnsAquaticAlien().value());
            ArrayList<Biome> predatorSpawns = filterOverworldBiomes("Predator", AVP.settings().getSpawnsPredator().value());
            ArrayList<Biome> marineSpawns = AVP.settings().getSpawnsMarine().value();
            ArrayList<Biome> vardaSpawns = filterOverworldBiomes("Varda", AVP.settings().getSpawnsVarda().value());

            if (AVP.settings().shouldEvolvedXenomorphsSpawn())
            {
                EntityRegistry.addSpawn(EntityNauticomorph.class, (Integer) AVP.settings().spawnWeightEntityNauticomorph.value(), 1, 2, EnumCreatureType.MONSTER, array(aquaAlienSpawns));
                EntityRegistry.addSpawn(EntityDrone.class, (Integer) AVP.settings().spawnWeightEntityDrone.value(), 1, 3, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityWarrior.class, (Integer) AVP.settings().spawnWeightEntityWarrior.value(), 1, 3, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityPraetorian.class, (Integer) AVP.settings().spawnWeightEntityPraetorian.value(), 1, 2, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityChestburster.class, (Integer) AVP.settings().spawnWeightEntityChestburster.value(), 1, 3, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVP.settings().spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, array(alienSpawns));
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVP.settings().spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, array(alienSpawns));
            }

            EntityRegistry.addSpawn(EntityYautjaWarrior.class, (Integer) AVP.settings().spawnWeightEntityYautjaWarrior.value(), 0, 1, EnumCreatureType.MONSTER, array(predatorSpawns));
            EntityRegistry.addSpawn(EntityYautjaBerserker.class, (Integer) AVP.settings().spawnWeightEntityYautjaBerserker.value(), 0, 1, EnumCreatureType.MONSTER, array(predatorSpawns));

            EntityRegistry.addSpawn(EntityMarine.class, (Integer) AVP.settings().spawnWeightEntityMarine.value(), 1, 1, EnumCreatureType.CREATURE, array(marineSpawns));

            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVP.settings().spawnWeightEntityEngineer.value(), 1, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntitySpaceJockey.class, (Integer) AVP.settings().spawnWeightEntitySpaceJockey.value(), 1, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityHammerpede.class, (Integer) AVP.settings().spawnWeightEntityHammerpede.value(), 0, 3, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityOctohugger.class, (Integer) AVP.settings().spawnWeightEntityOctohugger.value(), 0, 3, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityDeacon.class, (Integer) AVP.settings().spawnWeightEntityDeacon.value(), 0, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVP.settings().spawnWeightEntityEngineer.value(), 0, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityTrilobite.class, (Integer) AVP.settings().spawnWeightEntityTrilobite.value(), 0, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
        }
    }

    public ArrayList<Biome> filterOverworldBiomes(String listName, ArrayList<Biome> biomes)
    {
        Iterator<Biome> iter = biomes.iterator();
        ArrayList<Biome> overworldBiomes = getOverworldBiomeList();

        while (iter.hasNext())
        {
            Biome biome = iter.next();
            
            if (!AVP.settings().areOverworldSpawnsEnabled() && overworldBiomes.contains(biome))
            {
                iter.remove();

                System.out.println("Overworld spawn weights disabled. Removing biome from spawn list " + listName + ": " + biome.getRegistryName());
            }
        }

        return biomes;
    }

    public static ArrayList<Biome> getOverworldBiomeList()
    {
        ArrayList<Biome> overworldBiomes = new ArrayList<Biome>();

        for (Field field : Biomes.class.getDeclaredFields())
        {
            if (field.getType() == Biome.class)
            {
                try
                {
                    field.setAccessible(true);
                    Biome b = (Biome) field.get(null);

                    if (b != Biomes.HELL)
                    {
                        overworldBiomes.add(b);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        return overworldBiomes;
    }

    private static Biome[] array(ArrayList<Biome> biomes)
    {
        return Arrays.copyOf(biomes.toArray(), biomes.toArray().length, Biome[].class);
    }
}
