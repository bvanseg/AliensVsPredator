package org.avp.client.render.block;

import java.util.List;

import org.avp.block.BlockReflectiveShape;
import org.avp.block.BlockReflectiveShape.EnumAlignment;

import com.arisux.mdx.lib.client.render.model.block.ModelRotationXYZ;
import com.arisux.mdx.lib.game.Game;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IRetexturableModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.property.IExtendedBlockState;

public class BakedModelShape implements IBakedModel
{
    private IModel                          model;
    private TextureAtlasSprite              sprite;
    private static final String 			key 		= "#texture";
    private static final String 			texture 	= "avp:blocks/reflection";

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
    	int z = 0;
    	
    	if (state != null)
    	{
    		EnumAlignment alignment = state.getValue(BlockReflectiveShape.ALIGNMENT);
    		
	        switch (alignment)
	        {
		        case BOTTOM:
		        	x = 0;
		        	break;
		        case TOP:
		        	x = 180;
		        	break;
		        case SIDE:
		        	x = 270;
		        	break;
		        default:
		        	x = 0;
		        	break;
	        }
	        
	        EnumFacing facing = state.getValue(BlockReflectiveShape.PLACEMENT).getOpposite();
	        
	        if (alignment == EnumAlignment.TOP)
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
    	
        return new TRSRTransformation(ModelRotationXYZ.getModelRotation(x, y, z).getMatrix());
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
    {
        Minecraft mc = Game.minecraft();
        TextureMap textureMap = mc.textureMapBlocks;
        BlockRendererDispatcher dispatcher = mc.getBlockRendererDispatcher();
        IModel retextured = model;
        TRSRTransformation transformation = rotation(state);

        if (model instanceof IRetexturableModel)
        {
            IRetexturableModel retexturable = (IRetexturableModel) model;
            retextured = retexture(retexturable, key, texture);

            if (state instanceof IExtendedBlockState)
            {
                IExtendedBlockState extendedState = (IExtendedBlockState) state;
                IBlockState blockstate = extendedState.getValue(BlockReflectiveShape.REFLECTION);

                if (blockstate != null)
                {
                    this.sprite = dispatcher.getBlockModelShapes().getModelForState(blockstate).getParticleTexture();

                    if (this.sprite != textureMap.getMissingSprite())
                    {
                        retextured = retexture(retexturable, key, sprite.getIconName());
                    }
                    else
                    {
                        this.sprite = textureMap.getAtlasSprite(texture);
                    }
                }
            }
        }
        
        if (retextured != null)
        {
        	return retextured.bake(transformation, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL, ModelLoader.defaultTextureGetter()).getQuads(state, side, rand);
        }
        
        return model.bake(transformation, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL, ModelLoader.defaultTextureGetter()).getQuads(state, side, rand);
    }
    
    private static IModel retexture(IRetexturableModel model, String key, String location)
    {
    	return model.retexture(ImmutableMap.of(key, location));
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
