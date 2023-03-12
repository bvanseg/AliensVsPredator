package org.avp.common.block.skull;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.client.model.tile.skulls.ModelProtomorphSkull;
import org.avp.common.block.BlockSkull;

public class BlockSkullProtomorph extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static class Resources
    {
        private static final MapModelTexture<ModelProtomorphSkull> model = AVP.resources().models().PROTOMORPH_SKULL;
    }

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelProtomorphSkull m = Resources.model.getModel();
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
        return Resources.model.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
}
