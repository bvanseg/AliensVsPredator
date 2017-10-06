package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDrone;
import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorXeno extends ItemArmor
{
    @SideOnly(Side.CLIENT)
    public ModelDrone mainModel;

    public ItemArmorXeno(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AliensVsPredator.materials().armors().chitin, renderIndex, armorType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
        case FEET:
            return Draw.getResourcePath(AliensVsPredator.resources().XENO1);
        case LEGS:
            return Draw.getResourcePath(AliensVsPredator.resources().XENO2);
        case CHEST:
            return Draw.getResourcePath(AliensVsPredator.resources().XENO1);
        default:
            return Draw.getResourcePath(AliensVsPredator.resources().XENO1);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
    {
        return null;
    }

    public static boolean isPlayerWearingXenoArmorSet(EntityPlayer player)
    {
        if (player != null)
        {
            ItemStack helm = Inventories.getHelmSlotItemStack(player);
            ItemStack chest = Inventories.getChestSlotItemStack(player);
            ItemStack legs = Inventories.getLegsSlotItemStack(player);
            ItemStack boots = Inventories.getBootSlotItemStack(player);
            return (helm != null && chest != null && legs != null && boots != null && (helm.getItem() == AliensVsPredator.items().helmXeno && chest.getItem() == AliensVsPredator.items().plateXeno && legs.getItem() == AliensVsPredator.items().legsXeno && boots.getItem() == AliensVsPredator.items().bootsXeno));
        }

        return false;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (isPlayerWearingXenoArmorSet(player))
        {
            SpecialPlayer specialPlayer = (SpecialPlayer) player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

            if (world.isRemote)
            {
                this.controlledAbility(player, specialPlayer);
            }

            player.fallDistance = 0.0F;

            if (specialPlayer.canClimb() && player.isCollidedHorizontally)
            {
                player.motionY += 0.03F;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void controlledAbility(EntityPlayer player, SpecialPlayer specialPlayer)
    {
        boolean canClimbPrev = specialPlayer.canClimb();

        if (Game.minecraft().gameSettings.keyBindJump.isPressed())
        {
            specialPlayer.setCanClimb(true);
        }
        else if (!Game.minecraft().gameSettings.keyBindJump.isPressed())
        {
            specialPlayer.setCanClimb(false);
        }

        if (canClimbPrev != specialPlayer.canClimb())
        {
            specialPlayer.syncWithServer(player);
        }
    }
}
