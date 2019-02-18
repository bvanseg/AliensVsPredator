package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.entities.EntitySmartDisc;

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

public class ItemDisc extends HookedItem
{
    @Override
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityLivingBase living, int itemInUseCount)
    {
        if (living instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) living;

            if (player.inventory.hasItemStack(new ItemStack(AliensVsPredator.items().itemDisc)))
            {
                int remainingCount = this.getMaxItemUseDuration(itemstack) - itemInUseCount;
                float charge = remainingCount / 20.0F;
                charge = (charge * charge + charge * 2.0F) / 3.0F;

                if (charge >= 0.1F)
                {
                    boolean crit = charge > 1.5F ? true : false;
                    charge = charge > 1.5F ? 1.5F : charge;
                    charge *= 1.5F;

                    if (!world.isRemote)
                    {
                        EntitySmartDisc entity = new EntitySmartDisc(world, living, itemstack, charge);
                        entity.setIsCritical(crit);
                        world.spawnEntity(entity);
                    }

                    GameSounds.fxBow.playSound(living, 0.6F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.0F));
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
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (playerIn.inventory.hasItemStack(new ItemStack(AliensVsPredator.items().itemDisc)))
        {
            playerIn.setActiveHand(hand);
        }
        
        return super.onItemRightClick(worldIn, playerIn, hand);
    }
}
