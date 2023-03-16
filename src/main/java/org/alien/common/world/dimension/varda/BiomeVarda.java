package org.alien.common.world.dimension.varda;

import com.asx.mdx.common.minecraft.Worlds;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.alien.common.AlienBlocks;
import org.alien.common.entity.living.vardic.EntityDeaconShark;
import org.alien.common.world.dimension.BiomeGenLV;
import org.alien.common.world.dimension.GenerationFilters;
import org.alien.common.world.dimension.WorldGenSurfaceBlock;
import org.alien.common.world.dimension.varda.gen.*;
import org.avp.AVP;
import org.avp.common.AVPBlocks;

import java.util.Random;

public class BiomeVarda extends BiomeGenLV
{
    public static BiomeVarda vardaBadlands = (BiomeVarda) new BiomeVarda(new BiomeProperties(AVP.dimensions().BIOME_NAME_VARDA_BADLANDS).setBaseHeight(1.0F).setHeightVariation(2.0F).setRainDisabled().setWaterColor(0xFFFF66)).setRegistryName(AVP.Properties.ID, "vardabadlands");
    public static BiomeVarda vardaForest   = (BiomeVarda) new BiomeVarda(new BiomeProperties(AVP.dimensions().BIOME_NAME_VARDA_FOREST).setBaseHeight(1.0F).setHeightVariation(8.0F).setTemperature(0.7F).setRainfall(0.1F).setWaterColor(0xFFFF66)).setRegistryName(AVP.Properties.ID, "vardaforest");

    public BiomeVarda(BiomeProperties properties)
    {
        super(properties);
        this.topBlock = AVPBlocks.UNIDIRT.getDefaultState();
        this.fillerBlock = AVPBlocks.UNISTONE.getDefaultState();
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityDeaconShark.class, 1, 0, 1));
    }

    @Override
    public BiomeDecorator createBiomeDecorator()
    {
        return this.decorator = new BiomeDecoratorVarda();
    }

    public static class BiomeDecoratorVarda extends BiomeDecorator
    {
        @Override
        public void decorate(World world, Random seed, Biome biome, BlockPos pos)
        {
            if (this.decorating)
            {
                throw new RuntimeException("Already decorating");
            }
            else
            {
                this.chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(world.getWorldInfo().getGeneratorOptions()).build();
                this.chunkPos = pos;
                this.generateOres(world, seed);
                this.genDecorations(biome, world, seed);
                this.decorating = false;
            }
        }

        @Override
        protected void genDecorations(Biome biome, World world, Random seed)
        {
            WorldGenerator stalagmites = new WorldGenSurfaceBlock(AVPBlocks.STALAGMITE.getDefaultState());
            WorldGenerator formation1 = new TerrainFormation();
            WorldGenerator formation2 = new TerrainFormation1();
            
            if (biome == BiomeVarda.vardaForest)
            {
                this.generateForest(biome, world, seed);
            }

            for (int idx = 0; idx < 64; idx++)
            {
                stalagmites.generate(world, seed, Worlds.randPos(seed, this.chunkPos, 8, 80));
            }

            for (int i = 0; i < 128; i++)
            {
                WorldGenerator landform = null;

                switch (seed.nextInt(2))
                {
                    case 0:
                        landform = formation1;
                        break;
                    case 1:
                        landform = formation2;
                        break;
                }

                landform.generate(world, seed, Worlds.randChunkPos(seed, this.chunkPos));
            }
        }

        @Override
        protected void generateOres(World world, Random seed)
        {
            Worlds.generateInChunk(world, new WorldGenMinable(AVPBlocks.UNIDIRT.getDefaultState(), 32, GenerationFilters.STONE), seed, 20, 0, 4, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(AVPBlocks.UNISAND.getDefaultState(), 32, GenerationFilters.STONE), seed, 20, 0, 128, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(AVPBlocks.ORE_BAUXITE.getDefaultState(), 4, GenerationFilters.STONE), seed, 20, 16, 128, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(AVPBlocks.ORE_COPPER.getDefaultState(), 4, GenerationFilters.STONE), seed, 20, 0, 128, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(AVPBlocks.ORE_SILICON.getDefaultState(), 4, GenerationFilters.STONE), seed, 15, 0, 64, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(AVPBlocks.ORE_LITHIUM.getDefaultState(), 3, GenerationFilters.STONE), seed, 1, 1, 48, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), 16, GenerationFilters.STONE), seed, 20, 0, 128, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), 8, GenerationFilters.STONE), seed, 20, 0, 64, this.chunkPos);
            Worlds.generateInChunk(world, new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), 3, GenerationFilters.STONE), seed, 1, 0, 16, this.chunkPos);
        }

        private void generateForest(Biome biome, World world, Random seed)
        {
            WorldGenerator saplings = new WorldGenSustainableOnDirt(AlienBlocks.GIGER_SAPLING.getDefaultState());
            WorldGenerator tree1 = new VardaTreeGenerator(true);
            WorldGenerator tree2 = new VardaTree2Generator(true);
            WorldGenerator tree3 = new VardaTree3Generator(true);
            WorldGenerator treeTall = new VardaTallTreeGenerator(true);
            WorldGenerator gooPools = new WorldGenLakes(AlienBlocks.BLACK_GOO);
            
            for (int i = 0; i < 2; i++)
            {
                gooPools.generate(world, seed, Worlds.randChunkPos(seed, this.chunkPos));
            }

            for (int idx = 0; idx < 192; idx++)
            {
                WorldGenerator tree = null;

                switch (seed.nextInt(4))
                {
                    case 0:
                        tree = tree1;
                        break;
                    case 1:
                        tree = tree2;
                        break;
                    case 2:
                        tree = tree3;
                        break;
                    case 3:
                        tree = treeTall;
                        break;
                }

                if (tree != null)
                {
                    tree.generate(world, seed, Worlds.randChunkPos(seed, this.chunkPos));
                }
            }

            for (int idx = 0; idx < 64; idx++)
            {
                saplings.generate(world, seed, Worlds.randChunkPos(seed, this.chunkPos));
            }
        }
    }
}
