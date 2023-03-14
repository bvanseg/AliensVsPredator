package org.alien.common.entity.living.xenomorph;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraftforge.common.util.Constants.NBT;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.MatriarchBrain;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.world.hive.AlienHive;
import org.alien.common.world.hive.HiveMember;
import org.alien.common.world.hive.HiveOwner;

import java.util.ArrayList;
import java.util.UUID;

public class EntityMatriarch extends SpeciesXenomorph implements IMob, HiveOwner
{
    public static final float                 OVIPOSITOR_THRESHOLD_SIZE          = 1.3F;
    public static final float                 OVIPOSITOR_PROGRESSIVE_GROWTH_SIZE = 0.00225F;
    public static final int                   OVIPOSITOR_UNHEALTHY_THRESHOLD     = 50;
    public static final int                   OVIPOSITOR_JELLYLEVEL_THRESHOLD    = 1000;
    public static final int                   OVIPOSITOR_JELLYLEVEL_GROWTH_USE   = 1;

    private static final DataParameter<Float> OVIPOSITOR_SIZE                    = EntityDataManager.createKey(EntityMatriarch.class, DataSerializers.FLOAT);

    public boolean                            growingOvipositor;

    public AlienHive                         alienHive;

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

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(OVIPOSITOR_SIZE, 0F);
    }

    @Override
    public MatriarchBrain getBrain() {
        if (brain == null && !this.world.isRemote) {
            brain = new MatriarchBrain(this);
        }
        return (MatriarchBrain) brain;
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

    private void jumpBoost() {
        if (isJumping) {
            this.addVelocity(0, 0.2D, 0);
        }
    }

    private void heal() {
        if (this.world.getTotalWorldTime() % 20 == 0 && this.getHealth() > this.getMaxHealth() / 4) {
            this.heal(1F);
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.jumpBoost();
            this.heal();

            if (this.alienHive != null) {
                this.alienHive.update();
            }

            if (this.posY < -32)
            {
                this.setDead();
            }
        }

        if (!this.world.isRemote)
        {
            if (this.world.getTotalWorldTime() % 20 == 0)
            {
                ArrayList<SpeciesAlien> aliens = (ArrayList<SpeciesAlien>) Entities.getEntitiesInCoordsRange(this.world, SpeciesAlien.class, new Pos(this), 16);

                if (this.getAlienHive() != null)
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

                            if (alien != null && alien instanceof HiveMember)
                            {
                            	HiveMember hiveMember = ((HiveMember) alien);

                            	if (hiveMember.getAlienHive() == null) {
                            		this.getAlienHive().addHiveMember(hiveMember.getHiveMemberID());
                            	}
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isReproducing() {
    	return this.getOvipositorSize() >= 1.3F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return AlienSounds.QUEEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return this.getHealth() > this.getMaxHealth() / 4 ? AlienSounds.QUEEN_LIVING_CONSTANT.event() : AlienSounds.QUEEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.QUEEN_DEATH.event();
    }

    private static final String ALIEN_HIVE_NBT_KEY = "AlienHive";

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.setOvipositorSize(nbt.getFloat("ovipositorSize"));

        if (nbt.hasKey(ALIEN_HIVE_NBT_KEY, NBT.TAG_COMPOUND)) {
        	this.alienHive = this.createNewAlienHive();
        	NBTTagCompound hiveData = nbt.getCompoundTag(ALIEN_HIVE_NBT_KEY);
        	this.alienHive.readFromNBT(hiveData);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setFloat("ovipositorSize", this.getOvipositorSize());

        if (this.alienHive != null) {
        	NBTTagCompound hiveData = new NBTTagCompound();
        	this.alienHive.writeToNBT(hiveData);
        	nbt.setTag(ALIEN_HIVE_NBT_KEY, hiveData);
        }
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

    public float getOvipositorSize()
    {
        return this.getDataManager().get(OVIPOSITOR_SIZE);
    }

    public void setOvipositorSize(float value)
    {
        this.getDataManager().set(OVIPOSITOR_SIZE, value);
    }

    @Override
    protected int getJellyLevelStart()
    {
        return 1000;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_QUEEN);
    }

	@Override
	public AlienHive createNewAlienHive() {
		return new AlienHive(this);
	}

	@Override
	public UUID getHiveMemberID() {
		return this.entityUniqueID;
	}
}
