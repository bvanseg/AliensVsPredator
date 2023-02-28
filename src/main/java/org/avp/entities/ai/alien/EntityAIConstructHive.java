package org.avp.entities.ai.alien;

import org.avp.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.world.hives.HiveHandler;

import net.minecraft.entity.ai.EntityAIBase;

/**
 *
 * @author Boston Vanseghi
 *
 */
public class EntityAIConstructHive extends EntityAIBase {
	
	private EntityMatriarch matriarch;
	
	public EntityAIConstructHive(EntityMatriarch matriarch) {
		super();
		this.matriarch = matriarch;
		this.setMutexBits(0);
	}

	@Override
	public boolean shouldExecute() {
        boolean ovipositorHealthy = this.matriarch.getJellyLevel() >= EntityMatriarch.OVIPOSITOR_UNHEALTHY_THRESHOLD;
		return ovipositorHealthy &&
				this.matriarch.getHive() == null &&
				this.matriarch.world.getTotalWorldTime() % 20 == 0 &&
				!this.matriarch.world.canSeeSky(this.matriarch.getPosition());
	}

	@Override
	public void updateTask() {
		this.matriarch.setHive(HiveHandler.instance.getHiveForUUID(this.matriarch.getUniqueID()));

        if (this.matriarch.getHive() == null) {
            HiveHandler.instance.createHive(matriarch);
        }

        this.removeAI();
	}

    private void removeAI() {
        if (!this.matriarch.tasks.taskEntries.isEmpty() || !this.matriarch.targetTasks.taskEntries.isEmpty()) {
            this.matriarch.tasks.taskEntries.clear();
            this.matriarch.targetTasks.taskEntries.clear();
        }
    }
}
