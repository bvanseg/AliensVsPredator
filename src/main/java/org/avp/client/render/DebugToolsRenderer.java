package org.avp.client.render;

import java.util.ArrayList;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Type;

public class DebugToolsRenderer
{
    public static final DebugToolsRenderer instance = new DebugToolsRenderer();
    private ArrayList<BlockScanner>        blockScanners;

    public static class BlockScanner
    {
        private Block               block;
        private ArrayList<BlockPos> blocksFound;
        private int                 scanRange;
        private float               r;
        private float               g;
        private float               b;
        private float               a;

        public BlockScanner(Block block)
        {
            this(block, 0.5F, 0F, 1F, 0.4F);
        }

        public BlockScanner(Block block, float r, float g, float b, float a)
        {
            this(block, 32, r, g, b, a);
        }

        public BlockScanner(Block block, int scanRange, float r, float g, float b, float a)
        {
            this.blocksFound = new ArrayList<BlockPos>();
            this.block = block;
            this.scanRange = scanRange;
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }
    }

    public DebugToolsRenderer()
    {
        this.blockScanners = new ArrayList<BlockScanner>();
    }

    public static void scanForBlock(BlockScanner scanner)
    {
        boolean pass = true;

        for (BlockScanner s : DebugToolsRenderer.instance.blockScanners)
        {
            if (s.block == scanner.block)
            {
                pass = false;
            }
        }

        if (pass)
        {
            DebugToolsRenderer.instance.blockScanners.add(scanner);
        }
    }

    public static void destroyBlockScanner(BlockScanner scanner)
    {
        for (BlockScanner s : (ArrayList<BlockScanner>) DebugToolsRenderer.instance.blockScanners.clone())
        {
            if (s.block == scanner.block)
            {
                DebugToolsRenderer.instance.blockScanners.remove(s);
            }
        }
    }

