package org.alien.common.entity.living;

import com.asx.mdx.common.minecraft.Pos;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;

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
    protected void despawnEntity() { /* Do Nothing */ }
    
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
        return new ItemStack(AlienItems.SUMMONER_DRACO_EGG);
    }
}
