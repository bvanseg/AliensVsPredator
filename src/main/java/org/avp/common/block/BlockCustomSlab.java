package org.avp.common.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lib.common.block.BlockProperties;

import java.util.Random;

public abstract class BlockCustomSlab extends BlockSlab {

    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.create("variant", Variant.class);

    protected final BlockProperties blockProperties;

    private BlockRenderLayer renderLayer;
    private boolean doesSideRendering;

    protected final String rawRegistryName;

    protected BlockCustomSlab(String registryName, BlockProperties properties) {
        super(properties.getMaterial());

        this.rawRegistryName = registryName;
        this.setRegistryName(registryName);
        this.blockProperties = properties;
        this.renderLayer = BlockRenderLayer.SOLID;
        this.doesSideRendering = true;

        IBlockState iblockstate = this.blockState.getBaseState();

        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        if (properties.getSoundType() != null) {
            this.setSoundType(properties.getSoundType());
        }

        this.setDefaultState(iblockstate.withProperty(VARIANT, Variant.DEFAULT));
        this.useNeighborBrightness = !this.isDouble();
    }

    public BlockCustomSlab setRenderLayer(BlockRenderLayer layer) {
        this.renderLayer = layer;
        return this;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return this.renderLayer;
    }

    public boolean doesSideRendering() {
        return this.doesSideRendering;
    }

    public BlockCustomSlab setDoesSideRendering(boolean doesSideRendering) {
        this.doesSideRendering = doesSideRendering;
        return this;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        if (this.doesSideRendering) {
            return super.doesSideBlockRendering(state, world, pos, face);
        }

        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, Variant.DEFAULT);

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return this.isDouble() ? new BlockStateContainer(this, VARIANT) : new BlockStateContainer(this, HALF, VARIANT);
    }

    /**
     * Returns the slab block name with the type associated with it
     */
    @Override
    public String getTranslationKey(int meta)
    {
        return super.getTranslationKey();
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return Variant.DEFAULT;
    }

    public static class Double extends BlockCustomSlab {

        private final BlockCustomSlab.Half halfSlab;

        public Double(String name, BlockProperties properties, BlockCustomSlab.Half halfSlab) {
            super(name, properties);
            properties.apply(this);
            this.halfSlab = halfSlab;
        }

        @Override
        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Item.getItemFromBlock(halfSlab);
        }

        @Override
        public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
            return new ItemStack(halfSlab);
        }

        @Override
        public boolean isDouble() {
            return true;
        }
    }

    public static class Half extends BlockCustomSlab {
        public Half(String name, BlockProperties properties) {
            super(name, properties);
            properties.apply(this);
        }

        public BlockCustomSlab.Double createDoubleVariant() {
            return (Double) new Double(
                    "double_" + this.rawRegistryName,
                    this.blockProperties,
                    this
            ).setRenderLayer(this.getRenderLayer()).setDoesSideRendering(this.doesSideRendering());
        }

        @Override
        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Item.getItemFromBlock(this);
        }

        @Override
        public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
            return new ItemStack(this);
        }

        @Override
        public boolean isDouble() {
            return false;
        }
    }

    public enum Variant implements IStringSerializable {
        DEFAULT;

        @Override
        public String getName() {
            return "default";
        }
    }
}
