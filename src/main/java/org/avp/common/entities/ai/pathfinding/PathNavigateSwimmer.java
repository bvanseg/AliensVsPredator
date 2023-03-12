package org.avp.common.entities.ai.pathfinding;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.SwimNodeProcessor;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PathNavigateSwimmer extends PathNavigate
{
    public PathNavigateSwimmer(EntityLiving entityLiving, World worldIn)
    {
        super(entityLiving, worldIn);
    }

    @Override
    protected PathFinder getPathFinder()
    {
        return new PathFinder(new SwimNodeProcessor());
    }

    @Override
    protected boolean canNavigate()
    {
        return this.isInLiquid();
    }

    @Override
    protected Vec3d getEntityPosition()
    {
        return new Vec3d(this.entity.posX, this.entity.posY + (double) this.entity.height * 0.5D, this.entity.posZ);
    }

    @Override
    protected void pathFollow()
    {
        Vec3d entityPos = this.getEntityPosition();
        float widthSquared = this.entity.width * this.entity.width;

        if (entityPos.squareDistanceTo(this.currentPath.getVectorFromIndex(this.entity, this.currentPath.getCurrentPathIndex())) < (double) widthSquared)
        {
            this.currentPath.incrementPathIndex();
        }

        for (int i = Math.min(this.currentPath.getCurrentPathIndex() + 6, this.currentPath.getCurrentPathLength() - 1); i > this.currentPath.getCurrentPathIndex(); --i)
        {
            Vec3d currentPathVec = this.currentPath.getVectorFromIndex(this.entity, i);

            if (currentPathVec.squareDistanceTo(entityPos) <= 36.0D && this.isDirectPathBetweenPoints(entityPos, currentPathVec, 0, 0, 0))
            {
                this.currentPath.setCurrentPathIndex(i);
                break;
            }
        }

        this.checkForStuck(entityPos);
    }

    @Override
    protected void removeSunnyPath()
    {
        super.removeSunnyPath();
    }

    @Override
    protected boolean isDirectPathBetweenPoints(Vec3d pos1, Vec3d pos2, int sizeX, int sizeY, int sizeZ)
    {
        RayTraceResult result = this.world.rayTraceBlocks(pos1, new Vec3d(pos2.x, pos2.y + (double) this.entity.height * 0.5D, pos2.z), false);
        return result == null || result.typeOfHit == Type.MISS;
    }
}
