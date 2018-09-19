package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.client.render.VisionModeRenderEvent;
import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.lwjgl.input.Keyboard;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

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
    public ItemArmorTitanium(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AliensVsPredator.materials().armors().celtic, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
                return Draw.getPath(AliensVsPredator.resources().TITANIUM1);
            case LEGS:
                return Draw.getPath(AliensVsPredator.resources().TITANIUM2);
            case CHEST:
                return Draw.getPath(AliensVsPredator.resources().TITANIUM1);
            case HEAD:
                return Draw.getPath(AliensVsPredator.resources().TITANIUM1);
            default:
                return Draw.getPath(AliensVsPredator.resources().TITANIUM1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AliensVsPredator.items().helmTitanium)
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
