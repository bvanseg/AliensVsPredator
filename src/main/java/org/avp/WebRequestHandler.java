package org.avp;

import org.avp.world.hives.HiveHandler;

import com.asx.mdx.webserver.RequestHandler;
import com.asx.mdx.webserver.RequestHandler.StandardRequestHandler;
import com.asx.mdx.webserver.WebModule;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class WebRequestHandler
{
    public static final WebRequestHandler instance = new WebRequestHandler();

    public void pre(FMLPreInitializationEvent event)
    {
        WebModule.REQUESTS().add(new StandardRequestHandler("/avp/hives/count", new RequestHandler.IDataHandler() {
            @Override
            public Object getData()
            {
                if (HiveHandler.instance != null && HiveHandler.instance.getHives() != null)
                {
                    return String.valueOf(HiveHandler.instance.getHives().size());
                }

                return null;
            }
        }));
    }
}
