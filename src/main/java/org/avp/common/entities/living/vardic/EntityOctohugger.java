package org.avp.common.entities.living.vardic;

import java.util.ArrayList;

import org.avp.common.ItemHandler;
import org.avp.common.api.parasitoidic.IParasitoid;
import org.avp.client.Sounds;
import org.avp.common.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entities.ai.alien.EntitySelectorParasitoid;
import org.avp.common.entities.ai.PatchedEntityAIWander;
import org.avp.common.entities.living.species.EntityParasitoid;
import org.avp.common.world.Embryo;
import org.avp.common.world.capabilities.IOrganism.Organism;
import org.avp.common.world.capabilities.IOrganism.Provider;

import com.asx.mdx.lib.world.block.Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
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

public class EntityOctohugger extends EntityParasitoid implements IMob, IParasitoid
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
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAICustomAttackOnCollide(this, 0.55D, true));
        this.tasks.addTask(2, new PatchedEntityAIWander(this, 0.55D));
        this.targetTasks.addTask(0, new EntityAILeapAtTarget(this, 0.8F));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, false, false, this.getImpregnationEntitySelector()));
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
                    ArrayList<IBlockState> check = new ArrayList<IBlockState>();
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

                    RayTraceResult trace = this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ), new Vec3d(pos.getX(), pos.getY(), pos.getZ()), false, true, false);
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

            if (entities != null)
            {
                for (EntityLivingBase entity : new ArrayList<EntityLivingBase>(entities))
                {
                    if (!EntitySelectorParasitoid.instance.apply(entity) || entity instanceof EntityParasitoid)
                    {
                        entities.remove(entity);
                    }
                }

                Entity target = entities.size() >= 1 ? (Entity) entities.get(world.rand.nextInt(entities.size())) : null;

                if (target != null)
                {
                    if (this.getDistanceSq(target) > 0)
                    {
                        stringStrength = 0.0F;
                    }
                }
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
    public boolean canMoveToJelly()
    {
        return super.canMoveToJelly() && this.isFertile();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.FACEHUGGER_DEATH.event();
    }

    @Override
    public void implantEmbryo(EntityLivingBase living)
    {
        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);
        organism.impregnate(Embryo.BELUGA);
        organism.syncWithClients(living);
        this.setFertility(false);
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
        return new ItemStack(ItemHandler.summonerOctohugger);
    }
    
    @Override
    public SoundEvent getImplantSound()
    {
        return Sounds.FACEHUGGER_IMPLANT.event();
    }
}
