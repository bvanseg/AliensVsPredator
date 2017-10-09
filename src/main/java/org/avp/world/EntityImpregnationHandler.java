package org.avp.world;

import org.avp.Settings.ClientSettings;
import org.avp.client.entityfx.EntityBloodFX;
import org.avp.entities.living.EntitySpeciesYautja;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.arisux.mdx.lib.game.Game;

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
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityImpregnationHandler
{
    public static final EntityImpregnationHandler instance = new EntityImpregnationHandler();

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event)
    {
        this.tick(Game.minecraft().world);
    }

    @SubscribeEvent
    public void tick(TickEvent.WorldTickEvent event)
    {
        this.tick(event.world);
    }

    public void tick(World world)
    {
        if (world != null)
        {
            for (int x = 0; x < world.loadedEntityList.size(); ++x)
            {
                Entity entity = (Entity) world.loadedEntityList.get(x);

                if (entity != null && entity instanceof EntityLivingBase)
                {
                    EntityLivingBase host = (EntityLivingBase) entity;
                    Organism organism = (Organism) host.getCapability(Provider.CAPABILITY, null);
                    EntityPlayer player = null;

                    if (host instanceof EntityPlayer)
                    {
                        player = (EntityPlayer) host;
                    }

                    organism.onTick(host, organism);

                    if (host.isEntityAlive() && organism.hasEmbryo())
                    {

                        if (player != null && !player.capabilities.isCreativeMode || player == null)
                        {
                            if (!world.isRemote)
                            {
                                organism.gestate(host);
                            }
                            else if (world.isRemote)
                            {
                                if (!Game.minecraft().isGamePaused())
                                {
                                    organism.gestate(host);
                                }
                            }
                        }

                        if (organism.getEmbryo().getAge() >= organism.getEmbryo().getGestationPeriod())
                        {
                            if (organism.getEmbryo().getNascenticOrganism() != null)
                            {
                                if (!world.isRemote)
                                {
                                    organism.getEmbryo().getNascenticOrganism().vitalize(host);
                                }
                            }
                        }

                        if (organism.hasEmbryo() && organism.getEmbryo().getAge() > 0)
                        {
                            if (player == null || player != null && !player.capabilities.isCreativeMode)
                            {
                                int age = organism.getEmbryo().getAge();
                                int gestationPeriod = organism.getEmbryo().getGestationPeriod();
                                int timeLeft = gestationPeriod - age;
                                int timeBlind = gestationPeriod - (gestationPeriod / 2);
                                int timeBleed = gestationPeriod - (gestationPeriod / 10);

                                if (age >= timeBlind)
                                {
                                    if (!world.isRemote)
                                    {
                                        host.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, organism.getEmbryo().getGestationPeriod() / 2));
                                    }
                                }

                                if (world.isRemote && timeLeft <= 3)
                                {
                                    for (int i = 256; i > 0; i--)
                                    {
                                        this.bleed(host, 0.5F);
                                    }
                                }

                                if (world.isRemote && age >= timeBleed)
                                {
                                    this.bleed(host, 0.25F);
                                    
                                    if (host.getRNG().nextInt(100) == 0)
                                    {
                                        for (int i = 32; i > 0; i--)
                                        {
                                            this.bleed(host, 0.5F);
                                        }
                                    }
                                }
                            }

                            if (player != null && player.capabilities.isCreativeMode)
                            {
                                if (!world.isRemote)
                                {
                                    player.clearActivePotions();
                                }
                            }
                        }
                    }
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

        if (host instanceof EntitySpeciesYautja)
        {
            particleColor = 0x00FF00;
            glow = true;
        }

        if (host instanceof EntitySquid || host instanceof EntitySpider)
        {
            particleColor = 0x0000FF;
            glow = false;
        }

        if (host instanceof EntityCreeper)
        {
            particleColor = 0x507d2a;
            glow = false;
        }
        
        if (host instanceof EntityGhast)
        {
            particleColor = 0xF0F0F0;
            glow = false;
        }
        
        if (host instanceof EntityMooshroom)
        {
            particleColor = 0xCD8C6F;
            glow = false;
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
        
        Game.minecraft().effectRenderer.addEffect(new EntityBloodFX(host.world, pX, pY, pZ, particleColor, glow));
    }

    @SubscribeEvent
    public void respawnEvent(PlayerRespawnEvent event)
    {
        EntityLivingBase living = (EntityLivingBase) event.player;
        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);

        if (organism.hasEmbryo())
        {
            organism.removeEmbryo();
        }
    }

    @SubscribeEvent
    public void despawnEvent(LivingSpawnEvent.AllowDespawn event)
    {
        EntityLivingBase living = (EntityLivingBase) event.getEntityLiving();
        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);

        if (organism.hasEmbryo())
        {
            event.setResult(Result.DENY);
        }
    }
}
