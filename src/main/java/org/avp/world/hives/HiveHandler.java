package org.avp.world.hives;

import java.util.ArrayList;
import java.util.UUID;

import org.avp.AliensVsPredator;
import org.avp.api.storage.IWorldSaveHandler;
import org.avp.entities.living.EntityMatriarch;
import org.avp.entities.living.EntitySpeciesAlien;
import org.avp.tile.TileEntityHiveResin;

import com.arisux.mdx.MDX;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.Worlds;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HiveHandler implements IWorldSaveHandler
{
    public static final HiveHandler  instance = new HiveHandler();
    private ArrayList<XenomorphHive> hives    = null;
    public ArrayList<Pos>            burntResin;

    public HiveHandler()
    {
        this.hives = new ArrayList<XenomorphHive>();
        this.burntResin = new ArrayList<Pos>();
    }
    
    public XenomorphHive createHive(EntityMatriarch queen)
    {
        XenomorphHive hive = new XenomorphHive(queen.world, queen.getUniqueID()).setLocation(queen.posX, queen.posY, queen.posZ);
        HiveHandler.instance.getHives().add(hive);
        return hive;
    }

    public ArrayList<XenomorphHive> getHives()
    {
        return hives;
    }

    public XenomorphHive getHiveForAlien(EntitySpeciesAlien alien)
    {
        for (XenomorphHive hive : this.hives)
        {
            for (EntitySpeciesAlien a : hive.getAliensInHive())
            {
                if (a == alien)
                {
                    return hive;
                }
            }
        }

        return null;
    }

    public XenomorphHive getHiveForUUID(UUID uuid)
    {
        for (XenomorphHive hive : this.hives)
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

            if (resin != null && resin.getBlockCovering() != null)
            {
                world.setBlockState(pos, resin.getBlockCovering(), 3);
                
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
    public void updateHives(TickEvent.WorldTickEvent event)
    {
        // Murder annoying slimes if this is a dev environment.
        if (Game.isDevEnvironment())
        {
            for (Object o : new ArrayList(event.world.loadedEntityList))
            {
                Entity entity = (Entity) o;

                if (o instanceof EntitySlime)
                {
                    entity.setDead();
                }
            }
        }

        for (Pos coord : new ArrayList<Pos>(this.burntResin))
        {
            event.world.setBlockState(coord.blockPos(), Blocks.AIR.getDefaultState(), 3);
            this.burntResin.remove(coord);
        }

        for (XenomorphHive hive : (ArrayList<XenomorphHive>) this.hives.clone())
        {
            if (hive != null && hive.getDimensionId() == event.world.provider.getDimension())
            {
                hive.update(event.world);
            }
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

                for (XenomorphHive hive : this.hives)
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

        MDX.log().info(String.format("Saved %s hives for level '%s'/%s", hiveCount, world.getSaveHandler().getWorldDirectory(), world.provider.getDimensionType().getName()));

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

                        if (!this.hives.contains(hive))
                        {
                            this.hives.add(hive);
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
