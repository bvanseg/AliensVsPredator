package org.avp.block.skulls;

import org.avp.AliensVsPredator;
import org.avp.block.BlockSkull;
import org.avp.client.model.entities.living.ModelWarrior;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.Texture;
import com.arisux.mdx.lib.client.render.model.MapModelTexture;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSkullXenomorph extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static class Resources
    {
        private static final MapModelTexture<ModelWarrior> model = AliensVsPredator.resources().models().DRONE_SKULL;
    }

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelWarrior m = Resources.model.getModel();
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
        return Resources.model.getTexture();
    }
}
