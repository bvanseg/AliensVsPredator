package org.avp.common.block.skull;

import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.alien.client.model.entity.living.ModelEngineer;
import org.avp.client.Resources;
import org.avp.common.block.BlockSkull;

public class BlockSkullEngineer extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelEngineer m = Resources.instance.models().ENGINEER.getModel();
        return new ModelRenderer[] { m.head1, m.head2, m.hose, m.rJaw, m.lJaw, m.nozzle1, m.nozzle2, m.nozzle3a, m.nozzle3b, m.nozzle3c, m.nozzle3d };
    }

    @Override
    public Texture getSkullTexture()
    {
        return Resources.instance.models().ENGINEER.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/stone_diorite");
    }
}
