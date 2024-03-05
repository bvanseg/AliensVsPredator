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
public class AVPEntityTypes implements AVPRegistry {

    private static final AVPEntityTypes INSTANCE = new AVPEntityTypes();

    public static AVPEntityTypes getInstance() {
        return INSTANCE;
    }

    public static final GameObject<EntityType<Belugaburster>> BELUGABURSTER = registerLiving(
        "belugaburster",
        0xC2C1BD, 0x646857,
        EntityType.Builder.of(Belugaburster::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Belugamorph>> BELUGAMORPH = registerLiving(
        "belugamorph",
        0xBCC9C6, 0x646E65,
        EntityType.Builder.of(Belugamorph::new, MobCategory.MONSTER)
    );

    public static <T extends Mob> GameObject<EntityType<T>> registerLiving(
        String registryName,
        int backgroundColor,
        int highlightColor,
        EntityType.Builder<T> builder
    ) {
        return Services.ENTITY_REGISTRY.registerWithSpawnEgg(registryName, backgroundColor, highlightColor, () -> builder.build(registryName));
    }

    @Override
    public void register() {}
}
