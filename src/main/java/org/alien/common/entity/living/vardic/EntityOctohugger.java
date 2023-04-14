package org.alien.common.entity.living.vardic;

import com.asx.mdx.common.minecraft.block.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.world.Embryo;
import org.alien.common.world.capability.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;

import java.util.ArrayList;

public class EntityOctohugger extends EntityParasitoid implements IMob, Parasitoid
{
    private static final DataParameter<BlockPos> HANGING_POSITION = EntityDataManager.createKey(EntityOctohugger.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Boolean>  HANGING          = EntityDataManager.createKey(EntityOctohugger.class, DataSerializers.BOOLEAN);

    private BlockPos                             hangingLocation  = null;

    public EntityOctohugger(World world)
    {
        super(world);
        this.setSize(0.3F, 0.8F);
        this.experienceValue = 10;
        this.ignoreFrustumCheck = true;
        this.jumpMovementFactor = 0.3F;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(HANGING_POSITION, new BlockPos(0, 0, 0));
        this.getDataManager().register(HANGING, false);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.50D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(4.0D);
    }

    public boolean isHanging()
    {
        return this.getDataManager().get(HANGING);
    }

    public void setHanging(boolean value)
    {
        this.getDataManager().set(HANGING, value);
    }

    public BlockPos getHangingLocation()
    {
        return this.hangingLocation = this.getDataManager().get(HANGING_POSITION);
    }

    public void updateHangingLocation(BlockPos location)
    {
        if (location != null)
        {
            this.getDataManager().set(HANGING_POSITION, location);
        }

        this.hangingLocation = location;
    }

    public boolean isHangingLocationStale()
    {
        return (this.getHangingLocation() == null || this.getHangingLocation().getX() == 0 && this.getHangingLocation().getY() == 0 && this.getHangingLocation().getZ() == 0);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.fallDistance = 0;

        if (!this.world.isRemote && this.world.getTotalWorldTime() % 60 == 0 && isHangingLocationStale())
        {
            ArrayList<BlockPos> locations = Blocks.getPositionsInRange((int) this.posX, (int) this.posY, (int) this.posZ, 8);

            for (int x = 0; x < locations.size(); x++)
            {
                BlockPos pos = locations.get(this.rand.nextInt(locations.size()));
                IBlockState state = this.world.getBlockState(pos);

                if (state.getBlock() != net.minecraft.init.Blocks.AIR)
                {
                    ArrayList<IBlockState> check = new ArrayList<>();
                    BlockPos locBelow = pos.add(0, -1, 0);

                    check.add(this.world.getBlockState(locBelow));
                    check.add(this.world.getBlockState(locBelow.add(-1, 0, 0)));
                    check.add(this.world.getBlockState(locBelow.add(0, 0, -1)));
                    check.add(this.world.getBlockState(locBelow.add(+1, 0, 0)));
                    check.add(this.world.getBlockState(locBelow.add(0, 0, +1)));

                    boolean validPosition = true;

                    for (IBlockState blockstate : check)
                    {
                        if (blockstate.getBlock() != net.minecraft.init.Blocks.AIR)
                        {
                            validPosition = false;
                            break;
                        }
                    }

                    RayTraceResult trace = this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + this.getEyeHeight(), this.posZ), new Vec3d(pos.getX(), pos.getY(), pos.getZ()), false, true, false);
                    boolean canSeeLocation = trace == null;

                    if (validPosition && canSeeLocation)
                    {
                        this.updateHangingLocation(pos.add(0.5D + (this.rand.nextDouble() / 2) - (this.rand.nextDouble() / 2), 0, 0.5D + (this.rand.nextDouble() / 2) - (this.rand.nextDouble() / 2)));
                        break;
                    }
                }
            }
        }

        double maxStringStrength = 0.085D;
        double stringStrength = maxStringStrength;

        if (this.getEntityBoundingBox() != null)
        {
            ArrayList<EntityLivingBase> entities = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(1, -8, 1));

            entities.removeIf(entity -> !EntitySelectorParasitoid.instance.test(entity) || entity instanceof EntityParasitoid);

            Entity target = !entities.isEmpty() ? entities.get(world.rand.nextInt(entities.size())) : null;

            if (target != null && this.getDistanceSq(target) > 0)
            {
                stringStrength = 0.0F;
            }
        }

        if (!this.isHangingLocationStale())
        {
            double hangingX = this.getHangingLocation().getX();
            double hangingY = this.getHangingLocation().getY();
            double hangingZ = this.getHangingLocation().getZ();
            this.motionX += (hangingX - this.posX) * stringStrength * 1.4;
            this.motionY += (hangingY - this.posY) * (stringStrength * 0.85);
            this.motionZ += (hangingZ - this.posZ) * stringStrength * 1.4;

            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

            double distance = this.getDistance(hangingX, hangingY, hangingZ);

            if (distance <= 1.1D)
            {
                this.setHanging(true);
            }

            this.motionX = 0;
            this.motionY = 0;
            this.motionZ = 0;
        }

        if (this.getRidingEntity() != null || !this.isFertile() || this.isHanging() && this.getHangingLocation() != null && this.world.getBlockState(this.getHangingLocation()).getBlock() == net.minecraft.init.Blocks.AIR)
        {
            this.setHanging(false);
            this.updateHangingLocation(new BlockPos(0, 0, 0));
        }

        if (this.isHanging())
        {
            this.motionX = 0;
            this.motionY = 0;
            this.motionZ = 0;
        }
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean getCanSpawnHere()
    {
        BlockPos pos = this.getPosition().add(0, -(this.getPosition().getY() - this.getEntityBoundingBox().minY), 0);
        return super.getCanSpawnHere() && isValidLightLevel() && !this.world.canBlockSeeSky(pos);
    }

    @Override
    protected boolean isValidLightLevel()
    {
        BlockPos pos = this.getPosition().add(0, -(this.getPosition().getY() - this.getEntityBoundingBox().minY), 0);

        if (this.world.getLightFor(EnumSkyBlock.SKY, pos) > this.rand.nextInt(32))
        {
            return false;
        }

        return this.world.getLight(pos) <= this.rand.nextInt(8);
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.FACEHUGGER_DEATH.event();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.setHanging(nbt.getInteger("IsHanging") == 1);
        this.updateHangingLocation(new BlockPos(nbt.getDouble("HangingX"), nbt.getDouble("HangingY"), nbt.getDouble("HangingZ")));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("IsHanging", this.isHanging() ? 1 : 0);

        if (!this.isHangingLocationStale())
        {
            nbt.setDouble("HangingX", this.getHangingLocation().getX());
            nbt.setDouble("HangingY", this.getHangingLocation().getY());
            nbt.setDouble("HangingZ", this.getHangingLocation().getZ());
        }
        return nbt;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_OCTOHUGGER);
    }
    
    @Override
    public SoundEvent getImplantSound()
    {
        return AlienSounds.FACEHUGGER_IMPLANT.event();
    }
}
