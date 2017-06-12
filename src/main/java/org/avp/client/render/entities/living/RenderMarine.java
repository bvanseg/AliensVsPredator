package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelMarine;
import org.avp.entities.living.EntityMarine;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMarine extends RenderLivingWrapper<EntityMarine, ModelMarine>
{
    public RenderMarine(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().MARINE);
    }

    @Override
    protected void preRenderCallback(EntityMarine living, float partialTicks)
    {
        super.preRenderCallback(living, partialTicks);
    }
    
    protected void renderEquippedItems(EntityMarine living, float partialTicks)
    {
        //super.renderEquippedItems(living, partialTicks);

        EntityMarine marine = (EntityMarine) living;
        TexturedModel<? extends Model> model = marine.getMarineType().getFirearmModelTexMap();

        OpenGL.pushMatrix();
        {
            this.getModel().getModel().bipedRightArm.postRender(Model.DEFAULT_SCALE);
            if (marine.isFiring())
            {
                this.getModel().getModel().aimedBow = true;
            }
            else
            {
                this.getModel().getModel().aimedBow = false;
            }
            OpenGL.translate(-0.35F, 0.8F, -0.85F);
            OpenGL.rotate(270.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(0.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.scale(1.2F, 1.2F, 1.2F);
            OpenGL.disable(GL11.GL_CULL_FACE);

            switch (marine.getMarineType())
            {
                case AK47:
                    OpenGL.translate(-0.35F, 0.45F, -0.55F);
                    break;
                case SNIPER:
                    OpenGL.translate(-0.25F, 0.45F, 0.05F);
                    break;
                case M56SG:
                    OpenGL.translate(-0.15F, 0.7F, -0.73F);
                    this.getModel().getModel().aimedBow = false;
                    break;
                default:
                    break;
            }

            model.draw();
        }
        OpenGL.popMatrix();
    }
}
