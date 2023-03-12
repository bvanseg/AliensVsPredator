package org.predator.common.item;

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
import org.avp.AVP;
import org.avp.client.AVPSounds;
import org.avp.common.world.capability.ISpecialPlayer.SpecialPlayer;
import org.lwjgl.input.Keyboard;
import org.predator.client.render.VisionModeRenderEvent;

public class ItemArmorCeltic extends ItemArmor
{
    public ItemArmorCeltic(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AVP.materials().armors().celtic, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot) {
            case LEGS:
                return Draw.getPath(AVP.resources().CELTIC2);
            default:
                return Draw.getPath(AVP.resources().CELTIC1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AVP.items().biomaskCeltic)
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

            if (helmSlot != null && helmSlot.getItem() == AVP.items().biomaskCeltic && AVP.keybinds().genericSpecial.isPressed() && Keyboard.getEventKeyState())
            {
                AVPSounds.YAUTJA_VISION_SWITCH.playSound(Game.minecraft().player, 1F, 1F);
                VisionModeRenderEvent.instance.switchMode();
            }
        }
    }
}
