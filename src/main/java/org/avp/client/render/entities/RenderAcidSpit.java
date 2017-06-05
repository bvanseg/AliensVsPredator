package org.avp.client.render.entities;

import org.avp.client.model.entities.ModelPlasma;

import com.arisux.mdx.lib.client.render.Color;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderAcidSpit extends Render
{
    private ModelPlasma model = new ModelPlasma();

    public RenderAcidSpit()
    {
        super(Game.renderManager());
        this.model.setColor(new Color(0.2F, 1.0F, 0.0F, 0.7F));
    }

    @Override
    public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        float rotation = 20;
        model.drawInternalVertices = false;
        OpenGL.pushMatrix();
        {
            OpenGL.translate(posX, posY, posZ);
            OpenGL.rotate(entity.rotationYaw - 90.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(entity.rotationPitch - 90.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.scale(0.1F, 0.4F, 0.1F);

            OpenGL.pushMatrix();
            {
                OpenGL.rotate(rotation, 0.0F, 1.0F, 0.0F);
                this.model.setScale(0.6F);
                this.model.render();

                OpenGL.pushMatrix();
                {
                    OpenGL.rotate(rotation, 0.0F, 1.0F, 0.0F);
                    this.model.setScale(0.7F);
                    this.model.render();

                    OpenGL.pushMatrix();
                    {
                        OpenGL.rotate(rotation, 0.0F, 1.0F, 0.0F);
                        this.model.setScale(0.8F);
                        this.model.render();

                        OpenGL.pushMatrix();
                        {
                            OpenGL.rotate(rotation, 0.0F, 1.0F, 0.0F);
                            this.model.setScale(0.9F);
                            this.model.render();

                            OpenGL.pushMatrix();
                            {
                                OpenGL.rotate(rotation, 0.0F, 1.0F, 0.0F);
                                this.model.setScale(1.0F);
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
            OpenGL.popMatrix();
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}
