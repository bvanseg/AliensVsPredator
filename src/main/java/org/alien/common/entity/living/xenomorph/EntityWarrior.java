package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPItemDrops;
import org.lib.common.inventory.ItemDropContext;

public class EntityWarrior extends SpeciesXenomorph
{
    public EntityWarrior(World world)
    {
        super(world);
        this.experienceValue = 175;
        this.setSize(1.0F, 2.25F);
        this.tasks.addTask(0, new EntityAISwimming(this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return AlienSounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return AlienSounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.ALIEN_DEATH.event();
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_WARRIOR);
    }

    @Override
    protected void dropSkull(DamageSource damageSource, ItemDropContext itemDropContext) {
        if (damageSource.getDamageType().equalsIgnoreCase(AVPDamageSources.WRISTBRACER)) {
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.SKULL_XENO_WARRIOR, 25);
        } else {
            itemDropContext.drop(AVPItemDrops.SKULL_XENO_WARRIOR);
        }
    }
}
