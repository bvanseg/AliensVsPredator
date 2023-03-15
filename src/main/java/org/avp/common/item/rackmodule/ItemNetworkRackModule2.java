package org.avp.common.item.rackmodule;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import org.avp.client.Resources;
import org.avp.common.item.ItemNetworkRackModule;

public class ItemNetworkRackModule2 extends ItemNetworkRackModule
{
    public ItemNetworkRackModule2()
    {
        super();
    }
    
    @Override
    public MapModelTexture<Model<?>> getModel()
    {
        return Resources.instance.models().RACKMODULE2;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOn()
    {
        return Resources.instance.models().RACKMODULE2_ON;
    }

    @Override
    public MapModelTexture<Model<?>> getModelOff()
    {
        return Resources.instance.models().RACKMODULE2_OFF;
    }
}
