package org.alien.common.entity.living;

import com.asx.mdx.lib.world.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.ItemHandler;
import org.alien.common.entity.living.xenomorphs.EntityOvamorph;
import org.alien.common.entity.living.xenomorphs.parasites.EntityFacehugger;

public class EntityDracoEgg extends EntityOvamorph
{
    public EntityDracoEgg(World world)
    {
        super(world);
        this.setSize(1F, 1F);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
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
    protected void despawnEntity()
    {
        ;
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);
    }
    
    @Override
    protected void hatch()
    {
        if (!this.world.isRemote)
        {
            EntityFacehugger facehugger = new EntityFacehugger(this.world);
            Pos pos = new Pos(this).findSafePosAround(this.world);

            facehugger.setLocationAndAngles(pos.x, pos.y, pos.z, 0F, 0F);
            world.spawnEntity(facehugger);
            facehugger.motionY = 0.75F;

            this.setContainsFacehugger(false);
        }
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.Experimental.summonerDracoEgg);
    }
}
