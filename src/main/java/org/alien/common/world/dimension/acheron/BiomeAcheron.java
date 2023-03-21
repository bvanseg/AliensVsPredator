package org.alien.common.world.dimension.acheron;

import com.asx.mdx.common.minecraft.Worlds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.feature.WorldGenMinable;
import org.alien.common.world.dimension.BiomeGenLV;
import org.avp.AVP;
import org.avp.common.block.init.AVPBlocks;

import java.util.Random;

public class BiomeAcheron extends BiomeGenLV
{
    public static final BiomeAcheron acheron = (BiomeAcheron) new BiomeAcheron(new BiomeProperties("Acheron").setBaseHeight(0.1F).setHeightVariation(0.4F).setTemperature(0.5F).setRainDisabled()).setRegistryName(AVP.Properties.ID, "acheron");

    public BiomeAcheron(BiomeProperties properties)
    {
        super(properties);
        this.topBlock = AVPBlocks.UNIDIRT.getDefaultState();
        this.fillerBlock = AVPBlocks.UNISTONE.getDefaultState();
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
            ;
        }

        @Override
        protected void generateOres(World world, Random random)
        {
            Worlds.generateInChunk(world, new WorldGenMinable(AVPBlocks.UNIDIRT.getDefaultState(), 32), random, 20, 0, 128, chunkPos);
        }
    }
}
