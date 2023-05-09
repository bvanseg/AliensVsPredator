package org.avp.common;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.AVP;
import org.avp.common.block.init.AVPBlocks;
import org.avp.common.block.init.AVPTileEntityBlocks;
import org.avp.common.item.crafting.ItemSchematic;
import org.avp.common.item.crafting.ItemSchematicRegistry;
import org.avp.common.item.init.AVPArmorItems;
import org.avp.common.item.init.AVPItems;
import org.weapon.common.item.init.WeaponItems;

import java.util.HashMap;

/**
 * @author Ri5ux
 */
public class AVPItemSchematics
{
    private AVPItemSchematics() {}

    public static void registerRecipes()
    {
        addSchematicsForVanillaStyleRecipes();
        addSchematics();
    }

    private static void addSchematicsForVanillaStyleRecipes() {
        ForgeRegistries.RECIPES.getEntries().forEach(entry -> {
            ResourceLocation res = entry.getKey();
            IRecipe recipe = entry.getValue();
            ItemStack result = recipe.getRecipeOutput();

            // We only want avp items to be craftable in the assembler.
            if (!res.getNamespace().equalsIgnoreCase("avp")) return;

            // Exclude certain items to avoid duping exploits.
            if (result.getItem() == AVPItems.ITEM_INGOT_ALUMINUM) return;
            if (result.getItem() == AVPItems.ITEM_INGOT_COPPER) return;
            if (result.getItem() == Item.getItemFromBlock(AVPBlocks.ALUMINUM_BLOCK)) return;
            if (result.getItem() == Item.getItemFromBlock(AVPBlocks.COPPER_BLOCK)) return;
            if (result.getItem() == Item.getItemFromBlock(AVPBlocks.RAW_BAUXITE_BLOCK)) return;
            if (result.getItem() == Item.getItemFromBlock(AVPBlocks.RAW_COPPER_BLOCK)) return;

            NonNullList<Ingredient> ingredients = recipe.getIngredients();

            HashMap<Item, Integer> itemToCount = new HashMap<>();

            for (Ingredient ingredient: ingredients) {
                ItemStack[] matchingStacks = ingredient.getMatchingStacks();

                for (ItemStack itemStack: matchingStacks) {
                    if (itemStack.getItem().getRegistryName() == null || itemStack.getItemDamage() != 0)
                        continue;

                    // It's expected that avp crafting recipes use only minecraft and avp items. So we only listen for these
                    // namespaces in matching stacks. Otherwise, we might accidentally include ore-dict itemstacks like sulphur
                    // from thermal series, for example.
                    if (!itemStack.getItem().getRegistryName().getNamespace().equalsIgnoreCase(AVP.Properties.ID) &&
                            !itemStack.getItem().getRegistryName().getNamespace().equalsIgnoreCase("minecraft"))
                        continue;

                    Item item = itemStack.getItem();
                    int count = itemStack.getCount();
                    itemToCount.merge(item, count, Integer::sum);
                }
            }

            ItemSchematic itemSchematic = new ItemSchematic(result) {
                @Override
                public ItemStack[] getItemsRequired()
                {
                    return itemToCount.entrySet().stream().map(
                            e -> new ItemStack(e.getKey(), calculateReducedCost(e.getValue()))
                    ).toArray(ItemStack[]::new);
                }
            };

            ItemSchematicRegistry.register(itemSchematic);
        });
    }

    private static int calculateReducedCost(int count) {
        return (int) Math.max(Math.ceil(count / 2D), 1);
    }

