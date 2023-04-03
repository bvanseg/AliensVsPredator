package org.predator.common.entity;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.entity.fx.EntityFXElectricArc;
import com.asx.mdx.common.minecraft.LargeExplosion;
import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.common.config.ModelConfig;
import org.predator.client.PredatorSounds;

import java.util.ArrayList;
import java.util.List;

public class EntityWristbracer extends EntityThrowable
{
    private static final DataParameter<Integer> TICKING_TIME_IN_TICKS = EntityDataManager.createKey(EntityWristbracer.class, DataSerializers.VARINT);

    private static final ArrayList<Block> EXCLUDED_BLOCKS = new ArrayList<>();
    private static final ArrayList<Material> EXCLUDED_MATERIALS = new ArrayList<>();

    private static final int ELECTRIC_ARC_START_TIME_IN_TICKS = 20 * 15; // 15 seconds.
    private static final int ELECTRIC_ARC_INTENSE_START_TIME_IN_TICKS = ELECTRIC_ARC_START_TIME_IN_TICKS + 20 * 30; // 30 seconds.
    public static final int DETONATION_START_TIME_IN_TICKS = ELECTRIC_ARC_INTENSE_START_TIME_IN_TICKS + 20; // 46 seconds.

    static {
        EXCLUDED_BLOCKS.add(Blocks.BEDROCK);
        EXCLUDED_MATERIALS.add(Material.ROCK);
    }

    public EntityWristbracer(World world)
    {
        super(world);
        this.setSize(0.25F, 0.25F);
        this.ignoreFrustumCheck = true;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(TICKING_TIME_IN_TICKS, 0);
    }

    @Override
    public void onUpdate()
    {
        this.updatePositionAndMotion();

        // Countdown sound fx.
        if (this.world.getTotalWorldTime() % 20 == 0 && this.getTickingTimeInTicks() < DETONATION_START_TIME_IN_TICKS)
        {
            PredatorSounds.FX_WRISTBRACER_ALARM.playSound(this, 15F, 1F);
        }

        float explosionWidthMax = 80F;
        float explosionHeightMax = explosionWidthMax / 2;

        if (this.getTickingTimeInTicks() >= ELECTRIC_ARC_START_TIME_IN_TICKS)
        {
            this.zapNearbyBlock(explosionWidthMax);
        }

        // Explode 2 seconds after detonation start.
        if (this.getTickingTimeInTicks() >= DETONATION_START_TIME_IN_TICKS + (20 * 2))
        {
            this.explode(explosionWidthMax, explosionHeightMax);
        }

        // Create explosion sounds while detonating.
        if (this.getTickingTimeInTicks() > DETONATION_START_TIME_IN_TICKS && this.ticksExisted % 2 == 0) {
            this.world.playSound(null, this.getPosition(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 15F, 0.3F);
        }

        this.setTickingTimeInTicks(this.getTickingTimeInTicks() + 1);
    }

    private void updatePositionAndMotion() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        // Update gravity and motion
        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }
    }

    private void zapNearbyBlock(float explosionWidthMax) {
        float explosionWidth = (this.getPostIntenseElectricArcTicks() * explosionWidthMax / ELECTRIC_ARC_INTENSE_START_TIME_IN_TICKS);

        double pX = this.posX + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double pY = this.posY + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double pZ = this.posZ + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);

        if (this.world.isRemote)
        {
            this.spawnElectricArc(explosionWidthMax);
        }

        if (!this.world.isRemote)
        {
            // Destroy random blocks around the wristbracer.
            BlockPos pos = new BlockPos((int) Math.round(pX), (int) Math.round(pY), (int) Math.round(pZ));
            IBlockState blockState = this.world.getBlockState(pos);
            Block block = blockState.getBlock();
            Material material = blockState.getMaterial();
            // If the block is not excluded and its material is not excluded, destroy the block.
            if (!EXCLUDED_BLOCKS.contains(block) && !EXCLUDED_MATERIALS.contains(material)) {
                this.world.setBlockToAir(pos);
            }
        }
    }

    private void explode(float explosionWidthMax, float explosionHeightMax) {
        if (ModelConfig.instance.getGeneral().explosionsEnabled)
        {
            LargeExplosion explosion = new LargeExplosion(world, explosionWidthMax, explosionHeightMax, explosionWidthMax, (int) this.posX, (int) this.posY, (int) this.posZ, 1_000F, this.world.rand.nextLong(), EXCLUDED_BLOCKS, EXCLUDED_MATERIALS, 0, 2);
            explosion.start();

            List<Entity> entities = Entities.getEntitiesInCoordsRange(world, Entity.class, new Pos(this.getPosition()), (int) explosionWidthMax, (int) explosionHeightMax);

            entities.stream().filter(EntityLivingBase.class::isInstance).forEach(
                living -> living.attackEntityFrom(DamageSource.causeExplosionDamage((EntityLivingBase) living), 1_000_000)
            );
        }

        this.setDead();
    }

    @SideOnly(Side.CLIENT)
    private void spawnElectricArc(float explosionWidthMax)
    {
        float explosionWidth = explosionWidthMax * this.getPostIntenseElectricArcTicks() / ELECTRIC_ARC_INTENSE_START_TIME_IN_TICKS;
        float iS = 1F;
        double sX = this.posX + (this.rand.nextDouble() * iS) - (this.rand.nextDouble() * iS);
        double sY = this.posY + (this.rand.nextDouble() * iS) - (this.rand.nextDouble() * iS);
        double sZ = this.posZ + (this.rand.nextDouble() * iS) - (this.rand.nextDouble() * iS);
        double pX = this.posX + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double pY = this.posY + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double pZ = this.posZ + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double arcFluctuation = 1 + (this.getPostIntenseElectricArcTicks() * 40.0 / ELECTRIC_ARC_INTENSE_START_TIME_IN_TICKS);
        double arcComplexity = (1F / explosionWidth) * 2;
        float arcDensity = 0.7F * this.getPostIntenseElectricArcTicks() / ELECTRIC_ARC_INTENSE_START_TIME_IN_TICKS;

        ClientGame.instance.minecraft().effectRenderer.addEffect(new EntityFXElectricArc(this.world, sX, sY, sZ, pX, pY, pZ, 1, arcFluctuation, arcComplexity, arcDensity, 0xAA00CCFF));
    }

    public int getPostIntenseElectricArcTicks()
    {
        return MathHelper.clamp((this.getTickingTimeInTicks() - ELECTRIC_ARC_START_TIME_IN_TICKS), 0, Integer.MAX_VALUE);
    }

    public int getPostDetonateTicks()
    {
        return MathHelper.clamp((this.getTickingTimeInTicks() - DETONATION_START_TIME_IN_TICKS), 0, Integer.MAX_VALUE);
    }

    @Override
    protected void onImpact(RayTraceResult RayTraceResult) { /* Do Nothing */ }

    private static final String TICKS_EXISTED_NBT_KEY = "TickingTime";

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.setTickingTimeInTicks(compound.getInteger(TICKS_EXISTED_NBT_KEY));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger(TICKS_EXISTED_NBT_KEY, this.getTickingTimeInTicks());
        return super.writeToNBT(compound);
    }

    public int getTickingTimeInTicks() {
        return this.dataManager.get(TICKING_TIME_IN_TICKS);
    }

    public void setTickingTimeInTicks(int tickingTimeInSeconds) {
        this.dataManager.set(TICKING_TIME_IN_TICKS, tickingTimeInSeconds);
    }
}
