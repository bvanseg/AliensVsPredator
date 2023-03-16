package org.alien.common.entity.living;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;

public class EntityDracoEgg extends EntityOvamorph
{
    public EntityDracoEgg(World world)
    {
        super(world);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_DRACO_EGG);
    }
}
