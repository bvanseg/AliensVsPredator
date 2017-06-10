package org.avp.world.dimension.acheron;

import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.world.dimension.BiomeGenLV;
import org.avp.world.dimension.WorldGenSurfaceBlock;

import com.arisux.mdx.lib.world.Worlds;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorAcheron extends BiomeDecorator
{
    protected World       world;
    public BiomeGenLV     biome;
    public WorldGenerator stalagmiteGen;

    public BiomeDecoratorAcheron(BiomeGenLV biome)
    {
        super();
        this.biome = biome;
    }

    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos)
    {
        if (this.decorating)
        {
            throw new RuntimeException("Already decorating");
        }
        else
        {
            this.chunkProviderSettings = ChunkProviderSettings.Factory.jsonToFactory(worldIn.getWorldInfo().getGeneratorOptions()).build();
            this.chunkPos = pos;
            this.stalagmiteGen = new WorldGenSurfaceBlock(AliensVsPredator.blocks().terrainStalagmite.getDefaultState());
            this.genDecorations(biome, worldIn, random);
            this.decorating = false;
        }
    }
    
    @Override
    protected void genDecorations(Biome biome, World world, Random random)
    {
        this.generateOres(world, random);
        Worlds.generateInChunk(world, this.stalagmiteGen, random, 10, chunkPos);
    }

    @Override
    protected void generateOres(World world, Random random)
    {
        Worlds.generateInChunk(world, new WorldGenMinable(AliensVsPredator.blocks().unidirt.getDefaultState(), 32), random, 20, 0, 128, chunkPos);
    }
}
