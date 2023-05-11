package org.prometheus.common.entity.living.vardic;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.living.EntityParasitoid;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.entity.ai.brain.parasitoid.OctohuggerBrain;

public class EntityOctohugger extends EntityParasitoid implements Parasitoid {
    private static final DataParameter<BlockPos> HANGING_POSITION = EntityDataManager.createKey(EntityOctohugger.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Boolean> HANGING = EntityDataManager.createKey(EntityOctohugger.class, DataSerializers.BOOLEAN);

    public EntityOctohugger(World world) {
        super(world);
        this.setSize(0.3F, 0.8F);
        this.experienceValue = 10;
        this.ignoreFrustumCheck = true;
        this.jumpMovementFactor = 0.3F;
    }

    @Override
    public OctohuggerBrain getBrain() {
        return (OctohuggerBrain) super.getBrain();
    }

    @Override
    public OctohuggerBrain createNewBrain() {
        return new OctohuggerBrain(this);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(HANGING_POSITION, BlockPos.ORIGIN);
        this.getDataManager().register(HANGING, false);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.50D);
    }

    public boolean isHanging() {
        return this.getDataManager().get(HANGING);
    }

    public void setHanging(boolean value) {
        this.getDataManager().set(HANGING, value);
    }

    public BlockPos getHangingLocation() {
        return this.getDataManager().get(HANGING_POSITION);
    }

    public void updateHangingLocation(BlockPos location) {
        if (location != null) {
            this.getDataManager().set(HANGING_POSITION, location);
        }
    }

    public boolean isHangingLocationStale() {
        return (this.getHangingLocation() == null || this.getHangingLocation().getX() == 0 && this.getHangingLocation().getY() == 0 && this.getHangingLocation().getZ() == 0);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.fallDistance = 0;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos pos = this.getPosition().add(0, -(this.getPosition().getY() - this.getEntityBoundingBox().minY), 0);
        return super.getCanSpawnHere() && !this.world.canBlockSeeSky(pos);
    }

    @Override
    protected boolean isValidLightLevel() {
        BlockPos pos = this.getPosition().add(0, -(this.getPosition().getY() - this.getEntityBoundingBox().minY), 0);

        if (this.world.getLightFor(EnumSkyBlock.SKY, pos) > this.rand.nextInt(32)) {
            return false;
        }

        return this.world.getLight(pos) <= this.rand.nextInt(8);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AlienSounds.FACEHUGGER_DEATH.event();
    }

    private static final String IS_HANGING_NBT_KEY = "IsHanging";
    private static final String HANGING_X_NBT_KEY = "HangingX";
    private static final String HANGING_Y_NBT_KEY = "HangingY";
    private static final String HANGING_Z_NBT_KEY = "HangingZ";

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.setHanging(nbt.getInteger(IS_HANGING_NBT_KEY) == 1);

        double x = nbt.getDouble(HANGING_X_NBT_KEY);
        double y = nbt.getDouble(HANGING_Y_NBT_KEY);
        double z = nbt.getDouble(HANGING_Z_NBT_KEY);
        BlockPos pos = new BlockPos(x, y, z);
        this.updateHangingLocation(pos);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger(IS_HANGING_NBT_KEY, this.isHanging() ? 1 : 0);

        if (!this.isHangingLocationStale()) {
            nbt.setDouble(HANGING_X_NBT_KEY, this.getHangingLocation().getX());
            nbt.setDouble(HANGING_Y_NBT_KEY, this.getHangingLocation().getY());
            nbt.setDouble(HANGING_Z_NBT_KEY, this.getHangingLocation().getZ());
        }
        return nbt;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(PrometheusItems.SUMMONER_OCTOHUGGER);
    }

    @Override
    public SoundEvent getImplantSound() {
        return AlienSounds.FACEHUGGER_IMPLANT.event();
    }
}
