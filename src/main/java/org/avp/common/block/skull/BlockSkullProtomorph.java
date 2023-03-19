package org.avp.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.model.tile.skull.ModelProtomorphSkull;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;

public class BlockSkullProtomorph extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelProtomorphSkull m = Resources.instance.models().PROTOMORPH_SKULL.getModel();
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
        return Resources.instance.models().PROTOMORPH_SKULL.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
}
