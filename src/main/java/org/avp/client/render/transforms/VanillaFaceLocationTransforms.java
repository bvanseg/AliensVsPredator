package org.avp.client.render.transforms;

import org.avp.client.render.entities.living.RenderFacehuggers;
import org.avp.client.render.util.EntityRenderTransforms;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;

public class VanillaFaceLocationTransforms
{
    public static void register()
    {
        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityVillager.class, EntityWitch.class)
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
                OpenGL.translate(0F, -0.1F, 0.15F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityPlayer.class, EntityPigZombie.class, EntityZombie.class)
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

                if (entity.getRidingEntity()instanceof EntityZombie)
                {
                    EntityZombie zombie = (EntityZombie) entity.getRidingEntity();

                    if (zombie.isChild())
                    {
                        OpenGL.translate(0F, 0F, 0.85F);
                    }
                }
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityPlayerSP.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                EntityPlayerSP player = (EntityPlayerSP) entity.getRidingEntity();
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.rotate(90.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, -0.0F, 2.05F);
                OpenGL.rotate(-player.rotationPitch, 1, 0, 0);
                OpenGL.translate(0F, -0.1F, -0.15F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityCow.class, EntityMooshroom.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(-110.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(5F, 1F, 0F, 0F);
                OpenGL.translate(0F, -0.8F, -0.15F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityPig.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(-100.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(5F, 1F, 0F, 0F);
                OpenGL.translate(0F, -0.85F, 0.25F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityHorse.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(-137.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.translate(0F, -0.6F, -1.1F);
            }
        });
        
        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityLlama.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(-105.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.translate(0F, -1.1F, -0.95F);
            }
        });
        
        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityDonkey.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                OpenGL.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(-130.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.translate(0F, -0.55F, -1.05F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityCreeper.class)
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
                OpenGL.translate(0F, -0.1F, -0.05F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntitySkeleton.class)
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
                OpenGL.translate(0F, -0.1F, -0.1F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntitySpider.class)
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
                OpenGL.translate(0F, -0.60F, 0.45F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntitySlime.class, EntityMagmaCube.class)
        {
            @Override
            public void pre(Entity entity, float partialTicks)
            {
                ;
            }

            @Override
            public void post(Entity entity, float partialTicks)
            {
                EntitySlime slime = (EntitySlime) entity.getRidingEntity();
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.rotate(90.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, slime.getSlimeSize() * -0.25F, 0.75F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityGhast.class)
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
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityEnderman.class)
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
                OpenGL.translate(0F, -0.1F, 0.0F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityCaveSpider.class)
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
                OpenGL.translate(0F, -0.3F, 0.4F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntitySilverfish.class)
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
                OpenGL.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.rotate(-30.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.translate(0F, 0.7F, 0.55F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityBlaze.class)
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
                OpenGL.translate(0F, -0.15F, 0.25F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityBat.class)
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
                OpenGL.translate(0F, 0.1F, 0.1F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntitySheep.class)
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
                OpenGL.translate(0F, -0.8F, 0.25F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityChicken.class)
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
                OpenGL.rotate(50.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, -0.3F, -0.45F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntitySquid.class)
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
                OpenGL.rotate(270.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, -0.7F, 0.55F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityWolf.class)
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
                OpenGL.rotate(140.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, -0.37F, 0.55F);
            }
        });

        RenderFacehuggers.transforms.add(new EntityRenderTransforms(EntityOcelot.class)
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
                OpenGL.translate(0F, -0.7F, 0.2F);
            }
        });
    }
}
