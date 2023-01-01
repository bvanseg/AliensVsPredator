package org.avp.client.render.items;

import org.avp.block.BlockSkull;
import org.avp.block.skulls.BlockSkullMatriarch;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderItemSkull extends ItemRenderer<Model>
{
    private BlockSkull skull;

    public RenderItemSkull(BlockSkull skull)
    {
        super(null);
        this.skull = skull;
        Game.registerEventHandler(this);
    }

    @SubscribeEvent
    public void registerTextureAtlasSprites(TextureStitchEvent.Pre event)
    {
        //TODO: TextureAtlasSprite does not allow non-symmetrical aspect ratios. Cannot use original mob texture.
        //this.sprite = event.getMap().registerSprite(new Texture("avp", "mob/test"));
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(0.35F, -0.35F, 0.35F);
        OpenGL.translate(0F, 0.75F, 0.25F);
        GlStateManager.disableCull();
        this.draw(itemstack.getItem());
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.25F;
        OpenGL.scale(glScale, -glScale, glScale);
        OpenGL.translate(0.5F, -0.25, 0.5F);
        GlStateManager.disableCull();
        this.draw(itemstack.getItem());
        GlStateManager.enableCull();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.6F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, -0.5F, 0F);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        this.draw(itemstack.getItem());
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.53F;
        GlStateManager.disableCull();
        OpenGL.scale(glScale, -glScale, glScale);
        this.draw(itemstack.getItem());
    }

    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return this.skull.getParticleTexture(Game.minecraft().getTextureMapBlocks());
        //return this.sprite;
    }

    private void draw(Item item)
    {
        if (skull instanceof BlockSkullMatriarch)
        {
            float s = 0.55F;
            OpenGL.scale(s, s, s);
            OpenGL.rotate(-45, 1, 0, 0);
            OpenGL.translate(-1F, 1F, 0F);
        }
        
        if (skull.getSkullTexture() != null)
        {
            skull.getSkullTexture().bind();
        }

        skull.preRenderTransforms();

        for (ModelRenderer cube : skull.getSkullModelRenderers())
        {
            cube.render(Model.DEFAULT_SCALE);
        }
    }
}