package org.predator.common.item;

import com.asx.mdx.client.sound.GameSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;
import org.predator.common.PredatorItems;
import org.predator.common.entity.EntitySpear;

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
        if (!(entityLiving instanceof EntityPlayer)) return;
        if (world.isRemote) return;

        float charge = (this.getMaxItemUseDuration(itemstack) - timeLeft * 1F) / 9F;
        float maxCharge = 3.5F;

        charge = Math.min(charge, maxCharge);

        if (charge < 0.1D)
            return;

        EntityPlayer player = (EntityPlayer) entityLiving;

        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

        if (!inventorySnapshot.hasItem(PredatorItems.ITEM_SPEAR)) return;

        EntitySpear entityspear = new EntitySpear(world, player);
        entityspear.shoot(entityspear.motionX, entityspear.motionY, entityspear.motionZ, 0.9F * charge, 0.1F);
        GameSounds.fxPop.playSound(player, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + charge * 0.5F);
        world.spawnEntity(entityspear);
        inventorySnapshot.consumeItem(PredatorItems.ITEM_SPEAR);
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
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);
        if (inventorySnapshot.hasItem(PredatorItems.ITEM_SPEAR))
        {
            player.setActiveHand(hand);
        }

        return super.onItemRightClick(world, player, hand);
    }
}