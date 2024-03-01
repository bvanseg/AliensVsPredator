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

    public static final GameObject<EntityType<Belugaburster>> BELUGABURSTER = registerLiving("belugaburster", EntityType.Builder.of(Belugaburster::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Belugamorph>> BELUGAMORPH = registerLiving("belugamorph", EntityType.Builder.of(Belugamorph::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<DeaconAdult>> DEACON_ADULT = registerLiving("deacon_adult", EntityType.Builder.of(DeaconAdult::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<DeaconAdultEngineer>> DEACON_ADULT_ENGINEER = registerLiving("deacon_adult_engineer", EntityType.Builder.of(DeaconAdultEngineer::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Dracoburster>> DRACOBURSTER = registerLiving("dracoburster", EntityType.Builder.of(Dracoburster::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Dracomorph>> DRACOMORPH = registerLiving("dracomorph", EntityType.Builder.of(Dracomorph::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Engineer>> ENGINEER = registerLiving("engineer", EntityType.Builder.of(Engineer::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Octohugger>> OCTOHUGGER = registerLiving("octohugger", EntityType.Builder.of(Octohugger::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Ovamorph>> OVAMORPH = registerLiving("ovamorph", EntityType.Builder.of(Ovamorph::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<OvamorphDraco>> OVAMORPH_DRACO = registerLiving("ovamorph_draco", EntityType.Builder.of(OvamorphDraco::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Trilobite>> TRILOBITE = registerLiving("trilobite", EntityType.Builder.of(Trilobite::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<TrilobiteBaby>> TRILOBITE_BABY = registerLiving("trilobite_baby", EntityType.Builder.of(TrilobiteBaby::new, MobCategory.MONSTER));
    public static final GameObject<EntityType<Ultramorph>> ULTRAMORPH = registerLiving("ultramorph", EntityType.Builder.of(Ultramorph::new, MobCategory.MONSTER));

    private static <T extends Mob> GameObject<EntityType<T>> registerLiving(String registryName, EntityType.Builder<T> builder) {
        return Services.ENTITY_REGISTRY.registerWithSpawnEgg(registryName, () -> builder.build(registryName));
    }

    @Override
    public void register() {}
}
