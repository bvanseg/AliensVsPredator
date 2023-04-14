package org.weapon.common.item.firearm.rework.mode;

/**
 * @author Boston Vanseghi
 */
public class FireModes {

    private FireModes() {}

    public static final FireMode AUTOMATIC = new FireMode(true, false);
    public static final FireMode SEMI_AUTOMATIC = new FireMode(false, false);
    public static final FireMode TRIPLE_BURST = new FireMode(3, false, false);
    public static final FireMode QUAD_BURST = new FireMode(4, false, false);
    public static final FireMode SINGLE_SHOT = new FireMode(false, true);
}
