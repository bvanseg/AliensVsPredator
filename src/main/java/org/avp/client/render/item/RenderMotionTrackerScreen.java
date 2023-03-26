package org.avp.client.render.item;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.Tuple;
import org.avp.client.AVPSounds;
import org.avp.client.Resources;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class RenderMotionTrackerScreen
{
    // Stores a pair of the angle and distance for a contact point.
    private final ArrayList<Tuple<Float, Double>> contactPoints = new ArrayList<>();
    private String displayString;
    private final float[] pitch = new float[31];
    private float direction = 0.0F;
    private int minDistance = 40;
    private int entitiesPinged = 0;
    private boolean updateTracker = false;
    private boolean shouldPing = false;

    public RenderMotionTrackerScreen()
    {
        this.displayString = "";

        for (int x = 0; x <= 30; x++)
        {
            this.pitch[x] = (float) Math.pow(1.0188D, 30 - x);
        }
    }

    public void draw(int x, int y, int w, int h)
    {
        if (ClientGame.instance.minecraft().isGamePaused())
        {
            this.updateTracker = false;
            this.shouldPing = false;
        }

        this.direction = this.direction >= 360.0F ? this.direction -= 360.0F : this.direction < 0.0F ? this.direction += 360.0F : (-ClientGame.instance.minecraft().player.rotationYaw);
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
        double fadeTime = System.currentTimeMillis() / 10.0 % 150.0D;
        double fadeIntensity = 1.0D - fadeTime * 0.02D;

        this.pingEnvironment((int) fadeTime / 10);

        for (Tuple<Float, Double> contactPoint : this.contactPoints)
        {
            float locate = contactPoint.getFirst();
            float differenceDegrees = locate - this.direction;

            differenceDegrees = differenceDegrees < -180.0F ? differenceDegrees += 360.0F : differenceDegrees > 180.0F ? differenceDegrees -= 360.0F : differenceDegrees;

            if (Math.abs(differenceDegrees) > 90.0F) {
                double hypot = contactPoint.getSecond();

                this.drawPing(x, y, (float) fadeIntensity, locate, hypot);
            }

        }
    }

    private void drawPing(int x, int y, float fadeIntensity, float locate, double hypot) {
        OpenGL.pushMatrix();
        {
            OpenGL.color(1.0F, 1.0F, 1.0F, fadeIntensity);
            OpenGL.translate(-32.0F, 37.0F, 0.0F);
            OpenGL.rotate(-locate + this.direction + 180.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.translate(0.0D, -hypot * 2, 0.0D);
            OpenGL.rotate(-(-locate + this.direction + 180.0F), 0.0F, 0.0F, 1.0F);
            OpenGL.translate(0.0D, hypot * 2, 0.0D);
            OpenGL.translate(-32.0F, -37.0F, 0.0F);
            OpenGL.translate(0.0D, -hypot * 2, 0.0D);
            Resources.instance.MOTIONTRACKER_PING.bind();
            OpenGL.antiAlias2d();
            Draw.drawQuad(x * 2, y * 2, 128, 128);
        }
        OpenGL.popMatrix();
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
            Resources.instance.MOTIONTRACKER_BG.bind();
            OpenGL.antiAlias2d();
            Draw.drawQuad(x, y, 128, 76, 64, 64);

            if (shouldPing)
            {
               this.drawPingRipple(x, y, time);
            }
        }
        OpenGL.popMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        Resources.instance.MOTIONTRACKER_FG.bind();
        OpenGL.antiAlias2d();
        OpenGL.translate(0, 0, -0.0002F);
        Draw.drawQuad(x, y, 128, 128, 64, 64);
    }

    private void drawPingRipple(int x, int y, int time) {
        if (time == -9)
        {
            Resources.instance.MOTIONTRACKER_S1.bind();
        }
        else if (time == -8)
        {
            Resources.instance.MOTIONTRACKER_S2.bind();
        }
        else if (time == -7)
        {
            Resources.instance.MOTIONTRACKER_S3.bind();
        }
        else if (time == -6)
        {
            Resources.instance.MOTIONTRACKER_S4.bind();
        }
        else if (time == -5)
        {
            Resources.instance.MOTIONTRACKER_S5.bind();
        }
        else if (time == -4)
        {
            Resources.instance.MOTIONTRACKER_S6.bind();
        }

        OpenGL.antiAlias2d();
        Draw.drawQuad(x, y, 128, 76, 64, 64);
    }

    public void pingEnvironment(int pingTime)
    {
        if (pingTime != 11) {
            this.shouldPing = true;
        } else if (this.shouldPing) {
            AVPSounds.MOTIONTRACKER_PING.playSound(ClientGame.instance.minecraft().player);
            this.shouldPing = false;
        }

        if (pingTime != 0) {
            this.updateTracker = true;
        } else if (this.updateTracker) {
            this.updateTracker();

            if (this.entitiesPinged > 0) {
                AVPSounds.MOTIONTRACKER_PONG.playSound(ClientGame.instance.minecraft().player, 1F, this.pitch[this.minDistance]);
            }
        }
    }

    private void updateTracker() {
        this.updateTracker = false;
        this.contactPoints.clear();
        this.minDistance = 40;
        this.entitiesPinged = 0;

        for (Entity entity : ClientGame.instance.minecraft().world.getLoadedEntityList())
        {
            if (entity != ClientGame.instance.minecraft().player &&
                    entity instanceof EntityLiving &&
                    (isMoving(ClientGame.instance.minecraft().player) || isMoving(entity) || entity.isInvisible())
            ) {
                trackEntity(entity);
            }
        }

        if (this.entitiesPinged > 0) {
            this.displayString = this.minDistance < 10 ? "0" + this.minDistance + "m" : this.minDistance + "m";
        } else {
            this.displayString = "00m";
        }
    }

    private void trackEntity(Entity entity) {
        int deltaX = getPlayerPosX() - (int) entity.posX;
        int deltaY = getPlayerPosZ() - (int) entity.posZ;
        float locate = (float) Math.toDegrees(Math.atan2(deltaX, deltaY));
        float differenceDegrees = locate - this.direction;
        differenceDegrees = differenceDegrees < -180.0F ? differenceDegrees += 360.0F : differenceDegrees > 180.0F ? differenceDegrees -= 360.0F : differenceDegrees;

        double hypot = Math.sqrt(deltaX * deltaX + deltaY * deltaY) / (Math.pow(2.0D, 2.0D) / 2.0D);

        if (hypot < 31.0D && Math.abs(differenceDegrees) > 90.0F)
        {
            this.minDistance = hypot < this.minDistance ? (int) hypot : this.minDistance;
            this.contactPoints.add(new Tuple<>(locate, hypot));
            this.entitiesPinged++;
        }
    }

    private int getPlayerPosX()
    {
        return (int) (ClientGame.instance.minecraft().player.posX < 0.0D ? ClientGame.instance.minecraft().player.posX - 1.0D : ClientGame.instance.minecraft().player.posX);
    }

    private int getPlayerPosZ()
    {
        return (int) (ClientGame.instance.minecraft().player.posZ < 0.0D ? ClientGame.instance.minecraft().player.posZ - 1.0D : ClientGame.instance.minecraft().player.posZ);
    }

    public boolean isMoving(Entity entity)
    {
        return entity.lastTickPosX != entity.posX || entity.lastTickPosY != entity.posY || entity.lastTickPosZ != entity.posZ;
    }
}
