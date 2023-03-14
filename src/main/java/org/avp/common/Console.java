package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.core.mods.IPostInitEvent;
import com.asx.mdx.core.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Console implements IPreInitEvent, IInitEvent, IPostInitEvent
{
    public static final Console instance = new Console();
    public static final Logger logger = LogManager.getLogger("AVP");

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        logger.info("Preparing...");
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        int currentYear = LocalDate.now().getYear();
        logger.info("AliensVsPredator Minecraft Mod Copyright © 2012-{} ASX", currentYear);
        logger.info("Initializing...");
    }

    @Override
    public void post(FMLPostInitializationEvent event)
    {
        logger.info("Initialized. Running post initialization tasks...");
    }
}
