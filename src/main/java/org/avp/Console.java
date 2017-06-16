package org.avp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.game.IPostInitEvent;
import com.arisux.mdx.lib.game.IPreInitEvent;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Console implements IPreInitEvent, IInitEvent, IPostInitEvent
{
    public static final Console instance = new Console();
    public static final Logger  logger   = LogManager.getLogger("AVP");

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        logger.info("Preparing to initialize...");
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        logger.info("Copyright(C) 2012-2017 ASX");
        logger.info("Initializing...");
    }

    @Override
    public void post(FMLPostInitializationEvent event)
    {
        logger.info("Initialized. Running post initialization tasks...");
    }
}
