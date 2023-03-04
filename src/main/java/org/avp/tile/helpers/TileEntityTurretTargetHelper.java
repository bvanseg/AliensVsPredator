package org.avp.tile.helpers;

import java.util.HashSet;

import org.avp.entities.living.EntityAethon;
import org.avp.entities.living.species.engineer.EntityEngineer;
import org.avp.entities.living.species.engineer.EntitySpaceJockey;
import org.avp.entities.living.species.species223ode.EntityDeacon;
import org.avp.entities.living.species.species223ode.EntityTrilobite;
import org.avp.entities.living.species.xenomorphs.EntityChestburster;
import org.avp.entities.living.species.xenomorphs.EntityCrusher;
import org.avp.entities.living.species.xenomorphs.EntityDrone;
import org.avp.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.entities.living.species.xenomorphs.EntityNauticomorph;
import org.avp.entities.living.species.xenomorphs.EntityOvamorph;
import org.avp.entities.living.species.xenomorphs.EntityPraetorian;
import org.avp.entities.living.species.xenomorphs.EntityPredalien;
import org.avp.entities.living.species.xenomorphs.EntityPredalienChestburster;
import org.avp.entities.living.species.xenomorphs.EntityQueenChestburster;
import org.avp.entities.living.species.xenomorphs.EntityRunnerChestburster;
import org.avp.entities.living.species.xenomorphs.EntityRunnerDrone;
import org.avp.entities.living.species.xenomorphs.EntityRunnerWarrior;
import org.avp.entities.living.species.xenomorphs.EntitySpitter;
import org.avp.entities.living.species.xenomorphs.EntityUltramorph;
import org.avp.entities.living.species.xenomorphs.EntityWarrior;
import org.avp.entities.living.species.xenomorphs.parasites.EntityFacehugger;
import org.avp.entities.living.species.xenomorphs.parasites.EntityRoyalFacehugger;
import org.avp.entities.living.vardic.EntityBelugaburster;
import org.avp.entities.living.vardic.EntityBelugamorph;
import org.avp.entities.living.vardic.EntityDeaconShark;
import org.avp.entities.living.vardic.EntityGooMutant;
import org.avp.entities.living.vardic.EntityHammerpede;
import org.avp.entities.living.vardic.EntityOctohugger;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * 
 * @author Ri5ux
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretTargetHelper {
	
	private static int TURRET_RANGE = 24;

	private Entity targetEntity;
	private HashSet<Class<? extends Entity>> targetTypes;
	private HashSet<String> targetPlayers;

	public TileEntityTurretTargetHelper() {
		this.targetEntity = null;
		this.targetTypes = new HashSet<>();
		this.targetPlayers = new HashSet<>();
	}
	
	public void update(World world, Pos pos, TileEntityTurretLookHelper lookHelper) {
		if (!doesCurrentTargetStillExist() || !canClearlyAttackCurrentTarget(pos)) {
			this.targetEntity = null;
			lookHelper.setLockedOn(false);
		}

		if (this.targetEntity == null) {
			this.findTarget(world, pos);
		}
	}
	
	public boolean doesCurrentTargetStillExist() {
		return this.targetEntity != null && !this.targetEntity.isDead;
	}
	
	private boolean canClearlyAttackCurrentTarget(Pos pos) {
		return this.canTarget(this.targetEntity, pos) && this.canSee(this.targetEntity, pos);
	}

	public void findTarget(World world, Pos pos) {
		if (!world.isRemote) {
			EntityLiving newTarget = (EntityLiving) Entities.getRandomEntityInCoordsRange(world, EntityLiving.class, pos, TURRET_RANGE, TURRET_RANGE);

			if (newTarget != null && this.targetTypes.contains(newTarget.getClass()) && this.canTarget(newTarget, pos) && canSee(newTarget, pos)) {
				this.targetEntity = newTarget;
			}
		}
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
		// TODO: Store UUIDs, not names to avoid casing discrepancies.
		return this.targetPlayers.contains(player.getCommandSenderEntity().getName());
	}

	public void addTargetPlayer(String name) {
		this.targetPlayers.add(name);
	}

	public void removeTargetPlayer(String name) {
		this.targetPlayers.remove(name);

		// TODO: Do not use the player name here, check against their UUID, instead.
		if (this.targetEntity instanceof EntityPlayer && this.targetEntity.getName().equalsIgnoreCase(name)) {
			this.targetEntity = null;
		}
	}

	public void removeTargetType(Class<? extends Entity> entityClass) {
		this.setTargetEntity(null);
		this.targetTypes.remove(entityClass);
	}

	public void addTargetType(Class<? extends Entity> entityClass) {
		this.setTargetEntity(null);
		this.targetTypes.add(entityClass);
	}

	public boolean canTargetType(Class<? extends Entity> entityClass) {
		return this.targetTypes.contains(entityClass);
	}

	public HashSet<String> getTargetPlayers() {
		return targetPlayers;
	}

	public Entity getTargetEntity() {
		return targetEntity;
	}

	public void setTargetEntity(Entity targetEntity) {
		this.targetEntity = targetEntity;
	}

	public HashSet<Class<? extends Entity>> getDangerousTargets() {
		return targetTypes;
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
}
