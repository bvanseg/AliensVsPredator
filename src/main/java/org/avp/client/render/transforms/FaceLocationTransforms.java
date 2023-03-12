package org.avp.client.render.transforms;

import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.entity.Entity;
import org.alien.client.render.entity.living.RenderFacehuggers;
import org.avp.client.render.util.EntityRenderTransforms;
import org.avp.common.entities.living.EntityCombatSynthetic;
import org.avp.common.entities.living.EntityMarine;
import org.predator.common.entity.living.SpeciesYautja;
import org.alien.common.entity.living.engineer.EntityEngineer;

public class FaceLocationTransforms
{
    public static void register()
    {
        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityCombatSynthetic.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.rotate(90.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, -0.2F, 0F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityEngineer.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.rotate(115.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, -0.2F, 0.2F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityMarine.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.rotate(90.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, -0.2F, 0F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(SpeciesYautja.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.rotate(110.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, 0F, 0.5F);
            }
        });
    }
}
