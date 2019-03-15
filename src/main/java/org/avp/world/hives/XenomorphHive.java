package org.avp.world.hives;

import java.util.ArrayList;
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
    private ArrayList<SpeciesAlien>  aliens;
    private ArrayList<TileEntityHiveResin> resinInHive;
    private UUID                           uuid;
    private EntityMatriarch                    queen;
    public World                           world;
    private int                            dimensionId;
    private int                            xCoord;
    private int                            yCoord;
    private int                            zCoord;

    public XenomorphHive(World world, UUID uuid)
    {
        this.uuid = uuid;
        this.queen = (EntityMatriarch) Worlds.getEntityByUUID(world, this.uuid);
        this.aliens = new ArrayList<SpeciesAlien>();
        this.resinInHive = new ArrayList<TileEntityHiveResin>();

        if (this.getQueen() != null)
        {
            this.dimensionId = this.getQueen().world.provider.getDimension();
        }
    }

    public void setLocation(int xCoord, int yCoord, int zCoord)
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }

    public XenomorphHive setLocation(double xCoord, double yCoord, double zCoord)
    {
        this.setLocation((int) xCoord, (int) yCoord, (int) zCoord);
        return this;
    }

    public ArrayList<SpeciesAlien> getAliensInHive()
    {
        return this.aliens;
    }

    public ArrayList<TileEntityHiveResin> getResinInHive()
    {
        return resinInHive;
    }

    public void addMemberToHive(SpeciesAlien alien)
    {
        if (!this.aliens.contains(alien))
        {
            this.aliens.add(alien);
        }
    }

    public void addResin(TileEntityHiveResin resin)
    {
        if (!this.resinInHive.contains(resin))
        {
            this.resinInHive.add(resin);
        }
    }

    public boolean owns(TileEntityHiveResin resin)
    {
        if (resin != null && resin.getHiveSignature() != null)
        {
            if (!this.resinInHive.contains(resin) && resin.getHiveSignature().equals(this.getUniqueIdentifier()))
            {
                return true;
            }
        }

        return false;
    }

    public UUID getUniqueIdentifier()
    {
        return uuid;
    }

    public EntityMatriarch getQueen()
    {
        return this.queen == null && world != null ? this.queen = (EntityMatriarch) Worlds.getEntityByUUID(world, this.uuid) : this.queen;
    }

    public int getDimensionId()
    {
        return dimensionId;
    }

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

        if (this.getQueen() != null && this.getQueen().isDead)
        {
            HiveHandler.instance.getHives().remove(this);
        }

        if (this.getQueen() != null)
        {
            this.dimensionId = this.getQueen().world.provider.getDimension();
        }

        if (world.getWorldTime() % (20 * 5) == 0)
        {
            for (SpeciesAlien alien : (ArrayList<SpeciesAlien>) this.getAliensInHive().clone())
            {
                if (alien == null || alien.isDead)
                {
                    this.getAliensInHive().remove(alien);
                }
            }
        }
    }

    public void destroy()
    {
        for (TileEntityHiveResin resin : new ArrayList<TileEntityHiveResin>(this.getResinInHive()))
        {
            if (resin != null)
            {
                this.world.setBlockState(resin.getPos(), resin.getBlockCovering());
            }
        }

        for (SpeciesAlien alien : new ArrayList<SpeciesAlien>(this.getAliensInHive()))
        {
            if (alien != null)
            {
                alien.setDead();
            }
        }

        this.getAliensInHive().clear();
        this.getResinInHive().clear();
        HiveHandler.instance.getHives().remove(this);
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
        if (this.uuid != null)
        {
            nbt.setString("UUID", this.uuid.toString());
        }
        else
        {
            MDX.log().warn(String.format("A hive's UUID was null during the save process. This hive was not saved. Debug information: DIM(%s) XYZ(%s, %s, %s)", this.dimensionId, this.xCoord, this.yCoord, this.zCoord));
            return;
        }

        nbt.setInteger("DimID", this.dimensionId);
        nbt.setInteger("X", this.xCoord);
        nbt.setInteger("Y", this.yCoord);
        nbt.setInteger("Z", this.zCoord);

        NBTTagList list = new NBTTagList();

        for (TileEntityHiveResin resin : this.resinInHive)
        {
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
        return this.getQueen().getDistance(this.xCoord(), this.yCoord(), this.zCoord()) < this.getCoreRange();
    }

    public boolean isPointWithinHive(Pos coord)
    {
        return isPointWithinHive((int) coord.x(), (int) coord.y(), (int) coord.z());
    }

    public boolean isPointWithinHive(int x, int y, int z)
    {
        return this.getQueen().getDistance(x, y, z) < this.getMaxHiveRadius();
    }

    public double getDistanceFromHive(Entity entity)
    {
        return this.getQueen().getDistance(entity.posX, entity.posY, entity.posZ);
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
