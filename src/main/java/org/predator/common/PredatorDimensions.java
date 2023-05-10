package org.predator.common;

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
import org.predator.common.world.dimension.preserve.WorldProviderPreserve;

public class PredatorDimensions implements IInitEvent
{
    public static final PredatorDimensions instance = new PredatorDimensions();

    @Mod.EventBusSubscriber(modid = AVP.Properties.ID)
    public static class RegistrationHandler
    {
        private RegistrationHandler() {}

        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event)
        {
            // TODO: register preserve biomes here.
        }
    }

    public static final Dimension PRESERVE = new Dimension("Preserve", "_preserve", WorldProviderPreserve.class, false);

    @Override
    public void init(FMLInitializationEvent event)
    {
        // Because DimensionManager.getNextFreeDimId() only changes once a dimension has been registered, we have to
        // adjust the config per dimension id prior to registration. It's not recommended to write up a custom dimension ID lookup
        // function since it will break in future versions due to asynchronous changes Forge will make.
        registerPreserveDimension();
    }

    private static void registerPreserveDimension() {
        if (ModelConfig.getInstance().getDimensions().preserveDimId == null) {
            ModelConfig.getInstance().getDimensions().preserveDimId = DimensionManager.getNextFreeDimId();
        }
        DimensionRegistryUtil.registerDimension(PRESERVE, ModelConfig.getInstance().getDimensions().preserveDimId);
    }
}
