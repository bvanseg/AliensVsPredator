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

public class CraftingHandler implements IInitEvent
{
    public static final CraftingHandler instance = new CraftingHandler();
    private ItemStack                   charcoal = new ItemStack(Items.COAL, 1);

    public CraftingHandler()
    {
        charcoal.setItemDamage(1);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.addRecipes();
        this.addSmelting();
        this.addSchematics();
    }

    public void addRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemCarbon, 2), "aa", "aa", 'a', Items.COAL);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemCarbon, 2), "aa", "aa", 'a', new ItemStack(Items.COAL, 1, 1));
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemPolycarbonate, 2), "aaa", "bbb", "bbb", 'a', AliensVsPredator.items().itemSilicon, 'b', AliensVsPredator.items().itemCarbon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemResistor, 1), " a ", " b ", " a ", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.items().itemCarbon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemDiode, 1), " a ", " b ", " c ", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.items().itemCarbon, 'c', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemLed, 1), " b ", " c ", " a ", 'a', AliensVsPredator.items().itemDiode, 'b', AliensVsPredator.items().itemPolycarbonate, 'c', Items.REDSTONE);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemCapacitor, 1), " a ", " b ", " a ", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.items().itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemVoltageRegulator, 1), " a ", " b ", " c ", 'a', AliensVsPredator.items().itemDiode, 'b', AliensVsPredator.items().itemIngotCopper, 'c', AliensVsPredator.items().itemResistor);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemTransistor, 1), "  a", "bc ", "  a", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.items().itemSilicon, 'c', Blocks.LEVER);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemIntegratedCircuit, 1), "dbe", "cac", "fbg", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', AliensVsPredator.items().itemIngotAluminum, 'c', AliensVsPredator.items().itemIngotCopper, 'd', AliensVsPredator.items().itemTransistor, 'e', AliensVsPredator.items().itemResistor, 'f', AliensVsPredator.items().itemVoltageRegulator, 'g', AliensVsPredator.items().itemDiode);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemProcessor, 1), "aaa", "aba", "aca", 'a', AliensVsPredator.items().itemIntegratedCircuit, 'b', AliensVsPredator.items().itemPolycarbonate, 'c', AliensVsPredator.items().itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemRAM, 1), "aaa", "cec", "dbd", 'a', AliensVsPredator.items().itemIntegratedCircuit, 'b', AliensVsPredator.items().itemPolycarbonate, 'c', AliensVsPredator.items().itemSilicon, 'd', AliensVsPredator.items().itemIngotCopper, 'e', AliensVsPredator.items().itemVoltageRegulator);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemMotherboard, 1), "aef", "gbc", "dbh", 'a', AliensVsPredator.items().itemIntegratedCircuit, 'b', AliensVsPredator.items().itemPolycarbonate, 'c', AliensVsPredator.items().itemTransistor, 'd', AliensVsPredator.items().itemCapacitor, 'e', AliensVsPredator.items().itemVoltageRegulator, 'f', AliensVsPredator.items().itemDiode, 'g', AliensVsPredator.items().itemResistor, 'h', AliensVsPredator.items().itemLed);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockPowerline, 2), " a ", "aba", " a ", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', AliensVsPredator.items().itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockTransformer, 1), "aaa", "bca", "aaa", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.items().itemVoltageRegulator, 'c', Blocks.IRON_BLOCK);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockNegativeTransformer, 1), "aaa", "acb", "aaa", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.items().itemVoltageRegulator, 'c', Blocks.IRON_BLOCK);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemPowerSupply, 1), "abc", "dec", "abc", 'a', AliensVsPredator.items().itemDiode, 'b', AliensVsPredator.items().itemVoltageRegulator, 'c', AliensVsPredator.items().itemIngotAluminum, 'd', AliensVsPredator.items().itemCapacitor, 'e', AliensVsPredator.blocks().blockTransformer);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemSolidStateDrive, 1), "aaa", "dcb", "fgh", 'a', AliensVsPredator.items().itemRAM, 'b', AliensVsPredator.items().itemVoltageRegulator, 'c', AliensVsPredator.items().itemIntegratedCircuit, 'd', AliensVsPredator.items().itemIngotLithium, 'e', AliensVsPredator.items().itemVoltageRegulator, 'f', AliensVsPredator.items().itemTransistor, 'g', AliensVsPredator.items().itemPolycarbonate, 'h', AliensVsPredator.items().itemCapacitor);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockAssembler, 1), "aba", "dfh", "ceg", 'a', AliensVsPredator.items().itemRAM, 'b', AliensVsPredator.items().itemProcessor, 'c', AliensVsPredator.items().itemPowerSupply, 'd', AliensVsPredator.items().itemPolycarbonate, 'e', AliensVsPredator.items().itemSolidStateDrive, 'f', AliensVsPredator.items().itemLedDisplay, 'g', AliensVsPredator.items().itemMotherboard, 'h', AliensVsPredator.items().itemTransistor);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemLedDisplay, 1), "bdb", "bcb", "bab", 'a', AliensVsPredator.items().itemIntegratedCircuit, 'b', AliensVsPredator.items().itemLed, 'c', AliensVsPredator.items().itemPolycarbonate, 'd', AliensVsPredator.items().itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockSolarPanel, 1), "aaa", "bbb", "dcd", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', AliensVsPredator.items().itemSilicon, 'c', AliensVsPredator.items().itemIngotCopper, 'd', AliensVsPredator.items().itemIngotLithium);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().plateMarine, 1), "b b", "aba", "bab", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Blocks.WOOL);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().legsMarine, 1), "bab", "b b", "a a", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Blocks.WOOL);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().bootsMarine, 1), "b b", "a a", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Blocks.WOOL);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressureMask, 1), "aaa", "b b", "dcd", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().industrialglass, 'c', AliensVsPredator.items().itemCarbon, 'd', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressureChest, 1), "b b", "aba", "bab", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().industrialglass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressurePants, 1), "bab", "b b", "a a", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().industrialglass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressureBoots, 1), "b b", "a a", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().industrialglass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50helmet, 1), "aaa", "b b", "dcd", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().industrialglass, 'c', AliensVsPredator.items().itemCarbon, 'd', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50body, 1), "b b", "aba", "bab", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().industrialglass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50pants, 1), "bab", "b b", "a a", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().industrialglass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50boots, 1), "b b", "a a", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().industrialglass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemPistol, 1), "bc", "a ", 'a', AliensVsPredator.items().itemPistolStock, 'b', AliensVsPredator.items().itemPistolAction, 'c', AliensVsPredator.items().itemPistolBarrel);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemPistolStock, 1), "ccc", "ab ", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.items().itemSilicon, 'c', Blocks.PLANKS);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemPistolAction, 1), "ca", "ab", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Blocks.LEVER, 'c', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemPistolBarrel, 1), "aaa", "b  ", 'a', Items.IRON_INGOT, 'b', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemAmmoPistol, 2), " a ", "bcb", "bcb", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.items().itemIngotAluminum, 'c', Items.GUNPOWDER);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemM4, 1), "bc", "a ", 'a', AliensVsPredator.items().itemM4Stock, 'b', AliensVsPredator.items().itemM4Action, 'c', AliensVsPredator.items().itemM4Barrel);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemM4Stock, 1), "ccc", "ab ", 'c', AliensVsPredator.items().itemIngotAluminum, 'a', AliensVsPredator.items().itemSilicon, 'b', AliensVsPredator.items().itemCarbon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemM4Action, 1), "caa", "ab ", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Blocks.LEVER, 'c', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemM4Barrel, 1), "aaa", "bc ", 'a', Items.IRON_INGOT, 'b', AliensVsPredator.items().itemSilicon, 'c', AliensVsPredator.items().itemCarbon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemAK47, 1), "bc", "a ", 'a', AliensVsPredator.items().itemAK47Stock, 'b', AliensVsPredator.items().itemAK47Action, 'c', AliensVsPredator.items().itemAK47Barrel);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemAK47Stock, 1), "ccc", "ab ", 'c', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.items().itemSilicon, 'a', AliensVsPredator.items().itemCarbon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemAK47Action, 1), "caa", "db ", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Blocks.LEVER, 'c', AliensVsPredator.items().itemSilicon, 'd', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemAK47Barrel, 1), "aaa", "cb ", 'a', Items.IRON_INGOT, 'b', AliensVsPredator.items().itemSilicon, 'c', AliensVsPredator.items().itemCarbon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemAmmoAR, 1), " a ", "bcb", "bdb", 'a', Items.IRON_INGOT, 'b', AliensVsPredator.items().itemIngotAluminum, 'c', Items.GUNPOWDER, 'd', AliensVsPredator.items().itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemGrenade, 1), " d ", "aca", " b ", 'a', Items.IRON_INGOT, 'b', AliensVsPredator.items().itemIngotAluminum, 'c', Items.GUNPOWDER, 'd', AliensVsPredator.items().itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemIncendiaryGrenade, 1), " d ", "aca", " b ", 'a', Items.IRON_INGOT, 'b', AliensVsPredator.items().itemIngotAluminum, 'c', Items.BLAZE_POWDER, 'd', AliensVsPredator.items().itemIngotCopper);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemNostromoFlamethrower, 1), "e f", "ada", "bbc", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', AliensVsPredator.items().itemIngotAluminum, 'c', Blocks.LEVER, 'd', AliensVsPredator.items().itemSilicon, 'e', Items.IRON_INGOT, 'f', Items.FLINT_AND_STEEL);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemFuelTank, 1), "dad", "bcb", "bbb", 'a', Items.SLIME_BALL, 'b', AliensVsPredator.items().itemIngotAluminum, 'c', Items.BLAZE_POWDER, 'd', AliensVsPredator.items().itemPolycarbonate);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().industrialwall, 16), "bbb", "aaa", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.COBBLESTONE);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().industrialwallstriped, 16), "bbb", "aaa", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.STONE);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockWallStairs, 12), "b  ", "aa ", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.COBBLESTONE);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().industrialglass, 16), "bbb", "aaa", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.GLASS);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockIndustrialGlassStairs, 12), "b  ", "aa ", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.GLASS);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().industrialbricks, 16), "bbb", "aaa", "bbb", 'a', Items.IRON_INGOT, 'b', Items.BRICK);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockIronBricksStairs, 12), "b  ", "aa ", "bbb", 'a', Items.IRON_INGOT, 'b', Items.BRICK);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockBlastdoor, 1), "aba", "cdc", "aba", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.OBSIDIAN, 'c', Items.IRON_DOOR, 'd', Blocks.STICKY_PISTON);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemMaintenanceJack, 1), "a  ", " a ", "aab", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.items().itemPolycarbonate);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockLocker, 1), "aaa", "aba", "aaa", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Items.OAK_DOOR);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockGunLocker, 1), "aaa", "aba", "aaa", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', Items.IRON_DOOR);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemDoritos, 3), "aaa", "a b", "bbb", 'a', Items.WHEAT, 'b', Items.BAKED_POTATO);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().itemDoritosCoolRanch, 1), "ab", "b ", 'a', AliensVsPredator.items().itemDoritos, 'b', Items.WHEAT);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().mainframePanelShimmer, 1), "aba", "bcb", "aba", 'a', Items.GLOWSTONE_DUST, 'b', Items.REDSTONE, 'c', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().mainframePanelFlicker, 1), "bab", "aca", "bab", 'a', Items.GLOWSTONE_DUST, 'b', Items.REDSTONE, 'c', AliensVsPredator.items().itemSilicon);
    }

    public void addSmelting()
    {
        GameRegistry.addSmelting(AliensVsPredator.blocks().oreCopper, new ItemStack(AliensVsPredator.items().itemIngotCopper), 1.0F);
        GameRegistry.addSmelting(AliensVsPredator.blocks().oreLithium, new ItemStack(AliensVsPredator.items().itemIngotLithium), 1.0F);
        GameRegistry.addSmelting(AliensVsPredator.blocks().oreBauxite, new ItemStack(AliensVsPredator.items().itemIngotAluminum), 1.0F);
        GameRegistry.addSmelting(AliensVsPredator.blocks().oreSilicon, new ItemStack(AliensVsPredator.items().itemSilicon), 1.0F);
        GameRegistry.addSmelting(AliensVsPredator.blocks().terrainUniTreeLog, charcoal, 1.0F);
    }

    public void addSchematics()
    {
        ItemHandler items = AliensVsPredator.items();
        BlockHandler blocks = AliensVsPredator.blocks();

        AssemblyManager.register(new Schematic("turret", new ItemStack(blocks.blockTurret, 1))
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
        AssemblyManager.register(new Schematic("redstonefluxGenerator", new ItemStack(blocks.redstoneFluxGenerator, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(blocks.blockTransformer, 4),
                    new ItemStack(blocks.blockNegativeTransformer, 4),
                    new ItemStack(items.itemPolycarbonate, 4),
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(Items.DIAMOND, 4) };
            }
        });
        AssemblyManager.register(new Schematic("cryostasisTube", new ItemStack(blocks.blockCryostasisTube, 1))
        {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                    new ItemStack(items.itemPolycarbonate, 4),
                    new ItemStack(items.itemIngotAluminum, 4),
                    new ItemStack(blocks.industrialglass, 4),
                    new ItemStack(blocks.blockLightPanel, 1) };
            }
        });
        AssemblyManager.register(new Schematic("lightPanel", new ItemStack(blocks.blockLightPanel, 1))
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
        AssemblyManager.register(new Schematic("powerline", new ItemStack(blocks.blockPowerline, 4))
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
                    new ItemStack(blocks.blockTransformer, 1) };
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
