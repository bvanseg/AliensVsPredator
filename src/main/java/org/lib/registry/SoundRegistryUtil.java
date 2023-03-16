package org.lib.registry;

import com.asx.mdx.client.sound.Sound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.AVP;

/**
 * @author Boston Vanseghi
 */
public class SoundRegistryUtil {
    public static Sound createSound(String name)
    {
        return new Sound(new ResourceLocation(AVP.Properties.DOMAIN + name));
    }

    public static void registerSound(Sound sound) {
        ForgeRegistries.SOUND_EVENTS.register(sound.createSoundEvent(sound.getLocation().getPath()));
    }
}
