package org.avp.client.render.transforms;

import static org.lwjgl.opengl.GL11.GL_ALPHA_TEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;

import org.avp.AliensVsPredator;
import org.avp.client.render.tile.RenderCryostasisTube;
import org.avp.client.render.tile.RenderCryostasisTube.CryostasisEntityRenderer;
import org.avp.entities.living.EntityChestburster;
import org.avp.entities.living.EntityDrone;
import org.avp.entities.living.EntityFacehugger;
import org.avp.entities.living.EntityMatriarch;
import org.avp.entities.living.EntityOvamorph;
import org.avp.entities.living.EntityPraetorian;
import org.avp.entities.living.EntityXenomorph;
import org.avp.tile.TileEntityCryostasisTube;
import org.lwjgl.opengl.GL12;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.model.MapModelTexture;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.entity.Entity;

public class CryostasisTubeRenderers
{
    public static void register()
    {
        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityChestburster.class) {
            @Override
            public boolean isApplicable(Entity entity)
            {
                return entity instanceof EntityChestburster;
            }

            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null)
                {
                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.translate(0F, -0.5F, 0F);
                    OpenGL.rotate(90F, 1F, 0F, 0F);
                    Game.renderManager().renderEntity(tile.stasisEntity, 0, 0, 0, 0F, Game.partialTicks(), false);
                }
            }
        });

        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityFacehugger.class) {
            @Override
            public boolean isApplicable(Entity entity)
            {
                return entity instanceof EntityFacehugger;
            }

            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null)
                {
                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.translate(0F, -0.5F, 0F);
                    OpenGL.rotate(90F, 1F, 0F, 0F);
                    Game.renderManager().renderEntity(tile.stasisEntity, 0, 0, 0, 0F, Game.partialTicks(), false);
                }
            }
        });

        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityOvamorph.class) {
            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null)
                {
                    OpenGL.scale(0.875F, 0.875F, 0.875F);
                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.translate(0F, 0.75F, 0F);
                    OpenGL.rotate(180F, 1F, 0F, 0F);
                    OpenGL.rotate(23.5F, 0F, 1F, 0F);
                    Game.renderManager().renderEntity(tile.stasisEntity, 0, 0, 0, 0F, Game.partialTicks(), false);
                }
            }
        });

        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityXenomorph.class) {
            @Override
            public boolean isApplicable(Entity entity)
            {
                return entity instanceof EntityXenomorph;
            }

            @Override
            public void renderChassis(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                OpenGL.disableCullFace();
                OpenGL.enableBlend();
                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
                OpenGL.translate(posX + 0.5F, posY + 1.7F, posZ + 0.5F);
                OpenGL.rotate(tile);
                OpenGL.enable(GL12.GL_RESCALE_NORMAL);
                OpenGL.scale(0.75F, -0.75F, 0.75F);
                OpenGL.enable(GL_ALPHA_TEST);
                OpenGL.scale(4, 3, 4);
                OpenGL.translate(0F, -0.75F, 0F);
                AliensVsPredator.resources().models().CRYOSTASIS_TUBE.draw();
                OpenGL.enableCullFace();
            }

            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null && !(tile.stasisEntity instanceof EntityMatriarch))
                {
                    double depth = tile.stasisEntity instanceof EntityPraetorian ? -1.95 : tile.stasisEntity instanceof EntityDrone ? -1.0 : -1.5F;

                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.scale(0.25, 0.25, 0.25);
                    OpenGL.translate(0F, -2.75F, depth);
                    OpenGL.translate(0F, 2F, 0F);
                    OpenGL.rotate(90F, 1F, 0F, 0F);
                    Game.renderManager().renderEntity(tile.stasisEntity, 0, 0, 0, 0F, Game.partialTicks(), false);

                }
                else if (tile.stasisEntity instanceof EntityMatriarch)
                {
                    OpenGL.disableLight();
                    OpenGL.scale(0.05, 0.05, 0.05);
                    OpenGL.translate(-3.25, -16, 0);
                    Draw.drawString("\u26A0", 0, 0, 0xFFFF0000, false);
                    OpenGL.enableLight();
                }
            }

            @Override
            public void renderTube(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                MapModelTexture<?> mask = null;

                if (tile.isShattered())
                {
                    mask = AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK_SHATTERED;
                }
                else if (tile.isCracked())
                {
                    mask = AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK_CRACKED;
                }
                else
                {
                    mask = AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK;
                }

                if (tile.getVoltage() > 0)
                {
                    OpenGL.disableLightMapping();
                    OpenGL.disableLight();
                }

                OpenGL.disableCullFace();
                mask.draw();
                OpenGL.scale(0.5, 0.5, 0.5);
                OpenGL.enableLightMapping();
                OpenGL.enableLight();
                OpenGL.enableCullFace();
            }
        });
    }
}
