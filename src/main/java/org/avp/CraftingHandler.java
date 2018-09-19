package org.avp;

import org.avp.item.crafting.AssemblyManager;
import org.avp.item.crafting.Schematic;

import com.arisux.mdx.lib.game.IInitEvent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingHandler implements IInitEvent
{
    public static final CraftingHandler instance = new CraftingHandler();
    private static final ItemStack      CHARCOAL = new ItemStack(Items.COAL, 1, 1);

    @Override
    public void init(FMLInitializationEvent event)
    {
        ItemHandler items = AliensVsPredator.items();
        BlockHandler blocks = AliensVsPredator.blocks();

        this.addOreDictionarySupport(items, blocks);
        this.addSmelting(items, blocks);
        this.addSchematics(items, blocks);
    }

    private void addOreDictionarySupport(ItemHandler items, BlockHandler blocks)
    {
        OreDictionary.registerOre("copper", items.itemIngotCopper);
        OreDictionary.registerOre("ingotCopper", items.itemIngotCopper);
        OreDictionary.registerOre("lithium", items.itemIngotLithium);
        OreDictionary.registerOre("itemLithium", items.itemIngotLithium);
        OreDictionary.registerOre("aluminum", items.itemIngotAluminum);
        OreDictionary.registerOre("ingotAluminum", items.itemIngotAluminum);
        OreDictionary.registerOre("aluminium", items.itemIngotAluminum);
        OreDictionary.registerOre("ingotAluminium", items.itemIngotAluminum);
        OreDictionary.registerOre("oreCopper", blocks.oreCopper);
        OreDictionary.registerOre("oreLithium", blocks.oreLithium);
        OreDictionary.registerOre("oreAluminum", blocks.oreBauxite);
        OreDictionary.registerOre("oreAluminium", blocks.oreBauxite);
        OreDictionary.registerOre("oreSilicon", blocks.oreSilicon);
        OreDictionary.registerOre("silicon", items.itemSilicon);
        OreDictionary.registerOre("itemSilicon", items.itemSilicon);
        OreDictionary.registerOre("polycarbonate", items.itemPolycarbonate);
        OreDictionary.registerOre("itemPolycarbonate", items.itemPolycarbonate);
        OreDictionary.registerOre("plastic", items.itemPolycarbonate);
        OreDictionary.registerOre("itemPlastic", items.itemPolycarbonate);
        OreDictionary.registerOre("logWood", blocks.gigerLog);
        OreDictionary.registerOre("log", blocks.gigerLog);
        OreDictionary.registerOre("neodymium", items.neodymium);
        OreDictionary.registerOre("oreMonazite", blocks.oreMonazite);
        OreDictionary.registerOre("cobalt", items.cobalt);
        OreDictionary.registerOre("oreCobalt", blocks.oreCobalt);
    }

    private void addSmelting(ItemHandler items, BlockHandler blocks)
    {
        GameRegistry.addSmelting(blocks.oreCopper, new ItemStack(items.itemIngotCopper), 1.0F);
        GameRegistry.addSmelting(blocks.oreLithium, new ItemStack(items.itemIngotLithium), 1.0F);
        GameRegistry.addSmelting(blocks.oreBauxite, new ItemStack(items.itemIngotAluminum), 1.0F);
        GameRegistry.addSmelting(blocks.oreSilicon, new ItemStack(items.itemSilicon), 1.0F);
        GameRegistry.addSmelting(blocks.gigerLog, CHARCOAL, 1.0F);
    }

    private void addSchematics(ItemHandler items, BlockHandler blocks)
    {
        AssemblyManager.register(new Schematic("turret", new ItemStack(blocks.turret, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemM41A, 1),
                    new ItemStack(items.itemPolycarbonate, 4),
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(items.itemIngotCopper, 4),
                    new ItemStack(items.itemLedDisplay, 1)
                };
            }
        });
        AssemblyManager.register(new Schematic("redstonefluxGenerator", new ItemStack(blocks.universalGenerator, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(blocks.transformer, 4),
                    new ItemStack(blocks.stepdownTransformer, 4),
                    new ItemStack(items.itemPolycarbonate, 4),
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(Items.DIAMOND, 4) };
            }
        });
        AssemblyManager.register(new Schematic("cryostasisTube", new ItemStack(blocks.cryoTube, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 4),
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(blocks.industrialglass, 4),
                    new ItemStack(blocks.lightPanel, 1) };
            }
        });
        AssemblyManager.register(new Schematic("lightPanel", new ItemStack(blocks.lightPanel, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 2),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(blocks.industrialglass, 2),
                    new ItemStack(Items.GLOWSTONE_DUST, 2) };
            }
        });
        AssemblyManager.register(new Schematic("pulserifle", new ItemStack(items.itemM41A, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 8),
                    new ItemStack(Items.IRON_INGOT, 8),
                    new ItemStack(items.itemIngotAluminum, 6),
                    new ItemStack(items.itemIngotCopper, 6),
                    new ItemStack(Items.GOLD_INGOT, 4),
                    new ItemStack(items.itemIntegratedCircuit, 2),
                    new ItemStack(items.itemLedDisplay, 1) };
            }
        });
        AssemblyManager.register(new Schematic("grenade", new ItemStack(items.itemGrenade, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Items.IRON_INGOT, 2),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(Items.GUNPOWDER, 1),
                    new ItemStack(items.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("fire_grenade", new ItemStack(items.itemIncendiaryGrenade, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Items.IRON_INGOT, 2),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(Items.BLAZE_POWDER, 1),
                    new ItemStack(items.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("marineHelm", new ItemStack(items.helmMarine, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Blocks.WOOL, 3),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemLedDisplay, 2),
                    new ItemStack(items.itemPolycarbonate, 2),
                    new ItemStack(items.itemProcessor, 1) };
            }
        });
        AssemblyManager.register(new Schematic("marinePlate", new ItemStack(items.plateMarine, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Blocks.WOOL, 3),
                    new ItemStack(items.itemIngotAluminum, 2) };
            }
        });
        AssemblyManager.register(new Schematic("marineLeggings", new ItemStack(items.legsMarine, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Blocks.WOOL, 3),
                    new ItemStack(items.itemIngotAluminum, 2) };
            }
        });
        AssemblyManager.register(new Schematic("marineBoots", new ItemStack(items.bootsMarine, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Blocks.WOOL, 1),
                    new ItemStack(items.itemIngotAluminum, 1) };
            }
        });
        AssemblyManager.register(new Schematic("sniperMagazine", new ItemStack(items.itemAmmoSniper, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotAluminum, 5),
                    new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("pistolMagazine", new ItemStack(items.itemAmmoPistol, 3))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(Items.GUNPOWDER, 2),
                    new ItemStack(items.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ARAmmo", new ItemStack(items.itemAmmoAR, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotAluminum, 5),
                    new ItemStack(Items.IRON_INGOT, 1),
                    new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("SMGAmmo", new ItemStack(items.itemAmmoSMG, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(Items.IRON_INGOT, 4),
                    new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("m56sg", new ItemStack(items.itemM56SG, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemM56SGAimingModule, 1),
                    new ItemStack(items.itemM56SGStock, 1),
                    new ItemStack(items.itemM56SGBarrel, 1),
                    new ItemStack(items.itemM56SGSupportFrame, 1) };
            }
        });
        AssemblyManager.register(new Schematic("sniper", new ItemStack(items.itemSniper, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemSniperScope, 1),
                    new ItemStack(items.itemSniperAction, 1),
                    new ItemStack(items.itemSniperPeripherals, 1),
                    new ItemStack(items.itemSniperBarrel, 1),
                    new ItemStack(items.itemSniperStock, 1) };
            }
        });
        AssemblyManager.register(new Schematic("pistol", new ItemStack(items.itemPistol, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPistolStock, 1),
                    new ItemStack(items.itemPistolBarrel, 1),
                    new ItemStack(items.itemPistolAction, 1) };
            }
        });
        AssemblyManager.register(new Schematic("m4", new ItemStack(items.itemM4, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemM4Stock, 1),
                    new ItemStack(items.itemM4Barrel, 1),
                    new ItemStack(items.itemM4Action, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ak47", new ItemStack(items.itemAK47, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemAK47Action, 1),
                    new ItemStack(items.itemAK47Barrel, 1),
                    new ItemStack(items.itemAK47Stock, 1) };
            }
        });
        AssemblyManager.register(new Schematic("doritos", new ItemStack(items.itemDoritos, 4))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Items.WHEAT, 4),
                    new ItemStack(Items.BAKED_POTATO, 4) };
            }
        });
        AssemblyManager.register(new Schematic("doritosCoolRanch", new ItemStack(items.itemDoritosCoolRanch, 4))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemDoritos, 4),
                    new ItemStack(Items.WHEAT, 3) };
            }
        });
        AssemblyManager.register(new Schematic("motionTracker", new ItemStack(items.itemMotionTracker, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 6),
                    new ItemStack(items.itemIngotAluminum, 8),
                    new ItemStack(items.itemIngotCopper, 6),
                    new ItemStack(items.itemLedDisplay, 2),
                    new ItemStack(items.itemProcessor, 2),
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(Items.IRON_INGOT, 8) };
            }
        });
        AssemblyManager.register(new Schematic("flamethrower", new ItemStack(items.itemM240ICU, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 4),
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(items.itemIngotCopper, 3),
                    new ItemStack(Items.BLAZE_ROD, 1),
                    new ItemStack(Items.IRON_INGOT, 6) };
            }
        });
        AssemblyManager.register(new Schematic("nbtDrive", new ItemStack(items.itemFlashDrive, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 1),
                    new ItemStack(items.itemRAM, 4),
                    new ItemStack(items.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticBiomask", new ItemStack(items.helmTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 2),
                    new ItemStack(Items.DIAMOND_HELMET, 1),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemLedDisplay, 2),
                    new ItemStack(items.itemPolycarbonate, 2),
                    new ItemStack(items.itemProcessor, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticPlate", new ItemStack(items.plateTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_CHESTPLATE, 1),
                    new ItemStack(items.itemIngotAluminum, 3),
                    new ItemStack(items.itemPolycarbonate, 3) };
            }
        });
        AssemblyManager.register(new Schematic("celticLegs", new ItemStack(items.legsTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_LEGGINGS, 1),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticBoots", new ItemStack(items.bootsTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_BOOTS, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticAxe", new ItemStack(items.axeTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_AXE, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticPickaxe", new ItemStack(items.pickaxeTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_PICKAXE, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticHoe", new ItemStack(items.hoeTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_HOE, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticShovel", new ItemStack(items.shovelTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_SHOVEL, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticSword", new ItemStack(items.swordTitanium, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Items.DIAMOND_SWORD, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("wristBlade", new ItemStack(items.itemWristbracer, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 2),
                    new ItemStack(Items.DIAMOND, 4),
                    new ItemStack(items.itemLedDisplay, 2),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("wristbracerBlades", new ItemStack(items.itemWristbracerBlades, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 2),
                    new ItemStack(Items.SHEARS, 1),
                    new ItemStack(Items.DIAMOND, 2),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("proximityMine", new ItemStack(items.itemProximityMine, 3))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(Blocks.TNT, 2),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticDisc", new ItemStack(items.itemDisc, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(items.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticShuriken", new ItemStack(items.itemShuriken, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticSpear", new ItemStack(items.itemSpear, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemArtifactTech, 1),
                    new ItemStack(items.itemIngotAluminum, 1),
                    new ItemStack(items.itemPolycarbonate, 2),
                    new ItemStack(Items.DIAMOND, 1) };
            }
        });
        AssemblyManager.register(new Schematic("polycarbonate", new ItemStack(items.itemPolycarbonate, 4))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemCarbon, 6),
                    new ItemStack(items.itemSilicon, 3) };
            }
        });
        AssemblyManager.register(new Schematic("carbon", new ItemStack(items.itemCarbon, 3))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(Items.COAL, 4) };
            }
        });
        AssemblyManager.register(new Schematic("resistor", new ItemStack(items.itemResistor, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotCopper, 2),
                    new ItemStack(items.itemCarbon, 1) };
            }
        });
        AssemblyManager.register(new Schematic("capacitor", new ItemStack(items.itemCapacitor, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotCopper, 2),
                    new ItemStack(items.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("diode", new ItemStack(items.itemDiode, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotCopper, 1),
                    new ItemStack(items.itemCarbon, 1),
                    new ItemStack(items.itemSilicon, 1) };
            }
        });
        AssemblyManager.register(new Schematic("led", new ItemStack(items.itemLed, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 1),
                    new ItemStack(items.itemDiode, 1),
                    new ItemStack(Items.REDSTONE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("regulator", new ItemStack(items.itemVoltageRegulator, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemDiode, 1),
                    new ItemStack(items.itemIngotCopper, 1),
                    new ItemStack(items.itemResistor, 1) };
            }
        });
        AssemblyManager.register(new Schematic("transistor", new ItemStack(items.itemTransistor, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemSilicon, 1),
                    new ItemStack(Item.getItemFromBlock(Blocks.LEVER), 1) };
            }
        });
        AssemblyManager.register(new Schematic("ic", new ItemStack(items.itemIntegratedCircuit, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 1),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(items.itemIngotCopper, 2),
                    new ItemStack(items.itemSilicon, 1),
                    new ItemStack(items.itemTransistor, 1),
                    new ItemStack(items.itemResistor, 1),
                    new ItemStack(items.itemVoltageRegulator, 1),
                    new ItemStack(items.itemDiode, 1) };
            }
        });
        AssemblyManager.register(new Schematic("processor", new ItemStack(items.itemProcessor, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 1),
                    new ItemStack(items.itemIntegratedCircuit, 5),
                    new ItemStack(items.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("motherboard", new ItemStack(items.itemMotherboard, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 1),
                    new ItemStack(items.itemIntegratedCircuit, 1),
                    new ItemStack(items.itemSilicon, 1),
                    new ItemStack(items.itemTransistor, 1),
                    new ItemStack(items.itemVoltageRegulator, 1),
                    new ItemStack(items.itemDiode, 1) };
            }
        });
        AssemblyManager.register(new Schematic("powerline", new ItemStack(blocks.powerline, 4))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 4),
                    new ItemStack(items.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("powersupply", new ItemStack(items.itemPowerSupply, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemDiode, 1),
                    new ItemStack(items.itemVoltageRegulator, 1),
                    new ItemStack(items.itemIngotAluminum, 2),
                    new ItemStack(blocks.transformer, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ledDisplay", new ItemStack(items.itemLedDisplay, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 1),
                    new ItemStack(items.itemLed, 6),
                    new ItemStack(items.itemIntegratedCircuit, 1),
                    new ItemStack(items.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ram", new ItemStack(items.itemRAM, 2))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemIntegratedCircuit, 3),
                    new ItemStack(items.itemVoltageRegulator, 1),
                    new ItemStack(items.itemIngotCopper, 2),
                    new ItemStack(items.itemSilicon, 2),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("solidstatedrive", new ItemStack(items.itemSolidStateDrive, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemRAM, 2),
                    new ItemStack(items.itemVoltageRegulator, 1),
                    new ItemStack(items.itemIntegratedCircuit, 1),
                    new ItemStack(items.itemIngotLithium, 1),
                    new ItemStack(items.itemPolycarbonate, 1) };
            }
        });
    }
}
