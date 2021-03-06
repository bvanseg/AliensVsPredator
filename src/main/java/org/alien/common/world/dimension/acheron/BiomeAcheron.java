package org.alien.common.world.dimension.acheron;

import com.asx.mdx.common.minecraft.Worlds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.feature.WorldGenMinable;
import org.prometheus.common.block.init.PrometheusVardaBlocks;
import org.alien.common.world.dimension.BiomeGenLV;
import org.avp.AVP;

import java.util.Random;

public class BiomeAcheron extends BiomeGenLV
{
    public static final BiomeAcheron acheron = (BiomeAcheron) new BiomeAcheron(new BiomeProperties("Acheron").setBaseHeight(0.1F).setHeightVariation(0.4F).setTemperature(0.5F).setRainDisabled()).setRegistryName(AVP.Properties.ID, "acheron");

    public BiomeAcheron(BiomeProperties properties)
    {
        super(properties);
        this.topBlock = PrometheusVardaBlocks.UNIDIRT.getDefaultState();
        this.fillerBlock = PrometheusVardaBlocks.UNISTONE.getDefaultState();
    }
    
    @Override
    public BiomeDecorator createBiomeDecorator()
    {
        return this.decorator = new BiomeDecoratorAcheron();
    }
    
    public static class BiomeDecoratorAcheron extends BiomeDecorator
    {
        @Override
        public void decorate(World world, Random random, Biome biome, BlockPos pos)
        {
            if (this.decorating)
            {
                throw new RuntimeException("Already decorating");
            }
            else
            {
                
                this.chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(world.getWorldInfo().getGeneratorOptions()).build();
                this.chunkPos = pos;
                this.generateOres(world, random);
                this.genDecorations(biome, world, random);
                this.decorating = false;
            }
        }

        @Override
        protected void genDecorations(Biome biome, World world, Random random)
        {
        }

        private static final WorldGenMinable WORLDGEN_ORE_UNIDIRT = new WorldGenMinable(PrometheusVardaBlocks.UNIDIRT.getDefaultState(), 32);

        @Override
        protected void generateOres(World world, Random random)
        {
            Worlds.generateInChunk(world, WORLDGEN_ORE_UNIDIRT, random, 20, 0, 128, chunkPos);
        }
    }
}
