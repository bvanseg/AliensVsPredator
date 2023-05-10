package org.prometheus.common.block.skull;

import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.alien.client.AlienResources;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelEngineer;
import org.avp.common.block.BlockSkull;

public class BlockSkullEngineer extends BlockSkull
{

    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelEngineer m = PrometheusResources.Models.ENGINEER.getModel();
        return new ModelRenderer[] { m.head1, m.head2, m.hose, m.rJaw, m.lJaw, m.nozzle1, m.nozzle2, m.nozzle3a, m.nozzle3b, m.nozzle3c, m.nozzle3d };
    }

    @Override
    public Texture getSkullTexture()
    {
        return PrometheusResources.Models.ENGINEER.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/stone_diorite");
    }
}
