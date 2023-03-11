package org.avp.entities.living.species.xenomorphs;

import org.avp.EntityItemDrops;
import org.avp.ItemHandler;
import org.avp.client.Sounds;
import org.avp.entities.living.species.SpeciesXenomorph;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPredalien extends SpeciesXenomorph implements IMob
{
    public EntityPredalien(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.025F;
        this.experienceValue = 225;
        this.setSize(1.0F, 2.5F);
        this.ignoreFrustumCheck = true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.PREDALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.PREDALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.PREDALIEN_DEATH.event();
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        Sounds.PREDALIEN_ATTACK.playSound(this, 1F, 1F);
        return super.attackEntityAsMob(entity);
    }

    @Override
    public void onDeath(DamageSource damageSource)
    {
        super.onDeath(damageSource);
        EntityItemDrops.SKULL_PREDATOR.tryDrop(this);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerPredalien);
    }
}
