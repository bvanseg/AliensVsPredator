package org.avp.common;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.alien.common.AlienBlocks;
import org.alien.common.AlienItems;
import org.apache.commons.lang3.StringUtils;
import org.avp.AVP;
import org.avp.common.item.crafting.AssemblyManager;
import org.avp.common.item.crafting.Schematic;
import org.predator.common.PredatorItems;

import java.util.Arrays;

@EventBusSubscriber
public class CraftingHandler
{
    public static final CraftingHandler instance = new CraftingHandler();
    private static final ItemStack      CHARCOAL = new ItemStack(Items.COAL, 1, 1);

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        addSmelting();
        addSchematics();
    }

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

    private static void addSmelting()
    {
        GameRegistry.addSmelting(AVPBlocks.ORE_COPPER, new ItemStack(AVPItems.ITEM_INGOT_COPPER), 1.0F);
        GameRegistry.addSmelting(AVPBlocks.ORE_LITHIUM, new ItemStack(AVPItems.ITEM_INGOT_LITHIUM), 1.0F);
        GameRegistry.addSmelting(AVPBlocks.ORE_BAUXITE, new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM), 1.0F);
        GameRegistry.addSmelting(AVPBlocks.ORE_SILICON, new ItemStack(AVPItems.ITEM_SILICON), 1.0F);
        GameRegistry.addSmelting(AlienItems.ITEM_RAW_TENTACLE, new ItemStack(AlienItems.ITEM_TRILO_BITE), 2.0F);
        GameRegistry.addSmelting(AlienBlocks.GIGER_LOG, CHARCOAL, 1.0F);
    }

    private static void addSchematics()
    {
        AssemblyManager.register(new Schematic("teslacoil", new ItemStack(AVPBlocks.TESLA_COIL, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 9),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 9),
                        new ItemStack(AVPBlocks.TRANSFORMER, 2),
                        new ItemStack(Blocks.IRON_BLOCK, 1),
                        new ItemStack(AVPBlocks.POWERLINE, 2),
                        new ItemStack(AVPItems.ITEM_CAPACITOR, 6),
                        new ItemStack(AVPItems.ITEM_POWER_SUPPLY, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("terminal", new ItemStack(AVPBlocks.TERMINAL, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 3),
                        new ItemStack(AVPBlocks.TRANSFORMER, 1),
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
        AssemblyManager.register(new Schematic("reflective_slope", new ItemStack(AVPBlocks.SLOPE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.IRON_NUGGET, 8),
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("reflective_corner", new ItemStack(AVPBlocks.CORNER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.IRON_NUGGET, 8),
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("reflective_inverter_corner", new ItemStack(AVPBlocks.INVERTED_CORNER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.IRON_NUGGET, 8),
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("reflective_ridge", new ItemStack(AVPBlocks.RIDGE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.IRON_NUGGET, 8),
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("reflective_pyramid", new ItemStack(AVPBlocks.PYRAMID, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.IRON_NUGGET, 8),
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("reflective_inverted_ridge", new ItemStack(AVPBlocks.INVERTED_RIDGE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.IRON_NUGGET, 8),
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("reflective_inverted_pyramid", new ItemStack(AVPBlocks.INVERTED_PYRAMID, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.IRON_NUGGET, 8),
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                };
            }
        });
        AssemblyManager.register(new Schematic("medpod", new ItemStack(AVPBlocks.MEDPOD, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPBlocks.TERMINAL, 1),
                        new ItemStack(AVPBlocks.LIGHT_PANEL, 2),
                        new ItemStack(AVPBlocks.INDUSTRIAL_GLASS, 4),
                        new ItemStack(Blocks.IRON_BLOCK, 1),
                        new ItemStack(AVPBlocks.PADDING_SQUARE_WHITE, 3),
                        new ItemStack(AVPBlocks.TRANSFORMER, 1),
                        new ItemStack(AVPItems.ITEM_CHARGE_PACK, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 8),
                        PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.HEALING)
                };
            }
        });
        AssemblyManager.register(new Schematic("turret", new ItemStack(AVPBlocks.TURRET, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_M41A, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 4),
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 1)
                };
            }
        });
        AssemblyManager.register(new Schematic("redstonefluxGenerator", new ItemStack(AVPBlocks.UNIVERSAL_GENERATOR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPBlocks.TRANSFORMER, 4),
                        new ItemStack(AVPBlocks.STEPDOWN_TRANSFORMER, 4),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(Items.DIAMOND, 4) };
            }
        });
        AssemblyManager.register(new Schematic("cryostasisTube", new ItemStack(AVPBlocks.CRYO_TUBE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(AVPBlocks.INDUSTRIAL_GLASS, 4),
                        new ItemStack(AVPBlocks.LIGHT_PANEL, 1) };
            }
        });
        AssemblyManager.register(new Schematic("lightPanel", new ItemStack(AVPBlocks.LIGHT_PANEL, 1)) {
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
        AssemblyManager.register(new Schematic("pulserifle", new ItemStack(AVPItems.ITEM_M41A, 1)) {
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
        AssemblyManager.register(new Schematic("grenade", new ItemStack(AVPItems.ITEM_GRENADE, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.IRON_INGOT, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.GUNPOWDER, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("fire_grenade", new ItemStack(AVPItems.ITEM_INCENDIARY_GRENADE, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.IRON_INGOT, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.BLAZE_POWDER, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("marineHelm", new ItemStack(AVPItems.HELM_MARINE, 1)) {
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
        AssemblyManager.register(new Schematic("marinePlate", new ItemStack(AVPItems.PLATE_MARINE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2) };
            }
        });
        AssemblyManager.register(new Schematic("marineLeggings", new ItemStack(AVPItems.LEGS_MARINE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2) };
            }
        });
        AssemblyManager.register(new Schematic("marineBoots", new ItemStack(AVPItems.BOOTS_MARINE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1) };
            }
        });
        AssemblyManager.register(new Schematic("sniperMagazine", new ItemStack(AVPItems.ITEM_AMMO_SNIPER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 5),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("pistolMagazine", new ItemStack(AVPItems.ITEM_AMMO_PISTOL, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(Items.GUNPOWDER, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ARAmmo", new ItemStack(AVPItems.ITEM_AMMO_AR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 5),
                        new ItemStack(Items.IRON_INGOT, 1),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("SMGAmmo", new ItemStack(AVPItems.ITEM_AMMO_SMG, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(Items.IRON_INGOT, 4),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("m56sg", new ItemStack(AVPItems.ITEM_M56SG, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_M56SG_AIMING_MODULE, 1),
                        new ItemStack(AVPItems.ITEM_M56SG_STOCK, 1),
                        new ItemStack(AVPItems.ITEM_M56SG_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_M56SG_SUPPORT_FRAME, 1) };
            }
        });
        AssemblyManager.register(new Schematic("sniper", new ItemStack(AVPItems.ITEM_SNIPER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_SNIPER_SCOPE, 1),
                        new ItemStack(AVPItems.ITEM_SNIPER_ACTION, 1),
                        new ItemStack(AVPItems.ITEM_SNIPER_PERIPHERALS, 1),
                        new ItemStack(AVPItems.ITEM_SNIPER_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_SNIPER_STOCK, 1) };
            }
        });
        AssemblyManager.register(new Schematic("pistol", new ItemStack(AVPItems.ITEM_PISTOL, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_PISTOL_STOCK, 1),
                        new ItemStack(AVPItems.ITEM_PISTOL_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_PISTOL_ACTION, 1) };
            }
        });
        AssemblyManager.register(new Schematic("m4", new ItemStack(AVPItems.ITEM_M4, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_M4_STOCK, 1),
                        new ItemStack(AVPItems.ITEM_M4_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_M4_ACTION, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ak47", new ItemStack(AVPItems.ITEM_AK47, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_AK47_ACTION, 1),
                        new ItemStack(AVPItems.ITEM_AK47_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_AK47_STOCK, 1) };
            }
        });
        AssemblyManager.register(new Schematic("doritos", new ItemStack(AVPItems.ITEM_DORITOS, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.WHEAT, 4),
                        new ItemStack(Items.BAKED_POTATO, 4) };
            }
        });
        AssemblyManager.register(new Schematic("doritosCoolRanch", new ItemStack(AVPItems.ITEM_DORITOS_COOL_RANCH, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_DORITOS, 4),
                        new ItemStack(Items.WHEAT, 3) };
            }
        });
        AssemblyManager.register(new Schematic("motionTracker", new ItemStack(AVPItems.ITEM_MOTION_TRACKER, 1)) {
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
        AssemblyManager.register(new Schematic("flamethrower", new ItemStack(AVPItems.ITEM_M_240_ICU, 1)) {
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
        AssemblyManager.register(new Schematic("nbtDrive", new ItemStack(AVPItems.ITEM_FLASH_DRIVE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_RAM, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticBiomask", new ItemStack(PredatorItems.BIOMASK_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 2),
                        new ItemStack(Items.DIAMOND_HELMET, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2),
                        new ItemStack(AVPItems.ITEM_PROCESSOR, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticPlate", new ItemStack(PredatorItems.CHESTPLATE_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_CHESTPLATE, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 3),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 3) };
            }
        });
        AssemblyManager.register(new Schematic("celticLegs", new ItemStack(PredatorItems.LEGS_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_LEGGINGS, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticBoots", new ItemStack(PredatorItems.BOOTS_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_BOOTS, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticAxe", new ItemStack(PredatorItems.AXE_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_AXE, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticPickaxe", new ItemStack(PredatorItems.PICKAXE_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_PICKAXE, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticHoe", new ItemStack(PredatorItems.HOE_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_HOE, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticShovel", new ItemStack(PredatorItems.SHOVEL_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_SHOVEL, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticSword", new ItemStack(PredatorItems.SWORD_CELTIC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Items.DIAMOND_SWORD, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("wristBlade", new ItemStack(PredatorItems.ITEM_WRISTBRACER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 2),
                        new ItemStack(Items.DIAMOND, 4),
                        new ItemStack(AVPItems.ITEM_LED_DISPLAY, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2) };
            }
        });
        AssemblyManager.register(new Schematic("wristbracerBlades", new ItemStack(PredatorItems.ITEM_WRISTBRACER_BLADES, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 2),
                        new ItemStack(Items.SHEARS, 1),
                        new ItemStack(Items.DIAMOND, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2) };
            }
        });
        AssemblyManager.register(new Schematic("proximityMine", new ItemStack(PredatorItems.ITEM_PROXIMITY_MINE, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(Blocks.TNT, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticDisc", new ItemStack(PredatorItems.ITEM_DISC, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(Items.DIAMOND, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticShuriken", new ItemStack(PredatorItems.ITEM_SHURIKEN, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticSpear", new ItemStack(PredatorItems.ITEM_SPEAR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2),
                        new ItemStack(Items.DIAMOND, 1) };
            }
        });
        AssemblyManager.register(new Schematic("polycarbonate", new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_CARBON, 6),
                        new ItemStack(AVPItems.ITEM_SILICON, 3) };
            }
        });
        AssemblyManager.register(new Schematic("carbon", new ItemStack(AVPItems.ITEM_CARBON, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.COAL, 4) };
            }
        });
        AssemblyManager.register(new Schematic("resistor", new ItemStack(AVPItems.ITEM_RESISTOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 2),
                        new ItemStack(AVPItems.ITEM_CARBON, 1) };
            }
        });
        AssemblyManager.register(new Schematic("capacitor", new ItemStack(AVPItems.ITEM_CAPACITOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
        AssemblyManager.register(new Schematic("diode", new ItemStack(AVPItems.ITEM_DIODE, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1),
                        new ItemStack(AVPItems.ITEM_CARBON, 1),
                        new ItemStack(AVPItems.ITEM_SILICON, 1) };
            }
        });
        AssemblyManager.register(new Schematic("led", new ItemStack(AVPItems.ITEM_LED, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_DIODE, 1),
                        new ItemStack(Items.REDSTONE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("regulator", new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_DIODE, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1),
                        new ItemStack(AVPItems.ITEM_RESISTOR, 1) };
            }
        });
        AssemblyManager.register(new Schematic("transistor", new ItemStack(AVPItems.ITEM_TRANSISTOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_SILICON, 1),
                        new ItemStack(Item.getItemFromBlock(Blocks.LEVER), 1) };
            }
        });
        AssemblyManager.register(new Schematic("ic", new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 2),
                        new ItemStack(AVPItems.ITEM_SILICON, 1),
                        new ItemStack(AVPItems.ITEM_TRANSISTOR, 1),
                        new ItemStack(AVPItems.ITEM_RESISTOR, 1),
                        new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 1),
                        new ItemStack(AVPItems.ITEM_DIODE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("processor", new ItemStack(AVPItems.ITEM_PROCESSOR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 5),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
        AssemblyManager.register(new Schematic("motherboard", new ItemStack(AVPItems.ITEM_MOTHERBOARD, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 1),
                        new ItemStack(AVPItems.ITEM_SILICON, 1),
                        new ItemStack(AVPItems.ITEM_TRANSISTOR, 1),
                        new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 1),
                        new ItemStack(AVPItems.ITEM_DIODE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("powerline", new ItemStack(AVPBlocks.POWERLINE, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("powersupply", new ItemStack(AVPItems.ITEM_POWER_SUPPLY, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_DIODE, 1),
                        new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPBlocks.TRANSFORMER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ledDisplay", new ItemStack(AVPItems.ITEM_LED_DISPLAY, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_LED, 6),
                        new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ram", new ItemStack(AVPItems.ITEM_RAM, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 3),
                        new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 2),
                        new ItemStack(AVPItems.ITEM_SILICON, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("solidstatedrive", new ItemStack(AVPItems.ITEM_SOLID_STATE_DRIVE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_RAM, 2),
                        new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 1),
                        new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1) };
            }
        });
    }
}
