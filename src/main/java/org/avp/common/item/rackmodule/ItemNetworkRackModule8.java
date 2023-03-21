package org.avp.common.item.rackmodule;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import org.avp.client.Resources;
import org.avp.common.item.ItemNetworkRackModule;

public class ItemNetworkRackModule8 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule8()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model> getModel()
    {
        return Resources.instance.models().RACKMODULE8;
    }

    @Override
    public MapModelTexture<Model> getModelOn()
    {
        return Resources.instance.models().RACKMODULE8_ON;
    }

    @Override
    public MapModelTexture<Model> getModelOff()
    {
        return Resources.instance.models().RACKMODULE8_OFF;
    }
}
