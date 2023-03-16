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

    public KeyBinding                  specialSecondary;
    public KeyBinding                  specialPrimary;
    public KeyBinding                  genericSpecial;

    @Override
    public void post(FMLPostInitializationEvent event)
    {
        specialSecondary = Game.instance.registerKeybinding("item.special.secondary", Keyboard.KEY_R, KEYBIND_GROUP);
        specialPrimary = Game.instance.registerKeybinding("item.special.primary", Keyboard.KEY_F, KEYBIND_GROUP);
        genericSpecial = Game.instance.registerKeybinding("generic.special", Keyboard.KEY_V, KEYBIND_GROUP);
    }
}
