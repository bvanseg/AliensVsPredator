package org.prometheus.common.entity.ai.brain.task;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.block.Blocks;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.prometheus.common.block.init.PrometheusBlocks;

import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class LurkInBlackGooBrainTask extends AbstractEntityBrainTask {
    @Override
    protected boolean shouldExecute() {
        EntityLiving entity = ctx.getEntity();
        if (entity.getAttackTarget() != null)
            return false;
        if (entity.world.getTotalWorldTime() % 40 != 0 && entity.getRNG().nextInt(4) != 0)
            return false;

        return entity.world.getBlockState(entity.getPosition()).getBlock() != PrometheusBlocks.BLACK_GOO;
    }

    @Override
    protected void startExecuting() {
        EntityLiving entity = ctx.getEntity();
        List<Pos> locations = Blocks.getCoordDataInRangeIncluding((int) entity.posX, (int) entity.posY, (int) entity.posZ, 10, entity.world, PrometheusBlocks.BLACK_GOO);

        if (!locations.isEmpty()) {
            Pos selectedCoord = locations.get(entity.getRNG().nextInt(locations.size()));
            double speed = entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
            entity.getNavigator().tryMoveToXYZ(selectedCoord.x, selectedCoord.y, selectedCoord.z, speed);
        }
    }
}
