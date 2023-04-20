package org.alien.common.entity.living.xenomorph.ovamorph;

import com.asx.mdx.common.minecraft.entity.animations.Animation;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;

public class EntityOvamorphGiger extends EntityOvamorph
{
    public static final Animation HATCH_ANIMATION = Animation.create(20 * 3);

    public EntityOvamorphGiger(World world)
    {
        super(world);
        this.setSize(0.7F, 0.95F);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
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

        // TODO: This first check may not be totally equivalent to the one that was last here.
        if (this.getTimeLeftUntilOpen() <= 0 && this.world.isRemote)
        {
            if (this.getActiveAnimation() != HATCH_ANIMATION)
            {
                this.setActiveAnimation(HATCH_ANIMATION);
                this.setAnimationTick(HATCH_ANIMATION.getDuration() - 1);
            }
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_OVAMORPH);
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
