package org.alien.common.entity.living.xenomorph.burster;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.world.hive.HiveMember;

public class EntityPredalienChestburster extends EntityChestburster implements HiveMember {
    public EntityPredalienChestburster(World world) {
        super(world);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AlienItems.SUMMONER_PREDALIEN_BURSTER);
    }
}
