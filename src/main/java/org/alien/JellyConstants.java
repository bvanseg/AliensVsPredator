package org.alien;

/**
 * @author Boston Vanseghi
 */
public class JellyConstants {

    private JellyConstants() {
    }

    public static final int RAW_YIELD = 64;
    public static final int BASE_FOOD_YIELD = RAW_YIELD / 16;

    // Drone values
    public static final int DRONE_SHARE_THRESHOLD = RAW_YIELD / 2;

    // Queen values
    public static final int EGG_LAY_COST = 25;
    public static final int OVIPOSITOR_THRESHOLD = RAW_YIELD * 2;
    public static final int OVIPOSITOR_GROWTH_COST = 1;
}
