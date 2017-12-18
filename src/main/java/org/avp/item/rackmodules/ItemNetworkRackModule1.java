package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.TexturedModel;

public class ItemNetworkRackModule1 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule1()
    {
        super();
    }
    
    @Override
    public TexturedModel<Model> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE1;
    }

    @Override
    public TexturedModel<Model> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE1_ON;
    }

    @Override
    public TexturedModel<Model> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE1_OFF;
    }
}
