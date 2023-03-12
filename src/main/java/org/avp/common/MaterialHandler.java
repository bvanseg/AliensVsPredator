package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.avp.common.block.materials.MaterialBlackGoo;
import org.avp.common.block.materials.MaterialMist;

public class MaterialHandler implements IInitEvent
{
    public static MaterialHandler instance = new MaterialHandler();
    private static final Armors armors = new Armors();
    private static final Tools tools = new Tools();

    public final Material mist = new MaterialMist();
    public final Material blackgoo = new MaterialBlackGoo();

    //TODO: Armor enum textures, sounds, and toughness
    public static class Armors
    {
        public final ArmorMaterial celtic = EnumHelper.addArmorMaterial("celtic", "items.celtic", 34, new int[] { 4, 7, 5, 3 }, 20, null, 5);
        public final ArmorMaterial chitin = EnumHelper.addArmorMaterial("chitin", "items.chitin", 30, new int[] { 2, 7, 5, 3 }, 7, null, 1);
        public final ArmorMaterial kevlar = EnumHelper.addArmorMaterial("kevlar", "items.kevlar", 26, new int[] { 2, 6, 3, 2 }, 5, null, 2);
        public final ArmorMaterial pressuresuit = EnumHelper.addArmorMaterial("pressuresuit", "items.pressuresuit", 22, new int[] { 2, 4, 3, 2 }, 6, null, 1);
        public final ArmorMaterial mk50 = EnumHelper.addArmorMaterial("mk50", "items.mk50", 24, new int[] { 2, 4, 3, 2 }, 6, null, 1);
    }

    public static class Tools
    {
        public final ToolMaterial celtic = EnumHelper.addToolMaterial("celtic", 12, 1430, 9.0F, 8.0F, 9);
        public final ToolMaterial chitin = EnumHelper.addToolMaterial("chitin", 7, 730, 10.0F, 7.0F, 14);
    }

    public Armors armors()
    {
        return armors;
    }

    public Tools tools()
    {
        return tools;
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        ;
    }
}
