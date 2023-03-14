package org.avp.common.api.client.render;



import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public interface IFirearmModel
{
    public ModelRenderer[] getBarrel();
    
    public ModelRenderer[] getAction();
    
    public ModelRenderer[] getStock();
    
    public ModelRenderer[] getScope();
    
    public ModelRenderer[] getPeripherals();
    
    public ModelRenderer[] getAccessories();
}
