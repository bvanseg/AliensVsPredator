package org.avp.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped.ArmPose;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import org.avp.AVP;
import org.avp.client.model.entity.living.ModelMarine;
import org.avp.common.entity.living.EntityMarine;

public class RenderMarine extends RenderLivingWrapper<EntityMarine, ModelMarine>
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
            if (this.livingEntityRenderer instanceof RenderLivingWrapper && living instanceof EntityMarine)
            {
                EntityMarine marine = (EntityMarine) living;
                RenderLivingWrapper<EntityMarine, ModelMarine> renderer = (RenderLivingWrapper<EntityMarine, ModelMarine>) this.livingEntityRenderer;

                if (stack != null)
                {
                    GlStateManager.pushMatrix();

                    if (living.isSneaking())
                    {
                        GlStateManager.translate(0.0F, 0.2F, 0.0F);
                    }

                    if (marine.isAiming())
                    {
                        renderer.getModel().getModel().leftArmPose = ArmPose.BOW_AND_ARROW;
                    }
                    else
                    {
                        renderer.getModel().getModel().leftArmPose = ArmPose.EMPTY;
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

    public RenderMarine(RenderManager m)
    {
        super(m, AVP.resources().models().MARINE);
        this.addLayer(new LayerHeldGun(this));
    }

    @Override
    protected void preRenderCallback(EntityMarine living, float partialTicks)
    {
        super.preRenderCallback(living, partialTicks);
    }
}
