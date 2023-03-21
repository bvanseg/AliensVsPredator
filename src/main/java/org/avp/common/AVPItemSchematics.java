package org.avp.common;

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
import org.avp.common.block.init.AVPBlocks;
import org.avp.common.block.init.AVPReflectiveBlocks;
import org.avp.common.block.init.AVPTileEntityBlocks;
import org.avp.common.item.crafting.AssemblyManager;
import org.avp.common.item.crafting.ItemSchematic;
import org.predator.common.PredatorItems;

/**
 * @author Ri5ux
 */
@EventBusSubscriber
public class AVPItemSchematics
{
    private AVPItemSchematics() {}

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        addSchematics();
    }

    private static void addSchematics()
    {
        AssemblyManager.register(new ItemSchematic("teslacoil", new ItemStack(AVPTileEntityBlocks.TESLA_COIL, 1)) {
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
        AssemblyManager.register(new ItemSchematic("terminal", new ItemStack(AVPTileEntityBlocks.TERMINAL, 1)) {
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
        AssemblyManager.register(new ItemSchematic("reflective_slope", new ItemStack(AVPReflectiveBlocks.SLOPE, 1)) {
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
        AssemblyManager.register(new ItemSchematic("reflective_corner", new ItemStack(AVPReflectiveBlocks.CORNER, 1)) {
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
        AssemblyManager.register(new ItemSchematic("reflective_inverter_corner", new ItemStack(AVPReflectiveBlocks.INVERTED_CORNER, 1)) {
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
        AssemblyManager.register(new ItemSchematic("reflective_ridge", new ItemStack(AVPReflectiveBlocks.RIDGE, 1)) {
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
        AssemblyManager.register(new ItemSchematic("reflective_pyramid", new ItemStack(AVPReflectiveBlocks.PYRAMID, 1)) {
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
        AssemblyManager.register(new ItemSchematic("reflective_inverted_ridge", new ItemStack(AVPReflectiveBlocks.INVERTED_RIDGE, 1)) {
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
        AssemblyManager.register(new ItemSchematic("reflective_inverted_pyramid", new ItemStack(AVPReflectiveBlocks.INVERTED_PYRAMID, 1)) {
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
        AssemblyManager.register(new ItemSchematic("medpod", new ItemStack(AVPTileEntityBlocks.MEDPOD, 1)) {
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
        AssemblyManager.register(new ItemSchematic("turret", new ItemStack(AVPTileEntityBlocks.TURRET, 1)) {
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
        AssemblyManager.register(new ItemSchematic("redstonefluxGenerator", new ItemStack(AVPTileEntityBlocks.UNIVERSAL_GENERATOR, 1)) {
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
        AssemblyManager.register(new ItemSchematic("cryostasisTube", new ItemStack(AVPTileEntityBlocks.CRYO_TUBE, 1)) {
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
        AssemblyManager.register(new ItemSchematic("lightPanel", new ItemStack(AVPTileEntityBlocks.LIGHT_PANEL, 1)) {
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
        AssemblyManager.register(new ItemSchematic("pulserifle", new ItemStack(AVPItems.ITEM_M41A, 1)) {
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
        AssemblyManager.register(new ItemSchematic("grenade", new ItemStack(AVPItems.ITEM_GRENADE, 2)) {
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
        AssemblyManager.register(new ItemSchematic("fire_grenade", new ItemStack(AVPItems.ITEM_INCENDIARY_GRENADE, 2)) {
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
        AssemblyManager.register(new ItemSchematic("marineHelm", new ItemStack(AVPItems.HELM_MARINE, 1)) {
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
        AssemblyManager.register(new ItemSchematic("marinePlate", new ItemStack(AVPItems.PLATE_MARINE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2) };
            }
        });
        AssemblyManager.register(new ItemSchematic("marineLeggings", new ItemStack(AVPItems.LEGS_MARINE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2) };
            }
        });
        AssemblyManager.register(new ItemSchematic("marineBoots", new ItemStack(AVPItems.BOOTS_MARINE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("sniperMagazine", new ItemStack(AVPItems.ITEM_AMMO_SNIPER, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 5),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("pistolMagazine", new ItemStack(AVPItems.ITEM_AMMO_PISTOL, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(Items.GUNPOWDER, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("ARAmmo", new ItemStack(AVPItems.ITEM_AMMO_AR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 5),
                        new ItemStack(Items.IRON_INGOT, 1),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("SMGAmmo", new ItemStack(AVPItems.ITEM_AMMO_SMG, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 4),
                        new ItemStack(Items.IRON_INGOT, 4),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("m56sg", new ItemStack(AVPItems.ITEM_M56SG, 1)) {
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
        AssemblyManager.register(new ItemSchematic("sniper", new ItemStack(AVPItems.ITEM_SNIPER, 1)) {
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
        AssemblyManager.register(new ItemSchematic("pistol", new ItemStack(AVPItems.ITEM_PISTOL, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_PISTOL_STOCK, 1),
                        new ItemStack(AVPItems.ITEM_PISTOL_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_PISTOL_ACTION, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("m4", new ItemStack(AVPItems.ITEM_M4, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_M4_STOCK, 1),
                        new ItemStack(AVPItems.ITEM_M4_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_M4_ACTION, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("ak47", new ItemStack(AVPItems.ITEM_AK47, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_AK47_ACTION, 1),
                        new ItemStack(AVPItems.ITEM_AK47_BARREL, 1),
                        new ItemStack(AVPItems.ITEM_AK47_STOCK, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("doritos", new ItemStack(AVPItems.ITEM_DORITOS, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.WHEAT, 4),
                        new ItemStack(Items.BAKED_POTATO, 4) };
            }
        });
        AssemblyManager.register(new ItemSchematic("doritosCoolRanch", new ItemStack(AVPItems.ITEM_DORITOS_COOL_RANCH, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_DORITOS, 4),
                        new ItemStack(Items.WHEAT, 3) };
            }
        });
        AssemblyManager.register(new ItemSchematic("motionTracker", new ItemStack(AVPItems.ITEM_MOTION_TRACKER, 1)) {
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
        AssemblyManager.register(new ItemSchematic("flamethrower", new ItemStack(AVPItems.ITEM_M_240_ICU, 1)) {
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
        AssemblyManager.register(new ItemSchematic("nbtDrive", new ItemStack(AVPItems.ITEM_FLASH_DRIVE, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_RAM, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("celticBiomask", new ItemStack(PredatorItems.BIOMASK_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticPlate", new ItemStack(PredatorItems.CHESTPLATE_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticLegs", new ItemStack(PredatorItems.LEGS_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticBoots", new ItemStack(PredatorItems.BOOTS_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticAxe", new ItemStack(PredatorItems.AXE_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticPickaxe", new ItemStack(PredatorItems.PICKAXE_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticHoe", new ItemStack(PredatorItems.HOE_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticShovel", new ItemStack(PredatorItems.SHOVEL_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticSword", new ItemStack(PredatorItems.SWORD_CELTIC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("wristBlade", new ItemStack(PredatorItems.ITEM_WRISTBRACER, 1)) {
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
        AssemblyManager.register(new ItemSchematic("wristbracerBlades", new ItemStack(PredatorItems.ITEM_WRISTBRACER_BLADES, 1)) {
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
        AssemblyManager.register(new ItemSchematic("proximityMine", new ItemStack(PredatorItems.ITEM_PROXIMITY_MINE, 3)) {
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
        AssemblyManager.register(new ItemSchematic("celticDisc", new ItemStack(PredatorItems.ITEM_DISC, 1)) {
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
        AssemblyManager.register(new ItemSchematic("celticShuriken", new ItemStack(PredatorItems.ITEM_SHURIKEN, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 2) };
            }
        });
        AssemblyManager.register(new ItemSchematic("celticSpear", new ItemStack(PredatorItems.ITEM_SPEAR, 1)) {
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
        AssemblyManager.register(new ItemSchematic("polycarbonate", new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_CARBON, 6),
                        new ItemStack(AVPItems.ITEM_SILICON, 3) };
            }
        });
        AssemblyManager.register(new ItemSchematic("carbon", new ItemStack(AVPItems.ITEM_CARBON, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.COAL, 4) };
            }
        });
        AssemblyManager.register(new ItemSchematic("resistor", new ItemStack(AVPItems.ITEM_RESISTOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 2),
                        new ItemStack(AVPItems.ITEM_CARBON, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("capacitor", new ItemStack(AVPItems.ITEM_CAPACITOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 2),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("diode", new ItemStack(AVPItems.ITEM_DIODE, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1),
                        new ItemStack(AVPItems.ITEM_CARBON, 1),
                        new ItemStack(AVPItems.ITEM_SILICON, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("led", new ItemStack(AVPItems.ITEM_LED, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_DIODE, 1),
                        new ItemStack(Items.REDSTONE, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("regulator", new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_DIODE, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1),
                        new ItemStack(AVPItems.ITEM_RESISTOR, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("transistor", new ItemStack(AVPItems.ITEM_TRANSISTOR, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPItems.ITEM_SILICON, 1),
                        new ItemStack(Item.getItemFromBlock(Blocks.LEVER), 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("ic", new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 2)) {
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
        AssemblyManager.register(new ItemSchematic("processor", new ItemStack(AVPItems.ITEM_PROCESSOR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 1),
                        new ItemStack(AVPItems.ITEM_INTEGRATED_CIRCUIT, 5),
                        new ItemStack(AVPItems.ITEM_INGOT_LITHIUM, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("motherboard", new ItemStack(AVPItems.ITEM_MOTHERBOARD, 1)) {
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
        AssemblyManager.register(new ItemSchematic("powerline", new ItemStack(AVPTileEntityBlocks.POWERLINE, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_POLYCARBONATE, 4),
                        new ItemStack(AVPItems.ITEM_INGOT_COPPER, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("powersupply", new ItemStack(AVPItems.ITEM_POWER_SUPPLY, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(AVPItems.ITEM_DIODE, 1),
                        new ItemStack(AVPItems.ITEM_VOLTAGE_REGULATOR, 1),
                        new ItemStack(AVPItems.ITEM_INGOT_ALUMINUM, 2),
                        new ItemStack(AVPTileEntityBlocks.TRANSFORMER, 1) };
            }
        });
        AssemblyManager.register(new ItemSchematic("ledDisplay", new ItemStack(AVPItems.ITEM_LED_DISPLAY, 2)) {
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
        AssemblyManager.register(new ItemSchematic("ram", new ItemStack(AVPItems.ITEM_RAM, 2)) {
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
        AssemblyManager.register(new ItemSchematic("solidstatedrive", new ItemStack(AVPItems.ITEM_SOLID_STATE_DRIVE, 1)) {
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
