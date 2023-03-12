package org.avp.common.entities.living.species.xenomorphs;

import org.avp.common.ItemHandler;
import org.avp.common.entities.living.species.SpeciesXenomorph;
import org.avp.common.world.hives.rework.HiveMember;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPantheramorph extends SpeciesXenomorph implements HiveMember
{
    public EntityPantheramorph(World world)
    {
        super(world);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.Experimental.summonerPantheramorph);
    }
}
