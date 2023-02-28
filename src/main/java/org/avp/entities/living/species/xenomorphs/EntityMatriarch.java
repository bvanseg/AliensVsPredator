package org.avp.entities.living.species.xenomorphs;

import java.util.ArrayList;
import java.util.UUID;

import org.avp.AliensVsPredator;
import org.avp.ItemHandler;
import org.avp.client.Sounds;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.alien.EntityAIConstructHive;
import org.avp.entities.ai.alien.EntityAIFindJelly;
import org.avp.entities.ai.alien.EntityAIPathFindToHive;
import org.avp.entities.ai.alien.EntitySelectorXenomorph;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.packets.server.PacketSpawnEntity;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMatriarch extends SpeciesXenomorph implements IMob
{
    public static final float                 OVIPOSITOR_THRESHOLD_SIZE          = 1.3F;
    public static final float                 OVIPOSITOR_PROGRESSIVE_GROWTH_SIZE = 0.00225F;
    public static final int                   OVIPOSITOR_UNHEALTHY_THRESHOLD     = 50;
    public static final int                   OVIPOSITOR_JELLYLEVEL_THRESHOLD    = 1000;
    public static final int                   OVIPOSITOR_JELLYLEVEL_GROWTH_USE   = 1;

    private static final DataParameter<Float> OVIPOSITOR_SIZE                    = EntityDataManager.createKey(EntityMatriarch.class, DataSerializers.FLOAT);

    public boolean                            growingOvipositor;

    public EntityMatriarch(World world)
    {
        super(world);
        this.setSize(2.0F, 5.0F);
        this.growingOvipositor = false;
        this.experienceValue = 40000;
        this.jumpMovementFactor = 0.2F;
        this.hurtResistantTime = 0;
        this.ignoreFrustumCheck = true;
        this.jellyLimitOverride = true;
    }

    public float getOvipositorSize()
    {
        return this.getDataManager().get(OVIPOSITOR_SIZE);
    }

    public void setOvipositorSize(float value)
    {
        this.getDataManager().set(OVIPOSITOR_SIZE, value);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(OVIPOSITOR_SIZE, 0F);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(24D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.600000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1F);
    }

    @Override
    protected void addStandardXenomorphAISet()
    {
        if (this.tasks.taskEntries.isEmpty() && this.targetTasks.taskEntries.isEmpty())
        {
            this.tasks.taskEntries.clear();
            this.targetTasks.taskEntries.clear();
            this.tasks.addTask(0, new EntityAISwimming(this));
            this.tasks.addTask(0, new EntityAIConstructHive(this));
            this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityLivingBase.class, 10F));
            this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
            this.tasks.addTask(1, new EntityAIPathFindToHive(this));
            this.tasks.addTask(2, new EntityAIFindJelly(this));
            this.tasks.addTask(4, new EntityAICustomAttackOnCollide(this, 0.6D, true));
            
            this.targetTasks.addTask(0, new EntityAINearestAttackableTarget<EntityLiving>(this, EntityLiving.class, 0, false, false, EntitySelectorXenomorph.instance));
            this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
            this.targetTasks.addTask(2, new EntityAILeapAtTarget(this, 1.6F));
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.handleOvipositorGrowth();
        this.reproduce();
        this.jumpBoost();
        this.heal();

        if (!this.world.isRemote)
        {
            if (this.posY < -32)
            {
                this.setDead();
            }

            if (this.world.getTotalWorldTime() % 20 == 0)
            {
                ArrayList<SpeciesAlien> aliens = (ArrayList<SpeciesAlien>) Entities.getEntitiesInCoordsRange(this.world, SpeciesAlien.class, new Pos(this), 16);

                if (this.getHive() != null)
                {
                    for (SpeciesAlien alien : aliens)
                    {
                        if (this.rand.nextInt(3) == 0)
                        {
                            // if (alien != null && alien.getHive() != null && !(alien instanceof EntityQueen) && alien.getHive() == this.getHive())
                            // {
                            // if ((this.getAttackTarget() != null || this.getLastAttackedEntity() != null))
                            // {
                            // if (this.rand.nextInt(6) == 0)
                            // {
                            // if (alien instanceof EntityOvamorph)
                            // {
                            // EntityOvamorph ovamorph = (EntityOvamorph) alien;
                            // ovamorph.setHatched(true);
                            // }
                            // }
                            //
                            // EntityLivingBase target = this.getAttackTarget() != null ? this.getAttackTarget() : this.getLastAttackedEntity();
                            //
                            // alien.setAttackTarget(target);
                            // alien.getNavigator().tryMoveToEntityLiving(target, alien.getMoveHelper().getSpeed());
                            // }
                            // }

                            if (alien != null && alien.getHive() == null)
                            {
                                alien.setHiveSignature(this.hive.getUniqueIdentifier());
                            }
                        }
                    }
                }
            }
        }
    }

    private void reproduce()
    {
        if (this.isReproducing())
        {
            if (this.world.getTotalWorldTime() % (20 * 120) == 0 && this.getJellyLevel() >= OVIPOSITOR_UNHEALTHY_THRESHOLD)
            {
                int ovipositorDist = 10;
                double rotationYawRadians = Math.toRadians(this.rotationYawHead - 90);
                double ovamorphX = (this.posX + (ovipositorDist * (Math.cos(rotationYawRadians))));
                double ovamorphZ = (this.posZ + (ovipositorDist * (Math.sin(rotationYawRadians))));

                if (this.world.isRemote)
                {
                    AliensVsPredator.network().sendToServer(new PacketSpawnEntity(ovamorphX, this.posY, ovamorphZ, Entities.getEntityRegistrationId(EntityOvamorph.class)));
                }
                this.setJellyLevel(this.getJellyLevel() - 100);
            }
        }
    }
    
    public boolean isReproducing() {
    	return this.getOvipositorSize() >= 1.3F;
    }

    private void jumpBoost()
    {
        if (!this.world.isRemote)
        {
            if (isJumping)
            {
                this.addVelocity(0, 0.2D, 0);
            }
        }
    }

    private void heal()
    {
        if (!this.world.isRemote)
        {
            if (this.world.getTotalWorldTime() % 20 == 0)
            {
                if (this.getHealth() > this.getMaxHealth() / 4)
                {
                    this.heal(1F);
                }
            }
        }
    }

	private void handleOvipositorGrowth() {
		if (this.getOvipositorSize() < EntityMatriarch.OVIPOSITOR_THRESHOLD_SIZE) {
            this.setOvipositorSize(this.getOvipositorSize() + EntityMatriarch.OVIPOSITOR_PROGRESSIVE_GROWTH_SIZE);
            this.setJellyLevel(this.getJellyLevel() - EntityMatriarch.OVIPOSITOR_JELLYLEVEL_GROWTH_USE);
        }
        
        if (this.getJellyLevel() < OVIPOSITOR_UNHEALTHY_THRESHOLD) {
            this.setOvipositorSize(0F);
            this.addStandardXenomorphAISet();
        }
	}

    @Override
    public UUID getHiveSignature()
    {
        return this.hive != null ? this.hive.getUniqueIdentifier() : this.getUniqueID();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.QUEEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return this.getHealth() > this.getMaxHealth() / 4 ? Sounds.QUEEN_LIVING_CONSTANT.event() : Sounds.QUEEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.QUEEN_DEATH.event();
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.setOvipositorSize(nbt.getFloat("ovipositorSize"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setFloat("ovipositorSize", this.getOvipositorSize());
    }
    
    public boolean canBeCollidedWith()
    {
        return true;
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }
    
    @Override
    protected void collideWithEntity(Entity entityIn)
    {
        ;
    }

    @Override
    protected int getJellyLevelStart()
    {
        return 1000;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerQueen);
    }
}
