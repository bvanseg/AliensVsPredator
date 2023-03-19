package org.avp;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Provides a O(1) method to access entities by UUID.
 *
 * @author Boston Vanseghi
 */
public class EntityAccessor implements IInitEvent {
    public static final EntityAccessor instance = new EntityAccessor();

    private static final HashMap<UUID, WeakReference<Entity>> entitiesByUUID = new HashMap<>();

    private EntityAccessor() {}

    private void putEntity(Entity entity) {
        Objects.requireNonNull(entity);
        WeakReference<Entity> ref = new WeakReference<>(entity);
        entitiesByUUID.compute(entity.getUniqueID(), (key, value) -> ref);
    }

    public Optional<Entity> getEntityByUUID(UUID uuid) {
        WeakReference<Entity> ref = entitiesByUUID.get(uuid);

        if (ref == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(ref.get());
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {
        this.putEntity(event.getEntity());
    }

    @SubscribeEvent
    public void onWorldTickEvent(TickEvent.WorldTickEvent event) {
        // Remove dead references every minute.
        if (event.world.getTotalWorldTime() % (20 * 60) == 0) {
            entitiesByUUID.entrySet().removeIf(entry -> entry.getValue() == null || entry.getValue().get() == null);
        }
    }
}
