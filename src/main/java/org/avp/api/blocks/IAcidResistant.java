package org.avp.api.blocks;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IAcidResistant
{
    public boolean canAcidDestroy(World world, BlockPos posBelow, EntityLiving acid);
}
