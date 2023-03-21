package org.alien.client.render.util;

import org.alien.common.api.parasitoidic.Maturable;
import org.alien.common.entity.living.SpeciesAlien;

/**
 * @author Boston Vanseghi
 */
public class AlienGrowthUtil {
    private AlienGrowthUtil() {}

    public static float calculateJellyGrowthFactor(SpeciesAlien alien, float step, int scaleReductionFactor, float partialTicks) {
        float additionalScale = 0F;

        if (alien instanceof Maturable) {
            float jellyLevelPrev = alien.growthProgress;
            alien.growthProgress = alien.getJellyLevel();
            alien.growthProgress = jellyLevelPrev + ((alien.growthProgress - jellyLevelPrev) * partialTicks * step);
            additionalScale = alien.growthProgress / (((Maturable) alien).getMaturityLevel() * scaleReductionFactor);
        }

        return additionalScale;
    }
}
