package org.alien.common.entity.ai.brain.task;

import com.asx.mdx.lib.world.Pos;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class MatriarchMoveToHiveCoreBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}

	private ArrayList<Pos> pathPoints = new ArrayList<>();
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (!(ctx.getEntity() instanceof EntityMatriarch))
			return false;

		EntityMatriarch matriarch = (EntityMatriarch) ctx.getEntity();
		return matriarch.getAlienHive() != null && !matriarch.isReproducing();
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityMatriarch matriarch = (EntityMatriarch) ctx.getEntity();

		Pos coordQueen = new Pos(matriarch);
		Pos coordHive = new Pos(matriarch.getAlienHive().getCoreBlockPos().getX(), matriarch.getAlienHive().getCoreBlockPos().getY(),
				matriarch.getAlienHive().getCoreBlockPos().getZ());

		int hiveDist = (int) matriarch.getDistance(coordHive.x, coordHive.y, coordHive.z);

		if (hiveDist > matriarch.getAlienHive().getMaxHiveRadius() * 0.5 && matriarch.getAttackTarget() == null) {
			this.pathPoints = Pos.getPointsBetween(coordQueen, coordHive, hiveDist / 12);

			if (!this.pathPoints.isEmpty()) {
				Pos closestPoint = this.pathPoints.get(0);

				// TODO: This for loop may not be necessary, since the closest pos returned from Pos.getPointsBetween should always be the first pos in the collection.
				for (Pos point : this.pathPoints) {
					if (closestPoint != null && point.distanceFrom(matriarch) < closestPoint.distanceFrom(matriarch)) {
						closestPoint = point;
					}
				}

				if (matriarch.getDistance(closestPoint.x, closestPoint.y, closestPoint.z) < 1.0D) {
					this.pathPoints.remove(closestPoint);
				}
			}
		}
	}
}
