package org.predator.client.render;

import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.client.event.RenderLivingEvent;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.client.render.LightmapUpdateEvent;
import org.predator.client.PredatorResources;

import static org.lwjgl.opengl.GL11.*;

public enum VisionMode
{
    NORMAL(0, "Normal", 0xFFFF0000)
    {
        @Override
        public void render(Object... data)
        {
            LightmapUpdateEvent.instance.gammaValue = 0F;
            Draw.drawOverlay(PredatorResources.instance.BLUR_CELTIC_HUD, 1F, 0F, 0F, 1F);
        }
    },
    ELECTROMAGNETIC(1, "Electromagnetic", 0xFF00FF00)
    {
        @Override
        public void render(Object... data)
        {
            OpenGL.pushMatrix();
            {
                OpenGL.enable(GL_BLEND);
                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
                OpenGL.blendFunc(GL_ONE_MINUS_DST_COLOR, GL_ZERO);
                OpenGL.disable(GL_ALPHA_TEST);
                PredatorResources.instance.BLUR_CELTIC_HUD.bind();
                OpenGL.color(0F, 1F, 0.1F, 0F);
                Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight(), 0, 0, 0, 0);
                OpenGL.color(0F, 1F, 0F, 1F);
                Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight(), 0, 0, 0, 0);
                OpenGL.enable(GL_ALPHA_TEST);
                OpenGL.disable(GL_BLEND);
                OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            }
            OpenGL.popMatrix();

            LightmapUpdateEvent.instance.gammaValue = LightmapUpdateEvent.instance.gammaValue < 0F ? LightmapUpdateEvent.instance.gammaValue + 0.03F : LightmapUpdateEvent.instance.gammaValue;
            Draw.drawOverlay(PredatorResources.instance.BLUR_CELTIC_HUD, 1F, 1F, 1F, 1F);
        }

        @Override
        public void renderEntityPre(RenderLivingEvent.Pre event)
        {
            if (isEntityTypeAllowed(event.getEntity()))
            {
                OpenGL.disableLight();
                OpenGL.disableLightMapping();
                OpenGL.color3i(0xFF00FF00);
            }
        }

        @Override
        public void renderEntityPost(RenderLivingEvent.Post event)
        {
            if (isEntityTypeAllowed(event.getEntity()))
            {
                OpenGL.enableLight();
                OpenGL.enableLightMapping();
            }
        }

        public boolean isEntityTypeAllowed(Entity entity)
        {
            Class<?>[] allowedEntityTypes = new Class<?>[] { SpeciesAlien.class, EntityEnderman.class, EntityDragon.class };

            for (Class<?> cls : allowedEntityTypes)
            {
                if (cls.isInstance(entity))
                {
                    return true;
                }
            }

            return false;
        }
    },
    THERMAL(2, "Thermal", 0xFFFF0000)
    {
        @Override
        public void render(Object... data)
        {
            OpenGL.pushMatrix();
            {
                OpenGL.enable(GL_BLEND);
                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
                OpenGL.blendFunc(GL_ONE_MINUS_DST_COLOR, GL_ZERO);
                OpenGL.disable(GL_ALPHA_TEST);
                PredatorResources.instance.BLUR_CELTIC_HUD.bind();
                OpenGL.color(1F, 1F, 0F, 0F);
                Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight(), 0, 0, 0, 0);
                OpenGL.color(1F, 1F, 0.45F, 0F);
                Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight(), 0, 0, 0, 0);
                OpenGL.enable(GL_ALPHA_TEST);
                OpenGL.disable(GL_BLEND);
                OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            }
            OpenGL.popMatrix();

            LightmapUpdateEvent.instance.gammaValue = LightmapUpdateEvent.instance.gammaValue < 0F ? LightmapUpdateEvent.instance.gammaValue + 0.03F : LightmapUpdateEvent.instance.gammaValue;
            Draw.drawOverlay(PredatorResources.instance.BLUR_CELTIC_HUD, 0F, 0.8F, 0.1F, 1F);
        }

        @Override
        public void renderEntityPre(RenderLivingEvent.Pre event)
        {
            if (event.getEntity().getCreatureAttribute() != EnumCreatureAttribute.UNDEAD && !(event.getEntity() instanceof SpeciesXenomorph))
            {
                OpenGL.disableLight();
                OpenGL.disableLightMapping();
                OpenGL.color3i(0xFFFF0000);
            }
        }

        @Override
        public void renderEntityPost(RenderLivingEvent.Post event)
        {
            if (event.getEntity().getCreatureAttribute() != EnumCreatureAttribute.UNDEAD)
            {
                OpenGL.enableLight();
                OpenGL.enableLightMapping();
                OpenGL.blendClear();
            }
        }
    };

    protected int id, color;
    public String modeName;

    VisionMode(int id, String modeName, int statusColor)
    {
        this.id = id;
        this.modeName = modeName;
        this.color = statusColor;
    }

    public static VisionMode get(int id)
    {
        return VisionMode.values()[id];
    }

    public abstract void render(Object... data);

    public void renderEntityPre(RenderLivingEvent.Pre event) { /* Do nothing */ }

    public void renderEntityPost(RenderLivingEvent.Post event) { /* Do nothing */ }
}
