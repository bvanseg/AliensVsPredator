package org.weapon.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

/**
 * @author Boston Vanseghi
 */
public class PlayerHandUseExecutableFuture extends PlayerHandUseFuture {
    private final Runnable runnable;

    public PlayerHandUseExecutableFuture(EntityPlayer player, EnumHand enumHand, Runnable runnable, long worldTimeToRunAt) {
        super(player, enumHand, worldTimeToRunAt);
        this.runnable = runnable;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }
}
