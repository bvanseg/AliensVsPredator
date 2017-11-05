package org.avp.block;

import org.avp.tile.TileEntitySkull;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.Texture;
import com.arisux.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockSkull extends Block
{
    public BlockSkull()
    {
        super(Material.IRON);
        this.setLightOpacity(2);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

    @SideOnly(Side.CLIENT)
    public void preRenderTransforms()
    {
        float scale = 3.0F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, 0.05F, 0F);
    }

    @SideOnly(Side.CLIENT)
    public ModelRenderer[] getSkullModelRenderers()
    {
        return new ModelRenderer[] {};
    }

    @SideOnly(Side.CLIENT)
    public Texture getSkullTexture()
    {
        return null;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntitySkull();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntitySkull && placer != null)
        {
            TileEntitySkull skull = (TileEntitySkull) tile;
            skull.setRotationYAxis(Entities.getEntityFacingRotY(placer));
        }
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
