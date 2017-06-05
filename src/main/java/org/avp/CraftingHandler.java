package org.avp;

import org.avp.item.crafting.AssemblyManager;
import org.avp.item.crafting.Schematic;

import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHandler implements IInitEvent
{
    public static final CraftingHandler instance   = new CraftingHandler();
    private ItemStack                   charcoal   = new ItemStack(Items.COAL, 1);

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
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressureMask, 1), "aaa", "b b", "dcd", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().blockIndustrialGlass, 'c', AliensVsPredator.items().itemCarbon, 'd', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressureChest, 1), "b b", "aba", "bab", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().blockIndustrialGlass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressurePants, 1), "bab", "b b", "a a", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().blockIndustrialGlass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().pressureBoots, 1), "b b", "a a", 'a', AliensVsPredator.items().itemIngotAluminum, 'b', AliensVsPredator.blocks().blockIndustrialGlass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50helmet, 1), "aaa", "b b", "dcd", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().blockIndustrialGlass, 'c', AliensVsPredator.items().itemCarbon, 'd', AliensVsPredator.items().itemSilicon);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50body, 1), "b b", "aba", "bab", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().blockIndustrialGlass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50pants, 1), "bab", "b b", "a a", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().blockIndustrialGlass);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.items().mk50boots, 1), "b b", "a a", 'a', AliensVsPredator.items().itemIngotCopper, 'b', AliensVsPredator.blocks().blockIndustrialGlass);
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
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockWall, 16), "bbb", "aaa", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.COBBLESTONE);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockWallW, 16), "bbb", "aaa", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.STONE);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockWallStairs, 12), "b  ", "aa ", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.COBBLESTONE);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockIndustrialGlass, 16), "bbb", "aaa", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.GLASS);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockIndustrialGlassStairs, 12), "b  ", "aa ", "bbb", 'a', AliensVsPredator.items().itemPolycarbonate, 'b', Blocks.GLASS);
        GameRegistry.addRecipe(new ItemStack(AliensVsPredator.blocks().blockIronBricks, 16), "bbb", "aaa", "bbb", 'a', Items.IRON_INGOT, 'b', Items.BRICK);
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

        AssemblyManager.instance.add(new Schematic("turret", Inventories.newStack(blocks.blockTurret, 1), Inventories.newStack(items.itemM41A, 1), Inventories.newStack(items.itemPolycarbonate, 4), Inventories.newStack(items.itemIngotAluminum, 4), Inventories.newStack(items.itemIngotCopper, 4), Inventories.newStack(items.itemLedDisplay, 1)));
        AssemblyManager.instance.add(new Schematic("redstonefluxGenerator", Inventories.newStack(blocks.redstoneFluxGenerator, 1), Inventories.newStack(blocks.blockTransformer, 4), Inventories.newStack(blocks.blockNegativeTransformer, 4), Inventories.newStack(items.itemPolycarbonate, 4), Inventories.newStack(items.itemIngotAluminum, 4), Inventories.newStack(Items.DIAMOND, 4)));
        AssemblyManager.instance.add(new Schematic("cryostasisTube", Inventories.newStack(blocks.blockCryostasisTube, 1), Inventories.newStack(items.itemPolycarbonate, 4), Inventories.newStack(items.itemIngotAluminum, 4), Inventories.newStack(blocks.blockIndustrialGlass, 4), Inventories.newStack(blocks.blockLightPanel, 1)));
        AssemblyManager.instance.add(new Schematic("lightPanel", Inventories.newStack(blocks.blockLightPanel, 1), Inventories.newStack(items.itemPolycarbonate, 2), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(blocks.blockIndustrialGlass, 2), Inventories.newStack(Items.GLOWSTONE_DUST, 2)));
        AssemblyManager.instance.add(new Schematic("pulserifle", Inventories.newStack(items.itemM41A, 1), Inventories.newStack(items.itemPolycarbonate, 8), Inventories.newStack(Items.IRON_INGOT, 8), Inventories.newStack(items.itemIngotAluminum, 6), Inventories.newStack(items.itemIngotCopper, 6), Inventories.newStack(Items.GOLD_INGOT, 4), Inventories.newStack(items.itemIntegratedCircuit, 2), Inventories.newStack(items.itemLedDisplay, 1)));
        AssemblyManager.instance.add(new Schematic("grenade", Inventories.newStack(items.itemGrenade, 2), Inventories.newStack(Items.IRON_INGOT, 2), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(Items.GUNPOWDER, 1), Inventories.newStack(items.itemIngotCopper, 1)));
        AssemblyManager.instance.add(new Schematic("fire_grenade", Inventories.newStack(items.itemIncendiaryGrenade, 2), Inventories.newStack(Items.IRON_INGOT, 2), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(Items.BLAZE_POWDER, 1), Inventories.newStack(items.itemIngotCopper, 1)));
        AssemblyManager.instance.add(new Schematic("marineHelm", Inventories.newStack(items.helmMarine, 1), Inventories.newStack(Blocks.WOOL, 3), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemLedDisplay, 2), Inventories.newStack(items.itemPolycarbonate, 2), Inventories.newStack(items.itemProcessor, 1)));
        AssemblyManager.instance.add(new Schematic("marinePlate", Inventories.newStack(items.plateMarine, 1), Inventories.newStack(Blocks.WOOL, 3), Inventories.newStack(items.itemIngotAluminum, 2)));
        AssemblyManager.instance.add(new Schematic("marineLeggings", Inventories.newStack(items.legsMarine, 1), Inventories.newStack(Blocks.WOOL, 3), Inventories.newStack(items.itemIngotAluminum, 2)));
        AssemblyManager.instance.add(new Schematic("marineBoots", Inventories.newStack(items.bootsMarine, 1), Inventories.newStack(Blocks.WOOL, 1), Inventories.newStack(items.itemIngotAluminum, 1)));
        AssemblyManager.instance.add(new Schematic("sniperMagazine", Inventories.newStack(items.itemAmmoSniper, 1), Inventories.newStack(items.itemIngotAluminum, 5), Inventories.newStack(Items.GUNPOWDER, 1)));
        AssemblyManager.instance.add(new Schematic("pistolMagazine", Inventories.newStack(items.itemAmmoPistol, 3), Inventories.newStack(items.itemIngotAluminum, 4), Inventories.newStack(Items.GUNPOWDER, 2), Inventories.newStack(items.itemIngotCopper, 1)));
        AssemblyManager.instance.add(new Schematic("ARAmmo", Inventories.newStack(items.itemAmmoAR, 1), Inventories.newStack(items.itemIngotAluminum, 5), Inventories.newStack(Items.IRON_INGOT, 1), Inventories.newStack(Items.GUNPOWDER, 1)));
        AssemblyManager.instance.add(new Schematic("SMGAmmo", Inventories.newStack(items.itemAmmoSMG, 1), Inventories.newStack(items.itemIngotAluminum, 4), Inventories.newStack(Items.IRON_INGOT, 4), Inventories.newStack(Items.GUNPOWDER, 1)));
        AssemblyManager.instance.add(new Schematic("m56sg", Inventories.newStack(items.itemM56SG, 1), Inventories.newStack(items.itemM56SGAimingModule, 1), Inventories.newStack(items.itemM56SGStock, 1), Inventories.newStack(items.itemM56SGBarrel, 1), Inventories.newStack(items.itemM56SGSupportFrame, 1)));
        AssemblyManager.instance.add(new Schematic("sniper", Inventories.newStack(items.itemSniper, 1), Inventories.newStack(items.itemSniperScope, 1), Inventories.newStack(items.itemSniperAction, 1), Inventories.newStack(items.itemSniperPeripherals, 1), Inventories.newStack(items.itemSniperBarrel, 1), Inventories.newStack(items.itemSniperStock, 1)));
        AssemblyManager.instance.add(new Schematic("pistol", Inventories.newStack(items.itemPistol, 1), Inventories.newStack(items.itemPistolStock, 1), Inventories.newStack(items.itemPistolBarrel, 1), Inventories.newStack(items.itemPistolAction, 1)));
        AssemblyManager.instance.add(new Schematic("m4", Inventories.newStack(items.itemM4, 1), Inventories.newStack(items.itemM4Stock, 1), Inventories.newStack(items.itemM4Barrel, 1), Inventories.newStack(items.itemM4Action, 1)));
        AssemblyManager.instance.add(new Schematic("ak47", Inventories.newStack(items.itemAK47, 1), Inventories.newStack(items.itemAK47Action, 1), Inventories.newStack(items.itemAK47Barrel, 1), Inventories.newStack(items.itemAK47Stock, 1)));
        AssemblyManager.instance.add(new Schematic("doritos", Inventories.newStack(items.itemDoritos, 4), Inventories.newStack(Items.WHEAT, 4), Inventories.newStack(Items.BAKED_POTATO, 4)));
        AssemblyManager.instance.add(new Schematic("doritosCoolRanch", Inventories.newStack(items.itemDoritosCoolRanch, 4), Inventories.newStack(items.itemDoritos, 4), Inventories.newStack(Items.WHEAT, 3)));
        AssemblyManager.instance.add(new Schematic("motionTracker", Inventories.newStack(items.itemMotionTracker, 1), Inventories.newStack(items.itemPolycarbonate, 6), Inventories.newStack(items.itemIngotAluminum, 8), Inventories.newStack(items.itemIngotCopper, 6), Inventories.newStack(items.itemLedDisplay, 2), Inventories.newStack(items.itemProcessor, 2), Inventories.newStack(Items.DIAMOND, 1), Inventories.newStack(Items.IRON_INGOT, 8)));
        AssemblyManager.instance.add(new Schematic("flamethrower", Inventories.newStack(items.itemM240ICU, 1), Inventories.newStack(items.itemPolycarbonate, 4), Inventories.newStack(items.itemIngotAluminum, 4), Inventories.newStack(items.itemIngotCopper, 3), Inventories.newStack(Items.BLAZE_ROD, 1), Inventories.newStack(Items.IRON_INGOT, 6)));
        AssemblyManager.instance.add(new Schematic("nbtDrive", Inventories.newStack(items.itemFlashDrive, 1), Inventories.newStack(items.itemPolycarbonate, 1), Inventories.newStack(items.itemRAM, 4), Inventories.newStack(items.itemIngotLithium, 1)));
        AssemblyManager.instance.add(new Schematic("celticBiomask", Inventories.newStack(items.helmTitanium, 1), Inventories.newStack(items.itemArtifactTech, 2), Inventories.newStack(Items.DIAMOND_HELMET, 1), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemLedDisplay, 2), Inventories.newStack(items.itemPolycarbonate, 2), Inventories.newStack(items.itemProcessor, 1)));
        AssemblyManager.instance.add(new Schematic("celticPlate", Inventories.newStack(items.plateTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_CHESTPLATE, 1), Inventories.newStack(items.itemIngotAluminum, 3), Inventories.newStack(items.itemPolycarbonate, 3)));
        AssemblyManager.instance.add(new Schematic("celticLegs", Inventories.newStack(items.legsTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_LEGGINGS, 1), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemPolycarbonate, 2)));
        AssemblyManager.instance.add(new Schematic("celticBoots", Inventories.newStack(items.bootsTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_BOOTS, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("celticAxe", Inventories.newStack(items.axeTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_AXE, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("celticPickaxe", Inventories.newStack(items.pickaxeTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_PICKAXE, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("celticHoe", Inventories.newStack(items.hoeTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_HOE, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("celticShovel", Inventories.newStack(items.shovelTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_SHOVEL, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("celticSword", Inventories.newStack(items.swordTitanium, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Items.DIAMOND_SWORD, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("wristBlade", Inventories.newStack(items.itemWristbracer, 1), Inventories.newStack(items.itemArtifactTech, 2), Inventories.newStack(Items.DIAMOND, 4), Inventories.newStack(items.itemLedDisplay, 2), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemPolycarbonate, 2)));
        AssemblyManager.instance.add(new Schematic("wristbracerBlades", Inventories.newStack(items.itemWristbracerBlades, 1), Inventories.newStack(items.itemArtifactTech, 2), Inventories.newStack(Items.SHEARS, 1), Inventories.newStack(Items.DIAMOND, 2), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemPolycarbonate, 2)));
        AssemblyManager.instance.add(new Schematic("proximityMine", Inventories.newStack(items.itemProximityMine, 3), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(Blocks.TNT, 2), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("celticDisc", Inventories.newStack(items.itemDisc, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(Items.DIAMOND, 1), Inventories.newStack(items.itemPolycarbonate, 2)));
        AssemblyManager.instance.add(new Schematic("celticShuriken", Inventories.newStack(items.itemShuriken, 2), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemPolycarbonate, 2)));
        AssemblyManager.instance.add(new Schematic("celticSpear", Inventories.newStack(items.itemSpear, 1), Inventories.newStack(items.itemArtifactTech, 1), Inventories.newStack(items.itemIngotAluminum, 1), Inventories.newStack(items.itemPolycarbonate, 2), Inventories.newStack(Items.DIAMOND, 1)));
        AssemblyManager.instance.add(new Schematic("polycarbonate", Inventories.newStack(items.itemPolycarbonate, 4), Inventories.newStack(items.itemCarbon, 6), Inventories.newStack(items.itemSilicon, 3)));
        AssemblyManager.instance.add(new Schematic("carbon", Inventories.newStack(items.itemCarbon, 3), Inventories.newStack(Items.COAL, 4)));
        AssemblyManager.instance.add(new Schematic("resistor", Inventories.newStack(items.itemResistor, 2), Inventories.newStack(items.itemIngotCopper, 2), Inventories.newStack(items.itemCarbon, 1)));
        AssemblyManager.instance.add(new Schematic("capacitor", Inventories.newStack(items.itemCapacitor, 2), Inventories.newStack(items.itemIngotCopper, 2), Inventories.newStack(items.itemIngotLithium, 1)));
        AssemblyManager.instance.add(new Schematic("diode", Inventories.newStack(items.itemDiode, 2), Inventories.newStack(items.itemIngotCopper, 1), Inventories.newStack(items.itemCarbon, 1), Inventories.newStack(items.itemSilicon, 1)));
        AssemblyManager.instance.add(new Schematic("led", Inventories.newStack(items.itemLed, 2), Inventories.newStack(items.itemPolycarbonate, 1), Inventories.newStack(items.itemDiode, 1), Inventories.newStack(Items.REDSTONE, 1)));
        AssemblyManager.instance.add(new Schematic("regulator", Inventories.newStack(items.itemVoltageRegulator, 2), Inventories.newStack(items.itemDiode, 1), Inventories.newStack(items.itemIngotCopper, 1), Inventories.newStack(items.itemResistor, 1)));
        AssemblyManager.instance.add(new Schematic("transistor", Inventories.newStack(items.itemTransistor, 2), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemSilicon, 1), Inventories.newStack(Item.getItemFromBlock(Blocks.LEVER), 1)));
        AssemblyManager.instance.add(new Schematic("ic", Inventories.newStack(items.itemIntegratedCircuit, 2), Inventories.newStack(items.itemPolycarbonate, 1), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(items.itemIngotCopper, 2), Inventories.newStack(items.itemSilicon, 1), Inventories.newStack(items.itemTransistor, 1), Inventories.newStack(items.itemResistor, 1), Inventories.newStack(items.itemVoltageRegulator, 1), Inventories.newStack(items.itemDiode, 1)));
        AssemblyManager.instance.add(new Schematic("processor", Inventories.newStack(items.itemProcessor, 1), Inventories.newStack(items.itemPolycarbonate, 1), Inventories.newStack(items.itemIntegratedCircuit, 5), Inventories.newStack(items.itemIngotLithium, 1)));
        AssemblyManager.instance.add(new Schematic("motherboard", Inventories.newStack(items.itemMotherboard, 1), Inventories.newStack(items.itemPolycarbonate, 1), Inventories.newStack(items.itemIntegratedCircuit, 1), Inventories.newStack(items.itemSilicon, 1), Inventories.newStack(items.itemTransistor, 1), Inventories.newStack(items.itemVoltageRegulator, 1), Inventories.newStack(items.itemDiode, 1)));
        AssemblyManager.instance.add(new Schematic("powerline", Inventories.newStack(blocks.blockPowerline, 4), Inventories.newStack(items.itemPolycarbonate, 4), Inventories.newStack(items.itemIngotCopper, 1)));
        AssemblyManager.instance.add(new Schematic("powersupply", Inventories.newStack(items.itemPowerSupply, 1), Inventories.newStack(items.itemDiode, 1), Inventories.newStack(items.itemVoltageRegulator, 1), Inventories.newStack(items.itemIngotAluminum, 2), Inventories.newStack(blocks.blockTransformer, 1)));
        AssemblyManager.instance.add(new Schematic("ledDisplay", Inventories.newStack(items.itemLedDisplay, 2), Inventories.newStack(items.itemPolycarbonate, 1), Inventories.newStack(items.itemLed, 6), Inventories.newStack(items.itemIntegratedCircuit, 1), Inventories.newStack(items.itemIngotLithium, 1)));
        AssemblyManager.instance.add(new Schematic("ram", Inventories.newStack(items.itemRAM, 2), Inventories.newStack(items.itemIntegratedCircuit, 3), Inventories.newStack(items.itemVoltageRegulator, 1), Inventories.newStack(items.itemIngotCopper, 2), Inventories.newStack(items.itemSilicon, 2), Inventories.newStack(items.itemPolycarbonate, 1)));
        AssemblyManager.instance.add(new Schematic("solidstatedrive", Inventories.newStack(items.itemSolidStateDrive, 1), Inventories.newStack(items.itemRAM, 2), Inventories.newStack(items.itemVoltageRegulator, 1), Inventories.newStack(items.itemIntegratedCircuit, 1), Inventories.newStack(items.itemIngotLithium, 1), Inventories.newStack(items.itemPolycarbonate, 1)));
    }
}
