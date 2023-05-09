package org.alien.common.world;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.math.MDXMath;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

/**
 * @author Boston Vanseghi
 */
public class ClientEntityImpregnationHandler extends EntityImpregnationHandler
{
    public static final ClientEntityImpregnationHandler instance = new ClientEntityImpregnationHandler();

    private ClientEntityImpregnationHandler() {}

    @Override
    @SubscribeEvent
    public void tick(LivingUpdateEvent event)
    {
    	Entity entity =  event.getEntity();
        World world = entity.getEntityWorld();
        EntityLivingBase host = (EntityLivingBase) entity;
        OrganismImpl organism = (OrganismImpl) host.getCapability(Provider.CAPABILITY, null);

        if (organism == null || !organism.hasEmbryo()) return;
        if (!world.isRemote) return;

        if (!ClientGame.instance.minecraft().isGamePaused()) {
            organism.getEmbryo().grow();
        }

        // Play heartbeat sounds only for the client players.
        if (host == ClientGame.instance.minecraft().player) {
            int age = organism.getEmbryo().getAge();
            int gestationPeriod = organism.getEmbryo().getEntry().getGestationPeriod();
            int currentStage = (int) MDXMath.map(age, gestationPeriod * (1 - STAGE_ONE_PERCENTAGE), gestationPeriod * (1 - STAGE_FOUR_PERCENTAGE), 1, 4);
            this.playHeartbeatSound(world, host, currentStage);
        }
    }

    private void playHeartbeatSound(World world, EntityLivingBase host, int currentStage) {
        EntityPlayerSP player = ClientGame.instance.minecraft().player;
        if (currentStage == 1 && world.getTotalWorldTime() % 20 == 0) {
            world.playSound(player, host.getPosition(), AlienSounds.HEARTBEAT_NORMAL.event(), SoundCategory.HOSTILE, 0.5F, 1F);
        }
        else if (currentStage == 2 && world.getTotalWorldTime() % 15 == 0) {
            world.playSound(player, host.getPosition(), AlienSounds.HEARTBEAT_ELEVATED.event(), SoundCategory.HOSTILE, 1F, 1F);
        }
        else if (currentStage == 3 && world.getTotalWorldTime() % 10 == 0) {
            world.playSound(player, host.getPosition(), AlienSounds.HEARTBEAT_RAPID.event(), SoundCategory.HOSTILE, 1.5F, 1F);
        }
        else if (currentStage >= 4 && world.getTotalWorldTime() % 8 == 0) {
            world.playSound(player, host.getPosition(), AlienSounds.HEARTBEAT_FATAL.event(), SoundCategory.HOSTILE, 2F, 1F);
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
