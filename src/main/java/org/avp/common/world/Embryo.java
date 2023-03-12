package org.avp.common.world;

import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.vardic.EntityBelugaburster;
import org.alien.common.entity.living.vardic.EntityBelugamorph;
import org.alien.common.entity.living.xenomorphs.*;
import org.avp.common.api.parasitoidic.INascentic;
import org.avp.common.world.capabilities.IOrganism.Organism;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.util.ArrayList;

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
