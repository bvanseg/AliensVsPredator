package org.avp.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import org.avp.common.AVPResources;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityTags implements AVPRegistry {

    private static final AVPEntityTags INSTANCE = new AVPEntityTags();

    public static AVPEntityTags getInstance() {
        return INSTANCE;
    }

    private static TagKey<EntityType<?>> create(String registryName) {
        return TagKey.create(Registries.ENTITY_TYPE, AVPResources.location(registryName));
    }

    public TagKey<EntityType<?>> ACID_BLEEDERS;
    public TagKey<EntityType<?>> ALIENS;
    public TagKey<EntityType<?>> EGGS;
    public TagKey<EntityType<?>> ENGINEERS;
    public TagKey<EntityType<?>> NON_HOSTS;
    public TagKey<EntityType<?>> PARASITES;
    public TagKey<EntityType<?>> PREDATORS;
    public TagKey<EntityType<?>> ROYAL_ALIENS;

    @Override
    public void register() {
        ACID_BLEEDERS = create("acid_bleeders");
        ALIENS = create("aliens");
        EGGS = create("eggs");
        ENGINEERS = create("engineers");
        NON_HOSTS = create("non_hosts");
        PARASITES = create("parasites");
        PREDATORS = create("predators");
        ROYAL_ALIENS = create("royal_aliens");
    }
}
