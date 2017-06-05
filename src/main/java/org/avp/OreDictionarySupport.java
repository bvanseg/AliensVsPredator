package org.avp;

import com.arisux.mdx.lib.game.IInitEvent;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionarySupport implements IInitEvent
{
    public static OreDictionarySupport instance = new OreDictionarySupport();

    public void init(FMLInitializationEvent event)
    {
        OreDictionary.registerOre("copper", AliensVsPredator.items().itemIngotCopper);
        OreDictionary.registerOre("ingotCopper", AliensVsPredator.items().itemIngotCopper);
        OreDictionary.registerOre("lithium", AliensVsPredator.items().itemIngotLithium);
        OreDictionary.registerOre("itemLithium", AliensVsPredator.items().itemIngotLithium);
        OreDictionary.registerOre("aluminum", AliensVsPredator.items().itemIngotAluminum);
        OreDictionary.registerOre("ingotAluminum", AliensVsPredator.items().itemIngotAluminum);
        OreDictionary.registerOre("aluminium", AliensVsPredator.items().itemIngotAluminum);
        OreDictionary.registerOre("ingotAluminium", AliensVsPredator.items().itemIngotAluminum);
        System.out.println("COPPER: " + Item.getItemFromBlock(AliensVsPredator.blocks().oreCopper));
        OreDictionary.registerOre("oreCopper", AliensVsPredator.blocks().oreCopper);
        OreDictionary.registerOre("oreLithium", AliensVsPredator.blocks().oreLithium);
        OreDictionary.registerOre("oreAluminum", AliensVsPredator.blocks().oreBauxite);
        OreDictionary.registerOre("oreAluminium", AliensVsPredator.blocks().oreBauxite);
        OreDictionary.registerOre("oreSilicon", AliensVsPredator.blocks().oreSilicon);
        OreDictionary.registerOre("silicon", AliensVsPredator.items().itemSilicon);
        OreDictionary.registerOre("itemSilicon", AliensVsPredator.items().itemSilicon);
        OreDictionary.registerOre("polycarbonate", AliensVsPredator.items().itemPolycarbonate);
        OreDictionary.registerOre("itemPolycarbonate", AliensVsPredator.items().itemPolycarbonate);
        OreDictionary.registerOre("plastic", AliensVsPredator.items().itemPolycarbonate);
        OreDictionary.registerOre("itemPlastic", AliensVsPredator.items().itemPolycarbonate);
        OreDictionary.registerOre("logWood", AliensVsPredator.blocks().terrainUniTreeLog);
        OreDictionary.registerOre("log", AliensVsPredator.blocks().terrainUniTreeLog);
    }
}
