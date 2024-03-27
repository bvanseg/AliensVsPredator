package org.avp.common.item.impl;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.FlamethrowerSevastopolItemRenderer;
import org.avp.common.item.AVPWeaponItem;

public class FlamethrowerSevastopolItem extends AVPWeaponItem {

    public FlamethrowerSevastopolItem(Properties properties) {
        super(properties);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new FlamethrowerSevastopolItemRenderer();
    }
}
