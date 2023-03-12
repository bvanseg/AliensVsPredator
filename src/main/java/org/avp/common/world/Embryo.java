package org.avp.common.world;

import java.util.ArrayList;

import org.avp.common.api.parasitoidic.INascentic;
import org.avp.common.entities.living.species.engineer.EntityEngineer;
import org.avp.common.entities.living.species.engineer.EntitySpaceJockey;
import org.avp.common.entities.living.species.species223ode.EntityDeacon;
import org.avp.common.entities.living.species.species223ode.EntityDeaconAdult;
import org.avp.common.entities.living.species.xenomorphs.EntityBatXeno;
import org.avp.common.entities.living.species.xenomorphs.EntityBoiler;
import org.avp.common.entities.living.species.xenomorphs.EntityChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityDracoburster;
import org.avp.common.entities.living.species.xenomorphs.EntityDracomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.common.entities.living.species.xenomorphs.EntityMyceliomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityNauticomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityPantheramorph;
import org.avp.common.entities.living.species.xenomorphs.EntityPredalien;
import org.avp.common.entities.living.species.xenomorphs.EntityPredalienChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityQueenChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerDrone;
import org.avp.common.entities.living.species.xenomorphs.EntitySpitter;
import org.avp.common.entities.living.species.xenomorphs.EntityUltramorph;
import org.avp.common.entities.living.species.yautja.EntityYautjaBerserker;
import org.avp.common.entities.living.species.yautja.EntityYautjaWarrior;
import org.avp.common.entities.living.vardic.EntityBelugaburster;
import org.avp.common.entities.living.vardic.EntityBelugamorph;
import org.avp.common.world.capabilities.IOrganism.Organism;

import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Embryo implements Cloneable
{
    public static final ArrayList<Embryo> registeredTypes = new ArrayList<Embryo>();
    private static int                    nextAvailableId = 1;

    public static final Embryo            STANDARD        = new Embryo(EntityChestburster.class, EntityDrone.class, EntityLiving.class).register();
    public static final Embryo            QUEEN           = new Embryo(EntityQueenChestburster.class, EntityMatriarch.class, EntityLiving.class).setGestationPeriod(10 * 60 * 20).register();
    public static final Embryo            BELUGA          = new Embryo(EntityBelugaburster.class, EntityBelugamorph.class, EntityLiving.class).register();
    public static final Embryo            DEACON          = new Embryo(EntityDeacon.class, EntityDeaconAdult.class, EntityLiving.class).register();

    static
    {
        new Embryo(EntityChestburster.class, EntityBoiler.class, EntityCreeper.class).register();
        new Embryo(EntityChestburster.class, EntitySpitter.class, EntityWitch.class, EntityLlama.class).register();
        new Embryo(EntityDracoburster.class, EntityDracomorph.class, EntityDragon.class).register();
        new Embryo(EntityChestburster.class, EntityMyceliomorph.class, EntityMooshroom.class).register();
        new Embryo(EntityChestburster.class, EntityPantheramorph.class, EntityOcelot.class).register();
        new Embryo(EntityChestburster.class, EntityBatXeno.class, EntityBat.class).register();
        new Embryo(EntityChestburster.class, EntityNauticomorph.class, EntitySquid.class, EntityGuardian.class, EntityElderGuardian.class).register();
        new Embryo(EntityPredalienChestburster.class, EntityPredalien.class, EntityYautjaWarrior.class, EntityYautjaBerserker.class).register();
        new Embryo(EntityRunnerChestburster.class, EntityRunnerDrone.class, EntityCow.class, EntityHorse.class, EntityWolf.class, EntityPolarBear.class, EntityPig.class, EntitySheep.class).register();
        new Embryo(EntityChestburster.class, EntityUltramorph.class, EntityEngineer.class, EntitySpaceJockey.class).register();
    }

    private int                         id;
    private int                         age;
    private int                         gestationPeriod;
    private Class<? extends INascentic> nascenticType;
    private Class<? extends Entity>     result;
    private Class<? extends Entity>[]   hosts;
    private INascentic                  nascenticOrganism;

    public Embryo(Class<?> nascenticType, Class<?> result, Class<?>... hosts)
    {
        this.nascenticType = (Class<? extends INascentic>) nascenticType;
        this.result = (Class<? extends Entity>) result;
        this.hosts = (Class<? extends Entity>[]) hosts;
        this.gestationPeriod = 6000;
    }

    /**
     * Embryo types MUST be registered. They will not sync to the client if they are not.
     * @return
     */
    public Embryo register()
    {
        this.id = nextAvailableId++;
        registeredTypes.add(this);
        return this;
    }

    public void grow(EntityLivingBase host, Organism hostOrganism)
    {
        this.age++;

        if (this.getNascenticOrganism() != null)
        {
            this.getNascenticOrganism().grow(host);
        }
    }

    /**
     * @return The id this embryo was registered with. Returns 0 if this embryo was not registered.
     */
    public int getRegistrationId()
    {
        return id;
    }

    public int getAge()
    {
        return this.age;
    }

    public boolean isPremature()
    {
        return this.getAge() < this.getGestationPeriod() - this.getGestationPeriod() / 8;
    }

    public int getGestationPeriod()
    {
        return this.gestationPeriod;
    }

    public Embryo setGestationPeriod(int gestationPeriod)
    {
        this.gestationPeriod = gestationPeriod;
        return this;
    }

    public Class<? extends Entity> getResultingOrganism()
    {
        return result;
    }

    public INascentic createNasenticOrganism(World world)
    {
        if (this.nascenticOrganism == null)
        {
            return this.nascenticOrganism = (INascentic) Entities.constructEntity(world, (Class<? extends Entity>) this.nascenticType);
        }

        return this.nascenticOrganism;
    }

    public INascentic getNascenticOrganism()
    {
        return nascenticOrganism;
    }

    public Class<?>[] getHosts()
    {
        return hosts;
    }

    public static void save(Embryo embryo, NBTTagCompound nbt)
    {
        if (embryo != null)
        {
            nbt.setInteger("EmbryoId", embryo.id);
            nbt.setInteger("Age", embryo.age);
        }
    }

    public static Embryo load(NBTTagCompound nbt)
    {
        int id = nbt.getInteger("EmbryoId");

        if (id != 0)
        {
            try
            {
                Embryo embryo = (Embryo) fromId(id).clone();
                embryo.age = nbt.getInteger("Age");

                return embryo;
            }
            catch (Exception e)
            {
                System.out.println("ERROR during embryo construction: " + e);
                System.out.println("ID: " + id);
            }
        }
        return null;
    }

    public Embryo createCopy()
    {
        return Embryo.createCopy(this);
    }

    public static Embryo createCopy(Embryo source)
    {
        try
        {
            return (Embryo) source.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static Embryo fromId(int id)
    {
        for (Embryo embryo : registeredTypes)
        {
            if (embryo.id == id)
            {
                return embryo.createCopy();
            }
        }

        return STANDARD.createCopy();
    }

    public static Embryo createFromHost(EntityLivingBase host)
    {
        for (Embryo embryo : registeredTypes)
        {
            for (Class c : embryo.hosts)
            {
                if (c == host.getClass())
                {
                    return embryo.createCopy();
                }
            }
        }

        return STANDARD.createCopy();
    }
}
