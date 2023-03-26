package org.alien.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelWarrior;
import org.avp.common.block.BlockSkull;

public class BlockSkullXenomorphWarrior extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelWarrior m = AlienResources.instance.models().WARRIOR_SKULL.getModel();
        return new ModelRenderer[] { m.headBase, m.headSpine1, m.headSpine2, m.headTop, m.lHead, m.rHead, m.jaw, m.jaw2 };
    }

    @Override
    public void preRenderTransforms()
    {
        float scale = 1.5F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, 0.115F, 0F);
    }

    @Override
    public Texture getSkullTexture()
    {
        return AlienResources.instance.models().WARRIOR_SKULL.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
}