    public static void destroyBlockScanners()
    {
        if (DebugToolsRenderer.instance.blockScanners != null)
        {
            DebugToolsRenderer.instance.blockScanners.clear();
        }
    }

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event)
    {
        EntityPlayer p = Minecraft.getMinecraft().player;
        Tessellator tess = Tessellator.getInstance();
        VertexBuffer buff = tess.getBuffer();
        
        if (AliensVsPredator.settings().areDebugToolsEnabled())
        {
            drawBlockScannerBorders(event, p, tess, buff);
            drawChunkBorders(event, p, tess, buff);
        }
    }

    @SubscribeEvent
    public void tick(ClientTickEvent event)
    {
        // if (AliensVsPredator.settings().areDebugToolsEnabled())
        {
//             DebugToolsRenderer.destroyBlockScanners();
//             DebugToolsRenderer.scanForBlock(new BlockScanner(Blocks.COAL_ORE, 32, 0F, 0F, 0F, 0.4F));
//            DebugToolsRenderer.scanForBlock(new BlockScanner(Blocks.IRON_ORE, 32, 0.6F, 0.4F, 0.2F, 0.4F));
//            DebugToolsRenderer.scanForBlock(new BlockScanner(Blocks.GOLD_ORE, 32, 1F, 0.8F, 0F, 0.4F));
//            DebugToolsRenderer.scanForBlock(new BlockScanner(Blocks.DIAMOND_ORE, 32, 0, 0.6F, 1F, 0.4F));
            
            if (event.type == Type.CLIENT)
            {
                if (Game.minecraft().world != null && Game.minecraft().world.getWorldTime() % 40 == 0)
                {
                    int posX = (int) Game.minecraft().player.posX;
                    int posY = (int) Game.minecraft().player.posY;
                    int posZ = (int) Game.minecraft().player.posZ;

                    for (BlockScanner scanner : this.blockScanners)
                    {
                        if (scanner.block != null)
                        {
                            scanner.blocksFound = com.arisux.mdx.lib.world.block.Blocks.getBlocksInRangeIncluding(posX, posY, posZ, scanner.scanRange, Game.minecraft().world, scanner.block);
                        }
                    }
                }
            }
        }
    }

    private void drawBlockScannerBorders(RenderWorldLastEvent event, EntityPlayer p, Tessellator tess, VertexBuffer buff)
    {
        if (Game.minecraft().gameSettings.thirdPersonView == 0)
        {
            double x = p.lastTickPosX + (p.posX - p.lastTickPosX) * (double) event.getPartialTicks();
            double y = p.lastTickPosY + (p.posY - p.lastTickPosY) * (double) event.getPartialTicks();
            double z = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * (double) event.getPartialTicks();

            GlStateManager.disableTexture2D();
            GlStateManager.glLineWidth(1.0F);
            GlStateManager.enableBlend();
            OpenGL.disableLight();
            GlStateManager.disableDepth();

            if (blockScanners != null && !blockScanners.isEmpty())
            {
                for (BlockScanner scanner : blockScanners)
                {
                    if (scanner != null && scanner.blocksFound != null && !scanner.blocksFound.isEmpty())
                    {
                        for (BlockPos pos : scanner.blocksFound)
                        {
                            double cubeX = -(x - pos.getX());
                            double cubeY = -(y - pos.getY());
                            double cubeZ = -(z - pos.getZ());

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX, cubeY + 0.0D, cubeZ).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX, cubeY + 1.0D, cubeZ).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 1.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 0.0D, cubeY + 1.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 0.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();

                            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);
                            buff.pos(cubeX + 1.0D, cubeY + 0.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            buff.pos(cubeX + 0.0D, cubeY + 0.0D, cubeZ + 1.0D).color(scanner.r, scanner.g, scanner.b, scanner.a).endVertex();
                            tess.draw();
                        }
                    }
                }
            }

            GlStateManager.glLineWidth(1.0F);
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
        }
    }

    private void drawChunkBorders(RenderWorldLastEvent event, EntityPlayer p, Tessellator tess, VertexBuffer buff)
    {
        double x = p.lastTickPosX + (p.posX - p.lastTickPosX) * (double) event.getPartialTicks();
        double y = p.lastTickPosY + (p.posY - p.lastTickPosY) * (double) event.getPartialTicks();
        double z = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * (double) event.getPartialTicks();
        double sY = 0.0D - y;
        double eY = 256.0D - y;
        double sX = (double) (p.chunkCoordX << 4) - x;
        double sZ = (double) (p.chunkCoordZ << 4) - z;

        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth(1.0F);
        GlStateManager.enableBlend();
        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);

        for (int k = 1; k < 16; k += 1)
        {
            buff.pos(sX + (double) k, sY, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            buff.pos(sX + (double) k, sY, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + (double) k, eY, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + (double) k, eY, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            buff.pos(sX + (double) k, sY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            buff.pos(sX + (double) k, sY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + (double) k, eY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + (double) k, eY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
        }

        for (int l = 1; l < 16; l += 1)
        {
            buff.pos(sX, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            buff.pos(sX, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            buff.pos(sX + 16.0D, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            buff.pos(sX + 16.0D, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + 16.0D, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + 16.0D, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
        }

        for (int i1 = 0; i1 <= 256; i1 += 1)
        {
            double d7 = (double) i1 - y;
            buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX, d7, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + 16.0D, d7, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX + 16.0D, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
            buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
        }

        tess.draw();
        GlStateManager.glLineWidth(3.0F);
        buff.begin(3, DefaultVertexFormats.POSITION_COLOR);

        for (int j1 = 0; j1 <= 16; j1 += 16)
        {
            for (int l1 = 0; l1 <= 16; l1 += 16)
            {
                buff.pos(sX + (double) j1, sY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 0.0F).endVertex();
                buff.pos(sX + (double) j1, sY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                buff.pos(sX + (double) j1, eY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                buff.pos(sX + (double) j1, eY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 0.0F).endVertex();
            }
        }

        for (int k1 = 0; k1 <= 256; k1 += 16)
        {
            double d8 = (double) k1 - y;
            buff.pos(sX, d8, sZ).color(0.25F, 0.25F, 1.0F, 0.0F).endVertex();
            buff.pos(sX, d8, sZ).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
            buff.pos(sX, d8, sZ + 16.0D).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
            buff.pos(sX + 16.0D, d8, sZ + 16.0D).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
            buff.pos(sX + 16.0D, d8, sZ).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
            buff.pos(sX, d8, sZ).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
            buff.pos(sX, d8, sZ).color(0.25F, 0.25F, 1.0F, 0.0F).endVertex();
        }

        tess.draw();
        GlStateManager.glLineWidth(1.0F);
        GlStateManager.enableTexture2D();
    }
}
