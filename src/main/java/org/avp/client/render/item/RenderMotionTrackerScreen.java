package org.avp.client.render.item;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.avp.AVP;
import org.avp.client.Sounds;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class RenderMotionTrackerScreen
{
    public static final RenderMotionTrackerScreen instance         = new RenderMotionTrackerScreen();
    private ArrayList<Float>                      contactsAngle    = new ArrayList<Float>();
    private ArrayList<Double>                     contactsDistance = new ArrayList<Double>();
    private String                                displayString;
    private float[]                               pitch            = new float[31];
    private float                                 direction        = 0.0F;
    private int                                   minDistance      = 40;
    private int                                   pingCount        = 0;
    private boolean                               updateTracker    = false;
    private boolean                               shouldPing       = false;

    public RenderMotionTrackerScreen()
    {
        for (int x = 0; x <= 30; x++)
        {
            this.pitch[x] = (float) Math.pow(1.0188D, 30 - x);
        }
    }

    public void draw(int x, int y, int w, int h)
    {
        if (Game.minecraft().isGamePaused())
        {
            this.updateTracker = false;
            this.shouldPing = false;
        }

        this.direction = this.direction >= 360.0F ? this.direction -= 360.0F : this.direction < 0.0F ? this.direction += 360.0F : (-Game.minecraft().player.rotationYaw);
        this.displayString = this.pingCount > 0 ? this.minDistance < 10 ? "0" + this.minDistance + "m" : this.minDistance + "m" : "00m";
        OpenGL.scale(w / 128F, h / 96F, 1F);
        OpenGL.enable(GL11.GL_BLEND);
        this.drawScreen(x, y);
        OpenGL.translate(64F, 0F, 0F);
        this.drawPings(x, y);
        OpenGL.disable(GL11.GL_BLEND);
        OpenGL.translate(0, 0, -90.01F);
        Draw.drawString(displayString, x - 9, y + 64, 0xFF005599, false);
    }

    private void drawPings(int x, int y)
    {
        double fadeTime = System.currentTimeMillis() / 10L % 150.0D;
        double fadeIntensity = 1.0D - fadeTime * 0.02D;

        this.pingEnvironment((int) fadeTime / 10);

        for (int i = 0; i < this.contactsAngle.size(); i++)
        {
            float locate = this.contactsAngle.get(i);
            float differenceDegrees = locate - this.direction;

            differenceDegrees = differenceDegrees < -180.0F ? differenceDegrees += 360.0F : differenceDegrees > 180.0F ? differenceDegrees -= 360.0F : differenceDegrees;

            if (Math.abs(differenceDegrees) > 90.0F)
            {
                double hypot = this.contactsDistance.get(i);

                OpenGL.pushMatrix();
                {
                    OpenGL.color(1.0F, 1.0F, 1.0F, (float) fadeIntensity);
                    OpenGL.translate(-32.0F, 37.0F, 0.0F);
                    OpenGL.rotate(-locate + this.direction + 180.0F, 0.0F, 0.0F, 1.0F);
                    OpenGL.translate(0.0D, -hypot, 0.0D);
                    OpenGL.rotate(-(-locate + this.direction + 180.0F), 0.0F, 0.0F, 1.0F);
                    OpenGL.translate(0.0D, hypot, 0.0D);
                    OpenGL.translate(-32.0F, -37.0F, 0.0F);
                    OpenGL.translate(0.0D, -hypot, 0.0D);
                    AVP.resources().MOTIONTRACKER_PING.bind();
                    OpenGL.antiAlias2d();
                    Draw.drawQuad(x * 2, y * 2, 128, 128);
                }
                OpenGL.popMatrix();
            }

        }
    }

    private void drawScreen(int x, int y)
    {
        int time = (int) (System.currentTimeMillis() / 100L) % 15;

        OpenGL.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glMatrixMode(GL11.GL_TEXTURE);
        OpenGL.pushMatrix();
        {
            OpenGL.translate(0.5F, 0.5F, 0.0F);
            OpenGL.rotate(-this.direction, 0.0F, 0.0F, 1.0F);
            OpenGL.translate(-0.5F, -0.5F, 0.0F);
            AVP.resources().MOTIONTRACKER_BG.bind();
            OpenGL.antiAlias2d();
            Draw.drawQuad(x, y, 128, 76, 64, 64);

            if (shouldPing)
            {
                if (time >= 14)
                {
                    AVP.resources().MOTIONTRACKER_S6.bind();
                }
                else if (time >= 13)
                {
                    AVP.resources().MOTIONTRACKER_S5.bind();
                }
                else if (time >= 12)
                {
                    AVP.resources().MOTIONTRACKER_S4.bind();
                }
                else if (time >= 11)
                {
                    AVP.resources().MOTIONTRACKER_S3.bind();
                }
                else if (time >= 10)
                {
                    AVP.resources().MOTIONTRACKER_S2.bind();
                }
                else if (time >= 9)
                {
                    AVP.resources().MOTIONTRACKER_S1.bind();
                }

                OpenGL.antiAlias2d();
                Draw.drawQuad(x, y, 128, 76, 64, 64);
            }
        }
        OpenGL.popMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        AVP.resources().MOTIONTRACKER_FG.bind();
        OpenGL.antiAlias2d();
        OpenGL.translate(0, 0, -0.0002F);
        Draw.drawQuad(x, y, 128, 128, 64, 64);
    }

    @SuppressWarnings("unchecked")
    public void pingEnvironment(int pingTime)
    {
        if (pingTime != 11)
        {
            this.shouldPing = true;
        }
        else if (this.shouldPing)
        {
            this.shouldPing = false;
            Sounds.MOTIONTRACKER_PING.playSound(Game.minecraft().player);
        }

        if (pingTime != 0)
        {
            this.updateTracker = true;
        }
        else if (this.updateTracker)
        {
            ArrayList<Entity> entities = (ArrayList<Entity>) Game.minecraft().world.getLoadedEntityList();
            this.updateTracker = false;
            this.contactsAngle.clear();
            this.contactsDistance.clear();
            this.minDistance = 40;
            this.pingCount = 0;

            for (Entity entity : entities)
            {
                if (entity != Game.minecraft().player && entity instanceof EntityLiving && (isMoving(Game.minecraft().player) || isMoving(entity) || entity.isInvisible()))
                {
                    int wayX = xCoord() - (int) entity.posX;
                    int wayY = zCoord() - (int) entity.posZ;
                    float locate = (float) Math.toDegrees(Math.atan2(wayX, wayY));
                    float differenceDegrees = locate - this.direction;
                    differenceDegrees = differenceDegrees < -180.0F ? differenceDegrees += 360.0F : differenceDegrees > 180.0F ? differenceDegrees -= 360.0F : differenceDegrees;

                    double hypot = Math.sqrt(wayX * wayX + wayY * wayY) / (Math.pow(2.0D, 2.0D) / 2.0D);

                    if (hypot < 31.0D && Math.abs(differenceDegrees) > 90.0F)
                    {
                        this.minDistance = hypot < this.minDistance ? (int) hypot : this.minDistance;
                        this.contactsAngle.add(Float.valueOf(locate));
                        this.contactsDistance.add(Double.valueOf(hypot));
                        this.pingCount += 1;
                    }
                }
            }

            if (this.pingCount > 0)
            {
                Sounds.MOTIONTRACKER_PONG.playSound(Game.minecraft().player, 1F, this.pitch[this.minDistance]);
            }
        }
    }

    private int xCoord()
    {
        return (int) (Game.minecraft().player.posX < 0.0D ? Game.minecraft().player.posX - 1.0D : Game.minecraft().player.posX);
    }

    private int zCoord()
    {
        return (int) (Game.minecraft().player.posZ < 0.0D ? Game.minecraft().player.posZ - 1.0D : Game.minecraft().player.posZ);
    }

    public boolean isMoving(Entity entity)
    {
        return entity.lastTickPosX != entity.posX || entity.lastTickPosY != entity.posY || entity.lastTickPosZ != entity.posZ;
    }
}
