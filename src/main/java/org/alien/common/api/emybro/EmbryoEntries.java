package org.alien.common.api.emybro;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.*;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesEngineer;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.EntityBelugaburster;
import org.alien.common.entity.living.vardic.EntityBelugamorph;
import org.alien.common.entity.living.vardic.EntityOctohugger;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.burster.*;
import org.alien.common.entity.living.xenomorph.exotic.*;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.predator.common.entity.living.SpeciesYautja;

/**
 * @author Boston Vanseghi
 */
public class EmbryoEntries {

    private EmbryoEntries() {}

    public static final EmbryoEntry DRONE = new EmbryoEntry.Builder(EntityDrone.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
//            .addHost(EntityLiving.class) // No hosts since DRONE is the fallback for everything else.
            .removeHost(SpeciesAlien.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry RUNNER_DRONE = new EmbryoEntry.Builder(EntityRunnerDrone.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityRunnerChestburster.class)
            .addHost(EntityAnimal.class) // Animal hosts.
            .removeHost(SpeciesAlien.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry QUEEN = new EmbryoEntry.Builder(EntityMatriarch.class)
            .setImpregnator(EntityRoyalFacehugger.class)
            .setTransitionaryStage(EntityQueenChestburster.class)
            .addHost(EntityLiving.class) // Any host, royal facehugger is the deciding factor.
            .removeHost(SpeciesAlien.class)
            .removeHost(EntityCombatSynthetic.class)
            .setGestationPeriod(20 * 60 * 10) // 10 Minutes
            .build();

    public static final EmbryoEntry BELUGAMORPH = new EmbryoEntry.Builder(EntityBelugamorph.class)
            .setImpregnator(EntityOctohugger.class)
            .setTransitionaryStage(EntityBelugaburster.class)
            .addHost(EntityLiving.class) // Any host, octohugger is the deciding factor.
            .removeHost(SpeciesAlien.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry DEACON = new EmbryoEntry.Builder(EntityDeaconAdult.class)
            .setImpregnator(EntityTrilobite.class)
            .setTransitionaryStage(EntityDeacon.class)
            .addHost(EntityLiving.class) // Any host
            .removeHost(SpeciesAlien.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry PREDALIEN = new EmbryoEntry.Builder(EntityPredalien.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityPredalienChestburster.class)
            .addHost(SpeciesYautja.class) // Predator hosts
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry ULTRAMORPH = new EmbryoEntry.Builder(EntityUltramorph.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
            .addHost(SpeciesEngineer.class) // Engineer hosts
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry DRACOMORPH = new EmbryoEntry.Builder(EntityDracomorph.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityDracoburster.class)
            .addHost(EntityDragon.class) // Good luck trying to get this to happen.
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry BOILER = new EmbryoEntry.Builder(EntityBoiler.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
            .addHost(EntityCreeper.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry SPITTER = new EmbryoEntry.Builder(EntitySpitter.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
            .addHost(EntityWitch.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry MYCELIOMORPH = new EmbryoEntry.Builder(EntityMyceliomorph.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
            .addHost(EntityMooshroom.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry PANTHERAMORPH = new EmbryoEntry.Builder(EntityPantheramorph.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
            .addHost(EntityOcelot.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry BATXENO = new EmbryoEntry.Builder(EntityBatXeno.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
            .addHost(EntityBat.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();

    public static final EmbryoEntry NAUTICOMORPH = new EmbryoEntry.Builder(EntityNauticomorph.class)
            .setImpregnator(EntityFacehugger.class)
            .setTransitionaryStage(EntityChestburster.class)
            .addHost(EntityWaterMob.class)
            .addHost(EntityGuardian.class)
            .removeHost(EntityCombatSynthetic.class)
            .build();
}
