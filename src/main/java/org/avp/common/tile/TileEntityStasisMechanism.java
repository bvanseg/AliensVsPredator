package org.avp.common.tile;

import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import org.predator.common.entity.EntityMechanism;
import org.avp.common.item.ItemEntitySummoner;

public class TileEntityStasisMechanism extends TileEntity implements ITickable
{
    private int            direction;
    public EntityMechanism dummyEntity;
    private Entity         stasisEntity;
    public ItemStack       itemstack;
    private String         readOnlyDummyEntityUUID;
    private int            readOnlyStasisEntityID;

    public TileEntityStasisMechanism()
    {
        super();
    }

    @Override
    public void update()
    {
        
        if (!this.world.isRemote)
        {
			if (this.dummyEntity == null)
			{
			    this.dummyEntity = (EntityMechanism) getEntityForUUID(this.world, this.readOnlyDummyEntityUUID);
			    
			    if (this.dummyEntity == null)
			    {
			    	this.dummyEntity = new EntityMechanism(this.world);
			        this.dummyEntity.setLocationAndAngles(this.getPos().getX() + 0.5, this.getPos().getY(), this.getPos().getZ() + 0.5, 0, 0);
			        this.world.spawnEntity(this.dummyEntity);
			    }
			}
			
			if (this.dummyEntity != null)
			{
				if (this.itemstack != null && this.stasisEntity == null && this.itemstack.getItem() instanceof ItemEntitySummoner)
				{
			        ItemEntitySummoner summoner = (ItemEntitySummoner) this.itemstack.getItem();
			        this.stasisEntity = summoner.createNewEntity(this.world);
			        this.stasisEntity.setLocationAndAngles(this.getPos().getX() + 0.5, this.getPos().getY(), this.getPos().getZ() + 0.5, 0, 0);
			        this.world.spawnEntity(this.stasisEntity);
			    }
				
				this.dummyEntity.setLocationAndAngles(this.getPos().getX() + 0.5, this.getPos().getY(), this.getPos().getZ() + 0.5, 0, 0);

	        	// TODO: The riding entity automatically dismounts the very next tick... not sure why, need to fix.
	            if (this.stasisEntity != null && !this.stasisEntity.isRiding())
	            {
	                this.stasisEntity.startRiding(this.dummyEntity, true);
	            }

	            Entity riddenBy = Entities.getEntityRiddenBy(this.dummyEntity);

	            if (riddenBy == null)
	            {
	                this.itemstack = null;
	            }

	            if (riddenBy != null && riddenBy instanceof EntityLivingBase)
	            {
	                ((EntityLivingBase) riddenBy).rotationYawHead = direction * 90;
	            }
			}
        }
    }

    public void setDirection(byte direction)
    {
        this.direction = direction;
    }

    public int getDirection()
    {
        return this.direction;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("Direction", this.direction);

        if (this.dummyEntity != null)
        {
            nbt.setString("DummyEntity", this.dummyEntity.getUniqueID().toString());

            Entity riddenBy = Entities.getEntityRiddenBy(this.dummyEntity);

            if (riddenBy != null)
            {
                nbt.setInteger("StasisEntity", riddenBy.getEntityId());
            }
        }

        if (this.itemstack != null)
        {
            NBTTagCompound nbtStack = new NBTTagCompound();
            this.itemstack.writeToNBT(nbtStack);
            nbt.setTag("StasisItemstack", nbtStack);
        }

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.direction = nbt.getInteger("Direction");
        this.readOnlyDummyEntityUUID = nbt.getString("DummyEntity");
        this.readOnlyStasisEntityID = nbt.getInteger("StasisEntity");
        this.itemstack = new ItemStack(nbt.getCompoundTag("StasisItemstack"));
    }

    public static Entity getEntityForUUID(World world, String uuid)
    {
        for (Object o : world.loadedEntityList)
        {
            Entity e = (Entity) o;

            if (e.getUniqueID().toString().equals(uuid))
            {
                return e;
            }
        }

        return null;
    }

    public Entity getStasisEntity()
    {
        return stasisEntity;
    }

    public String getReadOnlyDmmyEntityUUID()
    {
        return readOnlyDummyEntityUUID;
    }

    public int getReadOnlyStasisEntityID()
    {
        return readOnlyStasisEntityID;
    }
}
