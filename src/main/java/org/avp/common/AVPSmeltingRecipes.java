package org.avp.common;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.alien.common.AlienItems;
import org.alien.common.block.init.AlienParadiseBlocks;
import org.alien.common.block.init.AlienVardaBlocks;
import org.avp.common.block.init.AVPOreBlocks;
import org.avp.common.item.init.AVPItems;

/**
 * @author Ri5ux
 */
@EventBusSubscriber
public class AVPSmeltingRecipes
{
    private static final ItemStack CHARCOAL = new ItemStack(Items.COAL, 1, 1);

    private AVPSmeltingRecipes() {}

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        addSmelting();
    }

    private static void addSmelting()
    {
        GameRegistry.addSmelting(AVPOreBlocks.ORE_LITHIUM, new ItemStack(AVPItems.ITEM_INGOT_LITHIUM), 1.0F);
        GameRegistry.addSmelting(AVPOreBlocks.ORE_SILICON, new ItemStack(AVPItems.ITEM_SILICON), 1.0F);
        GameRegistry.addSmelting(AlienItems.ITEM_RAW_TENTACLE, new ItemStack(AlienItems.ITEM_TRILO_BITE), 2.0F);

        GameRegistry.addSmelting(AlienVardaBlocks.GIGER_LOG, CHARCOAL, 1.0F);
        GameRegistry.addSmelting(AlienParadiseBlocks.PARADISE_LOG_SMALL, CHARCOAL, 1.0F);
        GameRegistry.addSmelting(AlienParadiseBlocks.PARADISE_LOG_MED, CHARCOAL, 1.0F);
        GameRegistry.addSmelting(AlienParadiseBlocks.PARADISE_LOG_LARGE, CHARCOAL, 1.0F);

        addAluminumSmeltingRecipes();
        addCopperSmeltingRecipes();
    }

    private static void addAluminumSmeltingRecipes() {
        GameRegistry.addSmelting(AVPOreBlocks.ORE_BAUXITE, new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM), 1.0F);
        GameRegistry.addSmelting(AVPItems.RAW_BAUXITE, new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM), 1.0F);

        GameRegistry.addSmelting(AVPItems.ALUMINUM_PICKAXE, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_SHOVEL, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_AXE, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_HOE, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_SWORD, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_HELMET, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_CHESTPLATE, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_LEGGINGS, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.ALUMINUM_BOOTS, new ItemStack(AVPItems.ALUMINUM_NUGGET), 0.1F);
    }

    private static void addCopperSmeltingRecipes() {
        GameRegistry.addSmelting(AVPOreBlocks.ORE_COPPER, new ItemStack(AVPItems.ITEM_INGOT_COPPER), 1.0F);
        GameRegistry.addSmelting(AVPItems.RAW_COPPER, new ItemStack(AVPItems.ITEM_INGOT_COPPER), 1.0F);

        GameRegistry.addSmelting(AVPItems.COPPER_PICKAXE, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_SHOVEL, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_AXE, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_HOE, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_SWORD, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_HELMET, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_CHESTPLATE, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_LEGGINGS, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
        GameRegistry.addSmelting(AVPItems.COPPER_BOOTS, new ItemStack(AVPItems.COPPER_NUGGET), 0.1F);
    }
}
