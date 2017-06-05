package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.entities.EntitySpear;

import com.arisux.mdx.lib.game.GameSounds;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSpear extends ItemSword
{
    public ItemSpear(ToolMaterial material)
    {
        super(material);
        this.setMaxDamage(120);
        this.maxStackSize = 1;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityLiving;
            
            if (Inventories.playerHas(AliensVsPredator.items().itemSpear, player))
            {
                float charge = (this.getMaxItemUseDuration(itemstack) - timeLeft * 1F) / 9F;
                float maxCharge = 3.5F;

                charge = charge >= maxCharge ? maxCharge : charge;

                if (charge < 0.1D)
                {
                    return;
                }

                if (!world.isRemote)
                {
                    EntitySpear entityspear = new EntitySpear(world, player, itemstack);
                    entityspear.setThrowableHeading(entityspear.motionX, entityspear.motionY, entityspear.motionZ, 0.9F * charge, 0.1F);
                    GameSounds.fxPop.playSound(player, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + charge * 0.5F);
                    world.spawnEntity(entityspear);

                    if (!player.capabilities.isCreativeMode)
                    {
                        Inventories.consumeItem(player, AliensVsPredator.items().itemSpear, true);
                    }
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
        return EnumAction.BOW;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand)
    {
        if (Inventories.playerHas(AliensVsPredator.items().itemSpear, player))
        {
            player.setActiveHand(hand);
        }
        
        return super.onItemRightClick(itemstack, world, player, hand);
    }
}