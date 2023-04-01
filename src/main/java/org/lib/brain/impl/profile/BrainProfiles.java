package org.lib.brain.impl.profile;

import org.lib.brain.profile.BrainProfile;

/**
 * @author Boston Vanseghi
 */
public class BrainProfiles {

    private BrainProfiles() {}

    public static final BrainProfile STANDARD = new BrainProfile("standard");

    // Facehugger
    public static final BrainProfile PARASITOID_ATTACHED = new BrainProfile("parasitoid_attached");
    public static final BrainProfile PARASITOID_INFERTILE = new BrainProfile("parasitoid_infertile");

    // Matriarch
    public static final BrainProfile MATRIARCH_REPRODUCING = new BrainProfile("matriarch_reproducing");
}
