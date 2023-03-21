package org.avp.client.render.tile;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.MapModelTexture;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.Resources;
import org.avp.client.render.util.EntityRenderTransforms;
import org.avp.common.tile.TileEntityCryostasisTube;
import org.lwjgl.opengl.GL12;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

@SideOnly(Side.CLIENT)
public class RenderCryostasisTube extends TileEntitySpecialRenderer<TileEntityCryostasisTube>
{
    public static ArrayList<CryostasisEntityRenderer> renderers = new ArrayList<>();
    private static final CryostasisEntityRenderer     renderer  = new CryostasisEntityRenderer()
                                                                {
                                                                    public boolean isApplicable(Entity entity)
                                                                    {
                                                                        return true;
                                                                    };
                                                                };

    public static abstract class CryostasisEntityRenderer extends EntityRenderTransforms
    {
        public CryostasisEntityRenderer(Class<?>... entities)
        {
            super(entities);
        }

        @Override
        public void pre(Entity entity, float partialTicks)
        {
            ;
        }

        @Override
        public void post(Entity entity, float partialTicks)
        {
            ;
        }

        public void renderChassis(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
        {
            OpenGL.enable(GL_BLEND);
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            OpenGL.translate(posX + 0.5F, posY + 1.125F, posZ + 0.5F);
            OpenGL.rotate(tile);
            OpenGL.enable(GL12.GL_RESCALE_NORMAL);
            OpenGL.scale(0.75F, -0.75F, 0.75F);
            OpenGL.enable(GL_ALPHA_TEST);
            OpenGL.disableCullFace();
            Resources.instance.models().CRYOSTASIS_TUBE.draw(tile);
            OpenGL.enableCullFace();
        }

        public void renderTube(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
        {
            MapModelTexture<?> mask = null;

            if (tile.isShattered())
            {
                mask = Resources.instance.models().CRYOSTASIS_TUBE_MASK_SHATTERED;
            }
            else if (tile.isCracked())
            {
                mask = Resources.instance.models().CRYOSTASIS_TUBE_MASK_CRACKED;
            }
            else
            {
                mask = Resources.instance.models().CRYOSTASIS_TUBE_MASK;
            }

            if (tile.getVoltage() > 0)
            {
                OpenGL.disableLightMapping();
                OpenGL.disableLight();
            }

            OpenGL.enableCullFace();
            mask.draw();
            OpenGL.enableLightMapping();
            OpenGL.enableLight();
            OpenGL.enableDepthTest();
        }

        public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
        {
            if (tile.stasisEntity != null)
            {
                if (tile.getVoltage() > 0)
                {
                    OpenGL.disableLight();
                }

                ClientGame.instance.renderManager().renderEntity(tile.stasisEntity, 0, 0, 0, 0F, ClientGame.instance.partialTicks(), false);
            }
        }
    }

    @Override
    public void render(TileEntityCryostasisTube tile, double posX, double posY, double posZ, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            CryostasisEntityRenderer cachedRenderer = null;

            if (tile != null && tile.stasisEntity != null)
            {
            	cachedRenderer = renderers.stream().filter((r) -> r.isApplicable(tile.stasisEntity)).findFirst().orElse(renderer);
            } else {
            	cachedRenderer = renderer;
            }

            cachedRenderer.renderChassis(this, tile, posX, posY, posZ);
            OpenGL.pushMatrix();
            OpenGL.disableCullFace();
            cachedRenderer.renderEntity(this, tile, posX, posY, posZ);
            OpenGL.enableCullFace();
            OpenGL.popMatrix();
            cachedRenderer.renderTube(this, tile, posX, posY, posZ);

            OpenGL.disableBlend();
            OpenGL.enableLight();
            OpenGL.enableLightMapping();
        }
        OpenGL.popMatrix();
    }
}
