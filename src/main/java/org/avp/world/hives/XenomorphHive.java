package org.avp.world.hives;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.tile.TileEntityHiveResin;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Worlds;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;

public class XenomorphHive
{
	// FIXME: This can really just be a hash set of UUIDs. Entities can be fetched by UUID later.
    private final HashMap<UUID, SpeciesAlien>    aliens;
    
    // FIXME: It's not a good idea to hold references to tile entities when we can alternatively hold references to positions.
    private final HashSet<TileEntityHiveResin>   resinInHive;
    private final UUID                           uuid;
    private EntityMatriarch                      queen;
    public World                                 world;
    private int                                  dimensionId;
    
    private int                                  xCoord;
    private int                                  yCoord;
    private int                                  zCoord;

    public XenomorphHive(World world, UUID uuid)
    {
        this.uuid = uuid;
        this.queen = (EntityMatriarch) Worlds.getEntityByUUID(world, this.uuid);
        this.aliens = new HashMap<>();
        this.resinInHive = new HashSet<>();

        // FIXME: The queen would only be null here if it was unloaded, dead, or the wrong entity UUID was provided.
        // In all three cases, the hive shouldn't exist!
        if (this.getQueen() != null)
        {
            this.dimensionId = this.getQueen().world.provider.getDimension();
        }
    }

