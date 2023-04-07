package org.avp.common.item.crafting;

import org.avp.AVP;

import java.util.*;

/**
 * @author Ri5ux
 */
public class ItemSchematicRegistry {
    private static final HashMap<String, ItemSchematic> schematicsByName = new HashMap<>();

    public static void register(ItemSchematic schematic) {
        Objects.requireNonNull(schematic);

        schematicsByName.compute(schematic.getName().toLowerCase(Locale.US), (key, value) -> {
            if (value != null) {
                AVP.instance.getLogger().warn("[AVP/API/Assembler] Schematic with name '{}' is already registered.", schematic.getName());
            }

            return schematic;
        });
    }

    public static List<ItemSchematic> getSchematics() {
        return new ArrayList<>(schematicsByName.values());
    }

    public static ItemSchematic getSchematicByName(String name) {
        return schematicsByName.get(name.toLowerCase(Locale.US));
    }
}
