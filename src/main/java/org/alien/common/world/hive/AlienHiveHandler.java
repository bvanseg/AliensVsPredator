package org.alien.common.world.hive;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.avp.common.tile.TileEntityHiveResin;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AlienHiveHandler {
	public static final AlienHiveHandler instance = new AlienHiveHandler();

	private final HashMap<UUID, AlienHive> entityUUIDsToHive;
	private final HashMap<BlockPos, AlienHive> resinPositionsToHive;
	
	private AlienHiveHandler() {
		this.entityUUIDsToHive = new HashMap<>();
		this.resinPositionsToHive = new HashMap<>();
	}
	
	public void addEntityAsMemberToHive(UUID entityUUID, AlienHive alienHive) {
		this.entityUUIDsToHive.compute(entityUUID, (k, v) -> alienHive);
	}

	AlienHive getHiveForEntityID(UUID hiveMemberID) {
		return entityUUIDsToHive.get(hiveMemberID);
	}

	public void removeHiveMember(UUID hiveMemberUUID) {
		this.entityUUIDsToHive.remove(hiveMemberUUID);
	}

	public void removeHiveMembers(Set<UUID> hiveMemberUUIDs) {
		this.entityUUIDsToHive.keySet().removeAll(hiveMemberUUIDs);
	}

	public void breakResinAt(World world, int targetX, int targetY, int targetZ) {
		BlockPos resinPos = new BlockPos(targetX, targetY, targetZ).toImmutable();
		
		if (resinPositionsToHive.containsKey(resinPos)) {
			TileEntityHiveResin resin = (TileEntityHiveResin) world.getTileEntity(resinPos);
			
			if (resin != null) {
				world.setBlockState(resinPos, resin.getParentBlock().getDefaultState(), 3);
			}
		}
	}

	public void removeResinPositions(Set<BlockPos> resinPositions) {
		this.resinPositionsToHive.keySet().removeAll(resinPositions);
	}
}
