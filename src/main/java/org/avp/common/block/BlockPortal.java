package org.avp.common.block;

import java.util.Random;

import com.asx.mdx.lib.world.Dimension;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPortal extends Block
{
    private Dimension dimension;

    public BlockPortal(Dimension dimension)
    {
        super(Material.PORTAL);
        setLightOpacity(100);
        setTickRandomly(true);
        this.dimension = dimension;
    }
    
    @SideOnly(Side.CLIENT)
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
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }
    
    @Override
    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random rand)
    {
        super.randomDisplayTick(stateIn, world, pos, rand);

        for (int i = 6; i > 0; --i)
        {
            world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.getX() + rand.nextDouble(), pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }
    
    @Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entity)
    {
        if ((entity.getRidingEntity()== null) && (Entities.getEntityRiddenBy(entity) == null) && ((entity instanceof EntityPlayerMP)))
        {
            EntityPlayerMP player = (EntityPlayerMP) entity;

            if (player.dimension != this.dimension.getId())
            {
                player.timeUntilPortal = 10;
                dimension.transferEntityTo(player);
            }
            else
            {
                player.timeUntilPortal = 10;
                Dimension.transferEntityTo(player, 0);
            }
        }
    }
}
