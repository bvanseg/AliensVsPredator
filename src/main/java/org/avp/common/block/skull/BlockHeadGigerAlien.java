package org.avp.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.alien.client.model.tile.skull.ModelGigerAlienHead;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;

public class BlockHeadGigerAlien extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelGigerAlienHead m = Resources.instance.models().GIGER_ALIEN_HEAD.getModel();
        return new ModelRenderer[] { m.head };
    }

    @Override
    public void preRenderTransforms()
    {
        float scale = 1F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.rotate(90F, 0, 1, 0);
        OpenGL.translate(0F, -1.25F, -0.25F);
    }

    @Override
    public Texture getSkullTexture()
    {
        return Resources.instance.models().GIGER_ALIEN_HEAD.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/hardened_clay_stained_gray");
    }
    
    @Override
    public boolean canChangeOrientation()
    {
        return true;
    }
}
