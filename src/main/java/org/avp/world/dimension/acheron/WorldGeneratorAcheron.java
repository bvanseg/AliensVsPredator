package org.avp.world.dimension.acheron;

import java.util.Random;

import org.avp.world.dimension.acheron.worldgen.formations.LV426Formation;
import org.avp.world.dimension.acheron.worldgen.formations.LV426Formation2;
import org.avp.world.dimension.acheron.worldgen.formations.LV426Formation3;
import org.avp.world.dimension.acheron.worldgen.formations.LV426Formation4;
import org.avp.world.dimension.acheron.worldgen.formations.LV426Formation5;
import org.avp.world.dimension.acheron.worldgen.formations.LV426Formation6;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

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
