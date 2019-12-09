package org.avp.world.hives;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.avp.api.storage.IWorldSaveHandler;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.tile.TileEntityHiveResin;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Worlds;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HiveHandler implements IWorldSaveHandler
{
    public static final HiveHandler  instance = new HiveHandler();
    private HashMap<UUID, XenomorphHive> hives    = null;
    public ArrayList<Pos>            burntResin;

    public HiveHandler()
    {
        this.hives = new HashMap<UUID, XenomorphHive>();
        this.burntResin = new ArrayList<Pos>();
    }

    public XenomorphHive createHive(EntityMatriarch queen)
    {
        XenomorphHive hive = new XenomorphHive(queen.world, queen.getUniqueID()).setLocation(queen.posX, queen.posY, queen.posZ);
        HiveHandler.instance.hives.put(hive.getUniqueIdentifier(), hive);
        return hive;
    }
    
    public HashMap<UUID, XenomorphHive> getHiveMap()
    {
        return hives;
    }

    public List<XenomorphHive> getHives()
    {
        return hives.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    /**
     * Fetches the hive for the given {@link SpeciesAlien}. May return null if the alien has no hive.
     * 
     * @param alien The alien to get a {@link XenomorphHive} for.
     * @return The hive of the alien, or null if it has no hive at all.
     */
    public XenomorphHive getHiveForAlien(SpeciesAlien alien)
    {
        XenomorphHive hive = alien.getHive();
        
        // Safety check to make sure the hive also exists within the map, as well.
        if (hive != null && hive.getAlienMap().containsKey(hive.getUniqueIdentifier()))
            return hive;
        
        return null;
    }

    public XenomorphHive getHiveForUUID(UUID uuid)
    {
        for (XenomorphHive hive : this.getHives())
        {
            if (hive != null && hive.getUniqueIdentifier() != null && hive.getUniqueIdentifier().equals(uuid))
            {
                return hive;
            }
        }

        return null;
    }

    public static boolean breakResinAt(World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityHiveResin)
        {
            TileEntityHiveResin resin = (TileEntityHiveResin) tile;

            if (resin != null && resin.getParentBlock() != null)
            {
                world.setBlockState(pos, resin.getParentBlock().getDefaultState(), 3);

                return true;
            }
        }

        return false;
    }

    @SubscribeEvent
    public void breakResin(BlockEvent.BreakEvent event)
    {
        if (breakResinAt(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ()))
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void removeSlimes(EntityJoinWorldEvent event)
    {
        // Murder annoying slimes if this is a dev environment.
        if (Game.isDevEnvironment())
            if (event.getEntity() instanceof EntitySlime)
                event.setCanceled(true);
    }

    @SubscribeEvent
    public void updateHives(TickEvent.WorldTickEvent event)
    {
        for (Pos coord : new ArrayList<Pos>(this.burntResin))
        {
            event.world.setBlockState(coord.blockPos(), Blocks.AIR.getDefaultState(), 3);
            this.burntResin.remove(coord);
        }

        Iterator<XenomorphHive> iter = this.getHives().iterator();

        while (iter.hasNext())
        {
            XenomorphHive hive = iter.next();
            if (hive != null && hive.getDimensionId() == event.world.provider.getDimension())
                hive.update(event.world);
        }
    }

    public void clearCaches()
    {
        System.out.println("Cleared hive cache.");
        this.hives.clear();
    }

    @Override
    public boolean saveData(World world, NBTTagCompound nbt)
    {
        int hiveCount = 0;

        if (nbt != null)
        {
            if (this.hives != null && !this.hives.isEmpty())
            {
                NBTTagList tagHives = new NBTTagList();

                for (XenomorphHive hive : this.getHives())
                {
                    if (hive.getDimensionId() == world.provider.getDimension())
                    {
                        MDX.log().info(String.format("Saving Hive(%s) at %s, %s, %s", hive.getUniqueIdentifier(), hive.xCoord(), hive.yCoord(), hive.zCoord()));
                        hiveCount++;
                        NBTTagCompound tagHive = new NBTTagCompound();
                        hive.save(world, tagHive);
                        tagHives.appendTag(tagHive);
                    }
                }

                nbt.setTag("XenomorphHives", tagHives);
            }
        }
        else
        {
            return false;
        }

        if (hiveCount > 0)
        {
            MDX.log().info(String.format("Saved %s hives for level '%s'/%s", hiveCount, world.getSaveHandler().getWorldDirectory(), world.provider.getDimensionType().getName()));
        }

        return true;
    }

    @Override
    public boolean loadData(World world, NBTTagCompound nbt)
    {
        int hiveCount = 0;

        if (nbt != null)
        {
            NBTTagList tagHives = nbt.getTagList("XenomorphHives", NBT.TAG_COMPOUND);

            if ((tagHives.tagCount()) > 0)
            {
                for (int idx = tagHives.tagCount() - 1; idx >= 0; idx--)
                {
                    NBTTagCompound tagHive = tagHives.getCompoundTagAt(idx);
                    UUID uuid = Worlds.uuidFromNBT(tagHive, "UUID");
                    XenomorphHive hive = this.getHiveForUUID(uuid);

                    if (hive == null && uuid != null)
                    {
                        hive = new XenomorphHive(world, uuid);

                        if (!this.hives.containsKey(hive.getUniqueIdentifier()))
                        {
                            this.hives.put(hive.getUniqueIdentifier(), hive);
                        }
                    }

                    if (hive == null || uuid == null)
                    {
                        MDX.log().warn(String.format("Failed to load a hive, Debug Information: UUID(%s), Instance(%s)", uuid, hive));
                    }

                    if (hive != null)
                    {
                        hiveCount++;
                        hive.load(world, uuid, tagHive);
                        MDX.log().info(String.format("Loaded Hive(%s) at %s, %s, %s", hive.getUniqueIdentifier(), hive.xCoord(), hive.yCoord(), hive.zCoord()));
                    }
                }
            }
        }
        else
        {
            return false;
        }

        MDX.log().info(String.format("%s hives have been loaded for level '%s'/%s. %s hives are globally accessable.", hiveCount, world.getSaveHandler().getWorldDirectory(), world.provider.getDimensionType().getName(), this.hives.size()));

        return true;
    }
}
