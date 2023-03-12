package org.avp.common.block.skulls;

import org.avp.AVP;
import org.avp.common.block.BlockSkull;
import org.avp.client.model.tile.skulls.ModelGigerAlienHead;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHeadGigerAlien extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static class Resources
    {
        private static final MapModelTexture<ModelGigerAlienHead> model = AVP.resources().models().GIGER_ALIEN_HEAD;
    }

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelGigerAlienHead m = Resources.model.getModel();
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
        return Resources.model.getTexture();
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
