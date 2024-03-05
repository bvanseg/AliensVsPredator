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

    public static final GameObject<EntityType<DeaconAdult>> DEACON_ADULT = registerLiving(
        "deacon_adult",
        0x8896A5, 0x495256,
        EntityType.Builder.of(DeaconAdult::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<DeaconAdultEngineer>> DEACON_ADULT_ENGINEER = registerLiving(
        "deacon_adult_engineer",
        0, 0, // TODO:
        EntityType.Builder.of(DeaconAdultEngineer::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Dracoburster>> DRACOBURSTER = registerLiving(
        "dracoburster",
        0xD8B877, 0xF7E2B4,
        EntityType.Builder.of(Dracoburster::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Dracomorph>> DRACOMORPH = registerLiving(
        "dracomorph",
        0x212121, 0x535353,
        EntityType.Builder.of(Dracomorph::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Engineer>> ENGINEER = registerLiving(
        "engineer",
        0xB8B1B6, 0x99AFBD,
        EntityType.Builder.of(Engineer::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Octohugger>> OCTOHUGGER = registerLiving(
        "octohugger",
        0xC2BCC8, 0xC09CAE,
        EntityType.Builder.of(Octohugger::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Ovamorph>> OVAMORPH = registerLiving(
        "ovamorph",
        0x615B45, 0xBF7872,
        EntityType.Builder.of(Ovamorph::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<OvamorphDraco>> OVAMORPH_DRACO = registerLiving(
        "ovamorph_draco",
        0x2F2F2F, 0xA36762,
        EntityType.Builder.of(OvamorphDraco::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Trilobite>> TRILOBITE = registerLiving(
        "trilobite",
        0xCCC2A5, 0x987379,
        EntityType.Builder.of(Trilobite::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<TrilobiteBaby>> TRILOBITE_BABY = registerLiving(
        "trilobite_baby",
        0xCCC2A5, 0x987379,
        EntityType.Builder.of(TrilobiteBaby::new, MobCategory.MONSTER)
    );

    public static final GameObject<EntityType<Ultramorph>> ULTRAMORPH = registerLiving(
        "ultramorph",
        0x3E474E, 0x696E76,
        EntityType.Builder.of(Ultramorph::new, MobCategory.MONSTER)
    );

    private static <T extends Mob> GameObject<EntityType<T>> registerLiving(
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
