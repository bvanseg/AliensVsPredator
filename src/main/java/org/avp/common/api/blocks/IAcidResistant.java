package org.avp.common.api.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IAcidResistant
{
    public boolean canAcidDestroy(World world, BlockPos posBelow, Entity acid);
}
