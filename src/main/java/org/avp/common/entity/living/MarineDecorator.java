package org.avp.common.entity.living;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import org.avp.common.world.MarineTypes;

import java.util.Set;

/**
 * @author Boston Vanseghi
 */
public class MarineDecorator {

    protected static final int[] SKIN_TONES = new int[] { 0xF1C381FF, 0xC58C85FF, 0xECBCB4FF, 0xD1A3A4FF, 0xA1665EFF, 0x503335FF, 0x592F2AFF };
    protected static final int[] EYE_COLORS = new int[] {
            0x4D1500FF, // Classic brownish-black
            0x8BB5DBFF, // Light Blue
            0x4079C0FF, // Blue
            0xB3B9B9FF, // Light Gray
            0x8E9796FF, // Gray
            0x748B9DFF, // Blue-Gray
            0x6E9D4CFF, // Green
            0xAA6925FF, // Amber
            0x863603FF, // Light Brown
            0x3f0c08FF  // Dark Brown
    };

    protected static final String[] NAMES = new String[]{
            "Alex",
            "Anderson",
            "Apone",
            "Billy",
            "Bob",
            "Brandon",
            "Brody",
            "Cameron",
            "Connor",
            "Crowe",
            "Dallas",
            "Dietrich",
            "Drake",
            "Dustin",
            "Ferro",
            "Fincher",
            "Frost",
            "Gorman",
            "Harrison",
            "Hicks",
            "Hudson",
            "Jason",
            "Jefferson",
            "Justin",
            "Markus",
            "O'Bannon",
            "Shift",
            "Scott",
            "Spunkmeyer",
            "Toby",
            "Wierzbowski"
    };

    private MarineDecorator() {}

    public static int generateRandomWeaponType(EntityMarine marine) {
        return marine.world.rand.nextInt(MarineTypes.values().length);
    }

    public static int generateRandomSkinTone(EntityMarine marine) {
        return SKIN_TONES[marine.world.rand.nextInt(SKIN_TONES.length)];
    }

    public static int generateRandomEyeColor(EntityMarine marine) {
        return EYE_COLORS[marine.world.rand.nextInt(EYE_COLORS.length)];
    }

    public static int generateCamoColorBasedOnCurrentBiome(EntityMarine marine) {
        Biome biome = marine.world.getBiome(marine.getPosition());

        int color;

        Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);

        if (biomeTypes.contains(BiomeDictionary.Type.NETHER)) {
            color = 0x85_42_42_FF; // Netherrack
        } else if (biomeTypes.contains(BiomeDictionary.Type.END)) {
            color = 0xEE_F6_B4_FF; // End Stone
        } else if (biomeTypes.contains(BiomeDictionary.Type.MUSHROOM)) {
            color = 0x8B_71_73_FF; // Mycelium
        } else if (!marine.world.canBlockSeeSky(marine.getPosition())) {
            color = 0x74_74_74_FF; // Underground
        }
        else if (biomeTypes.contains(BiomeDictionary.Type.SNOWY)) {
            color = 0xFA_FA_FA_FF; // Snow
        } else if (biomeTypes.contains(BiomeDictionary.Type.SANDY) || biomeTypes.contains(BiomeDictionary.Type.BEACH)) {
            color = 0xD5_C4_96_FF; // Sand
        } else if (biomeTypes.contains(BiomeDictionary.Type.OCEAN)) {
            color = 0x1F_3C_5A_FF; // Water
        } else if (biomeTypes.contains(BiomeDictionary.Type.RIVER)) {
            color = 0x30_5A_9C_FF; // Water (river)
        } else if (biomeTypes.contains(BiomeDictionary.Type.SWAMP)) {
            color = 0x2F_5C_41_FF; // Swamp Water
        } else if (biomeTypes.contains(BiomeDictionary.Type.FOREST)) {
            color = 0x3C_67_3C_FF; // Leaves (forest)
        } else if (biomeTypes.contains(BiomeDictionary.Type.PLAINS)) {
            color = 0x8B_AC_45_FF; // Grass
        } else if (biomeTypes.contains(BiomeDictionary.Type.MOUNTAIN)) {
            color = 0x7F_7F_7F_FF; // Stone
        } else if (biomeTypes.contains(BiomeDictionary.Type.HILLS)) {
            color = 0x8B_72_3E_FF; // Dirt
        } else if (biomeTypes.contains(BiomeDictionary.Type.JUNGLE)) {
            color = 0x50_76_35_FF; // Leaves (jungle)
        } else if (biomeTypes.contains(BiomeDictionary.Type.SAVANNA)) {
            color = 0xBF_A6_5A_FF; // Grass (savanna)
        } else {
            // Default coloring for camo is white.
            color = 0xAA_AA_AA_FF;
        }

        return color;
    }

    public static String generateRandomMarineName(EntityMarine marine) {
        return NAMES[marine.world.rand.nextInt(NAMES.length)];
    }

    public static MarineRank generateRandomMarineRank(EntityMarine marine) {
        return MarineRank.values()[marine.world.rand.nextInt(MarineRank.values().length)];
    }

    public static enum MarineRank {
        PRIVATE("Private", "Pvt"),
        PRIVATE_FIRST_CLASS("Private First Class", "PFC"),
        LANCE_CORPORAL("Lance Corporal", "LCpl"),
        CORPORAL("Corporal", "Cpl"),
        SERGEANT("Sergeant", "Sgt"),
        STAFF_SERGEANT("Staff Sergeant", "SSgt"),
        GUNNERY_SERGEANT("Gunnery Sergeant", "GySgt"),
        MASTER_SERGEANT("Master Sergeant", "MSgt"),
        FIRST_SERGEANT("First Sergeant", "1st Sgt"),
        MASTER_GUNNERY_SERGEANT("Master Gunnery Sergeant", "MGySgt");

        private String displayName;
        private String shorthandName;

        MarineRank(String displayName, String shorthandName) {
            this.displayName = displayName;
            this.shorthandName = shorthandName;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getShorthandName() {
            return this.shorthandName;
        }
    }
}
