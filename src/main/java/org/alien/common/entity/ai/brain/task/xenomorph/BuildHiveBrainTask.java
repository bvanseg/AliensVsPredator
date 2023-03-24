package org.alien.common.entity.ai.brain.task.xenomorph;

import com.asx.mdx.common.minecraft.Pos;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.Path;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.alien.common.AlienBlocks;
import org.alien.common.entity.living.xenomorph.EntityDrone;
import org.avp.common.block.BlockHiveResin;
import org.avp.common.tile.TileEntityHiveResin;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class BuildHiveBrainTask extends AbstractEntityBrainTask {

	private static final HashSet<Block> BLOCK_DENYLIST = new HashSet<>();

	static {
		BLOCK_DENYLIST.add(Blocks.BEDROCK);
		BLOCK_DENYLIST.add(Blocks.AIR);
		BLOCK_DENYLIST.add(AlienBlocks.RESIN);
		BLOCK_DENYLIST.add(AlienBlocks.NATURAL_RESIN);
	}

	private ArrayList<BlockPos> positionsOfInterest = new ArrayList<>();

	private BlockPos targetPos;

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityDrone)) return false;

		EntityDrone droneEntity = (EntityDrone) entity;

		if (droneEntity.getAlienHive() == null) return false;
		if (droneEntity.world.getTotalWorldTime() % 10 != 0) return false;
		if (droneEntity.getRNG().nextInt(3) != 0) return false;
		if (droneEntity.getJellyLevel() < 16) return false;

		return true;
	}
	
    @Override
	protected void startExecuting() {
		EntityDrone entity = (EntityDrone) ctx.getEntity();
		this.targetPos = findNextSuitableResinLocation(entity, 3);

		if (targetPos == null) return;

		Path path = entity.getNavigator().getPathToXYZ(targetPos.getX(), targetPos.getY(), targetPos.getZ());

		if (path == null) return;

		entity.getNavigator().setPath(path, 0.8D);
	}

	@Override
	protected boolean shouldContinueExecuting() {
		if (this.targetPos == null) return false;
		if (ctx.getEntity().getNavigator().noPath()) return false;
		if (((EntityDrone)ctx.getEntity()).getAlienHive() == null) return false;

		return true;
	}

	@Override
	protected void continueExecuting() {
		EntityDrone entity = (EntityDrone) ctx.getEntity();
		IBlockState state = entity.world.getBlockState(this.targetPos);

		double distance = entity.getDistanceSq(this.targetPos);

		if (!this.canReplaceWithResin(state)) {
			this.targetPos = null;
			return;
		}

		if (distance <= 2)
		{
			entity.world.setBlockState(this.targetPos, AlienBlocks.NATURAL_RESIN.getDefaultState());
			((BlockHiveResin) AlienBlocks.NATURAL_RESIN).evaluateNeighbors(entity.world, this.targetPos);

			TileEntity tileEntity = entity.world.getTileEntity(this.targetPos);

			if (tileEntity == null || !(tileEntity instanceof TileEntityHiveResin)) return;

			TileEntityHiveResin resin = (TileEntityHiveResin) tileEntity;

			resin.setParentBlock(state.getBlock(), 0);
			entity.world.notifyBlockUpdate(this.targetPos, state, state, 3);
			entity.getAlienHive().addResin(this.targetPos);

			entity.setJellyLevel(entity.getJellyLevel() - 16);
			this.targetPos = null;
		}
	}

	private BlockPos findNextSuitableResinLocation(EntityLiving entity, int radius)
	{
		// Read a random block pos from cache.
		if (!positionsOfInterest.isEmpty()) {
			int randomIndex = entity.getRNG().nextInt(positionsOfInterest.size());
			return positionsOfInterest.remove(randomIndex);
		}

		World world = entity.world;
		double posX = entity.posX;
		double posY = entity.posY;
		double posZ = entity.posZ;

		ArrayList<BlockPos> data = new ArrayList<>();

		for (int x = (int) (posX - radius); x < posX + (radius); x++)
		{
			for (int y = (int) (posY - radius); y < posY + (radius); y++)
			{
				for (int z = (int) (posZ - radius); z < posZ + (radius); z++)
				{
					BlockPos location = new BlockPos(x, y, z);
					IBlockState blockState = world.getBlockState(location);

					if (this.canPlaceResinAt(entity, location, blockState)) {
						data.add(location);
					}
				}
			}
		}

		// Cache data.
		positionsOfInterest = data;

		// Return block from cache, if possible.
		if (!positionsOfInterest.isEmpty()) {
			int randomIndex = entity.getRNG().nextInt(positionsOfInterest.size());
			return positionsOfInterest.remove(randomIndex);
		}

		// Otherwise just return null, no pos found or cached.
		return null;
	}

	private boolean canPlaceResinAt(EntityLiving entity, BlockPos location, IBlockState blockState) {
		if (!this.canReplaceWithResin(blockState)) return false;

		Vec3d start = new Vec3d(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ);
		Vec3d end = new Vec3d(location.getX(), location.getY(), location.getZ());
		RayTraceResult hit =  entity.world.rayTraceBlocks(start, end, false, true, false);

		if (hit != null && hit.typeOfHit != RayTraceResult.Type.BLOCK) return false;
		if (!Pos.isAnySurfaceEmpty(location, entity.world)) return false;

		return true;
	}

	private boolean canReplaceWithResin(IBlockState blockState) {
		return (!BLOCK_DENYLIST.contains(blockState.getBlock()) && blockState.isOpaqueCube());
	}
}
