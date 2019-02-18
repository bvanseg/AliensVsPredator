package org.avp.client;

import org.lwjgl.input.Keyboard;

import com.asx.mdx.core.mods.IPostInitEvent;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class KeybindHandler implements IPostInitEvent
{
    public static final KeybindHandler instance      = new KeybindHandler();
    private static final String        KEYBIND_GROUP = "keybind.group.avp";

    public KeyBinding                  specialSecondary;
    public KeyBinding                  specialPrimary;
    public KeyBinding                  genericSpecial;

    @Override
    public void post(FMLPostInitializationEvent event)
    {
        specialSecondary = Game.registerKeybinding("item.special.secondary", Keyboard.KEY_R, KEYBIND_GROUP);
        specialPrimary = Game.registerKeybinding("item.special.primary", Keyboard.KEY_F, KEYBIND_GROUP);
        genericSpecial = Game.registerKeybinding("generic.special", Keyboard.KEY_V, KEYBIND_GROUP);
    }
}