    private static void addSchematics()
    {
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPTileEntityBlocks.TESLA_COIL, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 9),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 9),
                        new ItemStack(AVPTileEntityBlocks.TRANSFORMER, 2),
                        new ItemStack(Blocks.IRON_BLOCK, 1),
                        new ItemStack(AVPTileEntityBlocks.POWERLINE, 2),
                        new ItemStack(AVPItems.ITEM_CAPACITOR, 6),
                        new ItemStack(AVPItems.ITEM_POWER_SUPPLY, 1),
                };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPTileEntityBlocks.TERMINAL, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 3),
                        new ItemStack(AVPTileEntityBlocks.TRANSFORMER, 1),
                        new ItemStack(AVPBlocks.MUTHUR_PANEL_1, 3),
                        new ItemStack(AVPBlocks.MUTHUR_PANEL_2, 3),
                        new ItemStack(AVPItems.ITEM_POWER_SUPPLY, 1),
                        new ItemStack(AVPItems.ITEM_RAM, 6),
                        new ItemStack(AVPItems.ITEM_PROCESSOR, 6),
                        new ItemStack(AVPItems.ITEM_SOLID_STATE_DRIVE, 2),
                        new ItemStack(AVPItems.ITEM_MOTHERBOARD, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 6),
                        new ItemStack(Blocks.STONE_BUTTON, 16),
                };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPTileEntityBlocks.MEDPOD, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPTileEntityBlocks.TERMINAL, 1),
                        new ItemStack(AVPTileEntityBlocks.LIGHT_PANEL, 2),
                        new ItemStack(AVPBlocks.INDUSTRIAL_GLASS, 4),
                        new ItemStack(Blocks.IRON_BLOCK, 1),
                        new ItemStack(AVPBlocks.PADDING_SQUARE_WHITE, 3),
                        new ItemStack(AVPTileEntityBlocks.TRANSFORMER, 1),
                        new ItemStack(AVPItems.ITEM_CHARGE_PACK, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 8),
                        PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.HEALING)
                };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPTileEntityBlocks.TURRET, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(WeaponItems.ITEM_M41A, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 4),
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 1)
                };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPTileEntityBlocks.UNIVERSAL_GENERATOR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPTileEntityBlocks.TRANSFORMER, 4),
                        new ItemStack(AVPTileEntityBlocks.STEPDOWN_TRANSFORMER, 4),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(Items.DIAMOND, 4) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPTileEntityBlocks.CRYO_TUBE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(AVPBlocks.INDUSTRIAL_GLASS, 4),
                        new ItemStack(AVPTileEntityBlocks.LIGHT_PANEL, 1) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPTileEntityBlocks.LIGHT_PANEL, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPBlocks.INDUSTRIAL_GLASS, 2),
                        new ItemStack(Items.GLOWSTONE_DUST, 2) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(WeaponItems.ITEM_M41A, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 8),
                        new ItemStack(Items.IRON_INGOT, 8),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 6),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 6),
                        new ItemStack(Items.GOLD_INGOT, 4),
                        new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 2),
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 1) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPArmorItems.HELM_MARINE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2),
                        new ItemStack(AVPItems.ITEM_PROCESSOR, 1) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(WeaponItems.ITEM_AMMO_SNIPER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 5),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(WeaponItems.ITEM_AMMO_SMG, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(Items.IRON_INGOT, 4),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(WeaponItems.ITEM_M56SG, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(WeaponItems.ITEM_M56SG_AIMING_MODULE, 1),
                        new ItemStack(WeaponItems.ITEM_M56SG_STOCK, 1),
                        new ItemStack(WeaponItems.ITEM_M56SG_BARREL, 1),
                        new ItemStack(WeaponItems.ITEM_M56SG_SUPPORT_FRAME, 1) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(WeaponItems.ITEM_SNIPER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(WeaponItems.ITEM_SNIPER_SCOPE, 1),
                        new ItemStack(WeaponItems.ITEM_SNIPER_ACTION, 1),
                        new ItemStack(WeaponItems.ITEM_SNIPER_PERIPHERALS, 1),
                        new ItemStack(WeaponItems.ITEM_SNIPER_BARREL, 1),
                        new ItemStack(WeaponItems.ITEM_SNIPER_STOCK, 1) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPItems.ITEM_MOTION_TRACKER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 6),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 8),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 6),
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 2),
                        new ItemStack(AVPItems.ITEM_PROCESSOR, 2),
                        new ItemStack(Items.DIAMOND, 1),
                        new ItemStack(Items.IRON_INGOT, 8) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(WeaponItems.ITEM_M_240_ICU, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 3),
                        new ItemStack(Items.BLAZE_ROD, 1),
                        new ItemStack(Items.IRON_INGOT, 6) };
            }
        });
        ItemSchematicRegistry.register(new ItemSchematic(new ItemStack(AVPItems.ITEM_FLASH_DRIVE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_RAM, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
    }
}
