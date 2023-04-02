package org.alien.common.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.alien.common.world.fluid.FluidMist;
import org.avp.common.AVPFluidMaterials;

public class BlockMist extends BlockFluidClassic
{
    public static final Fluid fluid = new FluidMist();
    
    public BlockMist()
    {
        super(fluid, AVPFluidMaterials.MIST);
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos)
    {
        if (world.getBlockState(pos).getMaterial().isLiquid())
        {
            return false;
        }
        
        return super.canDisplace(world, pos);
    }
    
    @Override
    public boolean displaceIfPossible(World world, BlockPos pos)
    {
        if (world.getBlockState(pos).getMaterial().isLiquid())
        {
            return false;
        }
        
        return super.displaceIfPossible(world, pos);
    }
}
