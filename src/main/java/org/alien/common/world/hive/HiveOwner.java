package org.alien.common.world.hive;

/**
 * Allows the implementing target to create and own an AlienHive. HiveOwners are also HiveMembers.
 * 
 * @author Boston Vanseghi
 *
 */
public interface HiveOwner extends HiveMember {
	AlienHive createNewAlienHive();
}
