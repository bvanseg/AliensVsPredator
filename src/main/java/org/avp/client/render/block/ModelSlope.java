package org.avp.client.render.block;

import java.util.Collection;

import org.avp.AliensVsPredator;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

public class ModelSlope implements IModel
{
    public static final ResourceLocation MODEL_LOCATION = new ResourceLocation(AliensVsPredator.ID, "block/slope.obj");
    public static final ResourceLocation TEXTURE        = new ResourceLocation(AliensVsPredator.ID, "blocks/reflection");
    
    @Override
    public Collection<ResourceLocation> getDependencies()
    {
        return ImmutableSet.of(MODEL_LOCATION);
    }

    @Override
    public Collection<ResourceLocation> getTextures()
    {
        return ImmutableSet.of(TEXTURE);
    }

    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
    {
        IModel model = null;
        
        try
        {
            model = ModelLoaderRegistry.getModel(MODEL_LOCATION);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return new BakedModelShape(bakedTextureGetter.apply(TEXTURE), model);
    }

    @Override
    public IModelState getDefaultState()
    {
        return TRSRTransformation.identity();
    }
}
