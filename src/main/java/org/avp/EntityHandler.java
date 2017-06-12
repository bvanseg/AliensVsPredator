package org.avp;

import java.util.ArrayList;
import java.util.Arrays;

import org.avp.entities.EntityAPC;
import org.avp.entities.EntityAcidPool;
import org.avp.entities.EntityAcidProjectile;
import org.avp.entities.EntityFlame;
import org.avp.entities.EntityGrenade;
import org.avp.entities.EntityLaserMine;
import org.avp.entities.EntityLiquidLatexPool;
import org.avp.entities.EntityMechanism;
import org.avp.entities.EntityMedpod;
import org.avp.entities.EntityPlasma;
import org.avp.entities.EntityShuriken;
import org.avp.entities.EntitySmartDisc;
import org.avp.entities.EntitySpear;
import org.avp.entities.EntitySupplyChute;
import org.avp.entities.EntitySupplyChuteMarines;
import org.avp.entities.EntitySupplyChuteSeegson;
import org.avp.entities.EntityTurret;
import org.avp.entities.EntityWristbracer;
import org.avp.entities.living.EntityAethon;
import org.avp.entities.living.EntityAqua;
import org.avp.entities.living.EntityBabyhead;
import org.avp.entities.living.EntityBatXeno;
import org.avp.entities.living.EntityBelugaburster;
import org.avp.entities.living.EntityBelugamorph;
import org.avp.entities.living.EntityBoiler;
import org.avp.entities.living.EntityChestburster;
import org.avp.entities.living.EntityCombatSynthetic;
import org.avp.entities.living.EntityCrusher;
import org.avp.entities.living.EntityDeacon;
import org.avp.entities.living.EntityDeaconShark;
import org.avp.entities.living.EntityDracoEgg;
import org.avp.entities.living.EntityDracoburster;
import org.avp.entities.living.EntityDracomorph;
import org.avp.entities.living.EntityDrone;
import org.avp.entities.living.EntityEngineer;
import org.avp.entities.living.EntityFacehugger;
import org.avp.entities.living.EntityGooMutant;
import org.avp.entities.living.EntityHammerpede;
import org.avp.entities.living.EntityMarine;
import org.avp.entities.living.EntityMyceliomorph;
import org.avp.entities.living.EntityOctohugger;
import org.avp.entities.living.EntityOvamorph;
import org.avp.entities.living.EntityPantheramorph;
import org.avp.entities.living.EntityPraetorian;
import org.avp.entities.living.EntityPredalien;
import org.avp.entities.living.EntityPredalienChestburster;
import org.avp.entities.living.EntityPredatorHound;
import org.avp.entities.living.EntityMatriarch;
import org.avp.entities.living.EntityQueenChestburster;
import org.avp.entities.living.EntityRoyalFacehugger;
import org.avp.entities.living.EntityRunnerChestburster;
import org.avp.entities.living.EntityRunnerDrone;
import org.avp.entities.living.EntityRunnerWarrior;
import org.avp.entities.living.EntityScelemur;
import org.avp.entities.living.EntitySpaceJockey;
import org.avp.entities.living.EntitySpitter;
import org.avp.entities.living.EntityTrilobite;
import org.avp.entities.living.EntityUltramorph;
import org.avp.entities.living.EntityUrsuidae;
import org.avp.entities.living.EntityWarrior;
import org.avp.entities.living.EntityYautja;
import org.avp.entities.living.EntityYautjaBerserker;
import org.avp.entities.living.EntityYautjaMutant;
import org.avp.tile.TileEntityAmpule;
import org.avp.tile.TileEntityAssembler;
import org.avp.tile.TileEntityBlastdoor;
import org.avp.tile.TileEntityCryostasisTube;
import org.avp.tile.TileEntityGunLocker;
import org.avp.tile.TileEntityHiveResin;
import org.avp.tile.TileEntityLightPanel;
import org.avp.tile.TileEntityLocker;
import org.avp.tile.TileEntityMedpod;
import org.avp.tile.TileEntityNegativeTransformer;
import org.avp.tile.TileEntityPowercell;
import org.avp.tile.TileEntityPowerline;
import org.avp.tile.TileEntityRedstoneEmitter;
import org.avp.tile.TileEntityRedstoneFluxGenerator;
import org.avp.tile.TileEntityRedstoneSensor;
import org.avp.tile.TileEntityReflective;
import org.avp.tile.TileEntityRepulsionGenerator;
import org.avp.tile.TileEntitySatelliteDish;
import org.avp.tile.TileEntitySatelliteModem;
import org.avp.tile.TileEntitySkull;
import org.avp.tile.TileEntitySolarPanel;
import org.avp.tile.TileEntityStasisMechanism;
import org.avp.tile.TileEntitySupplyCrate;
import org.avp.tile.TileEntityTransformer;
import org.avp.tile.TileEntityTurret;
import org.avp.tile.TileEntityWorkstation;
import org.avp.world.dimension.BiomeGenLV;
import org.avp.world.dimension.acheron.BiomeAcheron;
import org.avp.world.dimension.varda.BiomeVarda;

