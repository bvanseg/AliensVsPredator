package org.alien.common.entity.ai.selector;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.AlienItems;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

import javax.annotation.Nullable;

public class EntitySelectorAcidPool extends EntitySelectorBase
{
    public static final EntitySelectorAcidPool instance = new EntitySelectorAcidPool();

    @Override
    public boolean test(@Nullable Entity target)
    {
        if (!super.test(target)) return false;

        if (Predicates.IS_ALIEN.test(target)) return false;

        return !(target instanceof EntityPlayer) || Inventories.getBootSlotItemStack((EntityPlayer) target).getItem() != AlienItems.BOOTS_XENO;
    }
}
