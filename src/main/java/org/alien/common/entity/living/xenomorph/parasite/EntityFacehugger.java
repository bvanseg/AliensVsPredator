package org.alien.common.entity.living.xenomorph.parasite;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.ai.brain.parasitoid.FacehuggerBrain;
import org.alien.common.entity.ai.brain.parasitoid.ParasitoidBrain;
import org.alien.common.entity.living.EntityParasitoid;

public class EntityFacehugger extends EntityParasitoid implements IMob, Parasitoid
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
    public ParasitoidBrain getBrain() {
        if (!this.world.isRemote && this.brain ==  null) {
            this.brain = new FacehuggerBrain(this);
        }
        return this.brain;
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
    protected void despawnEntity() { /* Do Nothing */ }

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
        return this.isFertile() ? AlienSounds.FACEHUGGER_DEATH.event() : super.getDeathSound();
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_FACEHUGGER);
    }
    
    @Override
    public SoundEvent getImplantSound()
    {
        return AlienSounds.FACEHUGGER_IMPLANT.event();
    }
    
    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.0575F, 3.0F);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        if (this.isFertile()) {
            super.knockBack(entityIn, strength, xRatio, zRatio);
        }
    }
}
