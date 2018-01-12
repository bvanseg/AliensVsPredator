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
        this.addRecipes(items, blocks);
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

    private void addRecipes(ItemHandler items, BlockHandler blocks)
    {
        GameRegistry.addRecipe(new ItemStack(items.itemCarbon, 2), "aa", "aa", 'a', Items.COAL);
        GameRegistry.addRecipe(new ItemStack(items.itemCarbon, 2), "aa", "aa", 'a', new ItemStack(Items.COAL, 1, 1));
        GameRegistry.addRecipe(new ItemStack(items.itemPolycarbonate, 2), "aaa", "bbb", "bbb", 'a', items.itemSilicon, 'b', items.itemCarbon);
        GameRegistry.addRecipe(new ItemStack(items.itemResistor, 1), " a ", " b ", " a ", 'a', items.itemIngotCopper, 'b', items.itemCarbon);
        GameRegistry.addRecipe(new ItemStack(items.itemDiode, 1), " a ", " b ", " c ", 'a', items.itemIngotCopper, 'b', items.itemCarbon, 'c', items.itemSilicon);
        GameRegistry.addRecipe(new ItemStack(items.itemLed, 1), " b ", " c ", " a ", 'a', items.itemDiode, 'b', items.itemPolycarbonate, 'c', Items.REDSTONE);
        GameRegistry.addRecipe(new ItemStack(items.itemCapacitor, 1), " a ", " b ", " a ", 'a', items.itemIngotCopper, 'b', items.itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(items.itemVoltageRegulator, 1), " a ", " b ", " c ", 'a', items.itemDiode, 'b', items.itemIngotCopper, 'c', items.itemResistor);
        GameRegistry.addRecipe(new ItemStack(items.itemTransistor, 1), "  a", "bc ", "  a", 'a', items.itemIngotAluminum, 'b', items.itemSilicon, 'c', Blocks.LEVER);
        GameRegistry.addRecipe(new ItemStack(items.itemIntegratedCircuit, 1), "dbe", "cac", "fbg", 'a', items.itemPolycarbonate, 'b', items.itemIngotAluminum, 'c', items.itemIngotCopper, 'd', items.itemTransistor, 'e', items.itemResistor, 'f', items.itemVoltageRegulator, 'g', items.itemDiode);
        GameRegistry.addRecipe(new ItemStack(items.itemProcessor, 1), "aaa", "aba", "aca", 'a', items.itemIntegratedCircuit, 'b', items.itemPolycarbonate, 'c', items.itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(items.itemRAM, 1), "aaa", "cec", "dbd", 'a', items.itemIntegratedCircuit, 'b', items.itemPolycarbonate, 'c', items.itemSilicon, 'd', items.itemIngotCopper, 'e', items.itemVoltageRegulator);
        GameRegistry.addRecipe(new ItemStack(items.itemMotherboard, 1), "aef", "gbc", "dbh", 'a', items.itemIntegratedCircuit, 'b', items.itemPolycarbonate, 'c', items.itemTransistor, 'd', items.itemCapacitor, 'e', items.itemVoltageRegulator, 'f', items.itemDiode, 'g', items.itemResistor, 'h', items.itemLed);
        GameRegistry.addRecipe(new ItemStack(blocks.powerline, 2), " a ", "aba", " a ", 'a', items.itemPolycarbonate, 'b', items.itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(blocks.transformer, 1), "aaa", "bca", "aaa", 'a', items.itemIngotCopper, 'b', items.itemVoltageRegulator, 'c', Blocks.IRON_BLOCK);
        GameRegistry.addRecipe(new ItemStack(blocks.stepdownTransformer, 1), "aaa", "acb", "aaa", 'a', items.itemIngotCopper, 'b', items.itemVoltageRegulator, 'c', Blocks.IRON_BLOCK);
        GameRegistry.addRecipe(new ItemStack(items.itemPowerSupply, 1), "abc", "dec", "abc", 'a', items.itemDiode, 'b', items.itemVoltageRegulator, 'c', items.itemIngotAluminum, 'd', items.itemCapacitor, 'e', blocks.transformer);
        GameRegistry.addRecipe(new ItemStack(items.itemSolidStateDrive, 1), "aaa", "dcb", "fgh", 'a', items.itemRAM, 'b', items.itemVoltageRegulator, 'c', items.itemIntegratedCircuit, 'd', items.itemIngotLithium, 'e', items.itemVoltageRegulator, 'f', items.itemTransistor, 'g', items.itemPolycarbonate, 'h', items.itemCapacitor);
        GameRegistry.addRecipe(new ItemStack(blocks.assembler, 1), "aba", "dfh", "ceg", 'a', items.itemRAM, 'b', items.itemProcessor, 'c', items.itemPowerSupply, 'd', items.itemPolycarbonate, 'e', items.itemSolidStateDrive, 'f', items.itemLedDisplay, 'g', items.itemMotherboard, 'h', items.itemTransistor);
        GameRegistry.addRecipe(new ItemStack(items.itemLedDisplay, 1), "bdb", "bcb", "bab", 'a', items.itemIntegratedCircuit, 'b', items.itemLed, 'c', items.itemPolycarbonate, 'd', items.itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(blocks.solarPanel, 1), "aaa", "bbb", "dcd", 'a', items.itemPolycarbonate, 'b', items.itemSilicon, 'c', items.itemIngotCopper, 'd', items.itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(items.plateMarine, 1), "b b", "aba", "bab", 'a', items.itemIngotAluminum, 'b', Blocks.WOOL);
        GameRegistry.addRecipe(new ItemStack(items.legsMarine, 1), "bab", "b b", "a a", 'a', items.itemIngotAluminum, 'b', Blocks.WOOL);
        GameRegistry.addRecipe(new ItemStack(items.bootsMarine, 1), "b b", "a a", 'a', items.itemIngotAluminum, 'b', Blocks.WOOL);
        GameRegistry.addRecipe(new ItemStack(items.pressureMask, 1), "aaa", "b b", "dcd", 'a', items.itemIngotAluminum, 'b', blocks.industrialglass, 'c', items.itemCarbon, 'd', items.itemSilicon);
        GameRegistry.addRecipe(new ItemStack(items.pressureChest, 1), "b b", "aba", "bab", 'a', items.itemIngotAluminum, 'b', blocks.industrialglass);
        GameRegistry.addRecipe(new ItemStack(items.pressurePants, 1), "bab", "b b", "a a", 'a', items.itemIngotAluminum, 'b', blocks.industrialglass);
        GameRegistry.addRecipe(new ItemStack(items.pressureBoots, 1), "b b", "a a", 'a', items.itemIngotAluminum, 'b', blocks.industrialglass);
        GameRegistry.addRecipe(new ItemStack(items.mk50helmet, 1), "aaa", "b b", "dcd", 'a', items.itemIngotCopper, 'b', blocks.industrialglass, 'c', items.itemCarbon, 'd', items.itemSilicon);
        GameRegistry.addRecipe(new ItemStack(items.mk50body, 1), "b b", "aba", "bab", 'a', items.itemIngotCopper, 'b', blocks.industrialglass);
        GameRegistry.addRecipe(new ItemStack(items.mk50pants, 1), "bab", "b b", "a a", 'a', items.itemIngotCopper, 'b', blocks.industrialglass);
        GameRegistry.addRecipe(new ItemStack(items.mk50boots, 1), "b b", "a a", 'a', items.itemIngotCopper, 'b', blocks.industrialglass);
        GameRegistry.addRecipe(new ItemStack(items.itemPistol, 1), "bc", "a ", 'a', items.itemPistolStock, 'b', items.itemPistolAction, 'c', items.itemPistolBarrel);
        GameRegistry.addRecipe(new ItemStack(items.itemPistolStock, 1), "ccc", "ab ", 'a', items.itemIngotAluminum, 'b', items.itemSilicon, 'c', Blocks.PLANKS);
        GameRegistry.addRecipe(new ItemStack(items.itemPistolAction, 1), "ca", "ab", 'a', items.itemIngotAluminum, 'b', Blocks.LEVER, 'c', items.itemSilicon);
        GameRegistry.addRecipe(new ItemStack(items.itemPistolBarrel, 1), "aaa", "b  ", 'a', Items.IRON_INGOT, 'b', items.itemSilicon);
        GameRegistry.addRecipe(new ItemStack(items.itemAmmoPistol, 2), " a ", "bcb", "bcb", 'a', items.itemIngotCopper, 'b', items.itemIngotAluminum, 'c', Items.GUNPOWDER);
        GameRegistry.addRecipe(new ItemStack(items.itemM4, 1), "bc", "a ", 'a', items.itemM4Stock, 'b', items.itemM4Action, 'c', items.itemM4Barrel);
        GameRegistry.addRecipe(new ItemStack(items.itemM4Stock, 1), "ccc", "ab ", 'c', items.itemIngotAluminum, 'a', items.itemSilicon, 'b', items.itemCarbon);
        GameRegistry.addRecipe(new ItemStack(items.itemM4Action, 1), "caa", "ab ", 'a', items.itemIngotAluminum, 'b', Blocks.LEVER, 'c', items.itemSilicon);
        GameRegistry.addRecipe(new ItemStack(items.itemM4Barrel, 1), "aaa", "bc ", 'a', Items.IRON_INGOT, 'b', items.itemSilicon, 'c', items.itemCarbon);
        GameRegistry.addRecipe(new ItemStack(items.itemAK47, 1), "bc", "a ", 'a', items.itemAK47Stock, 'b', items.itemAK47Action, 'c', items.itemAK47Barrel);
        GameRegistry.addRecipe(new ItemStack(items.itemAK47Stock, 1), "ccc", "ab ", 'c', items.itemIngotAluminum, 'b', items.itemSilicon, 'a', items.itemCarbon);
        GameRegistry.addRecipe(new ItemStack(items.itemAK47Action, 1), "caa", "db ", 'a', items.itemIngotAluminum, 'b', Blocks.LEVER, 'c', items.itemSilicon, 'd', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(items.itemAK47Barrel, 1), "aaa", "cb ", 'a', Items.IRON_INGOT, 'b', items.itemSilicon, 'c', items.itemCarbon);
        GameRegistry.addRecipe(new ItemStack(items.itemAmmoAR, 1), " a ", "bcb", "bdb", 'a', Items.IRON_INGOT, 'b', items.itemIngotAluminum, 'c', Items.GUNPOWDER, 'd', items.itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(items.itemGrenade, 1), " d ", "aca", " b ", 'a', Items.IRON_INGOT, 'b', items.itemIngotAluminum, 'c', Items.GUNPOWDER, 'd', items.itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(items.itemIncendiaryGrenade, 1), " d ", "aca", " b ", 'a', Items.IRON_INGOT, 'b', items.itemIngotAluminum, 'c', Items.BLAZE_POWDER, 'd', items.itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(items.itemSevastopolFlamethrower, 1), "e f", "ada", "bbc", 'a', items.itemPolycarbonate, 'b', items.itemIngotAluminum, 'c', Blocks.LEVER, 'd', items.itemSilicon, 'e', Items.IRON_INGOT, 'f', Items.FLINT_AND_STEEL);
        GameRegistry.addRecipe(new ItemStack(items.itemPropaneTank, 1), "dad", "bcb", "bbb", 'a', Items.SLIME_BALL, 'b', items.itemIngotAluminum, 'c', Items.BLAZE_POWDER, 'd', items.itemPolycarbonate);
        GameRegistry.addRecipe(new ItemStack(blocks.industrialwall, 16), "bbb", "aaa", "bbb", 'a', items.itemPolycarbonate, 'b', Blocks.COBBLESTONE);
        GameRegistry.addRecipe(new ItemStack(blocks.industrialwallstriped, 16), "bbb", "aaa", "bbb", 'a', items.itemPolycarbonate, 'b', Blocks.STONE);
        GameRegistry.addRecipe(new ItemStack(blocks.wallStairs, 12), "b  ", "aa ", "bbb", 'a', items.itemPolycarbonate, 'b', Blocks.COBBLESTONE);
        GameRegistry.addRecipe(new ItemStack(blocks.industrialglass, 16), "bbb", "aaa", "bbb", 'a', items.itemPolycarbonate, 'b', Blocks.GLASS);
        GameRegistry.addRecipe(new ItemStack(blocks.industrialGlassStairs, 12), "b  ", "aa ", "bbb", 'a', items.itemPolycarbonate, 'b', Blocks.GLASS);
        GameRegistry.addRecipe(new ItemStack(blocks.industrialbricks, 16), "bbb", "aaa", "bbb", 'a', Items.IRON_INGOT, 'b', Items.BRICK);
        GameRegistry.addRecipe(new ItemStack(blocks.ironBricksStairs, 12), "b  ", "aa ", "bbb", 'a', Items.IRON_INGOT, 'b', Items.BRICK);
        GameRegistry.addRecipe(new ItemStack(blocks.blastDoor, 1), "aba", "cdc", "aba", 'a', items.itemPolycarbonate, 'b', Blocks.OBSIDIAN, 'c', Items.IRON_DOOR, 'd', Blocks.STICKY_PISTON);
        GameRegistry.addRecipe(new ItemStack(items.itemMaintenanceJack, 1), "a  ", " a ", "aab", 'a', items.itemIngotAluminum, 'b', items.itemPolycarbonate);
        GameRegistry.addRecipe(new ItemStack(blocks.locker, 1), "aaa", "aba", "aaa", 'a', items.itemIngotAluminum, 'b', Items.OAK_DOOR);
        GameRegistry.addRecipe(new ItemStack(blocks.gunLocker, 1), "aaa", "aba", "aaa", 'a', items.itemIngotAluminum, 'b', Items.IRON_DOOR);
        GameRegistry.addRecipe(new ItemStack(items.itemDoritos, 3), "aaa", "a b", "bbb", 'a', Items.WHEAT, 'b', Items.BAKED_POTATO);
        GameRegistry.addRecipe(new ItemStack(items.itemDoritosCoolRanch, 1), "ab", "b ", 'a', items.itemDoritos, 'b', Items.WHEAT);
        GameRegistry.addRecipe(new ItemStack(blocks.muthurPanel1, 1), "aba", "bcb", "aba", 'a', Items.GLOWSTONE_DUST, 'b', Items.REDSTONE, 'c', items.itemSilicon);
        GameRegistry.addRecipe(new ItemStack(blocks.muthurPanel2, 1), "bab", "aca", "bab", 'a', Items.GLOWSTONE_DUST, 'b', Items.REDSTONE, 'c', items.itemSilicon);
        GameRegistry.addShapelessRecipe(new ItemStack(items.neodymiumMagnet), new Object[] { items.neodymium, items.cobalt, items.cobalt });
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
