package org.alien.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.common.world.dimension.acheron.BiomeAcheron;
import org.alien.common.world.dimension.acheron.WorldProviderAcheron;
import org.alien.common.world.dimension.varda.BiomeVarda;
import org.alien.common.world.dimension.varda.WorldProviderVarda;
import org.avp.AVP;
import org.avp.common.config.ModelConfig;
import org.lib.common.dimension.Dimension;
import org.lib.common.registry.DimensionRegistryUtil;

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

    public static final Dimension ACHERON = new Dimension("Acheron", "_acheron", WorldProviderAcheron.class, false);
    public static final Dimension VARDA = new Dimension("Varda", "_varda", WorldProviderVarda.class, false);

    public static final String DIMENSION_NAME_ACHERON = "LV-426 (Acheron)";

    public static final String DIMENSION_ID_ACHERON = "DIM_LV426";

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
        registerAcheronDimension();
        registerVardaDimension();
    }

    private static void registerAcheronDimension() {
        if (ModelConfig.getInstance().getDimensions().acheronDimId == null) {
            ModelConfig.getInstance().getDimensions().acheronDimId = DimensionManager.getNextFreeDimId();
        }

        DimensionRegistryUtil.registerDimension(ACHERON, ModelConfig.getInstance().getDimensions().acheronDimId);
    }

    private static void registerVardaDimension() {
        if (ModelConfig.getInstance().getDimensions().vardaDimId == null) {
            ModelConfig.getInstance().getDimensions().vardaDimId = DimensionManager.getNextFreeDimId();
        }
        DimensionRegistryUtil.registerDimension(VARDA, ModelConfig.getInstance().getDimensions().vardaDimId);
    }
}
