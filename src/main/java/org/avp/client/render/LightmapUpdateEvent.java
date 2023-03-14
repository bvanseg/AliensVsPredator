package org.avp.client.render;

import com.asx.mdx.lib.util.Game;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;


public class LightmapUpdateEvent
{
    public static final LightmapUpdateEvent instance = new LightmapUpdateEvent();
    public float gammaValue = 0F;
    private boolean gammaOverride;
    private int ticksPassed = 0;
    
    public void overrideGamma()
    {
        this.gammaOverride = true;
        this.ticksPassed = 0;
    }

    @SubscribeEvent
    public void renderTick(RenderTickEvent event)
    {
        if (gammaOverride)
        {
            this.updateLightmap(event.renderTickTime);
            ticksPassed++;
            
            if (ticksPassed > 20 * 5)
            {
                this.gammaOverride = false;
            }
        }
    }

    public void updateLightmap(float partialTicks)
    {
        Minecraft mc = Game.minecraft();
        WorldClient worldclient = mc.world;

        if (worldclient != null)
        {
            for (int i = 0; i < 256; ++i)
            {
                float f1 = worldclient.getSunBrightness(1.0F) * 0.95F + 0.05F;
                float f2 = worldclient.provider.getLightBrightnessTable()[i / 16] * f1;
                float f3 = worldclient.provider.getLightBrightnessTable()[i % 16] * (Game.getTorchFlickerX() * 0.1F + 1.5F);

                if (worldclient.getLastLightningBolt() > 0)
                {
                    f2 = worldclient.provider.getLightBrightnessTable()[i / 16];
                }

                float f4 = f2 * (worldclient.getSunBrightness(1.0F) * 0.65F + 0.35F);
                float f5 = f2 * (worldclient.getSunBrightness(1.0F) * 0.65F + 0.35F);
                float f6 = f3 * ((f3 * 0.6F + 0.4F) * 0.6F + 0.4F);
                float f7 = f3 * (f3 * f3 * 0.6F + 0.4F);
                float f8 = f4 + f3;
                float f9 = f5 + f6;
                float f10 = f2 + f7;
                f8 = f8 * 0.96F + 0.03F;
                f9 = f9 * 0.96F + 0.03F;
                f10 = f10 * 0.96F + 0.03F;
                float gamma;

                if (Game.getBossColorModifier() > 0.0F)
                {
                    gamma = Game.getBossColorModifierPrev() + (Game.getBossColorModifier() - Game.getBossColorModifierPrev()) * partialTicks;
                    f8 = f8 * (1.0F - gamma) + f8 * 0.7F * gamma;
                    f9 = f9 * (1.0F - gamma) + f9 * 0.6F * gamma;
                    f10 = f10 * (1.0F - gamma) + f10 * 0.6F * gamma;
                }

                if (worldclient.provider.getDimension() == 1)
                {
                    f8 = 0.22F + f3 * 0.75F;
                    f9 = 0.28F + f6 * 0.75F;
                    f10 = 0.25F + f7 * 0.75F;
                }

                float f12;

                if (mc.player.isPotionActive(MobEffects.NIGHT_VISION))
                {
                    gamma = this.getNightVisionBrightness(mc.player, partialTicks);
                    f12 = 1.0F / f8;

                    if (f12 > 1.0F / f9)
                    {
                        f12 = 1.0F / f9;
                    }

                    if (f12 > 1.0F / f10)
                    {
                        f12 = 1.0F / f10;
                    }

                    f8 = f8 * (1.0F - gamma) + f8 * f12 * gamma;
                    f9 = f9 * (1.0F - gamma) + f9 * f12 * gamma;
                    f10 = f10 * (1.0F - gamma) + f10 * f12 * gamma;
                }

                if (f8 > 1.0F)
                {
                    f8 = 1.0F;
                }

                if (f9 > 1.0F)
                {
                    f9 = 1.0F;
                }

                if (f10 > 1.0F)
                {
                    f10 = 1.0F;
                }

                gamma = gammaValue + mc.gameSettings.gammaSetting;
                f12 = 1.0F - f8;
                float f13 = 1.0F - f9;
                float f14 = 1.0F - f10;
                f12 = 1.0F - f12 * f12 * f12 * f12;
                f13 = 1.0F - f13 * f13 * f13 * f13;
                f14 = 1.0F - f14 * f14 * f14 * f14;
                f8 = f8 * (1.0F - gamma) + f12 * gamma;
                f9 = f9 * (1.0F - gamma) + f13 * gamma;
                f10 = f10 * (1.0F - gamma) + f14 * gamma;
                f8 = f8 * 0.96F + 0.03F;
                f9 = f9 * 0.96F + 0.03F;
                f10 = f10 * 0.96F + 0.03F;

                if (f8 > 1.0F)
                {
                    f8 = 1.0F;
                }

                if (f9 > 1.0F)
                {
                    f9 = 1.0F;
                }

                if (f10 > 1.0F)
                {
                    f10 = 1.0F;
                }

                if (f8 < 0.0F)
                {
                    f8 = 0.0F;
                }

                if (f9 < 0.0F)
                {
                    f9 = 0.0F;
                }

                if (f10 < 0.0F)
                {
                    f10 = 0.0F;
                }

                short short1 = 255;
                int j = (int) (f8 * 255.0F);
                int k = (int) (f9 * 255.0F);
                int l = (int) (f10 * 255.0F);
                Game.getLightmapColors()[i] = short1 << 24 | j << 16 | k << 8 | l;
            }

            Game.getLightmapTexture().updateDynamicTexture();
            Game.setLightmapUpdateNeeded(false);
        }
    }

    private float getNightVisionBrightness(EntityPlayer entityPlayer, float partialTicks)
    {
        return entityPlayer.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration() > 200 ? 1.0F : 0.7F + MathHelper.sin((entityPlayer.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration() - partialTicks) * (float) Math.PI * 0.2F) * 0.3F;
    }
}
