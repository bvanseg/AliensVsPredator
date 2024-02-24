package org.avp.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.avp.AVPConstants;
import org.avp.AVPItemGroups;
import org.avp.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPEntities implements AVPRegistry {
    private static final AVPEntities INSTANCE = new AVPEntities();

    public static AVPEntities getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, AVPConstants.MOD_ID);
    private static final DeferredRegister<Item> SPAWN_EGG_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    private static final EntityType<OvamorphEntity> OVAMORPH = registerEntityType("ovamorph", EntityType.Builder.create(OvamorphEntity::new, EntityClassification.MONSTER));

    private static <T extends Entity> EntityType<T> registerEntityType(String name, EntityType.Builder<T> entityTypeBuilder) {
        EntityType<T> entityType = entityTypeBuilder.build(AVPConstants.MOD_ID + ":" + name);

        ENTITY_TYPES.register(name, () -> entityType);

        SPAWN_EGG_ITEMS.register("spawn_egg_" + name, () -> {
            Item.Properties properties = new Item.Properties().group(AVPItemGroups.ENTITIES_ITEM_GROUP);
            return new SpawnEggItem(entityType, 0, 0, properties);
        });

        return entityType;
    }

    @Override
    public void register() {
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SPAWN_EGG_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
