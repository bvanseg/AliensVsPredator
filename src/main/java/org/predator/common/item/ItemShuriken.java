package org.predator.common.item;

import com.asx.mdx.client.sound.GameSounds;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.predator.common.entity.EntityShuriken;

public class ItemShuriken extends HookedItem
{
    @Override
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityLivingBase entityLiving, int timeLeft)
    {
        if (!(entityLiving instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) entityLiving;

        if (!world.isRemote)
        {
            world.spawnEntity(new EntityShuriken(world, player));
        }

        GameSounds.fxBow.playSound(player, 0.6F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.0F));
        Inventories.consumeItem(player, this);
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
        player.setActiveHand(hand);
        return super.onItemRightClick(world, player, hand);
    }
}
