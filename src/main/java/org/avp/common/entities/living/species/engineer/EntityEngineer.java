package org.avp.common.entities.living.species.engineer;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.DamageSources;
import org.avp.common.EntityItemDrops;
import org.avp.common.ItemHandler;
import org.avp.common.entities.living.species.SpeciesEngineer;

public class EntityEngineer extends SpeciesEngineer
{
    public EntityEngineer(World world)
    {
        super(world);
        this.experienceValue = 250;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(160.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5199999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1F);
    }
    
    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);
        
        if (damagesource == DamageSources.wristbracer)
        {
            EntityItemDrops.SKULL_ENGINEER.tryDrop(this, 25);
        }
        else
        {
            EntityItemDrops.SKULL_ENGINEER.tryDrop(this);
        }
    }

    @Override
    public int getTotalArmorValue()
    {
        return 7;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return null;
    }
    
    @Override
    protected void despawnEntity()
    {
        ;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerEngineer);
    }
}
