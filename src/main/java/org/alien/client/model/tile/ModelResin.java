package org.alien.client.model.tile;

import com.google.common.collect.ImmutableSet;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.alien.client.model.tile.cached.CachedModelResin;

import java.util.Collection;
import java.util.function.Function;

public class ModelResin implements IModel
{
    private final ResourceLocation modelResource;
    private final ResourceLocation textureResource;
    
    public ModelResin(ResourceLocation modelResource, ResourceLocation textureResource)
    {
    	this.modelResource = modelResource;
    	this.textureResource = textureResource;
	}
    
    @Override
    public Collection<ResourceLocation> getDependencies()
    {
        return ImmutableSet.of(modelResource);
    }

    @Override
    public Collection<ResourceLocation> getTextures()
    {
        return ImmutableSet.of(textureResource);
    }
    
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
    {
        IModel model = null;
        
        try
        {
            model = ModelLoaderRegistry.getModel(modelResource);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return new CachedModelResin(bakedTextureGetter.apply(textureResource), model);
    }
    
    @Override
    public IModelState getDefaultState()
    {
        return TRSRTransformation.identity();
    }
}
