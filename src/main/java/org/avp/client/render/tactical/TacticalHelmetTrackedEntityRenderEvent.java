package org.avp.client.render.tactical;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.world.capability.Organism;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.client.Resources;
import org.avp.common.AVPItems;
import org.avp.common.world.capability.SpecialPlayer;
import org.lwjgl.opengl.GL11;

import java.lang.ref.WeakReference;
import java.util.HashSet;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Ri5ux
 */
public class TacticalHelmetTrackedEntityRenderEvent {

    public static final TacticalHelmetTrackedEntityRenderEvent instance = new TacticalHelmetTrackedEntityRenderEvent();

    private SpecialPlayer.SpecialPlayerImpl specialPlayer;

    private final HashSet<WeakReference<EntityLivingBase>> trackedEntities = new HashSet<>();

    private TacticalHelmetTrackedEntityRenderEvent() {}

    // Add tracked entities here.
    @SubscribeEvent
    public void renderEntityEvent(RenderLivingEvent.Post<EntityLivingBase> event) {
        if (!this.shouldTrackEntities()) return;

        EntityLivingBase entity = event.getEntity();
        double distance = event.getEntity().getDistance(ClientGame.instance.minecraft().player);

        if (distance > 32) return;
        if ((entity instanceof EntityParasitoid) && !((EntityParasitoid) entity).isFertile()) return;

        this.trackedEntities.add(new WeakReference<>(entity));
    }

    // Render tracked entities here. It is important to render all tracked entities within the world last event, as
    // we want the distance trackers to render in front of all blocks, entities, etc. everything.
    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event) {
        if (!this.shouldTrackEntities()) return;
        if (ClientGame.instance.minecraft().player == null) return;
        if (this.getSpecialPlayer() == null) return;

        Vec3d p = ClientGame.instance.minecraft().player.getLookVec();
        float scale = 24.0F;

        OpenGL.pushMatrix();
        {
            OpenGL.translate(p.x, p.y, p.z);
            OpenGL.scale(scale, scale, scale);

            this.trackedEntities.removeIf(ref -> {
                if (ref == null)
                    return true;

                EntityLivingBase entity = ref.get();

                if (entity == null || entity.isDead)
                    return true;

                this.renderTrackedEntityData(p, entity);
                return false;
            });
        }
        OpenGL.popMatrix();

        // Clean up.
        this.trackedEntities.clear();
    }

    private boolean shouldTrackEntities() {
        // If not in first person.
        if (ClientGame.instance.minecraft().gameSettings.thirdPersonView != 0) return false;

        ItemStack helmSlotItemStack = Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player);
        if (helmSlotItemStack == null) return false;
        if (helmSlotItemStack.getItem() != AVPItems.HELM_MARINE) return false;

        return true;
    }

    private void renderTrackedEntityData(Vec3d p, EntityLivingBase living) {
        if (living == null) return;
        if (living == ClientGame.instance.minecraft().player) return;
        if (specialPlayer.isEntityCullingEnabled()) return;
        // FIXME: This check using MDX seems to not work no matter what.
//        if (!Entities.canEntityBeSeenBy(living, ClientGame.instance.minecraft().player)) return;

        double partialTicks = ClientGame.instance.partialTicks();
        OrganismImpl organism = (OrganismImpl) living.getCapability(Organism.Provider.CAPABILITY, null);
        Entity rve = ClientGame.instance.minecraft().getRenderViewEntity();

        Vec3d lPos = new Vec3d(living.posX, living.posY, living.posZ).add(0, living.getEyeHeight() / 2, 0);
        lPos = lPos.subtract(new Vec3d(rve.posX + (rve.posX - rve.prevPosX) * partialTicks, rve.posY + (rve.posY - rve.prevPosY) * partialTicks, rve.posZ + (rve.posZ - rve.prevPosZ) * partialTicks));

        Vec3d nPos = p.add(lPos.x, lPos.y, lPos.z).normalize();
        Vec3d rPos = p.add(-nPos.x, -nPos.y, -nPos.z);

        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL11.GL_ALPHA_TEST);
            OpenGL.enable(GL_DEPTH_TEST);
            GL11.glDepthFunc(GL_ALWAYS);
            OpenGL.blendClear();
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
            OpenGL.disableLight();
            OpenGL.disableLightMapping();
            OpenGL.translate(p.x, p.y, p.z);
            OpenGL.translate(-rPos.x, -(rPos.y), -rPos.z);
            OpenGL.rotate(-ClientGame.instance.minecraft().player.rotationYaw - 180, 0, 1, 0);
            OpenGL.rotate(-ClientGame.instance.minecraft().player.rotationPitch, 1, 0, 0);

            OpenGL.pushMatrix();
            {
                OpenGL.rotate(ClientGame.instance.minecraft().player.rotationYaw - 180, 0, 1, 0);
                float indicatorScale = 0.05F;
                OpenGL.blendClear();
                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                OpenGL.scale(indicatorScale, indicatorScale, indicatorScale);
                OpenGL.rotate(-ClientGame.instance.minecraft().player.rotationYaw, 0, 1, 0);

                if (organism != null && organism.hasEmbryo()) {
                    OpenGL.color4i(0xFFFF0000);
                    Draw.drawResourceCentered(Resources.instance.INFECTION_INDICATOR, 2, -1, 2, 2, 255, 0, 0, 255);
                }

                    int color = (organism != null && organism.hasEmbryo()) || living instanceof IMob ? 0xFFFF0000 : 0xFF00AAFF;
                int textMultiplier = 10;
                int textX = 20;
                int textY = -38 + textMultiplier;
                float textScale = 0.0625F;
                OpenGL.rotate(180F, 0F, 1F, 0F);
                OpenGL.scale(textScale, -textScale, textScale);

                String dist = String.valueOf(((int) living.getDistance((ClientGame.instance.minecraft().player))));
                Draw.drawString(dist, textX - 19 - (Draw.getStringRenderWidth(dist) / 2), (textY += textMultiplier) + 15, color, false);

                if (organism != null && organism.hasEmbryo()) {
                    int lifeTimeTicks = organism.getEmbryo().getGestationPeriod() - organism.getEmbryo().getAge();
                    int lifeTimeSeconds = lifeTimeTicks / 20;
                    Draw.drawString("FOREIGN ORGANISM", textX, textY += textMultiplier, 0xFFFF0000, false);
                    Draw.drawString("VITAL.TIME: " + lifeTimeSeconds / 60 + "." + lifeTimeSeconds % 60 + "M", textX, textY += textMultiplier, 0xFFFF0000, false);
                }

                Draw.drawCenteredRectWithOutline(0, 0, 16, 16, 1, 0x00000000, color);
            }
            OpenGL.popMatrix();

            OpenGL.enableLightMapping();
            OpenGL.enableLight();
            OpenGL.enable(GL11.GL_DEPTH_TEST);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            OpenGL.enable(GL11.GL_ALPHA_TEST);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
            OpenGL.blendClear();
        }
        OpenGL.popMatrix();
    }

    public SpecialPlayer.SpecialPlayerImpl getSpecialPlayer()
    {
        return ClientGame.instance.minecraft() != null ? ClientGame.instance.minecraft().player != null ? this.specialPlayer = (SpecialPlayer.SpecialPlayerImpl) ClientGame.instance.minecraft().player.getCapability(SpecialPlayer.SpecialPlayerImpl.Provider.CAPABILITY, null) : null : null;
    }
}
