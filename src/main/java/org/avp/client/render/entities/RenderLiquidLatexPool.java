package org.avp.client.render.entities;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class RenderLiquidLatexPool extends Render
{
    public RenderLiquidLatexPool()
    {
        super(Game.renderManager());
    }

    @Override
    public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            float offset = 1.4F;
            double renderX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * renderPartialTicks;
            double renderY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * renderPartialTicks + entity.getCollisionBorderSize();
            double renderZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * renderPartialTicks;
            double partialX = posX - renderX;
            double partialY = posY - renderY;
            double partialZ = posZ - renderZ;

            AliensVsPredator.resources().LIQUID_POOL.bind();
            Draw.startQuads();
            OpenGL.color(1F, 1F, 1F, 1F);

            for (int blockX = MathHelper.floor(renderX - offset); blockX <= MathHelper.floor(renderX + offset); ++blockX)
            {
                for (int blockY = MathHelper.floor(renderY - offset); blockY <= MathHelper.floor(renderY); ++blockY)
                {
                    for (int blockZ = MathHelper.floor(renderZ - offset); blockZ <= MathHelper.floor(renderZ + offset); ++blockZ)
                    {
                        BlockPos pos = new BlockPos(blockX, blockY - 1, blockZ);
                        IBlockState blockstate = Game.minecraft().player.world.getBlockState(pos);

                        if (blockstate.getBlock() != Blocks.AIR)
                        {
                            this.drawOnBlock(blockstate, posX, posY + entity.getCollisionBorderSize(), posZ, pos, yaw, offset, partialX, partialY + entity.getCollisionBorderSize(), partialZ, entity.ticksExisted);
                        }
                    }
                }
            }

            Draw.tessellate();
            OpenGL.color(1F, 1F, 1F, 1F);
        }
        OpenGL.popMatrix();
    }

    private void drawOnBlock(IBlockState state, double posX, double posY, double posZ, BlockPos pos, float yaw, float offset, double partialX, double partialY, double partialZ, float opacity)
    {
        if (state.isNormalCube())
        {
            AxisAlignedBB boundingbox = state.getCollisionBoundingBox(Game.minecraft().world, pos);
            double x1 = pos.getX() + boundingbox.minX + partialX;
            double x2 = pos.getX() + boundingbox.maxX + partialX;
            double y = pos.getY() + boundingbox.minY + partialY + 0.015625D;
            double z1 = pos.getZ() + boundingbox.minZ + partialZ;
            double z2 = pos.getZ() + boundingbox.maxZ + partialZ;
            float u1 = (float) ((posX - x1) / 2.0D / offset + 0.5D);
            float u2 = (float) ((posX - x2) / 2.0D / offset + 0.5D);
            float v1 = (float) ((posZ - z1) / 2.0D / offset + 0.5D);
            float v2 = (float) ((posZ - z2) / 2.0D / offset + 0.5D);

            OpenGL.pushMatrix();
            {
                OpenGL.rotate(yaw, 0F, 1F, 0F);
                Draw.vertex(x1, y, z1, u1, v1).endVertex();
                Draw.vertex(x1, y, z2, u1, v2).endVertex();
                Draw.vertex(x2, y, z2, u2, v2).endVertex();
                Draw.vertex(x2, y, z1, u2, v1).endVertex();
            }
            OpenGL.popMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}
