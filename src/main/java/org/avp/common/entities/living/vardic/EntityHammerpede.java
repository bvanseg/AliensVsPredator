package org.avp.common.entities.living.vardic;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.block.Blocks;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.AlienBlocks;
import org.avp.client.Sounds;
import org.avp.common.ItemHandler;
import org.avp.common.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entities.living.species.SpeciesAlien;

import java.util.ArrayList;

public class EntityHammerpede extends SpeciesAlien implements IMob
{

    public EntityHammerpede(World par1World)
    {
        super(par1World);

        this.setSize(0.5F, 0.5F);
        this.experienceValue = 16;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, 0.8D, true));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        // TODO: Re-implement this
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, Entity.class, 10 /** targetChance **/
//            , false /** checkSight **/
//            , false /** nearbyOnly **/
//            , entitySelector));
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5499999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.fallDistance = 0F;
        this.lurkInBlackGoo();
    }

    public void lurkInBlackGoo()
    {
        if (this.getAttackTarget() == null)
        {
            if (this.world.getTotalWorldTime() % 40 == 0 && this.rand.nextInt(4) == 0)
            {
                if (this.world.getBlockState(new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ)).getBlock() != AlienBlocks.BLACK_GOO)
                {
                    ArrayList<Pos> locations = Blocks.getCoordDataInRangeIncluding((int) this.posX, (int) this.posY, (int) this.posZ, (int) 10, this.world, AlienBlocks.BLACK_GOO);

                    if (locations.size() > 0)
                    {
                        Pos selectedCoord = locations.get(this.rand.nextInt(locations.size()));
                        this.getNavigator().tryMoveToXYZ((double) selectedCoord.x, (double) selectedCoord.y, (double) selectedCoord.z, this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                    }
                    locations.clear();
                    locations = null;
                }
            }
        }
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.CHESTBURSTER_ATTACK.event();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.CHESTBURSTER_HURT.event();
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
    public boolean attackEntityFrom(DamageSource source, float damage)
    {
        return super.attackEntityFrom(source, damage);
    }

    @Override
    public boolean isPotionApplicable(PotionEffect potionEffect)
    {
        return potionEffect.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potionEffect);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerHammerpede);
    }
}
