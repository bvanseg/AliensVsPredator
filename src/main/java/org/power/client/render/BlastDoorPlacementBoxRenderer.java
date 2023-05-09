package org.power.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.power.common.tile.TileEntityBlastdoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlastDoorPlacementBoxRenderer
{
    public static final BlastDoorPlacementBoxRenderer instance = new BlastDoorPlacementBoxRenderer();

    public BlastDoorPlacementBoxRenderer()
    {
    }

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event)
    {
        EntityPlayer p = Minecraft.getMinecraft().player;
        Tessellator tess = Tessellator.getInstance();
        BufferBuilder buff = tess.getBuffer();

        if (ClientGame.instance.minecraft().gameSettings.thirdPersonView != 0) return;

        ItemStack stack = ClientGame.instance.minecraft().player.getHeldItemMainhand();

        Block block = Block.getBlockFromItem(stack.getItem());

        if (!block.hasTileEntity(block.getDefaultState())) return;

        TileEntity t = block.createTileEntity(ClientGame.instance.minecraft().world, block.getDefaultState());

        if (!(t instanceof TileEntityBlastdoor)) return;

        TileEntityBlastdoor bd = (TileEntityBlastdoor) t;
        List<BlockPos> blocks = new ArrayList<>(Arrays.asList(bd.setFor(Entities.getEntityFacingRotY(p))));
        blocks.add(BlockPos.ORIGIN);

        RayTraceResult rayTraceResult = ClientGame.instance.minecraft().objectMouseOver;

        if (rayTraceResult == null) return;

        Vec3d hitVec = rayTraceResult.hitVec;

        double x = p.lastTickPosX + (p.posX - p.lastTickPosX) * event.getPartialTicks();
        double y = p.lastTickPosY + (p.posY - p.lastTickPosY) * event.getPartialTicks();
        double z = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * event.getPartialTicks();

        double locationX = Math.floor(hitVec.x);
        double locationY = Math.floor(hitVec.y);
        double locationZ = Math.floor(hitVec.z);

        double placeX = locationX - x;
        double placeY = locationY - y;
        double placeZ = locationZ - z;

        float r = 1.0F;
        float g = 0.0F;
        float b = 0.2F;
        float a = 0.6F;

        boolean validPlacementPosition = true;

        for (BlockPos pos : blocks)
        {
            if (p.world.getBlockState(pos.add(locationX, locationY, locationZ)).getBlock() != Blocks.AIR)
            {
                validPlacementPosition = false;
            }
        }

        if (validPlacementPosition)
        {
            r = 0.4F;
            g = 1.0F;
            b = 0.0F;
        }

        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth(2.0F);
        GlStateManager.enableBlend();

        for (BlockPos pos : blocks)
        {
            this.drawPlacementBlock(tess, buff, placeX, placeY, placeZ, r, g, b, a, pos);
        }

        GlStateManager.glLineWidth(1.0F);
        GlStateManager.enableTexture2D();
    }

    private void drawPlacementBlock(Tessellator tess, BufferBuilder buff, double placeX, double placeY, double placeZ, float r, float g, float b, float a, BlockPos pos) {
        double cubeX = placeX + pos.getX();
        double cubeY = placeY + pos.getY();
        double cubeZ = placeZ + pos.getZ();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX, cubeY + 0.0D, cubeZ).color(r, g, b, a).endVertex();
        buff.pos(cubeX, cubeY + 1.0D, cubeZ).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 0.0D).color(r, g, b, a).endVertex();
        tess.draw();

        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
        buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 1.0D).color(r, g, b, a).endVertex();
        tess.draw();
    }
}
