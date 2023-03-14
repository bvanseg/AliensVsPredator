package org.alien.common.world.worldgen;

import com.asx.mdx.lib.world.Pos;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TerrainGenVariant<T> extends WorldGenerator implements IWorldGenerator
{
    protected ArrayList<TerrainGenVariant<T>> variants;

    public TerrainGenVariant()
    {
        this.variants = new ArrayList<TerrainGenVariant<T>>();
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        ;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (!locationIsValidSpawn(world, pos))
        {
            return false;
        }

        if (this.getVariants() != null && this.getVariants().size() > 0)
        {
            ArrayList<TerrainGenVariant<T>> variants = this.getVariants();
            TerrainGenVariant<T> selected = variants.get(rand.nextInt(variants.size() - 1));

            return selected.generateOffsetsAt(world, pos);
        }

        return false;
    }

    public boolean locationIsValidSpawn(World world, BlockPos pos)
    {
        for (int i = 0; i < 8; i++)
        {
            BlockPos check = pos.add(0, i - 1, 0);

            if (world.getBlockState(check.add(0, 1, 0)).getBlock() == Blocks.AIR)
            {
                if (world.getBlockState(check).getBlock() != Blocks.AIR)
                {
                    pos = check;
                    break;
                }
            }
        }

        int wX = 1 + (this.getWidthX() / 4);
        int wZ = 1 + (this.getWidthZ() / 4);

        pos = pos.add(wX, 0, wZ);

        Block origin = world.getBlockState(pos).getBlock();
        Block minX = world.getBlockState(pos.add(-wX, 0, 0)).getBlock();
        Block maxX = world.getBlockState(pos.add(+wX, 0, 0)).getBlock();
        Block maxZ = world.getBlockState(pos.add(0, 0, +wZ)).getBlock();
        Block maxY = world.getBlockState(pos.add(0, 1, 0)).getBlock();
        Block minY = world.getBlockState(pos.add(0, -1, 0)).getBlock();

        List<Block> validBlocks = Arrays.asList(this.getValidLocations());

        if (validBlocks.contains(minX) && validBlocks.contains(maxX) && validBlocks.contains(maxZ))
        {
            if (maxY != Blocks.AIR)
            {
                return false;
            }

            if (validBlocks.contains(origin))
            {
                return true;
            }
            else if (origin == Blocks.SNOW && validBlocks.contains(minY))
            {
                return true;
            }
        }

        return false;
    }

    public void setBlock(World world, BlockPos posStart, double offsetX, double offsetY, double offsetZ, IBlockState state)
    {
        BlockPos pos = posStart.add(offsetX, offsetY, offsetZ);
        IBlockState s1 = world.getBlockState(pos);
        Block b1 = s1.getBlock();

        if (b1.isAir(s1, world, pos) || b1.isLeaves(s1, world, pos))
        {
            world.setBlockState(pos, state, 2);
        }
    }

    public void addVariant(TerrainGenVariant<T> variant)
    {
        this.variants.add(variant);
    }

    public ArrayList<TerrainGenVariant<T>> getVariants()
    {
        return this.variants;
    }

    public Block[] getValidLocations()
    {
        return new Block[] { Blocks.DIRT };
    }

    public Pos[] getOffsets()
    {
        List<Pos> set = new ArrayList<Pos>();
        return set.toArray(new Pos[set.size()]);
    }

    public boolean generateOffsetsAt(World world, BlockPos pos)
    {
        for (Pos o : this.getOffsets())
        {
            this.setBlock(world, pos, o.x, o.y, o.z, this.getBlock());
        }

        return true;
    }

    public IBlockState getBlock()
    {
        return Blocks.DIRT.getDefaultState();
    }

    public static Pos offset(List<Pos> set, double x, double y, double z)
    {
        Pos offset = new Pos(x, y, z);
        set.add(offset);

        return offset;
    }

    public int getWidthX()
    {
        double xMin = 0;
        double xMax = 0;

        for (Pos o : this.getOffsets())
        {
            if (o.x < xMin)
                xMin = o.x;

            if (o.x > xMax)
                xMax = o.x;
        }

        return (int) Math.round(xMin + xMax);
    }

    public int getWidthZ()
    {
        double zMin = 0;
        double zMax = 0;

        for (Pos o : this.getOffsets())
        {
            if (o.z < zMin)
                zMin = o.z;

            if (o.z > zMax)
                zMax = o.z;
        }

        return (int) Math.round(zMin + zMax);
    }
}
