package org.avp.common.world;

import com.asx.mdx.client.sound.Sound;
import net.minecraft.util.SoundEvent;
import org.weapon.common.item.firearm.ItemFirearm;
import org.weapon.common.item.init.WeaponItems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public enum MarineTypes
{
    M4(0, (ItemFirearm) WeaponItems.ITEM_M4, 2),
    AK47(1, (ItemFirearm) WeaponItems.ITEM_AK47, 3),
    M41A(2, (ItemFirearm) WeaponItems.ITEM_M41A, 2),
    SNIPER(3, (ItemFirearm) WeaponItems.ITEM_SNIPER, 2),
    M56SG(4, (ItemFirearm) WeaponItems.ITEM_M56SG, 1),
    PISTOL(5, (ItemFirearm) WeaponItems.ITEM_PISTOL, 90);

    private final int id;
    private final ItemFirearm itemFirearm;
    private final int weight;

    MarineTypes(int id, ItemFirearm itemFirearm, int weight)
    {
        this.id = id;
        this.itemFirearm = itemFirearm;
        this.weight = weight;
    }

    public int getValue()
    {
        return id;
    }

    public int getWeight() {
        return this.weight;
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

    public static int getSumOfWeights() {
        int i = 0;
        for (MarineTypes type: values()) {
            i += type.weight;
        }
        return i;
    }

    public static int[] getCumulativeSummedWeights() {
        int[] summedWeights = new int[values().length];

        int index = 0;
        int currentSum = 0;
        for (MarineTypes type: values()) {
            currentSum += type.weight;
            summedWeights[index] = currentSum;
            index++;
        }

        return summedWeights;
    }

    public static MarineTypes rollRandomWeightedMarineType(Random random) {
        int weightSum = getSumOfWeights();
        int weightRoll = random.nextInt(weightSum);
        int[] summedWeights = getCumulativeSummedWeights();

        int i = 0;
        for (int cumulativeWeight: summedWeights) {
            if (weightRoll < cumulativeWeight) {
                return MarineTypes.values()[i];
            }
            i++;
        }

        return MarineTypes.PISTOL;
    }
}
