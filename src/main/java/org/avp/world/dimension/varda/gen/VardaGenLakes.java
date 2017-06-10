package org.avp.world.dimension.varda.gen;

import java.util.Random;

import org.avp.AliensVsPredator;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VardaGenLakes extends WorldGenerator
{
    private IBlockState state;

    public VardaGenLakes(IBlockState state)
    {
        this.state = state;
    }
    
    @Override
    public boolean generate(World world, Random rand, BlockPos position)
    {
        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();
        
        x -= 8;

        for (z -= 8; (y > 5) && (world.isAirBlock(new BlockPos(x, y, z))); y--)
            ;
        if (y <= 4)
        {
            return false;
        }

        y -= 4;
        
        position = new BlockPos(x, y, z);

        boolean[] var6 = new boolean[2048];
        int var7 = rand.nextInt(4) + 4;

        for (int var8 = 0; var8 < var7; var8++)
        {
            double var9 = rand.nextDouble() * 6.0D + 3.0D;
            double var11 = rand.nextDouble() * 4.0D + 2.0D;
            double var13 = rand.nextDouble() * 6.0D + 3.0D;
            double var15 = rand.nextDouble() * (16.0D - var9 - 2.0D) + 1.0D + var9 / 2.0D;
            double var17 = rand.nextDouble() * (8.0D - var11 - 4.0D) + 2.0D + var11 / 2.0D;
            double var19 = rand.nextDouble() * (16.0D - var13 - 2.0D) + 1.0D + var13 / 2.0D;

            for (int var21 = 1; var21 < 15; var21++)
            {
                for (int var22 = 1; var22 < 15; var22++)
                {
                    for (int var23 = 1; var23 < 7; var23++)
                    {
                        double var24 = (var21 - var15) / (var9 / 2.0D);
                        double var26 = (var23 - var17) / (var11 / 2.0D);
                        double var28 = (var22 - var19) / (var13 / 2.0D);
                        double var30 = var24 * var24 + var26 * var26 + var28 * var28;

                        if (var30 >= 1.0D)
                            continue;
                        var6[((var21 * 16 + var22) * 8 + var23)] = true;
                    }

                }

            }

        }

        for (int rX = 0; rX < 16; rX++)
        {
            for (int rZ = 0; rZ < 16; rZ++)
            {
                for (int rY = 0; rY < 8; rY++)
                {
                    boolean var33 = (var6[((rX * 16 + rZ) * 8 + rY)] == false) && (((rX < 15) && (var6[(((rX + 1) * 16 + rZ) * 8 + rY)] != false)) || ((rX > 0) && (var6[(((rX - 1) * 16 + rZ) * 8 + rY)] != false)) || ((rZ < 15) && (var6[((rX * 16 + rZ + 1) * 8 + rY)] != false)) || ((rZ > 0) && (var6[((rX * 16 + (rZ - 1)) * 8 + rY)] != false)) || ((rY < 7) && (var6[((rX * 16 + rZ) * 8 + rY + 1)] != false)) || ((rY > 0) && (var6[((rX * 16 + rZ) * 8 + (rY - 1))] != false)));

                    if (!var33)
                        continue;
                    IBlockState blockstate = world.getBlockState(position.add(rX, rY, rZ));
                    Material material = blockstate.getMaterial();

                    if ((rY >= 4) && (material.isLiquid()))
                    {
                        return false;
                    }

                    if ((rY < 4) && (!material.isSolid()) && blockstate != this.state)
                    {
                        return false;
                    }
                }
            }

        }

        for (int rX = 0; rX < 16; rX++)
        {
            for (int rZ = 0; rZ < 16; rZ++)
            {
                for (int rY = 0; rY < 8; rY++)
                {
                    if (var6[((rX * 16 + rZ) * 8 + rY)] == false)
                        continue;
                    world.setBlockState(position.add(rX, rY, rZ), rY >= 4 ? Blocks.AIR.getDefaultState() : this.state);
                }
            }

        }

        for (int rX = 0; rX < 16; rX++)
        {
            for (int rZ = 0; rZ < 16; rZ++)
            {
                for (int rY = 4; rY < 8; rY++)
                {
                    BlockPos rPos = position.add(rX, rY, rZ);
                    BlockPos rPosBelow = rPos.add(0, -1, 0);
                    
                    if ((var6[((rX * 16 + rZ) * 8 + rY)] == false) || (world.getBlockState(rPosBelow) != Blocks.DIRT.getDefaultState()) || (world.getLightFor(EnumSkyBlock.SKY, rPos) <= 0))
                        continue;
                    
                    world.setBlockState(rPosBelow, AliensVsPredator.blocks().unidirt.getDefaultState());
                }
            }

        }

        if (this.state.getMaterial() == Material.LAVA)
        {
            for (int rX = 0; rX < 16; rX++)
            {
                for (int rZ = 0; rZ < 16; rZ++)
                {
                    for (int rY = 0; rY < 8; rY++)
                    {
                        BlockPos rPos = position.add(rX, rY, rZ);
                        boolean flag = (var6[((rX * 16 + rZ) * 8 + rY)] == false) && (((rX < 15) && (var6[(((rX + 1) * 16 + rZ) * 8 + rY)] != false)) || ((rX > 0) && (var6[(((rX - 1) * 16 + rZ) * 8 + rY)] != false)) || ((rZ < 15) && (var6[((rX * 16 + rZ + 1) * 8 + rY)] != false)) || ((rZ > 0) && (var6[((rX * 16 + (rZ - 1)) * 8 + rY)] != false)) || ((rY < 7) && (var6[((rX * 16 + rZ) * 8 + rY + 1)] != false)) || ((rY > 0) && (var6[((rX * 16 + rZ) * 8 + (rY - 1))] != false)));

                        if ((!flag) || ((rY >= 4) && (rand.nextInt(2) == 0)) || (!world.getBlockState(rPos).getMaterial().isSolid()))
                            continue;
                        world.setBlockState(rPos, AliensVsPredator.blocks().unistone.getDefaultState());
                    }
                }
            }

        }

        return true;
    }
}
