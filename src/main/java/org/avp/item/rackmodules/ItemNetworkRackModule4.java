package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

public class ItemNetworkRackModule4 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule4()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE4;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE4_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE4_OFF;
    }
}
