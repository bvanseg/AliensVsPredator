package org.alien.common.world;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.math.MDXMath;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import org.alien.client.AlienSounds;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.capability.OrganismImpl;
import org.lib.common.FuncUtil;

public class EntityImpregnationHandler
{
    public static final EntityImpregnationHandler instance = new EntityImpregnationHandler();

    private EntityImpregnationHandler() {}

    @SubscribeEvent
    public void tick(LivingUpdateEvent event)
    {
    	Entity entity =  event.getEntity();
    	
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
        
    	int age = organism.getEmbryo().getAge();
        int gestationPeriod = organism.getEmbryo().getEntry().getGestationPeriod();
        int ticksUntilBirth = gestationPeriod - age;

        if (!world.isRemote || !ClientGame.instance.minecraft().isGamePaused()) {
            organism.getEmbryo().grow();
        }

        if (!world.isRemote) {
            // These variables determine the beginning times of the stages of embryo development as percentages. The percentages
            // count down as they are multiplied with the gestationPeriod (so if age < gestationPeriod * 0.75, stage 1 will
            // begin once 25% of the gestation period has elapsed).
            double stageOnePercentage = 0.75;
            double stageTwoPercentage = 0.5;
            double stageThreePercentage = 0.25;
            double stageFourPercentage = 0.1;

            int currentStage = (int) MDXMath.map(age, gestationPeriod * (1 - stageOnePercentage), gestationPeriod * (1 - stageFourPercentage), 1, 4);

            // Stage 1, the player develops an increasing hunger up to hunger 100.
            if (ticksUntilBirth < gestationPeriod * stageOnePercentage) {
                int hungerAmplifier = (int) MDXMath.map(age, gestationPeriod * (1 - stageOnePercentage), gestationPeriod, 1, 40);
                host.addPotionEffect(new PotionEffect(MobEffects.HUNGER, gestationPeriod, hungerAmplifier));
            }

            // Stage 2, the player becomes weakened as the embryo takes hold within them.
            if (ticksUntilBirth < gestationPeriod * stageTwoPercentage) {
                host.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, gestationPeriod));
            }

            // Stage 3, the player is losing so much energy that slowness and mining fatigue take place.
            int stageThreeAmplifier = (int) MDXMath.map(age, gestationPeriod * (1 - stageThreePercentage), gestationPeriod, 1, 4);
            if (ticksUntilBirth < gestationPeriod * stageThreePercentage) {
                host.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, gestationPeriod, stageThreeAmplifier));
                host.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, gestationPeriod, stageThreeAmplifier));
            }

            // Stage 4, the player's bodily organs are so heavily damaged that nausea and blindness set in. Death is imminent.
            int stageFourAmplifier = (int) MDXMath.map(age, gestationPeriod * (1 - stageFourPercentage), gestationPeriod, 1, 4);
            if (ticksUntilBirth < gestationPeriod * stageFourPercentage) {
                host.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, gestationPeriod, stageFourAmplifier));
                host.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, gestationPeriod, stageFourAmplifier));
            }

            if (currentStage == 1 && world.getTotalWorldTime() % 20 == 0) {
                world.playSound(null, host.getPosition(), AlienSounds.HEARTBEAT_NORMAL.event(), SoundCategory.HOSTILE, 0.5F, 1F);
            }
            else if (currentStage == 2 && world.getTotalWorldTime() % 15 == 0) {
                world.playSound(null, host.getPosition(), AlienSounds.HEARTBEAT_ELEVATED.event(), SoundCategory.HOSTILE, 1F, 1F);
            }
            else if (currentStage == 3 && world.getTotalWorldTime() % 10 == 0) {
                world.playSound(null, host.getPosition(), AlienSounds.HEARTBEAT_RAPID.event(), SoundCategory.HOSTILE, 1.5F, 1F);
            }
            else if (currentStage >= 4 && world.getTotalWorldTime() % 8 == 0) {
                world.playSound(null, host.getPosition(), AlienSounds.HEARTBEAT_FATAL.event(), SoundCategory.HOSTILE, 2F, 1F);
            }

            // Congratulations, it's the birth of a billion dollar franchise!
            if (ticksUntilBirth <= 0) {
                organism.getEmbryo().vitalize(host);
            }
        }
    }
    
    public boolean canTickHost(Entity entity) {
    	// If the entity is in an invalid state
    	if (entity == null || entity.isDead || entity.world == null || !(entity instanceof EntityLivingBase))
    		return false;
        
        OrganismImpl organism = (OrganismImpl) entity.getCapability(Provider.CAPABILITY, null);
        
        // If the organism does not have an embryo
        if (organism != null && !organism.hasEmbryo())
        	return false;

        // Ignore creative players.
        return !(entity instanceof EntityPlayer) || !((EntityPlayer) entity).isCreative();
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
