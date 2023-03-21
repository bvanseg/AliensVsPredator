package org.avp.client.model.tile.cached;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.model.Model;
import com.asx.mdx.client.render.model.block.ModelRotationXYZ;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
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
import org.apache.commons.lang3.tuple.Pair;
import org.avp.common.block.BlockReflective;
import org.avp.common.block.util.EnumAlignment;

import javax.vecmath.Matrix4f;
import java.util.Collections;
import java.util.List;

public class CachedModelReflectiveShape implements IBakedModel
{
    private static final String                                                            TEXTURE_KEY            = "#texture";
    private static final String                                                            TEXTURE_LOCATION       = "avp:blocks/reflection";
    private static final VertexFormat                                                      VERTEX_FORMAT          = DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL;
    private static final java.util.function.Function<ResourceLocation, TextureAtlasSprite> TEXTURE_GETTER         = ModelLoader.defaultTextureGetter();
    private static final Function<ResourceLocation, TextureAtlasSprite>                    DEFAULT_TEXTURE_GETTER = location -> ClientGame.instance.minecraft().getTextureMapBlocks().getAtlasSprite("avp:blocks/reflection");

    private final IModel                                                                         model;
    private TextureAtlasSprite                                                             sprite;
    private final ShapeRenderList                                                                overrides;
    private final Pair<? extends IBakedModel, Matrix4f>                                    selfPair;
    protected ItemStack                                                                    stack;
    protected EntityLivingBase                                                             entity;
    private TransformType                                                                  transformType;

    public static class ShapeRenderList<M extends Model> extends ItemOverrideList
    {
        public ShapeRenderList()
        {
            super(Lists.<ItemOverride>newArrayList());
        }

        @SuppressWarnings("all")
        @Override
        public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity)
        {
            if (originalModel instanceof CachedModelReflectiveShape)
            {
                CachedModelReflectiveShape model = (CachedModelReflectiveShape) originalModel;
                model.setItemstack(stack);
                model.setEntity(entity);
            }

            return super.handleItemState(originalModel, stack, world, entity);
        }
    }

    public CachedModelReflectiveShape(TextureAtlasSprite sprite, IModel model)
    {
        super();
        this.sprite = sprite;
        this.model = model;
        this.overrides = new ShapeRenderList();
        this.selfPair = Pair.of(this, null);
    }

    private static TRSRTransformation rotation(IBlockState state)
    {
        int x = 0;
        int y = 0;
        int z = 0;

        if (state != null)
        {
            EnumAlignment alignment = state.getValue(BlockReflective.ALIGNMENT);

            switch (alignment)
            {
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

            EnumFacing placement = state.getValue(BlockReflective.FACING);
            EnumFacing facing = placement.getOpposite();

            if (alignment == EnumAlignment.TOP)
            {
                facing = placement;
            }

            switch (facing)
            {
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
        if (transformType == TransformType.GUI)
        {
            return this.model.bake(new TRSRTransformation(ModelRotationXYZ.getModelRotation(0, 90, 0).getMatrix()), VERTEX_FORMAT, DEFAULT_TEXTURE_GETTER).getQuads(state, side, rand);
        }

        if (side == null && transformType == null)
        {
            TextureMap textureMap = ClientGame.instance.minecraft().getTextureMapBlocks();
            BlockRendererDispatcher dispatcher = ClientGame.instance.minecraft().getBlockRendererDispatcher();
            TRSRTransformation transformation = rotation(state);
            IModel retextured = model;
            IModel retexturable = model;
            retextured = retexture(model, TEXTURE_KEY, TEXTURE_LOCATION);

            if (state instanceof IExtendedBlockState)
            {
                IExtendedBlockState extendedState = (IExtendedBlockState) state;
                IBlockState reflectedState = extendedState.getValue(BlockReflective.REFLECTION);

                if (reflectedState != null)
                {
                    this.sprite = dispatcher.getBlockModelShapes().getTexture(reflectedState);

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
