package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Maturable;
import org.alien.common.entity.ai.brain.xenomorph.CrusherBrain;
import org.alien.common.entity.ai.brain.xenomorph.XenomorphBrain;
import org.alien.common.world.hive.HiveMember;

public class EntityCrusher extends EntityPraetorian implements Maturable, HiveMember
{
    public EntityCrusher(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.2F;
        this.experienceValue = 300;
        this.setSize(1.0F, 2.8F);
    }

    @Override
    public XenomorphBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new CrusherBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(90.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1F);
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
    protected float getSoundPitch() {
        return 0.2F;
    }

    @Override
    public int getTotalArmorValue()
    {
        return 5;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_CRUSHER);
    }
}
