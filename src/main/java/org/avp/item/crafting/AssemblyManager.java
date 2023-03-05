package org.avp.item.crafting;

import java.util.ArrayList;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class AssemblyManager
{
    public static final AssemblyManager instance   = new AssemblyManager();
    private ArrayList<Schematic>        schematics = new ArrayList<Schematic>();

    public ArrayList<Schematic> schematics()
    {
        return this.schematics;
    }

    public static void register(Schematic schematic)
    {
        AssemblyManager.instance.add(schematic);
    }

    public ArrayList<Schematic> getSchematics(Item item)
    {
        ArrayList<Schematic> schematics = new ArrayList<Schematic>();

        for (Schematic schematic : this.schematics())
        {
            if (schematic.getItemStackAssembled() != null && schematic.getItemStackAssembled().getItem() == item)
            {
                schematics.add(schematic);
            }
        }

        return schematics;
    }

    public Schematic getSchematic(String id)
    {
        for (Schematic schematic : this.schematics())
        {
            if (schematic.getName().equalsIgnoreCase(id))
            {
                return schematic;
            }
        }

        return null;
    }

    public boolean isValid(Schematic schematic)
    {
        for (Schematic sch : this.schematics)
        {
            if (schematic == null || sch != null && schematic != null && sch.getName().equalsIgnoreCase(schematic.getName()))
            {
                return false;
            }
        }

        return true;
    }

    public void add(Schematic schematic)
    {
        if (isValid(schematic))
        {
            this.schematics.add(schematic);
        }
        else
        {
            MDX.log().warn(String.format("[AVP/API/Assembler] Schematic for id '%s' is already registered.", schematic.getName()));
        }
    }

    public static int amountForMatchingStack(EntityPlayer player, ItemStack requirement)
    {
        int count = 0;

        int[] matches = OreDictionary.getOreIDs(requirement);
        boolean checkOreDictionary = matches.length > 0;

        if (checkOreDictionary)
        {
            for (int id : matches)
            {
                String sharedName = OreDictionary.getOreName(id);

                for (ItemStack potentialMatch : OreDictionary.getOres(sharedName))
                {
                    count += Inventories.getAmountOfItemPlayerHas(potentialMatch.getItem(), player);
                }
            }
        }
        else
        {
            count += Inventories.getAmountOfItemPlayerHas(requirement.getItem(), player);
        }

        return count;
    }

    /**
     * Try to assemble the specified schematic, for the specified player, the specified amount of times.
     * 
     * @param player - The player whose resources will be used to assemble the schematic.
     * @param schematic - The schematic to be assembled.
     * @param count - The amount of items to assemble this schematic.
     * @return - The amount of items assembled. Returns 0 of the process was not successful.
     */
    public static int tryAssembly(EntityPlayer player, Schematic schematic, int count)
    {
        return tryAssembly(player, schematic, count, false);
    }

    /**
     * Try to assemble the specified schematic, for the specified player, the specified amount of times. Simulate if specified.
     * 
     * @param player - The player whose resources will be used to assemble the schematic.
     * @param schematic - The schematic to be assembled.
     * @param count - The amount of items to assemble this schematic.
     * @param simulate - Set to true if the assembly should only be simulated.
     * @return - The amount of items assembled. Returns 0 of the process was not successful.
     */
    public static int tryAssembly(EntityPlayer player, Schematic schematic, int count, boolean simulate)
    {
        int amount = 0;

        for (int i = 0; i < count; i++)
        {
            if (AssemblyManager.handleAssembly(schematic, player, simulate))
            {
                amount++;
            }
            else
            {
                break;
            }
        }

        return amount;
    }

    /**
     * Try to assemble the specified schematic, for the specified player, the specified amount of times. Simulate if specified.
     * 
     * @param player - The player whose resources will be used to assemble the schematic.
     * @param schematic - The schematic to be assembled.
     * @param simulate - Set to true if the assembly should only be simulated.
     * @return - The maximum amount of items that can possibly be assembled.
     */
    public static int tryAssemblyMax(EntityPlayer player, Schematic schematic, boolean simulate)
    {
        int amount = 0;

        for (int i = 0; i < 64; i++)
        {
            if (AssemblyManager.handleAssembly(schematic, player, simulate))
            {
                amount++;
            }
            else
            {
                break;
            }
        }

        return amount;
    }

    public static boolean handleAssembly(Schematic schematic, EntityPlayer player)
    {
        return handleAssembly(schematic, player, false);
    }

    public static ItemStack findInventoryItemstackMatchOreDict(EntityPlayer player, ItemStack stack)
    {
        int[] matches = OreDictionary.getOreIDs(stack);
        boolean checkOreDictionary = matches.length > 0;

        if (checkOreDictionary)
        {
            for (int id : matches)
            {
                String sharedName = OreDictionary.getOreName(id);

                for (ItemStack potentialMatch : OreDictionary.getOres(sharedName))
                {
                    if (Inventories.getAmountOfItemPlayerHas(potentialMatch.getItem(), player) >= stack.getCount())
                    {
                        return potentialMatch;
                    }
                }
            }
        }

        return stack;
    }

    public static boolean handleAssembly(Schematic schematic, EntityPlayer player, boolean simulate)
    {
        if (schematic != null && Schematic.isComplete(schematic, player) || schematic != null && player.isCreative())
        {
            if (!player.isCreative())
            {
                for (ItemStack requirement : schematic.getItemsRequired())
                {
                    if (requirement != null && requirement != ItemStack.EMPTY)
                    {
                        Item requiredItem = findInventoryItemstackMatchOreDict(player, requirement).getItem();

                        if (Inventories.getAmountOfItemPlayerHas(requiredItem, player) >= requirement.getCount())
                        {
                            for (int x = 0; x < requirement.getCount(); x++)
                            {
                                if (!simulate)
                                {
                                    if (!Inventories.consumeItem(player, requiredItem))
                                    {
                                        return false;
                                    }
                                }
                            }
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }

            if (!simulate)
            {
                if (!player.inventory.addItemStackToInventory(schematic.getItemStackAssembled().copy()))
                {
                    new EntityItem(player.world, player.posX, player.posY, player.posZ, schematic.getItemStackAssembled().copy());
                }
            }

            return true;
        }

        return false;
    }
}
