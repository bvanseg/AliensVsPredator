package org.avp.common.block.skulls;

import org.avp.AVP;
import org.avp.common.block.BlockSkull;
import org.avp.client.model.tile.skulls.ModelBiomaskTracker;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBiomaskTracker extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static class Resources
    {
        private static final MapModelTexture<ModelBiomaskTracker> model = AVP.resources().models().BIOMASK_TRACKER;
    }

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelBiomaskTracker m = Resources.model.getModel();
        return new ModelRenderer[] { m.biomaskMouth };
    }

    @Override
    public void preRenderTransforms()
    {
        float scale = 1.9F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, -1.3F, 0F);
    }

    @Override
    public Texture getSkullTexture()
    {
        return Resources.model.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/bedrock");
    }
}
