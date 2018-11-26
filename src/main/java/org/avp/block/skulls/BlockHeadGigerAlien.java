package org.avp.block.skulls;

import org.avp.AliensVsPredator;
import org.avp.block.BlockSkull;
import org.avp.client.model.tile.skulls.ModelGigerAlienHead;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.Texture;
import com.arisux.mdx.lib.client.render.model.MapModelTexture;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHeadGigerAlien extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static class Resources
    {
        private static final MapModelTexture<ModelGigerAlienHead> model = AliensVsPredator.resources().models().GIGER_ALIEN_HEAD;
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
    public boolean canChangeOrientation()
    {
        return true;
    }
}
