package org.avp.common.entities.ai.alien;

import net.minecraft.entity.ai.EntityAIBase;
import org.avp.common.entities.living.species.SpeciesXenomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.common.world.hives.rework.HiveMember;
import org.avp.common.world.hives.rework.HiveOwner;

public class EntityAIShareJelly extends EntityAIBase
{

    private SpeciesXenomorph xenomorph;

    public EntityAIShareJelly(SpeciesXenomorph xenomorph)
    {
        super();
        this.xenomorph = xenomorph;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute()
    {
    	if (xenomorph instanceof HiveMember)
    		return false;
    	HiveMember hiveMember = (HiveMember)xenomorph;

        return this.xenomorph.getJellyLevel() > 0 && hiveMember.getAlienHive() != null && xenomorph.getAttackTarget() == null;
    }

    @Override
    public void updateTask()
    {
        super.updateTask();

        HiveMember hiveMember = (HiveMember) this.xenomorph;
    	HiveOwner hiveOwner = hiveMember.getAlienHive().getHiveOwner();

    	if (hiveOwner instanceof EntityMatriarch) {
    		EntityMatriarch queen = (EntityMatriarch) hiveOwner;

            if (hiveMember.getAlienHive() != null && !(this.xenomorph instanceof EntityMatriarch))
            {
                if (queen.getOvipositorSize() < EntityMatriarch.OVIPOSITOR_THRESHOLD_SIZE || queen.isReproducing())
                {
                    if (queen.getJellyLevel() < EntityMatriarch.OVIPOSITOR_JELLYLEVEL_THRESHOLD * 2 && this.xenomorph.getJellyLevel() >= 80)
                    {
                    	queen.setJellyLevel(queen.getJellyLevel() + this.xenomorph.getJellyLevel());
                        this.xenomorph.setJellyLevel(0);
                    }
                }
            }
    	}
    }
}
