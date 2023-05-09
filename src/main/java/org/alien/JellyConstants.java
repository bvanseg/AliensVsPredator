package org.alien;

/**
 * @author Boston Vanseghi
 */
public class JellyConstants {

    private JellyConstants() {
    }

    /* Base */
    public static final int RAW_YIELD = 64;

    // The jelly yield that eating food gives to xenomorphs. This is multiplied with the food count + saturation.
    public static final int BASE_FOOD_YIELD = RAW_YIELD / 16;

    /* Drone values */

    // The jelly cost for a drone to produce a resin block.
    public static final int RESIN_PLACE_COST = RAW_YIELD / 4;

    // The threshold at which drones can share excess jelly to the queen.
    public static final int DRONE_SHARE_THRESHOLD = RAW_YIELD / 2;

    /* Queen values */
    public static final int EGG_LAY_COST = RAW_YIELD / 3;

    // The threshold at which the queen will no longer demand jelly.
    public static final int QUEEN_SHARE_SATISFACTION_THRESHOLD = RAW_YIELD * 2;

    // How much jelly it costs to grow the queen's ovipositor per tick.
    public static final int OVIPOSITOR_GROWTH_COST = 1;
}
