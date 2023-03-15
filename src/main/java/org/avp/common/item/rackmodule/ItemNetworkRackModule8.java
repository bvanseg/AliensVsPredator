package org.avp.common.item.rackmodule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import org.avp.AVP;
import org.avp.common.item.ItemNetworkRackModule;

public class ItemNetworkRackModule8 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule8()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AVP.resources().models().RACKMODULE8;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AVP.resources().models().RACKMODULE8_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AVP.resources().models().RACKMODULE8_OFF;
    }
}