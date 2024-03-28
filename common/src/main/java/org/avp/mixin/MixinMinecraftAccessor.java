package org.avp.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Minecraft.class)
public interface MixinMinecraftAccessor {

    @Accessor("rightClickDelay")
    public void setRightClickDelay(int rightClickDelay);
}
