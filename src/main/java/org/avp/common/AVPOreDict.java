package org.avp.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.alien.common.AlienBlocks;
import org.apache.commons.lang3.StringUtils;
import org.avp.AVP;

import java.util.Arrays;

/**
 * @author Ri5ux
 */
@EventBusSubscriber
public class AVPOreDict
{
    public static final AVPOreDict instance = new AVPOreDict();

    private AVPOreDict() {}

    @SubscribeEvent
    public static void registerOres(RegistryEvent.Register<IRecipe> event)
    {
        AVP.log().info("Ore dictionary registration");
        
        registerOreDict("copper", AVPItems.ITEM_INGOT_COPPER, "ingot");
        registerOreDict("lithium", AVPItems.ITEM_INGOT_LITHIUM, "ingot");
        registerOreDict("aluminum", AVPItems.ITEM_INGOT_ALUMINUM, "ingot");
        registerOreDict("cobalt", AVPItems.ITEM_COBALT, "ingot");

        registerOreDict("silicon", AVPItems.ITEM_SILICON, "", "material");
        registerOreDict("silica", AVPItems.ITEM_SILICON, "", "material");
        registerOreDict("polycarbonate", AVPItems.ITEM_POLYCARBONATE, "", "material");
        registerOreDict("plastic", AVPItems.ITEM_POLYCARBONATE, "", "material");
        registerOreDict("neodymium", AVPItems.ITEM_NEODYMIUM, "", "material");
        registerOreDict("magnet", AVPItems.ITEM_NEODYMIUM_MAGNET, "", "material");
        registerOreDict("carbon", AVPItems.ITEM_CARBON, "", "material");

        registerOreDict("copper", AVPBlocks.ORE_COPPER, "ore");
        registerOreDict("lithium", AVPBlocks.ORE_LITHIUM, "ore");
        registerOreDict("aluminum", AVPBlocks.ORE_BAUXITE, "ore");
        registerOreDict("aluminium", AVPBlocks.ORE_BAUXITE, "ore");
        registerOreDict("silicon", AVPBlocks.ORE_SILICON, "ore");
        registerOreDict("monazite", AVPBlocks.ORE_MONAZITE, "ore");
        registerOreDict("cobalt", AVPBlocks.ORE_COBALT, "ore");

        
        registerOreDict("wood", AlienBlocks.GIGER_LOG, "log");
    }
    
    public static void registerOreDict(String name, Item item, String... prefixes)
    {
        registerOreDict(name, item, false, prefixes);
    }
    
    public static void registerOreDict(String name, Item item, boolean registerSingleName, String... prefixes)
    {
        String tempName = name.toLowerCase();
        
        if(registerSingleName)
            OreDictionary.registerOre(tempName, item);
        
        Arrays.stream(prefixes).forEach(e ->
        {
            OreDictionary.registerOre(e + "." + tempName, item);
            OreDictionary.registerOre(e + "_" + tempName, item);
            OreDictionary.registerOre(e + (e.isEmpty() ? tempName : StringUtils.capitalize(tempName)), item);
        });
    }
    
    public static void registerOreDict(String name, Block block, String... prefixes)
    {
        registerOreDict(name, block, false, prefixes);
    }
    
    public static void registerOreDict(String name, Block block, boolean registerSingleName, String... prefixes)
    {
        String tempName = name.toLowerCase();
        
        if(registerSingleName)
            OreDictionary.registerOre(tempName, block);
        
        Arrays.stream(prefixes).forEach(e ->
        {
            OreDictionary.registerOre(e + "." + tempName, block);
            OreDictionary.registerOre(e + "_" + tempName, block);
            OreDictionary.registerOre(e + StringUtils.capitalize(tempName), block);
        });
    }
}
