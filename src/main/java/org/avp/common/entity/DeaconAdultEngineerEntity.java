package org.avp.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

/**
 * @author Boston Vanseghi
 */
public class DeaconAdultEngineerEntity extends MonsterEntity {

    protected DeaconAdultEngineerEntity(EntityType<? extends MonsterEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.2d);
    }
}
