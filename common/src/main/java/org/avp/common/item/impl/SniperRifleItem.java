package org.avp.common.item.impl;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.SniperRifleItemRenderer;
import org.avp.common.item.AbstractAVPWeaponItem;

public class SniperRifleItem extends AbstractAVPWeaponItem {

    public SniperRifleItem(Properties properties) {
        super(properties);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new SniperRifleItemRenderer();
    }
}
