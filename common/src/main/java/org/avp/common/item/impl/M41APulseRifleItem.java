package org.avp.common.item.impl;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.M41APulseRifleItemRenderer;
import org.avp.common.item.AbstractAVPWeaponItem;

public class M41APulseRifleItem extends AbstractAVPWeaponItem {

    public M41APulseRifleItem(Properties properties) {
        super(properties);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new M41APulseRifleItemRenderer();
    }
}
