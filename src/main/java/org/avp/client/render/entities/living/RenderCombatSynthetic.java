package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.model.SpecialModelBiped;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import org.avp.AVP;
import org.avp.common.entities.living.EntityCombatSynthetic;

public class RenderCombatSynthetic extends RenderLivingWrapper<EntityCombatSynthetic, SpecialModelBiped>
{
    public static class LayerHeldGun extends LayerHeldItem
    {
        public LayerHeldGun(RenderLivingBase<?> livingEntityRendererIn)
        {
            super(livingEntityRendererIn);
        }

        @Override
        public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
        {
            boolean flag = entitylivingbaseIn.getPrimaryHand() == EnumHandSide.RIGHT;
            ItemStack itemstack = flag ? entitylivingbaseIn.getHeldItemOffhand() : entitylivingbaseIn.getHeldItemMainhand();
            ItemStack itemstack1 = flag ? entitylivingbaseIn.getHeldItemMainhand() : entitylivingbaseIn.getHeldItemOffhand();

            if (itemstack != null || itemstack1 != null)
            {
                GlStateManager.pushMatrix();

                if (this.livingEntityRenderer.getMainModel().isChild)
                {
                    GlStateManager.translate(0.0F, 0.625F, 0.0F);
                    GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
                    GlStateManager.scale(0.5F, 0.5F, 0.5F);
                }

                this.renderHeldItem(entitylivingbaseIn, itemstack1, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
                this.renderHeldItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
                GlStateManager.popMatrix();
            }
        }

        private void renderHeldItem(EntityLivingBase living, ItemStack stack, ItemCameraTransforms.TransformType transformType, EnumHandSide handSide)
        {
            if (this.livingEntityRenderer instanceof RenderLivingWrapper && living instanceof EntityCombatSynthetic)
            {
                EntityCombatSynthetic synthetic = (EntityCombatSynthetic) living;
                RenderLivingWrapper<EntityCombatSynthetic, SpecialModelBiped> renderer = (RenderLivingWrapper<EntityCombatSynthetic, SpecialModelBiped>) this.livingEntityRenderer;

                if (stack != null)
                {
                    GlStateManager.pushMatrix();

                    if (living.isSneaking())
                    {
                        GlStateManager.translate(0.0F, 0.2F, 0.0F);
                    }

                    if (synthetic.isAiming())
                    {
                        renderer.getModel().getModel().aimedBow = true;
                    }
                    else
                    {
                        renderer.getModel().getModel().aimedBow = false;
                    }

                    renderer.getModel().getModel().postRenderArm(0.0625F, handSide);
                    GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
                    GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                    boolean flag = handSide == EnumHandSide.LEFT;
                    GlStateManager.translate((float) (flag ? -1 : 1) / 16.0F, 0.125F, -0.625F);
                    Minecraft.getMinecraft().getItemRenderer().renderItemSide(living, stack, transformType, flag);
                    GlStateManager.popMatrix();
                }
            }
        }
    }
    
    public RenderCombatSynthetic(RenderManager m)
    {
        super(m, AVP.resources().models().COMBAT_SYNTHETIC);
        this.addLayer(new LayerHeldGun(this));
    }

    @Override
    protected void preRenderCallback(EntityCombatSynthetic base, float partialTicks)
    {
        super.preRenderCallback(base, partialTicks);
    }
    
    //TODO: FIX
    protected void renderEquippedItems(EntityCombatSynthetic entityLiving, float partialTicks)
    {
        //super.renderEquippedItems(entityLiving, partialTicks);

        float glScale = 1.2F;

        if (this.mainModel != null && this.mainModel instanceof SpecialModelBiped)
        {
            SpecialModelBiped model = (SpecialModelBiped) this.mainModel;

            OpenGL.pushMatrix();
            {
                model.aimedBow = true;
                model.bipedRightArm.postRender(Model.DEFAULT_SCALE);
                OpenGL.translate(-0.35F, 0.8F, -0.85F);
                OpenGL.rotate(270.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(0.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.disableCull();
                OpenGL.scale(glScale, glScale, glScale);
                AVP.resources().models().M41A.draw();
            }
            OpenGL.popMatrix();
        }
    }
}
