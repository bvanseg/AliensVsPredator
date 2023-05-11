package org.alien.common.entity.ai.brain.task;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.nbt.NBTTagCompound;
import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.hive.AlienHive;
import org.alien.common.world.hive.HiveMember;
import org.alien.common.world.hive.HiveOwner;
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

        // If the alien is a hive member, we additionally need to check that this alien's role is not in equilibrium
        // with the rest of the hive. So for example, if alienEntity is a drone and there are too many drones within the hive,
        // this check will be set to true. However, if there are not enough drones in the hive relative to warriors, this check
        // will return false, because the hive has a need for drones and can not afford to make warriors.
        boolean canHiveMemberMature = true;
        if (alienEntity instanceof HiveMember) {
            HiveMember hiveMember = (HiveMember) alienEntity;
            AlienHive alienHive = hiveMember.getAlienHive();

            if (alienHive != null) {
                canHiveMemberMature = alienHive.canMature(alienEntity.getClass());

                // If the next morph is a hive owner, but the hive already has an owner, do not morph.
                if (HiveOwner.class.isAssignableFrom(maturityEntry.getEntityClass()) && !alienHive.getHiveOwnerEntity().isDead) {
                    canHiveMemberMature = false;
                }
            }
        }

        return canHiveMemberMature &&
                maturityEntry.getEntityClass() != null &&
                maturityEntry.getRequiredJellyLevel() > 0 &&
                alienEntity.jellyLevel.get() >= maturityEntry.getRequiredJellyLevel();
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
        alien.jellyLevel.add(-maturityEntry.getRequiredJellyLevel());
        // TODO: Create a shell of the original entity.
        alienEntity.setDead();

        // As soon as the entity matures, we need the alien hive to update to be aware of the member change.
        if (alienEntity instanceof HiveMember) {
            HiveMember hiveMember = (HiveMember) alienEntity;
            AlienHive alienHive = hiveMember.getAlienHive();

            if (alienHive != null) {
                if (alien instanceof HiveMember) {
                    alienHive.addHiveMember(((HiveMember)alien).getHiveMemberID());
                }
                alienHive.update();
            }
        }
    }
}
