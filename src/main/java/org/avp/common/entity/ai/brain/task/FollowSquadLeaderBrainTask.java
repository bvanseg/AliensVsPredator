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
import java.util.UUID;

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

        if (!marine.getSquadLeaderID().isPresent()) return false;


        EntityLivingBase squadLeader = this.getSquadLeader(marine);

        if (squadLeader == null)
        {
            return false;
        }
        else if (squadLeader instanceof EntityPlayer && ((EntityPlayer)squadLeader).isSpectator())
        {
            return false;
        }
        else if (marine.getDistanceSq(squadLeader) < (this.minDist * this.minDist))
        {
            return false;
        }

        return true;
    }

    @Override
    protected void startExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        EntityLivingBase squadLeader = this.getSquadLeader(marine);
        this.timeToRecalcPath = 0;
        this.oldWaterCost = marine.getPathPriority(PathNodeType.WATER);
        marine.setPathPriority(PathNodeType.WATER, 0.0F);
        marine.getNavigator().tryMoveToEntityLiving(squadLeader, this.followSpeed);
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        return !marine.getNavigator().noPath() &&
                marine.getDistanceSq(this.getSquadLeader(marine)) > (this.maxDist * this.maxDist);
    }

    @Override
    protected void continueExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        EntityLivingBase owner = getSquadLeader(marine);
        marine.getLookHelper().setLookPositionWithEntity(owner, 10.0F, (float)marine.getVerticalFaceSpeed());

        if (--this.timeToRecalcPath <= 0)
        {
            this.timeToRecalcPath = 10;

            if (!marine.getNavigator().tryMoveToEntityLiving(owner, this.followSpeed))
            {
                if (!marine.getLeashed() && !marine.isRiding())
                {
                    if (marine.getDistanceSq(owner) >= 144.0D)
                    {
                        int i = MathHelper.floor(owner.posX) - 2;
                        int j = MathHelper.floor(owner.posZ) - 2;
                        int k = MathHelper.floor(owner.getEntityBoundingBox().minY);

                        for (int l = 0; l <= 4; ++l)
                        {
                            for (int i1 = 0; i1 <= 4; ++i1)
                            {
                                if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.isTeleportFriendlyBlock(i, j, k, l, i1))
                                {
                                    marine.setLocationAndAngles((float)(i + l) + 0.5F, k, (float)(j + i1) + 0.5F, marine.rotationYaw, marine.rotationPitch);
                                    marine.getNavigator().clearPath();
                                    return;
                                }
                            }
                        }
                    }
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

    public EntityLivingBase getSquadLeader(EntityMarine marine) {
        UUID uuid = marine.getSquadLeaderID().get();
        return marine.world.getPlayerEntityByUUID(uuid);
    }

    protected boolean isTeleportFriendlyBlock(int x, int z, int y, int xOffset, int zOffset)
    {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        BlockPos blockpos = new BlockPos(x + xOffset, y - 1, z + zOffset);
        IBlockState iblockstate = marine.world.getBlockState(blockpos);
        return iblockstate.getBlockFaceShape(marine.world, blockpos, EnumFacing.DOWN) == BlockFaceShape.SOLID && iblockstate.canEntitySpawn(marine) && marine.world.isAirBlock(blockpos.up()) && marine.world.isAirBlock(blockpos.up(2));
    }
}
