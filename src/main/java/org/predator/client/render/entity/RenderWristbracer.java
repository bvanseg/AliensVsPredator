package org.predator.client.render.entity;

import com.asx.mdx.lib.client.util.Color;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.predator.client.model.entity.ModelPlasma;
import org.predator.client.model.item.ModelWristBlade;
import org.predator.common.entity.EntityWristbracer;

public class RenderWristbracer extends Render<EntityWristbracer>
{
    private final MapModelTexture<ModelWristBlade> wristbracer = AVP.resources().models().WRISTBLADES.clone();
    private final ModelPlasma model       = new ModelPlasma();
    private float                                rotation;
    private float                                rotationPrev;
    private float                                scale;
    private float                                scalePrev;

    public RenderWristbracer(RenderManager m)
    {
        super(m);
        this.model.setColor(new Color(0.5F, 0.6F, 1F, 0.4F));
    }

    @Override
    public void doRender(EntityWristbracer entity, double posX, double posY, double posZ, float yaw, float partialTicks)
    {
        EntityWristbracer nuke = (EntityWristbracer) entity;

        rotationPrev = rotation;
        rotation = nuke.ticksExisted % 360;
        rotation = rotationPrev + (rotation - rotationPrev) * partialTicks;
        scalePrev = scale;
        scale = nuke.getPostInitTicks() * 200 / nuke.getPostInitTicksMax();
        scale = scalePrev + (scale - scalePrev) * partialTicks;

        OpenGL.pushMatrix();
        {
            OpenGL.translate(posX - 0.125F, posY + 0.15F, posZ + 0.05F);
            OpenGL.rotate(180F, 1F, 0F, 0F);
            wristbracer.draw();
            OpenGL.rotate(entity.rotationYaw - 90.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(entity.rotationPitch - 90.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.scale(scale, scale, scale);

            if (nuke.getPostInitTicks() > 1)
            {
                OpenGL.pushMatrix();
                {
                    OpenGL.rotate(rotation, 0.0F, 1.0F, 0.0F);
                    this.model.setScale(0.1F);
                    this.model.render();

                    OpenGL.pushMatrix();
                    {
                        OpenGL.rotate(rotation * 1.5F, 0.0F, 1.0F, 0.0F);
                        this.model.setScale(0.2F);
                        this.model.render();

                        OpenGL.pushMatrix();
                        {
                            OpenGL.rotate(rotation * 1.5F, 0.0F, 1.0F, 0.0F);
                            this.model.setScale(0.3F);
                            this.model.render();

                            OpenGL.pushMatrix();
                            {
                                OpenGL.rotate(rotation * 1.5F, 0.0F, 1.0F, 0.0F);
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
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWristbracer entity)
    {
        return null;
    }
}
