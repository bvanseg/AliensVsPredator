package org.avp.common.entity.living;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

/**
 * @author Boston Vanseghi
 */
public class Praetorian extends Monster {

    public Praetorian(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
}