import com.arisux.mdx.MDX;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.game.IPreInitEvent;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EntityHandler implements IInitEvent, IPreInitEvent
{
    public static final EntityHandler instance = new EntityHandler();
    private static int                entityId = 0;

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        this.registerEntities();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerTileEntities();
        this.registerLivingEntities();
        this.registerRemappedEntities();
        this.registerSpawns();
    }

    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityTurret.class, "tileEntityTurret");
        GameRegistry.registerTileEntity(TileEntityWorkstation.class, "tileEntityWorkstation");
        GameRegistry.registerTileEntity(TileEntityHiveResin.class, "tileEntityBlockHive");
        GameRegistry.registerTileEntity(TileEntityAssembler.class, "tileEntityAssembler");
        GameRegistry.registerTileEntity(TileEntityStasisMechanism.class, "tileStasisMechanism");
        GameRegistry.registerTileEntity(TileEntityRepulsionGenerator.class, "tileEntityGenerator");
        GameRegistry.registerTileEntity(TileEntityPowerline.class, "tileEntityPowerline");
        GameRegistry.registerTileEntity(TileEntityBlastdoor.class, "tileEntityBlastdoor");
        GameRegistry.registerTileEntity(TileEntityCryostasisTube.class, "tileEntityCryostasisTube");
        GameRegistry.registerTileEntity(TileEntityLightPanel.class, "tileEntityLightPanel");
        GameRegistry.registerTileEntity(TileEntitySatelliteModem.class, "tileEntitySatelliteModem");
        GameRegistry.registerTileEntity(TileEntitySatelliteDish.class, "tileEntitySatelliteDish");
        GameRegistry.registerTileEntity(TileEntityTransformer.class, "tileEntityTransformer");
        GameRegistry.registerTileEntity(TileEntityNegativeTransformer.class, "tileEntityNegativeTransformer");
        GameRegistry.registerTileEntity(TileEntityRedstoneSensor.class, "tileEntityR2PConverter");
        GameRegistry.registerTileEntity(TileEntityRedstoneEmitter.class, "tileEntityP2RConverter");
        GameRegistry.registerTileEntity(TileEntityPowercell.class, "tileEntityPowercell");
        GameRegistry.registerTileEntity(TileEntityAmpule.class, "tileEntityAmpule");
        GameRegistry.registerTileEntity(TileEntityLocker.class, "tileEntityLocker");
        GameRegistry.registerTileEntity(TileEntityGunLocker.class, "tileEntityGunLocker");
        GameRegistry.registerTileEntity(TileEntityMedpod.class, "tileEntityMedpod");
        GameRegistry.registerTileEntity(TileEntitySupplyCrate.class, "tileEntitySupplyCrate");
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "tile.avp.solarpanel");
        GameRegistry.registerTileEntity(TileEntitySkull.class, "tile.avp.skull");
        GameRegistry.registerTileEntity(TileEntityRedstoneFluxGenerator.class, "tile.avp.redstonefluxgenerator");
        GameRegistry.registerTileEntity(TileEntityReflective.class, "tile.avp.reflective");
    }

    private void registerRemappedEntities()
    {
        // Global Entity Identity Remapping
        MDX.registerRemappedEntity(EntityRunnerDrone.class, "RunnerDrone");
        MDX.registerRemappedEntity(EntityRunnerWarrior.class, "RunnerWarrior");
        MDX.registerRemappedEntity(EntityDrone.class, "Drone");
        MDX.registerRemappedEntity(EntityWarrior.class, "Warrior");
        MDX.registerRemappedEntity(EntitySpitter.class, "Spitter");
        MDX.registerRemappedEntity(EntityCrusher.class, "Crusher");
        MDX.registerRemappedEntity(EntityPraetorian.class, "Praetorian");
        MDX.registerRemappedEntity(EntityMarine.class, "Marine");
        MDX.registerRemappedEntity(EntityYautja.class, "Yautja");
        MDX.registerRemappedEntity(EntityMatriarch.class, "Queen");
        MDX.registerRemappedEntity(EntityFacehugger.class, "Facehugger");
        MDX.registerRemappedEntity(EntityChestburster.class, "Chestbuster");
        MDX.registerRemappedEntity(EntityOvamorph.class, "Ovamorph");
        MDX.registerRemappedEntity(EntityRoyalFacehugger.class, "RoyalFacehugger");
        MDX.registerRemappedEntity(EntityAqua.class, "AquaAlien");
        MDX.registerRemappedEntity(EntityPredalien.class, "Predalien");
        MDX.registerRemappedEntity(EntityCombatSynthetic.class, "CombatSynthetic");
        MDX.registerRemappedEntity(EntityDeacon.class, "Protomorph");
        MDX.registerRemappedEntity(EntityHammerpede.class, "Hammerpede");
        MDX.registerRemappedEntity(EntityTrilobite.class, "Trilobite");
        MDX.registerRemappedEntity(EntitySpaceJockey.class, "SpaceJockey");
        MDX.registerRemappedEntity(EntityEngineer.class, "Engineer");
        MDX.registerRemappedEntity(EntityYautjaBerserker.class, "YautjaBerserker");
        MDX.registerRemappedEntity(EntityDeaconShark.class, "DeaconShark");

        // Mod Entity Identity Remapping
        MDX.registerRemappedEntity(EntityDeacon.class, "avp.Protomorph");
    }

    private void registerEntities()
    {
        Game.register(EntitySpear.class, "Spear", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntityLaserMine.class, "ProximityMine", entityId++, AliensVsPredator.instance(), 250, 8, true);
        Game.register(EntityPlasma.class, "Plasma", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntityGrenade.class, "Grenade", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntityFlame.class, "Flamethrower", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntityAcidPool.class, "AcidPool", entityId++, AliensVsPredator.instance(), 250, 16, true);
        Game.register(EntityLiquidLatexPool.class, "LiquidLatexPool", entityId++, AliensVsPredator.instance(), 250, 16, true);
        Game.register(EntityAcidProjectile.class, "AcidSpit", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntitySmartDisc.class, "EntityDisc", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntityShuriken.class, "EntityShuriken", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntityTurret.class, "EntityTurret", entityId++, AliensVsPredator.instance(), 250, 8, true);
        Game.register(EntityWristbracer.class, "Nuke", entityId++, AliensVsPredator.instance(), 250, 4, true);
        Game.register(EntityAPC.class, "APC", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityMechanism.class, "MECHANISM", entityId++, AliensVsPredator.instance(), 250, 16, true);
        Game.register(EntityMedpod.class, "Medpod", entityId++, AliensVsPredator.instance(), 250, 16, true);
        Game.register(EntitySupplyChute.class, "SupplyChute", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntitySupplyChuteMarines.class, "SupplyChuteMarines", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntitySupplyChuteSeegson.class, "SupplyChuteSeegson", entityId++, AliensVsPredator.instance(), 250, 1, true);
    }

    private void registerLivingEntities()
    {
        Game.register(EntityRunnerDrone.class, "RunnerDrone", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityRunnerWarrior.class, "RunnerWarrior", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityDrone.class, "Drone", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityWarrior.class, "Warrior", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntitySpitter.class, "Spitter", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityCrusher.class, "Crusher", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityPraetorian.class, "Praetorian", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityMarine.class, "Marine", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityYautja.class, "Yautja", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityMatriarch.class, "Queen", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityFacehugger.class, "Facehugger", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityChestburster.class, "Chestbuster", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityOvamorph.class, "Ovamorph", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityRoyalFacehugger.class, "RoyalFacehugger", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityAqua.class, "AquaAlien", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityPredalien.class, "Predalien", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityCombatSynthetic.class, "CombatSynthetic", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityDeacon.class, "Deacon", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityHammerpede.class, "Hammerpede", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityTrilobite.class, "Trilobite", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntitySpaceJockey.class, "SpaceJockey", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityEngineer.class, "Engineer", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityYautjaBerserker.class, "YautjaBerserker", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityDeaconShark.class, "DeaconShark", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityUltramorph.class, "Ultramorph", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityGooMutant.class, "GooMutant", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityAethon.class, "Aethon", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityOctohugger.class, "Octohugger", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityBelugaburster.class, "Belugaburster", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityBelugamorph.class, "Belugamorph", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityPredalienChestburster.class, "PredalienChestburster", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityQueenChestburster.class, "QueenChestburster", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityRunnerChestburster.class, "RunnerChestburster", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityBabyhead.class, "Babyhead", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityBatXeno.class, "BatXeno", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityBoiler.class, "Boiler", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityDracoburster.class, "Dracoburster", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityDracoEgg.class, "DracoOvamorph", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityDracomorph.class, "Dracomorph", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityMyceliomorph.class, "Myceliomorph", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityPantheramorph.class, "Pantheramorph", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityPredatorHound.class, "HellHound", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityUrsuidae.class, "Ursuidae", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityScelemur.class, "VardaMonkey", entityId++, AliensVsPredator.instance(), 250, 1, true);
        Game.register(EntityYautjaMutant.class, "YautjaMutant", entityId++, AliensVsPredator.instance(), 250, 1, true);
    }

    private static final Class<?>[][]    PARAM_TYPES   = new Class[][] { { EnumCreatureType.class, Class.class, int.class, Material.class, boolean.class, boolean.class } };
