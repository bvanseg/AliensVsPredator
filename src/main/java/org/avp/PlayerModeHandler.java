package org.avp;


import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.avp.world.playermode.LevelData;
import org.avp.world.playermode.PlayerMode;

import com.arisux.mdx.lib.client.util.Texture;
import com.arisux.mdx.lib.client.util.models.MapModelTexture;
import com.arisux.mdx.lib.client.util.models.Model;
import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.world.entity.player.Players;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerModeHandler implements IInitEvent
{
    public static final PlayerModeHandler instance = new PlayerModeHandler();

    @Override
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            this.assignLevelModelMaps();
        }
    }

    @SideOnly(Side.CLIENT)
    public void assignLevelModelMaps()
    {
        ModelBiped modelBiped = new ModelBiped();
        modelBiped.isChild = false;

        PlayerMode.NORMAL.getLevelMappingForLevel(0).setModelTexMap(AliensVsPredator.resources().models().BIPED);
        PlayerMode.MARINE.getLevelMappingForLevel(0).setModelTexMap(AliensVsPredator.resources().models().MARINE);
        PlayerMode.PREDATOR.getLevelMappingForLevel(0).setModelTexMap(AliensVsPredator.resources().models().YAUTJA_WARRIOR);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(0).setModelTexMap(AliensVsPredator.resources().models().OVAMORPH);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(1).setModelTexMap(AliensVsPredator.resources().models().FACEHUGGER);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(10).setModelTexMap(AliensVsPredator.resources().models().CHESTBUSTER);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(20).setModelTexMap(AliensVsPredator.resources().models().DRONE_ADVANCED_BLOOD);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(45).setModelTexMap(AliensVsPredator.resources().models().WARRIOR_BLOOD);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(65).setModelTexMap(AliensVsPredator.resources().models().PRAETORIAN);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(90).setModelTexMap(AliensVsPredator.resources().models().MATRIARCH);
    }

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
    {
        if (event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            SpecialPlayer specialPlayer = (SpecialPlayer) player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

            specialPlayer.setPlayerMode(PlayerMode.NORMAL);
            {
                // Query the player to choose their PlayerMode type.
            }
        }
    }

    @SubscribeEvent
    public void onPlayerPickupXP(PlayerPickupXpEvent event)
    {
        EntityPlayer player = event.getEntityPlayer();

        if (Players.getXPCurrentLevel(player) + event.getOrb().getXpValue() >= Players.getXPCurrentLevelMax(player))
        {
            this.onPlayerLevelUp(player, (int) Players.getXPLevel(player) + 1);
        }
    }

    public void onPlayerLevelUp(EntityPlayer player, int newLevel)
    {
        ;
    }

    public static final PlayerModeHandler instance()
    {
        return AliensVsPredator.playermodehandler();
    }

    public static boolean isPlayerInMode(EntityPlayer player, PlayerMode playerMode)
    {
        SpecialPlayer specialPlayer = (SpecialPlayer) player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);
        return specialPlayer.getPlayerMode() == playerMode;
    }

    public static boolean isNormal(EntityPlayer player)
    {
        return isPlayerInMode(player, PlayerMode.NORMAL);
    }

    public static boolean isMarine(EntityPlayer player)
    {
        return isPlayerInMode(player, PlayerMode.MARINE);
    }

    public static boolean isPredator(EntityPlayer player)
    {
        return isPlayerInMode(player, PlayerMode.PREDATOR);
    }

    public static boolean isXenomorph(EntityPlayer player)
    {
        return isPlayerInMode(player, PlayerMode.XENOMORPH);
    }

    public PlayerMode getPlayerModeForPlayer(EntityPlayer player)
    {
        SpecialPlayer specialPlayer = (SpecialPlayer) player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);
        return specialPlayer.getPlayerMode();
    }

    public LevelData getLevelMappingForPlayer(EntityPlayer player)
    {
        return getPlayerModeForPlayer(player).getLevelMappingForLevel((int) Players.getXPLevel(player));
    }

    @SideOnly(Side.CLIENT)
    public MapModelTexture<? extends Model> getModelTexMapForPlayer(EntityPlayer player)
    {
        return getLevelMappingForPlayer(player).getModelTexMap();
    }

    @SideOnly(Side.CLIENT)
    public Model getModelForPlayer(EntityPlayer player)
    {
        return getModelTexMapForPlayer(player).getModel();
    }

    @SideOnly(Side.CLIENT)
    public Texture getTextureForPlayer(EntityPlayer player)
    {
        return getModelTexMapForPlayer(player).getTexture();
    }
}
