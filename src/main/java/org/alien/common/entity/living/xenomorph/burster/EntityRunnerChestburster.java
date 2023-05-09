package org.alien.common.entity.living.xenomorph.burster;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.world.hive.HiveMember;

public class EntityRunnerChestburster extends EntityChestburster implements HiveMember
{

    public EntityRunnerChestburster(World world)
    {
        super(world);
        this.setSize(0.8F, 1F);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_RUNNER_BURSTER);
    }
}
