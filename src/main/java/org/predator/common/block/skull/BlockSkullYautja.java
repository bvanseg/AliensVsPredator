package org.predator.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;
import org.predator.client.model.entity.living.ModelYautja;

public class BlockSkullYautja extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelYautja m = Resources.instance.models().YAUTJA_SKULL.getModel();
        return new ModelRenderer[] { m.face };
    }

    @Override
    public void preRenderTransforms()
    {
        float scale = 1.9F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, 0.25F, 0F);
    }

    @Override
    public Texture getSkullTexture()
    {
        return Resources.instance.models().YAUTJA_SKULL.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
}
