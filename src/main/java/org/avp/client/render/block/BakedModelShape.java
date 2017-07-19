package org.avp.client.render.block;

import java.util.List;

import org.avp.block.BlockReflectiveShape;

import com.arisux.mdx.lib.game.Game;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelRotation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IRetexturableModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.property.IExtendedBlockState;

public class BakedModelShape implements IBakedModel
{
    private IModel                          model;
    private TextureAtlasSprite              sprite;

    public BakedModelShape(TextureAtlasSprite sprite, IModel model)
    {
        super();
        this.sprite = sprite;
        this.model = model;
    }

    private static TRSRTransformation rotation(IBlockState state)
    {
    	int x = 0;
    	int y = 0;
    	
    	if (state != null)
    	{
    		EnumHalf half = state.getValue(BlockReflectiveShape.HALF);
    		
	        switch (half)
	        {
		        case BOTTOM:
		        	x = 0;
		        	break;
		        case TOP:
		        	x = 180;
		        	break;
		        default:
		        	x = 0;
		        	break;
	        }
	        
	        EnumFacing facing = state.getValue(BlockReflectiveShape.PLACEMENT).getOpposite();
	        
	        if (half == EnumHalf.TOP)
	        {
	        	facing = facing.getOpposite();
	        }
	        
	        switch (facing)
	        {
	            case NORTH:
	            	y = 0;
		        	break;
	            case EAST:
	            	y = 90;
		        	break;
	            case SOUTH:
	            	y = 180;
		        	break;
	            case WEST:
	            	y = 270;
		        	break;
	            default:
	            	y = 0;
		        	break;
	        }
    	}
        
        return new TRSRTransformation(ModelRotation.getModelRotation(x, y));
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
    {
        IModel quadModel = model;
        Function<ResourceLocation, TextureAtlasSprite> textureGetter = ModelLoader.defaultTextureGetter();
        TRSRTransformation transformations = rotation(state);
        VertexFormat vertexFormat = DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL;

        if (model instanceof IRetexturableModel)
        {
            String key = "#texture";
            String iconName = "avp:blocks/reflection";
            IRetexturableModel retexturable = (IRetexturableModel) model;
            ImmutableMap<String, String> defaultTextures = ImmutableMap.of(key, iconName);
            quadModel = retexturable.retexture(defaultTextures);

            if (state instanceof IExtendedBlockState)
            {
                IExtendedBlockState extendedState = (IExtendedBlockState) state;
                IBlockState reflectiveState = extendedState.getValue(BlockReflectiveShape.REFLECTION);

                if (reflectiveState != null)
                {
                    BlockModelShapes shapes = Game.minecraft().getBlockRendererDispatcher().getBlockModelShapes();
                    IBakedModel reflectedModel = shapes.getModelForState(reflectiveState);

                    this.sprite = reflectedModel.getParticleTexture();

                    if (this.sprite != Game.minecraft().textureMapBlocks.getMissingSprite())
                    {
                        ImmutableMap<String, String> textures = ImmutableMap.of(key, sprite.getIconName());
                        quadModel = retexturable.retexture(textures);
                    }
                    else
                    {
                        this.sprite = Game.minecraft().textureMapBlocks.getAtlasSprite(iconName);
                    }
                }
            }
        }
        
        if (quadModel != null)
        {
        	return quadModel.bake(transformations, vertexFormat, textureGetter).getQuads(state, side, rand);
        }
        
        return model.bake(transformations, vertexFormat, textureGetter).getQuads(state, side, rand);
    }

    @Override
    public boolean isAmbientOcclusion()
    {
        return false;
    }

    @Override
    public boolean isGui3d()
    {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer()
    {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return this.sprite;
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms()
    {
        return ItemCameraTransforms.DEFAULT;
    }

    @Override
    public ItemOverrideList getOverrides()
    {
        return ItemOverrideList.NONE;
    }
}
