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
        switch (yautja.cloakState.get()) {
            case CLOAKED:
                yautja.cloakRenderProgress = MAX_CLOAK;
                break;
            case CLOAKING:
                yautja.cloakRenderProgress += CLOAK_PROGRESS_SPEED;
                break;
            case DECLOAKING_FORCED:
                yautja.cloakRenderProgress -= CLOAK_PROGRESS_SPEED;
                break;
            case DECLOAKING_MANUAL:
                yautja.cloakRenderProgress -= CLOAK_PROGRESS_SPEED * 3;
                break;
            default:
                yautja.cloakRenderProgress = MIN_CLOAK;
                break;
        }

        yautja.cloakRenderProgress = MathHelper.clamp(yautja.cloakRenderProgress, MIN_CLOAK, MAX_CLOAK);
    }

    private static void handleCloak(SpeciesYautja yautja) {
        if (yautja.cloakRenderProgress < MAX_CLOAK) {
            if (yautja.cloakState.get() != CloakState.CLOAKING) {
                PredatorSounds.YAUTJA_CLOAK.playSound(yautja, 0.6F, 1.0F);
            }

            yautja.cloakState.set(CloakState.CLOAKING);
        } else if (yautja.cloakRenderProgress == MAX_CLOAK) {
            yautja.cloakState.set(CloakState.CLOAKED);
        }
    }

    private static void handleDecloak(SpeciesYautja yautja) {
        CloakState decloakType = yautja.getAttackTarget() != null ? CloakState.DECLOAKING_MANUAL : CloakState.DECLOAKING_FORCED;

        if (yautja.cloakRenderProgress > MIN_CLOAK) {
            if (yautja.cloakState.get() != CloakState.DECLOAKING_FORCED && yautja.cloakState.get() != CloakState.DECLOAKING_MANUAL) {
                PredatorSounds.YAUTJA_DECLOAK.playSound(yautja, 0.6F, 1.0F);
            }

            yautja.cloakState.set(decloakType);
        }
        else if (yautja.cloakRenderProgress == MIN_CLOAK) {
            yautja.cloakState.set(CloakState.DECLOAKED);
        }
    }
}
