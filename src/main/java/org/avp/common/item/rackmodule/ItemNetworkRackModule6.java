package org.avp.common.item.rackmodule;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import org.avp.client.Resources;
import org.avp.common.item.ItemNetworkRackModule;

public class ItemNetworkRackModule6 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule6()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model> getModel()
    {
        return Resources.instance.models().RACKMODULE6;
    }

    @Override
    public MapModelTexture<Model> getModelOn()
    {
        return Resources.instance.models().RACKMODULE6_ON;
    }

    @Override
    public MapModelTexture<Model> getModelOff()
    {
        return Resources.instance.models().RACKMODULE6_OFF;
    }
}
