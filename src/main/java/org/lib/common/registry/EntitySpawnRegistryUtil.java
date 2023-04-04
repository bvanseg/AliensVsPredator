package org.lib.common.registry;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.AVP;
import org.avp.common.config.ModelConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class EntitySpawnRegistryUtil {

    private EntitySpawnRegistryUtil() {}

    private static Set<Biome> overworldBiomes;

    public static synchronized Set<Biome> getOverworldBiomeList()
    {
        if (overworldBiomes == null) {
            overworldBiomes =ForgeRegistries.BIOMES.getValuesCollection().stream().filter(biome -> {
                if (biome.getRegistryName() == null)
                    return false;
                boolean isMinecraftBiome = biome.getRegistryName().getNamespace().equalsIgnoreCase("minecraft");
                boolean isOverworldBiome = biome != Biomes.HELL && biome != Biomes.VOID && biome != Biomes.SKY;
                return isMinecraftBiome && isOverworldBiome;
            }).collect(Collectors.toSet());
        }

        return overworldBiomes;
    }

    public static List<Biome> filterOverworldBiomes(String listName, List<Biome> biomes)
    {
        Set<Biome> overworldBiomes = EntitySpawnRegistryUtil.getOverworldBiomeList();

        biomes.removeIf(biome -> {
            boolean condition = !ModelConfig.getInstance().getSpawning().overworldSpawnsEnabled && overworldBiomes.contains(biome);
            if (condition) {
                AVP.log().info("Overworld spawn weights disabled. Removing biome from spawn list {}: {}", listName, biome.getRegistryName());
            }
            return condition;
        });

        return biomes;
    }

    public static Biome[] array(List<Biome> biomes)
    {
        return Arrays.copyOf(biomes.toArray(), biomes.toArray().length, Biome[].class);
    }
}
