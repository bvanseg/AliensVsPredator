package org.avp.block.skulls;

import org.avp.AliensVsPredator;
import org.avp.block.BlockSkull;
import org.avp.client.model.tile.skulls.ModelBiomaskFalconer;

import com.arisux.mdx.lib.client.util.OpenGL;
import com.arisux.mdx.lib.client.util.Texture;
import com.arisux.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBiomaskFalconer extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static class Resources
    {
        private static final MapModelTexture<ModelBiomaskFalconer> model = AliensVsPredator.resources().models().BIOMASK_FALCONER;
    }

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelBiomaskFalconer m = Resources.model.getModel();
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
        return Resources.model.getTexture();
    }
}
