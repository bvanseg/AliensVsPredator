package org.avp.common.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public abstract class EntityAIYOffsetBlockInteract extends EntityAIBase
{
    protected EntityLiving theEntity;
    protected int yOffset;
    protected Block block;
    boolean hasStoppedDoorInteraction;

    public EntityAIYOffsetBlockInteract(EntityLiving theEntity, int yOffset)
    {
        this.theEntity = theEntity;
        this.yOffset = yOffset;
        this.block = Blocks.AIR;
    }

    @Override
    public boolean shouldExecute()
    {
        this.block = this.theEntity.world.getBlockState(new BlockPos((int) this.theEntity.posX, (int) this.theEntity.posY + yOffset, (int) this.theEntity.posZ)).getBlock();
        return this.block != null;
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return true;
    }

    @Override
    public void startExecuting()
    {
        this.getOffsetBlock();
    }

    @Override
    public void updateTask()
    {
        this.getOffsetBlock();
    }

    public void getOffsetBlock()
    {
        if (this.block == Blocks.AIR)
        {
            this.block = this.theEntity.world.getBlockState(new BlockPos((int) this.theEntity.posX, (int) this.theEntity.posY + yOffset, (int) this.theEntity.posZ)).getBlock();
        }
    }
}
