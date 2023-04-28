package org.alien.common.entity.living.paradise;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;

/**
 * @author Boston Vanseghi
 */
public class EntityStripedDevil extends EntityCreature {
    public EntityStripedDevil(World world) {
        super(world);
        this.setSize(0.5F, 1.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5599999761581421D);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AlienItems.SUMMONER_STRIPED_DEVIL);
    }
}
