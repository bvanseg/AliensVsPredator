package org.alien.common.entity.ai.brain.task;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.util.EnumParticleTypes;
import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.xenomorph.EntityChestburster;

/**
 * @author Boston Vanseghi
 */
public class ChestbursterMatureBrainTask extends MatureBrainTask {

    @Override
    public boolean isReadyToMature(SpeciesAlien alienEntity)
    {
        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(alienEntity.getClass()).orElse(MaturityEntries.DEFAULT);
        return alienEntity.ticksExisted >= maturityEntry.getMaturityTime() || alienEntity.getJellyLevel() >= maturityEntry.getRequiredJellyLevel();
    }

    @Override
    public void mature(SpeciesAlien alienEntity)
    {
        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(alienEntity.getClass()).orElse(MaturityEntries.DEFAULT);
        if (alienEntity.getJellyLevel() >= maturityEntry.getRequiredJellyLevel() && alienEntity.ticksExisted < maturityEntry.getMaturityTime())
        {
            alienEntity.setJellyLevel(alienEntity.getJellyLevel() - maturityEntry.getRequiredJellyLevel());
        }

        SpeciesAlien matureState = (SpeciesAlien) Entities.constructEntity(alienEntity.world, ((EntityChestburster)alienEntity).getMatureState());

        if (matureState != null)
        {
            matureState.setLocationAndAngles(alienEntity.posX, alienEntity.posY, alienEntity.posZ, 0.0F, 0.0F);
            alienEntity.world.spawnEntity(matureState);
        }

        alienEntity.setDead();
    }
}
