package org.avp.common.world.hive;

/**
 * Allows the implementing target to create and own an AlienHive. HiveOwners are also HiveMembers.
 * 
 * @author Boston Vanseghi
 *
 */
public interface HiveOwner extends HiveMember {
	public AlienHive createNewAlienHive();
}
