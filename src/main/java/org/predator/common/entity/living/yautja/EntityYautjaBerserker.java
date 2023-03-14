package org.predator.common.entity.living.yautja;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPItemDrops;
import org.predator.common.PredatorItems;
import org.predator.common.entity.living.SpeciesYautja;

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
    protected void dropBiomaskAndSkull(DamageSource damageSource)
    {
        if (damageSource == AVPDamageSources.WRISTBRACER)
        {
            AVPItemDrops.SKULL_PREDATOR.tryDrop(this, 25);
            AVPItemDrops.BIOMASK_BERSERKER.tryDrop(this, 25);
            AVPItemDrops.BIOMASK_FALCONER.tryDrop(this, 25);
            AVPItemDrops.BIOMASK_TRACKER.tryDrop(this, 25);
            return;
        }

        AVPItemDrops.SKULL_PREDATOR.tryDrop(this);
        AVPItemDrops.BIOMASK_BERSERKER.tryDrop(this);
        AVPItemDrops.BIOMASK_FALCONER.tryDrop(this);
        AVPItemDrops.BIOMASK_TRACKER.tryDrop(this);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(PredatorItems.SUMMONER_YAUTJA_BERSERKER);
    }
}
