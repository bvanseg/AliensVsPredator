package org.avp.common.block;

import java.util.Random;

import org.avp.common.tile.TileEntitySkull;
import org.avp.common.tile.TileEntitySkull.EnumOrientation;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockSkull extends Block
{
    public BlockSkull()
    {
        super(Material.IRON);
        this.setLightOpacity(1);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    // Controls light passthrough
    @Override
    public boolean isFullCube(IBlockState state)
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

    /** Applies to skull model **/
    @SideOnly(Side.CLIENT)
    public Texture getSkullTexture()
    {
        return null;
    }
    
    /** Applies to particle **/
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getParticleTexture(TextureMap map)
    {
        return map.getAtlasSprite("minecraft:blocks/bedrock");
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntitySkull && player != null)
        {
            TileEntitySkull skull = (TileEntitySkull) tile;

            if (this.canChangeOrientation())
            {
                EnumOrientation orientation = EnumOrientation.WALL;

                switch (facing)
                {
                    case UP:
                        if (player.isSneaking())
                        {
                            orientation = EnumOrientation.SIDE;
                        }
                        else
                        {
                            orientation = EnumOrientation.FLAT;
                        }
                        break;
                    default:
                        orientation = EnumOrientation.WALL;
                }

                skull.setOrientation(orientation);
            }
        }

        return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    public boolean canChangeOrientation()
    {
        return false;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return super.getItemDropped(state, rand, fortune);
    }
    
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        Random rand = world instanceof World ? ((World) world).rand : RANDOM;
        Item item = this.getItemDropped(state, rand, fortune);

        if (item != Items.AIR)
        {
            drops.add(new ItemStack(item, 1, this.damageDropped(state)));
        }
    }
}
