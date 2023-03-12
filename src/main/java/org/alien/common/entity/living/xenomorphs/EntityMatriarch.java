package org.alien.common.entity.living.xenomorphs;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
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
import org.alien.common.entity.ai.EntityAIFindJelly;
import org.alien.common.entity.ai.EntityAIPathFindToHive;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.AVP;
import org.avp.client.Sounds;
import org.avp.common.ItemHandler;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.avp.common.network.packet.server.PacketSpawnEntity;
import org.avp.common.world.hive.AlienHive;
import org.avp.common.world.hive.HiveMember;
import org.avp.common.world.hive.HiveOwner;

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

    private AlienHive                         alienHive;

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

    private void removeAI()
    {
        if (!this.tasks.taskEntries.isEmpty() || !this.targetTasks.taskEntries.isEmpty())
        {
            this.tasks.taskEntries.clear();
            this.targetTasks.taskEntries.clear();
        }
    }

    @Override
    protected void addStandardXenomorphAISet()
    {
        if (this.tasks.taskEntries.isEmpty() && this.targetTasks.taskEntries.isEmpty())
        {
            this.tasks.taskEntries.clear();
            this.targetTasks.taskEntries.clear();
            this.tasks.addTask(0, new EntityAISwimming(this));
            this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityLivingBase.class, 10F));
            this.tasks.addTask(0, new EntityAISwimming(this));
            this.tasks.addTask(1, new PatchedEntityAIWander(this, 0.8D));
            this.tasks.addTask(1, new EntityAIPathFindToHive(this));
            this.tasks.addTask(2, new EntityAIFindJelly(this));
            this.tasks.addTask(4, new EntityAICustomAttackOnCollide(this, 0.6D, true));

            this.targetTasks.addTask(0, new EntityAINearestAttackableTarget<EntityLiving>(this, EntityLiving.class, 0, false, false, EntitySelectorXenomorph.instance));
            this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
            this.targetTasks.addTask(2, new EntityAILeapAtTarget(this, 1.6F));
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

                // this.world.playSound(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(), AliensVsPredator.sounds().SOUND_QUEEN_HURT, SoundCategory.HOSTILE, 1F, this.rand.nextInt(10) / 100, true);

                if (this.world.isRemote)
                {
                    AVP.network().sendToServer(new PacketSpawnEntity(ovamorphX, this.posY, ovamorphZ, Entities.getEntityRegistrationId(EntityOvamorph.class)));
                }
                this.setJellyLevel(this.getJellyLevel() - 100);
            }
        }
    }

    private void handleOvipositorGrowth()
    {
        if (!this.world.isRemote)
        {
            boolean ovipositorHealthy = this.getJellyLevel() >= OVIPOSITOR_UNHEALTHY_THRESHOLD;

            if (ovipositorHealthy)
            {
                if (this.getAlienHive() == null && !this.world.canSeeSky(this.getPosition()))
                {
                    this.alienHive = this.createNewAlienHive();

                    if (this.getOvipositorSize() < OVIPOSITOR_THRESHOLD_SIZE)
                    {
                        this.setOvipositorSize(this.getOvipositorSize() + OVIPOSITOR_PROGRESSIVE_GROWTH_SIZE);
                        this.setJellyLevel(this.getJellyLevel() - OVIPOSITOR_JELLYLEVEL_GROWTH_USE);
                    }

                    this.removeAI();
                }
            }
            else if (!ovipositorHealthy)
            {
                this.setOvipositorSize(0F);
                this.addStandardXenomorphAISet();
            }
        }
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

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.handleOvipositorGrowth();
        this.reproduce();
        this.jumpBoost();
        this.heal();

        if (!this.world.isRemote && this.alienHive != null) {
        	this.alienHive.update();
        }

        if (!this.world.isRemote)
        {
            if (this.posY < -32)
            {
                this.setDead();
            }

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

    private static final String alienHiveNbtKey = "AlienHive";

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.setOvipositorSize(nbt.getFloat("ovipositorSize"));

        if (nbt.hasKey(alienHiveNbtKey, NBT.TAG_COMPOUND)) {
        	this.alienHive = this.createNewAlienHive();
        	NBTTagCompound hiveData = nbt.getCompoundTag("AlienHive");
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
        	nbt.setTag(alienHiveNbtKey, hiveData);
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

	@Override
	public AlienHive createNewAlienHive() {
		return new AlienHive(this);
	}

	@Override
	public UUID getHiveMemberID() {
		return this.entityUniqueID;
	}
}
