package org.predator.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import org.avp.common.AVPDamageSources;
import org.lib.common.FuncUtil;
import org.lib.common.entity.BooleanDataHandle;
import org.predator.common.PredatorItems;

import java.util.List;
import java.util.UUID;

public class EntityLaserMine extends Entity
{
    private static final DataParameter<Boolean> TRIPPED = EntityDataManager.createKey(EntityLaserMine.class, DataSerializers.BOOLEAN);

    private static final int TIME_TO_DETONATE_IN_TICKS = 10;

    public final BooleanDataHandle isTripped = new BooleanDataHandle(this, TRIPPED);
    private UUID ownerUUID;
    public int direction;
    public BlockPos parentBlockPos;
	private Entity targetEntity;
	private RayTraceResult obstructingBlockTrace;
	
	private double targetDistance;
	private double blockDistance;
	
	private long charge;

    public EntityLaserMine(World world)
    {
        super(world);
        this.ignoreFrustumCheck = true;
        this.targetDistance = Double.MAX_VALUE;
        this.blockDistance = Double.MAX_VALUE;
        this.setSize(0.5F, 0.5F);
    }

    public EntityLaserMine(World world, BlockPos pos, int direction, UUID ownerUUID)
    {
        this(world);
        this.parentBlockPos = pos;
        this.direction = direction;
        this.ownerUUID = ownerUUID;
        this.moveToBlockPosAndAngles(pos, 0F, 0F);
        this.setDirectionBasedBounds(direction);
    }

    @Override
    protected void entityInit()
    {
        this.getDataManager().register(TRIPPED, false);
    }
    
    public boolean canStay()
    {
        return this.parentBlockPos != null && world.getBlockState(this.parentBlockPos) != Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return true;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        // Try and find a clear target every 2 ticks if one does not already exist.
        if (this.world.getTotalWorldTime() % 2 == 0 && !this.canExplodeForEntity()) {
        	this.targetEntity = this.findEntityOnPath();
        	this.obstructingBlockTrace = this.scanForBlocks();
        }
    	
    	this.targetDistance = targetEntity != null ?
    			this.getDistance(targetEntity.posX, targetEntity.posY, targetEntity.posZ) :
    				Double.MAX_VALUE;
    	this.blockDistance = obstructingBlockTrace != null ?
    			this.getDistance(obstructingBlockTrace.getBlockPos().getX(), obstructingBlockTrace.getBlockPos().getY(), obstructingBlockTrace.getBlockPos().getZ()) :
    				Double.MAX_VALUE;

    	if (!this.world.isRemote) {
        	if (this.canExplodeForEntity()) {
        		if (this.isTargetEntityVisible()) {
            		this.isTripped.set(true);
        		}
            	
        		if (this.isTripped.get()) {
        			if (this.isCharged()) {
        				this.explode(targetEntity);
        			} else {
            			this.charge++;
        			}
        		}
        	}
        	
            if (!this.canStay()) {
                this.drop();
            }
    	}
    }

    public int getLaserMaxDepth()
    {
        return 4;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float damage)
    {
        if (!this.world.isRemote)
        {
            this.drop();
        }

        return true;
    }

    private static final String PARENT_BLOCK_POS_NBT_KEY = "ParentBlockPos";
    private static final String DIR_NBT_KEY = "Dir";
    private static final String OWNER_NBT_KEY = "Owner";

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        if (parentBlockPos != null) {
            nbttagcompound.setIntArray(PARENT_BLOCK_POS_NBT_KEY, new int[] { parentBlockPos.getX(), parentBlockPos.getY(), parentBlockPos.getZ() });
        }

