package org.avp.common.item.impl;

import mod.azure.azurelib.common.internal.common.core.animation.AnimatableManager;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import org.avp.client.render.item.SniperRifleItemRenderer;
import org.avp.common.item.AVPWeaponItem;

public class SniperRifleItem extends AVPWeaponItem {

    public SniperRifleItem(Properties properties) {
        super(properties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new SniperRifleItemRenderer();
    }
}
