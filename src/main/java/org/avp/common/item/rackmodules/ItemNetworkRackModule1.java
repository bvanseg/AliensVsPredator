package org.avp.common.item.rackmodules;

import org.avp.AVP;
import org.avp.common.item.ItemNetworkRackModule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

public class ItemNetworkRackModule1 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule1()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AVP.resources().models().RACKMODULE1;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AVP.resources().models().RACKMODULE1_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AVP.resources().models().RACKMODULE1_OFF;
    }
}
