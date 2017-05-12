package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.client.render.VisionModeRenderEvent;
import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.lwjgl.input.Keyboard;

import com.arisux.mdxlib.lib.client.render.Draw;
import com.arisux.mdxlib.lib.game.Game;
import com.arisux.mdxlib.lib.world.entity.player.inventory.Inventories;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorTitanium extends ItemArmor
{
    public ItemArmorTitanium(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType)
    {
        super(material, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
                return Draw.getResourcePath(AliensVsPredator.resources().TITANIUM1);
            case LEGS:
                return Draw.getResourcePath(AliensVsPredator.resources().TITANIUM1);
            case CHEST:
                return Draw.getResourcePath(AliensVsPredator.resources().TITANIUM2);
            case HEAD:
                return Draw.getResourcePath(AliensVsPredator.resources().TITANIUM1);
            default:
                return Draw.getResourcePath(AliensVsPredator.resources().TITANIUM1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == AliensVsPredator.items().helmTitanium)
        {
            SpecialPlayer specialPlayer = (SpecialPlayer) player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);
            player.fallDistance = 0.0F;

            if (world.isRemote)
            {
                this.controlledAbility(specialPlayer);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void controlledAbility(SpecialPlayer specialPlayer)
    {
        if (Game.minecraft().inGameHasFocus)
        {
            ItemStack helmSlot = Inventories.getHelmSlotItemStack(Game.minecraft().player);

            if (helmSlot != null && helmSlot.getItem() == AliensVsPredator.items().helmTitanium && AliensVsPredator.keybinds().genericSpecial.isPressed() && Keyboard.getEventKeyState())
            {
                VisionModeRenderEvent.instance.switchMode();
            }
        }
    }
}
