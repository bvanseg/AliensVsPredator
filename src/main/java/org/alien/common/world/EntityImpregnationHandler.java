package org.alien.common.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.capability.OrganismImpl;

/**
 * @author Boston Vanseghi
 */
public abstract class EntityImpregnationHandler
{
    // These variables determine the beginning times of the stages of embryo development as percentages. The percentages
    // count down as they are multiplied with the gestationPeriod (so if age < gestationPeriod * 0.75, stage 1 will
    // begin once 25% of the gestation period has elapsed).
    protected static final double STAGE_ONE_PERCENTAGE = 0.75;
    protected static final double STAGE_TWO_PERCENTAGE = 0.5;
    protected static final double STAGE_THREE_PERCENTAGE = 0.25;
    protected static final double STAGE_FOUR_PERCENTAGE = 0.1;


    protected EntityImpregnationHandler() {}

    public abstract void tick(LivingUpdateEvent event);

    public boolean canTickHost(Entity entity) {
    	// If the entity is in an invalid state
    	if (entity == null || entity.isDead || entity.world == null || !(entity instanceof EntityLivingBase))
    		return false;

        OrganismImpl organism = (OrganismImpl) entity.getCapability(Provider.CAPABILITY, null);

        // If the organism does not have an embryo
        if (organism != null && !organism.hasEmbryo())
        	return false;

        // Ignore creative players.
        return !(entity instanceof EntityPlayer) || !((EntityPlayer) entity).isCreative();
    }
}
