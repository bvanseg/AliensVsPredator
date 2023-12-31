package org.alien.common.entity.ai.brain.task.util;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.alien.client.render.util.AlienGrowthUtil;
import org.alien.common.entity.living.SpeciesAlien;

/**
 * @author Boston Vanseghi
 */
public class OvipositorHelper {

    private OvipositorHelper() {}

    public static Vec3d getPositionAround(Entity entity, int distance, float yaw) {
        double rotationYawRadians = Math.toRadians(yaw);
        double x = (entity.posX + (distance * (Math.cos(rotationYawRadians))));
        double z = (entity.posZ + (distance * (Math.sin(rotationYawRadians))));

        return new Vec3d(x, entity.posY, z);
    }

    public static Vec3d getEggLayingPosition(Entity entity) {
        int distance = 10;

        if (entity instanceof SpeciesAlien) {
            float magicValue = MathHelper.clamp(((SpeciesAlien)entity).jellyLevel.get() / ((float)AlienGrowthUtil.MATRIARCH_MAX_PSEUDO_JELLY_LEVEL * 2), 0F, 1F) / 1.75F;
            distance += distance * magicValue;
        }

        return getPositionAround(entity, distance, entity.rotationYaw - 180);
    }

    public static Vec3d getOppositeOfEggLayingPosition(Entity entity) {
        int distance = 10;

        if (entity instanceof SpeciesAlien) {
            float magicValue = MathHelper.clamp(((SpeciesAlien)entity).jellyLevel.get() / ((float)AlienGrowthUtil.MATRIARCH_MAX_PSEUDO_JELLY_LEVEL * 2), 0F, 1F) / 1.75F;
            distance += distance * magicValue;
        }

        return getPositionAround(entity, distance, entity.rotationYaw);
    }

    public static boolean isEggLayingPositionSafe(Entity entity, BlockPos eggPos) {
        // Make sure that the position the queen is laying an egg at is not in a wall.
        if (entity.world.getBlockState(eggPos) != Blocks.AIR.getDefaultState()) return false;

        // The ground below the egg-laying position must also be a full block.

        boolean isSafeBlockBelow = false;

        for (int i = 0; i < 4; i++) {
            if (entity.world.getBlockState(eggPos.down(i + 1)).isFullBlock()) {
                isSafeBlockBelow = true;
            }
        }

        return isSafeBlockBelow;
    }

    public static boolean canSeeEggLayingPosition(Entity entity, BlockPos eggPos) {
        // The queen needs to have line-of-sight to her egglaying position.
        Vec3d bot = new Vec3d(entity.posX, entity.posY + (entity.height / 2), entity.posZ);
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
