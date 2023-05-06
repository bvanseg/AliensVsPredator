package org.predator.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesEngineer;
import org.avp.common.entity.living.EntityMarine;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;
import org.lib.common.predicate.EntitySelectorBase;
import org.predator.common.item.*;
import org.weapon.common.item.firearm.ItemFirearm;

import java.util.function.Predicate;

public class EntitySelectorYautja extends EntitySelectorBase
{
    public static final EntitySelectorYautja instance = new EntitySelectorYautja();

    @Override
    public boolean test(Entity entity)
    {
        if (!super.test(entity)) return false;

        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;

            InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

            Predicate<Item> predicate = item -> item instanceof ItemSword ||
                    item instanceof ItemAxe ||
                    item instanceof ItemPickaxe ||
                    item instanceof ItemFirearm ||
                    item instanceof ItemWristbracer ||
                    item instanceof ItemPlasmaCannon ||
                    item instanceof ItemBow ||
                    item instanceof ItemDisc ||
                    item instanceof ItemShuriken;


            if (!inventorySnapshot.getItemsMatchingPredicate(predicate).isEmpty()) {
                return true;
            }
        }

        return (entity instanceof SpeciesAlien) || (entity instanceof SpeciesEngineer) || (entity instanceof EntityMarine);
    }
}
