package org.alien.common.world.capability;

import com.asx.mdx.client.ClientGame;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import org.alien.common.world.Embryo;
import org.avp.client.render.tactical.TacticalHelmetHUDRenderEvent;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.OrganismClientSync;

import java.util.concurrent.Callable;

/**
 * @author Ri5ux
 */
public class OrganismImpl implements Organism, Capability.IStorage<Organism> {
    public static class Factory implements Callable<Organism> {
        @Override
        public Organism call() {
            return new OrganismImpl();
        }
    }

    private Embryo embryo;
    private int heartRate;

    public OrganismImpl() {
        this.embryo = null;
        this.heartRate = 60;
    }

    /**
     * Gets the heart rate of this organism, which is measured in BPM.
     */
    @Override
    public int getHeartRate() {
        return this.heartRate;
    }

    @Override
    public void setHeartRate(int rate) {
        this.heartRate = rate;
    }

    @Override
    public boolean hasEmbryo() {
        return this.embryo != null;
    }

    @Override
    public Embryo getEmbryo() {
        return this.embryo;
    }

    @Override
    public void setEmbryo(Embryo embryo) {
        this.embryo = embryo;
    }

    public void onTick(EntityLivingBase living, Organism organism) {
        World world = living.world;

        if (!world.isRemote && world.getTotalWorldTime() % 60 == 0) {
            this.syncWithClients(living);
        }

        if (!world.isRemote) {
            if (living.isSprinting()) {
                organism.setHeartRate(130 + living.getRNG().nextInt(20));
            } else if (living.motionX + living.motionZ > 0) {
                organism.setHeartRate(70 + living.getRNG().nextInt(10));
            } else {
                organism.setHeartRate(60 + living.getRNG().nextInt(10));
            }

            if (organism.hasEmbryo()) {
                int age = organism.getEmbryo().getAge();
                int gestationPeriod = organism.getEmbryo().getGestationPeriod();
                int timeLeft = gestationPeriod - age;
                int timeBleed = gestationPeriod - (gestationPeriod / 10);

                if (age >= timeBleed) {
                    organism.setHeartRate(60 + (250 - (timeLeft * 250 / (30 * 20))));

                    if (world.getTotalWorldTime() % 10 == 0) {
                        this.syncWithClients(living);
                    }
                }
            }
        }

        if (world.isRemote && living == ClientGame.instance.minecraft().player) {
            TacticalHelmetHUDRenderEvent.instance.getElectrocardiogram().setRate(organism.getHeartRate());
        }
    }

    public void syncWithClients(EntityLivingBase living) {
        if (living != null && !living.world.isRemote) {
            NBTTagCompound tag = (NBTTagCompound) Provider.CAPABILITY.getStorage().writeNBT(Provider.CAPABILITY, this, null);
            OrganismClientSync packet = new OrganismClientSync(living.getEntityId(), tag);
            AVPNetworking.instance.sendToAll(packet);
        }
    }

    private static final String BPM_NBT_KEY = "BPM";

    @Override
    public NBTBase writeNBT(Capability<Organism> capability, Organism instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();

        Embryo.save(instance.getEmbryo(), tag);
        tag.setInteger(BPM_NBT_KEY, instance.getHeartRate());

        return tag;
    }

    @Override
    public void readNBT(Capability<Organism> capability, Organism instance, EnumFacing side, NBTBase nbt) {
        if (nbt instanceof NBTTagCompound) {
            NBTTagCompound tag = (NBTTagCompound) nbt;

            instance.setEmbryo(Embryo.load(tag));
            instance.setHeartRate(tag.getInteger(BPM_NBT_KEY));
        }
    }
}