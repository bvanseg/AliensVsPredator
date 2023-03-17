package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class RamTowardsTargetBrainTask extends AbstractEntityBrainTask {

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

		EntityLiving leaper = ctx.getEntity();
		Entity leapTarget = ctx.getEntity().getAttackTarget();

		if (leapTarget == null || leapTarget.isDead || cooldown > 0) {
			return false;
		}
		else {
			double d0 = leaper.getDistanceSq(leapTarget);
			return d0 <= 49.0;
		}
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		EntityLiving leaper = ctx.getEntity();
		Entity leapTarget = ctx.getEntity().getAttackTarget();
		double d0 = leapTarget.posX - leaper.posX;
		double d1 = leapTarget.posZ - leaper.posZ;
		float f = MathHelper.sqrt(d0 * d0 + d1 * d1);

		if (f >= 1.0E-4) {
			double distanceModifier = 5.0;
			leaper.motionX += (d0 / f * 0.5 * 0.800000011920929 + leaper.motionX * 0.20000000298023224) * distanceModifier;
			leaper.motionZ += (d1 / f * 0.5 * 0.800000011920929 + leaper.motionZ * 0.20000000298023224) * distanceModifier;
			this.isRamming = true;
			this.cooldown = 20 * 10;
		}

		if (this.isRamming) {
			this.destroyBlocksInAABB(ctx);
		}

		// TODO: Disable attack on collide ai, back the crusher up a bit, launch forward, and then re-enable attack-on-collide ai.
	}

	@Override
	public void finish(EntityBrainContext ctx) {
		super.finish(ctx);
		this.isRamming = false;
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
