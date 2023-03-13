package org.predator.common.entity.living;

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
import org.avp.common.AVPItems;
import org.avp.common.api.parasitoidic.IHost;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.predator.common.PredatorItems;

public class EntityPredatorHound extends EntityMob implements IMob, IHost
{
    public EntityPredatorHound(World world)
    {
        super(world);
        this.setSize(1.5F, 1.75F);
        this.experienceValue = 0;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 5.5D));
        this.tasks.addTask(2, new EntityAIMoveThroughVillage(this, 5.5D, false));
        this.tasks.addTask(3, new PatchedEntityAIWander(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLivingBase.class, 16.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5199999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.3D);
    }
    
    @Override
    public int getTotalArmorValue()
    {
        return 3;
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
        return new ItemStack(PredatorItems.SUMMONER_PREDATOR_HOUND);
    }
}
