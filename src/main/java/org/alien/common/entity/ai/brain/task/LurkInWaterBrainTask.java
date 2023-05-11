package org.alien.common.entity.ai.brain.task;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.block.Blocks;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import org.lib.brain.impl.AbstractEntityBrainTask;

import java.util.ArrayList;

/**
 * @author Boston Vanseghi
 */
public class LurkInWaterBrainTask extends AbstractEntityBrainTask {
    @Override
    protected boolean shouldExecute() {
        EntityLiving entity = ctx.getEntity();

        if (entity.getAttackTarget() != null) return false;
        if (entity.ticksExisted % 40 != 0) return false;
        if (entity.getRNG().nextInt(4) != 0) return false;
        if (entity.world.getBlockState(entity.getPosition()).getBlock() == net.minecraft.init.Blocks.WATER) return false;

        return true;
    }

    @Override
    protected void startExecuting() {
        EntityLiving entity = ctx.getEntity();

        double range = entity.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue() / 2;
        ArrayList<Pos> coordData = Blocks.getCoordDataInRangeIncluding((int) entity.posX, (int) entity.posY, (int) entity.posZ, (int) range, entity.world, net.minecraft.init.Blocks.WATER);

        if (coordData.isEmpty()) return;

        Pos selectedCoord = coordData.get(entity.getRNG().nextInt(coordData.size()));
        double speed = entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
        entity.getNavigator().tryMoveToXYZ(selectedCoord.x, selectedCoord.y, selectedCoord.z, speed);
    }
}
