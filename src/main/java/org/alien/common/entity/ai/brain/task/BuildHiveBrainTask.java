package org.alien.common.entity.ai.brain.task;

import com.asx.mdx.lib.world.Pos;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
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
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class BuildHiveBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();

	private static final HashSet<Block> BLOCK_DENYLIST = new HashSet<>();

	static {
		BLOCK_DENYLIST.add(Blocks.BEDROCK);
		BLOCK_DENYLIST.add(Blocks.AIR);
		BLOCK_DENYLIST.add(AlienBlocks.RESIN);
		BLOCK_DENYLIST.add(AlienBlocks.NATURAL_RESIN);
	}
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}

	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		if(!(entity instanceof EntityDrone)) return false;

		EntityDrone droneEntity = (EntityDrone) entity;

		if (droneEntity.targetOvamorph != null) return false;
		if (droneEntity.getAlienHive() == null) return false;
		if (droneEntity.world.getTotalWorldTime() % 10 != 0) return false;
		if (droneEntity.getRNG().nextInt(3) != 0) return false;
		if (droneEntity.getJellyLevel() < 16) return false;

		return true;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityDrone entity = (EntityDrone) ctx.getEntity();

		BlockPos pos = findNextSuitableResinLocation(entity, 3);

		if (pos == null) return;

		IBlockState state = entity.world.getBlockState(pos);
		Path path = entity.getNavigator().getPathToXYZ(pos.getX(), pos.getY(), pos.getZ());

		if (path == null) return;

		entity.getNavigator().setPath(path, 0.8D);
		entity.world.setBlockState(pos, AlienBlocks.NATURAL_RESIN.getDefaultState());
		((BlockHiveResin) AlienBlocks.NATURAL_RESIN).evaluateNeighbors(entity.world, pos);

		TileEntity tileEntity = entity.world.getTileEntity(pos);

		if (tileEntity == null || !(tileEntity instanceof  TileEntityHiveResin)) return;

		TileEntityHiveResin resin = (TileEntityHiveResin) tileEntity;

		resin.setParentBlock(state.getBlock(), 0);
		entity.world.notifyBlockUpdate(pos, state, state, 3);
		entity.getAlienHive().addResin(pos);

		entity.setJellyLevel(entity.getJellyLevel() - 16);
	}

	private BlockPos findNextSuitableResinLocation(Entity entity, int range)
	{
		World world = entity.world;
		double posX = entity.posX;
		double posY = entity.posY;
		double posZ = entity.posZ;

		ArrayList<BlockPos> data = new ArrayList<>();

		for (int x = (int) (posX - range); x < posX + (range); x++)
		{
			for (int y = (int) (posY - range); y < posY + (range); y++)
			{
				for (int z = (int) (posZ - range); z < posZ + (range); z++)
				{
					BlockPos location = new BlockPos(x, y, z);
					IBlockState blockState = world.getBlockState(location);

					if (this.canReplaceWithResin(blockState))
					{
						Vec3d start = new Vec3d(posX, posY + entity.getEyeHeight(), posZ);
						Vec3d end = new Vec3d(x, y, z);
						RayTraceResult hit =  entity.world.rayTraceBlocks(start, end, false, true, false);

						if (hit == null || hit.typeOfHit == RayTraceResult.Type.BLOCK)
						{
							if (Pos.isAnySurfaceEmpty(location, entity.world))
							{
								data.add(location);
							}
						}
					}
				}
			}
		}

		return !data.isEmpty() ? data.get(entity.world.rand.nextInt(data.size())) : null;
	}

	protected boolean canReplaceWithResin(IBlockState blockState) {
		return (!BLOCK_DENYLIST.contains(blockState.getBlock()) && blockState.isOpaqueCube());
	}
}
