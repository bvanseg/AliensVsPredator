package org.avp.client.render.entities.living;

import java.util.ArrayList;

import org.avp.client.model.entities.living.ModelFacehugger;
import org.avp.client.render.RenderLivingHook;
import org.avp.client.render.util.EntityRenderTransforms;
import org.avp.entities.EntityMedpod;
import org.avp.entities.living.EntityFacehugger;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class RenderFacehugger<T extends EntityFacehugger, MODEL extends ModelFacehugger> extends RenderLivingWrapper<T, MODEL>
{
    public static ArrayList<EntityRenderTransforms> transforms = new ArrayList<EntityRenderTransforms>();

    public RenderFacehugger(TexturedModel<MODEL> model)
    {
        super(model);
    }

    @Override
    public void doRender(T entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(T facehugger, float partialTicks)
    {
        this.scale(facehugger, 0.9F);

        if (facehugger != null && facehugger.getRidingEntity()== null)
        {
            if (facehugger.motionY > 0 || facehugger.motionY < -0.1)
            {
                OpenGL.rotate(-45F, 1, 0, 0);
            }
        }

        if (facehugger != null && facehugger.getRidingEntity()!= null && facehugger.getRidingEntity().getRidingEntity()!= null && facehugger.getRidingEntity().getRidingEntity()instanceof EntityMedpod)
        {
            Entity entity = facehugger.getRidingEntity();
            EntityMedpod medpod = (EntityMedpod) entity.getRidingEntity();

            OpenGL.rotate(medpod.getTileEntity());
            RenderLivingHook.instance.getRenderer().transformEntity(medpod, entity, partialTicks);
        }

        if (facehugger.getRidingEntity()!= null && facehugger.getRidingEntity()instanceof EntityLivingBase)
        {
            for (EntityRenderTransforms transform : transforms)
            {
                if (transform.isApplicable(facehugger.getRidingEntity()))
                {
                    transform.post(facehugger, partialTicks);
                    break;
                }
            }
        }
    }

    protected void scale(T facehugger, float glScale)
    {
        if (facehugger != null && !facehugger.isFertile() && facehugger.getRidingEntity()== null)
        {
            OpenGL.scale(1F, -1F, 1F);
            OpenGL.translate(0F, 0.25F, 0F);
        }

        OpenGL.scale(glScale, glScale, glScale);
    }
}
