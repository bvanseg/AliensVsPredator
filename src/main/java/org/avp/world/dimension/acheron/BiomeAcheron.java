package org.avp.world.dimension.acheron;

import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.world.dimension.BiomeGenLV;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeAcheron extends BiomeGenLV
{
    public static final BiomeAcheron acheron = new BiomeAcheron(new BiomeProperties("Acheron").setBaseHeight(0.1F).setHeightVariation(0.4F).setTemperature(0.5F).setRainDisabled());

    public BiomeAcheron(BiomeProperties properties)
    {
        super(properties);
        this.topBlock = AliensVsPredator.blocks().unidirt.getDefaultState();
        this.fillerBlock = AliensVsPredator.blocks().unistone.getDefaultState();
        this.theBiomeDecorator = new BiomeDecoratorAcheron(this);
    }
    
    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        int i = worldIn.getSeaLevel();
        IBlockState top = this.topBlock;
        IBlockState filler = this.fillerBlock;
        int j = -1;
        int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int j1 = 255; j1 >= 0; --j1)
        {
            if (j1 <= rand.nextInt(5))
            {
                chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
            }
            else
            {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

                if (iblockstate2.getMaterial() == Material.AIR)
                {
                    j = -1;
                }
                else if (iblockstate2.getBlock() == Blocks.STONE)
                {
                    if (j == -1)
                    {
                        if (k <= 0)
                        {
                            top = AIR;
                            filler = STONE;
                        }
                        else if (j1 >= i - 4 && j1 <= i + 1)
                        {
                            top = this.topBlock;
                            filler = this.fillerBlock;
                        }

                        if (j1 < i && (top == null || top.getMaterial() == Material.AIR))
                        {
                            if (this.getFloatTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F)
                            {
                                top = ICE;
                            }
                            else
                            {
                                top = WATER;
                            }
                        }

                        j = k;

                        if (j1 >= i - 1)
                        {
                            chunkPrimerIn.setBlockState(i1, j1, l, top);
                        }
                        else if (j1 < i - 7 - k)
                        {
                            top = AIR;
                            filler = STONE;
                            chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
                        }
                        else
                        {
                            chunkPrimerIn.setBlockState(i1, j1, l, filler);
                        }
                    }
                    else if (j > 0)
                    {
                        --j;
                        chunkPrimerIn.setBlockState(i1, j1, l, filler);

                        if (j == 0 && filler.getBlock() == Blocks.SAND && k > 1)
                        {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            filler = filler.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
            }
        }
    }
}
