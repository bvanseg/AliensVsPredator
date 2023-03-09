package org.avp.world;

import org.avp.Settings.ClientSettings;
import org.avp.entities.living.species.SpeciesYautja;
import org.avp.entities.living.species.species223ode.EntityTrilobite;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.asx.mdx.config.GraphicsSetting;
import com.asx.mdx.lib.client.entityfx.EntityBloodFX;
import com.asx.mdx.lib.util.Game;

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
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityImpregnationHandler
{
    public static final EntityImpregnationHandler instance          = new EntityImpregnationHandler();

    private static float                          rotationYawLock   = 0F;
    private static float                          rotationPitchLock = 0F;
    private static boolean                        rotationLocked    = false;

    private EntityImpregnationHandler() {}
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void handlePlayerInput(InputUpdateEvent event)
    {
        if (Game.minecraft().player != null && Game.minecraft().player.getPassengers() != null && Game.minecraft().player.getPassengers().size() >= 1 && Game.minecraft().player.getPassengers().get(0) instanceof EntityTrilobite)
        {
            EntityTrilobite trilobite = (EntityTrilobite) Game.minecraft().player.getPassengers().get(0);

            if (!rotationLocked)
            {
                rotationYawLock = Game.minecraft().player.rotationYaw;
                rotationPitchLock = Game.minecraft().player.rotationPitch;
                Game.minecraft().player.moveRelative(0F, 0F, 2F, 1.0F);
                rotationLocked = true;
            }

            trilobite.rotationYawHead = rotationYawLock;
            trilobite.rotationYaw = rotationYawLock;
            trilobite.prevRotationYawHead = rotationYawLock;
            trilobite.prevRotationYaw = rotationYawLock;
            Game.minecraft().player.rotationPitch = -10F;
            Game.minecraft().player.rotationYaw = rotationYawLock;
            Game.minecraft().player.rotationYawHead = rotationYawLock;
            Game.minecraft().player.moveStrafing = 0F;
            event.getMovementInput().jump = false;
            event.getMovementInput().moveForward = event.getMovementInput().moveForward - event.getMovementInput().moveForward;
            event.getMovementInput().moveStrafe = event.getMovementInput().moveStrafe - event.getMovementInput().moveStrafe;
        }
        else
        {
            rotationLocked = false;
        }
    }

    @SubscribeEvent
    public void tick(LivingUpdateEvent event)
    {
    	Entity entity =  event.getEntity();
    	
    	// If the entity is in an invalid state, return.
    	if (entity == null || entity.isDead || entity.world == null || !(entity instanceof EntityLivingBase))
    		return;
    	
        World world = event.getEntity().getEntityWorld();
        
        // If the entity has not spawned in a world yet, return.
        if (world == null)
        	return;
        
        EntityLivingBase host = (EntityLivingBase) entity;
        Organism organism = (Organism) host.getCapability(Provider.CAPABILITY, null);
        
        // If the organism does not have an embryo, return.
        if (!organism.hasEmbryo())
        	return;

        // Handle player host.
        if (host instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer) host;
    		
    		if (player.isCreative())
    			return;
    		
    		tickPlayerHost(world, player, organism);
        }

        organism.onTick(host, organism);

        // TODO: Both branches below this comment need to be rewritten, remote checks should be done first.
        // Worth noting that both branches execute on both players and non-players.

    	System.out.println("AGE: " + organism.getEmbryo().getAge() + ", TRIGGER: " + organism.getEmbryo().getGestationPeriod());
        if (organism.getEmbryo().getAge() >= organism.getEmbryo().getGestationPeriod())
        {
            if (!world.isRemote && organism.getEmbryo().getNascenticOrganism() != null)
            {
                organism.getEmbryo().getNascenticOrganism().vitalize(host);
            }
        }

        if (organism.getEmbryo().getAge() > 0)
        {
        	int age = organism.getEmbryo().getAge();
            int gestationPeriod = organism.getEmbryo().getGestationPeriod();
            int timeBlind = gestationPeriod - (gestationPeriod / 2);

            if (!world.isRemote)
            {
            	if (age >= timeBlind) {
                    host.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, organism.getEmbryo().getGestationPeriod() / 2));
            	}
            }
            else {
                int timeLeft = gestationPeriod - age;
                int timeBleed = gestationPeriod - (gestationPeriod / 10);
                spawnBloodParticles(host, age, timeLeft, timeBleed);
            }
        }
    }

	private void tickPlayerHost(World world, EntityPlayer player, Organism organism) {
		
		// FIXME: Organism gestates server-side but not client-side when game is paused!
		if (!world.isRemote)
		{
		    organism.gestate(player);
		    
		    if (organism.getEmbryo().getAge() > 0) {
		        player.clearActivePotions();
		    }
		}
		else
		{
		    if (!Game.minecraft().isGamePaused())
		    {
		        organism.gestate(player);
		    }
		}
	}

    @SideOnly(Side.CLIENT)
	private void spawnBloodParticles(EntityLivingBase host, int age, int timeLeft, int timeBleed) {
		GraphicsSetting bloodDetails = ClientSettings.instance.bloodDetails().value();
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
        if (host == null || !ClientSettings.instance.bloodFX().value())
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
        
        GraphicsSetting bloodDetails = ClientSettings.instance.bloodDetails().value();
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

        Game.minecraft().effectRenderer.addEffect(new EntityBloodFX(host.world, pX, pY, pZ, particleColor, maxAge, glow));
    }

    @SubscribeEvent
    public void respawnEvent(PlayerRespawnEvent event)
    {
        EntityLivingBase living = event.player;
        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);

        if (organism.hasEmbryo())
        {
            organism.removeEmbryo();
        }
    }

    @SubscribeEvent
    public void despawnEvent(LivingSpawnEvent.AllowDespawn event)
    {
        EntityLivingBase living = event.getEntityLiving();
        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);

        if (organism.hasEmbryo())
        {
            event.setResult(Result.DENY);
        }
    }
}
