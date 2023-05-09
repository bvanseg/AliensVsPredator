package org.avp.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.Model;
import com.asx.mdx.common.math.MDXMath;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.avp.client.render.util.EntityRenderTransforms;
import org.power.client.render.tile.RenderMedpod;
import org.power.common.entity.EntityMedpod;

public class RenderLivingHook
{
    public static final RenderLivingHook instance = new RenderLivingHook();

    public static final RenderLiving renderer = new RenderLiving();

    public RenderLiving getRenderer()
    {
        return renderer;
    }

    public static class RenderLiving extends RenderLivingBase<EntityLivingBase>
    {
        private RenderLivingBase<EntityLivingBase> cache;

        public RenderLiving()
        {
            super(ClientGame.instance.renderManager(), null, 0F);
        }

        @Override
        protected ResourceLocation getEntityTexture(EntityLivingBase entity)
        {
            ResourceLocation resource = Entities.getEntityTexture(this.cache, entity);

            if (entity instanceof AbstractClientPlayer)
            {
                resource = ((AbstractClientPlayer) entity).getLocationSkin();
            }

            return resource;
        }

        public void render(EntityLivingBase entity, RenderLivingBase<EntityLivingBase> renderer, double posX, double posY, double posZ, float partialTicks)
        {
            EntityMedpod medpod = (EntityMedpod) entity.getRidingEntity();

            if (this.cache != renderer)
            {
                this.cache = renderer;
                this.mainModel = Model.getMainModel(renderer);
            }

            OpenGL.pushMatrix();
            {
                float rotationYaw = MDXMath.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
                float rotationYawHead = MDXMath.interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
                float rotationPitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
                float idleProgress = entity.ticksExisted + partialTicks;
                float swingProgressPrev = entity.prevLimbSwingAmount + (entity.limbSwingAmount - entity.prevLimbSwingAmount) * partialTicks;
                float swingProgress = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks);

                if (entity.isChild())
                {
                    swingProgress *= 3.0F;
                }

                if (swingProgressPrev > 1.0F)
                {
                    swingProgressPrev = 1.0F;
                }

                this.mainModel.swingProgress = this.getSwingProgress(entity, partialTicks);
                this.mainModel.isRiding = false;
                this.mainModel.isChild = entity.isChild();
                
                OpenGL.enableBlend();
                OpenGL.blendClear();
                OpenGL.translate(posX, posY, posZ);
                this.transformEntity(medpod, entity, partialTicks);
                this.mainModel.setLivingAnimations(entity, swingProgress, swingProgressPrev, partialTicks);
                Draw.bindTexture(this.getEntityTexture(entity));
                this.mainModel.render(entity, swingProgress, swingProgressPrev, idleProgress, rotationYawHead - rotationYaw, rotationPitch, Model.DEFAULT_SCALE);
                OpenGL.disableBlend();
            }
            OpenGL.popMatrix();
        }

        @Deprecated
        protected void renderModel(EntityLivingBase entity, float swingProgress, float swingProgressPrev, float idleProgress, float rotationYawHead, float rotationPitch, float DEFAULT_SCALE)
        {
            this.mainModel.setRotationAngles(swingProgress, swingProgressPrev, idleProgress, rotationYawHead, rotationPitch, DEFAULT_SCALE, entity);
        }

        public void transformEntity(EntityMedpod medpod, Entity inMedpod, float partialTicks)
        {
            float rotation = medpod.getTileEntity().getDoorProgress() * 45 / medpod.getTileEntity().getMaxDoorProgress();

            OpenGL.rotate(medpod.getTileEntity());
            OpenGL.scale(-1.0F, -1.0F, 1.0F);

            for (EntityRenderTransforms transform : RenderMedpod.transforms)
            {
                if (transform.isApplicable(inMedpod))
                {
                    transform.pre(inMedpod, partialTicks);
                    break;
                }
            }
            
            OpenGL.translate(0.0F, -24.0F * Model.DEFAULT_SCALE + 1.5F, 0.0F);
            OpenGL.rotate(rotation - 90F, 1F, 0F, 0F);
            
            for (EntityRenderTransforms transform : RenderMedpod.transforms)
            {
                if (transform.isApplicable(inMedpod))
                {
                    transform.post(inMedpod, partialTicks);
                    break;
                }
            }
        }
    }
}
