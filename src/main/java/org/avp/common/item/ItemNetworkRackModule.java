package org.avp.common.item;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemNetworkRackModule extends HookedItem
{
    public ItemNetworkRackModule()
    {
        this.setMaxStackSize(1);
    }

    public NBTTagCompound writeToNBT()
    {
        NBTTagCompound tag = new NBTTagCompound();
        return tag;
    }

    public void readFromNBT() { /* Do Nothing */ }

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model<?>> getModel();

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model<?>> getModelOn();

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model<?>> getModelOff();
}
