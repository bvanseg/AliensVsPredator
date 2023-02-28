package org.avp.entities.ai.alien;

import java.util.ArrayList;

import org.avp.entities.living.species.xenomorphs.EntityMatriarch;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.Pos;

import net.minecraft.entity.ai.EntityAIBase;

/**
 *
 * @author Boston Vanseghi
 *
 */
public class EntityAIPathFindToHive extends EntityAIBase {

	private EntityMatriarch matriarch;
	private ArrayList<Pos> pathPoints = new ArrayList<Pos>();

	public EntityAIPathFindToHive(EntityMatriarch matriarch) {
		super();
		this.matriarch = matriarch;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		return this.matriarch.getHive() != null && !this.matriarch.isReproducing();
	}

	@Override
	public void updateTask() {
		Pos coordQueen = new Pos(matriarch);
		Pos coordHive = new Pos(this.matriarch.getHive().xCoord(), this.matriarch.getHive().yCoord(),
				this.matriarch.getHive().zCoord());

		int hiveDist = (int) this.matriarch.getDistance(coordHive.x, coordHive.y, coordHive.z);

		if (hiveDist > this.matriarch.getHive().getMaxHiveRadius() * 0.5 && this.matriarch.getAttackTarget() == null) {
			this.pathPoints = Pos.getPointsBetween(coordQueen, coordHive, hiveDist / 12);

			if (this.pathPoints != null && !this.pathPoints.isEmpty()) {
				Pos closestPoint = this.pathPoints.get(0);

				// TODO: This for loop may not be necessary, since the closest pos returned from Pos.getPointsBetween should always be the first pos in the collection.
				for (Pos point : this.pathPoints) {
					if (closestPoint != null && point.distanceFrom(this.matriarch) < closestPoint.distanceFrom(this.matriarch)) {
						closestPoint = point;
					}
				}
				
				if (this.matriarch.getDistance(closestPoint.x, closestPoint.y, closestPoint.z) < 1.0D) {
					this.pathPoints.remove(closestPoint);
				}
			}
		}
	}
}
