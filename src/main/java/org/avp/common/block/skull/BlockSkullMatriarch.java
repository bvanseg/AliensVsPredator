package org.avp.common.block.skull;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.alien.client.AlienResources;
import org.alien.client.model.tile.skull.ModelQueenSkull;
import org.avp.common.block.BlockSkull;

public class BlockSkullMatriarch extends BlockSkull
{

    public static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
    
    @Override
    public ModelRenderer[] getSkullModelRenderers()
    {
        ModelQueenSkull m = AlienResources.instance.models().MATRIARCH_SKULL.getModel();
        return new ModelRenderer[] { m.head0 };
    }

    @Override
    public void preRenderTransforms()
    {
        float scale = 1.9F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, -1.35F, -0.25F);
    }

    @Override
    public Texture getSkullTexture()
    {
        return AlienResources.instance.models().MATRIARCH_SKULL.getTexture();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/end_stone");
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB;
    }
}
