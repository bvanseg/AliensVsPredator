package org.avp.client.render.transform;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import org.avp.client.render.tile.RenderMedpod;
import org.avp.client.render.util.EntityRenderTransforms;
import org.avp.common.entity.living.EntityMarine;
import org.predator.common.entity.living.SpeciesYautja;

public class MedpodTransforms
{
    public static void register()
    {
        RenderMedpod.transforms.add(new EntityRenderTransforms(EntityPlayerSP.class, EntityPlayerMP.class, EntityPlayerSP.class, EntityOtherPlayerMP.class, AbstractClientPlayer.class, EntityPlayer.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                OpenGL.translate(0.0F, -0.5F, 0.0F);
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.translate(0F, -0.5F, -0.4F);
            }
        });

        RenderMedpod.transforms.add(new EntityRenderTransforms(EntityAnimal.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(90F, 0F, 1F, 0F);
                OpenGL.rotate(-90F, 1F, 0F, 0F);
                OpenGL.translate(0F, -1F, 0F);
            }
        });

        RenderMedpod.transforms.add(new EntityRenderTransforms(EntityVillager.class, EntityMarine.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.translate(0.0F, -0.5F, -0.4F);
            }
        });

        RenderMedpod.transforms.add(new EntityRenderTransforms(SpeciesYautja.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.translate(0.0F, -0.275F, -0.4F);
                float scale = 0.925F;
                OpenGL.scale(scale, scale, scale);
            }
        });
    }
}
