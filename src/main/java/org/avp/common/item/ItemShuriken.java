package org.avp.common.item;

import com.asx.mdx.lib.util.GameSounds;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.avp.AVP;
import org.predator.common.entity.EntityShuriken;

public class ItemShuriken extends HookedItem
{
    @Override
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityLiving;
            
            if (player.inventory.hasItemStack(new ItemStack(AVP.items().itemShuriken)))
            {
                int remainingCount = this.getMaxItemUseDuration(itemstack) - timeLeft;
                float velocity = remainingCount / 20.0F;
                velocity = (velocity * velocity + velocity * 2.0F) / 3.0F;

                if (velocity >= 0.1F)
                {
                    velocity = velocity > 1.5F ? 1.5F : velocity;
                    velocity *= 1.5F;

                    if (!world.isRemote)
                    {
                        world.spawnEntity(new EntityShuriken(world, player, velocity * 1.5F));
                    }

                    GameSounds.fxBow.playSound(player, 0.6F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.0F));
                    Inventories.consumeItem(player, this);
                }
            }
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.BLOCK;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (player.inventory.hasItemStack(new ItemStack(AVP.items().itemShuriken)))
        {
            player.setActiveHand(hand);
        }
        
        return super.onItemRightClick(world, player, hand);
    }
}
