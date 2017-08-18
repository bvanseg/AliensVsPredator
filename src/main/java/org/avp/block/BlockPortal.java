package org.avp.block;

import java.util.Random;

import com.arisux.mdx.lib.world.Dimension;
import com.arisux.mdx.lib.world.entity.Entities;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;

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
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
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
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity)
    {
        if ((entity.getRidingEntity()== null) && (Entities.getEntityRiddenBy(entity) == null) && ((entity instanceof EntityPlayerMP)))
        {
            EntityPlayerMP player = (EntityPlayerMP) entity;

            if (player.dimension != this.dimension.getId())
            {
                player.timeUntilPortal = 10;
                teleportPlayerToDimension(player, this.dimension.getId());
            }
            else
            {
                player.timeUntilPortal = 10;
                teleportPlayerToDimension(player, 0);
            }
        }
    }
    
    public static void teleportPlayerToDimension(EntityPlayerMP player, int dimension)
    {
        player.getServer().getPlayerList().transferPlayerToDimension(player, dimension, new Teleporter(player.getServerWorld())
        {
            @Override
            public void placeInPortal(Entity entityIn, float rotationYaw)
            {
                int x = MathHelper.floor(entityIn.posX);
                int y = MathHelper.floor(entityIn.posY) - 1;
                int z = MathHelper.floor(entityIn.posZ);
                entityIn.setLocationAndAngles((double) x, (double) y, (double) z, entityIn.rotationYaw, 0.0F);
                entityIn.motionX = 0.0D;
                entityIn.motionY = 0.0D;
                entityIn.motionZ = 0.0D;
            }
        });
    }
}
