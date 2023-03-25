package org.predator.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;
import org.predator.client.model.tile.skull.ModelBiomaskFalconer;

public class BlockBiomaskFalconer extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelBiomaskFalconer m = Resources.instance.models().BIOMASK_FALCONER.getModel();
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
        return Resources.instance.models().BIOMASK_FALCONER.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/log_oak");
    }
}
