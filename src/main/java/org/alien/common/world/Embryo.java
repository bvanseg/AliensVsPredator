package org.alien.common.world;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.alien.common.api.emybro.EmbryoEntries;
import org.alien.common.api.emybro.EmbryoEntry;
import org.alien.common.api.emybro.EmbryoKey;
import org.alien.common.api.emybro.EmbryoRegistry;
import org.alien.common.world.capability.Organism;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.common.AVPDamageSources;
import org.lib.common.FuncUtil;

/**
 * @author Ri5ux
 */
public class Embryo {
    private final EmbryoEntry embryoEntry;
    private final EmbryoKey embryoKey;
    private int age;

    public Embryo(EmbryoEntry embryoEntry, EmbryoKey embryoKey) {
        this.embryoEntry = embryoEntry;
        this.embryoKey = embryoKey;
        this.age = 0;
    }

    public void grow() {
        this.age++;
    }

    public int getAge() {
        return this.age;
    }

    public EmbryoEntry getEntry() {
        return this.embryoEntry;
    }

    public EmbryoKey getEmbryoKey() {
        return this.embryoKey;
    }

    public Class<? extends Entity> getBirthCreature() {
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
        return this.embryoEntry.getGestationPeriod();
    }

    private static final String PLAYER_HOST_ID = "player";
    private static final String AGE_NBT_KEY = "Age";
    private static final String IMPREGNATOR_ID_NBT_KEY = "ImpregnatorId";
    private static final String HOST_ID_NBT_KEY = "HostId";

    public static void save(Embryo embryo, NBTTagCompound nbt) {
        if (embryo != null) {
            Class<? extends Entity> impregnatorClass = embryo.getEmbryoKey().getParasiteClass();
            Class<? extends Entity> hostClass = embryo.getEmbryoKey().getHostClass();

            EntityEntry impregnatorEntityEntry = EntityRegistry.getEntry(impregnatorClass);
            String impregnatorRegistryName = FuncUtil.let(FuncUtil.let(impregnatorEntityEntry, EntityEntry::getRegistryName), ResourceLocation::toString);
            if (impregnatorRegistryName != null) {
                nbt.setString(IMPREGNATOR_ID_NBT_KEY, impregnatorRegistryName);
            }

            if (EntityPlayer.class.isAssignableFrom(hostClass)) // Handle players
            {
                nbt.setString(HOST_ID_NBT_KEY, PLAYER_HOST_ID);
            }
            else // Handle non-players
            {
                EntityEntry hostEntityEntry = EntityRegistry.getEntry(hostClass);
                String hostRegistryName = FuncUtil.let(FuncUtil.let(hostEntityEntry, EntityEntry::getRegistryName), ResourceLocation::toString);
                if (hostRegistryName != null) {
                    nbt.setString(HOST_ID_NBT_KEY, hostRegistryName);
                }
            }

            nbt.setInteger(AGE_NBT_KEY, embryo.age);
        }
    }

    public static Embryo load(NBTTagCompound nbt) {
        String impregnatorId = nbt.getString(IMPREGNATOR_ID_NBT_KEY);
        String hostId = nbt.getString(HOST_ID_NBT_KEY);

        // To load the entry, we need to reconstruct the embryo entry from both the host and the stored parasite registry name.
        // Because embryo entries are now configurable, the old integer id system would break easily since the order for which
        // the embryo entries were loaded was not guaranteed, therefore not guaranteeing the integer id being set.
        // By using string ids of the parasite and host, we can avoid integer id issues altogether and keep the embryo loading
        // stable so long as the original entity registry names do not change.
        if (!impregnatorId.isEmpty()) {
            EntityEntry impregnatorEntry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(impregnatorId));
            EntityEntry hostEntry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(hostId));

            if (impregnatorEntry == null) return null;

            Embryo embryo;

            // Special case handling for players, as player entities are not registered along with normal entities.
            if (hostId.equalsIgnoreCase(PLAYER_HOST_ID))
            {
                embryo = EmbryoEntries.DRONE.create(new EmbryoKey(impregnatorEntry.getEntityClass(), EntityPlayer.class));
            } else {
                if (hostEntry == null) return null;

                EmbryoKey key = new EmbryoKey(impregnatorEntry.getEntityClass(), hostEntry.getEntityClass());
                EmbryoEntry embryoEntry = EmbryoRegistry.getEntry(key);
                embryo = embryoEntry.create(key);
            }

            embryo.age = nbt.getInteger(AGE_NBT_KEY);

            return embryo;
        }

        return null;
    }
}
