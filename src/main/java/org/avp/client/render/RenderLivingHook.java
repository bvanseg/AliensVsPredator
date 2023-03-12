package org.avp.client.render;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import org.avp.client.render.tile.RenderMedpod;
import org.avp.client.render.util.EntityRenderTransforms;
import org.avp.common.entities.EntityMedpod;
import org.predator.client.render.RenderPlayerPlasmaCannon;

public class RenderLivingHook
{
    public static final RenderLivingHook instance           = new RenderLivingHook();
    public RenderLiving                  renderer           = new RenderLiving();
    public RenderPlayerPlasmaCannon renderplasmacannon = new RenderPlayerPlasmaCannon();

    @SubscribeEvent
    public void update(ClientTickEvent event)
    {
        renderplasmacannon.update(event, Game.minecraft(), Game.minecraft().world);
    }

    @SubscribeEvent
    public void renderHand(RenderHandEvent event)
    {
        renderplasmacannon.renderFirstPerson(event, event.getPartialTicks());
    }

    @SubscribeEvent
    public void entityRenderEventPre(RenderLivingEvent.Pre event)
    {
        if (event.getEntity() != null)
        {
            if (event.getEntity() instanceof EntityPlayer)
            {
                renderplasmacannon.render(event, Game.partialTicks());
            }

            if (event.getEntity().getRidingEntity() instanceof EntityMedpod)
            {
                event.setCanceled(true);
                renderer.render(event.getEntity(), event.getRenderer(), event.getX(), event.getY(), event.getZ(), Game.partialTicks());
            }
        }
    }

    @SubscribeEvent
    public void entityRenderEventPost(RenderLivingEvent.Post event)
    {
        if (event.getEntity() != null)
        {
            if (event.getEntity() instanceof EntityPlayer)
            {
                renderplasmacannon.render(event, Game.partialTicks());
            }

            if (event.getEntity().getRidingEntity() instanceof EntityMedpod)
            {
                event.setCanceled(true);
            }
        }
    }

    public RenderLiving getRenderer()
    {
        return renderer;
    }

    public class RenderLiving extends RenderLivingBase<EntityLivingBase>
    {
        private RenderLivingBase<EntityLivingBase> cache;

        public RenderLiving()
        {
            super(Game.renderManager(), null, 0F);
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
            float rotation = (float) medpod.getTileEntity().getDoorProgress() * 45 / medpod.getTileEntity().getMaxDoorProgress();

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
