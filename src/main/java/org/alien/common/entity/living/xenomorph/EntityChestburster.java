package org.alien.common.entity.living.xenomorph;

import com.asx.mdx.common.Game;
import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Nascentic;
import org.alien.common.api.parasitoidic.RoyalOrganism;
import org.alien.common.entity.ai.brain.xenomorph.ChestbursterBrain;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.hive.HiveMember;
import org.avp.common.AVPDamageSources;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.EntityBrainContext;

public class EntityChestburster extends SpeciesAlien implements IMob, Nascentic, HiveMember, Brainiac<ChestbursterBrain>
{
    private Class<? extends Entity> matureState;

    private ChestbursterBrain brain;

    public EntityChestburster(World world)
    {
        super(world);
        this.matureState = EntityDrone.class;
        this.setSize(1.0F, 0.4F);
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
    public boolean isReadyToMature(RoyalOrganism jellyProducer)
    {
        return this.ticksExisted >= this.getMaturityTime() || this.getJellyLevel() >= this.getMaturityLevel();
    }

    @Override
    public void mature()
    {
        if (this.getJellyLevel() >= this.getMaturityLevel() && this.ticksExisted < this.getMaturityTime())
        {
            this.setJellyLevel(this.getJellyLevel() - this.getMaturityLevel());
        }

        SpeciesAlien matureState = (SpeciesAlien) Entities.constructEntity(this.world, this.getMatureState());

        if (matureState != null)
        {
            matureState.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
            this.world.spawnEntity(matureState);

            for (int particleCount = 0; particleCount < 8; ++particleCount)
            {
                this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }

        }
        else if (Game.instance.isDevEnvironment())
        {
            // TODO:
        }
        this.setDead();
    }

    protected Entity findPlayerToAttack(EntityPlayer entityplayer)
    {
        float brightness = this.getBrightness();

        if (brightness < 0.5F)
        {
            return this.world.getClosestPlayerToEntity(this, 32D);
        }
        else
        {
            return null;
        }
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

    public boolean isClimbing()
    {
        return this.isOnLadder() && this.motionY > 1.0099999997764826D;
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
        OrganismImpl organism = (OrganismImpl) host.getCapability(Provider.CAPABILITY, null);
        this.matureState = organism.getEmbryo().getResultingOrganism();
        
        Pos safeLocation = Entities.getSafeLocationAround(this, new Pos((int)host.posX, (int)host.posY, (int)host.posZ));
        
        if (safeLocation == null)
        {
            safeLocation = new Pos((int)host.posX, (int)host.posY, (int)host.posZ);
        }
        
        this.setLocationAndAngles(safeLocation.x(), safeLocation.y(), safeLocation.z(), 0.0F, 0.0F);
        host.world.spawnEntity(this);
        organism.removeEmbryo();
        host.getActivePotionEffects().clear();
        host.attackEntityFrom(AVPDamageSources.causeChestbursterDamage(this, host), 100000F);
        if(!host.isDead)
            host.setHealth(0);
    }
    
    @Override
    public Class<? extends Entity> getMatureState()
    {
        return this.matureState;
    }

    @Override
    public int getMaturityTime()
    {
        return (15 * 60) * 20;
    }

    @Override
    public int getMaturityLevel()
    {
        return 6400;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_CHESTBURSTER);
    }
}
