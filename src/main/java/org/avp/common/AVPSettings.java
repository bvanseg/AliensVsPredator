package org.avp.common;

import com.asx.mdx.common.io.config.*;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.common.AlienEntitySpawns;
import org.avp.AVP;
import org.lib.common.registry.EntitySpawnRegistryUtil;
import org.predator.common.PredatorEntitySpawns;

import java.io.File;
import java.util.ArrayList;

public class AVPSettings implements IPreInitEvent, IFlexibleConfiguration
{
    public static final AVPSettings instance          = new AVPSettings();

    private Configuration                  configuration;
    private final ArrayList<ConfigSetting> allSettings       = new ArrayList<>();

    private final String                   CATEGORY_SPAWNING = "spawning";

    private ConfigSetting                  spawnsAlien;
    private ConfigSetting                  spawnsAquaticAlien;
    private ConfigSetting                  spawnsPredator;
    private ConfigSetting                  spawnsMarine;
    private ConfigSetting                  spawnsVarda;


    @Override
    public ArrayList<ConfigSetting> allSettings()
    {
        return this.allSettings;
    }

    @Override
    public void saveSettings()
    {
        this.configuration.save();
    }

    @SideOnly(Side.CLIENT)
    public static class ClientSettings implements IFlexibleConfiguration
    {
        public static final ClientSettings     instance          = new ClientSettings();
        private Configuration                  configuration;
        private final ArrayList<ConfigSetting> allSettings       = new ArrayList<>();

        public void load(Configuration configuration)
        {
            this.configuration = configuration;
        }

        public void saveSettings()
        {
            this.configuration.save();
        }

        @Override
        public ArrayList<ConfigSetting> allSettings()
        {
            return this.allSettings;
        }
    }

    @EventHandler
    public void pre(FMLPreInitializationEvent evt)
    {
        configuration = new Configuration(new File(evt.getModConfigurationDirectory(), "aliensvspredator.config"));
        try
        {
            configuration.load();

            if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
            {
                ClientSettings.instance.load(configuration);
            }

            if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
            {
                AVP.log().info("Listing Overworld Biome IDs for configuration settings...");

                for (Biome b : EntitySpawnRegistryUtil.getOverworldBiomeList())
                {
                	AVP.log().info("{} : {}", b.getBiomeName(), b.getRegistryName());
                }
            }

            spawnsAlien = new ConfigSettingBiomeList(this, configuration.get(CATEGORY_SPAWNING, "alien_biomes", ConfigSettingBiomeList.biomeIdListForConfig(AlienEntitySpawns.DEFAULT_ALIEN_SPAWNS), "List of biomes for aliens to spawn in.")).setRequiresRestart();
            spawnsAquaticAlien = new ConfigSettingBiomeList(this, configuration.get(CATEGORY_SPAWNING, "aquatic_alien_biomes", ConfigSettingBiomeList.biomeIdListForConfig(AlienEntitySpawns.DEFAULT_AQUA_ALIEN_SPAWNS), "List of biomes for aquatic aliens to spawn in.")).setRequiresRestart();
            spawnsPredator = new ConfigSettingBiomeList(this, configuration.get(CATEGORY_SPAWNING, "predator_biomes", ConfigSettingBiomeList.biomeIdListForConfig(PredatorEntitySpawns.DEFAULT_PREDATOR_SPAWNS), "List of biomes for predators to spawn in.")).setRequiresRestart();
            spawnsMarine = new ConfigSettingBiomeList(this, configuration.get(CATEGORY_SPAWNING, "marine_biomes", ConfigSettingBiomeList.biomeIdListForConfig(AVPEntitySpawns.DEFAULT_MARINE_SPAWNS), "List of biomes for marines to spawn in.")).setRequiresRestart();
            spawnsVarda = new ConfigSettingBiomeList(this, configuration.get(CATEGORY_SPAWNING, "varda_biomes", ConfigSettingBiomeList.biomeIdListForConfig(AlienEntitySpawns.DEFAULT_VARDA_LIFE_SPAWNS), "List of biomes for varda wildlife to spawn in.")).setRequiresRestart();
        }
        finally
        {
            configuration.save();
        }
    }

    public Configuration getConfig()
    {
        return configuration;
    }

    public ConfigSettingBiomeList getSpawnsAlien()
    {
        return (ConfigSettingBiomeList) spawnsAlien;
    }

    public ConfigSettingBiomeList getSpawnsAquaticAlien()
    {
        return (ConfigSettingBiomeList) spawnsAquaticAlien;
    }

    public ConfigSettingBiomeList getSpawnsMarine()
    {
        return (ConfigSettingBiomeList) spawnsMarine;
    }

    public ConfigSettingBiomeList getSpawnsPredator()
    {
        return (ConfigSettingBiomeList) spawnsPredator;
    }

    public ConfigSettingBiomeList getSpawnsVarda()
    {
        return (ConfigSettingBiomeList) spawnsVarda;
    }
}
