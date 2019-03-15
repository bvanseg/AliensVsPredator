package org.avp.client.render;

import static org.lwjgl.opengl.GL11.GL_ALPHA_TEST;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_CONSTANT_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glDepthMask;

import org.avp.AliensVsPredator;
import org.avp.api.power.IVoltageReceiver;
import org.avp.entities.living.EntityMarine;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.tile.TileEntityPowercell;
import org.avp.tile.TileEntityStasisMechanism;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;
import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.avp.world.dimension.varda.WorldProviderVarda;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.ScaledResolution;
import com.asx.mdx.lib.client.util.Screen;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.block.Blocks;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class PressureHUDRenderEvent
{
    public static final PressureHUDRenderEvent instance = new PressureHUDRenderEvent();
    private boolean gammaRestored = true;

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event)
    {
        ;
    }

    @SubscribeEvent
    public void renderTickOverlay(RenderGameOverlayEvent.Pre event)
    {
        if (Game.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR)
            {
                if (Inventories.getHelmSlotItemStack(Game.minecraft().player) != null && Game.minecraft().gameSettings.thirdPersonView == 0 && Inventories.getHelmSlotItemStack(Game.minecraft().player).getItem() == AliensVsPredator.items().pressureMask)
                {
                    SpecialPlayer specialPlayer = (SpecialPlayer) Game.minecraft().player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

                    this.gammaRestored = false;
                    LightmapUpdateEvent.instance.gammaValue = specialPlayer.isNightvisionEnabled() ? 8F : 0F;
                    OpenGL.disableLight();
                    OpenGL.disableLightMapping();

                    OpenGL.enable(GL_BLEND);
                    OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                    OpenGL.disable(GL_DEPTH_TEST);
                    glDepthMask(false);
                    OpenGL.color(1F, 1F, 1F, 1F);
                    OpenGL.disable(GL_ALPHA_TEST);
                    // RenderUtil.bindTexture(AliensVsPredator.resources().BLUR_TACTICAL_HUD);
                    // RenderUtil.drawQuad(0, 0, RenderUtil.scaledDisplayResolution().getScaledWidth(), RenderUtil.scaledDisplayResolution().getScaledHeight());
                    glDepthMask(true);
                    OpenGL.enable(GL_DEPTH_TEST);
                    OpenGL.enable(GL_ALPHA_TEST);
                    OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
                    OpenGL.disable(GL_BLEND);

                    this.drawInfoBar();
                    this.drawImpregnationIndicator(Game.minecraft().player, getProperties());
                }
                else if (!gammaRestored)
                {
                    this.gammaRestored = true;
                    LightmapUpdateEvent.instance.gammaValue = 0F;
                }
            }
        }
    }

    @SubscribeEvent
    public void renderTick(RenderTickEvent event)
    {
        if (Game.minecraft().player != null)
        {
            this.renderInventoryElements();
        }
    }

    public void renderInventoryElements()
    {
        if (Inventories.getHelmSlotItemStack(Game.minecraft().player) != null && Inventories.getHelmSlotItemStack(Game.minecraft().player).getItem() == AliensVsPredator.items().pressureMask)
        {
            ;
        }
    }

    public SpecialPlayer getProperties()
    {
        return Game.minecraft() != null ? Game.minecraft().player != null ? (SpecialPlayer) Game.minecraft().player.getCapability(SpecialPlayer.Provider.CAPABILITY, null) : null : null;
    }

    public void drawInfoBar()
    {
        ScaledResolution res = Screen.scaledDisplayResolution();
        int guiScale = Game.minecraft().gameSettings.guiScale;
        float scale = guiScale == 0 ? res.getScaleFactor() * 0.25F : (guiScale == 1 ? res.getScaleFactor() * 1F : res.getScaleFactor() * 0.5F);
        int barPadding = 40;

        int hourOfMinecraftDay = (int) (Math.floor(Game.minecraft().player.world.getWorldTime() / 1000 + 8) % 24);
        int minuteOfMinecraftDay = (int) (60 * Math.floor(Game.minecraft().player.world.getWorldTime() % 1000) / 1000);

        String timeString = String.format("%02dH%02dM", hourOfMinecraftDay, minuteOfMinecraftDay);
        String fpsString = Game.minecraft().debug.substring(0, Game.minecraft().debug.indexOf(" fps")) + " FPS";
        String barString = timeString + " [" + fpsString + "]";

        OpenGL.pushMatrix();
        {
            FontRenderer fontrenderer = Game.minecraft().fontRenderer;
            OpenGL.scale(scale, scale, scale);
            OpenGL.enable(GL_BLEND);
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
            Draw.drawString(barString, barPadding, 25, 0xFF666666, false);
            OpenGL.pushMatrix();
            {
                float nameScale = 1.5F;
                OpenGL.scale(nameScale, nameScale, nameScale);
                Draw.drawString("[" + 100 + "%%] " + Game.minecraft().player.getName(), (int) ((barPadding) / nameScale), (int) (10 / nameScale), 0xFFFFAA00, false);
            }
            OpenGL.popMatrix();
            OpenGL.color4i(0xFFFFFFFF);

            Draw.drawPlayerFace(Game.minecraft().player, 0, 0, 32, 32);

            /** Silica storm detection indicator **/
            WorldProvider provider = Game.minecraft().world.provider;

            if (provider instanceof WorldProviderVarda)
            {
                WorldProviderVarda providerVarda = (WorldProviderVarda) provider;
//                long stormStartTime = providerVarda.getStormProvider().getStormStartTime() * 1000L;
//                long stormEndTime = providerVarda.getStormProvider().getStormEndTime() * 1000L;
//                long worldTime = providerVarda.getWorldTime();
//                int warningTime = 1000;
//                int timeUntilStorm = (int) (stormStartTime - provider.getWorldTime());

//                if ((timeUntilStorm < warningTime && worldTime < stormStartTime || worldTime > stormStartTime && worldTime % 20 <= 10) && worldTime <= stormEndTime + 1000)
//                {
//                    OpenGL.enableBlend();
//                    OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
//                    int indicatorWidth = 300;
//                    int indicatorHeight = 30;
//                    int indicatorX = (Screen.scaledDisplayResolution().getScaledWidth() / 2) - (indicatorWidth / 2);
//                    int indicatorY = 0;
//                    Draw.drawRect(indicatorX, indicatorY, indicatorWidth, indicatorHeight, 0x66333333);
//                    OpenGL.pushMatrix();
//                    {
//                        float nameScale = 1.5F;
//                        OpenGL.scale(nameScale, nameScale, nameScale);
//
//                        int actualX = (int) ((indicatorX) / nameScale);
//                        int actualY = (int) ((indicatorY) / nameScale);
//                        int actualWidth = (int) (indicatorWidth / nameScale);
//                        int actualHeight = (int) (indicatorHeight / nameScale);
//                        fontrenderer.drawString("Storm Indicator for " + provider.getDimensionType().getName(), actualX + 7, actualY + 7, 0xFFAA00);
//
//                        if (Worlds.canSeeSky(new Pos(Game.minecraft().player), Game.minecraft().world))
//                        {
//                            Draw.drawStringAlignCenter("You are outdoors, take cover immediately!", (int) ((Screen.scaledDisplayResolution().getScaledWidth() / 2) / nameScale), actualY + 35, 0xFF0000);
//                        }
//
//                        if (worldTime > stormStartTime)
//                        {
//                            Draw.drawProgressBar("Storm Inbound", (int) stormStartTime, 0, actualX, actualY + 20, actualWidth, 4, 2, 0xFFFFAA00, false);
//                        }
//                        else
//                        {
//                            Draw.drawProgressBar("Time Until Storm (" + (timeUntilStorm / 20) + " seconds)", (int) stormStartTime, ((int) stormStartTime - (int) worldTime), actualX, actualY + 20, actualWidth, 4, 2, (timeUntilStorm / 20) < 15 ? 0xFFFF0000 : 0xFFFFAA00, false);
//                        }
//                    }
//                    OpenGL.popMatrix();
//                    OpenGL.color4i(0xFFFFFFFF);
//                }
            }

            if (Game.minecraft().player != null)
            {
                if (Game.minecraft().objectMouseOver != null)
                {
                    /** GUI Drawing Information **/
                    int subMenuX = (int) (Screen.scaledDisplayResolution().getScaledWidth() - (200 * scale));
                    int subMenuY = 0;
                    int subMenuPadding = 10;
                    int subMenuStartY = subMenuY + subMenuPadding / 2;
                    int subEntrySpacing = 10;
                    int curEntry = 0;

                    if (Game.minecraft().objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY)
                    {
                        Entity entity = Game.minecraft().objectMouseOver.entityHit;

                        if (entity != null)
                        {
                            subMenuStartY = 5 + subMenuStartY;

                            OpenGL.pushMatrix();
                            {
                                float nameScale = 1.5F;
                                OpenGL.scale(nameScale, nameScale, nameScale);
                                fontrenderer.drawString("" + entity.getName(), (int) ((subMenuX + subMenuPadding) / nameScale), (int) ((subMenuStartY + (curEntry++ * subEntrySpacing)) / nameScale), 0xFFAA00);
                            }
                            OpenGL.popMatrix();

                            if (entity instanceof EntityLivingBase)
                            {
                                Draw.drawProgressBar((int) ((EntityLivingBase) entity).getHealth() + "/" + (int) ((EntityLivingBase) entity).getMaxHealth(), (int) ((EntityLivingBase) entity).getMaxHealth(), (int) ((EntityLivingBase) entity).getHealth(), Screen.scaledDisplayResolution().getScaledWidth() - 190, 25, 180, 1, 0, 0xFF00AAFF, false);
                            }
                            else
                            {
                                Draw.drawProgressBar("NULL / NULL", 1, 1, 10, 7, Screen.scaledDisplayResolution().getScaledWidth() - 20, 1, 0, 0xFF777777, false);
                            }
                            OpenGL.enableBlend();
                            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);

                            subMenuStartY = subMenuStartY + 20;

                            fontrenderer.drawString("Entity Type: " + entity.getClass().getSuperclass().getSimpleName(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);

                            if (entity instanceof EntityLiving)
                            {

                                if (((EntityLiving) entity).getAttackTarget() != null)
                                {
                                    fontrenderer.drawString("AttackTarget: " + ((EntityLiving) entity).getAttackTarget().getName(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                                    fontrenderer.drawString("Distance to Target: " + (((EntityLiving) entity).getAttackTarget() != null ? entity.getDistanceSq(((EntityLiving) entity).getAttackTarget()) : 0), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                                }

                                fontrenderer.drawString("LastAttacked: " + ((EntityLiving) entity).getLastAttackedEntityTime(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);

                                if (((EntityLiving) entity).getLastAttackedEntity() != null)
                                {
                                    fontrenderer.drawString("LastAttacker: " + ((EntityLiving) entity).getLastAttackedEntity().getName(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                                }

                                fontrenderer.drawString("Armor: " + ((EntityLiving) entity).getTotalArmorValue(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                                fontrenderer.drawString("FireImmunity: " + ((EntityLiving) entity).isImmuneToFire(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                            }

                            if (entity instanceof EntityLivingBase)
                            {
                                EntityLivingBase entityLiving = (EntityLivingBase) entity;
//                                Organism extendedLiving = (Organism) entityLiving.getExtendedProperties(Organism.IDENTIFIER);

                                fontrenderer.drawString("Age: " + entityLiving.getIdleTime(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);

//                                if (!(entity instanceof EntitySpeciesAlien) && extendedLiving.getEmbryo() != null)
//                                    fontrenderer.drawString("Parasite Type: " + extendedLiving.getEmbryo().getResult().getSimpleName(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                            }

                            if (entity instanceof SpeciesAlien)
                            {
                                fontrenderer.drawString("Jelly Level: " + ((SpeciesAlien) entity).getJellyLevel(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                            }

//                            if (entity instanceof EntityChestburster)
//                            {
//                                fontrenderer.drawString("Parasite Age: " + ((EntityChestburster) entity).ticksExisted + "/" + ((EntityChestburster) entity).getMaxParasiteAge(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
//                            }

                            if (entity instanceof EntityMarine)
                            {
                                fontrenderer.drawString("Type: " + ((EntityMarine) entity).getMarineType(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                                fontrenderer.drawString("IsFiring: " + ((EntityMarine) entity).isFiring(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                            }

                            int curHeight = 20 + 12 * curEntry;

                            if (entity instanceof Entity)
                            {
                                OpenGL.disableBlend();
                                OpenGL.color(1F, 1F, 1F);
                                Draw.drawEntity(Screen.scaledDisplayResolution().getScaledWidth() - 100, curHeight + 140, 30, -45, 0, entity);
                                OpenGL.enableBlend();
                                OpenGL.disableLight();
                                OpenGL.color(1F, 1F, 1F);
                            }

                            curHeight = curHeight + 150;

                            OpenGL.enableBlend();
                            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                            Draw.drawRect(Screen.scaledDisplayResolution().getScaledWidth() - 200, 0, 200, curHeight, 0x66333333);
                            OpenGL.blendClear();
                            OpenGL.disableBlend();
                        }
                    }

                    if (Game.minecraft().objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK)
                    {
                        /** Block Information **/
//                        Pos coord = new Pos(Game.minecraft().objectMouseOver.getBlockPos().getX(), Game.minecraft().objectMouseOver.getBlockPos().getY(), Game.minecraft().objectMouseOver.blockZ);
                        BlockPos blockpos = Game.minecraft().objectMouseOver.getBlockPos();
                        IBlockState blockstate = Game.minecraft().world.getBlockState(blockpos);
                        Block block = blockstate.getBlock();
                        TileEntity tile = Game.minecraft().player.world.getTileEntity(blockpos);

                        Draw.drawItem(new ItemStack(Item.getItemFromBlock(block), 1), subMenuX + subMenuPadding - 56, 0, 48, 48);

                        OpenGL.pushMatrix();
                        {
                            float nameScale = 1.5F;
                            OpenGL.scale(nameScale, nameScale, nameScale);
                            fontrenderer.drawString("" + block.getLocalizedName(), (int) ((subMenuX + subMenuPadding) / nameScale), (int) ((subMenuStartY + (curEntry++ * subEntrySpacing)) / nameScale), 0xFFAA00);
                        }
                        OpenGL.popMatrix();

                        subMenuStartY = subMenuStartY + 10;

                        String blockDomain = Blocks.getDomain(block);
                        ModContainer modContainer = Game.getModContainer(blockDomain.replace(":", ""));
                        String mod = modContainer != null ? modContainer.getName() : "???";
                        fontrenderer.drawString("From " + mod, subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);
                        fontrenderer.drawString("Looking at " + (Game.minecraft().objectMouseOver.sideHit.name()) + " face", subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0x666666);

                        if (tile instanceof TileEntity)
                        {
                            fontrenderer.drawString("Tile Entity: " + true, subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0xFFAA00);
                        }

                        if (tile instanceof IVoltageReceiver)
                        {
                            IVoltageReceiver poweredTile = (IVoltageReceiver) tile;
                            fontrenderer.drawString("Voltage: " + ((float) poweredTile.getCurrentVoltage(EnumFacing.SOUTH)) + "V", subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0xFFAA00);
                        }

                        if (tile instanceof TileEntityPowercell)
                        {
                            TileEntityPowercell powercell = (TileEntityPowercell) tile;
                            double percent = (powercell.getEnergyStored() * 100) / powercell.getMaxEnergyStored();
                            fontrenderer.drawString("Charge: " + percent + "% (" + powercell.getEnergyStored() + "/" + powercell.getMaxEnergyStored() + ")", subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0xFFAA00);
                        }

                        if (tile instanceof TileEntityStasisMechanism)
                        {
                            TileEntityStasisMechanism stasisMechanism = (TileEntityStasisMechanism) tile;
                            fontrenderer.drawString("Stasis Entity: " + stasisMechanism.getStasisEntity(), subMenuX + subMenuPadding, subMenuStartY + (curEntry++ * subEntrySpacing), 0xFFAA00);
                        }

                        int curHeight = 20 + 12 * curEntry;

                        OpenGL.enableBlend();
                        OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                        Draw.drawRect(Screen.scaledDisplayResolution().getScaledWidth() - 246, 0, 246, curHeight, 0x66333333);
                        OpenGL.blendClear();
                        OpenGL.disableBlend();

                    }

                    OpenGL.disableBlend();
                }
            }
        }
        OpenGL.popMatrix();
    }

    public void drawImpregnationIndicator(EntityLivingBase living, SpecialPlayer playerProperties)
    {
        if (playerProperties != null)
        {
            EntityPlayer player = (EntityPlayer) living;
            Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);

            if (organism.hasEmbryo() && living.world.getWorldTime() % 20 <= 10)
            {
                ScaledResolution res = Screen.scaledDisplayResolution();
                int lifeTimeTicks = organism.getEmbryo().getGestationPeriod() - organism.getEmbryo().getAge();
                int lifeTimeSeconds = lifeTimeTicks / 20;
                int iconSize = 64;

                OpenGL.enable(GL_BLEND);
                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_CONSTANT_ALPHA);
                OpenGL.pushMatrix();
                {
                    float scale = 1.5F;
                    OpenGL.scale(scale, scale, scale);
                    Draw.drawStringAlignRight("Analysis Complete:", (int) ((res.getScaledWidth() / scale) - (iconSize / scale)), (int) (10 / scale), 0xFFFFAA00);
                }
                OpenGL.popMatrix();
                Draw.drawStringAlignRight("1 Foreign Organism(s) Detected", res.getScaledWidth() - iconSize, 25, 0x666666);
                Draw.drawStringAlignRight("Please do NOT terminate organism.", res.getScaledWidth() - iconSize, 35, 0x666666);

                if (!player.capabilities.isCreativeMode)
                {
                    Draw.drawStringAlignRight(lifeTimeSeconds / 60 + " Minute(s) Estimated Until Death", res.getScaledWidth() - iconSize, 45, 0xFFFFAA00);
                }

                OpenGL.color4i(0xFFFFAA00);
                AliensVsPredator.resources().INFECTION_INDICATOR.bind();
                Draw.drawQuad(res.getScaledWidth() - iconSize, 0, iconSize, iconSize);
            }
        }
    }
}
