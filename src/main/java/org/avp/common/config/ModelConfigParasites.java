package org.avp.common.config;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.alien.common.api.parasitoidic.Parasitoid;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigParasites {

    @ConfigValue.Collection(key = "parasite.target.denylist", requiresRestart = true)
    public Set<String> denyList = null;

    public ModelConfigParasites() { /* Do Nothing */ }

    public Set<Class<? extends Entity>> getTargetDenyList() {
        return this.denyList.stream().map(registryName -> {
            EntityEntry entry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(registryName));
            return entry != null ? entry.getEntityClass() : null;
        }).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public void init() {
        if (denyList == null) {
            denyList = Parasitoid.getParasitoidDenylistRegistryNames();
        }
    }
}
