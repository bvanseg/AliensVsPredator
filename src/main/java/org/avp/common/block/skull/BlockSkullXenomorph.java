package org.avp.common.block.skull;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.model.entity.living.ModelWarrior;
import org.avp.AVP;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;

public class BlockSkullXenomorph extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static final MapModelTexture<ModelWarrior> model = Resources.instance.models().DRONE_SKULL;

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelWarrior m = model.getModel();
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
        return model.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
}
