package org.avp.common.item.impl;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.M41APulseRifleItemRenderer;
import org.avp.common.item.AVPWeaponItem;

public class M41APulseRifleItem extends AVPWeaponItem {

    public M41APulseRifleItem(Properties properties) {
        super(properties);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new M41APulseRifleItemRenderer();
    }
}
