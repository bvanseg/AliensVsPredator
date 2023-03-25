package org.alien.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.alien.client.AlienResources;
import org.alien.client.model.tile.skull.ModelProtomorphSkull;
import org.avp.common.block.BlockSkull;

public class BlockSkullProtomorph extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelProtomorphSkull m = AlienResources.instance.models().PROTOMORPH_SKULL.getModel();
        return new ModelRenderer[] { m.head1 };
    }

    @Override
    public void preRenderTransforms()
    {
        float scale = 1.9F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, -1.5F, 0F);
    }

    @Override
    public Texture getSkullTexture()
    {
        return AlienResources.instance.models().PROTOMORPH_SKULL.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
}
