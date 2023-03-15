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
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;
import org.predator.client.model.entity.living.ModelYautja;

public class BlockSkullYautja extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static final MapModelTexture<ModelYautja> model = Resources.instance.models().YAUTJA_SKULL;

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelYautja m = model.getModel();
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
        return model.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
}
