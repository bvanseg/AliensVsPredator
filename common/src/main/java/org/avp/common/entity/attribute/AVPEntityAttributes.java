package org.avp.common.entity.attribute;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.avp.common.entity.*;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityAttributes {

    private static final AVPEntityAttributes INSTANCE = new AVPEntityAttributes();

    private static final List<Map.Entry<GameObject<? extends EntityType<? extends Mob>>, AttributeSupplier>> BINDINGS =
        new ArrayList<>();

    public static AVPEntityAttributes getInstance() {
        return INSTANCE;
    }

    public static List<Map.Entry<GameObject<? extends EntityType<? extends Mob>>, AttributeSupplier>> getBindings() {
        return BINDINGS;
    }

    private static AttributeSupplier.Builder createAvPAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.ARMOR, 0)
            .add(Attributes.FOLLOW_RANGE, 16)
            .add(Attributes.MAX_HEALTH, 20)
            .add(Attributes.MOVEMENT_SPEED, 1);
    }

    public static final AttributeSupplier BELUGABURSTER = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 0.5D)
        .add(Attributes.MAX_HEALTH, 14.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.6499999761581421D)
        .build();

    public static final AttributeSupplier BELUGAMORPH = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 4.5D)
        .add(Attributes.MAX_HEALTH, 100.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.4700000238418579D)
        .build();

    public static final AttributeSupplier DEACON_ADULT = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 3D)
        .add(Attributes.MAX_HEALTH, 120.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.4700000238418579D)
        .build();

    public static final AttributeSupplier DEACON_ADULT_ENGINEER = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 4D)
        .add(Attributes.MAX_HEALTH, 150.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.4700000238418579D)
        .build();

    public static final AttributeSupplier DRACOBURSTER = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 0.5D)
        .add(Attributes.MAX_HEALTH, 25.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.6499999761581421D)
        .build();

    public static final AttributeSupplier DRONE = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 7.0D)
        .add(Attributes.MAX_HEALTH, 40.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.53D)
        .build();

    public static final AttributeSupplier DRACOMORPH = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 8.0D)
        .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
        .add(Attributes.MAX_HEALTH, 400.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.45199999761581421D)
        .build();

    public static final AttributeSupplier ENGINEER = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 8.0D)
        .add(Attributes.KNOCKBACK_RESISTANCE, 0.85D)
        .add(Attributes.MAX_HEALTH, 160.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.5199999761581421D)
        .build();

    public static final AttributeSupplier FACEHUGGER = createAvPAttributes()
        .add(Attributes.MAX_HEALTH, 5.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.55D)
        .build();

    public static final AttributeSupplier FACEHUGGER_ROYAL = createAvPAttributes()
        .add(Attributes.MAX_HEALTH, 14.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.6D)
        .build();

    public static final AttributeSupplier OCTOHUGGER = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 0.50D)
        .add(Attributes.MAX_HEALTH, 14.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.55D)
        .build();

    public static final AttributeSupplier OVAMORPH = createAvPAttributes()
        .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
        .add(Attributes.MAX_HEALTH, 8.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.0D)
        .build();

    public static final AttributeSupplier OVAMORPH_DRACO = createAvPAttributes()
        .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
        .add(Attributes.MAX_HEALTH, 16.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.0D)
        .build();

    public static final AttributeSupplier PRAETORIAN = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 12.0D)
        .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
        .add(Attributes.MAX_HEALTH, 100.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.5D)
        .build();

    public static final AttributeSupplier TRILOBITE = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 4.0D)
        .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
        .add(Attributes.MAX_HEALTH, 44.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.6999999761581421D)
        .build();

    public static final AttributeSupplier TRILOBITE_BABY = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 0.5D)
        .add(Attributes.MAX_HEALTH, 16.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.6499999761581421D)
        .build();

    public static final AttributeSupplier ULTRAMORPH = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 5.5D)
        .add(Attributes.MAX_HEALTH, 230.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.4700000238418579D)
        .build();

    public static final AttributeSupplier WARRIOR = createAvPAttributes()
        .add(Attributes.ATTACK_DAMAGE, 9.0D)
        .add(Attributes.MAX_HEALTH, 50.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.5D)
        .build();

    private static <T extends Mob> void addBinding(
        GameObject<EntityType<T>> gameObject,
        AttributeSupplier attributeSupplier
    ) {
        BINDINGS.add(new AbstractMap.SimpleEntry<>(gameObject, attributeSupplier));
    }

    static {
        // Unclassified
        addBinding(AVPEntityTypes.BELUGABURSTER, BELUGABURSTER);
        addBinding(AVPEntityTypes.BELUGAMORPH, BELUGAMORPH);

        // Exotic
        addBinding(AVPExoticAlienEntityTypes.DEACON_ADULT_ENGINEER, DEACON_ADULT_ENGINEER);
        addBinding(AVPExoticAlienEntityTypes.DRACOBURSTER, DRACOBURSTER);
        addBinding(AVPExoticAlienEntityTypes.DRACOMORPH, DRACOMORPH);
        addBinding(AVPExoticAlienEntityTypes.OCTOHUGGER, OCTOHUGGER);
        addBinding(AVPExoticAlienEntityTypes.OVAMORPH_DRACO, OVAMORPH_DRACO);
        addBinding(AVPExoticAlienEntityTypes.ULTRAMORPH, ULTRAMORPH);

        // Prometheus Engineers
        addBinding(AVPEngineerEntityTypes.ENGINEER, ENGINEER);

        // Prometheus Aliens
        addBinding(AVPPrometheusAlienEntityTypes.DEACON_ADULT, DEACON_ADULT);
        addBinding(AVPPrometheusAlienEntityTypes.TRILOBITE, TRILOBITE);
        addBinding(AVPPrometheusAlienEntityTypes.TRILOBITE_BABY, TRILOBITE_BABY);

        // Base Aliens
        addBinding(AVPBaseAlienEntityTypes.DRONE, DRONE);
        addBinding(AVPBaseAlienEntityTypes.FACEHUGGER, FACEHUGGER);
        addBinding(AVPBaseAlienEntityTypes.FACEHUGGER_ROYAL, FACEHUGGER_ROYAL);
        addBinding(AVPBaseAlienEntityTypes.OVAMORPH, OVAMORPH);
        addBinding(AVPBaseAlienEntityTypes.PRAETORIAN, PRAETORIAN);
        addBinding(AVPBaseAlienEntityTypes.WARRIOR, WARRIOR);
    }
}
