package org.avp.item;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Worlds;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIngotLithium extends HookedItem
{
    public ItemIngotLithium() {}

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean selected)
    {
        super.onUpdate(itemstack, world, entity, slot, selected);
        
        if (entity.isInWater()) {
        	this.explode(entity);
        }
        
        // Only explode with survival mode players.
        if (!(entity instanceof EntityPlayer) || (entity instanceof EntityPlayer) && ((EntityPlayer)entity).isCreative())
        	return;
        
        boolean isTouchingRain = world.isRainingAt(entity.getPosition()) && world.canSeeSky(entity.getPosition());
        boolean isHighHumidityBiome = world.getBiome(entity.getPosition()).isHighHumidity();
        
        if ((isTouchingRain || isHighHumidityBiome) && world.getTotalWorldTime() % 20 == 0 && world.rand.nextInt(5) == 0) {
        	this.explode(entity);
        }
    }
    
    private void explode(Entity entity) {
        Worlds.createExplosion(entity, entity.world, new Pos(entity), 1F, true, true, !entity.world.isRemote);
        Inventories.consumeItem((EntityPlayer) entity, this, true);
    }
}
