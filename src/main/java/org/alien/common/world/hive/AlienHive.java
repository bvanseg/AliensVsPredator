package org.alien.common.world.hive;

import com.google.common.primitives.Bytes;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants.NBT;
import org.avp.AVP;
import org.avp.EntityAccessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AlienHive {

	private final Entity ownerEntity;
	private final HashSet<UUID> hiveMemberUUIDs;
    private final HashSet<BlockPos> resinInHive;

	private BlockPos coreBlockPos;

	// TODO: Store hive member UUIDs by their role (class).

	public AlienHive(Entity ownerEntity) {
		if (!(ownerEntity instanceof HiveOwner)) {
			throw new IllegalStateException("Non-HiveOwner passed as owner of AlienHive!");
		}

		this.ownerEntity = ownerEntity;
		this.hiveMemberUUIDs = new HashSet<>();
		this.resinInHive = new HashSet<>();
		this.coreBlockPos = this.ownerEntity.getPosition().toImmutable();
		
		// Add the queen to the hive by default.
		this.addHiveMember(this.getHiveOwner().getHiveMemberID());
	}
	
	public void update() {
		// TODO: Pass on hive to a royal hive member if one is available *before* destroying hive completely.
		if (this.ownerEntity.isDead) {
			this.destroy();
		}
	}
	
	public void destroy() {
		AlienHiveHandler.instance.removeHiveMembers(this.hiveMemberUUIDs);
		AlienHiveHandler.instance.removeResinPositions(this.resinInHive);
	}
	
	public void addHiveMember(UUID entityUUID) {
		this.hiveMemberUUIDs.add(entityUUID);
		AlienHiveHandler.instance.addEntityAsMemberToHive(entityUUID, this);
	}

	public Optional<Entity> getHiveMember(UUID entityUUID) {
		return EntityAccessor.instance.getEntityByUUID(entityUUID);
	}

	public void addResin(BlockPos pos) {
		resinInHive.add(pos);
	}
	
	public BlockPos getCoreBlockPos() {
		return coreBlockPos;
	}
	
	public HiveOwner getHiveOwner() {
		return (HiveOwner) this.ownerEntity;
	}
	
	public boolean isQueenAtCore()
    {
        return this.ownerEntity.getDistance(this.coreBlockPos.getX(), this.coreBlockPos.getY(), this.coreBlockPos.getZ()) < this.getCoreRange();
    }

    public boolean isPointWithinHive(BlockPos coord)
    {
        return isPointWithinHive(coord.getX(), coord.getY(), coord.getZ());
    }

    public boolean isPointWithinHive(int x, int y, int z)
    {
        return this.coreBlockPos.getDistance(x, y, z) < this.getMaxHiveRadius();
    }

	public double getDistanceFromHive(Entity entity)
    {
        return this.ownerEntity.getDistance(entity.posX, entity.posY, entity.posZ);
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
	
	private static final String MATRIARCH_ID_NBT_KEY = "MatriarchId";
	private static final String CORE_BLOCK_POS_NBT_KEY = "CoreBlockPos";
	private static final String HIVE_MEMBERS_NBT_KEY = "HiveMembers";
	private static final String RESIN_POSITIONS_NBT_KEY = "ResinPositions";

	public void writeToNBT(NBTTagCompound nbt) {
		// Write matriarch UUID.
		nbt.setUniqueId(MATRIARCH_ID_NBT_KEY, this.getHiveOwner().getHiveMemberID());

		// Write core block position.
		nbt.setIntArray(CORE_BLOCK_POS_NBT_KEY, new int[] { this.coreBlockPos.getX(), this.coreBlockPos.getY(), this.coreBlockPos.getZ() });
		
		// Write hive members.
		NBTTagList memberList = new NBTTagList();
		this.hiveMemberUUIDs.forEach(uuid -> new NBTTagString(uuid.toString()));
		nbt.setTag(HIVE_MEMBERS_NBT_KEY, memberList);
		
		// Write relative resin block positions.
		ArrayList<Byte> resinPositions = new ArrayList<>();
		this.resinInHive.forEach(resinPos -> {
			resinPositions.add((byte)(this.coreBlockPos.getX() - resinPos.getX()));
			resinPositions.add((byte)(this.coreBlockPos.getY() - resinPos.getY()));
			resinPositions.add((byte)(this.coreBlockPos.getZ() - resinPos.getZ()));
		});
		nbt.setByteArray(RESIN_POSITIONS_NBT_KEY, Bytes.toArray(resinPositions));
	}

	public void readFromNBT(NBTTagCompound nbt) {
		// Sanity check.
		UUID matriarchId = nbt.getUniqueId(MATRIARCH_ID_NBT_KEY);
		
		if (matriarchId == null || !matriarchId.equals(this.getHiveOwner().getHiveMemberID())) {
			AVP.log().warn("Loaded an invalid matriarch id '{}', expected '{}'!", matriarchId, this.getHiveOwner().getHiveMemberID());
		}
		
		// Read core block position.
		int[] coreBlockPosParts = nbt.getIntArray(CORE_BLOCK_POS_NBT_KEY);
		if (coreBlockPosParts != null && coreBlockPosParts.length == 3) {
			this.coreBlockPos = new BlockPos(coreBlockPosParts[0], coreBlockPosParts[1], coreBlockPosParts[2]);
		}
		
		// Read hive members. Don't validate entity here, since queen can potentially load before other hive members.
		NBTTagList memberUUIDStrings = nbt.getTagList(HIVE_MEMBERS_NBT_KEY, NBT.TAG_STRING);
		memberUUIDStrings.forEach(uuidStringNBT -> this.hiveMemberUUIDs.add(UUID.fromString(uuidStringNBT.toString())));
		
		// Read relative resin block positions.
		byte[] resinPositions = nbt.getByteArray(RESIN_POSITIONS_NBT_KEY);
		
		for (int i = 0; i < resinPositions.length; i += 3) {
			int posX = resinPositions[i];
			int posY = resinPositions[i + 1];
			int posZ = resinPositions[i + 2];
			BlockPos resinPos = new BlockPos(posX + this.coreBlockPos.getX(), posY + this.coreBlockPos.getY(), posZ + this.coreBlockPos.getZ());
			this.resinInHive.add(resinPos.toImmutable());
		}
	}
}
