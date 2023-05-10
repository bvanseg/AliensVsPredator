package org.covenant.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.AVP;
import org.avp.common.config.ModelConfig;
import org.covenant.common.world.dimension.paradise.WorldProviderParadise;
import org.lib.common.dimension.Dimension;
import org.lib.common.registry.DimensionRegistryUtil;

public class CovenantDimensions implements IInitEvent
{
    public static final CovenantDimensions instance = new CovenantDimensions();

    @Mod.EventBusSubscriber(modid = AVP.Properties.ID)
    public static class RegistrationHandler
    {
        private RegistrationHandler() {}

        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event)
        {
            // TODO: register paradise biomes here.
        }
    }

    public static final Dimension PARADISE = new Dimension("Paradise", "_paradise", WorldProviderParadise.class, false);

    @Override
    public void init(FMLInitializationEvent event)
    {
        // Because DimensionManager.getNextFreeDimId() only changes once a dimension has been registered, we have to
        // adjust the config per dimension id prior to registration. It's not recommended to write up a custom dimension ID lookup
        // function since it will break in future versions due to asynchronous changes Forge will make.
        registerParadiseDimension();
    }

    private static void registerParadiseDimension() {
        if (ModelConfig.getInstance().getDimensions().paradiseDimId == null) {
            ModelConfig.getInstance().getDimensions().paradiseDimId = DimensionManager.getNextFreeDimId();
        }
        DimensionRegistryUtil.registerDimension(PARADISE, ModelConfig.getInstance().getDimensions().paradiseDimId);
    }
}
