package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.client.Sounds;
import org.avp.client.render.VisionModeRenderEvent;
import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.lwjgl.input.Keyboard;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorCeltic extends ItemArmor
{
    public ItemArmorCeltic(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AliensVsPredator.materials().armors().celtic, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
                return Draw.getPath(AliensVsPredator.resources().CELTIC1);
            case LEGS:
                return Draw.getPath(AliensVsPredator.resources().CELTIC2);
            case CHEST:
                return Draw.getPath(AliensVsPredator.resources().CELTIC1);
            case HEAD:
                return Draw.getPath(AliensVsPredator.resources().CELTIC1);
            default:
                return Draw.getPath(AliensVsPredator.resources().CELTIC1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AliensVsPredator.items().biomaskCeltic)
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

            if (helmSlot != null && helmSlot.getItem() == AliensVsPredator.items().biomaskCeltic && AliensVsPredator.keybinds().genericSpecial.isPressed() && Keyboard.getEventKeyState())
            {
                Sounds.YAUTJA_VISION_SWITCH.playSound(Game.minecraft().player, 1F, 1F);
                VisionModeRenderEvent.instance.switchMode();
            }
        }
    }
}
