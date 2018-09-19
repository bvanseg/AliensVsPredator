package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.arisux.mdx.lib.client.render.model.MapModelTexture;
import com.arisux.mdx.lib.client.render.model.Model;

public class ItemNetworkRackModule1 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule1()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE1;
    }

    @Override
    public MapModelTexture<Model> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE1_ON;
    }

    @Override
    public MapModelTexture<Model> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE1_OFF;
    }
}
