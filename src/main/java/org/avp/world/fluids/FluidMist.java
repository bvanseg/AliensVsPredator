package org.avp.world.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidMist extends Fluid
{
    //TODO: Flowing, Still texture locations
    public static final ResourceLocation flowing = new ResourceLocation("avp:blocks/mist.flowing");
    public static final ResourceLocation still = new ResourceLocation("avp:blocks/mist.still");
    
    public FluidMist()
    {
        super("mist", still, flowing);
        this.setDensity(1);
        this.setViscosity(8000);
        this.setGaseous(true);
    }
}
