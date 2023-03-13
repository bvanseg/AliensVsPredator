package org.alien.client.render.item;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.alien.client.model.tile.plant.ModelGroundFern;
import org.avp.AVP;
import org.avp.common.tile.plant.TileEntityGroundFern;
import org.lwjgl.opengl.GL11;

public class RenderItemGroundFern extends ItemRenderer<ModelGroundFern>
{
    public RenderItemGroundFern()
    {
        super(AVP.resources().models().GROUND_FERN);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 0.5F;
        OpenGL.scale(scale, -scale, scale);
        OpenGL.translate(0F, -1.5F, 0F);
        GL11.glDisable(GL11.GL_CULL_FACE);
        OpenGL.color(TileEntityGroundFern.STANDARD_1.r(), TileEntityGroundFern.STANDARD_1.g(), TileEntityGroundFern.STANDARD_1.b());
        this.getModel().draw();
        GL11.glEnable(GL11.GL_CULL_FACE);
        OpenGL.color(1F, 1F, 1F);
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 0.5F;
        OpenGL.translate(0.1F, 0.75F, 0F);
        OpenGL.scale(scale, scale, scale);
        OpenGL.rotate(200F, 0F, 0F, 1F);
        GlStateManager.disableCull();
        OpenGL.color(TileEntityGroundFern.STANDARD_1.r(), TileEntityGroundFern.STANDARD_1.g(), TileEntityGroundFern.STANDARD_1.b());
        this.getModel().draw();
        OpenGL.color(1F, 1F, 1F);
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.85F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.2F, 1.0F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(-80F, 1.0F, 0.0F, 0.0F);
        GL11.glDisable(GL11.GL_CULL_FACE);
        OpenGL.color(TileEntityGroundFern.STANDARD_1.r(), TileEntityGroundFern.STANDARD_1.g(), TileEntityGroundFern.STANDARD_1.b());
        this.getModel().draw();
        GL11.glEnable(GL11.GL_CULL_FACE);
        OpenGL.color(1F, 1F, 1F);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float s = 0.25F;
        OpenGL.scale(s, s, s);
        OpenGL.translate(0F, 1.5F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.color(TileEntityGroundFern.STANDARD_1.r(), TileEntityGroundFern.STANDARD_1.g(), TileEntityGroundFern.STANDARD_1.b());
        this.getModel().draw();
        OpenGL.color(1F, 1F, 1F);
    }
}
