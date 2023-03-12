package org.avp.common.entities.living.species.xenomorphs;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.animations.Animation;
import com.asx.mdx.lib.world.entity.animations.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.ItemHandler;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityFacehugger;

public class EntityOvamorphGiger extends EntityOvamorph
{
    public static final Animation HATCH_ANIMATION = Animation.create(20 * 3);

    public EntityOvamorphGiger(World world)
    {
        super(world);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
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

        if (this.hasHatched && this.world.isRemote)
        {
            if (this.getActiveAnimation() != HATCH_ANIMATION)
            {
                this.setActiveAnimation(HATCH_ANIMATION);
                this.setAnimationTick(HATCH_ANIMATION.getDuration() - 1);
            }
        }
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);
    }

    @Override
    protected void damageEntity(DamageSource source, float amount)
    {
        super.damageEntity(source, amount);
    }

    @Override
    protected void hatch()
    {
        if (!this.world.isRemote)
        {
            EntityFacehugger facehugger = new EntityFacehugger(this.world);
            Pos pos = new Pos(this).findSafePosAround(this.world);

            AnimationHandler.INSTANCE.sendAnimationMessage(this, HATCH_ANIMATION);
            facehugger.setLocationAndAngles(pos.x, pos.y, pos.z, 0F, 0F);
            world.spawnEntity(facehugger);
            facehugger.motionY = 0.75F;
            this.hasHatched = true;
            this.setContainsFacehugger(false);
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerOvamorph);
    }

    @Override
    public Animation[] getAnimations()
    {
        return new Animation[] { HATCH_ANIMATION };
    }

    @Override
    protected void onAnimationFinish(Animation animation)
    {
        if (animation == HATCH_ANIMATION)
        {
            this.pauseAnimation();
            this.setAnimationTick(this.getAnimationTick() - 1);
        }
        else
        {
            super.onAnimationFinish(animation);
        }
    }
}
