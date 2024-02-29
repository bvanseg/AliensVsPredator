package org.avp.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import org.avp.common.entity.living.*;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityTypes implements AVPRegistry {

    private static final AVPEntityTypes INSTANCE = new AVPEntityTypes();

    public static AVPEntityTypes getInstance() {
        return INSTANCE;
    }

    private void registerLiving(String registryName, EntityType.Builder<? extends Mob> builder) {
        Services.ENTITY_REGISTRY.registerWithSpawnEgg(registryName, () -> builder.build(registryName));
    }

    @Override
    public void register() {
        registerLiving("belugaburster", EntityType.Builder.of(Belugaburster::new, MobCategory.MONSTER));
        registerLiving("belugamorph", EntityType.Builder.of(Belugamorph::new, MobCategory.MONSTER));
        registerLiving("deacon_adult", EntityType.Builder.of(DeaconAdult::new, MobCategory.MONSTER));
        registerLiving("deacon_adult_engineer", EntityType.Builder.of(DeaconAdultEngineer::new, MobCategory.MONSTER));
        registerLiving("dracoburster", EntityType.Builder.of(Dracoburster::new, MobCategory.MONSTER));
        registerLiving("dracomorph", EntityType.Builder.of(Dracomorph::new, MobCategory.MONSTER));
        registerLiving("engineer", EntityType.Builder.of(Engineer::new, MobCategory.MONSTER));
        registerLiving("octohugger", EntityType.Builder.of(Octohugger::new, MobCategory.MONSTER));
        registerLiving("ovamorph", EntityType.Builder.of(Ovamorph::new, MobCategory.MONSTER));
        registerLiving("ovamorph_draco", EntityType.Builder.of(OvamorphDraco::new, MobCategory.MONSTER));
        registerLiving("trilobite", EntityType.Builder.of(Trilobite::new, MobCategory.MONSTER));
        registerLiving("trilobite_baby", EntityType.Builder.of(TrilobiteBaby::new, MobCategory.MONSTER));
        registerLiving("ultramorph", EntityType.Builder.of(Ultramorph::new, MobCategory.MONSTER));
    }
}