    // TODO: Use block pos
    public void setLocation(int xCoord, int yCoord, int zCoord)
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }

    // TODO: Use block pos
    public XenomorphHive setLocation(double xCoord, double yCoord, double zCoord)
    {
        this.setLocation((int) xCoord, (int) yCoord, (int) zCoord);
        return this;
    }

    public Collection<SpeciesAlien> getAliensInHive()
    {
        return this.aliens.values();
    }

    public Set<TileEntityHiveResin> getResinInHive()
    {
        return resinInHive;
    }

    public void addMemberToHive(SpeciesAlien alien)
    {
    	this.aliens.putIfAbsent(alien.getUniqueID(), alien);
    }

    public void addResin(TileEntityHiveResin resin)
    {
        this.resinInHive.add(resin);
    }

    public UUID getUniqueIdentifier()
    {
        return uuid;
    }

    public EntityMatriarch getQueen()
    {
    	// FIXME: This still has a chance of returning null if the queen is either not loaded or is dead.
        return this.queen == null && world != null ? this.queen = (EntityMatriarch) Worlds.getEntityByUUID(world, this.uuid) : this.queen;
    }

    public int getDimensionId()
    {
        return dimensionId;
    }
    
    // FIXME: Why not use a block pos instead to hold these three?
    public int xCoord()
    {
        return xCoord;
    }

    public int yCoord()
    {
        return yCoord;
    }

    public int zCoord()
    {
        return zCoord;
    }

    public void update(World world)
    {
        this.world = world;

        // FIXME: If the hive exists, lives and dies by the queen, why not just have the queen entity manage and update the hive instead?
        if (this.getQueen() != null && this.getQueen().isDead)
        {
            // FIXME: This modifies the hive map and this#update is called in HiveHandler while iterating the hive map.
            HiveHandler.instance.getHiveMap().remove(this.getUniqueIdentifier());
        }

        // TODO: Edge case, what happens if the queen changes dimensions, somehow?
        if (this.getQueen() != null)
        {
            this.dimensionId = this.getQueen().world.provider.getDimension();
        }

        // FIXME: It would be more optimal if aliens just notified the hive of their death (onDeath).
        if (world.getTotalWorldTime() % (20 * 5) == 0)
            aliens.entrySet().removeIf(e -> e.getValue() == null || e.getValue().isDead);
    }

    public void destroy()
    {
        for (TileEntityHiveResin resin : this.getResinInHive())
        {
            if (resin != null)
            {
                this.world.setBlockState(resin.getPos(), resin.getParentBlock().getDefaultState());
            }
        }

        for (SpeciesAlien alien : this.getAliensInHive())
        {
            if (alien != null)
            {
                alien.setDead();
            }
        }

        this.getAliensInHive().clear();
        this.getResinInHive().clear();
        HiveHandler.instance.getHiveMap().remove(this.getUniqueIdentifier());
    }

    public void load(World world, UUID uniqueIdentifier, NBTTagCompound nbt)
    {
        this.queen = (EntityMatriarch) Worlds.getEntityByUUID(world, this.uuid);
        this.dimensionId = nbt.getInteger("DimID");
        this.xCoord = nbt.getInteger("X");
        this.yCoord = nbt.getInteger("Y");
        this.zCoord = nbt.getInteger("Z");

        NBTTagList list = nbt.getTagList("Resin", NBT.TAG_STRING);
        
        for (int i = 0; i < list.tagCount(); i++)
        {
            String key = list.getStringTagAt(i);
            String[] coordSet = key.split(",");

            int x = Integer.parseInt(coordSet[0].trim());
            int y = Integer.parseInt(coordSet[1].trim());
            int z = Integer.parseInt(coordSet[2].trim());

            // FIXME: edge case, what if this block position's parent chunk is not loaded?
            TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

            if (tile instanceof TileEntityHiveResin)
            {
                TileEntityHiveResin resin = (TileEntityHiveResin) tile;
                this.addResin(resin);
            }
        }
    }

    public void save(World world, NBTTagCompound nbt)
    {
    	// FIXME: This should never be null, there shouldn't be a check here.
        if (this.uuid != null)
        {
            nbt.setString("UUID", this.uuid.toString());
        }
        else
        {
            MDX.log().warn(String.format("A hive's UUID was null during the save process. This hive was not saved. Debug information: DIM(%s) XYZ(%s, %s, %s)", this.dimensionId, this.xCoord, this.yCoord, this.zCoord));
            return;
        }

        // TODO: Resin positions could be stored more efficiently as an offset from a single core block (effective for < 255 block distance).
        // Storing the resin this way could allow us to get away with 3 bytes for storage instead of 12 bytes, saving 75% more storage.
        // If a piece of resin is somehow placed far away from a hive, it shouldn't be sustained, anyways.
        // The only edge case would be if the queen moves the hive, the core block moves.
        // Unless the core block shouldn't move without destroying the hive, then there is no problem.

        nbt.setInteger("DimID", this.dimensionId);
        nbt.setInteger("X", this.xCoord);
        nbt.setInteger("Y", this.yCoord);
        nbt.setInteger("Z", this.zCoord);

        NBTTagList list = new NBTTagList();

        for (TileEntityHiveResin resin : this.resinInHive)
        {
        	// FIXME: It is inefficient and error-prone to store positions as strings.
        	// We know each position is 3 values, so we can have a flat 1 dimensional array of ints, instead, where array length % 3 == 0 is always true.
            list.appendTag(new NBTTagString(String.format("%s, %s, %s", resin.getPos().getX(), resin.getPos().getY(), resin.getPos().getZ())));
        }

        nbt.setTag("Resin", list);
    }

    @Override
    public String toString()
    {
        return String.format("[Dimension %s, %s Aliens, %s Resin, HIVE UUID: %s, QUEEN UUID: %s, XYZ(%s, %s, %s)]", this.dimensionId, this.getAliensInHive().size(), this.getResinInHive().size(), this.getUniqueIdentifier(), this.getQueen() != null ? this.getQueen().getUniqueID() : null, this.xCoord, this.yCoord, this.zCoord);
    }

    public boolean isQueenAtCore()
    {
        if (this.getQueen() != null)
        {
            return this.getQueen().getDistance(this.xCoord(), this.yCoord(), this.zCoord()) < this.getCoreRange();
        }
        
        // FIXME: This is a misleading output if the queen is null.
        return false;
    }

    // FIXME: Use blockPos instead.
    public boolean isPointWithinHive(Pos coord)
    {
        return isPointWithinHive((int) coord.x(), (int) coord.y(), (int) coord.z());
    }

    public boolean isPointWithinHive(int x, int y, int z)
    {
        if (this.getQueen() != null)
        {
        	// TODO: Double-check that this distance is in terms of blocks.
            return this.getQueen().getDistance(x, y, z) < this.getMaxHiveRadius();
        }
        
        return false;
    }

    // FIXME: edge cases, what if the entity provided is null? What if the queen is null, the entity distance is 0, at the center of the hive (that shouldn't exist)??
    public double getDistanceFromHive(Entity entity)
    {
        if (this.getQueen() != null)
        {
            return this.getQueen().getDistance(entity.posX, entity.posY, entity.posZ);
        }

        return 0;
    }

    public boolean isEntityWithinRange(Entity entity)
    {
        return getDistanceFromHive(entity) < this.getMaxHiveRadius();
    }

    public int getCoreRange()
    {
        return getMaxHiveRadius() / 4;
    }

    public int getMaxHiveRadius()
    {
        return 32;
    }
}
