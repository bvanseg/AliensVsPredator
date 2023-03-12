package org.avp.common.tile.helpers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.avp.AliensVsPredator;
import org.avp.common.entities.living.EntityAethon;
import org.avp.common.entities.living.species.engineer.EntityEngineer;
import org.avp.common.entities.living.species.engineer.EntitySpaceJockey;
import org.avp.common.entities.living.species.species223ode.EntityDeacon;
import org.avp.common.entities.living.species.species223ode.EntityTrilobite;
import org.avp.common.entities.living.species.xenomorphs.EntityChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityCrusher;
import org.avp.common.entities.living.species.xenomorphs.EntityDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.common.entities.living.species.xenomorphs.EntityNauticomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityOvamorph;
import org.avp.common.entities.living.species.xenomorphs.EntityPraetorian;
import org.avp.common.entities.living.species.xenomorphs.EntityPredalien;
import org.avp.common.entities.living.species.xenomorphs.EntityPredalienChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityQueenChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerWarrior;
import org.avp.common.entities.living.species.xenomorphs.EntitySpitter;
import org.avp.common.entities.living.species.xenomorphs.EntityUltramorph;
import org.avp.common.entities.living.species.xenomorphs.EntityWarrior;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityFacehugger;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityRoyalFacehugger;
import org.avp.common.entities.living.vardic.EntityBelugaburster;
import org.avp.common.entities.living.vardic.EntityBelugamorph;
import org.avp.common.entities.living.vardic.EntityDeaconShark;
import org.avp.common.entities.living.vardic.EntityGooMutant;
import org.avp.common.entities.living.vardic.EntityHammerpede;
import org.avp.common.entities.living.vardic.EntityOctohugger;
import org.avp.common.packets.server.PacketTurretTargetUpdate;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.storage.NBTStorage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author Ri5ux
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretTargetHelper {
	
	private static final int TURRET_RANGE = 24;

	private Entity targetEntity;
	private int targetEntityId;
	private final HashSet<Class<? extends Entity>> targetTypes;
	private final HashSet<UUID> targetPlayers;
	private Pos pos;

	public TileEntityTurretTargetHelper() {
		this.targetEntity = null;
		this.targetTypes = new HashSet<>();
		this.targetPlayers = new HashSet<>();
	}
	
	public void update(World world, Pos pos, TileEntityTurretLookHelper lookHelper) {
		if (this.pos == null) {
			this.pos = pos;
		}
		
		// Because the server is always prepared ahead of the client, there is a slight chance that
		// the target entity packet may be sent out before the client is ready. In that edge case, the client
		// will not receive the target update, and the turret will not rotate accordingly, but will still fire according
		// to the server. To work around this desync, there are two options: 1) network the target to the client every tick,
		// 2) cheat and use the fact that NBT is guaranteed to be serialized and sent to the client on load. This is option 2.
		if (world.isRemote && this.targetEntity == null && this.targetEntityId != Integer.MIN_VALUE) {
			Entity entity = world.getEntityByID(targetEntityId);
			this.targetEntity = entity;
		}

		if (!doesCurrentTargetStillExist() || !canClearlyAttackCurrentTarget(pos)) {
			lookHelper.setLockedOn(false);
			this.setAndUpdateTargetEntity(world, null);
		}

		if (this.targetEntity == null) {
			this.findTarget(world, pos);
		}
		
		if (!this.canContinueAttackingTarget(this.targetEntity, pos)) {
			this.setAndUpdateTargetEntity(world, null);
		}
	}
	
	public boolean doesCurrentTargetStillExist() {
		return this.targetEntity != null && !this.targetEntity.isDead;
	}
	
	private boolean canClearlyAttackCurrentTarget(Pos pos) {
		return this.canTarget(this.targetEntity, pos) && this.canSee(this.targetEntity, pos);
	}

	public void findTarget(World world, Pos pos) {
		List<EntityLivingBase> nearbyLivingEntities = Entities.getEntitiesInCoordsRange(world, EntityLivingBase.class, pos, TURRET_RANGE, TURRET_RANGE);
		nearbyLivingEntities.sort(Comparator.comparingInt(e -> (int) e.getDistanceSq(pos.blockPos())));
		
		List<EntityLivingBase> potentialTargets = nearbyLivingEntities.stream()
				.filter(newTarget -> this.canContinueAttackingTarget(newTarget, pos)).collect(Collectors.toList());
		
		this.setAndUpdateTargetEntity(world, !potentialTargets.isEmpty() ? potentialTargets.get(0) : null);
	}
	
	private boolean canContinueAttackingTarget(Entity target, Pos pos) {
		if (target == null) return false;

		boolean mobCheck = this.targetTypes.contains(target.getClass()) && this.canTarget(target, pos) && canSee(target, pos);
		boolean playerCheck = target instanceof EntityPlayer && canTargetPlayer((EntityPlayer) target);
		
		if (mobCheck || playerCheck) {
			return true;
		}
		
		return false;
	}

	boolean canSee(Entity entity, Pos pos) {
		World world = entity.world;
		double height = entity.getEntityBoundingBox().maxY - entity.getEntityBoundingBox().minY;
		double halfHeight = height / 2;

		Vec3d mid = new Vec3d(entity.posX, entity.getEntityBoundingBox().maxY - (halfHeight), entity.posZ);
		Vec3d top = new Vec3d(entity.posX, entity.getEntityBoundingBox().maxY - (halfHeight + halfHeight), entity.posZ);
		Vec3d bot = new Vec3d(entity.posX, entity.getEntityBoundingBox().maxY - (halfHeight - halfHeight), entity.posZ);
		Vec3d offset = new Vec3d(pos.x, pos.y, pos.z).add(0.5, 1, 0.5);
		RayTraceResult midResult = world.rayTraceBlocks(mid, offset, false, true, false);
		RayTraceResult topResult = world.rayTraceBlocks(top, offset, false, true, false);
		RayTraceResult botResult = world.rayTraceBlocks(bot, offset, false, true, false);

		if (midResult == null || topResult == null || botResult == null) {
			return true;
		}

		return false;
	}

	private boolean canTarget(Entity entity, Pos pos) {
		if (entity != null && !entity.isDead) {
			double distance = Pos.distance(pos.x, pos.y, pos.z, entity.posX, entity.posY, entity.posZ);
			boolean playerCheck = entity instanceof EntityPlayer && this.canTargetPlayer((EntityPlayer) entity);
			return playerCheck || this.canTargetType(entity.getClass()) && distance <= TURRET_RANGE;
		}

		return false;
	}
	
	public int getRange() {
		return TURRET_RANGE;
	}

	private boolean canTargetPlayer(EntityPlayer player) {
		return this.targetPlayers.contains(player.getPersistentID()) && !player.isCreative() && !player.isSpectator();
	}

	public boolean addTargetPlayer(UUID playerUUID) {
		return this.targetPlayers.add(playerUUID);
	}

	public boolean  removeTargetPlayer(UUID playerUUID) {
		return this.targetPlayers.remove(playerUUID);
	}

	public void removeTargetType(Class<? extends Entity> entityClass) {
		this.targetTypes.remove(entityClass);
	}

	public void addTargetType(Class<? extends Entity> entityClass) {
		this.targetTypes.add(entityClass);
	}

	public boolean canTargetType(Class<? extends Entity> entityClass) {
		return this.targetTypes.contains(entityClass);
	}

	public HashSet<UUID> getTargetPlayers() {
		return targetPlayers;
	}

	public Entity getTargetEntity() {
		return targetEntity;
	}

	// A packet is taken as a parameter here to help enforce this method being called only client-side.
	@SideOnly(Side.CLIENT)
	public void setTargetEntity(PacketTurretTargetUpdate packet) {
        Entity entity = Game.minecraft().world.getEntityByID(packet.id);
		this.targetEntity = entity;
	}
	
	// Turret targets should only be set server-side.
	public void setAndUpdateTargetEntity(World world, Entity targetEntity) {
		if (world.isRemote) {
			// TODO: Warning log.
			return;
		}
		
		if (this.targetEntity != targetEntity && this.pos != null) {
			int entityId = targetEntity != null ? targetEntity.getEntityId() : Integer.MIN_VALUE;
            AliensVsPredator.network().sendToAll(new PacketTurretTargetUpdate(pos.blockPos(), entityId));
    		this.targetEntity = targetEntity;
			this.targetEntityId = entityId;
		}
	}

	public HashSet<Class<? extends Entity>> getDangerousTargets() {
		return this.targetTypes;
	}

	// TODO: Figure out what this was meant for.
	private void setPredefinedTargets() {
		this.addTargetType(EntityPlayer.class);
		this.addTargetType(EntityOvamorph.class);
		this.addTargetType(EntityFacehugger.class);
		this.addTargetType(EntityChestburster.class);
		this.addTargetType(EntityDrone.class);
		this.addTargetType(EntityWarrior.class);
		this.addTargetType(EntityPraetorian.class);
		this.addTargetType(EntityMatriarch.class);
		this.addTargetType(EntityCrusher.class);
		this.addTargetType(EntitySpitter.class);
		this.addTargetType(EntityNauticomorph.class);
		this.addTargetType(EntityPredalien.class);
		this.addTargetType(EntitySlime.class);
		this.addTargetType(EntityNauticomorph.class);
		this.addTargetType(EntityRunnerWarrior.class);
		this.addTargetType(EntityRunnerDrone.class);
		this.addTargetType(EntityDeacon.class);
		this.addTargetType(EntityUltramorph.class);
		this.addTargetType(EntityRunnerChestburster.class);
		this.addTargetType(EntityPredalienChestburster.class);
		this.addTargetType(EntityQueenChestburster.class);
		this.addTargetType(EntityBelugaburster.class);
		this.addTargetType(EntityHammerpede.class);
		this.addTargetType(EntityOvamorph.class);
		this.addTargetType(EntityDeaconShark.class);
		this.addTargetType(EntityOctohugger.class);
		this.addTargetType(EntityRoyalFacehugger.class);
		this.addTargetType(EntityTrilobite.class);
		this.addTargetType(EntityPredalien.class);
		this.addTargetType(EntitySpaceJockey.class);
		this.addTargetType(EntityEngineer.class);
		this.addTargetType(EntityBelugamorph.class);
		this.addTargetType(EntityGooMutant.class);
		this.addTargetType(EntityAethon.class);
	}
	
    public void readFromNBT(NBTTagCompound nbt)
    {
		this.targetEntityId = nbt.getInteger("CurrentTargetId");
        this.readTargetListFromCompoundTag(nbt);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
    	nbt.setInteger("CurrentTargetId", this.targetEntity != null ? this.targetEntity.getEntityId() : Integer.MIN_VALUE);
    	nbt.setTag("Targets", this.getTargetListTag());
        return nbt;
    }

    public NBTTagList getTargetListTag()
    {
        ArrayList<String> entityIDs = new ArrayList<>();

        for (Class<? extends Entity> c : this.getDangerousTargets())
        {
            entityIDs.add(Entities.getEntityRegistrationId(c));
        }

        return NBTStorage.newStringNBTList(entityIDs);
    }

    public void readTargetListFromCompoundTag(NBTTagCompound nbt)
    {
        NBTTagList list = nbt.getTagList("Targets", NBT.TAG_STRING);
        this.readTargetList(list);
    }

    public void readTargetList(NBTTagList list)
    {
        for (int i = 0; i < list.tagCount(); i++)
        {
            String id = list.getStringTagAt(i);

            ResourceLocation identifier = new ResourceLocation(id);
            EntityEntry entityEntry = ForgeRegistries.ENTITIES.getValue(identifier);
            Class<? extends Entity> entityClass = entityEntry.getEntityClass();
            this.addTargetType(entityClass);
        }
    }
}
