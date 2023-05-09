package org.alien.common.entity.living.xenomorph.exotic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.EntityAcidProjectile;
import org.alien.common.entity.ai.brain.xenomorph.SpitterBrain;
import org.alien.common.entity.living.SpeciesXenomorph;

public class EntitySpitter extends SpeciesXenomorph implements IRangedAttackMob
{
    
    public EntitySpitter(World par1World)
    {
        super(par1World);
        this.experienceValue = 275;
        this.setSize(1.0F, 2.5F);
    }

    @Override
    public SpitterBrain getBrain() {
        return (SpitterBrain) super.getBrain();
    }

    @Override
    public SpitterBrain createNewBrain() {
        return new SpitterBrain(this);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5500000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
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
    public int getTotalArmorValue()
    {
        return 2;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null)
        {
            this.getLookHelper().setLookPosition(targetEntity.posX, targetEntity.posY + targetEntity.getEyeHeight(), targetEntity.posZ, 10.0F, this.getVerticalFaceSpeed());

            if (this.canEntityBeSeen(targetEntity))
            {
                EntityAcidProjectile entityAcidProjectile = new EntityAcidProjectile(this.world, this);
                double d0 = targetEntity.posX - this.posX;
                double d1 = targetEntity.getEntityBoundingBox().minY + (targetEntity.height / 3.0F) - entityAcidProjectile.posY;
                double d2 = targetEntity.posZ - this.posZ;
                double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
                entityAcidProjectile.shoot(d0, d1 + d3 * 0.20000000298023224, d2, 1.6F, (14 - this.world.getDifficulty().getId() * 4));
                entityAcidProjectile.setDamage(damage * 2.0F + this.rand.nextGaussian() * 0.25D + damage * 0.11F);
                this.world.spawnEntity(entityAcidProjectile);
            }
        }
    }

    @Override
    public void setSwingingArms(boolean swingingArms) { /* Do Nothing */ }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_SPITTER);
    }
}
