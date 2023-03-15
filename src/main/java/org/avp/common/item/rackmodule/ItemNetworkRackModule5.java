package org.avp.common.item.rackmodule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import org.avp.AVP;
import org.avp.client.Resources;
import org.avp.common.item.ItemNetworkRackModule;

public class ItemNetworkRackModule5 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule5()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return Resources.instance.models().RACKMODULE5;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return Resources.instance.models().RACKMODULE5_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return Resources.instance.models().RACKMODULE5_OFF;
    }
}
