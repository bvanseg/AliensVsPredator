package org.avp.common.item.weapon;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.M3712ShotgunItemRenderer;
import org.avp.common.item.AVPWeaponItemData;
import org.avp.common.item.AbstractAVPWeaponItem;

public class M3712ShotgunItem extends AbstractAVPWeaponItem {

    public M3712ShotgunItem(Properties properties) {
        super(properties, AVPWeaponItemData.SHOTGUN);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new M3712ShotgunItemRenderer();
    }
}
