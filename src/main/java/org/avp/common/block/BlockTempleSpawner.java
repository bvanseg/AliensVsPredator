package org.avp.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.alien.common.entity.living.xenomorphs.EntityMatriarch;
import org.alien.common.entity.living.xenomorphs.EntityOvamorph;

public class BlockTempleSpawner extends Block
{
    public boolean creativeOnly;

    public BlockTempleSpawner(Material material, boolean creativeOnly)
    {
        super(material);
        this.creativeOnly = creativeOnly;
    }

    @Override
    public void onNeighborChange(IBlockAccess access, BlockPos pos, BlockPos neighbor)
    {
        if (access instanceof World)
        {
            World world = (World) access;
            int range = 25;

            boolean isQueenNear = world.getEntitiesWithinAABB(EntityMatriarch.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1).expand(range * 2, 50.0D, range * 2)).size() >= 1;

            if (!world.isRemote)
            {
                if (!(world.getRedstonePowerFromNeighbors(pos) > 0))
                {
                    world.scheduleBlockUpdate(pos, this, 4, 1);
                }
                else if (world.getRedstonePowerFromNeighbors(pos) > 0 && isQueenNear || world.getRedstonePowerFromNeighbors(pos) > 0 && creativeOnly)
                {
                    EntityOvamorph entityEgg = new EntityOvamorph(world);
                    entityEgg.setLocationAndAngles(pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D, 0.0F, 0.0F);
                    world.spawnEntity(entityEgg);
                }
            }
        }
    }
}
