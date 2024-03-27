package org.avp.common.item.impl;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.FlamethrowerSevastopolItemRenderer;
import org.avp.common.item.AVPWeaponItemData;
import org.avp.common.item.AbstractAVPWeaponItem;

public class FlamethrowerSevastopolItem extends AbstractAVPWeaponItem {

    public FlamethrowerSevastopolItem(Properties properties) {
        super(properties, AVPWeaponItemData.FLAMETHROWER_SEVASTOPOL);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new FlamethrowerSevastopolItemRenderer();
    }
}
