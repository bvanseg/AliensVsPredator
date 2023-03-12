package org.predator.common.entity.living.yautja;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.ItemHandler;
import org.predator.common.entity.living.SpeciesYautja;

public class EntityYautjaWarrior extends SpeciesYautja
{
    public EntityYautjaWarrior(World world)
    {
        super(world);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerYautjaWarrior);
    }
}
