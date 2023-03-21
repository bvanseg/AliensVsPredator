package org.avp.common.item;

import com.asx.mdx.common.minecraft.item.HookedItem;

public class ItemNetworkRackModule extends HookedItem
{
    public final int variant;

    public ItemNetworkRackModule(int variant)
    {
        super();
        this.variant = variant;
        this.setMaxStackSize(1);
    }
}
