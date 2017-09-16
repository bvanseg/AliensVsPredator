package org.avp.client.render;

import org.avp.PlayerModeHandler;
import org.avp.item.ItemFirearm;
import org.avp.item.ItemFlamethrower;
import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.avp.world.playermode.PlayerMode;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerModeRenderEvent
{
    public static final PlayerModeRenderEvent instance = new PlayerModeRenderEvent();
    private RenderPlayer2 renderLiving = new RenderPlayer2();

    private class RenderPlayer2 extends RenderLivingBase<EntityLivingBase>
    {
        public RenderPlayer2()
        {
            super(Game.renderManager(), new ModelBiped(), 0F);
        }
        
        @Override
        public void doRender(EntityLivingBase entityLiving, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
        {
            OpenGL.pushMatrix();
            {
                OpenGL.rotate(-yaw, 0F, 1F, 0F);
                OpenGL.rotate(180F, 1F, 0F, 0F);
                GlStateManager.disableCull();

                PlayerModeHandler.instance().getTextureForPlayer((EntityPlayer) entityLiving).bind();
                PlayerModeHandler.instance().getModelForPlayer((EntityPlayer) entityLiving).render(entityLiving);
            }
            OpenGL.popMatrix();
        }

        @Override
        protected ResourceLocation getEntityTexture(EntityLivingBase entity)
        {
            return null;
        }
    };

    @SubscribeEvent
    public void renderEntityTick(RenderPlayerEvent.Pre event)
    {
        SpecialPlayer specialPlayer = (SpecialPlayer) event.getEntityPlayer().getCapability(SpecialPlayer.Provider.CAPABILITY, null);
        ItemStack itemstack = event.getEntityPlayer().inventory.getCurrentItem();

        if (itemstack != null && (itemstack.getItem() instanceof ItemFirearm || itemstack.getItem() instanceof ItemFlamethrower))
        {
            event.getRenderer().getMainModel().rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
        }
        else
        {
            event.getRenderer().getMainModel().rightArmPose = ModelBiped.ArmPose.EMPTY;
        }

        if (event.getEntity() != null && specialPlayer.getPlayerMode() != PlayerMode.NORMAL)
        {
            renderLiving.doRender((EntityLivingBase) event.getEntity(), event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, event.getEntity().rotationYaw, event.getPartialRenderTick());
            event.setCanceled(true);
        }
    }
}
