package org.avp.common.config;

import org.alien.common.api.emybro.EmbryoEntries;
import org.alien.common.api.emybro.EmbryoEntry;
import org.alien.common.api.emybro.EmbryoRegistry;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigEmbryos {

    @ConfigValue.Collection(key = "embryo.entries")
    public Set<ModelConfigEmbryoEntry> embryoEntries;

    public ModelConfigEmbryos() { /* Do Nothing */ }

    public void init() {
        if (this.embryoEntries == null) {
            HashSet<EmbryoEntry> defaultEmbryoEntries = new HashSet<>();
            defaultEmbryoEntries.add(EmbryoEntries.BATXENO);
            defaultEmbryoEntries.add(EmbryoEntries.BELUGAMORPH);
            defaultEmbryoEntries.add(EmbryoEntries.BOILER);
            defaultEmbryoEntries.add(EmbryoEntries.DEACON);
            defaultEmbryoEntries.add(EmbryoEntries.DRACOMORPH);
            defaultEmbryoEntries.add(EmbryoEntries.DRONE);
            defaultEmbryoEntries.add(EmbryoEntries.MYCELIOMORPH);
            defaultEmbryoEntries.add(EmbryoEntries.NAUTICOMORPH);
            defaultEmbryoEntries.add(EmbryoEntries.PANTHERAMORPH);
            defaultEmbryoEntries.add(EmbryoEntries.PREDALIEN);
            defaultEmbryoEntries.add(EmbryoEntries.QUEEN);
            defaultEmbryoEntries.add(EmbryoEntries.RUNNER_DRONE);
            defaultEmbryoEntries.add(EmbryoEntries.SPITTER);
            defaultEmbryoEntries.add(EmbryoEntries.ULTRAMORPH);
            this.embryoEntries = defaultEmbryoEntries.stream().map(ModelConfigEmbryoEntry::new)
                    .filter(entry -> entry.getAdult() != null && !entry.getAdult().isEmpty())
                    .collect(Collectors.toSet());
        }

        for (ModelConfigEmbryoEntry configEmbryoEntry: this.embryoEntries) {
            EmbryoEntry embryoEntry = new EmbryoEntry.Builder(configEmbryoEntry).build();
            EmbryoRegistry.register(embryoEntry);
        }
    }
}
