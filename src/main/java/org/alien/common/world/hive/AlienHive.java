package org.alien.common.world.hive;

import com.google.common.primitives.Bytes;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants.NBT;
import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.entity.living.xenomorph.*;
import org.avp.AVP;
import org.lib.common.EntityAccessor;

import java.util.*;

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

	// Hive members are additionally tracked by their role (class).
	private final HashMap<Class<? extends Entity>, HashSet<UUID>> hiveMemberUUIDsByRole = new HashMap<>();

	// A static entry that exposes the ideal ratio each role of the hive should be. This helps aliens determine
	// whether they should mature. If the hive's current drone ratio is too high and the warrior ratio is too low,
	// then some drones will be allowed to morph into warriors. Otherwise, it's important to keep drones. If both ratios
	// are too low, then drones will also not morph into warriors until they are at a healthy count.
	private static final HashMap<Class<? extends Entity>, Integer> IDEAL_ROLE_RATIOS = new HashMap<>();

	static {
		IDEAL_ROLE_RATIOS.putIfAbsent(EntityDrone.class, 2); // 2 drones for every 1 warrior.
		IDEAL_ROLE_RATIOS.putIfAbsent(EntityRunnerDrone.class, 2);

		IDEAL_ROLE_RATIOS.putIfAbsent(EntityWarrior.class, 5); // 3 warriors for every 1 praetorian
		IDEAL_ROLE_RATIOS.putIfAbsent(EntityRunnerWarrior.class, 5);
	}

	public float getRatioToAdult(Class<? extends Entity> role) {
		if (!HiveMember.class.isAssignableFrom(role))
			throw new IllegalArgumentException("Given role class was not a HiveMember!");

		MaturityEntry maturityEntry = MaturityEntries.getEntryFor(role).orElse(null);
		// Ex. if role is EntityDrone.class, this gets the EntityWarrior.class count.
		int adultCount = maturityEntry == null ? 1 : this.hiveMemberUUIDsByRole.computeIfAbsent(maturityEntry.getEntityClass(), key -> new HashSet<>()).size();

		// let droneCount = 5 and warriorCount = 0.
		// droneCount / max(1, warriorCount) = 5, which is greater than the drone ratio (2 drones every 1 warrior), so evolve a drone.
		// let droneCount = 4 and warriorCount = 1.
		// droneCount / max(1, warriorCount) = 4, which is greater than the drone ratio (2 drones every 1 warrior), so evolve a drone.
		// let droneCount = 3 and warriorCount = 2.
		// droneCount / max(1, warriorCount) = 1.5, which is NOT greater than the drone ratio (2 drones every 1 warrior), so do nothing.
		return ((float)this.hiveMemberUUIDsByRole.computeIfAbsent(role, key -> new HashSet<>()).size()) / Math.max(adultCount, 1);
	}

	public boolean canMature(Class<? extends Entity> role) {
		float ratio = this.getRatioToAdult(role);
		return ratio > IDEAL_ROLE_RATIOS.getOrDefault(role, 1);
	}

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
		this.hiveMemberUUIDsByRole.clear();

		this.hiveMemberUUIDs.removeIf(hiveMemberUUID -> {
			Optional<Entity> entityOptional = EntityAccessor.instance.getEntityByUUID(hiveMemberUUID);

			boolean shouldRemove = false;
			if (entityOptional.isPresent()) {
				Entity entity = entityOptional.get();

				if (entity.isDead) {
					shouldRemove = true;
				} else {
					this.hiveMemberUUIDsByRole.computeIfAbsent(entity.getClass(), key -> new HashSet<>()).add(hiveMemberUUID);
				}
			} else {
				shouldRemove = true;
			}

			return shouldRemove;
		});
	}

	public void load() {
		this.hiveMemberUUIDs.forEach(uuid -> AlienHiveHandler.instance.addEntityAsMemberToHive(uuid, this));
		this.resinInHive.forEach(pos -> AlienHiveHandler.instance.addResinToHive(pos, this));
	}
	
	public void unload() {
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

	public Entity getHiveOwnerEntity() {
		return this.ownerEntity;
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
			AVP.instance.getLogger().warn("Loaded an invalid matriarch id '{}', expected '{}'!", matriarchId, this.getHiveOwner().getHiveMemberID());
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
