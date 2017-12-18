package org.avp.item.rackmodules;

import org.avp.AliensVsPredator;
import org.avp.item.ItemNetworkRackModule;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.TexturedModel;

public class ItemNetworkRackModule7 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule7()
    {
        super();
    }
    
    @Override
    public TexturedModel<Model> getModel()
    {
        return AliensVsPredator.resources().models().RACKMODULE7;
    }

    @Override
    public TexturedModel<Model> getModelOn()
    {
        return AliensVsPredator.resources().models().RACKMODULE7_ON;
    }

    @Override
    public TexturedModel<Model> getModelOff()
    {
        return AliensVsPredator.resources().models().RACKMODULE7_OFF;
    }
}
