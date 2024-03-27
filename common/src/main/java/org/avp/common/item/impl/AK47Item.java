package org.avp.common.item.impl;

import mod.azure.azurelib.common.internal.common.core.animation.AnimatableManager;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import org.avp.client.render.item.AK47ItemRenderer;
import org.avp.common.item.AVPWeaponItem;

public class AK47Item extends AVPWeaponItem {

    public AK47Item(Properties properties) {
        super(properties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    protected BlockEntityWithoutLevelRenderer createRenderer() {
        return new AK47ItemRenderer();
    }
}
