package org.prometheus.common.entity.ai.brain.task;

import com.asx.mdx.common.minecraft.block.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.EntityParasitoid;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.prometheus.common.entity.living.vardic.EntityOctohugger;

import java.util.ArrayList;

/**
 * @author Boston Vanseghi
 */
public class UpdateHangingPositionBrainTask extends AbstractEntityBrainTask {

    @Override
    protected boolean shouldExecute() {
        return ctx.getEntity() instanceof EntityOctohugger;
    }

    @Override
    protected void startExecuting() {
        EntityOctohugger entity = (EntityOctohugger) ctx.getEntity();
        if (!entity.world.isRemote && entity.world.getTotalWorldTime() % 60 == 0 && entity.isHangingLocationStale())
        {
            this.findAndUpdateTargetHangingPosition(entity);
        }

        double stringStrength = 0.085D;

        ArrayList<EntityLivingBase> entities = (ArrayList<EntityLivingBase>) entity.world.getEntitiesWithinAABB(EntityLivingBase.class, entity.getEntityBoundingBox().expand(1, -8, 1));

        entities.removeIf(e -> !EntitySelectorParasitoid.instance.test(e) || e instanceof EntityParasitoid);

        Entity target = !entities.isEmpty() ? entities.get(entity.world.rand.nextInt(entities.size())) : null;

        if (target != null && entity.getDistanceSq(target) > 0)
        {
            stringStrength = 0.0F;
        }

        if (!entity.isHangingLocationStale())
        {
            this.updateHangingOctohuggerMotionAndLocation(entity, stringStrength);
        }

        if (
            entity.getRidingEntity() != null ||
            !entity.isFertile() ||
            entity.isHanging() &&
            entity.getHangingLocation() != null &&
            entity.world.getBlockState(entity.getHangingLocation()).getBlock() == net.minecraft.init.Blocks.AIR)
        {
            entity.setHanging(false);
            entity.updateHangingLocation(BlockPos.ORIGIN);
        }

        if (entity.isHanging())
        {
            entity.motionX = 0;
            entity.motionY = 0;
            entity.motionZ = 0;
        }
    }

    private void updateHangingOctohuggerMotionAndLocation(EntityOctohugger entity, double stringStrength) {
        double hangingX = entity.getHangingLocation().getX();
        double hangingY = entity.getHangingLocation().getY();
        double hangingZ = entity.getHangingLocation().getZ();
        entity.motionX += (hangingX - entity.posX) * stringStrength * 1.4;
        entity.motionY += (hangingY - entity.posY) * (stringStrength * 0.85);
        entity.motionZ += (hangingZ - entity.posZ) * stringStrength * 1.4;

        entity.move(MoverType.SELF, entity.motionX, entity.motionY, entity.motionZ);

        double distance = entity.getDistance(hangingX, hangingY, hangingZ);

        if (distance <= 1.1D)
        {
            entity.setHanging(true);
        }

        entity.motionX = 0;
        entity.motionY = 0;
        entity.motionZ = 0;
    }

    private void findAndUpdateTargetHangingPosition(EntityOctohugger entity) {
        ArrayList<BlockPos> locations = Blocks.getPositionsInRange((int) entity.posX, (int) entity.posY, (int) entity.posZ, 8);

        for (int x = 0; x < locations.size(); x++)
        {
            BlockPos pos = locations.get(entity.getRNG().nextInt(locations.size()));
            IBlockState state = entity.world.getBlockState(pos);

            if (state.getBlock() != net.minecraft.init.Blocks.AIR)
            {
                ArrayList<IBlockState> check = new ArrayList<>();
                BlockPos locBelow = pos.add(0, -1, 0);

                check.add(entity.world.getBlockState(locBelow));
                check.add(entity.world.getBlockState(locBelow.add(-1, 0, 0)));
                check.add(entity.world.getBlockState(locBelow.add(0, 0, -1)));
                check.add(entity.world.getBlockState(locBelow.add(+1, 0, 0)));
                check.add(entity.world.getBlockState(locBelow.add(0, 0, +1)));

                boolean validPosition = true;

                for (IBlockState blockstate : check)
                {
                    if (blockstate.getBlock() != net.minecraft.init.Blocks.AIR)
                    {
                        validPosition = false;
                        break;
                    }
                }

                RayTraceResult trace = entity.world.rayTraceBlocks(new Vec3d(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ), new Vec3d(pos.getX(), pos.getY(), pos.getZ()), false, true, false);
                boolean canSeeLocation = trace == null;

                if (validPosition && canSeeLocation)
                {
                    entity.updateHangingLocation(pos.add(0.5D + (entity.getRNG().nextDouble() / 2) - (entity.getRNG().nextDouble() / 2), 0, 0.5D + (entity.getRNG().nextDouble() / 2) - (entity.getRNG().nextDouble() / 2)));
                    break;
                }
            }
        }
    }
}