        nbttagcompound.setByte(DIR_NBT_KEY, (byte) this.direction);
        nbttagcompound.setUniqueId(OWNER_NBT_KEY, this.ownerUUID);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        this.parentBlockPos = FuncUtil.let(
            nbttagcompound.getIntArray(PARENT_BLOCK_POS_NBT_KEY),
            array -> array.length != 3 ? null : new BlockPos(array[0], array[1], array[2])
        );
        this.direction = nbttagcompound.getByte(DIR_NBT_KEY);
        this.ownerUUID = nbttagcompound.getUniqueId(OWNER_NBT_KEY);
    }

    public double getLaserHitDistanceFromMine()
    {
    	// If there are no obstructions in front of the laser, we can just shine the max length.
    	if (targetEntity == null && obstructingBlockTrace == null) {
    		return this.getLaserMaxDepth();
    	}

        return Math.min(this.targetDistance, this.blockDistance);
    }
    
    private boolean canExplodeForEntity() {
    	if (this.targetEntity == null)
    		return false;
    	if (this.targetEntity instanceof EntityLaserMine)
    		return false;
        if (this.targetEntity instanceof EntityPlayer && ((EntityPlayer)this.targetEntity).isCreative())
        	return false;
        
        return true;
    }

	private boolean isCharged() {
		return this.charge >= TIME_TO_DETONATE_IN_TICKS;
	}

	private boolean isTargetEntityVisible() {
		return this.targetDistance < this.blockDistance;
	}
    
    private final RayTraceResult scanForBlocks() {
    	int xOffset = this.getLaserMaxDepth() * this.getHorizontalFacing().getDirectionVec().getX();
    	int zOffset = this.getLaserMaxDepth() * -this.getHorizontalFacing().getDirectionVec().getZ();
    	
        Vec3d origin = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d target = new Vec3d(this.posX + xOffset, this.posY, this.posZ + zOffset);
        RayTraceResult midResult = this.world.rayTraceBlocks(origin, target, false, true, false);

        return midResult;
    }
    
    private final Entity findEntityOnPath() {
    	int xOffset = this.getLaserMaxDepth() * this.getHorizontalFacing().getDirectionVec().getX();
    	int zOffset = this.getLaserMaxDepth() * -this.getHorizontalFacing().getDirectionVec().getZ();
        List<Entity> list = this.world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(xOffset, 0, zOffset).grow(0.025D));
        return !list.isEmpty() ? list.get(0) : null;
    }

    private void drop()
    {
        this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(PredatorItems.ITEM_PROXIMITY_MINE)));
        this.setDead();
    }

    private void explode(Entity entityHit)
    {
        Explosion explosion = new Explosion(world, this, this.posX, this.posY, this.posZ, 4F, false, false);
        explosion.doExplosionB(true);
        entityHit.attackEntityFrom(AVPDamageSources.causeLaserMineDamage(this), 15F);
        entityHit.hurtResistantTime = 0;
        this.setDead();
    }

    private void setDirectionBasedBounds(int side)
    {
        this.rotationYaw = 90F * (this.direction);
        float bounds = -0.00625F;
        
        // Used to randomly distribute the mine across the side of a block depending on what direction the mine is facing.
        boolean facing = this.getHorizontalFacing() == EnumFacing.NORTH || this.getHorizontalFacing() == EnumFacing.SOUTH;
        float randomXOffset = facing ? (this.rand.nextFloat() / 2) + 0.25F : 0.5F;
        float randomZOffset = !facing ? (this.rand.nextFloat() / 2) + 0.25F : 0.5F;

        float xPos = (float) (this.posX + randomXOffset);
        float yPos = (float) (this.posY + this.rand.nextFloat() / 2);
        float zPos = (float) (this.posZ + randomZOffset);
        float f6 = 0.53F;

        switch(side)
        {
            case 0:
                xPos -= f6;
                zPos -= f6 * 2;
                break;
            case 1:
                xPos -= f6 * 2;
                zPos -= f6;
                break;
            case 2:
                xPos -= f6;
                zPos += 0.06f;
                break;
            case 3:
                xPos += 0.06f;
                zPos -= f6;
                break;
            default:
                break;
        }

        this.setPosition(xPos, yPos, zPos);
        this.setEntityBoundingBox(new AxisAlignedBB(xPos - bounds, yPos - bounds, zPos - bounds, xPos + bounds, yPos + bounds, zPos + bounds));
    }
}