//    public static final EnumCreatureType WATER_MONSTER = EnumHelper.addEnum(PARAM_TYPES, EnumCreatureType.class, "water_monster", IMob.class, 20, Material.WATER, false, false);

    private void registerSpawns()
    {
        if (AliensVsPredator.settings().areAutoSpawnsEnabled())
        {
            Biome[] xenomorphBiomes = this.getFilteredBiomeArray(Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.PLAINS, Biomes.ROOFED_FOREST, Biomes.SWAMPLAND, Biomes.TAIGA, Biomes.TAIGA_HILLS, BiomeAcheron.acheron);

            Biome[] predatorBiomes = this.getFilteredBiomeArray(Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.ICE_PLAINS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.TAIGA, Biomes.TAIGA_HILLS);

            Biome[] vardaBiomes = this.getFilteredBiomeArray(BiomeVarda.vardaBadlands, BiomeVarda.vardaForest);

            Biome[] aquaXenomorphBiomes = this.getFilteredBiomeArray(Biomes.RIVER, Biomes.BEACH, Biomes.STONE_BEACH);

            if (AliensVsPredator.settings().shouldEvolvedXenomorphsSpawn())
            {
                EntityRegistry.addSpawn(EntityAqua.class, 5, 1, 2, EnumCreatureType.MONSTER, aquaXenomorphBiomes);
                EntityRegistry.addSpawn(EntityDrone.class, 50, 1, 3, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityWarrior.class, 20, 1, 3, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityPraetorian.class, 5, 1, 2, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityChestburster.class, 5, 1, 3, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityFacehugger.class, 5, 1, 2, EnumCreatureType.MONSTER, xenomorphBiomes);
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, 30, 1, 2, EnumCreatureType.MONSTER, xenomorphBiomes);
            }

            EntityRegistry.addSpawn(EntityYautja.class, 1, 0, 1, EnumCreatureType.MONSTER, predatorBiomes);
            EntityRegistry.addSpawn(EntityYautjaBerserker.class, 1, 0, 1, EnumCreatureType.MONSTER, predatorBiomes);
            EntityRegistry.addSpawn(EntityMarine.class, 2, 1, 1, EnumCreatureType.CREATURE, new Biome[] { Biomes.SWAMPLAND, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.PLAINS
            });
            EntityRegistry.addSpawn(EntityEngineer.class, 5, 1, 1, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntitySpaceJockey.class, 2, 1, 1, EnumCreatureType.MONSTER, vardaBiomes);

            EntityRegistry.addSpawn(EntityHammerpede.class, 1, 0, 3, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityOctohugger.class, 20, 0, 3, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityDeacon.class, 1, 0, 1, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityEngineer.class, 1, 0, 1, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityTrilobite.class, 1, 0, 1, EnumCreatureType.MONSTER, vardaBiomes);
        }
    }

    public Biome[] getFilteredBiomeArray(Biome... biomes)
    {
        ArrayList<Biome> biomeList = new ArrayList<Biome>(Arrays.asList(biomes));

        if (!AliensVsPredator.settings().areOverworldSpawnsEnabled())
        {
            biomeList = this.clearVanillaBiomes(biomeList);
        }

        return (Biome[]) Arrays.copyOf(biomeList.toArray(), biomeList.toArray().length, Biome[].class);
    }

    private ArrayList<Biome> clearVanillaBiomes(ArrayList<Biome> biomeList)
    {
        ArrayList<Biome> newList = new ArrayList<Biome>(biomeList);

        for (Biome biome : biomeList)
        {
            if (!(biome instanceof BiomeGenLV))
            {
                newList.remove(biome);
            }
        }

        return newList;
    }
}
