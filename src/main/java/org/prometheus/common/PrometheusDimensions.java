package org.prometheus.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.AVP;
import org.avp.common.config.ModelConfig;
import org.lib.common.dimension.Dimension;
import org.lib.common.registry.DimensionRegistryUtil;
import org.prometheus.common.world.dimension.varda.BiomeVarda;
import org.prometheus.common.world.dimension.varda.WorldProviderVarda;

public class PrometheusDimensions implements IInitEvent
{
    public static final PrometheusDimensions instance = new PrometheusDimensions();

    @Mod.EventBusSubscriber(modid = AVP.Properties.ID)
    public static class RegistrationHandler
    {
        private RegistrationHandler() {}

        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event)
        {
            event.getRegistry().register(BiomeVarda.vardaBadlands);
            event.getRegistry().register(BiomeVarda.vardaForest);
        }
    }

    public static final Dimension VARDA = new Dimension("Varda", "_varda", WorldProviderVarda.class, false);

    public static final String DIMENSION_NAME_VARDA = "LV-223 (Varda)";

    public static final String DIMENSION_ID_VARDA = "DIM_LV223";

    public static final String BIOME_NAME_VARDA_BADLANDS = "LV-223.B.1 (Varda Badlands)";

    public static final String BIOME_NAME_VARDA_FOREST = "LV-223.B.2 (Anomalistic Forest)";

    @Override
    public void init(FMLInitializationEvent event)
    {
        // Because DimensionManager.getNextFreeDimId() only changes once a dimension has been registered, we have to
        // adjust the config per dimension id prior to registration. It's not recommended to write up a custom dimension ID lookup
        // function since it will break in future versions due to asynchronous changes Forge will make.
        registerVardaDimension();
    }

    private static void registerVardaDimension() {
        if (ModelConfig.getInstance().getDimensions().vardaDimId == null) {
            ModelConfig.getInstance().getDimensions().vardaDimId = DimensionManager.getNextFreeDimId();
        }
        DimensionRegistryUtil.registerDimension(VARDA, ModelConfig.getInstance().getDimensions().vardaDimId);
    }
}
