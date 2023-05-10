/** AliensVsPredator Minecraft Mod - Copyright (C) 2012-2019 ASX **/
package org.avp;

import com.asx.mdx.common.Game;
import com.asx.mdx.common.mods.IMod;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.alien.Aliens;
import org.alien.client.AlienRenders;
import org.alien.common.entity.AlienCreatureTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avp.client.AVPSounds;
import org.avp.client.KeybindHandler;
import org.avp.client.Renders;
import org.avp.common.*;
import org.avp.common.block.init.AVPBlocks;
import org.avp.common.config.ModelConfig;
import org.avp.common.entity.MarineCreatureTypes;
import org.avp.common.item.init.AVPItems;
import org.avp.common.network.AvpDataSerializers;
import org.avp.common.world.CapabilityHandler;
import org.covenant.client.CovenantRenders;
import org.predator.Predators;
import org.predator.client.PredatorRenders;
import org.predator.common.entity.PredatorCreatureTypes;
import org.prometheus.client.PrometheusRenders;

import java.time.LocalDate;

/**
 * @author Ri5ux
 */
@Mod(name = AVP.Properties.NAME, modid = AVP.Properties.ID, dependencies = AVP.Properties.DEPENDENCIES)
public class AVP implements IMod
{
    public static class Properties
    {
        private Properties() {}

        public static final String NAME         = "AliensVsPredator";
        public static final String ID           = "avp";
        public static final String DEPENDENCIES = "required-after:mdxlib";
        public static final String DOMAIN       = ID + ":";
    }

    @Mod.Instance(AVP.Properties.ID)
    public static AVP instance;

    public final Logger logger = LogManager.getLogger("AVP");

    @Override
    public ModContainer container()
    {
        return Game.instance.getModContainer(AVP.Properties.ID);
    }

    static {
        // It is absolutely essential that we initialize these here before everything else. These create new creature types,
        // which involves modifying the CreatureType enum via reflection at runtime. If this is not done early enough,
        // the mod may crash with other mods or with itself (avp entities are registered using these creature types).
        AlienCreatureTypes.init();
        MarineCreatureTypes.init();
        PredatorCreatureTypes.init();
    }

    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event)
    {
        logger.info("Preparing...");

        AVPCreativeTabs.instance.pre(event);

        Aliens.instance.pre(event);
        Predators.instance.pre(event);

        AVPBlocks.instance.pre(event);
        AVPItems.instance.pre(event);
        AVPSounds.instance.pre(event);

        // Misc.
        CapabilityHandler.instance.pre(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            Renders.instance.pre(event);
            AlienRenders.instance.pre(event);
            PrometheusRenders.instance.pre(event);
            CovenantRenders.instance.pre(event);
            PredatorRenders.instance.pre(event);
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        int currentYear = LocalDate.now().getYear();
        logger.info("AliensVsPredator Minecraft Mod Copyright © 2012-{} ASX", currentYear);
        logger.info("Initializing...");

        AVPOreDict.registerOres();
        AVPItemSchematics.registerRecipes();

        AVPNetworking.instance.init(event);
        AVPGui.instance.init(event);
        AVPEventHandlers.instance.init(event);
        AVPCommands.instance.init(event);
        StructureSchematics.instance.init(event);
        AvpDataSerializers.instance.init(event);

        Aliens.instance.init(event);
        Predators.instance.init(event);

        AVPEntities.instance.init(event);
        AVPEntitySpawns.instance.init(event);
        AVPTileEntities.instance.init(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            Renders.instance.init(event);
            AlienRenders.instance.init(event);
            PrometheusRenders.instance.init(event);
            CovenantRenders.instance.init(event);
            PredatorRenders.instance.init(event);
        }
    }

    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event)
    {
        logger.info("Initialized. Running post initialization tasks...");
        ModelConfig.getInstance().getEmbryos().init();
        ModelConfig.getInstance().getParasites().init();

        ModelConfig.getInstance().write();

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            KeybindHandler.instance.post(event);
        }
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        AVPCommands.instance.onServerStarting(event);
    }

    public Logger getLogger()
    {
        return this.logger;
    }
}
