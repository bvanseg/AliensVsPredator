package org.prometheus.common.entity.living.vardic;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Host;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.entity.ai.brain.UrsuidaeBrain;
import org.lib.brain.Brainiac;

public class EntityUrsuidae extends EntityMob implements Host, Brainiac<UrsuidaeBrain>
{
    private UrsuidaeBrain brain;

    public EntityUrsuidae(World world)
    {
        super(world);
        this.setSize(1.5F, 1.75F);
        this.experienceValue = 0;
    }

    @Override
    public UrsuidaeBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new UrsuidaeBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5199999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.3D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update();
        }
    }

    @Override
    public int getTotalArmorValue()
    {
        return 1;
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
    protected void despawnEntity() { /* Do Nothing */ }

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
        return new ItemStack(PrometheusItems.SUMMONER_URSUIDAE);
    }
}
