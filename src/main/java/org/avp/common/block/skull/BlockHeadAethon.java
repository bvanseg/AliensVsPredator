package org.avp.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.alien.client.model.tile.skull.ModelAethonHead;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;

public class BlockHeadAethon extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelAethonHead m = Resources.instance.models().HEAD_AETHON.getModel();
        return new ModelRenderer[] { m.head };
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
        return Resources.instance.models().HEAD_AETHON.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/concrete_powder_white");
    }
}
