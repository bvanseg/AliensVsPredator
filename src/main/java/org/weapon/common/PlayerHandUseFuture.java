package org.weapon.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

/**
 * @author Boston Vanseghi
 */
public class PlayerHandUseFuture {

    private final EntityPlayer player;
    private final EnumHand enumHand;
    private final long worldTimeToRunAt;

    public PlayerHandUseFuture(EntityPlayer player, EnumHand enumHand, long worldTimeToRunAt) {
        this.player = player;
        this.enumHand = enumHand;
        this.worldTimeToRunAt = worldTimeToRunAt;
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }

    public EnumHand getEnumHand() {
        return this.enumHand;
    }

    public long getWorldTimeToRunAt() {
        return this.worldTimeToRunAt;
    }
}
