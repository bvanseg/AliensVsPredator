package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import org.alien.common.world.dimension.varda.BiomeVarda;
import org.avp.AVP;
import org.avp.common.entity.*;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.tile.*;
import org.avp.common.tile.plant.TileEntityGroundFern;
import org.avp.common.tile.plant.TileEntityTreeFern;
import org.predator.common.entity.*;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaMutant;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AVPEntities implements IInitEvent
{
    public static final AVPEntities instance                  = new AVPEntities();
    private static int                    entityId                  = 0;

    private static final ArrayList<EntityEntry> entities                  = new ArrayList<>();
    private static final ArrayList<EntityEntry> livingEntities            = new ArrayList<>();

    protected static final ArrayList<Biome>        DEFAULT_ALIEN_SPAWNS      = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_AQUA_ALIEN_SPAWNS = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_PREDATOR_SPAWNS   = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_VARDA_LIFE_SPAWNS = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_MARINE_SPAWNS     = new ArrayList<>();

    private AVPEntities() {}

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
        private RegistrationHandler() {}

        static
        {
            registerEntityEntry(EntitySpear.class, "Spear");
            registerEntityEntry(EntityLaserMine.class, "ProximityMine");
            registerEntityEntry(EntityPlasma.class, "Plasma");
            registerEntityEntry(EntityGrenade.class, "Grenade");
            registerEntityEntry(EntityFlame.class, "Flamethrower");
            registerEntityEntry(EntityAcidPool.class, "AcidPool");
            registerEntityEntry(EntityLiquidLatexPool.class, "LiquidLatexPool");
            registerEntityEntry(EntityAcidProjectile.class, "AcidSpit");
            registerEntityEntry(EntitySmartDisc.class, "EntityDisc");
            registerEntityEntry(EntityShuriken.class, "EntityShuriken");
            registerEntityEntry(EntityTurret.class, "EntityTurret");
            registerEntityEntry(EntityWristbracer.class, "Nuke");
            registerEntityEntry(EntityAPC.class, "APC");
            registerEntityEntry(EntityMechanism.class, "MECHANISM");
            registerEntityEntry(EntityMedpod.class, "Medpod");
            registerEntityEntry(EntitySupplyChute.class, "SupplyChute");
            registerEntityEntry(EntitySupplyChuteMarines.class, "SupplyChuteMarines");
            registerEntityEntry(EntitySupplyChuteSeegson.class, "SupplyChuteSeegson");
            registerEntityEntry(EntitySporePod.class, "SporePod");

            registerLivingEntityEntry(EntityRunnerDrone.class, "RunnerDrone");
            registerLivingEntityEntry(EntityRunnerWarrior.class, "RunnerWarrior");
            registerLivingEntityEntry(EntityDrone.class, "Drone");
            registerLivingEntityEntry(EntityWarrior.class, "Warrior");
            registerLivingEntityEntry(EntitySpitter.class, "Spitter");
            registerLivingEntityEntry(EntityCrusher.class, "Crusher");
            registerLivingEntityEntry(EntityPraetorian.class, "Praetorian");
            registerLivingEntityEntry(EntityMarine.class, "Marine");
            registerLivingEntityEntry(EntityYautjaWarrior.class, "Yautja");
            registerLivingEntityEntry(EntityMatriarch.class, "Queen");
            registerLivingEntityEntry(EntityFacehugger.class, "Facehugger");
            registerLivingEntityEntry(EntityChestburster.class, "Chestbuster");
            registerLivingEntityEntry(EntityOvamorph.class, "Ovamorph");
            registerLivingEntityEntry(EntityRoyalFacehugger.class, "RoyalFacehugger");
            registerLivingEntityEntry(EntityNauticomorph.class, "AquaAlien");
            registerLivingEntityEntry(EntityPredalien.class, "Predalien");
            registerLivingEntityEntry(EntityCombatSynthetic.class, "CombatSynthetic");
            registerLivingEntityEntry(EntityDeacon.class, "Deacon");
            registerLivingEntityEntry(EntityHammerpede.class, "Hammerpede");
            registerLivingEntityEntry(EntityTrilobite.class, "Trilobite");
            registerLivingEntityEntry(EntitySpaceJockey.class, "SpaceJockey");
            registerLivingEntityEntry(EntityEngineer.class, "Engineer");
            registerLivingEntityEntry(EntityYautjaBerserker.class, "YautjaBerserker");
            registerLivingEntityEntry(EntityDeaconShark.class, "DeaconShark");
            registerLivingEntityEntry(EntityUltramorph.class, "Ultramorph");
            registerLivingEntityEntry(EntityGooMutant.class, "GooMutant");
            registerLivingEntityEntry(EntityAethon.class, "Aethon");
            registerLivingEntityEntry(EntityOctohugger.class, "Octohugger");
            registerLivingEntityEntry(EntityBelugaburster.class, "Belugaburster");
            registerLivingEntityEntry(EntityBelugamorph.class, "Belugamorph");
            registerLivingEntityEntry(EntityPredalienChestburster.class, "PredalienChestburster");
            registerLivingEntityEntry(EntityQueenChestburster.class, "QueenChestburster");
            registerLivingEntityEntry(EntityRunnerChestburster.class, "RunnerChestburster");
            registerLivingEntityEntry(EntityDeaconAdult.class, "DeaconAdult");
            registerLivingEntityEntry(EntityOvamorphGiger.class, "OvamorphGiger");

            if (AVP.settings().areExperimentalFeaturesEnabled())
            {
                registerLivingEntityEntry(EntityBabyhead.class, "Babyhead");
                registerLivingEntityEntry(EntityBatXeno.class, "BatXeno");
                registerLivingEntityEntry(EntityBoiler.class, "Boiler");
                registerLivingEntityEntry(EntityDracoburster.class, "Dracoburster");
                registerLivingEntityEntry(EntityDracoEgg.class, "DracoOvamorph");
                registerLivingEntityEntry(EntityDracomorph.class, "Dracomorph");
                registerLivingEntityEntry(EntityMyceliomorph.class, "Myceliomorph");
                registerLivingEntityEntry(EntityPantheramorph.class, "Pantheramorph");
                registerLivingEntityEntry(EntityPredatorHound.class, "HellHound");
                registerLivingEntityEntry(EntityUrsuidae.class, "Ursuidae");
                registerLivingEntityEntry(EntityScelemur.class, "VardaMonkey");
                registerLivingEntityEntry(EntityYautjaMutant.class, "YautjaMutant");
            }
        }

        private static void registerEntityEntryToCollection(Class<? extends Entity> entityClass, String id, ArrayList<EntityEntry> collection) {
            collection.add(EntityEntryBuilder.create().entity(entityClass).id(id, entityId++).name(id).tracker(128, 4, true).build());
        }

        private static void registerEntityEntry(Class<? extends Entity> entityClass, String id) {
            registerEntityEntryToCollection(entityClass, id, entities);
        }

        private static void registerLivingEntityEntry(Class<? extends EntityLivingBase> entityClass, String id) {
            registerEntityEntryToCollection(entityClass, id, livingEntities);
        }

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event)
        {
            for (EntityEntry entityEntry : entities)
            {
                event.getRegistry().register(entityEntry);
            }

            for (EntityEntry entityEntry : livingEntities)
            {
                event.getRegistry().register(entityEntry);
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
            List<Biome> alienSpawns = filterOverworldBiomes("Alien", AVP.settings().getSpawnsAlien().value());
            List<Biome> aquaAlienSpawns = filterOverworldBiomes("AlienAquatic", AVP.settings().getSpawnsAquaticAlien().value());
            List<Biome> predatorSpawns = filterOverworldBiomes("Predator", AVP.settings().getSpawnsPredator().value());
            List<Biome> marineSpawns = AVP.settings().getSpawnsMarine().value();
            List<Biome> vardaSpawns = filterOverworldBiomes("Varda", AVP.settings().getSpawnsVarda().value());

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

    public List<Biome> filterOverworldBiomes(String listName, List<Biome> biomes)
    {
        Iterator<Biome> iter = biomes.iterator();
        List<Biome> overworldBiomes = getOverworldBiomeList();

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

    public static List<Biome> getOverworldBiomeList()
    {
        ArrayList<Biome> overworldBiomes = new ArrayList<>();

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

    private static Biome[] array(List<Biome> biomes)
    {
        return Arrays.copyOf(biomes.toArray(), biomes.toArray().length, Biome[].class);
    }
}
