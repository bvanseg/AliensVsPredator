package org.alien.common.entity.living.vardic;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.xenomorph.burster.EntityChestburster;

public class EntityBelugaburster extends EntityChestburster
{

    public EntityBelugaburster(World world)
    {
        super(world);
        this.setSize(0.25F, 0.7F);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_BELUGABURSTER);
    }
}
