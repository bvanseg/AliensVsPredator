package org.avp.common.item.rackmodules;

import org.avp.AliensVsPredator;
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
        return AliensVsPredator.resources().models().RACKMODULE6;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE6_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE6_OFF;
    }
}
