package org.alien.common;

import com.asx.mdx.common.minecraft.Dimension;
import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.common.world.dimension.acheron.BiomeAcheron;
import org.alien.common.world.dimension.acheron.WorldProviderAcheron;
import org.alien.common.world.dimension.varda.BiomeVarda;
import org.alien.common.world.dimension.varda.WorldProviderVarda;
import org.avp.AVP;

public class AlienDimensions implements IInitEvent
{
    public static final AlienDimensions instance = new AlienDimensions();

    @Mod.EventBusSubscriber(modid = AVP.Properties.ID)
    public static class RegistrationHandler
    {
        private RegistrationHandler() {}

        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event)
        {
            event.getRegistry().register(BiomeAcheron.acheron);
            event.getRegistry().register(BiomeVarda.vardaBadlands);
            event.getRegistry().register(BiomeVarda.vardaForest);
        }
    }

    public static final Dimension ACHERON                   = new Dimension("Acheron", "_acheron", WorldProviderAcheron.class, false);
    public static final Dimension VARDA                     = new Dimension("Varda", "_varda", WorldProviderVarda.class, false);

    public static final String    DIMENSION_NAME_ACHERON    = "LV-426 (Acheron)";

    public static final String    DIMENSION_ID_ACHERON      = "DIM_LV426";

    public static final String    DIMENSION_NAME_VARDA      = "LV-223 (Varda)";

    public static final String    DIMENSION_ID_VARDA        = "DIM_LV223";

    public static final String    BIOME_NAME_VARDA_BADLANDS = "LV-223.B.1 (Varda Badlands)";

    public static final String    BIOME_NAME_VARDA_FOREST   = "LV-223.B.2 (Anomalistic Forest)";

    @Override
    public void init(FMLInitializationEvent event)
    {
        ACHERON.register();
        VARDA.register();
    }
}
