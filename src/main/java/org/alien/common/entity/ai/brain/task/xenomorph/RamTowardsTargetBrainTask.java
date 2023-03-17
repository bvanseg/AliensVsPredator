package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.impl.task.AttackOnCollideBrainTask;

import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class RamTowardsTargetBrainTask extends AbstractEntityBrainTask {

	private static final int COOLDOWN_MAX = 20 * 8;

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
		map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
	}

	private boolean isRamming;
	private int cooldown;

	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		// If the entity is not on the ground, can't ram.
		if (!ctx.getEntity().onGround) {
			return false;
		}

		cooldown--;

		EntityLiving rammer = ctx.getEntity();
		Entity target = ctx.getEntity().getAttackTarget();

		if (target == null || target.isDead || cooldown > 20 * 3) {
			return false;
		}
		else {
			double d0 = rammer.getDistanceSq(target);
			return (!this.canReachTarget(ctx) || rammer.getRNG().nextInt(5) == 0) && d0 <= 150.0;
		}
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {

		EntityLiving rammer = ctx.getEntity();
		Entity target = rammer.getAttackTarget();
		double d0 = target.posX - rammer.posX;
		double d1 = target.posZ - rammer.posZ;
		float f = MathHelper.sqrt(d0 * d0 + d1 * d1);

		// Back up during the last 2 seconds.
		if (cooldown > 0 && cooldown < 20 * 2 && !this.canReachTarget(ctx)) {
			ctx.getBrain().getProfileTaskSets().get(ctx.getBrain().getActiveProfile())
					.forEach(task -> task.setDisabled(task instanceof AttackOnCollideBrainTask));
			rammer.motionX -= (d0 / f * 0.5 * 0.800000011920929 + rammer.motionX * 0.20000000298023224) * 0.5;
			rammer.motionZ -= (d1 / f * 0.5 * 0.800000011920929 + rammer.motionZ * 0.20000000298023224) * 0.5;
		}
		// Ram
		else if (cooldown <= 0) {
			if (f >= 1.0E-4) {
				double distanceModifier = 5.0;
				rammer.motionX += (d0 / f * 0.5 * 0.800000011920929 + rammer.motionX * 0.20000000298023224) * distanceModifier;
				rammer.motionZ += (d1 / f * 0.5 * 0.800000011920929 + rammer.motionZ * 0.20000000298023224) * distanceModifier;
				this.isRamming = true;
			}

			if (this.isRamming) {
				this.destroyBlocksInAABB(ctx);

				Optional<Entity> nearestOptional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
				if (nearestOptional.isPresent()) {
					Entity nearest = nearestOptional.get();

					// Hurt the nearest target found while ramming.
					if (nearest instanceof EntityLivingBase &&
							EntitySelectorXenomorph.instance.apply((EntityLivingBase) nearest) &&
							rammer.getDistanceSq(nearest) <= 2.0D
					) {
						nearest.attackEntityFrom(new EntityDamageSource("ram", rammer), 10.0F);
					}
				}
			}

			// This gives the crusher some extra time to ram through blocks and damage entities along the way.
			// The lower the threshold on the right is, the more destruction.
			if (this.cooldown < -1) {
				this.cooldown = COOLDOWN_MAX;
			}
		}
	}

	@Override
	public void finish(EntityBrainContext ctx) {
		super.finish(ctx);
		this.isRamming = false;
		// Allow crusher to attack on collide, again.
		ctx.getBrain().getProfileTaskSets().get(ctx.getBrain().getActiveProfile())
				.forEach(task -> task.setDisabled(false));
	}

	// This is a naive method to check if the crusher can reach the target.
	// It simply checks if the Crusher has a path to its target, and if it does, can the final path point fit the crusher.
	// If false, the crusher can try ramming to create space to reach the target.
	private boolean canReachTarget(EntityBrainContext ctx) {
		Path path = ctx.getEntity().getNavigator().getPath();
		if (path == null)
			return false;

		PathPoint finalPathPoint = path.getFinalPathPoint();

		if (finalPathPoint == null)
			return false;

		BlockPos finalBlockPos = new BlockPos(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z);
		return ctx.getEntity().world.getBlockState(finalBlockPos.up().up()) == Blocks.AIR.getDefaultState();
	}

	// Generously provided by the ender dragon code, tweaked to work with the crusher.
	private void destroyBlocksInAABB(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();
		AxisAlignedBB entityBoundingBox = entity.getEntityBoundingBox().grow(1.0, 0.5, 1.0);
		World world = entity.world;

		int i = MathHelper.floor(entityBoundingBox.minX);
		int j = MathHelper.ceil(entityBoundingBox.minY); // Ceil here to avoid breaking blocks below crusher.
		int k = MathHelper.floor(entityBoundingBox.minZ);
		int l = MathHelper.floor(entityBoundingBox.maxX);
		int i1 = MathHelper.floor(entityBoundingBox.maxY);
		int j1 = MathHelper.floor(entityBoundingBox.maxZ);

		for(int k1 = i; k1 <= l; ++k1) {
			for(int l1 = j; l1 <= i1; ++l1) {
				for(int i2 = k; i2 <= j1; ++i2) {
					BlockPos blockpos = new BlockPos(k1, l1, i2);
					IBlockState iblockstate = world.getBlockState(blockpos);
					Block block = iblockstate.getBlock();

					if (!block.isAir(iblockstate, world, blockpos) && iblockstate.getMaterial() != Material.FIRE) {
						if (block.blockHardness <= 25.0F) {
							if (block != Blocks.COMMAND_BLOCK &&
								block != Blocks.REPEATING_COMMAND_BLOCK &&
								block != Blocks.CHAIN_COMMAND_BLOCK &&
								block != Blocks.IRON_BARS &&
								block != Blocks.END_GATEWAY
							) {
								world.destroyBlock(blockpos, true);
							}
						}
					}
				}
			}
		}
	}
}
