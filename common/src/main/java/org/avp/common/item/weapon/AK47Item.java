package org.avp.common.item.weapon;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import org.avp.client.render.item.AK47ItemRenderer;
import org.avp.common.item.AVPWeaponItemData;
import org.avp.common.item.AbstractAVPWeaponItem;

public class AK47Item extends AbstractAVPWeaponItem {

    public AK47Item(Properties properties) {
        super(properties, AVPWeaponItemData.AK_47);
    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new AK47ItemRenderer();
    }
}
