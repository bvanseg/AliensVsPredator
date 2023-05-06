package org.predator.common.entity.living.helper;

import net.minecraft.util.math.MathHelper;
import org.predator.client.PredatorSounds;
import org.predator.common.entity.living.SpeciesYautja;
import org.predator.common.entity.state.CloakState;

/**
 * @author Boston Vanseghi
 */
public class YautjaCloakHelper {

    private YautjaCloakHelper() { /* Do Nothing */ }

    public static final int MAX_CLOAK = 20 * 2;
    public static final int MIN_CLOAK = 0;
    public static final int CLOAK_PROGRESS_SPEED = 1;

    public static void entityInit(SpeciesYautja yautja) {
        yautja.getDataManager().register(SpeciesYautja.CLOAK_STATE, CloakState.DECLOAKED);
        yautja.getDataManager().register(SpeciesYautja.CLOAK_PROGRESS, MIN_CLOAK);
    }


    public static void tickCloakingLogic(SpeciesYautja yautja) {
        if (!yautja.world.isRemote) {
            // Yautja should only force de-cloak in water, snow doesn't count.
            boolean isInRain = yautja.world.isRainingAt(yautja.getPosition()) && !yautja.world.getBiome(yautja.getPosition()).getEnableSnow();
            if (yautja.isInWater() || isInRain || yautja.getAttackTarget() != null) {
                handleDecloak(yautja);
            } else {
                handleCloak(yautja);
            }
        }

        updateCloakingProgress(yautja);
    }

    private static void updateCloakingProgress(SpeciesYautja yautja) {
        switch (yautja.getCloakState()) {
            case CLOAKED:
                yautja.cloakProgress = MAX_CLOAK;
                break;
            case CLOAKING:
                yautja.cloakProgress += CLOAK_PROGRESS_SPEED;
                break;
            case DECLOAKING_FORCED:
                yautja.cloakProgress -= CLOAK_PROGRESS_SPEED;
                break;
            case DECLOAKING_MANUAL:
                yautja.cloakProgress -= CLOAK_PROGRESS_SPEED * 3;
                break;
            default:
                yautja.cloakProgress = MIN_CLOAK;
                break;
        }

        yautja.cloakProgress = MathHelper.clamp(yautja.cloakProgress, MIN_CLOAK, MAX_CLOAK);
    }

    private static void handleCloak(SpeciesYautja yautja) {
        if (yautja.cloakProgress < MAX_CLOAK) {
            if (yautja.getCloakState() != CloakState.CLOAKING) {
                PredatorSounds.YAUTJA_CLOAK.playSound(yautja, 0.6F, 1.0F);
            }

            yautja.setCloakState(CloakState.CLOAKING);
        } else if (yautja.cloakProgress == MAX_CLOAK) {
            yautja.setCloakState(CloakState.CLOAKED);
        }
    }

    private static void handleDecloak(SpeciesYautja yautja) {
        CloakState decloakType = yautja.getAttackTarget() != null ? CloakState.DECLOAKING_MANUAL : CloakState.DECLOAKING_FORCED;

        if (yautja.cloakProgress > MIN_CLOAK) {
            if (yautja.getCloakState() != CloakState.DECLOAKING_FORCED && yautja.getCloakState() != CloakState.DECLOAKING_MANUAL) {
                PredatorSounds.YAUTJA_DECLOAK.playSound(yautja, 0.6F, 1.0F);
            }

            yautja.setCloakState(decloakType);
        }
        else if (yautja.cloakProgress == MIN_CLOAK) {
            yautja.setCloakState(CloakState.DECLOAKED);
        }
    }
}
