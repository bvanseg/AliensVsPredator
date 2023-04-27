package org.alien.common.world;

import com.asx.mdx.common.math.MDXMath;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.capability.OrganismImpl;
import org.lib.common.FuncUtil;

/**
 * @author Boston Vanseghi
 */
public class CommonEntityImpregnationHandler extends EntityImpregnationHandler
{
    public static final CommonEntityImpregnationHandler instance = new CommonEntityImpregnationHandler();

    private CommonEntityImpregnationHandler() {}

    @Override
    @SubscribeEvent
    public void tick(LivingUpdateEvent event)
    {
    	Entity entity = event.getEntity();
        World world = entity.getEntityWorld();
        EntityLivingBase host = (EntityLivingBase) entity;
        OrganismImpl organism = (OrganismImpl) host.getCapability(Provider.CAPABILITY, null);

        if (organism == null || !organism.hasEmbryo()) return;

        // If the host can't be ticked, remove its embryo and return.
        if (!this.canTickHost(entity)) {
            organism.setEmbryo(null);
            return;
        }

        organism.onTick(host, organism);

        if (world.isRemote) return;

        organism.getEmbryo().grow();

        this.updateEmbryoStageGrowth(host, organism);
    }

    private void updateEmbryoStageGrowth(EntityLivingBase host, OrganismImpl organism) {
        int age = organism.getEmbryo().getAge();
        int gestationPeriod = organism.getEmbryo().getEntry().getGestationPeriod();
        int ticksUntilBirth = gestationPeriod - age;

        // Stage 1, the player develops an increasing hunger up to hunger 100.
        if (ticksUntilBirth < gestationPeriod * STAGE_ONE_PERCENTAGE) {
            int hungerAmplifier = (int) MDXMath.map(age, gestationPeriod * (1 - STAGE_ONE_PERCENTAGE), gestationPeriod, 1, 40);
            host.addPotionEffect(new PotionEffect(MobEffects.HUNGER, gestationPeriod, hungerAmplifier));
        }

        // Stage 2, the player becomes weakened as the embryo takes hold within them.
        if (ticksUntilBirth < gestationPeriod * STAGE_TWO_PERCENTAGE) {
            host.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, gestationPeriod));
        }

        // Stage 3, the player is losing so much energy that slowness and mining fatigue take place.
        int stageThreeAmplifier = (int) MDXMath.map(age, gestationPeriod * (1 - STAGE_THREE_PERCENTAGE), gestationPeriod, 1, 4);
        if (ticksUntilBirth < gestationPeriod * STAGE_THREE_PERCENTAGE) {
            host.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, gestationPeriod, stageThreeAmplifier));
            host.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, gestationPeriod, stageThreeAmplifier));
        }

        // Stage 4, the player's bodily organs are so heavily damaged that nausea and blindness set in. Death is imminent.
        int stageFourAmplifier = (int) MDXMath.map(age, gestationPeriod * (1 - STAGE_FOUR_PERCENTAGE), gestationPeriod, 1, 4);
        if (ticksUntilBirth < gestationPeriod * STAGE_FOUR_PERCENTAGE) {
            host.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, gestationPeriod, stageFourAmplifier));
            host.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, gestationPeriod, stageFourAmplifier));
        }

        // Congratulations, it's the birth of a billion dollar franchise!
        if (ticksUntilBirth <= 0) {
            organism.getEmbryo().vitalize(host);
        }
    }

    @SubscribeEvent
    public void respawnEvent(PlayerRespawnEvent event)
    {
        OrganismImpl organism = (OrganismImpl) event.player.getCapability(Provider.CAPABILITY, null);
        FuncUtil.letc(organism, o -> o.setEmbryo(null));
    }

    @SubscribeEvent
    public void despawnEvent(LivingSpawnEvent.AllowDespawn event)
    {
        OrganismImpl organism = (OrganismImpl) event.getEntityLiving().getCapability(Provider.CAPABILITY, null);
        if (organism != null && organism.hasEmbryo())
            event.setResult(Result.DENY);
    }
}
