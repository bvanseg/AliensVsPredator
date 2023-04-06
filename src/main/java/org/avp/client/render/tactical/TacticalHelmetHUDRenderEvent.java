package org.avp.client.render.tactical;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.alien.common.api.emybro.EmbryoEntry;
import org.alien.common.world.capability.Organism;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.client.Resources;
import org.avp.client.render.LightmapUpdateEvent;
import org.avp.common.AVPItems;
import org.avp.common.world.capability.SpecialPlayer;
import org.lib.client.render.wavegraph.Wavegraph;
import org.lib.client.render.wavegraph.ekg.Electrocardiogram;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Ri5ux
 */
public class TacticalHelmetHUDRenderEvent {

    public static final TacticalHelmetHUDRenderEvent instance = new TacticalHelmetHUDRenderEvent();

    private boolean gammaRestored = true;

    private SpecialPlayer.SpecialPlayerImpl specialPlayer;
    private OrganismImpl playerOrganism;
    private final ArrayList<EntityPlayer> playersInHUD = new ArrayList<>();

    private final Electrocardiogram electrocardiogram;
    private final Wavegraph wavegraph1;
    private final Wavegraph wavegraph2;

    private int viewportThreshold = 20;

    private TacticalHelmetHUDRenderEvent() {
        this.electrocardiogram = new Electrocardiogram();
        this.wavegraph1 = new Wavegraph();
        this.wavegraph2 = new Wavegraph();
    }

    @SubscribeEvent
    public void renderTickOverlay(RenderGameOverlayEvent.Pre event)
    {
        if (ClientGame.instance.minecraft().player == null) return;
        if (event.getType() != RenderGameOverlayEvent.ElementType.CROSSHAIRS) return;

        ItemStack helmSlotItemStack = Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player);

        if (helmSlotItemStack != null && ClientGame.instance.minecraft().gameSettings.thirdPersonView == 0 && helmSlotItemStack.getItem() == AVPItems.HELM_MARINE)
        {
            SpecialPlayer.SpecialPlayerImpl specialPlayer = (SpecialPlayer.SpecialPlayerImpl) ClientGame.instance.minecraft().player.getCapability(SpecialPlayer.SpecialPlayerImpl.Provider.CAPABILITY, null);

            this.gammaRestored = false;
            LightmapUpdateEvent.instance.gammaValue = specialPlayer.isNightvisionEnabled() ? 8F : 0F;
            LightmapUpdateEvent.instance.overrideGamma();
            this.scanForNearbyPlayers();
            OpenGL.enableBlend();
            OpenGL.blendClear();
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
            OpenGL.color(1F, 1F, 1F, 1F);
            Resources.instance.BLUR_TACTICAL_HUD.bind();
            Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight());
            OpenGL.color(1F, 1F, 1F, 1F);
            OpenGL.blendClear();

