package org.avp.common;


import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import com.asx.mdx.client.render.model.texture.Texture;
import com.asx.mdx.common.minecraft.entity.player.Players;
import com.asx.mdx.common.mods.IInitEvent;
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
import org.avp.client.Resources;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;
import org.avp.common.world.playermode.LevelData;
import org.avp.common.world.playermode.PlayerMode;

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

        PlayerMode.NORMAL.getLevelMappingForLevel(0).setModelTexMap(Resources.instance.models().BIPED);
        PlayerMode.MARINE.getLevelMappingForLevel(0).setModelTexMap(Resources.instance.models().MARINE);
        PlayerMode.PREDATOR.getLevelMappingForLevel(0).setModelTexMap(Resources.instance.models().YAUTJA_WARRIOR);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(0).setModelTexMap(Resources.instance.models().OVAMORPH);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(1).setModelTexMap(Resources.instance.models().FACEHUGGER);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(10).setModelTexMap(Resources.instance.models().CHESTBUSTER);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(20).setModelTexMap(Resources.instance.models().DRONE_ADVANCED_BLOOD);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(45).setModelTexMap(Resources.instance.models().WARRIOR_BLOOD);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(65).setModelTexMap(Resources.instance.models().PRAETORIAN);
        PlayerMode.XENOMORPH.getLevelMappingForLevel(90).setModelTexMap(Resources.instance.models().MATRIARCH);
    }

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
    {
        if (event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);

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
        return PlayerModeHandler.instance;
    }

    public static boolean isPlayerInMode(EntityPlayer player, PlayerMode playerMode)
    {
        SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);
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
        SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);
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
