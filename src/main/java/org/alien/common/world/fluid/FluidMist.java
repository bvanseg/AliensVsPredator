package org.alien.common.world.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import org.avp.AVP;

public class FluidMist extends Fluid
{
    //TODO: Flowing, Still texture locations
    public static final ResourceLocation flowing = new ResourceLocation(AVP.Properties.ID, "blocks/mist.flowing");
    public static final ResourceLocation still = new ResourceLocation(AVP.Properties.ID, "blocks/mist.still");
    
    public FluidMist()
    {
        super("mist", still, flowing);
        this.setDensity(1);
        this.setViscosity(8000);
        this.setGaseous(true);
    }
}
