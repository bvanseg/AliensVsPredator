package org.prometheus.common.entity.living.vardic;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.block.Blocks;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.entity.living.SpeciesAlien;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.block.init.PrometheusBlocks;
import org.prometheus.common.entity.ai.brain.HammerpedeBrain;

import java.util.List;

public class EntityHammerpede extends SpeciesAlien
{
    public EntityHammerpede(World par1World)
    {
        super(par1World);

        this.setSize(0.25F, 0.75F);
        this.experienceValue = 16;
    }

    @Override
    public HammerpedeBrain getBrain() {
        return (HammerpedeBrain) super.getBrain();
    }

    @Override
    public HammerpedeBrain createNewBrain() {
        return new HammerpedeBrain(this);
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
    public void onUpdate()
    {
        super.onUpdate();
        this.fallDistance = 0F;
        this.lurkInBlackGoo();
    }

    public void lurkInBlackGoo()
    {
        if (this.getAttackTarget() != null)
            return;
        if (this.world.getTotalWorldTime() % 40 != 0 && this.rand.nextInt(4) != 0)
            return;
        if (this.world.getBlockState(this.getPosition()).getBlock() == PrometheusBlocks.BLACK_GOO)
            return;

        List<Pos> locations = Blocks.getCoordDataInRangeIncluding((int) this.posX, (int) this.posY, (int) this.posZ, 10, this.world, PrometheusBlocks.BLACK_GOO);

        if (!locations.isEmpty())
        {
            Pos selectedCoord = locations.get(this.rand.nextInt(locations.size()));
            this.getNavigator().tryMoveToXYZ(selectedCoord.x, selectedCoord.y, selectedCoord.z, this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
        }
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.CHESTBURSTER_ATTACK.event();
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
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(PrometheusItems.SUMMONER_HAMMERPEDE);
    }
}
