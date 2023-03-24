package org.lib.brain.impl.task;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class WanderBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
        map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
        map.put(BrainFlags.NEAREST_AVOID_TARGET, BrainFlagState.ABSENT);
    }

    @Override
    public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
    }
    
    protected double x;
    protected double y;
    protected double z;
    protected final double speed;
    protected int executionChance;

    private int idleTime;
    
    public WanderBrainTask(double speed) {
    	this(speed, 120);
    }
    
    public WanderBrainTask(double speed, int executionChance) {
    	this.speed = speed;
        this.executionChance = executionChance;
    }
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
        if (this.idleTime <= 100) {
            this.idleTime++;
            return false;
        }

        if (ctx.getEntity().getRNG().nextInt(this.executionChance) != 0) {
            return false;
        }

        Vec3d vec3d = this.getPosition(ctx);

        if (vec3d == null) {
            return false;
        } else {
            this.x = vec3d.x;
            this.y = vec3d.y;
            this.z = vec3d.z;
            this.idleTime = 0;
            return true;
        }
	}

    @Override
    protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
        return !ctx.getEntity().getNavigator().noPath();
    }

    @Override
	protected void startExecuting(EntityBrainContext ctx) {
    	ctx.getEntity().getNavigator().tryMoveToXYZ(this.x, this.y, this.z, this.speed);
	}

    @Nullable
    protected Vec3d getPosition(EntityBrainContext ctx) {
        return RandomPositionGenerator.findRandomTarget((EntityCreature)ctx.getEntity(), 10, 7);
    }
}
