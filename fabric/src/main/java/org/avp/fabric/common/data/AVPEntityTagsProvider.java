package org.avp.fabric.common.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import org.avp.common.entity.AVPBaseAlienEntityTypes;
import org.avp.common.entity.AVPEngineerEntityTypes;
import org.avp.common.entity.AVPEntityTypes;
import org.avp.common.entity.AVPExoticAlienEntityTypes;
import org.avp.common.entity.AVPPrometheusAlienEntityTypes;
import org.avp.common.entity.AVPRunnerAlienEntityTypes;
import org.avp.common.tag.AVPEntityTags;

import java.util.concurrent.CompletableFuture;

public class AVPEntityTagsProvider extends FabricTagProvider.EntityTypeTagProvider {
    public AVPEntityTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(AVPEntityTags.PARASITES).add(
            AVPBaseAlienEntityTypes.FACEHUGGER.get(),
            AVPBaseAlienEntityTypes.FACEHUGGER_ROYAL.get(),
            AVPExoticAlienEntityTypes.OCTOHUGGER.get(),
            AVPPrometheusAlienEntityTypes.TRILOBITE.get(),
            AVPPrometheusAlienEntityTypes.TRILOBITE_BABY.get()
        );

        getOrCreateTagBuilder(AVPEntityTags.EGGS).add(
            AVPBaseAlienEntityTypes.OVAMORPH.get(),
            AVPExoticAlienEntityTypes.OVAMORPH_DRACO.get()
        );

        getOrCreateTagBuilder(AVPEntityTags.ROYAL_ALIENS).add(
            AVPBaseAlienEntityTypes.FACEHUGGER_ROYAL.get(),
            AVPBaseAlienEntityTypes.PRAETORIAN.get(),
            AVPBaseAlienEntityTypes.QUEEN.get(),
            AVPRunnerAlienEntityTypes.CRUSHER.get()
        );

        getOrCreateTagBuilder(AVPEntityTags.ALIENS)
            .addTag(AVPEntityTags.EGGS)
            .addTag(AVPEntityTags.PARASITES)
            .addTag(AVPEntityTags.ROYAL_ALIENS)
            .add(
                AVPEntityTypes.BELUGABURSTER.get(),
                AVPEntityTypes.BELUGAMORPH.get(),

                AVPBaseAlienEntityTypes.CHESTBURSTER.get(),
                AVPBaseAlienEntityTypes.DRONE.get(),
                AVPBaseAlienEntityTypes.WARRIOR.get(),
                AVPExoticAlienEntityTypes.DEACON_ADULT_ENGINEER.get(),
                AVPExoticAlienEntityTypes.DRACOBURSTER.get(),
                AVPExoticAlienEntityTypes.DRACOMORPH.get(),
                AVPExoticAlienEntityTypes.ULTRAMORPH.get(),

                AVPPrometheusAlienEntityTypes.DEACON.get(),
                AVPPrometheusAlienEntityTypes.DEACON_ADULT.get(),

                AVPRunnerAlienEntityTypes.CHESTBURSTER_RUNNER.get(),
                AVPRunnerAlienEntityTypes.DRONE_RUNNER.get(),
                AVPRunnerAlienEntityTypes.WARRIOR_RUNNER.get()
            );

        getOrCreateTagBuilder(AVPEntityTags.ACID_BLEEDERS)
            .addTag(AVPEntityTags.ALIENS);

        getOrCreateTagBuilder(AVPEntityTags.ENGINEERS).add(
            AVPEngineerEntityTypes.ENGINEER.get()
        );

        getOrCreateTagBuilder(AVPEntityTags.NON_HOSTS)
            .addOptionalTag(EntityTypeTags.UNDEAD)
            .add(
                EntityType.ALLAY,
                EntityType.AXOLOTL,
                EntityType.BAT,
                EntityType.BEE,
                EntityType.BLAZE,
                EntityType.BREEZE,
                EntityType.CAVE_SPIDER,
                EntityType.CHICKEN,
                EntityType.AXOLOTL,
                EntityType.COD,
                EntityType.ELDER_GUARDIAN,
                EntityType.AXOLOTL,
                EntityType.ENDERMAN,
                EntityType.ENDERMITE,
                EntityType.AXOLOTL,
                EntityType.FROG,
                EntityType.GHAST,
                EntityType.GLOW_SQUID,
                EntityType.GUARDIAN,
                EntityType.IRON_GOLEM,
                EntityType.MAGMA_CUBE,
                EntityType.PARROT,
                EntityType.PUFFERFISH,
                EntityType.SALMON,
                EntityType.SHULKER,
                EntityType.SHULKER_BULLET,
                EntityType.SILVERFISH,
                EntityType.SLIME,
                EntityType.SNOW_GOLEM,
                EntityType.SPIDER,
                EntityType.SQUID,
                EntityType.STRIDER,
                EntityType.TADPOLE,
                EntityType.TROPICAL_FISH,
                EntityType.VEX,
                EntityType.WARDEN
            );
    }
}
