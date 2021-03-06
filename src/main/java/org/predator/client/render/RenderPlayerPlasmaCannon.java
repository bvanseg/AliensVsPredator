package org.predator.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.Color;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.common.math.MDXMath;
import com.asx.mdx.internal.MDX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import org.avp.client.Resources;
import org.avp.common.api.client.render.EventRenderer;
import org.avp.common.api.client.render.FirstPersonRenderer;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.Project;
import org.power.common.entity.EntityMedpod;
import org.predator.client.input.handler.InputHandlerPlasmaCannon;
import org.predator.client.model.entity.ModelPlasma;
import org.predator.client.model.item.ModelPlasmaCannon;
import org.predator.common.item.ItemWristbracer;

public class RenderPlayerPlasmaCannon implements EventRenderer, FirstPersonRenderer
{
    private static final MapModelTexture<ModelPlasmaCannon> MODEL              = Resources.instance.models().PLASMACANNON.clone();
    private static final MapModelTexture<ModelPlasmaCannon> MODEL_FIRST_PERSON = MODEL.clone();
    private static final ModelPlasma MODEL_PLASMA       = new ModelPlasma().setColor(new Color(0.3F, 0.6F, 1F, 0.7F));

    @Override
    public void update(Event event, Minecraft game, World world)
    {
        if (event instanceof ClientTickEvent)
        {
            ClientTickEvent cte = ((ClientTickEvent) event);

            if (cte.phase == Phase.START)
            {
            }

            if (cte.phase == Phase.END)
            {
            }
        }
    }

