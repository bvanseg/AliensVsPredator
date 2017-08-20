package org.avp.entities.living;

import org.avp.client.Sounds;
import org.avp.entities.EntityAcidProjectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySpitter extends EntityXenomorph implements IRangedAttackMob
{
    public EntitySpitter(World par1World)
    {
        super(par1World);
        this.experienceValue = 275;
        this.setSize(1.0F, 3.0F);
        
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.addStandardXenomorphAISet();
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
    protected SoundEvent getHurtSound()
    {
        return Sounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.ALIEN_DEATH.event();
    }

    @Override
    public int getTotalArmorValue()
    {
        return 2;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        this.attackEntityWithRangedAttack((EntityLivingBase) entity, 0.2f);
        return true;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase living, float damage)
    {
        if (!living.isDead)
        {
            this.getLookHelper().setLookPosition(living.posX, living.posY + living.getEyeHeight(), living.posZ, 10.0F, this.getVerticalFaceSpeed());

            if (this.canEntityBeSeen(living))
            {
                int attackDamage = 2;

                EntityAcidProjectile entityacid = new EntityAcidProjectile(this.world, this, living, 1.6F, 14 - attackDamage * 4);
                entityacid.setDamage(damage * 2.0F + this.rand.nextGaussian() * 0.25D + attackDamage * 0.11F);
                
                if (this.world.getWorldTime() % 30 == 0)
                {
                    this.world.spawnEntity(entityacid);
                }
            }
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }
}
