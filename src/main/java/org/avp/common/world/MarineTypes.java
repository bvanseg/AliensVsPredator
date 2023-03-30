package org.avp.common.world;

import com.asx.mdx.client.sound.Sound;
import net.minecraft.util.SoundEvent;
import org.weapon.common.item.firearm.ItemFirearm;
import org.weapon.common.item.init.WeaponItems;

import java.util.Arrays;
import java.util.HashMap;

public enum MarineTypes
{
    M4(0, (ItemFirearm) WeaponItems.ITEM_M4),
    AK47(1, (ItemFirearm) WeaponItems.ITEM_AK47),
    M41A(2, (ItemFirearm) WeaponItems.ITEM_M41A),
    SNIPER(3, (ItemFirearm) WeaponItems.ITEM_SNIPER),
    M56SG(4, (ItemFirearm) WeaponItems.ITEM_M56SG);

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
        Sound defaultFireSound = itemFirearm.getFirearmProperties().getFireSounds().get(itemFirearm.getFirearmProperties().getDefaultFireMode());
        return defaultFireSound != null ? defaultFireSound.event() : null;
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
