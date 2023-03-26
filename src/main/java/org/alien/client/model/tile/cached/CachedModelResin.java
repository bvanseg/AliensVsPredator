package org.alien.client.model.tile.cached;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.model.block.ModelRotationXYZ;
import com.asx.mdx.common.io.config.GraphicsSetting;
import com.google.common.collect.Lists;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.property.IExtendedBlockState;
import org.alien.common.block.BlockHiveResin;
import org.apache.commons.lang3.tuple.Pair;
import org.avp.common.AVPSettings.ClientSettings;

import javax.vecmath.Matrix4f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class CachedModelResin implements IBakedModel
{
    private static final String TEXTURE_LOCATION = "avp:blocks/hiveresin";
    private static final VertexFormat VERTEX_FORMAT = DefaultVertexFormats.BLOCK;

    private static final Function<ResourceLocation, TextureAtlasSprite> DEFAULT_TEXTURE_GETTER = location -> ClientGame.instance.minecraft().getTextureMapBlocks().getAtlasSprite(TEXTURE_LOCATION);

    private final IModel model;
    private TextureAtlasSprite sprite;
    private final RenderList overrides;
    private final Pair<? extends IBakedModel, Matrix4f> selfPair;
    protected ItemStack stack;
    protected EntityLivingBase entity;
    private TransformType transformType;

    public static class RenderList extends ItemOverrideList
    {
        public RenderList()
        {
            super(Lists.newArrayList());
        }

        @Override
        public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity)
        {
            if (originalModel instanceof CachedModelResin)
            {
                CachedModelResin model = (CachedModelResin) originalModel;
                model.setItemStack(stack);
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

    private void putVertex(UnpackedBakedQuad.Builder builder, Vec3d normal, double x, double y, double z, float u, float v)
    {
        for (int e = 0; e < VERTEX_FORMAT.getElementCount(); e++)
        {
            switch (VERTEX_FORMAT.getElement(e).getUsage())
            {
                case POSITION:
                    builder.put(e, (float) x, (float) y, (float) z, 1.0f);
                    break;
                case COLOR:
                    builder.put(e, 1.0f, 1.0f, 1.0f, 1.0f);
                    break;
                case UV:
                    switch (VERTEX_FORMAT.getElement(e).getIndex())
                    {
                        case 0:
                            float iu = sprite.getInterpolatedU(u);
                            float iv = sprite.getInterpolatedV(v);
                            builder.put(e, iu, iv);
                            break;
                        case 2:
                            builder.put(e, (short) 0, (short) 0);
                            break;
                        default:
                            builder.put(e);
                            break;
                    }
                    break;
                case NORMAL:
                    builder.put(e, (float) normal.x, (float) normal.y, (float) normal.z, 0f);
                    break;
                default:
                    builder.put(e);
                    break;
            }
        }
    }

    private BakedQuad createQuad(Vec3d v1, Vec3d v2, Vec3d v3, Vec3d v4, TextureAtlasSprite sprite)
    {
        Vec3d normal = v1.subtract(v2).crossProduct(v3.subtract(v2));

        UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(VERTEX_FORMAT);

        builder.setTexture(sprite);
        putVertex(builder, normal, v1.x, v1.y, v1.z, 0, 0);
        putVertex(builder, normal, v2.x, v2.y, v2.z, 0, 16);
        putVertex(builder, normal, v3.x, v3.y, v3.z, 16, 16);
        putVertex(builder, normal, v4.x, v4.y, v4.z, 16, 0);

        return builder.build();
    }

    private static final Vec3d[] BOTTOM_QUAD_VERTICES = new Vec3d[]{ new Vec3d(1.0D, 0.0D, 0.0D), new Vec3d(1.0D, 0.0D, 1.0D), new Vec3d(0.0D, 0.0D, 1.0D), new Vec3d(0.0D, 0.0D, 0.0D) };
    private static final Vec3d[] TOP_QUAD_VERTICES = new Vec3d[]{ new Vec3d(0.0D, 1.0D, 0.0D), new Vec3d(0.0D, 1.0D, 1.0D), new Vec3d(1.0D, 1.0D, 1.0D), new Vec3d(1.0D, 1.0D, 0.0D) };
    private static final Vec3d[] SOUTH_QUAD_VERTICES = new Vec3d[]{ new Vec3d(1.0D, 0.0D, 1.0D), new Vec3d(1.0D, 1.0D, 1.0D), new Vec3d(0.0D, 1.0D, 1.0D), new Vec3d(0.0D, 0.0D, 1.0D) };
    private static final Vec3d[] NORTH_QUAD_VERTICES = new Vec3d[]{ new Vec3d(0.0D, 0.0D, 0.0D), new Vec3d(0.0D, 1.0D, 0.0D), new Vec3d(1.0D, 1.0D, 0.0D), new Vec3d(1.0D, 0.0D, 0.0D) };
    private static final Vec3d[] WEST_QUAD_VERTICES = new Vec3d[]{ new Vec3d(0.0D, 0.0D, 1.0D), new Vec3d(0.0D, 1.0D, 1.0D), new Vec3d(0.0D, 1.0D, 0.0D), new Vec3d(0.0D, 0.0D, 0.0D) };
    private static final Vec3d[] EAST_QUAD_VERTICES = new Vec3d[]{ new Vec3d(1.0D, 0.0D, 0.0D), new Vec3d(1.0D, 1.0D, 0.0D), new Vec3d(1.0D, 1.0D, 1.0D), new Vec3d(1.0D, 0.0D, 1.0D) };

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
    {
        if (transformType == TransformType.GUI)
        {
            return this.model.bake(new TRSRTransformation(ModelRotationXYZ.getModelRotation(0, 90, 0).getMatrix()), VERTEX_FORMAT, DEFAULT_TEXTURE_GETTER).getQuads(state, side, rand);
        }

        if (side == null && transformType == null && model != null)
        {
            TextureMap textureMap = ClientGame.instance.minecraft().getTextureMapBlocks();
            this.sprite = textureMap.getAtlasSprite(TEXTURE_LOCATION);

            if (state instanceof IExtendedBlockState)
            {
                IExtendedBlockState extendedState = (IExtendedBlockState) state;
                IBlockState parentState = extendedState.getValue(BlockHiveResin.PARENT_BLOCK);

                if (parentState != null)
                {
                    this.sprite = ClientGame.instance.minecraft().getBlockRendererDispatcher().getBlockModelShapes().getTexture(parentState);

                    GraphicsSetting hiveTessellation = ClientSettings.instance.hiveTessellation().value();

                    if (this.sprite == textureMap.getMissingSprite() || sprite == null || hiveTessellation == GraphicsSetting.LOW)
                    {
                        this.sprite = textureMap.getAtlasSprite(TEXTURE_LOCATION);
                    }
                }
            }

            List<BakedQuad> quads = new ArrayList<>();

            // BOTTOM
            quads.add(createQuad(BOTTOM_QUAD_VERTICES[0], BOTTOM_QUAD_VERTICES[1], BOTTOM_QUAD_VERTICES[2], BOTTOM_QUAD_VERTICES[3], this.sprite));
            // TOP
            quads.add(createQuad(TOP_QUAD_VERTICES[0], TOP_QUAD_VERTICES[1], TOP_QUAD_VERTICES[2], TOP_QUAD_VERTICES[3], this.sprite));
            // SOUTH
            quads.add(createQuad(SOUTH_QUAD_VERTICES[0], SOUTH_QUAD_VERTICES[1], SOUTH_QUAD_VERTICES[2], SOUTH_QUAD_VERTICES[3], this.sprite));
            //NORTH
            quads.add(createQuad(NORTH_QUAD_VERTICES[0], NORTH_QUAD_VERTICES[1], NORTH_QUAD_VERTICES[2], NORTH_QUAD_VERTICES[3], this.sprite));
            // WEST
            quads.add(createQuad(WEST_QUAD_VERTICES[0], WEST_QUAD_VERTICES[1], WEST_QUAD_VERTICES[2], WEST_QUAD_VERTICES[3], this.sprite));
            // EAST
            quads.add(createQuad(EAST_QUAD_VERTICES[0], EAST_QUAD_VERTICES[1], EAST_QUAD_VERTICES[2], EAST_QUAD_VERTICES[3], this.sprite));

            return quads;
        }

        return Collections.emptyList();
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

    private void setItemStack(ItemStack stack)
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
        return selfPair;
    }
}
