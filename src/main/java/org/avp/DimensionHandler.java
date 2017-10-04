package org.avp;

import org.avp.world.dimension.TeleporterLV;
import org.avp.world.dimension.acheron.BiomeAcheron;
import org.avp.world.dimension.acheron.WorldProviderAcheron;
import org.avp.world.dimension.varda.BiomeVarda;
import org.avp.world.dimension.varda.WorldProviderVarda;

import com.arisux.mdx.MDX;
import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.world.Dimension;
import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.entity.Entities;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DimensionHandler implements IInitEvent
{
    public static final DimensionHandler instance = new DimensionHandler();

    public final Dimension               ACHERON  = new Dimension("Acheron", "_acheron", WorldProviderAcheron.class, true)
                                                  {
                                                      public Dimension register()
                                                      {
                                                          GameRegistry.register(BiomeAcheron.acheron, new ResourceLocation(AliensVsPredator.Properties.ID, "acheron"));
                                                          return super.register();
                                                      };
                                                  };
    public final Dimension               VARDA    = new Dimension("Varda", "_varda", WorldProviderVarda.class, true)
                                                  {
                                                      public Dimension register()
                                                      {
                                                          GameRegistry.register(BiomeVarda.vardaBadlands, new ResourceLocation(AliensVsPredator.Properties.ID, "vardabadlands"));
                                                          GameRegistry.register(BiomeVarda.vardaForest, new ResourceLocation(AliensVsPredator.Properties.ID, "vardaforest"));
                                                          
                                                          return super.register();
                                                      };
                                                  };

    public boolean                       initialized;

    public final String            DIMENSION_NAME_ACHERON    = "LV-426 (Acheron)";

    public final String            DIMENSION_ID_ACHERON      = "DIM_LV426";

    public final String            DIMENSION_NAME_VARDA      = "LV-223 (Varda)";

    public final String            DIMENSION_ID_VARDA        = "DIM_LV223";

    public final String            BIOME_NAME_VARDA_BADLANDS = "LV-223.B.1 (Varda Badlands)";

    public final String            BIOME_NAME_VARDA_FOREST   = "LV-223.B.2 (Anomalistic Forest)";

    @Override
    public void init(FMLInitializationEvent event)
    {
        ACHERON.register();
        VARDA.register();
    }

    @SideOnly(Side.SERVER)
    @SubscribeEvent
    public void onServerTick(ServerTickEvent event)
    {
        if (FMLCommonHandler.instance() != null && FMLCommonHandler.instance().getMinecraftServerInstance() != null && !this.initialized)
        {
            tryLoadDimension(VARDA.getId());
            tryLoadDimension(ACHERON.getId());

            this.initialized = true;
        }
    }

    public void initialWorldChunkLoad(WorldServer worldServerObj)
    {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        long startTime = System.currentTimeMillis();
        short chunkRadius = 196;

        for (int chunkX = -chunkRadius; (chunkX <= chunkRadius) && (server.isServerRunning()); chunkX += 16)
        {
            for (int chunkZ = -chunkRadius; (chunkZ <= chunkRadius) && (server.isServerRunning()); chunkZ += 16)
            {
                long curTime = System.currentTimeMillis();

                if (curTime < startTime)
                {
                    startTime = curTime;
                }

                if (curTime > startTime + 1000L)
                {
                    startTime = curTime;
                }

                worldServerObj.getChunkProvider().loadChunk(worldServerObj.getSpawnPoint().getX() + chunkX >> 4, worldServerObj.getSpawnPoint().getZ() + chunkZ >> 4);
            }
        }
    }

    public static void teleportPlayerToDimension(EntityPlayerMP player, int dimensionId)
    {
        PlayerList players = player.getServer().getPlayerList();
        MDX.log().info("Attempting to teleport player to dimension with id " + dimensionId);

        if (player.dimension == 0 || player.dimension != dimensionId)
        {
            WorldServer worldServer = player.getServer().worldServerForDimension(dimensionId);
            Teleporter teleporter = new TeleporterLV(worldServer);
            players.transferPlayerToDimension(player, dimensionId, teleporter);

            Pos safePos = Entities.getSafePositionAboveBelow(new Pos(player.posX, player.posY, player.posZ), worldServer);

            if (safePos == null)
            {
                player.setLocationAndAngles(worldServer.getSpawnPoint().getX(), worldServer.getSpawnPoint().getY(), worldServer.getSpawnPoint().getZ(), player.rotationYaw, player.rotationPitch);
            }
            else
            {
                player.setLocationAndAngles(safePos.x, safePos.y, safePos.z, player.rotationYaw, player.rotationPitch);
            }
        }
        else if (player.dimension == dimensionId)
        {
            WorldServer worldServer = player.getServer().worldServerForDimension(0);
            Teleporter teleporter = new TeleporterLV(worldServer);
            players.transferPlayerToDimension(player, 0, teleporter);

            Pos safePos = Entities.getSafePositionAboveBelow(new Pos(player.posX, player.posY, player.posZ), worldServer);

            if (safePos == null)
            {
                player.setLocationAndAngles(worldServer.getSpawnPoint().getX(), worldServer.getSpawnPoint().getY(), worldServer.getSpawnPoint().getZ(), player.rotationYaw, player.rotationPitch);
            }
            else
            {
                player.setLocationAndAngles(safePos.x, safePos.y, safePos.z, player.rotationYaw, player.rotationPitch);
            }
        }
        else
        {
            WorldServer worldServer = player.getServer().worldServerForDimension(dimensionId);
            Teleporter teleporter = new TeleporterLV(player.getServer().worldServerForDimension(dimensionId));
            players.transferPlayerToDimension(player, dimensionId, teleporter);

            Pos safePos = Entities.getSafePositionAboveBelow(new Pos(player.posX, player.posY, player.posZ), worldServer);

            if (safePos == null)
            {
                player.setLocationAndAngles(worldServer.getSpawnPoint().getX(), worldServer.getSpawnPoint().getY(), worldServer.getSpawnPoint().getZ(), player.rotationYaw, player.rotationPitch);
            }
            else
            {
                player.setLocationAndAngles(safePos.x, safePos.y, safePos.z, player.rotationYaw, player.rotationPitch);
            }
        }
    }

    public void tryLoadDimension(int dimensionId)
    {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        WorldServer worldServer = server.worldServerForDimension(dimensionId);

        if (worldServer != null && worldServer instanceof WorldServer)
        {
            server.logInfo("Preparing start region for level " + worldServer.provider.getDimensionType().getName());
            initialWorldChunkLoad(worldServer);
        }
    }
}
