package org.alien.common.entity.living.xenomorph;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.world.hive.HiveMember;

public class EntityQueenChestburster extends EntityChestburster implements HiveMember {

    public EntityQueenChestburster(World world) {
        super(world);
        this.setSize(0.8F, 1F);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AlienItems.SUMMONER_QUEEN_BURSTER);
    }
}
