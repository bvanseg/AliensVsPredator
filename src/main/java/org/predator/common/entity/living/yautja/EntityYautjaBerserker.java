package org.predator.common.entity.living.yautja;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPItemDrops;
import org.lib.common.inventory.ItemDropContext;
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
    protected void dropBiomaskAndSkull(ItemDropContext itemDropContext, DamageSource damageSource)
    {
        if (damageSource == AVPDamageSources.WRISTBRACER)
        {
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.SKULL_PREDATOR, 25);
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.BIOMASK_BERSERKER, 25);
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.BIOMASK_FALCONER, 25);
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.BIOMASK_TRACKER, 25);
            return;
        }

        itemDropContext.drop(AVPItemDrops.SKULL_PREDATOR);
        itemDropContext.drop(AVPItemDrops.BIOMASK_BERSERKER);
        itemDropContext.drop(AVPItemDrops.BIOMASK_FALCONER);
        itemDropContext.drop(AVPItemDrops.BIOMASK_TRACKER);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(PredatorItems.SUMMONER_YAUTJA_BERSERKER);
    }
}
