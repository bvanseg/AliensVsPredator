package org.avp.fabric.mixin;

import org.avp.common.AVPConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {
    
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        
        AVPConstants.LOGGER.info("This line is printed by an example mod mixin from Fabric!");
        AVPConstants.LOGGER.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}