package org.avp.mixin;

import org.avp.AVPConstants;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    
    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {
        
        AVPConstants.LOGGER.info("This line is printed by an example mod common mixin!");
        AVPConstants.LOGGER.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}