package org.alien.common.world;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.alien.common.api.emybro.EmbryoEntry;
import org.alien.common.api.emybro.EmbryoRegistry;
import org.alien.common.world.capability.Organism;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.common.AVPDamageSources;

/**
 * @author Ri5ux
 */
public class Embryo {
    private final int id;
    private int age;

    public Embryo(int id) {
        this.id = id;
        this.age = 0;
    }

    public void grow() {
        this.age++;
    }

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public EmbryoEntry getEntry() {
        return EmbryoRegistry.findById(this.id);
    }

    public Class<? extends EntityLivingBase> getBirthCreature() {
        return getEntry().getTransitionary().orElse(getEntry().getAdult());
    }

    private Entity createBirthCreature(World world) {
        return Entities.constructEntity(world, getBirthCreature());
    }

    public void vitalize(EntityLivingBase host) {
        OrganismImpl hostOrganism = (OrganismImpl) host.getCapability(Organism.Provider.CAPABILITY, null);
        Entity birthCreature = this.createBirthCreature(host.world);

        Pos safeLocation = Entities.getSafeLocationAround(birthCreature, new Pos((int)host.posX, (int)host.posY, (int)host.posZ));

        if (safeLocation == null)
        {
            safeLocation = new Pos((int)host.posX, (int)host.posY, (int)host.posZ);
        }

        birthCreature.setLocationAndAngles(safeLocation.x(), safeLocation.y(), safeLocation.z(), 0.0F, 0.0F);
        host.world.spawnEntity(birthCreature);
        hostOrganism.setEmbryo(null);
        host.getActivePotionEffects().clear();
        host.attackEntityFrom(AVPDamageSources.causeChestbursterDamage(birthCreature, host), 100000F);
        if(!host.isDead) {
            host.setHealth(0);
        }
    }

    /**
     * Deprecated. Use EmbryoEntry#getGestationPeriod, instead.
     *
     * @return The amount of time in ticks the embryo needs to grow for before it can vitalize.
     */
    @Deprecated
    public int getGestationPeriod() {
        EmbryoEntry embryoEntry = EmbryoRegistry.findById(this.id);
        return embryoEntry.getGestationPeriod();
    }

    private static final String AGE_NBT_KEY = "Age";
    private static final String EMBRYO_ID_NBT_KEY = "EmbryoId";

    public static void save(Embryo embryo, NBTTagCompound nbt) {
        if (embryo != null) {
            nbt.setInteger(EMBRYO_ID_NBT_KEY, embryo.id);
            nbt.setInteger(AGE_NBT_KEY, embryo.age);
        }
    }

    public static Embryo load(NBTTagCompound nbt) {
        int id = nbt.getInteger(EMBRYO_ID_NBT_KEY);

        if (id != 0) {
            try {
                EmbryoEntry embryoEntry = EmbryoRegistry.findById(id);
                Embryo embryo = embryoEntry.create();
                embryo.age = nbt.getInteger(AGE_NBT_KEY);

                return embryo;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
