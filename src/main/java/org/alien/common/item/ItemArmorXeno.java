package org.alien.common.item;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
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
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelDrone;
import org.alien.common.AlienItems;
import org.avp.common.AVPArmorMaterials;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;

/**
 * @author Ri5ux
 */
public class ItemArmorXeno extends ItemArmor
{
    @SideOnly(Side.CLIENT)
    public ModelDrone mainModel;

    public ItemArmorXeno(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AVPArmorMaterials.CHITIN, renderIndex, armorType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        if (slot == EntityEquipmentSlot.LEGS) {
            return Draw.getPath(AlienResources.XENO2);
        }
        return Draw.getPath(AlienResources.XENO1);
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
            return (helm.getItem() == AlienItems.HELM_XENO &&
                    chest.getItem() == AlienItems.PLATE_XENO &&
                    legs.getItem() == AlienItems.LEGS_XENO &&
                    boots.getItem() == AlienItems.BOOTS_XENO);
        }

        return false;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (!isPlayerWearingXenoArmorSet(player)) return;

        SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);

        if (world.isRemote)
        {
            this.controlledAbility(player, specialPlayer);
        }

        player.fallDistance = 0.0F;

        if (specialPlayer.canClimb() && player.collidedHorizontally)
        {
            player.motionY += 0.03F;
        }
    }

    @SideOnly(Side.CLIENT)
    public void controlledAbility(EntityPlayer player, SpecialPlayerImpl specialPlayer)
    {
        boolean canClimbPrev = specialPlayer.canClimb();

        if (ClientGame.instance.minecraft().gameSettings.keyBindJump.isPressed())
        {
            specialPlayer.setCanClimb(true);
        }
        else if (!ClientGame.instance.minecraft().gameSettings.keyBindJump.isPressed())
        {
            specialPlayer.setCanClimb(false);
        }

        if (canClimbPrev != specialPlayer.canClimb())
        {
            specialPlayer.syncWithServer(player);
        }
    }
}
