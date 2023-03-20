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

    protected BlockCustomSlab(String registryName, BlockProperties properties) {
        super(properties.getMaterial());
        this.setRegistryName(registryName);

        IBlockState iblockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);

        if (!this.isDouble()) {
            iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        this.setDefaultState(iblockstate);
        this.useNeighborBrightness = !this.isDouble();
    }

    @Override
    public String getTranslationKey(int meta) {
        return this.getTranslationKey();
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return Variant.DEFAULT;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (this instanceof Half) {
            return Item.getItemFromBlock(this);
        }
        return null;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        if (this instanceof Half) {
            return new ItemStack(this);
        }
        return null;
    }

    @Override
    public final IBlockState getStateFromMeta(final int meta) {
        IBlockState blockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);

        if (!this.isDouble()) {
            blockstate = blockstate.withProperty(HALF, ((meta & 8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
        }

        return blockstate;
    }

    @Override
    public final int getMetaFromState(final IBlockState state) {
        int meta = 0;

        if (!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP) {
            meta |= 8;
        }

        return meta;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if (!this.isDouble()) {
            return new BlockStateContainer(this, VARIANT, HALF);
        }
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }

    public static class Double extends BlockCustomSlab {
        public Double(String name, BlockProperties properties) {
            super(name, properties);
            properties.apply(this);
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
