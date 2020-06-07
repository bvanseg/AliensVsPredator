package org.avp.client.render.block.model.cached;

import java.util.Collections;
import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;
import org.avp.block.BlockHiveResin;

import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.client.util.models.block.ModelRotationXYZ;
import com.asx.mdx.lib.util.Game;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverride;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.property.IExtendedBlockState;

public class CachedModelResin implements IBakedModel
{
    private static final String                                                            TEXTURE_KEY            = "#texture";
    private static final String                                                            TEXTURE_LOCATION       = "avp:blocks/hiveresin";
    private static final VertexFormat                                                      VERTEX_FORMAT          = DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL;
    private static final java.util.function.Function<ResourceLocation, TextureAtlasSprite> TEXTURE_GETTER         = ModelLoader.defaultTextureGetter();
    private static final Function<ResourceLocation, TextureAtlasSprite>                    DEFAULT_TEXTURE_GETTER = new Function<ResourceLocation, TextureAtlasSprite>() {
                                                                                                                      public TextureAtlasSprite apply(ResourceLocation location)
                                                                                                                      {
                                                                                                                          return Game.minecraft().getTextureMapBlocks().getAtlasSprite("avp:blocks/hiveresin");
                                                                                                                      }
                                                                                                                  };

    private IModel                                                                         model;
    private TextureAtlasSprite                                                             sprite;
    private RenderList                                                                     overrides;
    private final Pair<? extends IBakedModel, Matrix4f>                                    selfPair;
    protected ItemStack                                                                    stack;
    protected EntityLivingBase                                                             entity;
    private TransformType                                                                  transformType;

    public static class RenderList<M extends Model> extends ItemOverrideList
    {
        public RenderList()
        {
            super(Lists.<ItemOverride>newArrayList());
        }

        @Override
        public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity)
        {
            if (originalModel instanceof CachedModelResin)
            {
                CachedModelResin model = (CachedModelResin) originalModel;
                model.setItemstack(stack);
                model.setEntity(entity);
            }

            return super.handleItemState(originalModel, stack, world, entity);
        }
    }

    public CachedModelResin(TextureAtlasSprite sprite, IModel model)
    {
        super();
        this.sprite = sprite;
        this.model = model;
        this.overrides = new RenderList();
        this.selfPair = Pair.of(this, null);
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
    {
        if (transformType == TransformType.GUI)
        {
            return this.model.bake(new TRSRTransformation(ModelRotationXYZ.getModelRotation(0, 90, 0).getMatrix()), VERTEX_FORMAT, DEFAULT_TEXTURE_GETTER).getQuads(state, side, rand);
        }

        if (side == null && transformType == null && model != null)
        {
            TextureMap textureMap = Game.minecraft().getTextureMapBlocks();
            BlockRendererDispatcher dispatcher = Game.minecraft().getBlockRendererDispatcher();
            TRSRTransformation transformation = new TRSRTransformation(ModelRotationXYZ.getModelRotation(0, 0, 0).getMatrix());
            IModel retextured = model;
            IModel retexturable = model;
            retextured = retexture(model, TEXTURE_KEY, TEXTURE_LOCATION);

            if (state instanceof IExtendedBlockState)
            {
                IExtendedBlockState extendedState = (IExtendedBlockState) state;
                IBlockState parentState = extendedState.getValue(BlockHiveResin.PARENT_BLOCK);

                if (parentState != null)
                {
                    this.sprite = dispatcher.getBlockModelShapes().getTexture(parentState);

                    if (this.sprite != textureMap.getMissingSprite() && sprite != null)
                    {
                        retextured = retexture(retexturable, TEXTURE_KEY, sprite.getIconName());
                    }
                    else
                    {
                        this.sprite = textureMap.getAtlasSprite(TEXTURE_LOCATION);
                    }
                }
                else
                {

                }
            }

            if (retextured != null)
            {
                List<BakedQuad> quads = retextured.bake(transformation, VERTEX_FORMAT, TEXTURE_GETTER).getQuads(state, side, rand);
                return quads;
            }

            try
            {
                return model.bake(transformation, VERTEX_FORMAT, TEXTURE_GETTER).getQuads(state, side, rand);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return Collections.emptyList();
    }

    private static IModel retexture(IModel model, String key, String location)
    {
        return model.retexture(ImmutableMap.of(key, location));
    }

    @Override
    public boolean isAmbientOcclusion()
    {
        this.transformType = null;
        return true;
    }

    @Override
    public boolean isGui3d()
    {
        return true;
    }

    @Override
    public boolean isBuiltInRenderer()
    {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return null;
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms()
    {
        return ItemCameraTransforms.DEFAULT;
    }

    @Override
    public ItemOverrideList getOverrides()
    {
        return this.overrides;
    }

    private void setItemstack(ItemStack stack)
    {
        this.stack = stack;
    }

    private void setEntity(EntityLivingBase entity)
    {
        this.entity = entity;
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType type)
    {
        this.transformType = type;

        switch (type)
        {
            case FIRST_PERSON_LEFT_HAND:
            {
            }
                break;
            case FIRST_PERSON_RIGHT_HAND:
            {
            }
                break;
            case GUI:
            {
            }
                break;
            case THIRD_PERSON_LEFT_HAND:
            {
            }
                break;
            case THIRD_PERSON_RIGHT_HAND:
            {
            }
                break;
            case GROUND:
            {
            }
                break;
            case FIXED:
            {
            }
                break;
            case HEAD:
            {
            }
                break;
            case NONE:
            {
            }
                break;

            default:
                break;
        }

        return selfPair;
    }
}