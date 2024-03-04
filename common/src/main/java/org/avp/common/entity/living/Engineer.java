package org.avp.common.entity.living;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

/**
 * @author Boston Vanseghi
 */
public class Engineer extends Monster {

    private static final EntityDataAccessor<Integer> ENGINEER_TYPE = SynchedEntityData.defineId(
        Engineer.class,
        EntityDataSerializers.INT
    );

    private static final EntityDataAccessor<Boolean> HAS_HELMET = SynchedEntityData.defineId(
        Engineer.class,
        EntityDataSerializers.BOOLEAN
    );

    public Engineer(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ENGINEER_TYPE, this.random.nextInt(2));
        this.entityData.define(HAS_HELMET, this.random.nextBoolean());
    }

    public boolean hasHelmet() {
        return this.entityData.get(HAS_HELMET);
    }

    public int getSuitType() {
        return this.entityData.get(ENGINEER_TYPE);
    }
}
