package org.weapon.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public class PlayerHandKey {
    private final EntityPlayer player;
    private final EnumHand enumHand;

    public PlayerHandKey(EntityPlayer player, EnumHand enumHand) {
        this.player = player;
        this.enumHand = enumHand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, enumHand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerHandKey playerHandKey = (PlayerHandKey) o;
        return player.equals(playerHandKey.player) && enumHand == playerHandKey.enumHand;
    }
}