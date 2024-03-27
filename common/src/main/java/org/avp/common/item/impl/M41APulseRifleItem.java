package org.avp.common.item.impl;

import mod.azure.azurelib.common.internal.common.core.animation.AnimatableManager;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import org.avp.client.render.item.M41APulseRifleItemRenderer;
import org.avp.common.item.AVPWeaponItem;

public class M41APulseRifleItem extends AVPWeaponItem {

    public M41APulseRifleItem(Properties properties) {
        super(properties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new M41APulseRifleItemRenderer();
    }
}
