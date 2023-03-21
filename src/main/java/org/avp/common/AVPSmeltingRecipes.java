package org.avp.common;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.alien.common.AlienBlocks;
import org.alien.common.AlienItems;

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
        GameRegistry.addSmelting(AVPBlocks.ORE_COPPER, new ItemStack(AVPItems.ITEM_INGOT_COPPER), 1.0F);
        GameRegistry.addSmelting(AVPBlocks.ORE_LITHIUM, new ItemStack(AVPItems.ITEM_INGOT_LITHIUM), 1.0F);
        GameRegistry.addSmelting(AVPBlocks.ORE_BAUXITE, new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM), 1.0F);
        GameRegistry.addSmelting(AVPBlocks.ORE_SILICON, new ItemStack(AVPItems.ITEM_SILICON), 1.0F);
        GameRegistry.addSmelting(AlienItems.ITEM_RAW_TENTACLE, new ItemStack(AlienItems.ITEM_TRILO_BITE), 2.0F);
        GameRegistry.addSmelting(AlienBlocks.GIGER_LOG, CHARCOAL, 1.0F);
    }
}
