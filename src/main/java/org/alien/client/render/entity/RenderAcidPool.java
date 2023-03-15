package org.alien.client.render.entity;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.alien.common.entity.EntityAcidPool;
import org.avp.client.Resources;
import org.lwjgl.opengl.GL11;

public class RenderAcidPool extends Render<EntityAcidPool>
{
    public RenderAcidPool(RenderManager manager)
    {
        super(manager);
    }

    @Override
    public void doRender(EntityAcidPool entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            float scale = 1F;
            float cover = 0.5F;
            double renderX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * renderPartialTicks;
            double renderY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * renderPartialTicks + entity.getCollisionBorderSize();
            double renderZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * renderPartialTicks;
            double partialX = posX - renderX;
            double partialY = posY - renderY + 1;
            double partialZ = posZ - renderZ;

            GlStateManager.disableLight(0);
            GlStateManager.disableLight(1);
            // OpenGL.enableLightMapping();
            OpenGL.enableBlend();
            OpenGL.blendClear();
            OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_DST_ALPHA);
            // OpenGL.enableLighting();
            // OpenGL.enableLight();
            // OpenGL.enableLightMapping();
            this.bindTexture(Resources.instance.LIQUID_POOL);
            Resources.instance.LIQUID_POOL.bind();
            Draw.startQuads();
            OpenGL.color(1F, 1F, 0F, 1F);

            for (int blockX = MathHelper.floor(renderX - cover); blockX <= MathHelper.floor(renderX + cover); ++blockX)
            {
                for (int blockY = MathHelper.floor(renderY - cover); blockY <= MathHelper.floor(renderY); ++blockY)
                {
                    for (int blockZ = MathHelper.floor(renderZ - cover); blockZ <= MathHelper.floor(renderZ + cover); ++blockZ)
                    {
                        BlockPos pos = new BlockPos(blockX, blockY - 1, blockZ);
                        IBlockState blockState = Game.minecraft().player.world.getBlockState(pos);

                        if (blockState.getBlock() != Blocks.AIR)
                        {
                            this.drawOnBlock(blockState, posX, posY + entity.getCollisionBorderSize(), posZ, pos, yaw, scale, partialX, partialY + entity.getCollisionBorderSize(), partialZ, entity.ticksExisted);
                        }
                    }
                }
            }

            Draw.tessellate();
            OpenGL.color(1F, 1F, 1F, 1F);
            OpenGL.blendClear();
            GlStateManager.enableLight(0);
            GlStateManager.enableLight(1);
        }
        OpenGL.popMatrix();
    }

    private void drawOnBlock(IBlockState state, double posX, double posY, double posZ, BlockPos pos, float yaw, float scale, double partialX, double partialY, double partialZ, float opacity)
    {
        AxisAlignedBB boundingbox = state.getCollisionBoundingBox(Game.minecraft().world, pos);

        if (boundingbox != null)
        {
            double x1 = pos.getX() + boundingbox.minX + partialX;
            double x2 = pos.getX() + boundingbox.maxX + partialX;
            double y = pos.getY() + boundingbox.minY + partialY + 0.015625D;
            double z1 = pos.getZ() + boundingbox.minZ + partialZ;
            double z2 = pos.getZ() + boundingbox.maxZ + partialZ;
            float u1 = (float) ((posX - x1) / 2.0D / scale + 0.5D);
            float u2 = (float) ((posX - x2) / 2.0D / scale + 0.5D);
            float v1 = (float) ((posZ - z1) / 2.0D / scale + 0.5D);
            float v2 = (float) ((posZ - z2) / 2.0D / scale + 0.5D);

            OpenGL.pushMatrix();
            {
                Draw.vertex(x1, y, z1, u1, v1).endVertex();
                Draw.vertex(x1, y, z2, u1, v2).endVertex();
                Draw.vertex(x2, y, z2, u2, v2).endVertex();
                Draw.vertex(x2, y, z1, u2, v1).endVertex();
            }
            OpenGL.popMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAcidPool entity)
    {
        return null;
    }
}
