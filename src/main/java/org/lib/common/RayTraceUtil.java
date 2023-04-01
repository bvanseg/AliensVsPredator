package org.lib.common;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class RayTraceUtil {

    private RayTraceUtil() {}

    public static RayTraceResult rayTrace(Entity shooter, double maxDistance, float partialTicks) {
        Vec3d start = shooter.getPositionEyes(partialTicks);
        Vec3d look = shooter.getLook(partialTicks);
        Vec3d end = start.add(look.scale(maxDistance));
        RayTraceResult blockHit = shooter.world.rayTraceBlocks(start, end, false, true, false);
        RayTraceResult entityHit = rayTraceEntities(shooter, maxDistance, partialTicks);
        if (blockHit == null) {
            return entityHit;
        } else if (entityHit == null) {
            return blockHit;
        } else {
            double blockHitDistance = blockHit.hitVec.distanceTo(start);
            double entityHitDistance = entityHit.hitVec.distanceTo(start);
            return blockHitDistance < entityHitDistance ? blockHit : entityHit;
        }
    }

    public static RayTraceResult rayTraceEntities(Entity shooter, double maxDistance, float partialTicks) {
        Vec3d start = shooter.getPositionEyes(partialTicks);
        Vec3d look = shooter.getLook(partialTicks);
        Vec3d end = start.add(look.scale(maxDistance));
        Vec3d scaledVec = look.scale(maxDistance);

        AxisAlignedBB boundingBox = shooter.getEntityBoundingBox().expand(scaledVec.x, scaledVec.y, scaledVec.z).grow(1.0D, 1.0D, 1.0D);
        List<Entity> entities = shooter.world.getEntitiesInAABBexcluding(shooter, boundingBox, e -> e != null && e.canBeCollidedWith());

        RayTraceResult closestHit = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Entity entity : entities) {
            AxisAlignedBB entityBoundingBox = entity.getEntityBoundingBox().grow(entity.getCollisionBorderSize());
            RayTraceResult rayTraceResult = entityBoundingBox.calculateIntercept(start, end);

            if (rayTraceResult != null) {
                double distance = start.distanceTo(rayTraceResult.hitVec);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestHit = new RayTraceResult(entity, rayTraceResult.hitVec);
                }
            }
        }

        return closestHit;
    }
}
