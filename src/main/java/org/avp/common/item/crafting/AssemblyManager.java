package org.avp.common.item.crafting;

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
                AVP.instance.getLogger().warn("[AVP/API/Assembler] Schematic with name '{}' is already registered.", schematic.getName());
            }

            return schematic;
        });
    }

    public ItemSchematic getSchematicByName(String name)
    {
        return schematicsByName.get(name.toLowerCase(Locale.US));
    }
}
