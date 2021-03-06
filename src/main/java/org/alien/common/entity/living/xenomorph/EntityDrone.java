package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.xenomorph.DroneBrain;
import org.alien.common.entity.ai.brain.xenomorph.XenomorphBrain;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPItemDrops;
import org.lib.common.inventory.ItemDropContext;

public class EntityDrone extends SpeciesXenomorph
{
    public EntityDrone(World world)
    {
        super(world);
        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
    }

    @Override
    public DroneBrain getBrain() {
        return (DroneBrain) super.getBrain();
    }

    @Override
    public XenomorphBrain createNewBrain() {
        return new DroneBrain(this);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.53D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_DRONE);
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
    protected void dropSkull(DamageSource damageSource, ItemDropContext itemDropContext) {
        if (damageSource.getDamageType().equalsIgnoreCase(AVPDamageSources.WRISTBRACER)) {
            itemDropContext.dropWithBonusDropWeight(AVPItemDrops.SKULL_XENO_DRONE, 25);
        } else {
            itemDropContext.drop(AVPItemDrops.SKULL_XENO_DRONE);
        }
    }
}
