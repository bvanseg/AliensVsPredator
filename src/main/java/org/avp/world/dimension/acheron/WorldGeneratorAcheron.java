package org.avp.world.dimension.acheron;

import java.util.Random;

import org.avp.world.dimension.acheron.worldgen.TerrainFormation;
import org.avp.world.dimension.acheron.worldgen.TerrainFormation1;
import org.avp.world.dimension.acheron.worldgen.TerrainFormation2;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorAcheron implements IWorldGenerator
{
    private void generateAcheron(World world, Random random, int chunkX, int chunkZ)
    {
        for (int i = 0; i < 18; i++)
        {
            new TerrainFormation().generate(world, random, new BlockPos(chunkX + random.nextInt(16), random.nextInt(128), chunkZ + random.nextInt(16)));
        }

        for (int i = 0; i < 18; i++)
        {
            new TerrainFormation1().generate(world, random, new BlockPos(chunkX + random.nextInt(16), random.nextInt(128), chunkZ + random.nextInt(16)));
        }

        for (int i = 0; i < 18; i++)
        {
            new TerrainFormation2().generate(world, random, new BlockPos(chunkX + random.nextInt(16), random.nextInt(128), chunkZ + random.nextInt(16)));
        }

//        Worlds.generateInChunk(world, new WorldGenSurfaceBlock(AliensVsPredator.blocks().terrainStalagmite.getDefaultState()), random, 10, new BlockPos(chunkX, 0, chunkZ));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.getBiomeForCoords(new BlockPos(chunkX * 16, 0, chunkZ * 16)) == BiomeAcheron.acheron)
        {
            this.generateAcheron(world, random, chunkX * 16, chunkZ * 16);
        }
    }
}
