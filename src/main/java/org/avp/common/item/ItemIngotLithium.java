package org.avp.common.item;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.Worlds;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class ItemIngotLithium extends HookedItem {
    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
        super.onUpdate(itemstack, world, entity, slot, selected);

        // If the item is currently not in-hand, return. We don't want lithium to explode by just being anywhere in the
        // player's inventory, because the player will be very confused otherwise.
        if (world.isRemote || !selected || world.getTotalWorldTime() % 10 != 0) return;

        // Only explode with survival mode players.
        if (!(entity instanceof EntityPlayer) || ((EntityPlayer) entity).isCreative())
            return;

        if (entity.isInWater()) {
            this.explode(entity);
            return;
        }

        if (world.rand.nextInt(25) == 0 && this.canExplodeAtEntityPosition(entity)) {
            this.explode(entity);
        }
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        World world = entityItem.world;

        if (world.isRemote || world.getTotalWorldTime() % 10 != 0) return super.onEntityItemUpdate(entityItem);

        if (entityItem.isInWater()) {
            this.explode(entityItem);
            entityItem.setDead();
            return super.onEntityItemUpdate(entityItem);
        }

        if (world.rand.nextInt(25) != 0) return super.onEntityItemUpdate(entityItem);

        if (entityItem.onGround && this.canExplodeAtEntityPosition(entityItem)) {
            this.explode(entityItem);
            entityItem.setDead();
        }

        return super.onEntityItemUpdate(entityItem);
    }

    private boolean canExplodeAtEntityPosition(Entity entity) {
        World world = entity.world;
        boolean isTouchingRain = world.isRainingAt(entity.getPosition()) && world.canSeeSky(entity.getPosition());
        boolean isHighHumidityBiome = world.getBiome(entity.getPosition()).isHighHumidity();

        return isTouchingRain || isHighHumidityBiome;
    }

    private void explode(Entity entity) {
        Worlds.createExplosion(entity, entity.world, new Pos(entity), 1F, true, true, !entity.world.isRemote);

        if (entity instanceof EntityPlayer) {
            Inventories.consumeItem((EntityPlayer) entity, this, true);
        }
    }
}
