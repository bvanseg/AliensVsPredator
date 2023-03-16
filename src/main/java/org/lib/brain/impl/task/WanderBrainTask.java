package org.lib.brain.impl.task;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class WanderBrainTask extends AbstractBrainTask<EntityBrainContext> {
	
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return FLAGS;
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
		if (!ctx.getEntity().getNavigator().noPath()) {
			return false;
		}

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
	protected void execute(EntityBrainContext ctx) {
    	ctx.getEntity().getNavigator().tryMoveToXYZ(this.x, this.y, this.z, this.speed);
	}

    @Nullable
    protected Vec3d getPosition(EntityBrainContext ctx) {
        return RandomPositionGenerator.findRandomTarget((EntityCreature)ctx.getEntity(), 10, 7);
    }
}
