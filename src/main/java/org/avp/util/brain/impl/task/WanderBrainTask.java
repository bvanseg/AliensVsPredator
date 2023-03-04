package org.avp.util.brain.impl.task;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import org.avp.util.brain.flag.AbstractBrainFlag;
import org.avp.util.brain.flag.BrainFlagState;
import org.avp.util.brain.impl.BrainFlags;
import org.avp.util.brain.impl.EntityBrainContext;
import org.avp.util.brain.task.AbstractBrainTask;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class WanderBrainTask extends AbstractBrainTask<EntityBrainContext> {
	
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<AbstractBrainFlag, BrainFlagState>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}
    
    protected double x;
    protected double y;
    protected double z;
    protected final double speed;
    protected int executionChance;
    protected boolean mustUpdate;
    
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
		
		if (!this.mustUpdate) {
            if (ctx.getEntity().getIdleTime() <= 100) {
                return false;
            }

            if (ctx.getEntity().getRNG().nextInt(this.executionChance) != 0) {
                return false;
            }
        }

        Vec3d vec3d = this.getPosition(ctx);

        if (vec3d == null) {
            return false;
        } else {
            this.x = vec3d.x;
            this.y = vec3d.y;
            this.z = vec3d.z;
            this.mustUpdate = false;
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
