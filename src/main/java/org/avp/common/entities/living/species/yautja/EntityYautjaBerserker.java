package org.avp.common.entities.living.species.yautja;

import org.avp.common.DamageSources;
import org.avp.common.EntityItemDrops;
import org.avp.common.ItemHandler;
import org.avp.common.entities.living.species.SpeciesYautja;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityYautjaBerserker extends SpeciesYautja
{
    public EntityYautjaBerserker(World world)
    {
        super(world);
        this.experienceValue = 450;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(130.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5199999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48D);
    }

    @Override
    public int getTotalArmorValue()
    {
        return 8;
    }
    
    @Override
    protected void dropBiomaskAndSkull(DamageSource damagesource)
    {
        if (damagesource == DamageSources.wristbracer)
        {
            EntityItemDrops.SKULL_PREDATOR.tryDrop(this, 25);
            EntityItemDrops.BIOMASK_BERSERKER.tryDrop(this, 25);
            EntityItemDrops.BIOMASK_FALCONER.tryDrop(this, 25);
            EntityItemDrops.BIOMASK_TRACKER.tryDrop(this, 25);
        }
        else
        {
            EntityItemDrops.SKULL_PREDATOR.tryDrop(this);
            EntityItemDrops.BIOMASK_BERSERKER.tryDrop(this);
            EntityItemDrops.BIOMASK_FALCONER.tryDrop(this);
            EntityItemDrops.BIOMASK_TRACKER.tryDrop(this);
        }
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerYautjaBerserker);
    }
}
