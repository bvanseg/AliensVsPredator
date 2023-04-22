package org.alien.common.world;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.io.config.GraphicsSetting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.common.config.ModelConfig;
import org.predator.common.entity.living.SpeciesYautja;

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

        // If the host can't be ticked, remove its embryo and return.
        if (!this.canTickHost(entity)) {
            if (organism != null && organism.hasEmbryo()) {
                organism.setEmbryo(null);
            }
            return;
        }

        organism.onTick(host, organism);
        
    	int age = organism.getEmbryo().getAge();
        int gestationPeriod = organism.getEmbryo().getGestationPeriod();
        int timeBlind = gestationPeriod - (gestationPeriod / 2);
        
 		if (!world.isRemote)
 		{
             organism.getEmbryo().grow();
 		    
 		    // TODO: This clears potion effects the host has every tick, not sure if this is correct.
 		    if (organism.getEmbryo().getAge() > 0) {
 		        host.clearActivePotions();
 		    }
 		    
        	if (age >= timeBlind && host.getActivePotionEffect(MobEffects.BLINDNESS) == null) {
                host.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, organism.getEmbryo().getGestationPeriod() / 2));
        	}
 		    
 		    boolean isEmbryoReadyToLive = organism.getEmbryo().getAge() >= organism.getEmbryo().getGestationPeriod();

 		    if (isEmbryoReadyToLive) {
                organism.getEmbryo().vitalize(host);
 		    }
 		}
 		else // client world.
 		{
 	        // FIXME: Organism gestates server-side but not client-side when game is paused!
 		    if (!ClientGame.instance.minecraft().isGamePaused())
 		    {
                 organism.getEmbryo().grow();
 		    }

			// FIXME: This currently runs every tick, but does nothing.
			if (organism.hasEmbryo() && organism.getEmbryo().getAge() > 0)
			{
				int timeLeft = gestationPeriod - age;
				int timeBleed = gestationPeriod - (gestationPeriod / 10);
				spawnBloodParticles(host, age, timeLeft, timeBleed);
			}
 		}
    }
    
    public boolean canTickHost(Entity entity) {
    	// If the entity is in an invalid state
    	if (entity == null || entity.isDead || entity.world == null || !(entity instanceof EntityLivingBase))
    		return false;
        
        OrganismImpl organism = (OrganismImpl) entity.getCapability(Provider.CAPABILITY, null);
        
        // If the organism does not have an embryo
        if (!organism.hasEmbryo())
        	return false;

        // Ignore creative players.
        if (entity instanceof EntityPlayer && ((EntityPlayer) entity).isCreative()) {
			return false;
        }
        
        return true;
    }

    @SideOnly(Side.CLIENT)
	private void spawnBloodParticles(EntityLivingBase host, int age, int timeLeft, int timeBleed) {
		GraphicsSetting bloodDetails = ModelConfig.getInstance().getGraphics().bloodDetails;
		// TODO: Not safe to use ordinals like this.
		int particleCount = bloodDetails.ordinal() < 2 ? 32 : 0 + 32 * (int)Math.pow(2, bloodDetails.ordinal());

		if (timeLeft <= 3)
		{
		    for (int i = particleCount; i > 0; i--)
		    {
		        this.bleed(host, 0.5F);
		    }
		}

		if (age >= timeBleed && bloodDetails.ordinal() > 2)
		{
		    this.bleed(host, 0.25F);

		    if (host.getRNG().nextInt(100) == 0 && bloodDetails.ordinal() > 3)
		    {
		        for (int i = 32; i > 0; i--)
		        {
		            this.bleed(host, 0.5F);
		        }
		    }
		}
	}

    @SideOnly(Side.CLIENT)
    private void bleed(EntityLivingBase host, float spread)
    {
        if (host == null || !ModelConfig.getInstance().getGraphics().bloodEffects)
        {
            return;
        }

        double pX = host.posX + (host.getRNG().nextDouble() * spread) - (host.getRNG().nextDouble() * spread);
        double pY = host.posY + (host.getRNG().nextDouble() * spread) - (host.getRNG().nextDouble() * spread);
        double pZ = host.posZ + (host.getRNG().nextDouble() * spread) - (host.getRNG().nextDouble() * spread);

        int particleColor = 0x610000;
        boolean glow = false;

        if (host instanceof SpeciesYautja)
        {
            particleColor = 0x00FF00;
            glow = true;
        }

        if (host instanceof EntitySquid || host instanceof EntitySpider)
        {
            particleColor = 0x0000FF;
        }

        if (host instanceof EntityCreeper)
        {
            particleColor = 0x75974B;
        }

        if (host instanceof EntityGhast)
        {
            particleColor = 0xF0F0F0;
        }

        if (host instanceof EntityMooshroom)
        {
            particleColor = 0xCD8C6F;
        }

        if (host instanceof EntityEnderman)
        {
            particleColor = 0xCC00FA;
            glow = true;
        }

        if (host instanceof EntityDragon)
        {
            particleColor = 0xA831FF;
            glow = true;
        }
        
        GraphicsSetting bloodDetails = ModelConfig.getInstance().getGraphics().bloodDetails;
        int maxAge = 0;
        
        switch(bloodDetails)
        {
        	case LOW:
        		maxAge = 60; // 3 seconds
        		break;
        	case MEDIUM:
        		maxAge = 30 * 20; // 30 seconds
        		break;
        	case HIGH:
        		maxAge = (30 * 20) * 2; // 60 seconds
        		break;
        	case ULTRA:
        		maxAge = (60 * 20) * 2; // 120 seconds
        		break;
        }

        //ClientGame.instance.minecraft().effectRenderer.addEffect(new EntityBloodFX(host.world, pX, pY, pZ, particleColor, maxAge, glow));
    }

    @SubscribeEvent
    public void respawnEvent(PlayerRespawnEvent event)
    {
        OrganismImpl organism = (OrganismImpl) event.player.getCapability(Provider.CAPABILITY, null);
        organism.setEmbryo(null);
    }

    @SubscribeEvent
    public void despawnEvent(LivingSpawnEvent.AllowDespawn event)
    {
        OrganismImpl organism = (OrganismImpl) event.getEntityLiving().getCapability(Provider.CAPABILITY, null);

        if (organism.hasEmbryo())
        {
            event.setResult(Result.DENY);
        }
    }
}
