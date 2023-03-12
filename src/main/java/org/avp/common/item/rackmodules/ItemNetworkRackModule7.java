package org.avp.common.item.rackmodules;

import org.avp.AVP;
import org.avp.common.item.ItemNetworkRackModule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

public class ItemNetworkRackModule7 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule7()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AVP.resources().models().RACKMODULE7;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AVP.resources().models().RACKMODULE7_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AVP.resources().models().RACKMODULE7_OFF;
    }
}
