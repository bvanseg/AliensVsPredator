package org.avp.common.item;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.world.item.HookedItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemNetworkRackModule extends HookedItem
{
    public ItemNetworkRackModule()
    {
        this.setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    public NBTTagCompound writeToNBT()
    {
        NBTTagCompound tag = new NBTTagCompound();
        return tag;
    }

    public void readFromNBT()
    {
        ;
    }

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model<?>> getModel();

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model<?>> getModelOn();

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model<?>> getModelOff();
}
