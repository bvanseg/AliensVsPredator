package org.avp.client.render;

import com.asx.mdx.lib.client.gui.GuiCustomButton;
import com.asx.mdx.lib.client.gui.IAction;
import com.asx.mdx.lib.client.gui.IGuiElement;
import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Screen;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.world.capability.IOrganism.Organism;
import org.alien.common.world.capability.IOrganism.Provider;
import org.avp.AVP;
import org.avp.client.gui.GuiTacticalHUDSettings;
import org.avp.client.render.wavegraph.Wavegraph;
import org.avp.client.render.wavegraph.ekg.Electrocardiogram;
import org.avp.common.AVPItems;
import org.avp.common.entity.EntityAPC;
import org.avp.common.world.capability.ISpecialPlayer.SpecialPlayer;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class TacticalHUDRenderEvent
{
    public static final TacticalHUDRenderEvent instance          = new TacticalHUDRenderEvent();
    private GuiTacticalHUDSettings             guiSettings;
    private final ArrayList<EntityPlayer>            playersInHUD      = new ArrayList<EntityPlayer>();
    private SpecialPlayer                      specialPlayer;
    private Organism                           playerOrganism;
    private final GuiCustomButton                    buttonMarineHelmConfig;
    private boolean                            gammaRestored     = true;
    private int                                viewportThreshold = 20;
    private ArrayList<EntityLivingBase>        trackedEntities;
    private final Electrocardiogram electrocardiogram;
    private final Wavegraph wavegraph1;
    private final Wavegraph                          wavegraph2;

    public TacticalHUDRenderEvent()
    {
        this.specialPlayer = getSpecialPlayer();
        this.buttonMarineHelmConfig = new GuiCustomButton(0, 0, 0, 50, 20, "");
        this.electrocardiogram = new Electrocardiogram();
        this.wavegraph1 = new Wavegraph();
        this.wavegraph2 = new Wavegraph();
    }

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event)
    {
        if (Game.minecraft().gameSettings.thirdPersonView == 0)
        {
            if (Inventories.getHelmSlotItemStack(Game.minecraft().player) != null && Inventories.getHelmSlotItemStack(Game.minecraft().player).getItem() == AVPItems.HELM_MARINE)
            {
                if (Game.minecraft().world != null && Game.minecraft().world.getTotalWorldTime() % (20 * 3) == 0)
                {
                    if (trackedEntities != null)
                    {
                        trackedEntities.clear();
                    }

                    trackedEntities = (ArrayList<EntityLivingBase>) Entities.getEntitiesInCoordsRange(Game.minecraft().player.world, EntityLivingBase.class, new Pos(Game.minecraft().player), 30, 30);

                    trackedEntities.removeIf(e -> {
                        return (e instanceof EntityParasitoid) && !((EntityParasitoid) e).isFertile();
                    });
                }

                if (trackedEntities != null)
                {
                    Vec3d p = Game.minecraft().player.getLookVec();
                    float scale = 24.0F;

                    OpenGL.pushMatrix();
                    {
                        OpenGL.translate(p.x, p.y, p.z);
                        OpenGL.scale(scale, scale, scale);

                        if (Game.minecraft().player != null && specialPlayer != null)
                        {
                            for (EntityLivingBase living : trackedEntities)
                            {
                                if (living != null && living != Game.minecraft().player)
                                {
                                    if (living != null && (Entities.canEntityBeSeenBy(living, Game.minecraft().player) || !specialPlayer.isEntityCullingEnabled()) && living instanceof EntityLivingBase)
                                    {
                                        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);
                                        Entity rve = Game.minecraft().getRenderViewEntity();

                                        Vec3d lPos = new Vec3d(living.posX, living.posY, living.posZ).add(0, living.getEyeHeight() / 2, 0);
                                        lPos = lPos.subtract(new Vec3d(rve.posX + (rve.posX - rve.prevPosX) * event.getPartialTicks(), rve.posY + (rve.posY - rve.prevPosY) * event.getPartialTicks(), rve.posZ + (rve.posZ - rve.prevPosZ) * event.getPartialTicks()));

                                        Vec3d nPos = p.add(lPos.x, lPos.y, lPos.z).normalize();
                                        Vec3d rPos = p.add(-nPos.x, -nPos.y, -nPos.z);

                                        OpenGL.pushMatrix();
                                        {
                                            OpenGL.disable(GL11.GL_ALPHA_TEST);
                                            OpenGL.enable(GL_DEPTH_TEST);
                                            GL11.glDepthFunc(GL11.GL_ALWAYS);
                                            OpenGL.blendClear();
                                            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                                            OpenGL.disableLight();
                                            OpenGL.disableLightMapping();
                                            OpenGL.translate(p.x, p.y, p.z);
                                            OpenGL.translate(-rPos.x, -(rPos.y), -rPos.z);
                                            OpenGL.rotate(-Game.minecraft().player.rotationYaw - 180, 0, 1, 0);
                                            OpenGL.rotate(-Game.minecraft().player.rotationPitch, 1, 0, 0);

                                            OpenGL.pushMatrix();
                                            {
                                                OpenGL.rotate(Game.minecraft().player.rotationYaw - 180, 0, 1, 0);
                                                float indicatorScale = 0.05F;
                                                OpenGL.blendClear();
                                                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                                                OpenGL.scale(indicatorScale, indicatorScale, indicatorScale);
                                                OpenGL.rotate(-Game.minecraft().player.rotationYaw, 0, 1, 0);

                                                if (organism.hasEmbryo())
                                                {
                                                    OpenGL.color4i(0xFFFF0000);
                                                    Draw.drawResourceCentered(AVP.resources().INFECTION_INDICATOR, 2, -1, 2, 2, 255, 0, 0, 255);
                                                }

                                                int color = organism.hasEmbryo() || living instanceof IMob ? 0xFFFF0000 : 0xFF00AAFF;
                                                int textMultiplier = 10;
                                                int textX = 20;
                                                int textY = -38 + textMultiplier;
                                                float textScale = 0.0625F;
                                                OpenGL.rotate(180F, 0F, 1F, 0F);
                                                OpenGL.scale(textScale, -textScale, textScale);

                                                String dist = ((int) living.getDistance((Game.minecraft().player)) + "");
                                                Draw.drawString(dist, textX - 19 - (Draw.getStringRenderWidth(dist) / 2), (textY += textMultiplier) + 15, color, false);

                                                if (organism.hasEmbryo())
                                                {
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
                                }
                            }
                        }
                    }
                    OpenGL.popMatrix();
                }
            }
        }
    }

    @SubscribeEvent
    public void renderTickOverlay(RenderGameOverlayEvent.Pre event)
    {
        if (Game.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
            {
                if (Inventories.getHelmSlotItemStack(Game.minecraft().player) != null && Game.minecraft().gameSettings.thirdPersonView == 0 && Inventories.getHelmSlotItemStack(Game.minecraft().player).getItem() == AVPItems.HELM_MARINE)
                {
                    SpecialPlayer specialPlayer = (SpecialPlayer) Game.minecraft().player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

                    this.gammaRestored = false;
                    LightmapUpdateEvent.instance.gammaValue = specialPlayer.isNightvisionEnabled() ? 8F : 0F;
                    LightmapUpdateEvent.instance.overrideGamma();
                    this.scanForNearbyPlayers();
                    OpenGL.enableBlend();
                    OpenGL.blendClear();
                    OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                    OpenGL.color(1F, 1F, 1F, 1F);
                    AVP.resources().BLUR_TACTICAL_HUD.bind();
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
        }
    }

    @SubscribeEvent
    public void renderTick(RenderGameOverlayEvent event)
    {
        if (Game.minecraft().player != null && event.getType() == ElementType.HOTBAR)
        {
            this.renderInventoryElements(event);
        }
        
        if (Game.minecraft().player != null && event.getType() == ElementType.HELMET)
        {
            if (Game.minecraft().player.getRidingEntity() instanceof EntityAPC)
            {
                EntityAPC apc = (EntityAPC) Game.minecraft().player.getRidingEntity();
                double apcVelocity = Math.sqrt(apc.motionX * apc.motionX + apc.motionZ * apc.motionZ);
                EntityAPC.Gear apcGear = EntityAPC.Gear.forVelocity(apcVelocity);
                
                Draw.drawString("Gear: " + apcGear.ordinal(), 10, 10, 0xFFFF0000, false);
            }
        }
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event)
    {
        if (Game.minecraft().world != null && event.phase == Phase.START)
        {
            this.electrocardiogram.update(Game.minecraft().world);
            this.wavegraph1.setRate(750);
            this.wavegraph2.setRate(450);
            this.wavegraph1.update(Game.minecraft().world);
            this.wavegraph2.update(Game.minecraft().world);

            if (buttonMarineHelmConfig.getAction() == null)
            {
                guiSettings = new GuiTacticalHUDSettings(Game.minecraft().currentScreen);
                buttonMarineHelmConfig.setAction(new IAction() {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        Game.minecraft().displayGuiScreen(guiSettings);
                    }
                });
            }
        }
    }

    public void renderInventoryElements(RenderGameOverlayEvent event)
    {
        if (Inventories.getHelmSlotItemStack(Game.minecraft().player) != null && Inventories.getHelmSlotItemStack(Game.minecraft().player).getItem() == AVPItems.HELM_MARINE)
        {
            if (Game.minecraft().currentScreen instanceof GuiInventory || Game.minecraft().currentScreen instanceof GuiChat)
            {
                buttonMarineHelmConfig.displayString = "Configure";
                buttonMarineHelmConfig.tooltip = "Click to configure the Tactical HUD.";
                buttonMarineHelmConfig.width = 70;
                buttonMarineHelmConfig.baseColor = 0x44000000;
                buttonMarineHelmConfig.x = Screen.scaledDisplayResolution().getScaledWidth() - buttonMarineHelmConfig.width;
                buttonMarineHelmConfig.y = 0;
                buttonMarineHelmConfig.drawButton();
            }
        }
    }

    public SpecialPlayer getSpecialPlayer()
    {
        return Game.minecraft() != null ? Game.minecraft().player != null ? this.specialPlayer = (SpecialPlayer) Game.minecraft().player.getCapability(SpecialPlayer.Provider.CAPABILITY, null) : null : null;
    }

    public Organism getPlayerOrganism()
    {
        return Game.minecraft() != null ? Game.minecraft().player != null ? this.playerOrganism = (Organism) Game.minecraft().player.getCapability(Provider.CAPABILITY, null) : null : null;
    }

    public void changeChannel(String channel)
    {
        this.specialPlayer.setBroadcastChannel(channel);
    }

    public void drawInfoBar(RenderGameOverlayEvent.Pre event)
    {
        int batteryPercent = 100;

        int hourOfMinecraftDay = (int) (Math.floor(Game.minecraft().player.world.getWorldTime() / 1000 + 8) % 24);
        int minuteOfMinecraftDay = (int) (60 * Math.floor(Game.minecraft().player.world.getWorldTime() % 1000) / 1000);

        String timeString = String.format("[%02d:%02d]", hourOfMinecraftDay, minuteOfMinecraftDay);
        String fpsString = Game.minecraft().debug.substring(0, Game.minecraft().debug.indexOf(" fps"));
        String barString = String.format("[%sFPS] [%s%%] %s", fpsString, batteryPercent, timeString);
        String bar2String = String.format("[X %s] [Y %s] [Z %s]", Math.round(Game.minecraft().player.posX), Math.round(Game.minecraft().player.posY), Math.round(Game.minecraft().player.posZ));
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

                String line1 = String.format("TYPE: %s", this.playerOrganism.getEmbryo().getNascenticOrganism() != null ? this.playerOrganism.getEmbryo().getNascenticOrganism().getClass().getSimpleName().replace("Entity", "") : "Unknown");
                String line2 = String.format("VITAL.TIME: %s.%sM", lifeTimeSeconds / 60, lifeTimeSeconds % 60);
                String line3 = String.format("EID: %s", this.playerOrganism.getEmbryo().getRegistrationId());

                OpenGL.pushMatrix();
                {
                    float scale = 0.5F;
                    OpenGL.scale(scale, scale, scale);
                    OpenGL.translate(event.getResolution().getScaledWidth() * 2 - 30F, event.getResolution().getScaledHeight() * 2 - 60F, 0F);
                    OpenGL.rotate(-180 + 15F, 0F, 0F, 1F);
                    OpenGL.rotate(25F, 0F, 1F, 0F);

                    OpenGL.color4i(0xFFFF0000);
                    AVP.resources().INFECTION_INDICATOR.bind();
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
                    Draw.drawString(Game.minecraft().player.getName().toUpperCase(), 0, 0, 0xFF00AAFF, false);
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
                AVP.resources().BATTERY_INDICATOR.bind();
                Draw.drawQuad(btX, btY, btWidth, btHeight, 0F, 1F, 0F, 0.5F);
                Draw.drawQuad(btX, btY, batteryWidth, btHeight, 0F, maxU, 0.5F, 1F);
            }
            OpenGL.popMatrix();
        }
        OpenGL.popMatrix();
    }

    public void drawImpregnationIndicator(Organism organism)
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
        // if (!Game.minecraft().player.capabilities.isCreativeMode)
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
        EntityPlayer playerFound = (EntityPlayer) Game.minecraft().player.world.findNearestEntityWithinAABB(EntityPlayer.class, Game.minecraft().player.getEntityBoundingBox().expand(this.getSpecialPlayer().getBroadcastRadius(), 128.0D, this.getSpecialPlayer().getBroadcastRadius()), Game.minecraft().player);

        if (playerFound != null)
        {
            SpecialPlayer specialPlayer = (SpecialPlayer) playerFound.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

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
            SpecialPlayer specialPlayer = (SpecialPlayer) player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

            if (player != null || player != null && !specialPlayer.getBroadcastChannel().equalsIgnoreCase(this.specialPlayer.getBroadcastChannel()))
            {
                playersInHUD.remove(x);
            }

            if (x <= viewportThreshold && player != null)
            {
                int barSpace = 15;
                int signal = (int) Game.minecraft().player.getDistanceSq(player);
                int maxSignal = specialPlayer.getBroadcastRadius() <= this.specialPlayer.getBroadcastRadius() ? specialPlayer.getBroadcastRadius() : this.specialPlayer.getBroadcastRadius();
                int pxMultiplier = signal >= maxSignal / 1.3 ? 5 : signal >= maxSignal / 2 ? 4 : signal >= maxSignal / 3 ? 3 : signal >= maxSignal / 4 ? 2 : signal >= maxSignal / 5 ? 1 : signal >= maxSignal / 6 ? 0 : 0;

                Draw.drawRect(Screen.scaledDisplayResolution().getScaledWidth() - 111, 40 + barSpace * x - 5, 120, 2, 0xAA00AAFF);
                Draw.drawRect(Screen.scaledDisplayResolution().getScaledWidth() - 111, 42 + barSpace * x - 5, 2, 9, 0xAA00AAFF);

                if (Game.minecraft().player.getDistanceSq(player) <= this.specialPlayer.getBroadcastRadius() && signal <= maxSignal / 1.3)
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
