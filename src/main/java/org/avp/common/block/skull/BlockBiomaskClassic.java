package org.avp.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;
import org.predator.client.model.tile.skull.ModelBiomaskClassic;

public class BlockBiomaskClassic extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelBiomaskClassic m = Resources.instance.models().BIOMASK_CLASSIC.getModel();
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
        return Resources.instance.models().BIOMASK_CLASSIC.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/stone");
    }
}
