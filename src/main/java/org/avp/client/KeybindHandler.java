package org.avp.client;

import com.asx.mdx.common.Game;
import com.asx.mdx.common.mods.IPostInitEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.lwjgl.input.Keyboard;

public class KeybindHandler implements IPostInitEvent
{
    public static final KeybindHandler instance      = new KeybindHandler();
    private static final String        KEYBIND_GROUP = "keybind.group.avp";

    public KeyBinding                  specialPrimary;
    public KeyBinding                  specialSecondary;
    public KeyBinding                  genericSpecial;

    @Override
    public void post(FMLPostInitializationEvent event)
    {
        specialPrimary = Game.instance.registerKeybinding("item.special.primary", Keyboard.KEY_G, KEYBIND_GROUP);
        specialSecondary = Game.instance.registerKeybinding("item.special.secondary", Keyboard.KEY_R, KEYBIND_GROUP);
        genericSpecial = Game.instance.registerKeybinding("generic.special", Keyboard.KEY_V, KEYBIND_GROUP);
    }
}
