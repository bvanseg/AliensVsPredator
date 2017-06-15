package org.avp.client;

import org.lwjgl.input.Keyboard;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IMod;
import com.arisux.mdx.lib.game.IPostInitEvent;

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
    public void post(IMod mod, FMLPostInitializationEvent event)
    {
        specialSecondary = Game.registerKeybinding("item.special.secondary", Keyboard.KEY_R, KEYBIND_GROUP);
        specialPrimary = Game.registerKeybinding("item.special.primary", Keyboard.KEY_F, KEYBIND_GROUP);
        genericSpecial = Game.registerKeybinding("generic.special", Keyboard.KEY_V, KEYBIND_GROUP);
    }
}
