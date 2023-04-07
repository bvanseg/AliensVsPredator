package org.alien.common.entity.living.xenomorph;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.api.parasitoidic.Nascentic;
import org.alien.common.entity.ai.brain.xenomorph.ChestbursterBrain;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.capability.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.hive.HiveMember;
import org.avp.common.AVPDamageSources;
import org.lib.brain.Brainiac;

public class EntityChestburster extends SpeciesAlien implements IMob, Nascentic, HiveMember, Brainiac<ChestbursterBrain>
{
    private Class<? extends Entity> matureState;

    private ChestbursterBrain brain;

    public EntityChestburster(World world)
    {
        super(world);
        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(this.getClass()).orElse(null);
        this.matureState = maturityEntry != null ? maturityEntry.getEntityClass() : EntityDrone.class;
        this.setSize(0.65F, 0.4F);
        this.experienceValue = 16;
    }

    @Override
    public ChestbursterBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new ChestbursterBrain(this);
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6499999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update();
        }
        
        if(this.getAttackTarget() != null && !EntitySelectorParasitoid.instance.test(this.getAttackTarget()))
            this.setAttackTarget(null);
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.CHESTBURSTER_DEATH.event();
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
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);

        String maturityState = nbt.getString("MaturityState");
        try
        {
            this.matureState = (Class<? extends Entity>) Class.forName(maturityState);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setString("MaturityState", this.matureState.getName());
    }

    @Override
    public void grow(EntityLivingBase host)
    {
        OrganismImpl organism = (OrganismImpl) host.getCapability(Provider.CAPABILITY, null);
    }

    @Override
    public void vitalize(EntityLivingBase host)
    {
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_CHESTBURSTER);
    }

    public Class<? extends Entity> getMatureState() {
        return this.matureState;
    }
}
