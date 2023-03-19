package org.alien.common.world.hive;

import com.google.common.primitives.Bytes;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants.NBT;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.avp.AVP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AlienHive {

	private final EntityMatriarch matriarch;
	private final HashSet<UUID> hiveMemberUUIDs;
    private final HashSet<BlockPos> resinInHive;

	private BlockPos coreBlockPos;
	
	public AlienHive(EntityMatriarch matriarch) {
		this.matriarch = matriarch;
		this.hiveMemberUUIDs = new HashSet<>();
		this.resinInHive = new HashSet<>();
		this.coreBlockPos = this.matriarch.getPosition().toImmutable();
		
		// Add the queen to the hive by default.
		this.addHiveMember(matriarch.getHiveMemberID());
	}
	
	public void update() {
		// If the matriarch is dead, the hive is dead. Update hives state.
		if (this.matriarch.isDead) {
			this.destroy();

			// TODO: Pass on hive to a royal hive member if one is available.
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

	public void addResin(BlockPos pos) {
		resinInHive.add(pos);
	}
	
	public BlockPos getCoreBlockPos() {
		return coreBlockPos;
	}
	
	public HiveOwner getHiveOwner() {
		return this.matriarch;
	}
	
	public boolean isQueenAtCore()
    {
        return this.matriarch.getDistance(this.coreBlockPos.getX(), this.coreBlockPos.getY(), this.coreBlockPos.getZ()) < this.getCoreRange();
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
        return this.matriarch.getDistance(entity.posX, entity.posY, entity.posZ);
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
		nbt.setUniqueId(MATRIARCH_ID_NBT_KEY, this.matriarch.getHiveMemberID());

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
		
		if (matriarchId == null || !matriarchId.equals(this.matriarch.getHiveMemberID())) {
			AVP.log().warn("Loaded an invalid matriarch id '{}', expected '{}'!", matriarchId, this.matriarch.getHiveMemberID());
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
