package org.avp.entities.living.species.xenomorphs.parasites;

import org.avp.ItemHandler;
import org.avp.api.parasitoidic.IParasitoid;
import org.avp.client.Sounds;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.alien.EntityAIFacehuggerLeap;
import org.avp.entities.living.species.EntityParasitoid;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFacehugger extends EntityParasitoid implements IMob, IParasitoid
{
    private int refertilizationJelly = 0;

    public EntityFacehugger(World world)
    {
        super(world);
        this.setSize(0.8F, 0.8F);
        this.experienceValue = 10;
        this.jumpMovementFactor = 0.3F;
    }

    @Override
    protected void addTasks()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAICustomAttackOnCollide(this, 0.55D, true));
        this.tasks.addTask(8, new EntityAIWander(this, 0.55D));
        this.targetTasks.addTask(2, new EntityAIFacehuggerLeap(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, false, false, this.getImpregnationEntitiySelector()));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.50D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    public boolean isOnLadder()
    {
        return this.motionY > 1.0099999997764826D;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return true;
    }
    
    @Override
    protected void despawnEntity()
    {
        ;
    }

    @Override
    public boolean canMoveToJelly()
    {
        return super.canMoveToJelly() && this.isFertile();
    }

    @Override
    protected void onPickupJelly(EntityItem entityItem)
    {
        super.onPickupJelly(entityItem);

        refertilizationJelly += entityItem.getItem().getCount();

        if (refertilizationJelly >= (5 + this.rand.nextInt(5)))
        {
            this.setFertility(true);
        }
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return this.isFertile() ? Sounds.FACEHUGGER_DEATH.event() : super.getDeathSound();
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerFacehugger);
    }
    
    @Override
    public SoundEvent getImplantSound()
    {
        return Sounds.FACEHUGGER_IMPLANT.event();
    }
    
    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.0575F, 3.0F);
    }
}
