package org.avp.item;

import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.client.Sounds;

import com.arisux.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

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

public class ItemStunBaton extends ItemSword
{
    // TODO: Fix this, the ToolMaterial passed into this constructor is DIAMOND,
    // didnt know what custom material to put, n dont wanna make a new one that
    // might not be what u guys want
    public ItemStunBaton(ToolMaterial material)
    {
        super(material);
        // TODO: Find out if this is a proper max damage. Remove this if a damage is
        // specified later by a custom material
        this.maxStackSize = 1;
    }

    // TODO: adjust these particles once MDX 2.0.0.25 is added to the dev
    // environment
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if (hasCharge(player.world, player))
        {
            addArcEffect(player, entity);
            Sounds.WEAPON_STUNBATON.playSound(entity);

            if (entity instanceof EntityLiving)
            {
                EntityLiving living = (EntityLiving) entity;
                living.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 160));
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

        if (Inventories.playerHas(AliensVsPredator.items().itemChargePack, player))
        {
            ItemStack ammoStack = player.inventory.getStackInSlot(Inventories.getSlotForItemIn(AliensVsPredator.items().itemChargePack, player.inventory));

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

        Game.minecraft().effectRenderer.addEffect(new EntityFXElectricArc(player.world, target.posX, targetYOrigin, target.posZ, targetX, targetY, targetZ, 1, 1F, 0.1F, 0.05F, 0xFF8866CC));
    }
}