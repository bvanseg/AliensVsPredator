package org.predator.common.entity.living.yautja;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.predator.common.PredatorItems;
import org.predator.common.entity.living.SpeciesYautja;

public class EntityYautjaWarrior extends SpeciesYautja
{
    public EntityYautjaWarrior(World world) {
        super(world);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(PredatorItems.SUMMONER_YAUTJA_WARRIOR);
    }
}
