package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.arisux.mdx.lib.client.render.model.Model;
import com.arisux.mdx.lib.client.render.model.MapModelTexture;

public class ItemNetworkRackModule5 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule5()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE5;
    }

    @Override
    public MapModelTexture<Model> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE5_ON;
    }

    @Override
    public MapModelTexture<Model> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE5_OFF;
    }
}
