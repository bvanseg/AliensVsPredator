package org.avp.common.entity.attribute;

import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import org.avp.common.entity.*;

/**
 * @author Boston Vanseghi
 */
public class AVPBaseAlienEntityAttributes {

    private static final AttributeSupplier CHESTBURSTER = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.ATTACK_DAMAGE, 0.5D)
        .add(Attributes.MAX_HEALTH, 14.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.6499999761581421D)
        .build();

    private static final AttributeSupplier DRONE = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.ATTACK_DAMAGE, 7.0D)
        .add(Attributes.MAX_HEALTH, 40.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.53D)
        .build();

    private static final AttributeSupplier FACEHUGGER = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.MAX_HEALTH, 5.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.55D)
        .build();

    private static final AttributeSupplier FACEHUGGER_ROYAL = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.MAX_HEALTH, 14.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.6D)
        .build();

    private static final AttributeSupplier OVAMORPH = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
        .add(Attributes.MAX_HEALTH, 8.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.0D)
        .build();

    private static final AttributeSupplier PRAETORIAN = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.ATTACK_DAMAGE, 12.0D)
        .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
        .add(Attributes.MAX_HEALTH, 100.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.5D)
        .build();

    private static final AttributeSupplier QUEEN = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.ATTACK_DAMAGE, 24.0D)
        .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
        .add(Attributes.MAX_HEALTH, 300.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.600000238418579D)
        .build();

    private static final AttributeSupplier WARRIOR = AVPEntityAttributesBindingRegistry.builder()
        .add(Attributes.ATTACK_DAMAGE, 9.0D)
        .add(Attributes.MAX_HEALTH, 50.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.5D)
        .build();

    public static void addBindings() {
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.CHESTBURSTER, CHESTBURSTER);
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.DRONE, DRONE);
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.FACEHUGGER, FACEHUGGER);
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.FACEHUGGER_ROYAL, FACEHUGGER_ROYAL);
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.OVAMORPH, OVAMORPH);
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.PRAETORIAN, PRAETORIAN);
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.QUEEN, QUEEN);
        AVPEntityAttributesBindingRegistry.addBinding(AVPBaseAlienEntityTypes.WARRIOR, WARRIOR);
    }
}
