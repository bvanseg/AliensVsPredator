package org.avp.world.dimension.varda;

import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.world.dimension.BiomeGenLV;
import org.avp.world.dimension.WorldGenSurfaceBlock;
import org.avp.world.dimension.varda.gen.TerrainFormation;
import org.avp.world.dimension.varda.gen.TerrainFormation1;
import org.avp.world.dimension.varda.gen.VardaTallTreeGenerator;
import org.avp.world.dimension.varda.gen.VardaTree2Generator;
import org.avp.world.dimension.varda.gen.VardaTree3Generator;
import org.avp.world.dimension.varda.gen.VardaTreeGenerator;
import org.avp.world.dimension.varda.gen.WorldGenSustainableOnDirt;

import com.arisux.mdx.lib.world.Worlds;
import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorVarda extends BiomeDecorator
{
    private static final Predicate<IBlockState> predicate = new Predicate<IBlockState>()
                                                          {
                                                              @Override
                                                              public boolean apply(IBlockState state)
                                                              {
                                                                  if (state.getBlock() == AliensVsPredator.blocks().unistone)
                                                                  {
                                                                      return true;
                                                                  }

                                                                  return false;
                                                              }
                                                          };

    private WorldGenerator                      stalagmiteGen;
    private WorldGenerator                      saplingGen;
    private WorldGenerator                      lakeGeneration;
    private WorldGenerator                      terrainFormation1;
    private WorldGenerator                      terrainFormation2;
    private WorldGenerator                      tree1;
    private WorldGenerator                      tree2;
    private WorldGenerator                      tree3;
    private WorldGenerator                      treeTall;
    private WorldGenerator                      genDirt;
    private WorldGenerator                      genSand;
    private WorldGenerator                      oreBauxite;
    private WorldGenerator                      oreCopper;
    private WorldGenerator                      oreSilicon;
    private WorldGenerator                      oreLithium;
    private WorldGenerator                      oreCoal;
    private WorldGenerator                      oreIron;
    private WorldGenerator                      oreDiamond;

    public BiomeDecoratorVarda(BiomeGenLV biome)
    {
        super();
    }

    @Override
    public void decorate(World world, Random seed, Biome biome, BlockPos pos)
    {
        if (this.decorating)
        {
            throw new RuntimeException("Already decorating");
        }
        else
        {
            this.chunkProviderSettings = ChunkProviderSettings.Factory.jsonToFactory(world.getWorldInfo().getGeneratorOptions()).build();
            this.chunkPos = pos;

            this.stalagmiteGen = new WorldGenSurfaceBlock(AliensVsPredator.blocks().terrainStalagmite.getDefaultState());
            this.saplingGen = new WorldGenSustainableOnDirt(AliensVsPredator.blocks().terrainUniTreeSapling.getDefaultState());
            this.lakeGeneration = new WorldGenLakes(AliensVsPredator.blocks().blockBlackGoo);
            this.terrainFormation1 = new TerrainFormation();
            this.terrainFormation2 = new TerrainFormation1();
            this.tree1 = new VardaTreeGenerator(true);
            this.tree2 = new VardaTree2Generator(true);
            this.tree3 = new VardaTree3Generator(true);
            this.treeTall = new VardaTallTreeGenerator(true);
            this.genDirt = new WorldGenMinable(AliensVsPredator.blocks().unidirt.getDefaultState(), 32, predicate);
            this.genSand = new WorldGenMinable(AliensVsPredator.blocks().unisand.getDefaultState(), 32, predicate);
            this.oreBauxite = new WorldGenMinable(AliensVsPredator.blocks().oreBauxite.getDefaultState(), 4, predicate);
            this.oreCopper = new WorldGenMinable(AliensVsPredator.blocks().oreCopper.getDefaultState(), 4, predicate);
            this.oreSilicon = new WorldGenMinable(AliensVsPredator.blocks().oreSilicon.getDefaultState(), 4, predicate);
            this.oreLithium = new WorldGenMinable(AliensVsPredator.blocks().oreLithium.getDefaultState(), 3, predicate);
            this.oreCoal = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), 16, predicate);
            this.oreIron = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), 8, predicate);
            this.oreDiamond = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), 3, predicate);

            this.genDecorations(biome, world, seed);
            this.decorating = false;
        }
    }

    @Override
    protected void genDecorations(Biome biome, World world, Random seed)
    {
        this.generateOres(world, seed);

        if (biome == BiomeVarda.vardaForest)
        {
            this.generateForestDecorations(biome, world, seed);
        }

        for (int idx = 0; idx < 64; idx++)
        {
            this.stalagmiteGen.generate(world, seed, new BlockPos(this.chunkPos.getX() + seed.nextInt(16), seed.nextInt(128), this.chunkPos.getZ() + seed.nextInt(16)));
        }

        for (int i = 0; i < 128; i++)
        {
            WorldGenerator landform = null;

            switch (seed.nextInt(2))
            {
                case 0:
                    landform = terrainFormation1;
                    break;
                case 1:
                    landform = terrainFormation2;
                    break;
            }

            landform.generate(world, seed, new BlockPos(this.chunkPos.getX() + seed.nextInt(16), seed.nextInt(128), this.chunkPos.getZ() + seed.nextInt(16)));
        }
    }

    @Override
    protected void generateOres(World world, Random seed)
    {
        Worlds.generateInChunk(world, genDirt, seed, 20, 0, 4, this.chunkPos);
        Worlds.generateInChunk(world, genSand, seed, 20, 0, 128, this.chunkPos);
        Worlds.generateInChunk(world, oreBauxite, seed, 20, 16, 128, this.chunkPos);
        Worlds.generateInChunk(world, oreCopper, seed, 20, 0, 128, this.chunkPos);
        Worlds.generateInChunk(world, oreSilicon, seed, 15, 0, 64, this.chunkPos);
        Worlds.generateInChunk(world, oreLithium, seed, 1, 1, 48, this.chunkPos);
        Worlds.generateInChunk(world, oreCoal, seed, 20, 0, 128, this.chunkPos);
        Worlds.generateInChunk(world, oreIron, seed, 20, 0, 64, this.chunkPos);
        Worlds.generateInChunk(world, oreDiamond, seed, 1, 0, 16, this.chunkPos);
    }

    private void generateForestDecorations(Biome biome, World world, Random seed)
    {
        for (int i = 0; i < 2; i++)
        {
            this.lakeGeneration.generate(world, seed, new BlockPos(this.chunkPos.getX() + seed.nextInt(16), seed.nextInt(128), this.chunkPos.getZ() + seed.nextInt(16)));
        }

        for (int idx = 0; idx < 256; idx++)
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
                tree.generate(world, seed, new BlockPos(this.chunkPos.getX() + seed.nextInt(16), seed.nextInt(128), this.chunkPos.getZ() + seed.nextInt(16)));
            }
        }

        for (int idx = 0; idx < 64; idx++)
        {
            saplingGen.generate(world, seed, new BlockPos(this.chunkPos.getX() + seed.nextInt(16), seed.nextInt(128), this.chunkPos.getZ() + seed.nextInt(16)));
        }
    }
}
