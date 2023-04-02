package org.predator.common.item;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.KeybindHandler;
import org.avp.common.AVPArmorMaterials;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;
import org.lwjgl.input.Keyboard;
import org.predator.client.PredatorResources;
import org.predator.client.PredatorSounds;
import org.predator.client.render.VisionModeRenderEvent;
import org.predator.common.PredatorItems;

public class ItemArmorCeltic extends ItemArmor
{
    public ItemArmorCeltic(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AVPArmorMaterials.CELTIC, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot) {
            case LEGS:
                return Draw.getPath(PredatorResources.instance.CELTIC2);
            default:
                return Draw.getPath(PredatorResources.instance.CELTIC1);
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
        if (ClientGame.instance.minecraft().inGameHasFocus)
        {
            ItemStack helmSlot = Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player);

            if (helmSlot != null && helmSlot.getItem() == PredatorItems.BIOMASK_CELTIC && KeybindHandler.instance.genericSpecial.isPressed() && Keyboard.getEventKeyState())
            {
                PredatorSounds.YAUTJA_VISION_SWITCH.playSound(ClientGame.instance.minecraft().player, 1F, 1F);
                VisionModeRenderEvent.instance.switchMode();
            }
        }
    }
}
