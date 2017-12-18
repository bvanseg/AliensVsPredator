package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.TexturedModel;

public class ItemNetworkRackModule8 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule8()
    {
        super();
    }
    
    @Override
    public TexturedModel<Model> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE8;
    }

    @Override
    public TexturedModel<Model> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE8_ON;
    }

    @Override
    public TexturedModel<Model> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE8_OFF;
    }
}
