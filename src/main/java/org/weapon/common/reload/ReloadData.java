package org.weapon.common.reload;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

/**
 * @author Boston Vanseghi
 */
public class ReloadData {

    private final EntityPlayer player;
    private final EnumHand enumHand;
    private final Runnable runnable;
    private final long worldTimeToRunAt;

    public ReloadData(EntityPlayer player, EnumHand enumHand, Runnable runnable, long worldTimeToRunAt) {
        this.player = player;
        this.enumHand = enumHand;
        this.runnable = runnable;
        this.worldTimeToRunAt = worldTimeToRunAt;
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }

    public EnumHand getEnumHand() {
        return this.enumHand;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public long getWorldTimeToRunAt() {
        return this.worldTimeToRunAt;
    }
}
