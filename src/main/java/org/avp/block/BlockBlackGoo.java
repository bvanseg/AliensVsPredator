package org.avp.block;

import org.avp.AliensVsPredator;
import org.avp.world.fluids.FluidBlackGoo;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockBlackGoo extends BlockFluidClassic
{
    public static final Fluid fluid = new FluidBlackGoo();
    
    public BlockBlackGoo()
    {
        super(fluid, AliensVsPredator.materials().blackgoo);
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
