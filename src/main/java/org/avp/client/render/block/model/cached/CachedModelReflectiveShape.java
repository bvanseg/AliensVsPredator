package org.avp.client.render.block.model.cached;

import java.util.Collections;
import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;
import org.avp.block.BlockReflective;
import org.avp.block.util.EnumAlignment;
import org.avp.client.Resources;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.render.model.block.ModelRotationXYZ;
import com.arisux.mdx.lib.game.Game;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
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
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.client.model.IRetexturableModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.property.IExtendedBlockState;

public class CachedModelReflectiveShape implements IPerspectiveAwareModel
{
    private static final String                                         TEXTURE_KEY            = "#texture";
    private static final String                                         TEXTURE_LOCATION       = "avp:blocks/reflection";
    private static final VertexFormat                                   VERTEX_FORMAT          = DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL;
    private static final Function<ResourceLocation, TextureAtlasSprite> TEXTURE_GETTER         = ModelLoader.defaultTextureGetter();
    private static final Function<ResourceLocation, TextureAtlasSprite> DEFAULT_TEXTURE_GETTER = new Function<ResourceLocation, TextureAtlasSprite>() {
                                                                                                   public TextureAtlasSprite apply(ResourceLocation location)
                                                                                                   {
                                                                                                       return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(Resources.instance.REFLECTION.toString());
                                                                                                   }
                                                                                               };

    private IModel                                                      model;
    private TextureAtlasSprite                                          sprite;
    private ShapeRenderList                                             overrides;
    private final Pair<? extends IBakedModel, Matrix4f>                 selfPair;
    protected ItemStack                                                 stack;
    protected EntityLivingBase                                          entity;
    private TransformType                                               transformType;

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

            EnumFacing placement = state.getValue(BlockReflective.FACING);
            EnumFacing facing = placement.getOpposite();

            if (alignment == EnumAlignment.TOP)
            {
                facing = placement;
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
        if (transformType == TransformType.GUI)
        {
            return this.model.bake(new TRSRTransformation(ModelRotationXYZ.getModelRotation(90, 90, 0).getMatrix()), VERTEX_FORMAT, new Function<ResourceLocation, TextureAtlasSprite>() {
                public TextureAtlasSprite apply(ResourceLocation location)
                {
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(Resources.instance.BLACKGOO.toString());
                }
            }).getQuads(state, side, rand);
        }

        if (side == null && transformType == null)
        {
            TextureMap textureMap = Game.minecraft().textureMapBlocks;
            BlockRendererDispatcher dispatcher = Game.minecraft().getBlockRendererDispatcher();
            IModel retextured = model;
            TRSRTransformation transformation = rotation(state);

            if (model instanceof IRetexturableModel)
            {
                IRetexturableModel retexturable = (IRetexturableModel) model;
                retextured = retexture(retexturable, TEXTURE_KEY, TEXTURE_LOCATION);

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

    private static IModel retexture(IRetexturableModel model, String key, String location)
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
