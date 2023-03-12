package org.avp.common.world.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import org.avp.AVP;

public class FluidBlackGoo extends Fluid
{
    //TODO: Flowing, Still texture locations
    public static final ResourceLocation flowing = new ResourceLocation(AVP.Properties.ID, "blocks/blackgoo.flowing");
    public static final ResourceLocation still = new ResourceLocation(AVP.Properties.ID, "blocks/blackgoo.still");
    
    public FluidBlackGoo()
    {
        super("blackGoo", still, flowing);
        this.setDensity(3000);
        this.setViscosity(6000);
        this.setGaseous(false);
    }
}
