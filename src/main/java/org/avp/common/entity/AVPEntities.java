package org.avp.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.avp.AVPConstants;
import org.avp.AVPItemGroups;
import org.avp.AVPRegistry;
import org.avp.AVPResources;

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

    private static final RegistryObject<EntityType<BelugabursterEntity>> BELUGABURSTER = registerEntityType("belugaburster", EntityType.Builder.create(BelugabursterEntity::new, EntityClassification.MONSTER).size(0.98F, 0.98F));
    private static final RegistryObject<EntityType<BelugamorphEntity>> BELUGAMORPH = registerEntityType("belugamorph", EntityType.Builder.create(BelugamorphEntity::new, EntityClassification.MONSTER).size(0.98F, 2.98F));
    private static final RegistryObject<EntityType<DracobursterEntity>> DRACOBURSTER = registerEntityType("dracoburster", EntityType.Builder.create(DracobursterEntity::new, EntityClassification.MONSTER).size(0.98F, 2.98F));
    private static final RegistryObject<EntityType<DracomorphEntity>> DRACOMORPH = registerEntityType("dracomorph", EntityType.Builder.create(DracomorphEntity::new, EntityClassification.MONSTER).size(0.98F, 2.98F));
    private static final RegistryObject<EntityType<OctohuggerEntity>> OCTOHUGGER = registerEntityType("octohugger", EntityType.Builder.create(OctohuggerEntity::new, EntityClassification.MONSTER).size(0.5F, 0.5F));
    private static final RegistryObject<EntityType<OvamorphEntity>> OVAMORPH = registerEntityType("ovamorph", EntityType.Builder.create(OvamorphEntity::new, EntityClassification.MONSTER).size(0.98F, 0.98F));
    private static final RegistryObject<EntityType<UltramorphEntity>> ULTRAMORPH = registerEntityType("ultramorph", EntityType.Builder.create(UltramorphEntity::new, EntityClassification.MONSTER).size(0.98F, 2.98F));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntityType(String name, EntityType.Builder<T> entityTypeBuilder) {
        ResourceLocation registryName = AVPResources.location(name);
        EntityType<T> entityType = entityTypeBuilder.build(registryName.toString());

        RegistryObject<EntityType<T>> registryObject = ENTITY_TYPES.register(name, () -> entityType);

        SPAWN_EGG_ITEMS.register("spawn_egg_" + name, () -> {
            Item.Properties properties = new Item.Properties().group(AVPItemGroups.ENTITIES_ITEM_GROUP);
            return new SpawnEggItem(entityType, 0, 0, properties);
        });

        return registryObject;
    }

    @Override
    public void register() {
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SPAWN_EGG_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
