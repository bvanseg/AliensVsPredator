package org.avp.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.common.PlayerModeHandler;
import org.avp.common.item.firearm.ItemFirearm;
import org.avp.common.item.firearm.ItemFlamethrower;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;
import org.avp.common.world.playermode.PlayerMode;

public class PlayerModeRenderEvent
{
    public static final PlayerModeRenderEvent instance = new PlayerModeRenderEvent();
    private final RenderPlayer2 renderLiving = new RenderPlayer2();

    private class RenderPlayer2 extends RenderLivingBase<EntityLivingBase>
    {
        public RenderPlayer2()
        {
            super(ClientGame.instance.renderManager(), new ModelBiped(), 0F);
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
        SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) event.getEntityPlayer().getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);
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
