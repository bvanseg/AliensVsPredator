package org.power.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.avp.client.render.item.util.ModuleModelGroup;
import org.avp.common.item.ItemNetworkRackModule;
import org.power.common.tile.TileEntityNetworkRack;

public class RenderNetworkRack extends TileEntitySpecialRenderer<TileEntityNetworkRack>
{
    @Override
    public void render(TileEntityNetworkRack rack, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        if (rack != null && rack.isParent())
        {
            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            GlStateManager.translate(x, y, z);
            float s = 1.0175F;
            float moduleScale = 0.94F;
            float slotSpacing = 0.715F;
            GlStateManager.scale(s, s, s);
            OpenGL.translate(0.5F, 1.5F, 0.5F);
            OpenGL.rotate(rack);
            OpenGL.translate(-0.5F - 0.365F, 0F, 0F);

            Resources.instance.models().NETWORKMODULERACK.draw();

            if (rack.isOperational())
            {
                OpenGL.disableLight();
                Resources.instance.models().NETWORKMODULERACK_ON.draw();
                OpenGL.enableLight();
            }
            else
            {
                Resources.instance.models().NETWORKMODULERACK_OFF.draw();
            }

            if (rack.inventory != null)
            {
                OpenGL.pushMatrix();
                OpenGL.scale(-1F, -1F, 1F);
                OpenGL.translate(-0.36F, -2.135F, -0.525F);

                for (int slot = rack.inventory.getSizeInventory(); slot >= 0; slot--)
                {
                    ItemStack moduleStack = rack.inventory.getStackInSlot(slot);

                    if (moduleStack != null)
                    {
                        if (moduleStack.getItem() instanceof ItemNetworkRackModule)
                        {
                            ItemNetworkRackModule module = (ItemNetworkRackModule) moduleStack.getItem();
                            OpenGL.pushMatrix();
                            OpenGL.translate(0, slotSpacing * (slot + 1), 0);
                            OpenGL.scale(moduleScale, moduleScale, moduleScale);
                            ModuleModelGroup moduleModelGroup = ModuleModelGroup.getModelsForVariant(module.variant);
                            moduleModelGroup.getBaseModel().draw();
                            
                            if (rack.isOperational())
                            {
                                OpenGL.disableLight();
                                moduleModelGroup.getOnModel().draw();
                                OpenGL.enableLight();
                            }
                            else
                            {
                                moduleModelGroup.getOffModel().draw();
                            }
                            
                            OpenGL.popMatrix();
                        }
                    }
                }
                OpenGL.popMatrix();
            }
            GlStateManager.enableCull();
            GlStateManager.popMatrix();
        }
    }
}
