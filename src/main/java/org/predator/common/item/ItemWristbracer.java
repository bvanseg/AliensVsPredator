package org.predator.common.item;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPMaterials;
import org.avp.common.network.packet.server.PacketSpawnNuke;
import org.predator.client.PredatorSounds;
import org.predator.common.PredatorItems;
import org.predator.common.inventory.ContainerWristbracer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemWristbracer extends HookedItem
{
    public static final String TAG_WRISTBRACER_ITEMS = "WristbracerItems";
    public static final String TAG_WRISTBRACER_ITEMS_SLOT = "Slot";

    private static final HashMap<String, IActionCode> codes = new HashMap<String, IActionCode>();

    public static interface IActionCode
    {
        public void onAction(String combonation, Object... args);
    }

    public static String code(int d1, int d2, int d3, int d4, int d5, int d6)
    {
        return String.format("%s%s%s%s%s%s", d1, d2, d3, d4, d5, d6);
    }

    public static IActionCode getAction(String combonation)
    {
        return codes.get(combonation);
    }

    public static boolean isCodeValid(String combonation)
    {
        return codes.get(combonation) != null;
    }

    public static void addCode(String combonation, IActionCode action)
    {
        if (!isCodeValid(combonation))
        {
            codes.put(combonation, action);
        }
    }
    
    static
    {
        addCode("009001", new IActionCode()
        {
            @Override
            public void onAction(String combonation, Object... args)
            {
                AVP.network().sendToServer(new PacketSpawnNuke());
                Game.minecraft().currentScreen = null;
            }
        });
    }
    
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if (equippedHasBlades(player))
        {
            PredatorSounds.WEAPON_WRISTBLADES.playSound(entity, 1.0F, 1.0F);
            entity.attackEntityFrom(AVPDamageSources.causeWristbracerDamage(player), getDamageToApply());

            if (!player.world.isRemote && !player.capabilities.isCreativeMode)
            {
                ItemStack bladesStack = getBlades(player.getHeldItemMainhand());
                NBTTagCompound nbt = player.getHeldItemMainhand().getTagCompound();
                NBTTagList wristbracerContents = nbt.getTagList(TAG_WRISTBRACER_ITEMS, Constants.NBT.TAG_COMPOUND);

                if (bladesStack != null && !player.world.isRemote)
                {
                    for (int s = 0; s < wristbracerContents.tagCount(); s++)
                    {
                        NBTTagCompound slot = wristbracerContents.getCompoundTagAt(s);
                        ItemStack slotstack = new ItemStack(slot);

                        if (slotstack != null && slotstack.getItem() == PredatorItems.ITEM_WRISTBRACER_BLADES)
                        {
                            wristbracerContents.removeTag(s);
                            bladesStack.writeToNBT(slot);
                            slot.setShort("Damage", (short) (bladesStack.getItemDamage() + 1));
                            slot.setByte(TAG_WRISTBRACER_ITEMS_SLOT, (byte) s);
                            wristbracerContents.appendTag(slot);
                            break;
                        }
                    }
                }

                nbt.setTag(TAG_WRISTBRACER_ITEMS, wristbracerContents);
                player.getHeldItemMainhand().setTagCompound(nbt);
                ((ContainerWristbracer) getNewContainer(player)).saveToNBT();
            }
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    public Container getNewContainer(EntityPlayer player)
    {
        return new ContainerWristbracer(player);
    }

    public static float getDamageToApply()
    {
        return AVPMaterials.Tools.CELTIC.getAttackDamage() * 1.5F;
    }

    public static ItemStack getBlades(ItemStack wristbracer)
    {
        return get(wristbracer, PredatorItems.ITEM_WRISTBRACER_BLADES);
    }

    public static ItemStack getPlasmaCannon(ItemStack wristbracer)
    {
        return get(wristbracer, PredatorItems.ITEM_PLASMA_CANNON);
    }

    public static ItemStack get(ItemStack wristbracer, Item item)
    {
        if (wristbracer != null && wristbracer.getTagCompound() != null)
        {
            NBTTagList contents = wristbracer.getTagCompound().getTagList(TAG_WRISTBRACER_ITEMS, Constants.NBT.TAG_COMPOUND);

            if (contents != null)
            {
                for (byte x = 0; x < contents.tagCount(); x++)
                {
                    NBTTagCompound itemTag = contents.getCompoundTagAt(x);
                    ItemStack stack = new ItemStack(itemTag);

                    if (stack != null && stack.getItem() == item)
                    {
                        return stack;
                    }
                }
            }
        }

        return null;
    }

    public static boolean equippedHasBlades(EntityPlayer player)
    {
        return hasBlades(currentWristbracer(player));
    }
    
    public static boolean hasBlades(ItemStack wristbracer)
    {
        return getBlades(wristbracer) != null;
    }
    
    public static boolean hasPlasmaCannon(ItemStack wristbracer)
    {
        return getPlasmaCannon(wristbracer) != null;
    }
    
    public static boolean hasWristbracer(EntityPlayer player)
    {
        return wristbracer(player) != null;
    }

    public static ItemStack currentWristbracer(EntityPlayer player)
    {
        if (player.getHeldItemMainhand() != null)
        {
            if (player.getHeldItemMainhand().getItem() instanceof ItemWristbracer)
            {
                return player.getHeldItemMainhand();
            }
        }

        return null;
    }
    
    public static ItemStack wristbracer(EntityPlayer player)
    {
        ArrayList<ItemStack> stacks = wristbracers(player);
        return stacks.size() > 0 ? stacks.get(0) : null;
    }
    
    public static ArrayList<ItemStack> wristbracers(EntityPlayer player)
    {
        ArrayList<ItemStack> wristbracers = new ArrayList<ItemStack>();
        
        for (ItemStack stack : player.inventory.mainInventory)
        {
            if (stack != null && stack.getItem() instanceof ItemWristbracer)
            {
                wristbracers.add(stack);
            }
        }
        
        return wristbracers;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        String descriptionKey = String.format("%s.desc", this.getTranslationKey());
        
        if (descriptionKey != null)
        {
            String formatted = I18n.format(descriptionKey, getDamageToApply());
            String[] lines = formatted.split("/n");

            for (String line : lines)
            {
                tooltip.add(line);
            }
        }
    }
}
