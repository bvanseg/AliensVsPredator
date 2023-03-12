package org.avp.common.world.dimension.acheron;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.avp.common.world.dimension.acheron.worldgen.formations.*;

import java.util.Random;

public class WorldGeneratorAcheron implements IWorldGenerator
{
    private void generateAcheron(World world, Random random, int chunkX, int chunkZ)
    {
        for (int i = 0; i < 64; i++)
        {
            LV426Formation formation = new LV426Formation();
            formation.addVariant(new LV426Formation2());
            formation.addVariant(new LV426Formation3());
            formation.addVariant(new LV426Formation4());
            formation.addVariant(new LV426Formation5());
            formation.addVariant(new LV426Formation6());
            formation.generate(world, random, new BlockPos(chunkX + random.nextInt(16), random.nextInt(128), chunkZ + random.nextInt(16)));
        }

//        Worlds.generateInChunk(world, new WorldGenSurfaceBlock(AVPBlocks.terrainStalagmite.getDefaultState()), random, 10, new BlockPos(chunkX, 0, chunkZ));
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
