package org.avp.common.item.rackmodules;

import org.avp.AVP;
import org.avp.common.item.ItemNetworkRackModule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

public class ItemNetworkRackModule6 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule6()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AVP.resources().models().RACKMODULE6;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AVP.resources().models().RACKMODULE6_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AVP.resources().models().RACKMODULE6_OFF;
    }
}
