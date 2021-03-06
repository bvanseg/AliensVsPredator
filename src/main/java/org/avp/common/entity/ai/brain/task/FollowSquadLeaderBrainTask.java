package org.avp.common.entity.ai.brain.task;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.avp.common.entity.living.EntityMarine;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.Map;
import java.util.Optional;

/**
 * @author Boston Vanseghi
 */
public class FollowSquadLeaderBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    }

    @Override
    public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
    }

    private final double followSpeed;
    private int timeToRecalcPath;
    float maxDist;
    float minDist;
    private float oldWaterCost;

    public FollowSquadLeaderBrainTask(double followSpeed, float minDist, float maxDist) {
        this.followSpeed = followSpeed;
        this.minDist = minDist;
        this.maxDist = maxDist;
    }

    @Override
    protected boolean shouldExecute() {
        if (!(ctx.getEntity() instanceof EntityMarine)) return false;
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        if (!marine.getSquadLeader().isPresent()) return false;

        Optional<EntityLivingBase> squadLeaderOptional = marine.getSquadLeader().toJavaUtil();

        if (!squadLeaderOptional.isPresent())
            return false;

        EntityLivingBase squadLeader = squadLeaderOptional.get();

        if (squadLeader instanceof EntityPlayer && ((EntityPlayer)squadLeader).isSpectator())
            return false;
        else
            return marine.getDistanceSq(squadLeader) >= (this.minDist * this.minDist);
    }

    @Override
    protected void startExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        this.timeToRecalcPath = 0;
        this.oldWaterCost = marine.getPathPriority(PathNodeType.WATER);
        marine.setPathPriority(PathNodeType.WATER, 0.0F);
        marine.getNavigator().tryMoveToEntityLiving(marine.getSquadLeader().get(), this.followSpeed);
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        Optional<EntityLivingBase> squadLeaderOptional = marine.getSquadLeader().toJavaUtil();

        if (!squadLeaderOptional.isPresent())
            return false;

        EntityLivingBase squadLeader = squadLeaderOptional.get();

        boolean hasPath = !marine.getNavigator().noPath();

        // If the marine loses their pathing, we want to attempt a teleport.
        if (!hasPath) {
            this.attemptToTeleportToSquadLeader(squadLeader);
        }

        return marine.getDistanceSq(squadLeader) > this.maxDist * this.maxDist;
    }

    @Override
    protected void continueExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        EntityLivingBase squadLeader = marine.getSquadLeader().get();

        marine.getLookHelper().setLookPositionWithEntity(squadLeader, 10.0F, marine.getVerticalFaceSpeed());

        if (--this.timeToRecalcPath <= 0)
        {
            this.timeToRecalcPath = 10;

            if (!marine.getNavigator().tryMoveToEntityLiving(squadLeader, this.followSpeed))
                this.attemptToTeleportToSquadLeader(squadLeader);
        }
    }

    private void attemptToTeleportToSquadLeader(EntityLivingBase owner) {
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        if (marine.getLeashed() || marine.isRiding()) return;
        if (marine.getDistanceSq(owner) < 1440.0D) return;

        int i = MathHelper.floor(owner.posX) - 2;
        int j = MathHelper.floor(owner.posZ) - 2;
        int k = MathHelper.floor(owner.getEntityBoundingBox().minY);

        for (int l = 0; l <= 4; ++l)
        {
            for (int i1 = 0; i1 <= 4; ++i1)
            {
                if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.isTeleportFriendlyBlock(i, j, k, l, i1))
                {
                    marine.setLocationAndAngles((i + l) + 0.5F, k, (j + i1) + 0.5F, marine.rotationYaw, marine.rotationPitch);
                    marine.getNavigator().clearPath();
                    return;
                }
            }
        }
    }

    @Override
    public void finish() {
        super.finish();
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        marine.getNavigator().clearPath();
        marine.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
    }

    protected boolean isTeleportFriendlyBlock(int x, int z, int y, int xOffset, int zOffset)
    {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        BlockPos blockpos = new BlockPos(x + xOffset, y - 1, z + zOffset);
        IBlockState iblockstate = marine.world.getBlockState(blockpos);
        return iblockstate.getBlockFaceShape(marine.world, blockpos, EnumFacing.DOWN) == BlockFaceShape.SOLID && iblockstate.canEntitySpawn(marine) && marine.world.isAirBlock(blockpos.up()) && marine.world.isAirBlock(blockpos.up(2));
    }
}
