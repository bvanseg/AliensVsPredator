package org.alien.common.entity.ai.brain.xenomorph;

import org.alien.common.entity.ai.brain.task.LurkInWaterBrainTask;
import org.alien.common.entity.ai.brain.task.UpdatePhosphorescenceLevelBrainTask;
import org.alien.common.entity.living.xenomorph.exotic.EntityNauticomorph;

/**
 * @author Boston Vanseghi
 */
public class NauticomorphBrain extends XenomorphBrain {

    public NauticomorphBrain(EntityNauticomorph entity) {
        super(entity);
    }

    @Override
    public void initTasks() {
        super.initTasks();

        this.addTask(new LurkInWaterBrainTask());
        this.addTask(new UpdatePhosphorescenceLevelBrainTask());
    }
}
