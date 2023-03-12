package org.avp.common.world.hive;

import net.minecraft.entity.Entity;

import java.util.UUID;

/**
 * Allows the implementing target to become part of an AlienHive.
 * 
 * @author Boston Vanseghi
 *
 */
public interface HiveMember {
	static final UUID EMPTY_HIVE_ID = new UUID(0, 0);
	
	public default UUID getHiveMemberID() {
		if (this instanceof Entity) {
			return ((Entity)this).getUniqueID();
		}
		
		return EMPTY_HIVE_ID;
	}
	
	public default boolean canBecomeHiveMember() {
		return this.getHiveMemberID() != EMPTY_HIVE_ID;
	}
	
	public default AlienHive getAlienHive() {
		return AlienHiveHandler.instance.getHiveForEntityID(this.getHiveMemberID());
	}
}