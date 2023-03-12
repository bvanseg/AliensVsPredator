package org.avp.common.item.rackmodules;

import org.avp.AVP;
import org.avp.common.item.ItemNetworkRackModule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

public class ItemNetworkRackModule5 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule5()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AVP.resources().models().RACKMODULE5;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AVP.resources().models().RACKMODULE5_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AVP.resources().models().RACKMODULE5_OFF;
    }
}
