package org.avp.client.render.block;

import java.util.List;

import org.avp.BlockHandler.BlockNewShape;

import com.arisux.mdx.lib.game.Game;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;

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
    private static final TRSRTransformation NORTH = new TRSRTransformation(ModelRotation.getModelRotation(0, 0));
    private static final TRSRTransformation EAST  = new TRSRTransformation(ModelRotation.getModelRotation(0, 90));
    private static final TRSRTransformation SOUTH = new TRSRTransformation(ModelRotation.getModelRotation(0, 180));
    private static final TRSRTransformation WEST  = new TRSRTransformation(ModelRotation.getModelRotation(0, 270));

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
        switch (((IExtendedBlockState) state).getValue(BlockNewShape.PLACEMENT).getOpposite())
        {
            case NORTH:
                return NORTH;
            case EAST:
                return EAST;
            case SOUTH:
                return SOUTH;
            case WEST:
                return WEST;
            default:
                return NORTH;
        }
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
    {
        IModel quadModel = model;
        TRSRTransformation transformations = rotation(state);
        VertexFormat vertexFormat = DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL;
        Function<ResourceLocation, TextureAtlasSprite> textureGetter = ModelLoader.defaultTextureGetter();
        
        if (model instanceof IRetexturableModel)
        {
            IRetexturableModel retexturable = (IRetexturableModel) model;
            ImmutableMap<String, String> defaultTextures = ImmutableMap.of("#texture", ModelSlope.TEXTURE.toString());
            model = retexturable.retexture(defaultTextures);

            if (state instanceof IExtendedBlockState)
            {
                IExtendedBlockState extendedState = (IExtendedBlockState) state;
                IBlockState reflection = extendedState.getValue(BlockNewShape.REFLECTION);

                BlockModelShapes shapes = Game.minecraft().getBlockRendererDispatcher().getBlockModelShapes();
                IBakedModel reflectionModel = shapes.getModelForState(reflection);
                this.sprite = reflectionModel.getParticleTexture();
                ImmutableMap<String, String> textures = ImmutableMap.of("#texture", sprite.getIconName());
                quadModel = retexturable.retexture(textures);
                
            }
        }

        return quadModel.bake(transformations, vertexFormat, textureGetter).getQuads(state, side, rand);
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
