package org.avp.common.item.firearm;
/**
     * An enum of the different firearm classifications used to mix and match firearms with different types of ammo.
     */
public enum Classification {
	SUB_MACHINE_GUN(1.0F),
	LIGHT_MACHINE_GUN(1.2F),
	RIFLE(1.8F),
	ASSAULT_RIFLE(1.0F),
	SHOTGUN(2.0F),
	PISTOL(1.0F);

	private float baseDamage;

	Classification(float baseDamage) {
		this.baseDamage = baseDamage;
	}

	public float getBaseDamage() {
		return this.baseDamage;
	}
}