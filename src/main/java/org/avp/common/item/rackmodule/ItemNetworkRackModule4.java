package org.avp.common.item.rackmodule;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import org.avp.AVP;
import org.avp.common.item.ItemNetworkRackModule;

public class ItemNetworkRackModule4 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule4()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AVP.resources().models().RACKMODULE4;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AVP.resources().models().RACKMODULE4_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AVP.resources().models().RACKMODULE4_OFF;
    }
}
