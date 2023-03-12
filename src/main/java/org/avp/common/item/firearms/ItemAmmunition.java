package org.avp.common.item.firearms;

import com.asx.mdx.lib.world.item.HookedItem;

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