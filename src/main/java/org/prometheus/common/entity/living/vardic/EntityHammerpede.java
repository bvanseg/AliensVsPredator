package org.prometheus.common.entity.living.vardic;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.entity.living.SpeciesAlien;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.entity.ai.brain.HammerpedeBrain;

public class EntityHammerpede extends SpeciesAlien
{
    public EntityHammerpede(World par1World)
    {
        super(par1World);

        this.setSize(0.25F, 0.75F);
        this.experienceValue = 16;
    }

    @Override
    public HammerpedeBrain getBrain() {
        return (HammerpedeBrain) super.getBrain();
    }

    @Override
    public HammerpedeBrain createNewBrain() {
        return new HammerpedeBrain(this);
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5499999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.fallDistance = 0F;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.CHESTBURSTER_ATTACK.event();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return AlienSounds.CHESTBURSTER_HURT.event();
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean isOnLadder()
    {
        return this.collidedHorizontally;
    }

    @Override
    public boolean isPotionApplicable(PotionEffect potionEffect)
    {
        return potionEffect.getPotion() != MobEffects.POISON && super.isPotionApplicable(potionEffect);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(PrometheusItems.SUMMONER_HAMMERPEDE);
    }
}