            this.drawInfoBar(event);
            this.drawImpregnationIndicator(getPlayerOrganism());
            this.drawPlayerScanner();
        }
        else if (!gammaRestored)
        {
            this.gammaRestored = true;
            LightmapUpdateEvent.instance.gammaValue = 0F;
            LightmapUpdateEvent.instance.overrideGamma();
        }
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event)
    {
        if (ClientGame.instance.minecraft().world != null && event.phase == TickEvent.Phase.START)
        {
            this.electrocardiogram.update(ClientGame.instance.minecraft().world);
            this.wavegraph1.setRate(750);
            this.wavegraph2.setRate(450);
            this.wavegraph1.update(ClientGame.instance.minecraft().world);
            this.wavegraph2.update(ClientGame.instance.minecraft().world);
        }
    }

    public void drawInfoBar(RenderGameOverlayEvent.Pre event)
    {
        int batteryPercent = 100;

        int hourOfMinecraftDay = (int) (Math.floor(ClientGame.instance.minecraft().player.world.getWorldTime() / 1000 + 8) % 24);
        int minuteOfMinecraftDay = (int) (60 * Math.floor(ClientGame.instance.minecraft().player.world.getWorldTime() % 1000) / 1000);

        String timeString = String.format("[%02d:%02d]", hourOfMinecraftDay, minuteOfMinecraftDay);
        String fpsString = ClientGame.instance.minecraft().debug.substring(0, ClientGame.instance.minecraft().debug.indexOf(" fps"));
        String barString = String.format("[%sFPS] [%s%%] %s", fpsString, batteryPercent, timeString);
        String bar2String = String.format("[X %s] [Y %s] [Z %s]", Math.round(ClientGame.instance.minecraft().player.posX), Math.round(ClientGame.instance.minecraft().player.posY), Math.round(ClientGame.instance.minecraft().player.posZ));
        String bar3String = String.format("[CHANNEL %s]", this.getSpecialPlayer().getBroadcastChannel());

        OpenGL.pushMatrix();
        {
            OpenGL.enableBlend();
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
            OpenGL.pushMatrix();
            {
                float scale = 0.5F;
                this.electrocardiogram.setWidth(140).setHeight(50).setBackgroundColor(0x00000000).setBacklightColor(0x00000000).setLineWidth(4F).setColor(0xFF0088FF);
                this.electrocardiogram.setX(0).setY(0);
                OpenGL.scale(scale, scale, scale);
                OpenGL.translate(20F, event.getResolution().getScaledHeight() * 2 - 100F, 0F);
                OpenGL.rotate(-15F, 0F, 0F, 1F);
                OpenGL.rotate(-25F, 0F, 1F, 0F);
                this.electrocardiogram.render(event.getPartialTicks());
            }
            OpenGL.popMatrix();
            OpenGL.pushMatrix();
            {
                float scale = 0.5F;
                this.wavegraph1.setWidth(140).setHeight(50).setBackgroundColor(0x00000000).setBacklightColor(0x00000000).setLineWidth(4F).setColor(0xFF0088FF);
                this.wavegraph1.setX(0).setY(0);
                OpenGL.scale(scale, scale, scale);
                OpenGL.translate(20F, event.getResolution().getScaledHeight() * 2 - 50F, 0F);
                OpenGL.rotate(-15F, 0F, 0F, 1F);
                OpenGL.rotate(-25F, 0F, 1F, 0F);
                this.wavegraph1.render(event.getPartialTicks());
            }
            OpenGL.popMatrix();
            OpenGL.pushMatrix();
            {
                float scale = 0.5F;
                this.wavegraph2.setWidth(140).setHeight(50).setBackgroundColor(0x00000000).setBacklightColor(0x00000000).setLineWidth(4F).setColor(0xFF0088FF);
                this.wavegraph2.setX(0).setY(0);
                OpenGL.scale(scale, scale, scale);
                OpenGL.translate(event.getResolution().getScaledWidth() * 2 - 30F, event.getResolution().getScaledHeight() * 2 - 60F, 0F);
                OpenGL.rotate(-180 + 15F, 0F, 0F, 1F);
                OpenGL.rotate(25F, 0F, 1F, 0F);
                OpenGL.rotate(180F, 1F, 0F, 0F);
                this.wavegraph2.render(event.getPartialTicks());
            }
            OpenGL.popMatrix();
            OpenGL.enableBlend();
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);

            if (this.playerOrganism != null && this.playerOrganism.hasEmbryo())
            {
                int lifeTimeTicks = this.playerOrganism.getEmbryo().getGestationPeriod() - this.playerOrganism.getEmbryo().getAge();
                int lifeTimeSeconds = lifeTimeTicks / 20;

                Class<? extends EntityLivingBase> birthCreatureClass = this.playerOrganism.getEmbryo().getBirthCreature();
                String line1 = String.format("TYPE: %s", birthCreatureClass.getSimpleName().replace("Entity", ""));
                String line2 = String.format("VITAL.TIME: %s.%sM", lifeTimeSeconds / 60, lifeTimeSeconds % 60);
                String line3 = String.format("EID: %s", this.playerOrganism.getEmbryo().getId());

                OpenGL.pushMatrix();
                {
                    float scale = 0.5F;
                    OpenGL.scale(scale, scale, scale);
                    OpenGL.translate(event.getResolution().getScaledWidth() * 2 - 30F, event.getResolution().getScaledHeight() * 2 - 60F, 0F);
                    OpenGL.rotate(-180 + 15F, 0F, 0F, 1F);
                    OpenGL.rotate(25F, 0F, 1F, 0F);

                    OpenGL.color4i(0xFFFF0000);
                    Resources.instance.INFECTION_INDICATOR.bind();
                    Draw.drawQuad(30, 0, 64, 64);

                    OpenGL.rotate(180F, 0F, 0F, 1F);
                    Draw.drawString(line1, -Draw.getStringRenderWidth(line1) - 64, -50, 0xFFFF0000, false);
                    Draw.drawString(line2, -Draw.getStringRenderWidth(line2) - 64, -40, 0xFFFF0000, false);
                    Draw.drawString(line3, -Draw.getStringRenderWidth(line3) - 64, -30, 0xFFFF0000, false);
                }
                OpenGL.popMatrix();
            }

            float globalscale = 0.75F;
            OpenGL.scale(globalscale, globalscale, globalscale);

            OpenGL.pushMatrix();
            {
                OpenGL.rotate(5F, 0F, 0F, 1F);
                OpenGL.translate(100F, 25F, 0F);

                OpenGL.pushMatrix();
                {
                    float nameScale = 1.5F;
                    OpenGL.scale(nameScale, nameScale, nameScale);
                    Draw.drawString(ClientGame.instance.minecraft().player.getName().toUpperCase(), 0, 0, 0xFF00AAFF, false);
                }
                OpenGL.popMatrix();

                Draw.drawString(barString, 0, 15, 0xFF00AAFF, false);
                Draw.drawString(bar2String, 0, 25, 0xFF00AAFF, false);
                Draw.drawString(bar3String, 0, 35, 0xFF00AAFF, false);
            }
            OpenGL.popMatrix();

            OpenGL.pushMatrix();
            {
                int hOffset = 5;
                int btX = 6;
                int btY = 3;
                int btWidth = 128;
                int btHeight = 64;
                int batteryWidth = btWidth / 2 * (batteryPercent + hOffset) / 100;
                float maxU = (batteryPercent + hOffset) / 100F / 2F;
                Resources.instance.BATTERY_INDICATOR.bind();
                Draw.drawQuad(btX, btY, btWidth, btHeight, 0F, 1F, 0F, 0.5F);
                Draw.drawQuad(btX, btY, batteryWidth, btHeight, 0F, maxU, 0.5F, 1F);
            }
            OpenGL.popMatrix();
        }
        OpenGL.popMatrix();
    }

    public void drawImpregnationIndicator(OrganismImpl organism)
    {
        // if (organism.hasEmbryo() && organism.getEntity().world.getWorldTime() % 20 <=
        // 10)
        // {
        // ScaledResolution res = Screen.scaledDisplayResolution();
        //
        // int lifeTimeTicks = organism.getEmbryo().getGestationPeriod() -
        // organism.getEmbryo().getAge();
        // int lifeTimeSeconds = lifeTimeTicks / 20;
        // int iconSize = 80;
        //
        // OpenGL.enable(GL_BLEND);
        // OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
        // OpenGL.pushMatrix();
        // {
        // float scale = 1.5F;
        // OpenGL.scale(scale, scale, scale);
        // Draw.drawStringAlignRight("Analysis Complete:", (int) ((res.getScaledWidth()
        // / scale) - (iconSize / scale)), (int) (30 / scale), 0xFFFF0000);
        // }
        // OpenGL.popMatrix();
        // Draw.drawStringAlignRight("Foreign Organism Detected", res.getScaledWidth() -
        // iconSize, 45, 0xFFFF0000);
        // Draw.drawStringAlignRight("Xenomorphic Embryo", res.getScaledWidth() -
        // iconSize, 55, 0xFFFF0000);
        //
        // if (!ClientGame.instance.minecraft().player.capabilities.isCreativeMode)
        // {
        // Draw.drawStringAlignRight("Time Until Death: " + (lifeTimeSeconds / 60) + "."
        // + lifeTimeSeconds % 60 + "M", res.getScaledWidth() - iconSize, 65,
        // 0xFFFFFFFF);
        // }
        //
        // OpenGL.color4i(0xFFFF0000);
        // AliensVsPredator.resources().INFECTION_INDICATOR.bind();
        // Draw.drawQuad(res.getScaledWidth() - iconSize, 0, iconSize, iconSize);
        // }
    }

    public void scanForNearbyPlayers()
    {
        EntityPlayer playerFound = ClientGame.instance.minecraft().player.world.findNearestEntityWithinAABB(EntityPlayer.class, ClientGame.instance.minecraft().player.getEntityBoundingBox().expand(this.getSpecialPlayer().getBroadcastRadius(), 128.0D, this.getSpecialPlayer().getBroadcastRadius()), ClientGame.instance.minecraft().player);

        if (playerFound != null)
        {
            SpecialPlayer.SpecialPlayerImpl specialPlayer = (SpecialPlayer.SpecialPlayerImpl) playerFound.getCapability(SpecialPlayer.SpecialPlayerImpl.Provider.CAPABILITY, null);

            if (!isPlayerInHUD(playerFound) && specialPlayer.getBroadcastChannel().equalsIgnoreCase(this.specialPlayer.getBroadcastChannel()))
            {
                playersInHUD.add(playerFound);
            }
        }
    }

    public void drawPlayerScanner()
    {
        for (int x = 0; x < playersInHUD.size(); x++)
        {
            EntityPlayer player = playersInHUD.get(x);
            SpecialPlayer.SpecialPlayerImpl specialPlayer = (SpecialPlayer.SpecialPlayerImpl) player.getCapability(SpecialPlayer.SpecialPlayerImpl.Provider.CAPABILITY, null);

            if (player != null || player != null && !specialPlayer.getBroadcastChannel().equalsIgnoreCase(this.specialPlayer.getBroadcastChannel()))
            {
                playersInHUD.remove(x);
            }

            if (x <= viewportThreshold && player != null)
            {
                int barSpace = 15;
                int signal = (int) ClientGame.instance.minecraft().player.getDistanceSq(player);
                int maxSignal = Math.min(specialPlayer.getBroadcastRadius(), this.specialPlayer.getBroadcastRadius());
                int pxMultiplier = signal >= maxSignal / 1.3 ? 5 : signal >= maxSignal / 2 ? 4 : signal >= maxSignal / 3 ? 3 : signal >= maxSignal / 4 ? 2 : signal >= maxSignal / 5 ? 1 : signal >= maxSignal / 6 ? 0 : 0;

                Draw.drawRect(Screen.scaledDisplayResolution().getScaledWidth() - 111, 40 + barSpace * x - 5, 120, 2, 0xAA00AAFF);
                Draw.drawRect(Screen.scaledDisplayResolution().getScaledWidth() - 111, 42 + barSpace * x - 5, 2, 9, 0xAA00AAFF);

                if (ClientGame.instance.minecraft().player.getDistanceSq(player) <= this.specialPlayer.getBroadcastRadius() && signal <= maxSignal / 1.3)
                {
                    OpenGL.color(1F, 1F, 1F, 1F);
                    Draw.bindTexture(Gui.ICONS);
                    Draw.drawQuad(Screen.scaledDisplayResolution().getScaledWidth() - 135, 36 + barSpace * x, 10, 8, 0, (176 + pxMultiplier * 8));

                    Draw.drawProgressBar(player.getName(), (int) player.getMaxHealth(), (int) player.getHealth(), Screen.scaledDisplayResolution().getScaledWidth() - 105, 40 + barSpace * x, 100, 1, 0, 0xFF00AAFF, false);
                    Draw.drawPlayerFace(player.getName(), Screen.scaledDisplayResolution().getScaledWidth() - 122, 35 + barSpace * x, 11, 11);
                }
                else
                {
                    OpenGL.enable(GL_BLEND);
                    OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                    Draw.drawRect(Screen.scaledDisplayResolution().getScaledWidth() - 105, 40 + barSpace * x, 100, 5, 0x66EEEEEE);
                    Draw.drawString("Connection lost...", Screen.scaledDisplayResolution().getScaledWidth() - 100, 39 + barSpace * x, 0xFFFFFFFF, true);
                }
            }
        }
    }

    public boolean isPlayerInHUD(EntityPlayer player)
    {
        if (player != null)
        {
            for (int x = 0; x < playersInHUD.size(); x++)
            {
                if (playersInHUD.get(x) != null && player.getName().equals(playersInHUD.get(x).getName()))
                    return true;
            }
        }

        return false;
    }

    public OrganismImpl getPlayerOrganism()
    {
        return ClientGame.instance.minecraft() != null ? ClientGame.instance.minecraft().player != null ? this.playerOrganism = (OrganismImpl) ClientGame.instance.minecraft().player.getCapability(Organism.Provider.CAPABILITY, null) : null : null;
    }

    public void changeChannel(String channel)
    {
        this.specialPlayer.setBroadcastChannel(channel);
    }

    public SpecialPlayer.SpecialPlayerImpl getSpecialPlayer()
    {
        return ClientGame.instance.minecraft() != null ? ClientGame.instance.minecraft().player != null ? this.specialPlayer = (SpecialPlayer.SpecialPlayerImpl) ClientGame.instance.minecraft().player.getCapability(SpecialPlayer.SpecialPlayerImpl.Provider.CAPABILITY, null) : null : null;
    }

    public int getViewportThreshold()
    {
        return viewportThreshold;
    }

    public void setViewportThreshold(int viewportThreshold)
    {
        this.viewportThreshold = viewportThreshold;
    }

    public Electrocardiogram getElectrocardiogram()
    {
        return electrocardiogram;
    }
}
