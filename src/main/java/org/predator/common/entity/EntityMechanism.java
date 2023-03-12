package org.predator.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.predator.PredatorBlocks;

public class EntityMechanism extends Entity
{
    private static final DataParameter<Integer> CONTAINED_ID = EntityDataManager.<Integer> createKey(EntityMechanism.class, DataSerializers.VARINT);
    
    public EntityMechanism(World world)
    {
        super(world);
        this.setSize(1F, 0.1F);
    }

    @Override
    protected void entityInit()
    {
        this.getDataManager().register(CONTAINED_ID, 0);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (this.world.getTotalWorldTime() % 20 == 0)
        {
            Block block = this.world.getBlockState(new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ - 1)).getBlock();

            if (block != PredatorBlocks.STASIS_MECHANISM)
            {
                this.setDead();
            }
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tag)
    {
        this.getDataManager().set(CONTAINED_ID, tag.getInteger("EntityContainedId"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tag)
    {
        tag.setInteger("EntityContainedId", this.getEntityContainedId());
    }

    public int getEntityContainedId()
    {
        return this.getDataManager().get(CONTAINED_ID);
    }

    public void setEntityContainedId(Entity entityContained)
    {
        this.getDataManager().set(CONTAINED_ID, entityContained.getEntityId());
    }
}