    @Override
    public void render(Event event, float partialTicks)
    {
        if (event instanceof RenderLivingEvent.Pre)
        {
            RenderLivingEvent.Pre pre = (RenderLivingEvent.Pre) event;

            if (pre.getEntity() instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) pre.getEntity();
                SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);

                if (!(player.getRidingEntity() instanceof EntityMedpod))
                {

                    if (ItemWristbracer.hasPlasmaCannon(ItemWristbracer.wristbracer(player)))
                    {
                        if (player.getName().equalsIgnoreCase(ClientGame.instance.minecraft().player.getName()))
                        {
                            float rotationYaw = MDXMath.interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, partialTicks);
                            float rotationYawHead = MDXMath.interpolateRotation(player.prevRotationYawHead, player.rotationYawHead, partialTicks);
                            float rotationPitch = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * partialTicks;
                            float idleProgress = player.ticksExisted + partialTicks;
                            float swingProgress = player.getSwingProgress(partialTicks);
                            float swingProgressPrev = player.prevSwingProgress;
                            float scale = 0.5F;

                            OpenGL.pushMatrix();
                            OpenGL.scale(scale, -scale, -scale);
                            OpenGL.rotate(rotationYaw, 0F, 1F, 0F);
                            float cannonHeight = player.getEyeHeight() > 1.6F ? 0F : 0.65F;
                            OpenGL.translate(-0.85F, -3.425F + cannonHeight, -0.85F);
                            OpenGL.rotate(-25F, 0F, 0F, 1F);
                            MODEL.bindTexture();
                            MODEL.getModel().render(player);
                            OpenGL.popMatrix();
                        }
                        else
                        {
                            float rotationYaw = MDXMath.interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, partialTicks);
                            float scale = 0.5F;

                            float offsetX = (float) player.posX - (float) ClientGame.instance.minecraft().player.posX;
                            float offsetY = (float) player.posY - (float) ClientGame.instance.minecraft().player.posY;
                            float offsetZ = (float) player.posZ - (float) ClientGame.instance.minecraft().player.posZ;

                            float offsetXPrev = (float) player.prevPosX - (float) ClientGame.instance.minecraft().player.prevPosX;
                            float offsetYPrev = (float) player.prevPosY - (float) ClientGame.instance.minecraft().player.prevPosY;
                            float offsetZPrev = (float) player.prevPosZ - (float) ClientGame.instance.minecraft().player.prevPosZ;

                            double averageX = MDXMath.interpolateRotation(offsetXPrev, offsetX, partialTicks);
                            double averageY = MDXMath.interpolateRotation(offsetYPrev, offsetY, partialTicks);
                            double averageZ = MDXMath.interpolateRotation(offsetZPrev, offsetZ, partialTicks);

                            OpenGL.pushMatrix();
                            OpenGL.translate(averageX, averageY, averageZ);
                            OpenGL.scale(scale, -scale, -scale);
                            OpenGL.rotate(rotationYaw, 0F, 1F, 0F);
                            float cannonHeight = player.getEyeHeight() > 1.6F ? 0F : 0.65F;
                            OpenGL.translate(-0.7F, -3.425F + cannonHeight, -0.6F);
                            MODEL.bindTexture();
                            MODEL.getModel().render(player);
                            OpenGL.popMatrix();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void renderFirstPerson(Event event, float partialTicks)
    {
        RenderHandEvent e = (RenderHandEvent) event;
        EntityLivingBase entity = ClientGame.instance.minecraft().player;
        EntityRenderer entityRenderer = ClientGame.instance.minecraft().entityRenderer;
        ItemRenderer ir = ClientGame.instance.minecraft().entityRenderer.itemRenderer;
        float rotationYawHead = MDXMath.interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
        float rotationPitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
        float equippedProgress = MDX.access().getEquippedProgressPrev() + (MDX.access().getEquippedProgress() - MDX.access().getEquippedProgressPrev()) * partialTicks;

        if (ItemWristbracer.hasPlasmaCannon(ItemWristbracer.wristbracer(ClientGame.instance.minecraft().player)))
        {
            if (ClientGame.instance.minecraft().gameSettings.thirdPersonView == 0)
            {
                if (MDX.access().getDebugViewDirection() <= 0)
                {
                    entityRenderer.enableLightmap();
                    GL11.glMatrixMode(GL11.GL_PROJECTION);
                    GL11.glLoadIdentity();

                    if (MDX.access().getCameraZoom() != 1.0D)
                    {
                        OpenGL.translate((float) MDX.access().getCameraYaw(), (float) (-MDX.access().getCameraPitch()), 0.0F);
                        GL11.glScaled(MDX.access().getCameraZoom(), MDX.access().getCameraZoom(), 1.0D);
                    }

                    Project.gluPerspective(MDX.access().getFOVModifier(partialTicks, false), (float) ClientGame.instance.minecraft().displayWidth / (float) ClientGame.instance.minecraft().displayHeight, 0.05F, MDX.access().getFarPlaneDistance() * 2.0F);

                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
                    GL11.glLoadIdentity();

                    if (ClientGame.instance.minecraft().gameSettings.viewBobbing)
                    {
                        MDX.access().setupViewBobbing(partialTicks);
                    }
                }

                OpenGL.pushMatrix();
                {
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                    OpenGL.rotate(rotationPitch, 1.0F, 0.0F, 0.0F);
                    OpenGL.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks, 0.0F, 1.0F, 0.0F);
                    OpenGL.enableStandardItemLighting();
                    OpenGL.popMatrix();
                    EntityPlayerSP entityplayersp = (EntityPlayerSP) entity;
                    float armPitch = entityplayersp.prevRenderArmPitch + (entityplayersp.renderArmPitch - entityplayersp.prevRenderArmPitch) * partialTicks;
                    float armYaw = entityplayersp.prevRenderArmYaw + (entityplayersp.renderArmYaw - entityplayersp.prevRenderArmYaw) * partialTicks;
                    OpenGL.rotate((entity.rotationPitch - armPitch) * 0.1F, 1.0F, 0.0F, 0.0F);
                    OpenGL.rotate((entity.rotationYaw - armYaw) * 0.1F, 0.0F, 1.0F, 0.0F);

                    OpenGL.pushMatrix();
                    {
                        float offset = 0.8F;
                        OpenGL.translate(0.8F * offset, -0.75F * offset - (1.0F - equippedProgress) * 0.6F, -0.9F * offset);
                        OpenGL.rotate(45.0F, 0.0F, 1.0F, 0.0F);
                        OpenGL.enable(GL12.GL_RESCALE_NORMAL);
                        OpenGL.translate(-1.0F, 3.6F, 3.5F);
                        OpenGL.rotate(120.0F, 0.0F, 0.0F, 1.0F);
                        OpenGL.rotate(200.0F, 1.0F, 0.0F, 0.0F);
                        OpenGL.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
                        OpenGL.scale(1.0F, 1.0F, 1.0F);
                        OpenGL.translate(5.6F, 0.0F, 0.0F);
                        float prescale = 2.0F;
                        OpenGL.scale(prescale, prescale, prescale);

                        float modelscale = 0.15F;
                        OpenGL.pushMatrix();
                        OpenGL.translate(0F, 0F, 0F);
                        OpenGL.scale(modelscale, modelscale, modelscale);
                        OpenGL.rotate(50F, 1F, 0F, 0F);
                        OpenGL.rotate(-70F, 0F, 0F, 1F);
                        OpenGL.rotate(45F, 1F, 0F, 0F);
                        OpenGL.translate(-0.1F, -3.95F, 1.25F);
                        // OpenGL.rotate(rotationYawHead, 0F, 1F, 0F);
                        // OpenGL.rotate(rotationPitch, 1F, 0F, 0F);
                        // OpenGL.translate(0F, 0F, -1F);
                        // OpenGL.enableLight();
                        MODEL_FIRST_PERSON.draw();

                        float rotation = (entity.world.getTotalWorldTime() + partialTicks) % 360;
                        double wave = Math.sin(rotation);

                        OpenGL.pushMatrix();
                        {
                            float pp = InputHandlerPlasmaCannon.instance.getChargeSize();
                            float aps = 0.25F;
                            float ps = aps - (aps / (1F + pp));
                            OpenGL.translate(0F, 0.025F, 0.1F - ps);
                            OpenGL.disableCullFace();

                            OpenGL.pushMatrix();
                            OpenGL.translate(wave * 0.005F, 0F, 0F);
                            OpenGL.rotate(rotation * 30, 1, 0, 0);
                            MODEL_PLASMA.setScale(ps / 2.75F);
                            MODEL_PLASMA.render();
                            OpenGL.popMatrix();

                            OpenGL.pushMatrix();
                            OpenGL.translate(wave * -0.005F, 0F, 0F);
                            OpenGL.rotate(rotation * -20, 1, 0, 0);
                            MODEL_PLASMA.setScale(ps / 2.25F);
                            MODEL_PLASMA.render();
                            OpenGL.popMatrix();

                            OpenGL.pushMatrix();
                            OpenGL.translate(wave * 0.005F, 0F, 0F);
                            OpenGL.rotate(rotation * 10, 1, 0, 0);
                            OpenGL.rotate(rotation, 1, 0, 0);
                            MODEL_PLASMA.setScale(ps / 2);
                            MODEL_PLASMA.render();
                            OpenGL.popMatrix();

                            OpenGL.pushMatrix();
                            OpenGL.translate(wave * -0.005F, 0F, 0F);
                            OpenGL.rotate(rotation * -5, 1, 0, 0);
                            OpenGL.rotate(rotation, 1, 0, 0);
                            MODEL_PLASMA.setScale(ps / 1.25F);
                            MODEL_PLASMA.render();
                            OpenGL.popMatrix();

                            OpenGL.pushMatrix();
                            OpenGL.enableCullFace();
                            OpenGL.translate(wave * 0.005F, 0F, 0F);
                            OpenGL.rotate(rotation * 5, 1, 0, 0);
                            OpenGL.rotate(rotation, 1, 0, 0);
                            MODEL_PLASMA.setScale(ps);
                            MODEL_PLASMA.render();
                            OpenGL.popMatrix();
                        }
                        OpenGL.popMatrix();
                    }
                    OpenGL.popMatrix();
                }
                OpenGL.popMatrix();

                entityRenderer.enableLightmap();
                OpenGL.blendClear();
            }
        }
    }
}
