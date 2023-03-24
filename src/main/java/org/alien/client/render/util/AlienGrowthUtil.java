package org.alien.client.render.util;

import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.entity.living.SpeciesAlien;

/**
 * @author Boston Vanseghi
 */
public class AlienGrowthUtil {
    private AlienGrowthUtil() {}

    public static float calculateJellyGrowthFactor(SpeciesAlien alien, float step, int scaleReductionFactor, float partialTicks) {
        float additionalScale = 0F;

        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(alien.getClass()).orElse(null);
        if (maturityEntry != null) {
            float jellyLevelPrev = alien.growthProgress;
            alien.growthProgress = alien.getJellyLevel();
            alien.growthProgress = jellyLevelPrev + ((alien.growthProgress - jellyLevelPrev) * partialTicks * step);
            additionalScale = alien.growthProgress / (maturityEntry.getRequiredJellyLevel() * scaleReductionFactor);
        }

        return additionalScale;
    }
}
