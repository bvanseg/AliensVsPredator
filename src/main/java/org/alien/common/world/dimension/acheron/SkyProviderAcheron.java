package org.alien.common.world.dimension.acheron;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.Color;
import com.asx.mdx.client.io.resource.GameResources;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.event.EntityViewRenderEvent.RenderFogEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.AlienResources;
import org.alien.common.world.dimension.DimensionUtil;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class SkyProviderAcheron extends IRenderHandler
{
    public static final SkyProviderAcheron instance = new SkyProviderAcheron();
    
    protected Color skyColor       = new com.asx.mdx.client.Color(0.0F, 0.0F, 0.0F, 1F);
    protected Color cloudColor     = new com.asx.mdx.client.Color(0.03F, 0.03F, 0.05F, 0.8F);
    protected Color starColor      = new com.asx.mdx.client.Color(0.0F, 0.5F, 1.0F, 0.15F);
    private int     starGLCallList = GLAllocation.generateDisplayLists(3);

    public SkyProviderAcheron()
    {
        this.generateStars();
    }
    
    private static final float fogIntensityMin = 0.02F;
    private static final float fogIntensityMax = 0.075F;
    private static final float fogMult = 0.00005F;
    
    private float fogIntensity = fogIntensityMin;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void fogRenderEvent(RenderFogEvent event)
    {
        if (ClientGame.instance.minecraft().player.world.provider instanceof WorldProviderAcheron)
        {
            if (ClientGame.instance.minecraft().player.world.canSeeSky(ClientGame.instance.minecraft().player.getPosition()))
            {
                if (fogIntensity < 0.03F)
                {
                    fogIntensity += fogMult;
                }
            }
            else
            {
                if (fogIntensity > 0.01F)
                {
                    fogIntensity -= fogMult;
                }
            }
            
            GlStateManager.setFog(GlStateManager.FogMode.EXP);
            GlStateManager.setFogDensity(fogIntensity);
        }
    }

    @SideOnly(Side.CLIENT)
    private void generateStars()
    {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder vertexbuffer = tessellator.getBuffer();

        if (this.starGLCallList >= 0)
        {
            GLAllocation.deleteDisplayLists(this.starGLCallList);
            this.starGLCallList = -1;
        }

        this.starGLCallList = GLAllocation.generateDisplayLists(1);
        GlStateManager.pushMatrix();
        GlStateManager.glNewList(this.starGLCallList, 4864);
        this.renderStars(vertexbuffer);
        GlStateManager.glEndList();
        GlStateManager.popMatrix();

        this.starGLCallList += 1;
    }

    @SideOnly(Side.CLIENT)
    private void renderStars(BufferBuilder buffer)
    {
        Random random = new Random(10842L);
        buffer.begin(7, DefaultVertexFormats.POSITION);

        for (int i = 0; i < 1500; ++i)
        {
            double d0 = (double) (random.nextFloat() * 2.0F - 1.0F);
            double d1 = (double) (random.nextFloat() * 2.0F - 1.0F);
            double d2 = (double) (random.nextFloat() * 2.0F - 1.0F);
            double d3 = (double) (0.15F + random.nextFloat() * 0.1F);
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;

            if (d4 < 1.0D && d4 > 0.01D)
            {
                d4 = 1.0D / Math.sqrt(d4);
                d0 = d0 * d4;
                d1 = d1 * d4;
                d2 = d2 * d4;
                double d5 = d0 * 100.0D;
                double d6 = d1 * 100.0D;
                double d7 = d2 * 100.0D;
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = random.nextDouble() * Math.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for (int j = 0; j < 4; ++j)
                {
                    double d18 = (double) ((j & 2) - 1) * d3;
                    double d19 = (double) ((j + 1 & 2) - 1) * d3;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    buffer.pos(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }
        Tessellator.getInstance().draw();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void render(float renderPartialTicks, WorldClient world, Minecraft mc)
    {
        OpenGL.disable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        GL11.glDepthMask(false);
        GlStateManager.enableFog();
        GL11.glColor3f(skyColor.r, skyColor.g, skyColor.b);
        GlStateManager.disableFog();
        OpenGL.disable(GL11.GL_ALPHA_TEST);
        OpenGL.enableBlend();
        OpenGL.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGL.color(starColor.r, starColor.g, starColor.b, starColor.a);

        /** Render Stars **/
        this.renderStars(Tessellator.getInstance().getBuffer());

        OpenGL.enable(GL11.GL_TEXTURE_2D);
        OpenGL.blendFunc(GL11.GL_SRC_ALPHA, 1);

        OpenGL.pushMatrix();
        {
            float scale = 25.0F;
            OpenGL.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            OpenGL.rotate(world.getCelestialAngle(renderPartialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
            Draw.bindTexture(GameResources.SKY_SUN);
            Draw.startQuads();
            Draw.vertex(-scale, 150.0D, -scale, 0.0D, 0.0).endVertex();
            Draw.vertex(scale, 150.0D, -scale, 1.0D, 0.0D).endVertex();
            Draw.vertex(scale, 150.0D, scale, 1.0D, 1.0D).endVertex();
            Draw.vertex(-scale, 150.0D, scale, 0.0D, 1.0D).endVertex();
            Draw.tessellate();
        }
        OpenGL.popMatrix();

        OpenGL.pushMatrix();
        {
            float scale = 100.0F;
            OpenGL.translate(80F, 0F, 0F);
            OpenGL.rotate(DimensionUtil.calculateCelestialAngle(world.getWorldTime(), renderPartialTicks) * 360.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            OpenGL.rotate(DimensionUtil.calculateCelestialAngle(world.getWorldTime(), renderPartialTicks) * 30.0F, 10.0F, -6.0F, -20.0F);
            OpenGL.rotate(155F, 0.0F, 1.0F, 0.0F);
            Draw.bindTexture(AlienResources.instance.SKY_VARDA);
            Draw.startQuads();
            Draw.vertex(-scale, 150.0D, -scale, 0.0D, 0.0D).endVertex();
            Draw.vertex(scale, 150.0D, -scale, 1.0D, 0.0D).endVertex();
            Draw.vertex(scale, 150.0D, scale, 1.0D, 1.0D).endVertex();
            Draw.vertex(-scale, 150.0D, scale, 0.0D, 1.0D).endVertex();
            Draw.tessellate();
        }
        OpenGL.popMatrix();
        
        OpenGL.pushMatrix();
        {
            float scale = 450.0F;
            OpenGL.translate(30F, 0F, 0F);
            OpenGL.rotate(DimensionUtil.calculateCelestialAngle(world.getWorldTime(), renderPartialTicks) * 360.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            OpenGL.rotate(DimensionUtil.calculateCelestialAngle(world.getWorldTime(), renderPartialTicks) * 360.0F, 10.0F, -6.0F, -20.0F);
            OpenGL.rotate(135F, 0.0F, 1.0F, 0.0F);
            Draw.bindTexture(AlienResources.instance.SKY_CALPAMOS);
            Draw.startQuads();
            Draw.vertex(-scale, 150.0D, -scale, 0.0D, 0.0D).endVertex();
            Draw.vertex(scale, 150.0D, -scale, 1.0D, 0.0D).endVertex();
            Draw.vertex(scale, 150.0D, scale, 1.0D, 1.0D).endVertex();
            Draw.vertex(-scale, 150.0D, scale, 0.0D, 1.0D).endVertex();
            Draw.tessellate();
        }
        OpenGL.popMatrix();

        OpenGL.blendClear();
        OpenGL.enable(GL11.GL_ALPHA_TEST);
        OpenGL.enable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(true);

        if (ClientGame.instance.minecraft().gameSettings.shouldRenderClouds() >= 1)
        {
            OpenGL.pushMatrix();
            {
                if (ClientGame.instance.minecraft().gameSettings.fancyGraphics)
                {
                    OpenGL.enable(GL11.GL_FOG);
                }

                this.renderClouds(renderPartialTicks);
                OpenGL.disable(GL11.GL_FOG);
            }
            OpenGL.popMatrix();
        }
    }

    @SideOnly(Side.CLIENT)
    public void renderClouds(float renderPartialTicks)
    {
        for (int cloudPass = 1; cloudPass > 0; cloudPass--)
        {
            float relativeHeight = (float) (ClientGame.instance.minecraft().getRenderViewEntity().lastTickPosY + (ClientGame.instance.minecraft().getRenderViewEntity().posY - ClientGame.instance.minecraft().getRenderViewEntity().lastTickPosY) * renderPartialTicks);
            float cloudSpan = 10.0F;
            float cloudHeight = 12.0F * cloudPass;
            float cloudSpeed = 20;
            double time = ClientGame.instance.minecraft().world.getWorldTime() * cloudSpeed + renderPartialTicks;
            double viewX = (ClientGame.instance.minecraft().getRenderViewEntity().prevPosX + (ClientGame.instance.minecraft().getRenderViewEntity().posX - ClientGame.instance.minecraft().getRenderViewEntity().prevPosX) * renderPartialTicks + time * 0.029999999329447746D) / cloudSpan;
            double viewZ = (ClientGame.instance.minecraft().getRenderViewEntity().prevPosZ + (ClientGame.instance.minecraft().getRenderViewEntity().posZ - ClientGame.instance.minecraft().getRenderViewEntity().prevPosZ) * renderPartialTicks) / cloudSpan + 0.33000001311302185D;
            float cloudY = ClientGame.instance.minecraft().world.provider.getCloudHeight() - relativeHeight;
            viewX -= (MathHelper.floor(viewX / 2048.0D)) * 2048;
            viewZ -= (MathHelper.floor(viewZ / 2048.0D)) * 2048;
            float scaleUV = 0.00390625F;
            float offsetU = MathHelper.floor(viewX) * scaleUV;
            float offsetV = MathHelper.floor(viewZ) * scaleUV;
            byte dist = (byte) (ClientGame.instance.minecraft().gameSettings.renderDistanceChunks);
            byte cloudSections = 2;

            OpenGL.disableCullFace();
            Draw.bindTexture(AlienResources.instance.SKY_VARDA_CLOUDS);
            OpenGL.enableBlend();
            OpenGlHelper.glBlendFunc(GL11.GL_ONE_MINUS_DST_COLOR, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
            OpenGL.scale(cloudSpan, 1.0F, cloudSpan);

            for (int pass = 0; pass < 2; pass++)
            {
                if (pass == 0)
                {
                    GL11.glColorMask(false, false, false, false);
                }
                else
                {
                    GL11.glColorMask(true, true, true, true);
                }

                for (int x = -cloudSections + 1; x <= cloudSections; ++x)
                {
                    for (int z = -cloudSections + 1; z <= cloudSections; ++z)
                    {
                        float cloudU = x * dist;
                        float cloudV = z * dist;
                        float cloudX = cloudU - ((float) (viewX - MathHelper.floor(viewX)));
                        float cloudZ = cloudV - ((float) (viewZ - MathHelper.floor(viewZ)));

                        Draw.startQuads();

                        if (cloudY > -cloudHeight - 1.0F)
                        {
                            Draw.vertex(cloudX + 0.0F, cloudY + 0.0F, cloudZ + dist, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).color(cloudColor.r * 0.7F, cloudColor.g * 0.7F, cloudColor.b * 0.7F, cloudColor.a + 0.1F).normal(0.0F, -1.0F, 0.0F).endVertex();
                            Draw.vertex(cloudX + dist, cloudY + 0.0F, cloudZ + dist, (cloudU + dist) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).color(cloudColor.r * 0.7F, cloudColor.g * 0.7F, cloudColor.b * 0.7F, cloudColor.a + 0.1F).normal(0.0F, -1.0F, 0.0F).endVertex();
                            Draw.vertex(cloudX + dist, cloudY + 0.0F, cloudZ + 0.0F, (cloudU + dist) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).color(cloudColor.r * 0.7F, cloudColor.g * 0.7F, cloudColor.b * 0.7F, cloudColor.a + 0.1F).normal(0.0F, -1.0F, 0.0F).endVertex();
                            Draw.vertex(cloudX + 0.0F, cloudY + 0.0F, cloudZ + 0.0F, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).color(cloudColor.r * 0.7F, cloudColor.g * 0.7F, cloudColor.b * 0.7F, cloudColor.a + 0.1F).normal(0.0F, -1.0F, 0.0F).endVertex();
                        }

                        if (cloudY <= cloudHeight + 1.0F)
                        {
                            Draw.vertex(cloudX + 0.0F, cloudY + cloudHeight, cloudZ + dist, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).normal(0.0F, 1.0F, 0.0F).color(cloudColor.r, cloudColor.g, cloudColor.b, cloudColor.a + 0.15F).endVertex();
                            Draw.vertex(cloudX + dist, cloudY + cloudHeight, cloudZ + dist, (cloudU + dist) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).normal(0.0F, 1.0F, 0.0F).color(cloudColor.r, cloudColor.g, cloudColor.b, cloudColor.a + 0.15F).endVertex();
                            Draw.vertex(cloudX + dist, cloudY + cloudHeight, cloudZ + 0.0F, (cloudU + dist) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).normal(0.0F, 1.0F, 0.0F).color(cloudColor.r, cloudColor.g, cloudColor.b, cloudColor.a + 0.15F).endVertex();
                            Draw.vertex(cloudX + 0.0F, cloudY + cloudHeight, cloudZ + 0.0F, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).normal(0.0F, 1.0F, 0.0F).color(cloudColor.r, cloudColor.g, cloudColor.b, cloudColor.a + 0.15F).endVertex();
                        }

                        if (x > -1)
                        {
                            for (int size = 0; size < dist; ++size)
                            {
                                Draw.vertex(cloudX + size + 0.0F, cloudY + 0.0F, cloudZ + dist, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).normal(-1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                                Draw.vertex(cloudX + size + 0.0F, cloudY + cloudHeight, cloudZ + dist, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).normal(-1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                                Draw.vertex(cloudX + size + 0.0F, cloudY + cloudHeight, cloudZ + 0.0F, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).normal(-1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                                Draw.vertex(cloudX + size + 0.0F, cloudY + 0.0F, cloudZ + 0.0F, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).normal(-1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                            }
                        }

                        if (x <= 1)
                        {
                            for (int size = 0; size < dist; ++size)
                            {
                                Draw.vertex(cloudX + size + 1.0F, cloudY + 0.0F, cloudZ + dist, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).normal(1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                                Draw.vertex(cloudX + size + 1.0F, cloudY + cloudHeight, cloudZ + dist, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + dist) * scaleUV + offsetV).normal(1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                                Draw.vertex(cloudX + size + 1.0F, cloudY + cloudHeight, cloudZ + 0.0F, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).normal(1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                                Draw.vertex(cloudX + size + 1.0F, cloudY + 0.0F, cloudZ + 0.0F, (cloudU + size + 0.5F) * scaleUV + offsetU, (cloudV + 0.0F) * scaleUV + offsetV).normal(1.0F, 0.0F, 0.0F).color(cloudColor.r * 0.9F, cloudColor.g * 0.9F, cloudColor.b * 0.9F, cloudColor.a).endVertex();
                            }
                        }

                        if (z > -1)
                        {
                            for (int size = 0; size < dist; ++size)
                            {
                                Draw.vertex(cloudX + 0.0F, cloudY + cloudHeight, cloudZ + size + 0.0F, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, -1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                                Draw.vertex(cloudX + dist, cloudY + cloudHeight, cloudZ + size + 0.0F, (cloudU + dist) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, -1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                                Draw.vertex(cloudX + dist, cloudY + 0.0F, cloudZ + size + 0.0F, (cloudU + dist) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, -1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                                Draw.vertex(cloudX + 0.0F, cloudY + 0.0F, cloudZ + size + 0.0F, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, -1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                            }
                        }

                        if (z <= 1)
                        {
                            for (int size = 0; size < dist; ++size)
                            {
                                Draw.vertex(cloudX + 0.0F, cloudY + cloudHeight, cloudZ + size + 1.0F, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, 1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                                Draw.vertex(cloudX + dist, cloudY + cloudHeight, cloudZ + size + 1.0F, (cloudU + dist) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, 1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                                Draw.vertex(cloudX + dist, cloudY + 0.0F, cloudZ + size + 1.0F, (cloudU + dist) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, 1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                                Draw.vertex(cloudX + 0.0F, cloudY + 0.0F, cloudZ + size + 1.0F, (cloudU + 0.0F) * scaleUV + offsetU, (cloudV + size + 0.5F) * scaleUV + offsetV).normal(0.0F, 0.0F, 1.0F).color(cloudColor.r * 0.8F, cloudColor.g * 0.8F, cloudColor.b * 0.8F, 0.8F).endVertex();
                            }
                        }

                        Draw.tessellate();
                        ;
                    }
                }
            }

            OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            OpenGL.disable(GL11.GL_BLEND);
            OpenGL.enable(GL11.GL_CULL_FACE);
        }
    }
}
