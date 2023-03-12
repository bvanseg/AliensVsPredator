package org.avp.common.item.firearms;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.client.util.ITooltipFlag;
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
import org.avp.client.Sounds;
import org.avp.common.entities.EntityFlame;

import java.util.List;

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
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (this.hasAmmo(world, player))
        {
            if (!world.isRemote)
            {
                EntityFlame entity = new EntityFlame(world, player);
                entity.setLocationAndAngles(entity.posX, entity.posY - 0.35, entity.posZ, entity.rotationYaw, entity.rotationPitch);
                world.spawnEntity(entity);
            }

            Sounds.WEAPON_FLAMETHROWER.playSound(player);
        }
        return super.onItemRightClick(world, player, hand);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add("Left click to aim. Right click to use.");
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
