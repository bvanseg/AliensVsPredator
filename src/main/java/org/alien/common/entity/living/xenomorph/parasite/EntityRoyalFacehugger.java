package org.alien.common.entity.living.xenomorph.parasite;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;

public class EntityRoyalFacehugger extends EntityFacehugger
{
    public EntityRoyalFacehugger(World world)
    {
        super(world);
        this.experienceValue = 300;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
    }

    @Override
    public int getTotalArmorValue()
    {
        return 4;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_ROYAL_FACEHUGGER);
    }
}
