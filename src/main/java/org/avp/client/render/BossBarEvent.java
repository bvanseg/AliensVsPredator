package org.avp.client.render;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.avp.AVP;
import org.avp.client.Resources;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;

public class BossBarEvent
{
    public static final BossBarEvent   instance = new BossBarEvent();
    public ArrayList<EntityLivingBase> bosses;

    public BossBarEvent()
    {
        bosses = new ArrayList<EntityLivingBase>();
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event)
    {
        this.bosses.clear();
    }

    @SubscribeEvent
    public void clientTick(ClientTickEvent event)
    {
        if (Game.minecraft().player != null)
        {
            if (Game.minecraft().player.world.getTotalWorldTime() % 40 == 0)
            {
                for (Object o : Game.minecraft().world.loadedEntityList)
                {
                    if (o instanceof EntityLivingBase)
                    {
                        EntityLivingBase living = (EntityLivingBase) o;
                        
                        if (living.isDead || this.bosses.contains(o))
                        {
                            break;
                        }

                        if (living instanceof EntityMatriarch)
                        {
                            bosses.add(living);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void renderTick(RenderGameOverlayEvent event)
    {
        if (event.getType() == ElementType.BOSSHEALTH)
        {
            OpenGL.pushMatrix();
            {
                float scale = 0.5F;
                OpenGL.scale(scale, scale, scale);

                for (EntityLivingBase boss : bosses)
                {
                    int index = bosses.indexOf(boss);
                    // TODO: Optimize this. It's inefficient.
                    // this.drawBossBar(boss, index, 0, 0);
                }
            }
            OpenGL.popMatrix();
        }
    }

    public void drawBossBar(EntityLivingBase boss, int index, int posX, int posY)
    {
        int tW = 233;
        int tH = 50;
        int offset = tW * 30 / 100;
        int health = (int) (boss.getHealth() * 100 / boss.getMaxHealth());
        int color = health < 50 ? health < 20 ? 0xFFFF0000 : 0xFFFFCC00 : 0xFF00FF00;
        String label = String.format("%s [%s]", boss.getName(), health + "%%");

        OpenGL.pushMatrix();
        {
            OpenGL.enable(GL11.GL_BLEND);
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            OpenGL.color4i(0xFFFFFFFF);
            Resources.instance.QUEEN_BOSS_BAR.bind();
            posX = posX + (index * (tW));
            OpenGL.color4i(color);
            Draw.drawQuad(posX + (offset / 2), posY, (tW - offset) * health / 100, tH, 0, 0.15F, 0.85F, 0F, 0.5F);
            OpenGL.color(1F, 1F, 1F, 1F);
            Draw.drawQuad(posX, posY, tW, tH, 0, 0F, 1F, 0.5F, 1F);
            Draw.drawStringAlignCenter(label, posX + (tW / 2), posY + 16, color);

            Draw.drawStringAlignCenter((int) boss.posX + "/" + (int) boss.posY + "/" + (int) boss.posZ, posX + (tW / 2), posY + 26, 0xFFFFFFFF);

            OpenGL.disable(GL11.GL_BLEND);
        }
        OpenGL.popMatrix();
    }
}
