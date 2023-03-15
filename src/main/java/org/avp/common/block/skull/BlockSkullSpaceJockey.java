package org.avp.common.block.skull;

import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.model.entity.living.ModelEngineer;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;

public class BlockSkullSpaceJockey extends BlockSkull
{
    @SideOnly(Side.CLIENT)
    private static final MapModelTexture<ModelEngineer> model = Resources.instance.models().SPACE_JOCKEY;

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelEngineer m = model.getModel();
        return new ModelRenderer[] { m.head1, m.head2, m.hose, m.rJaw, m.lJaw, m.nozzle1, m.nozzle2, m.nozzle3a, m.nozzle3b, m.nozzle3c, m.nozzle3d };
    }

    @Override
    public Texture getSkullTexture()
    {
        return model.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/concrete_powder_gray");
    }
}
