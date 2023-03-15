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
import org.avp.client.KeybindHandler;
import org.avp.client.Resources;
import org.avp.common.AVPMaterials;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;
import org.lwjgl.input.Keyboard;
import org.predator.client.PredatorSounds;
import org.predator.client.render.VisionModeRenderEvent;
import org.predator.common.PredatorItems;

public class ItemArmorCeltic extends ItemArmor
{
    public ItemArmorCeltic(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AVPMaterials.Armors.CELTIC, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot) {
            case LEGS:
                return Draw.getPath(Resources.instance.CELTIC2);
            default:
                return Draw.getPath(Resources.instance.CELTIC1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == PredatorItems.BIOMASK_CELTIC)
        {
            SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);
            player.fallDistance = 0.0F;

            if (world.isRemote)
            {
                this.controlledAbility(specialPlayer);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void controlledAbility(SpecialPlayerImpl specialPlayer)
    {
        if (Game.minecraft().inGameHasFocus)
        {
            ItemStack helmSlot = Inventories.getHelmSlotItemStack(Game.minecraft().player);

            if (helmSlot != null && helmSlot.getItem() == PredatorItems.BIOMASK_CELTIC && KeybindHandler.instance.genericSpecial.isPressed() && Keyboard.getEventKeyState())
            {
                PredatorSounds.YAUTJA_VISION_SWITCH.playSound(Game.minecraft().player, 1F, 1F);
                VisionModeRenderEvent.instance.switchMode();
            }
        }
    }
}
