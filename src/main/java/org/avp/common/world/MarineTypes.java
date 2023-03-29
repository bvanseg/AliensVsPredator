package org.avp.common.world;

import net.minecraft.util.SoundEvent;
import org.avp.common.AVPItems;
import org.avp.common.item.firearm.ItemFirearm;

import java.util.Arrays;
import java.util.HashMap;

public enum MarineTypes
{
    M4(0, (ItemFirearm) AVPItems.ITEM_M4),
    AK47(1, (ItemFirearm) AVPItems.ITEM_AK47),
    M41A(2, (ItemFirearm) AVPItems.ITEM_M41A),
    SNIPER(3, (ItemFirearm) AVPItems.ITEM_SNIPER),
    M56SG(4, (ItemFirearm) AVPItems.ITEM_M56SG);

    private final int id;
    private final ItemFirearm itemFirearm;

    MarineTypes(int id, ItemFirearm itemFirearm)
    {
        this.id = id;
        this.itemFirearm = itemFirearm;
    }

    public int getValue()
    {
        return id;
    }

    public SoundEvent getGunfireSound()
    {
        return itemFirearm.getFirearmProfile().getSound().event();
    }

    public ItemFirearm getFirearmItem()
    {
        return itemFirearm;
    }

    private static final HashMap<Integer, MarineTypes> typesById = new HashMap<>();

    static {
        Arrays.stream(MarineTypes.values()).forEach(type -> typesById.put(type.id, type));
    }

    public static MarineTypes getTypeForId(int id) {
        return typesById.get(id);
    }
}
