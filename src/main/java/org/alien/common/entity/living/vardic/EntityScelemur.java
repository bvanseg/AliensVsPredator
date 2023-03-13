package org.alien.common.entity.living.vardic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.avp.common.AVPItems;
import org.avp.common.api.parasitoidic.IHost;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;

public class EntityScelemur extends EntityMob implements IMob, IHost
{
    public EntityScelemur(World world)
    {
        super(world);
        this.setSize(0.5F, 1.0F);
        this.experienceValue = 0;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 0.55D));
        this.tasks.addTask(2, new EntityAIMoveThroughVillage(this, 0.55D, false));
        this.tasks.addTask(3, new PatchedEntityAIWander(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLivingBase.class, 16.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.tasks.addTask(6, new EntityAICustomAttackOnCollide(this, EntityLivingBase.class, 0.6D, true));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5599999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.3D);
    }
    
    @Override
    public int getTotalArmorValue()
    {
        return 0;
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
    public boolean canParasiteAttach()
    {
        return false;
    }

    @Override
    public boolean canHostParasite()
    {
        return false;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_VARDA_MONKEY);
    }
}
