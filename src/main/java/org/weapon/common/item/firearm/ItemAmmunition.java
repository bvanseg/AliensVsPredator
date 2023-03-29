package org.weapon.common.item.firearm;

import com.asx.mdx.common.minecraft.item.HookedItem;

public class ItemAmmunition extends HookedItem {
	protected Classification ammoClass;

	public ItemAmmunition(Classification ammoClass) {
		super();
		this.ammoClass = ammoClass;
	}

	public Classification getClassification() {
		return ammoClass;
	}
}