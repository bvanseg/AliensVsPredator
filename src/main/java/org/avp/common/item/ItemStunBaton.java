package org.avp.common.item;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.entity.fx.EntityFXElectricArc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.AVPSounds;
import org.avp.common.item.init.AVPItems;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;

import java.util.Random;

public class ItemStunBaton extends ItemSword
{
    public ItemStunBaton()
    {
        super(ToolMaterial.IRON);
        this.maxStackSize = 1;
    }
    
    @Override
    public float getAttackDamage()
    {
        return 6.0F;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if (hasCharge(player.world, player))
        {
            if(player.world.isRemote)
                addArcEffect(player, entity);
            
            AVPSounds.WEAPON_STUNBATON.playSound(entity);

            if (entity instanceof EntityLiving)
            {
                EntityLiving living = (EntityLiving) entity;
                living.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 160, 2));
                living.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 160));
            }
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    public boolean hasCharge(World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode)
        {
            return true;
        }

        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

        if (!inventorySnapshot.hasItem(AVPItems.ITEM_CHARGE_PACK)) return false;

        ItemStack ammoStack = inventorySnapshot.getFirstNonEmptyStack(AVPItems.ITEM_CHARGE_PACK);

        if (ammoStack == null || ammoStack.getItem() == null) return false;

        if (ammoStack.getItemDamage() < ammoStack.getMaxDamage())
        {
            ammoStack.damageItem(1, player);
        }
        else
        {
            inventorySnapshot.consumeItem(ammoStack.getItem());
        }

        return true;
    }

    @SideOnly(Side.CLIENT)
    private static void addArcEffect(EntityPlayer player, Entity target)
    {
        Random rand = new Random();
        float mult = 100F;
        int span = (int) (target.width * mult);

        float targetYOrigin = (float) (target.posY + (target.height / 2));
        float targetX = (float) (target.posX + (rand.nextInt(span) / mult) - (rand.nextInt(span) / mult));
        float targetY = (float) (targetYOrigin + (rand.nextInt(span) / mult) - (rand.nextInt(span) / mult));
        float targetZ = (float) (target.posZ + (rand.nextInt(span) / mult) - (rand.nextInt(span) / mult));

        ClientGame.instance.minecraft().effectRenderer.addEffect(new EntityFXElectricArc(player.world, target.posX, targetYOrigin, target.posZ, targetX, targetY, targetZ, 1, 1F, 0.1F, 0.05F, 0xFF8866CC));
    }
}