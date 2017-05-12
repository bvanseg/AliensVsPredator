package org.avp.item;

import java.util.List;

import org.avp.client.Sounds;
import org.avp.entities.EntityFlame;

import com.arisux.mdxlib.lib.world.entity.player.inventory.Inventories;
import com.arisux.mdxlib.lib.world.item.HookedItem;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemFlamethrower extends HookedItem
{
    protected Item ammo;

    public ItemFlamethrower(Item ammo)
    {
        super();
        this.maxStackSize = 1;
        this.ammo = ammo;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand)
    {
        if (this.hasAmmo(world, player))
        {
            if (!world.isRemote)
            {
                EntityFlame entity = new EntityFlame(world, player);
                entity.setLocationAndAngles(entity.posX, entity.posY - 0.35, entity.posZ, entity.rotationYaw, entity.rotationPitch);
                world.spawnEntity(entity);
            }

            Sounds.SOUND_WEAPON_FLAMETHROWER.playSound(player);
        }
        return super.onItemRightClick(itemstack, world, player, hand);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("all")
    public void addInformation(ItemStack itemstack, EntityPlayer entityPlayer, List tooltipList, boolean par4)
    {
        super.addInformation(itemstack, entityPlayer, tooltipList, par4);
        tooltipList.add("Left click to aim. Right click to use.");
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
        return true;
    }
    
    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        return false;
    }

    public boolean hasAmmo(World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode)
        {
            return true;
        }

        if (Inventories.playerHas(this.ammo, player))
        {
            ItemStack ammoStack = player.inventory.getStackInSlot(Inventories.getSlotForItemIn(this.ammo, player.inventory));

            if (ammoStack != null && ammoStack.getItem() != null)
            {
                if (ammoStack.getItemDamage() < ammoStack.getMaxDamage())
                {
                    ammoStack.damageItem(1, player);
                }
                else
                {
                    Inventories.consumeItem(player, ammoStack.getItem());
                }

                return true;
            }
        }
        return false;
    }

    public Item getAmmo()
    {
        return ammo;
    }
}
