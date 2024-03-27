package org.avp.common.item.impl;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.M3712ShotgunItemRenderer;
import org.avp.common.item.AVPWeaponItem;

public class M3712ShotgunItem extends AVPWeaponItem {

    public M3712ShotgunItem(Properties properties) {
        super(properties);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new M3712ShotgunItemRenderer();
    }
}
