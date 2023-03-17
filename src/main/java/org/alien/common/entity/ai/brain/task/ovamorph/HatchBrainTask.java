package org.alien.common.entity.ai.brain.task.ovamorph;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.world.World;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.EntityQueenChestburster;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class HatchBrainTask extends AbstractBrainTask<EntityBrainContext> {

	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (!(ctx.getEntity() instanceof EntityOvamorph))
			return false;

		EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
		// Egg must have a facehugger and must be fully open to hatch.
		return ovamorph.containsFacehugger() && ovamorph.getOpenProgress() >= EntityOvamorph.MAX_OPEN_PROGRESS;
	}
	
    @Override
	protected void startExecuting(EntityBrainContext ctx) {
		this.hatch((EntityOvamorph) ctx.getEntity());
	}

	private void hatch(EntityOvamorph ovamorph)
	{
		World world = ovamorph.world;

		Pos pos = new Pos(ovamorph).findSafePosAround(world);
		EntityFacehugger facehugger  = trySetRoyalFacehugger(ovamorph, pos);

		facehugger.setLocationAndAngles(pos.x, pos.y, pos.z, 0F, 0F);
		world.spawnEntity(facehugger);
		facehugger.motionY = 0.75F;
		ovamorph.setContainsFacehugger(false);
	}

	private EntityFacehugger trySetRoyalFacehugger(EntityOvamorph ovamorph, Pos pos) {
		EntityFacehugger facehugger =  null;
		World world = ovamorph.world;

		// TODO: Access hive members directly and make these checks.
		if (Entities.getEntitiesInCoordsRange(world, EntityMatriarch.class, pos, 50, 50).isEmpty() &&
				Entities.getEntitiesInCoordsRange(world, EntityRoyalFacehugger.class, pos, 50, 50).isEmpty() &&
				Entities.getEntitiesInCoordsRange(world, EntityQueenChestburster.class, pos, 50, 50).isEmpty())
		{
			if (ovamorph.getRNG().nextInt(3) == 0)
			{
				facehugger = new EntityRoyalFacehugger(world);
			}
		}

		if (facehugger == null) {
			facehugger = new EntityFacehugger(world);
		}

		return facehugger;
	}
}
