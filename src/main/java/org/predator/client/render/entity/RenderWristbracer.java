package org.predator.client.render.entity;

import com.asx.mdx.client.Color;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.MapModelTexture;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.client.Resources;
import org.predator.client.model.entity.ModelPlasma;
import org.predator.client.model.item.ModelWristBlade;
import org.predator.common.entity.EntityWristbracer;

public class RenderWristbracer extends Render<EntityWristbracer>
{
    private final MapModelTexture<ModelWristBlade> wristbracer = Resources.instance.models().WRISTBLADES.clone();
    private final ModelPlasma model = new ModelPlasma();
    private float rotation;
    private float scale;

    public RenderWristbracer(RenderManager m)
    {
        super(m);
        this.model.setColor(new Color(0.5F, 0.6F, 1F, 0.4F));
    }

    @Override
    public void doRender(EntityWristbracer entity, double posX, double posY, double posZ, float yaw, float partialTicks)
    {
        float rotationPrev = this.rotation;
        this.rotation = entity.ticksExisted % 360;
        this.rotation = rotationPrev + (this.rotation - rotationPrev) * partialTicks;

        OpenGL.pushMatrix();
        {
            OpenGL.translate(posX - 0.125F, posY + 0.15F, posZ + 0.05F);
            OpenGL.rotate(180F, 1F, 0F, 0F);
            this.wristbracer.draw();

            if (entity.ticksExisted > EntityWristbracer.DETONATION_START_TIME_IN_TICKS)
            {
                this.renderExplosiveWave(entity, partialTicks);
            }
        }
        OpenGL.popMatrix();
    }

    private void renderExplosiveWave(EntityWristbracer entity, float partialTicks) {
        // Set scale based on detonation progress.
        float scalePrev = this.scale;
        this.scale = scalePrev + (((entity.getPostDetonateTicks() * 200F) / 10) - scalePrev) * partialTicks;
        OpenGL.rotate(entity.rotationYaw - 90.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(entity.rotationPitch - 90.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.scale(this.scale, this.scale, this.scale);

        // Render multiple waves nested within one another.
        OpenGL.pushMatrix();
        {
            OpenGL.rotate(this.rotation, 0.0F, 1.0F, 0.0F);
            this.model.setScale(0.1F);
            this.model.render();

            OpenGL.pushMatrix();
            {
                OpenGL.rotate(this.rotation * 1.5F, 0.0F, 1.0F, 0.0F);
                this.model.setScale(0.2F);
                this.model.render();

                OpenGL.pushMatrix();
                {
                    OpenGL.rotate(this.rotation * 1.5F, 0.0F, 1.0F, 0.0F);
                    this.model.setScale(0.3F);
                    this.model.render();

                    OpenGL.pushMatrix();
                    {
                        OpenGL.rotate(this.rotation * 1.5F, 0.0F, 1.0F, 0.0F);
                        this.model.setScale(0.35F);
                        this.model.render();
                    }
                    OpenGL.popMatrix();
                }
                OpenGL.popMatrix();
            }
            OpenGL.popMatrix();
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWristbracer entity)
    {
        return null;
    }
}
