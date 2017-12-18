package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.TexturedModel;

public class ItemNetworkRackModule6 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule6()
    {
        super();
    }
    
    @Override
    public TexturedModel<Model> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE6;
    }

    @Override
    public TexturedModel<Model> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE6_ON;
    }

    @Override
    public TexturedModel<Model> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE6_OFF;
    }
}
