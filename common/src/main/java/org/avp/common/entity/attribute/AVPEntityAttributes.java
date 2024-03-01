package org.avp.common.entity.attribute;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import org.avp.common.entity.AVPEntityTypes;
import org.avp.common.util.GameObject;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityAttributes {

    private static final AVPEntityAttributes INSTANCE = new AVPEntityAttributes();

    private static final List<Map.Entry<GameObject<? extends EntityType<? extends Mob>>, AttributeSupplier>> BINDINGS = new ArrayList<>();

    public static AVPEntityAttributes getInstance() {
        return INSTANCE;
    }

    public static List<Map.Entry<GameObject<? extends EntityType<? extends Mob>>, AttributeSupplier>> getBindings() {
        return BINDINGS;
    }

    public static final AttributeSupplier BELUGABURSTER = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier BELUGAMORPH = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier DEACON_ADULT = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier DEACON_ADULT_ENGINEER = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier DRACOBURSTER = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier DRACOMORPH = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier ENGINEER = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier OCTOHUGGER = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier OVAMORPH = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier OVAMORPH_DRACO = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier TRILOBITE = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier TRILOBITE_BABY = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();
    public static final AttributeSupplier ULTRAMORPH = Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.MOVEMENT_SPEED, 1).add(Attributes.FOLLOW_RANGE, 1).build();

    private static <T extends Mob> void addBinding(GameObject<EntityType<T>> gameObject, AttributeSupplier attributeSupplier) {
        BINDINGS.add(new AbstractMap.SimpleEntry<>(gameObject, attributeSupplier));
    }

    static {
        addBinding(AVPEntityTypes.BELUGABURSTER, BELUGABURSTER);
        addBinding(AVPEntityTypes.BELUGAMORPH, BELUGAMORPH);
        addBinding(AVPEntityTypes.DEACON_ADULT, DEACON_ADULT);
        addBinding(AVPEntityTypes.DEACON_ADULT_ENGINEER, DEACON_ADULT_ENGINEER);
        addBinding(AVPEntityTypes.DRACOBURSTER, DRACOBURSTER);
        addBinding(AVPEntityTypes.DRACOMORPH, DRACOMORPH);
        addBinding(AVPEntityTypes.ENGINEER, ENGINEER);
        addBinding(AVPEntityTypes.OCTOHUGGER, OCTOHUGGER);
        addBinding(AVPEntityTypes.OVAMORPH, OVAMORPH);
        addBinding(AVPEntityTypes.OVAMORPH_DRACO, OVAMORPH_DRACO);
        addBinding(AVPEntityTypes.TRILOBITE, TRILOBITE);
        addBinding(AVPEntityTypes.TRILOBITE_BABY, TRILOBITE_BABY);
        addBinding(AVPEntityTypes.ULTRAMORPH, ULTRAMORPH);
    }
}
