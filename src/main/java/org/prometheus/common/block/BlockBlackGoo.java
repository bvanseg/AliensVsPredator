package org.prometheus.common.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import org.alien.common.world.fluid.FluidBlackGoo;
import org.avp.common.AVPFluidMaterials;

public class BlockBlackGoo extends BlockFluidClassic
{
    public static final Fluid fluid = new FluidBlackGoo();
    
    public BlockBlackGoo()
    {
        super(fluid, AVPFluidMaterials.BLACK_GOO);
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
