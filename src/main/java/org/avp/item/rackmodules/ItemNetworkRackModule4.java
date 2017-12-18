package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.TexturedModel;

public class ItemNetworkRackModule4 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule4()
    {
        super();
    }
    
    @Override
    public TexturedModel<Model> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE4;
    }

    @Override
    public TexturedModel<Model> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE4_ON;
    }

    @Override
    public TexturedModel<Model> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE4_OFF;
    }
}
