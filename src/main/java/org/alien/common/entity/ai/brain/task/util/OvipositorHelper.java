package org.alien.common.entity.ai.brain.task.util;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.lib.brain.impl.EntityBrainContext;

/**
 * @author Boston Vanseghi
 */
public class OvipositorHelper {

    private OvipositorHelper() {}

    public static Vec3d getEggLayingPosition(Entity entity) {
        // TODO: Scale this distance with the queen's jelly level.
        int ovipositorDist = 10;
        double rotationYawRadians = Math.toRadians(entity.rotationYaw - 90);
        double ovamorphX = (entity.posX + (ovipositorDist * (Math.cos(rotationYawRadians))));
        double ovamorphZ = (entity.posZ + (ovipositorDist * (Math.sin(rotationYawRadians))));

        return new Vec3d(ovamorphX, entity.posY, ovamorphZ);
    }

    public static boolean isEggLayingPositionSafe(Entity entity, BlockPos eggPos) {
        // Make sure that the position the queen is laying an egg at is not in a wall.
        if (entity.world.getBlockState(eggPos) != Blocks.AIR.getDefaultState()) return false;

        // The ground below the egg-laying position must also be a full block.
        if (!entity.world.getBlockState(eggPos.down()).isFullBlock()) return false;

        return true;
    }

    public static boolean canSeeEggLayingPosition(Entity entity, BlockPos eggPos) {
        // The queen needs to have line-of-sight to her egglaying position.
        Vec3d bot = new Vec3d(entity.posX, entity.getEntityBoundingBox().maxY / 2, entity.posZ);
        Vec3d offset = new Vec3d(eggPos.getX(), eggPos.getY(), eggPos.getZ());
        RayTraceResult result = entity.world.rayTraceBlocks(bot, offset, false, true, false);
        return result == null;
    }

    public static boolean canGrowOvipositor(Entity entity) {
        Vec3d egglayingPosition = OvipositorHelper.getEggLayingPosition(entity);
        BlockPos eggPos = new BlockPos(egglayingPosition.x, egglayingPosition.y, egglayingPosition.z);
        return OvipositorHelper.isEggLayingPositionSafe(entity, eggPos) &&
                OvipositorHelper.canSeeEggLayingPosition(entity, eggPos);
    }
}
