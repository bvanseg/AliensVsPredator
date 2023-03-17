package org.lib.brain.impl.task;

import com.google.common.base.Predicates;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EntitySelectors;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class WatchClosestBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.LOOK, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.LOOK, BrainFlagState.PRESENT);
	}
    
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    protected float maxDistance;
    private final float chance;
	private int lookTimeInTicks;
    protected Class <? extends Entity > watchedClass;
    
    public WatchClosestBrainTask(Class <? extends Entity > watchTargetClass, float maxDistance) {
    	this(watchTargetClass, maxDistance, 0.02F);
    }

    public WatchClosestBrainTask(Class <? extends Entity > watchTargetClass, float maxDistance, float chanceIn) {
        this.watchedClass = watchTargetClass;
        this.maxDistance = maxDistance;
        this.chance = chanceIn;
    }
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();
		if (entity.getRNG().nextFloat() >= this.chance) {
			return false;
		} else {
			if (entity.getAttackTarget() != null) {
				this.closestEntity = entity.getAttackTarget();
			}

			if (this.watchedClass == EntityPlayer.class) {
				this.closestEntity = entity.world.getClosestPlayer(entity.posX, entity.posY, entity.posZ,
						this.maxDistance,
						Predicates.and(EntitySelectors.NOT_SPECTATING, EntitySelectors.notRiding(entity)));
			} else {
				Optional<List<EntityLivingBase>> optional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);

				if (optional.isPresent()) {
					List<EntityLivingBase> nearbyEntities = optional.get();

					if (nearbyEntities.isEmpty()) {
						return false;
					}
					
					this.closestEntity = nearbyEntities.get(0);
				}
			}

			return this.closestEntity != null;
		}
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		this.lookTimeInTicks = 40 + ctx.getEntity().getRNG().nextInt(40);
	}

	@Override
	protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
		if (ctx.getEntity().getDistanceSq(this.closestEntity) > (this.maxDistance * this.maxDistance)) {
			return false;
		}

		return this.closestEntity != null && !this.closestEntity.isDead && this.lookTimeInTicks > 0;
	}

	@Override
	protected void continueExecuting(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();
		entity.getLookHelper().setLookPosition(
			this.closestEntity.posX,
			this.closestEntity.posY + this.closestEntity.getEyeHeight(),
			this.closestEntity.posZ,
			entity.getHorizontalFaceSpeed(),
			entity.getVerticalFaceSpeed()
		);
		this.lookTimeInTicks--;
	}
}
