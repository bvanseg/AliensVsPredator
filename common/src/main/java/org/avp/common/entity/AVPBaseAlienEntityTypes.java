package org.avp.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import org.avp.common.entity.living.*;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPBaseAlienEntityTypes implements AVPRegistry {

    private static final AVPBaseAlienEntityTypes INSTANCE = new AVPBaseAlienEntityTypes();

    public static AVPBaseAlienEntityTypes getInstance() {
        return INSTANCE;
    }

    public static final GameObject<EntityType<Ovamorph>> OVAMORPH = AVPEntityTypes.registerLiving(
        "ovamorph",
        0x615B45, 0xBF7872,
        EntityType.Builder.of(Ovamorph::new, MobCategory.MONSTER)
    );

    @Override
    public void register() {}
}
