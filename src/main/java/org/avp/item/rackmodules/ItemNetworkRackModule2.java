package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

public class ItemNetworkRackModule2 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule2()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE2;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE2_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE2_OFF;
    }
}
