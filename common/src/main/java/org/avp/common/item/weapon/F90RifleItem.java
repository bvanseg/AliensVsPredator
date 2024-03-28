package org.avp.common.item.weapon;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.F90RifleItemRenderer;
import org.avp.common.item.AVPWeaponItemData;
import org.avp.common.item.AbstractAVPWeaponItem;

public class F90RifleItem extends AbstractAVPWeaponItem {

    public F90RifleItem(Properties properties) {
        super(properties, AVPWeaponItemData.AK_47);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new F90RifleItemRenderer();
    }
}
