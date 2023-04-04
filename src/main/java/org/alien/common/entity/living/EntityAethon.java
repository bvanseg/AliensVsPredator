package org.alien.common.entity.living;

import com.asx.mdx.common.minecraft.Pos;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Host;
import org.alien.common.entity.ai.brain.AethonBrain;
import org.avp.common.AVPItemDrops;
import org.lib.brain.Brainiac;
import org.lib.common.inventory.ItemDropContext;

public class EntityAethon extends EntityMob implements IMob, Host, Brainiac<AethonBrain>
{
    private static final DataParameter<Integer> FLYING = EntityDataManager.createKey(EntityAethon.class, DataSerializers.VARINT);

    private BlockPos    flyToPosition;

    private AethonBrain brain;

    public EntityAethon(World world)
    {
        super(world);
        this.experienceValue = 150;
        this.setSize(3, 7);
    }

    @Override
    public AethonBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new AethonBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }
    
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(FLYING, 0);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45199999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32D);
    }

    @Override
    public boolean isAIDisabled()
    {
        return false;
    }

    @Override
    public boolean canParasiteAttach()
    {
        return this.canHostParasite();
    }

    @Override
    public boolean canHostParasite()
    {
        return false;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update();
        }

        this.fallDistance = 0F;

        if (!this.world.isRemote)
        {
            if (isFlying())
            {
                this.motionY *= 0.5000000238418579D;
            }

            if (this.getAttackTarget() != null && this.getDistance(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ) <= 12)
            {
                this.getDataManager().set(FLYING, 0);
            }
            else if (this.getAttackTarget() == null && this.rand.nextInt(30) == 0)
            {
                this.getDataManager().set(FLYING, 1);
            }

            if (this.flyToPosition != null && (!this.world.isAirBlock(this.flyToPosition) || this.flyToPosition.getY() < 1))
            {
                this.flyToPosition = null;
            }

            if (this.flyToPosition == null || this.rand.nextInt(30) == 0 || Pos.distanceSq(flyToPosition.getX(), flyToPosition.getY(), flyToPosition.getZ(), (int) this.posX, (int) this.posY, (int) this.posZ) < 4.0F)
            {
                if (this.getAttackTarget() != null)
                {
                    this.flyToPosition = new BlockPos((int) this.getAttackTarget().posX, (int) this.getAttackTarget().posY, (int) this.getAttackTarget().posZ);
                }
                else
                {
                    this.flyToPosition = new BlockPos((int) this.posX + this.rand.nextInt(16) - this.rand.nextInt(16), (int) this.posY + this.rand.nextInt(14) - this.rand.nextInt(16), (int) this.posZ + this.rand.nextInt(16) - this.rand.nextInt(16));
                }
            }

            if (this.isFlying())
            {
                double d0 = this.flyToPosition.getX() + 0.5D - this.posX;
                double d1 = this.flyToPosition.getY() + 0.1D - this.posY;
                double d2 = this.flyToPosition.getZ() + 0.5D - this.posZ;
                this.motionX += (Math.signum(d0) * 0.65D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(d1) * 2.199999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(d2) * 0.65D - this.motionZ) * 0.10000000149011612D;
                float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += f1;
            }
        }
    }

    public boolean isFlying()
    {
        return this.getDataManager().get(FLYING) != 0;
    }

    @Override
    public int getTotalArmorValue()
    {
        return 6;
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
    public void onDeath(DamageSource source)
    {
        super.onDeath(source);

        ItemDropContext itemDropContext = new ItemDropContext(this);
        itemDropContext.drop(AVPItemDrops.SKULL_ENGINEER);
        itemDropContext.drop(AVPItemDrops.SKULL_SPACEJOCKEY);
        itemDropContext.drop(AVPItemDrops.SKULL_PREDATOR);
        itemDropContext.drop(AVPItemDrops.SKULL_XENO_DRONE);
        itemDropContext.drop(AVPItemDrops.SKULL_XENO_WARRIOR);
        itemDropContext.drop(AVPItemDrops.SKULL_AETHON);
        itemDropContext.drop(AVPItemDrops.HEAD_GIGER);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_AETHON);
    }
}
