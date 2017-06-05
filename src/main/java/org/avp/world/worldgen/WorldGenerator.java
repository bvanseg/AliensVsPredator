package org.avp.world.worldgen;

import java.util.Random;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.world.Worlds;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random seed, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        this.generateSurface(world, seed, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        BlockPos chunkCoords = new BlockPos(chunkX, 0, chunkZ);
        Biome[] overworldBiomes = new Biome[] { Biomes.BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.PLAINS, Biomes.RIVER, Biomes.ROOFED_FOREST, Biomes.SWAMPLAND, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.OCEAN, Biomes.DEEP_OCEAN
        };
        Worlds.generateInBiome(world, new WorldGenMinable(AliensVsPredator.blocks().oreBauxite.getDefaultState(), 4), rand, 20, 16, 128, chunkCoords, overworldBiomes);
        Worlds.generateInBiome(world, new WorldGenMinable(AliensVsPredator.blocks().oreCopper.getDefaultState(), 4), rand, 20, 0, 128, chunkCoords, overworldBiomes);
        Worlds.generateInBiome(world, new WorldGenMinable(AliensVsPredator.blocks().oreSilicon.getDefaultState(), 4), rand, 15, 0, 64, chunkCoords, overworldBiomes);
        Worlds.generateInBiome(world, new WorldGenMinable(AliensVsPredator.blocks().oreLithium.getDefaultState(), 3), rand, 1, 1, 48, chunkCoords, overworldBiomes);
    }
}
