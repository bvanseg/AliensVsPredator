package org.avp;

import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.avp.client.render.entity.AVPEntityRenderers;
import org.avp.common.block.*;
import org.avp.common.entity.AVPEntities;
import org.avp.common.item.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Boston Vanseghi
 */
@Mod(AVPConstants.MOD_ID)
public class AVP {

    public static final Logger LOGGER = LoggerFactory.getLogger(AVP.class);

    public AVP() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        AVPEngineerShipBlocks.getInstance().register();
        AVPOreBlocks.getInstance().register();
        AVPPaddingBlocks.getInstance().register();
        AVPTempleBlocks.getInstance().register();
        AVPYautjaShipBlocks.getInstance().register();

        AVPEntities.getInstance().register();

        AVPArmorItems.getInstance().register();
        AVPElectronicItems.getInstance().register();
        AVPFoodItems.getInstance().register();
        AVPItems.getInstance().register();
        AVPWeaponItems.getInstance().register();
    }

    private void setup(FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM INIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void clientSetup(FMLClientSetupEvent event) {
        AVPEntityRenderers.getInstance().register();
    }
}
