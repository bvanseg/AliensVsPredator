package org.avp.common.item;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemNetworkRackModule extends HookedItem
{
    protected ItemNetworkRackModule()
    {
        this.setMaxStackSize(1);
    }

    public NBTTagCompound writeToNBT()
    {
        return new NBTTagCompound();
    }

    public void readFromNBT() { /* Do Nothing */ }

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model> getModel();

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model> getModelOn();

    @SideOnly(Side.CLIENT)
    public abstract MapModelTexture<Model> getModelOff();
}
