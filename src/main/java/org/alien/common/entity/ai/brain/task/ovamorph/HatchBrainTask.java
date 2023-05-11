package org.alien.common.entity.ai.brain.task.ovamorph;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.alien.common.entity.ai.helper.LeapHelper;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.alien.common.entity.living.xenomorph.burster.EntityQueenChestburster;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
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
	protected boolean shouldExecute() {
		if (!(ctx.getEntity() instanceof EntityOvamorph))
			return false;

		EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
		// Egg must have a facehugger and must be fully open to hatch.
		return ovamorph.containsFacehugger() && ovamorph.openProgress.get() >= EntityOvamorph.MAX_OPEN_PROGRESS;
	}
	
    @Override
	protected void startExecuting() {
		this.hatch((EntityOvamorph) ctx.getEntity());
	}

	private void hatch(EntityOvamorph ovamorph)
	{
		World world = ovamorph.world;

		Pos pos = new Pos(ovamorph).findSafePosAround(world);
		EntityFacehugger facehugger  = trySetRoyalFacehugger(ovamorph, pos);

		EntityLivingBase target = ovamorph.getAttackTarget();

		float yaw = 0;
		float pitch = 0;

		// Orient the facehugger towards the ovamorph's target.
		if (target != null) {
			double d0 = target.posX - ovamorph.posX;
			double d1 = target.posY - (ovamorph.posY + ovamorph.getEyeHeight());
			double d2 = target.posZ - ovamorph.posZ;
			double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
			yaw = (float)(MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
			pitch = (float)(-(MathHelper.atan2(d1, d3) * (180D / Math.PI)));
		}

		facehugger.setLocationAndAngles(pos.x, pos.y, pos.z, yaw, pitch);
		world.spawnEntity(facehugger);

		// Adjust the facehugger's initial motion after spawning.
		if (target != null) {
			LeapHelper.leapAtTarget(facehugger, target);
		}

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
