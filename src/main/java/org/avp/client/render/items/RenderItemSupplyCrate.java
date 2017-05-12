package org.avp.client.render.items;

import org.avp.client.model.entities.ModelSupplyChute;
import org.avp.item.ItemSupplyChute.SupplyChuteType;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.TexturedModel;
import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSupplyCrate extends ItemRenderer<ModelSupplyChute>
{
    public RenderItemSupplyCrate()
    {
        super(null);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.scale(-1F, 1F, 1F);
            OpenGL.rotate(90F, 0F, 0F, 1F);
            OpenGL.rotate(-45F, 0F, 1F, 0F);
            OpenGL.rotate(90F, 1F, 0F, 0F);
            OpenGL.translate(0F, -0.5F, -0.9F);
            OpenGL.disable(GL11.GL_CULL_FACE);

            TexturedModel<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
            texturedModel.bindTexture();
            texturedModel.getModel().drawCrate();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL11.GL_CULL_FACE);

            TexturedModel<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
            texturedModel.bindTexture();
            texturedModel.getModel().drawCrate();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.75F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, 0.75F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
//        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);

        TexturedModel<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
        texturedModel.bindTexture();
        texturedModel.getModel().drawCrate();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

        OpenGL.pushMatrix();
        {
            OpenGL.scale(1F, -1F, 1F);
            OpenGL.translate(0F, -1.5F, 0F);
            OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);

            TexturedModel<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
            texturedModel.bindTexture();
            texturedModel.getModel().drawCrate();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }
}
