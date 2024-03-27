package org.avp.client.render.item;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import org.avp.client.model.item.M41APulseRifleModel;
import org.avp.client.model.item.SniperRifleModel;
import org.avp.common.item.impl.M41APulseRifleItem;
import org.avp.common.item.impl.SniperRifleItem;

public class SniperRifleItemRenderer extends GeoItemRenderer<SniperRifleItem> {
    public SniperRifleItemRenderer() {
        super(new SniperRifleModel());
    }
}