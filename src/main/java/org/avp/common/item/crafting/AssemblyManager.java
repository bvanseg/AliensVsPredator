package org.avp.common.item.crafting;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.avp.AVP;

import java.util.*;

/**
 * @author Ri5ux
 */
public class AssemblyManager
{
    public static final AssemblyManager instance = new AssemblyManager();
    private final HashMap<String, ItemSchematic> schematicsByName = new HashMap<>();

    public List<ItemSchematic> schematics()
    {
        return new ArrayList<>(this.schematicsByName.values());
    }

    public static void register(ItemSchematic schematic)
    {
        Objects.requireNonNull(schematic);

        AssemblyManager.instance.schematicsByName.compute(schematic.getName().toLowerCase(Locale.US), (key, value) -> {
            if (value != null) {
                AVP.log().warn("[AVP/API/Assembler] Schematic with name '{}' is already registered.", schematic.getName());
            }

            return schematic;
        });
    }

    public ItemSchematic getSchematicByName(String name)
    {
        return schematicsByName.get(name.toLowerCase(Locale.US));
    }

    public static int amountForMatchingStack(EntityPlayer player, ItemStack requirement)
    {
        int count = 0;

        int[] matches = OreDictionary.getOreIDs(requirement);
        boolean checkOreDictionary = matches.length > 0;

        if (!checkOreDictionary) {
            count += Inventories.getAmountOfItemPlayerHas(requirement.getItem(), player);
            return count;
        }

        // TODO: Instead of three for loops here, we should iterate through the player inventory first, and then check each stack to see if it's oredict.
        // TODO: Also using a predicate would be nice.
        for (int id : matches)
        {
            String sharedName = OreDictionary.getOreName(id);

            for (ItemStack potentialMatch : OreDictionary.getOres(sharedName))
            {
                count += Inventories.getAmountOfItemPlayerHas(potentialMatch.getItem(), player);
            }
        }

        return count;
    }

    public static ItemStack findInventoryItemStackMatchOreDict(EntityPlayer player, ItemStack stack)
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
}
