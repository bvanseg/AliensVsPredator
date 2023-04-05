package org.alien.common.entity.ai.brain.task;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.nbt.NBTTagCompound;
import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.api.parasitoidic.RoyalOrganism;
import org.alien.common.entity.living.SpeciesAlien;
import org.lib.brain.impl.AbstractEntityBrainTask;

/**
 * @author Boston Vanseghi
 */
public class MatureBrainTask extends AbstractEntityBrainTask {
    @Override
    protected boolean shouldExecute() {
        if (!(ctx.getEntity() instanceof SpeciesAlien)) return false;
        return ctx.getEntity().ticksExisted % 20 == 0 &&
                this.isReadyToMature((SpeciesAlien)ctx.getEntity());
    }

    @Override
    protected void startExecuting() {
        SpeciesAlien alienEntity = (SpeciesAlien) ctx.getEntity();
        this.mature(alienEntity);
    }

    public boolean isReadyToMature(SpeciesAlien alienEntity)
    {
        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(alienEntity.getClass()).orElse(null);
        if (maturityEntry == null) return false;
        RoyalOrganism ro = alienEntity;
        return maturityEntry.getEntityClass() != null &&
                maturityEntry.getRequiredJellyLevel() > 0 &&
                ro.getJellyLevel() >= maturityEntry.getRequiredJellyLevel();
    }

    public void mature(SpeciesAlien alienEntity)
    {
        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(alienEntity.getClass()).orElse(null);
        if (maturityEntry == null) return;
        SpeciesAlien alien = (SpeciesAlien) Entities.constructEntity(alienEntity.world, maturityEntry.getEntityClass());
        NBTTagCompound tag = new NBTTagCompound();

        alien.setLocationAndAngles(alienEntity.posX, alienEntity.posY, alienEntity.posZ, 0.0F, 0.0F);
        alienEntity.world.spawnEntity(alien);
        alienEntity.writeAlienToNBT(tag);
        alien.readAlienFromNBT(tag);
        alien.setJellyLevel(alienEntity.getJellyLevel() - maturityEntry.getRequiredJellyLevel());
        // TODO: Create a shell of the original entity.
        alienEntity.setDead();
    }
}
