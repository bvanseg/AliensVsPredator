package org.avp.common.api.client.render;



import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public interface FirearmModel
{
    ModelRenderer[] getBarrel();
    
    ModelRenderer[] getAction();
    
    ModelRenderer[] getStock();
    
    ModelRenderer[] getScope();
    
    ModelRenderer[] getPeripherals();
    
    ModelRenderer[] getAccessories();
}
